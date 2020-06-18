package com.codegym.task.task31.task3106;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/*
Unzipping a file

*/
public class Solution {
    public static void main(String[] args) {

        try {

            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(args[0]));

            List<String> fileNames = new ArrayList<>();
            for (int i = 1; i < args.length; i++) {
                fileNames.add(args[i]);
            }
            Collections.sort(fileNames);
            int size = 1024;

            List<FileInputStream> files = new ArrayList<>();
            for (String file : fileNames) {
                files.add(new FileInputStream(file));
            }

            ZipInputStream zipInputStream = new ZipInputStream(new SequenceInputStream(Collections.enumeration(files)));
            ZipEntry zipEntry;

            while ((zipEntry = zipInputStream.getNextEntry()) != null) {

                byte[] data = new byte[1024];
                while ((size = zipInputStream.read(data, 0, data.length)) >= 0) {
                    bufferedOutputStream.write(data, 0, size);
                }
                bufferedOutputStream.flush();
            }

            bufferedOutputStream.flush();
            bufferedOutputStream.close();
            zipInputStream.close();

        } catch (Exception e) {

        }
    }
}
