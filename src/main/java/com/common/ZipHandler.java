package com.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipHandler {
    public static void zipDirectory(String sourceFolderName, String base, ZipOutputStream zos) throws IOException {
        File folder = new File(sourceFolderName);
        if (folder.isDirectory()) {
            for (String fileName : folder.list()) {
                if (base.equals("")) {
                    zipDirectory(folder.getName() + File.separator + fileName, base + folder.getName() + File.separator, zos);
                } else {
                    zipDirectory(folder.getName() + File.separator + fileName, base + File.separator, zos);
                }
            }
        } else {
            zipFile(folder, base, zos);
        }
    }

    public static void zipFile(File file, String base, ZipOutputStream zos) throws IOException {
        FileInputStream fis = new FileInputStream(file);
        String entryName = base + file.getName();
        ZipEntry zipEntry = new ZipEntry(entryName);
        zos.putNextEntry(zipEntry);

        byte[] buffer = new byte[1024];
        int bytesRead;

        // 파일을 읽어 ZipOutputStream에 쓴다.
        while ((bytesRead = fis.read(buffer)) != -1) {
            zos.write(buffer, 0, bytesRead);
        }

        // 파일과 ZipEntry를 닫는다.
        zos.closeEntry();
        fis.close();
    }

    public static void deleteDirectory(File directory) {
        if(directory.exists()) {
            File[] files = directory.listFiles();
            if(files != null) {
                for(File f : files) {
                    if(f.isDirectory()) {
                        deleteDirectory(f);
                    } else {
                        f.delete();
                    }
                }
            }
        }
    }
}
