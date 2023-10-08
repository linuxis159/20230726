package com.spring.controller;

import com.common.ZipHandler;
import com.spring.dto.PopTemplate;
import com.spring.template.JSFileTemplateIF;
import com.spring.template.PopJSFileType;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipOutputStream;

@Controller
public class PopTemplateController {
    @PostMapping("/createPopTemplate")
    public ResponseEntity<Resource> createPopTemplate(@RequestBody PopTemplate popTemplate) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, IOException {
        ZipHandler.deleteDirectory(new File("jsTemplate"));
        ZipHandler.deleteDirectory(new File("jsTemplateZip"));
        List<JSFileTemplateIF> popJSFileTemplates = new ArrayList();
        for (PopJSFileType popJSFileType : PopJSFileType.values()) {
            Class<?> clazz = Class.forName("com.spring.template.pop.templateImpl." + popJSFileType.getImpletationClassName());
            Constructor<?> ctor = clazz.getConstructor(PopTemplate.class, PopJSFileType.class);
            JSFileTemplateIF fileTemplate = (JSFileTemplateIF) ctor.newInstance(popTemplate, popJSFileType);
            popJSFileTemplates.add(fileTemplate);

        }
        for(JSFileTemplateIF popJSFileTemplate : popJSFileTemplates){
            File newJSFile = new File("jsTemplate" + File.separator + popJSFileTemplate.getFileName() + ".js");
            if(!newJSFile.exists()) {

                newJSFile.createNewFile();
            }
            FileWriter fw;
            fw = new FileWriter(newJSFile);
            BufferedWriter writer = new BufferedWriter(fw);
            writer.write(popJSFileTemplate.getTemplate());
            writer.close();
        }

        String sourceFolderName = "jsTemplate";
        String zipFileName = "jsTemplateZip"+File.separator+"menuTemplate.zip";
        FileOutputStream fos = new FileOutputStream(zipFileName);
        ZipOutputStream zos = new ZipOutputStream(fos);
        ZipHandler.zipDirectory(sourceFolderName, sourceFolderName, zos);



        File file = new File(zipFileName);
        Resource resource = new FileSystemResource(file);

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=" + zipFileName)
                .body(resource);
    }
}
