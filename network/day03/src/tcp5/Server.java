package tcp5;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URL;
import java.util.ArrayList;

public class Server {

   ServerSocket serverSocket;
   ArrayList<DataOutputStream> list = new ArrayList<>();

   private int port = 9999;
   private boolean flag = true;

   public Server() throws IOException {
      serverSocket = new ServerSocket(port);
      System.out.println("Server Ready . . .");
   }

   /*
    * while () client accept
    * 
    */
   public void start() throws IOException {
      while (flag) {
         Socket socket = serverSocket.accept();
         System.out.println(serverSocket.getInetAddress() + " : " + socket.getInetAddress() + "Connected");
         new Receiver(socket).start();
      }
   }

   class Receiver extends Thread {
      InputStream in;
      DataInputStream din;

      OutputStream out;
      DataOutputStream dout;

      public Receiver(Socket socket) throws IOException {
         in = socket.getInputStream();
         din = new DataInputStream(in);
         
         out = socket.getOutputStream();
         dout = new DataOutputStream(out);
         list.add(dout);
         System.out.println("Client count : " + list.size());
      }

      @Override
      public void run() {

         while (din != null) {
            String str = "";
            try {
               str = din.readUTF();
               //throw new IOException();
            } catch (IOException e) {
               break;
            }
            if (str.equals("q") && str != null) {
               break;
            }
            
            int partition = str.indexOf(',');
            String speed = str.substring(0, partition).trim();
            String temp = str.substring(partition+1, str.length()).trim();
            
            // Send SpringServer
            System.out.println(str);
            SendHttp http = new SendHttp(speed, temp);
            http.start();

         }
         list.remove(dout);
         try {
            if (dout != null) {
               dout.close();
            }
            if (din != null) {
               din.close();
            }
         } catch (IOException e) {
            e.printStackTrace();
         }
      }
   }
   
   class SendHttp extends Thread{
	   String temp, speed;
	   String url;
	   String urls = "http://127.0.0.1/ws/main.do";
	   public SendHttp() {
	   }
	   
	   public SendHttp(String speed, String temp) {
		   this.speed = speed;
		   this.temp = temp;
	   }
	   
	   
	   @Override
	   public void run() {
		   urls += "?speed=" + speed+ "&" +"temp=" + temp;
		   try {
			   URL url = new URL(urls);
			   HttpURLConnection con= (HttpURLConnection) url.openConnection();
			   con.setRequestMethod("POST");
			   con.setConnectTimeout(5000);
			   con.getInputStream();
		   }catch(Exception e) {
			   System.out.println("Http Error");
		   }
	   }
	   
   }
   

   public static void main(String args[]) {
      Server server = null;
      try {
         server = new Server();
         server.start();
      } catch (IOException e) {
         e.printStackTrace();
      }
   }

}