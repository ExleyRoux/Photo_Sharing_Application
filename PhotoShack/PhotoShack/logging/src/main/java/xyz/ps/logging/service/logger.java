package xyz.ps.logging.service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class logger {
    private boolean overwrite = false;

    public logger(String message) throws IOException {
        File i = getLoggingFile();
        FileWriter writer = new FileWriter(i);
        writer.append(message);
        writer.close();
    }


    private File getLoggingFile() throws IOException {
        int count = 0;
        String filename = "logger";
        String extension = ".txt";

        File myFile = new File(filename+extension);
        if (myFile.exists() && overwrite){
            myFile.createNewFile();
            return myFile;
        }
        else if (myFile.exists() && !overwrite){
            while (!createLoggingFile(filename+"("+count+")"+extension)){
                count++;
                if (count > 4){
                    overwrite = true;
                    count = 0;
                }
            }
        }
        else {
            throw new IOException();
        }
        return null;
    }

    private boolean createLoggingFile(String filename) throws IOException {
        File myFile = new File(filename);
        return myFile.createNewFile();
    }
}
