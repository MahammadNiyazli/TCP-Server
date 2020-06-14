/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FileUtility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.tools.FileObject;

/**
 *
 * @author User
 */
public class FileUtility {
    public static byte[] readWithBytes(String fileName) throws FileNotFoundException, IOException{
        File file = new File(fileName);
        FileInputStream fip = new FileInputStream(file);
        int length = (int) file.length();
        byte[] arr = new byte[length];
        fip.read(arr);
        return arr ;
    }
    
    public static void writeWidthBytes(String fileName,byte[] arr) throws FileNotFoundException, IOException{
        File file  = new File(fileName);
        FileOutputStream fop = new FileOutputStream(file);
        fop.write(arr);
    }
}
