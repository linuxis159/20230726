package com.spring.controller;

import com.spring.dto.MenuTemplate;
import com.spring.template.*;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

@RestController
public class MenuTemplateController {
    @PostMapping("/createMenuTemplate")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<Resource> createMenuTemplate(@RequestBody MenuTemplate menuTemplate) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, IOException {
        deleteDirectory(new File("jsTemplate"));
        deleteDirectory(new File("jsTemplateZip"));
        List<MenuJSFileTemplateIF> menuJSFileTemplates = new ArrayList();
        for(MenuJSFileType menuJSFileType : MenuJSFileType.values()){
            Class<?> clazz = Class.forName("com.spring.template."+menuJSFileType.getImpletationClassName());
            Constructor<?> ctor = clazz.getConstructor(MenuTemplate.class, MenuJSFileType.class);
            MenuJSFileTemplateIF fileTemplate = (MenuJSFileTemplateIF) ctor.newInstance(menuTemplate, menuJSFileType);
            menuJSFileTemplates.add(fileTemplate);

        }


        for(MenuJSFileTemplateIF menuJSFileTemplate : menuJSFileTemplates){
            File newJSFile = new File("jsTemplate" + File.separator + menuJSFileTemplate.getFileName() + ".js");
            if(!newJSFile.exists()) {

                newJSFile.createNewFile();
            }
            FileWriter fw;
            fw = new FileWriter(newJSFile);
            BufferedWriter writer = new BufferedWriter(fw);
            writer.write(menuJSFileTemplate.getTemplate());
            writer.close();
        }

        String sourceFolderName = "jsTemplate";
        String zipFileName = "jsTemplateZip"+File.separator+"menuTemplate.zip";
        FileOutputStream fos = new FileOutputStream(zipFileName);
        ZipOutputStream zos = new ZipOutputStream(fos);
        zipDirectory(sourceFolderName, sourceFolderName, zos);



        File file = new File(zipFileName);
        Resource resource = new FileSystemResource(file);

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=" + zipFileName)
                .body(resource);


    }

    private void zipDirectory(String sourceFolderName, String base, ZipOutputStream zos) throws IOException {
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

    private void zipFile(File file, String base, ZipOutputStream zos) throws IOException {
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

    public void deleteDirectory(File directory) {
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
