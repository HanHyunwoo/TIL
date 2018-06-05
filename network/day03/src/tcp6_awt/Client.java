package tcp6_awt;

import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {

   boolean flag = true;
   String address = "70.12.114.143";
   Socket socket;
   Scanner scanner;

   Frame f;
   Button b1, b2, b3, b4, b5, b6;
   
   Panel p;
   TextField tf1, tf2, tf3;
   

   public Client() {
      makeUI();
      while (true) {
         try {
            socket = new Socket(address, 8888);
            break;
         } catch (UnknownHostException e) {
            System.out.println("Retry . . .");
         } catch (IOException e) {
            System.out.println("Retry . . .");
         }
         try {
            Thread.sleep(2000);
         } catch (InterruptedException e1) {
            e1.printStackTrace();
         }
      }

      System.out.println("Connected Server ..");
   }

   public void makeUI() {
      b1 = new Button("20 C");
      b2 = new Button("100 KM");
      b3 = new Button("1500 rpm");
      b4 = new Button("Open Window");
      b5 = new Button("30 L");
      b1.setFont(new Font("serif", Font.BOLD, 30));
      b1.setBackground(Color.DARK_GRAY);
      b1.setForeground(Color.WHITE);

      f = new Frame();
      f.setLayout(new GridLayout(2, 3));
      
      f.add(b1);
      f.add(b2);
      f.add(b3);
      f.add(b4);
      f.add(b5);
  
      
      p = new Panel();
      p.setLayout(new GridLayout(3,1));  //3행 1열
      tf1 = new TextField("Start Car");
      tf2 = new TextField("Speed is 100");
      tf3 = new TextField("Open Window");
      p.add(tf1);
      p.add(tf2);
      p.add(tf3);  
      
      f.add(p);

      
      f.setLocation(0, 0);
      f.setSize(1024, 600);
      f.setVisible(true);
    //window업데이트가 발생되면 WindowAdapter가 받아서 처리하겠다. 
      f.addWindowListener(new WindowAdapter() {

         @Override
         public void windowClosing(WindowEvent e) {
            // memory에서 frame정보를 없앤다
            f.dispose();
            // 종료
            System.exit(0);
         }

      });

   }

   public void startClient() throws Exception {

      new Receiver(socket).start();
      Sender sender = new Sender(socket);
      scanner = new Scanner(System.in);
      while (flag != false) {

         System.out.println("클라이언트 입력 하세요:");

         String str = scanner.nextLine();
         if (str.trim().equals("q")) {
            Thread t = new Thread(sender);
            sender.setSendMsg("q");
            t.start();
            flag = false;
            scanner.close();
            break;
         }
         Thread t = new Thread(sender);
         sender.setSendMsg(str);
         t.start();
      }
      Thread.sleep(1000);
      socket.close();

      // System.exit(0);

   }

   class Sender implements Runnable {
      Socket socket;
      OutputStream out;
      DataOutputStream outw;
      String sendMsg;

      public Sender(Socket socket) throws IOException {
         this.socket = socket;
         out = socket.getOutputStream();
         outw = new DataOutputStream(out);
      }

      public void setSendMsg(String sendMsg) {
         this.sendMsg = sendMsg;
      }

      @Override
      public void run() {
         try {
            if (outw != null) {
               outw.writeUTF(sendMsg);
            }

         } catch (IOException e) {
            e.printStackTrace();
         }
      }
   }

   class Receiver extends Thread {
      Socket socket;
      InputStream in;
      DataInputStream inr;

      public Receiver(Socket socket) throws IOException {
         this.socket = socket;
         in = socket.getInputStream();
         inr = new DataInputStream(in);
      }

      @Override
      public void run() {
         while (inr != null) {
            try {
               String str = inr.readUTF();
               b1.setLabel(str);
               System.out.println(str);
               if (str.trim().equals("q")) {
                  inr.close();
                  break;
               }
            } catch (Exception e) {
               System.out.println("Server Closed");
               break;
            }
         }

         try {
            Thread.sleep(1000);
            flag = false;
            socket.close();
            System.exit(0);
         } catch (Exception e) {
            e.printStackTrace();
         }

      }
   }

   public static void main(String args[]) {

      try {
         new Client().startClient();
      } catch (Exception e) {
         e.printStackTrace();
      }

   }

}