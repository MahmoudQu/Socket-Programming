package socket.programming;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try {
            Scanner in=new Scanner(System.in);

            Socket socket=new Socket("localhost",2024);
            DataInputStream dataInputStream=new DataInputStream(socket.getInputStream());
            DataOutputStream dataOutputStream=new DataOutputStream(socket.getOutputStream());

            System.out.println(dataInputStream.readUTF());
            System.out.println("Enter you message:");
            String msg=in.nextLine();
            dataOutputStream.writeUTF(msg);
            System.out.println("A message of data contains : "+msg +" is sent to the server");
            System.out.println(dataInputStream.readUTF());
            // mahmoud mahmoud
            dataInputStream.close();
            dataOutputStream.close();
            socket.close();
            System.out.println("Client closed");

        } catch (IOException e) {
            e.getStackTrace();
        }

    }
}
