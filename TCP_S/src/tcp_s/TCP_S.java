/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tcp_s;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author User
 */
public class TCP_S {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(5678);
        
        while(true){
            Socket socket = server.accept();
            DataInputStream dis = new DataInputStream(socket.getInputStream());
            byte[] arr = getInformation(dis);
            FileUtility.FileUtility.writeWidthBytes("C:\\Users\\User\\Desktop\\oz.jpg", arr);
            System.out.println("Gelen melumat desktopa gonderildi !");
        }
    }
    
    public static byte[] getInformation(DataInputStream dis) throws IOException{
        int length = dis.readInt();
        byte[] arr = new byte[length];
        dis.read(arr);
        return arr;
        
    }
    
}
