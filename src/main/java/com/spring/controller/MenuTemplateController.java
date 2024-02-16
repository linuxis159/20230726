package com.spring.controller;

import com.common.ZipHandler;
import com.spring.dto.MenuTemplate;
import com.spring.template.JSFileTemplateIF;
import com.spring.template.MenuJSFileType;
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
import java.util.zip.ZipOutputStream;

@RestController
public class MenuTemplateController {
    @PostMapping("/createMenuTemplate")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<Resource> createMenuTemplate(@RequestBody MenuTemplate menuTemplate) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, IOException {
        ZipHandler.deleteDirectory(new File("jsTemplate"));
        ZipHandler.deleteDirectory(new File("jsTemplateZip"));
        List<JSFileTemplateIF> menuJSFileTemplates = new ArrayList();

        for(MenuJSFileType menuJSFileType : MenuJSFileType.values()){
            Class<?> clazz = Class.forName("com.spring.template.menu.templateImpl."+menuJSFileType.getImpletationClassName());
            Constructor<?> ctor = clazz.getConstructor(MenuTemplate.class, MenuJSFileType.class);
            JSFileTemplateIF fileTemplate = (JSFileTemplateIF) ctor.newInstance(menuTemplate, menuJSFileType);
            menuJSFileTemplates.add(fileTemplate);
        }


        for(JSFileTemplateIF menuJSFileTemplate : menuJSFileTemplates){
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
        try( FileOutputStream fos = new FileOutputStream(zipFileName);
            ZipOutputStream zos = new ZipOutputStream(fos)) {
            ZipHandler.zipDirectory(sourceFolderName, sourceFolderName, zos);
        } catch(Exception e){
            e.printStackTrace();
        }





        File file = new File(zipFileName);
        Resource resource = new FileSystemResource(file);

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=" + zipFileName)
                .body(resource);


    }






}
