package com.company;

import java.io.File;

public class FileUtils {
    public static boolean deleteFiles (File contetnsToDelete){
        File[] allContents = contetnsToDelete.listFiles();
        if (allContents != null) {
            for (File file : allContents) {
                deleteFiles(file);
            }
        }
        return contetnsToDelete.delete();
    }
}
