package tcp3;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
   String ip;
   int port;
   InputStream in;
   InputStreamReader inr;
   DataOutputStream dout;
   DataInputStream din;
   BufferedReader br;
   OutputStream out;
   OutputStreamWriter outw;
   PrintWriter pw;
   Boolean flag = true;
   
   Client() {
   }

   Client(String ip, int port) throws Exception {
      this.ip = ip;
      this.port = port;   
      Socket socket = null;
      socket = connect();
      if(socket != null)
         startClient(socket);

   }
   
   public void startClient(Socket socket) throws IOException {      
      System.out.println("Connected");
      
      out = socket.getOutputStream();
      in = socket.getInputStream();
      din = new DataInputStream(in);
      dout = new DataOutputStream(out);
      
      dout.writeUTF("안녕하시지요");      
      System.out.println(din.readUTF());
   }
   
   public Socket connect() {
      Socket socket = null;
      while (flag) {
         try {
            socket = new Socket(ip, port);
            if(socket != null && socket.isConnected()) {               
               return socket;
            }
         } catch (IOException e) {            
            System.out.println("Re-Try");
            try {
               Thread.sleep(2000);
            } catch (InterruptedException e1) {   }
         }
         
      }
      return socket;
   }

   public static void main(String[] args) {
      try {
         Client client = new Client("70.12.114.143", 7777);
      } catch (Exception e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }

   }

}