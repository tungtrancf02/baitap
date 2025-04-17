package iotream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopyExample {
    public static void main(String[] args) throws IOException {
        FileInputStream fin = null;
        FileOutputStream fout = null;
        fin = new FileInputStream("in_outstream.txt");
        fout = new FileOutputStream("filedich.txt");
        byte[] buffer = new byte[1024];
        int bytesRead;
        while ((bytesRead = fin.read(buffer)) > 0) {
            fout.write(buffer, 0, bytesRead);
        }
        fin.close();
        fout.close();
    }
}