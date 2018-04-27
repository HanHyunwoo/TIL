package tcp3;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
   ServerSocket serverSocket;
   int port;
   
   public Server() throws IOException {
      port = 7777;
      serverSocket = new ServerSocket(port);
   }

   public void startServer() throws IOException {
      while (true) {
         Socket socket = null;
         System.out.println("Server Ready...");
         socket = serverSocket.accept();
         ReceiveAndSend ras = new ReceiveAndSend(socket);
         ras.run();
         System.out.println("Server Finished...");
      }
   }

   class ReceiveAndSend implements Runnable {
      Socket socket;
      OutputStream out;      
      InputStream in;
      DataInputStream din;
      DataOutputStream dout;
      
      ReceiveAndSend() {
      }
      

      ReceiveAndSend(Socket socket) throws IOException {
         this.socket = socket;
         in = socket.getInputStream();         
         out = socket.getOutputStream();      
         din = new DataInputStream(in);
         dout = new DataOutputStream(out);
      }

      @Override
      public void run() {
         try {
            System.out.println("in run.....");
            System.out.println(socket.getInetAddress() + " " + din.readUTF());
            dout.writeUTF("±×·¡ ¾È³ç " + serverSocket.getInetAddress());
         } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
         }          
      }
      
   }

   public static void main(String[] args) {
      Server server = null;
      try {
         server = new Server();
         server.startServer();
      } catch (IOException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
   }

}