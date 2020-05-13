package com.codegym.task.task18.task1814;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/* 
UnsupportedFileName

*/

public class TxtInputStream extends FileInputStream {

    public TxtInputStream(String fileName) throws UnsupportedFileNameException, IOException {

        super(fileName);


        int length = fileName.length();
        String extension = fileName.substring(length - 4);
        if (!extension.equals(".txt")) {
            super.close();
            throw new UnsupportedFileNameException();
        }
    }

    public static void main(String[] args) {
    }
}

