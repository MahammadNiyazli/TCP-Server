
import FileUtility.FileUtility;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
public class Main {

   
    
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your name : "); String name = scanner.next();
        System.out.print("Enter your surname : "); String surname = scanner.next();
        
        System.out.println("Hormetli "+name+" "+surname+" zəhmət olmasa göndərmək istədiyiniz faylın yerləşdiyi keçidi qeyd edin : ");
        String fileName  = scanner.next();
        System.out.println("bu şəkli göndərmək istədiyiniz şəxsin(serverin) ip və portunu daxil edin:");
        String ipAndPort = scanner.next();
        String[] arr = ipAndPort.split(":");
        String ip = arr[0];
        int port = Integer.parseInt(arr[1]);
        
        Socket socket = new Socket(ip,port);
        DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
        byte[] arr2 = FileUtility.readWithBytes(fileName);
        dos.writeInt(arr2.length);
        dos.write(arr2);
        dos.close();
        System.out.println("Ugurla Gonderildi !");
    }
    
}
