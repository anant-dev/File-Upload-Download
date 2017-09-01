/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mindfire.download;

import com.mindfire.service.UploadDownload;
import com.mindfire.service.UploadDownload_Service;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 *
 * @author anants
 */
public class download {

    public static void main(String[] args) {
        UploadDownload_Service service = new UploadDownload_Service();
        UploadDownload port = service.getUploadDownloadPort();
        String fileName = "bg.jpg";
        String filePath = "E:/test/downloadto/" + fileName;
        File file = new File(filePath);
        byte[] fileBytes = port.download(fileName);

        try {
            FileOutputStream fos = new FileOutputStream(filePath);
            BufferedOutputStream outputStream = new BufferedOutputStream(fos);
            outputStream.write(fileBytes);
            outputStream.close();

            System.out.println("File downloaded: " + filePath);
        } catch (IOException ex) {
            System.err.println(ex);
        }

    }

}
