/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mindfire.upload;

import com.mindfire.service.UploadDownload;
import com.mindfire.service.UploadDownload_Service;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 *
 * @author anants
 */
public class Upload {

    public static void main(String[] args) {

        UploadDownload_Service service = new UploadDownload_Service();
        UploadDownload port = service.getUploadDownloadPort();
        String fileName = "bg.jpg";
        String filePath = "E:/test/uploadfrom/" + fileName;
        File file = new File(filePath);
         
        // uploads a file
        try {
            FileInputStream fis = new FileInputStream(file);
            BufferedInputStream inputStream = new BufferedInputStream(fis);
            byte[] imageBytes = new byte[(int) file.length()];
            inputStream.read(imageBytes);
             
            port.upload(file.getName(), imageBytes);
 
            inputStream.close();
            System.out.println("File uploaded: " + filePath);
        } catch (IOException ex) {
            System.err.println(ex);
        }      
    }

}
