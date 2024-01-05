package socket.programming;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket=new ServerSocket(2024);
            Socket socket=serverSocket.accept();
            System.out.println("Server started");

            DataInputStream dataInputStream=new DataInputStream(socket.getInputStream());
            DataOutputStream dataOutputStream=new DataOutputStream(socket.getOutputStream());

            dataOutputStream.writeUTF("Server is waiting, send your message");
            String msg=dataInputStream.readUTF();
            System.out.println("The server received a message from the client");
            msg=msg.toUpperCase();
            System.out.println("The message is now modified");
            dataOutputStream.writeUTF("Your modified message is "+msg);

            dataOutputStream.close();
            dataInputStream.close();
            socket.close();
            serverSocket.close();
            System.out.println("Server closed");

        } catch (IOException e) {
            e.getStackTrace();
        }
    }
}
