package com.gaoke.gen;

import com.gaoke.bean.ControllerBean;
import com.google.common.io.Resources;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ControllerGen {
    public static void main(String[] args) {
        try {
            new ControllerGen().gen();

        } catch (IOException | TemplateException e) {
            e.printStackTrace();
        }
    }

    public static void gen(ControllerBean cbean) throws IOException, TemplateException {
        Configuration cfg = new Configuration();

        URL url = Resources.getResource("codeTemplate");
        cfg.setDirectoryForTemplateLoading(new File(url.getPath()));
        cfg.setDefaultEncoding("UTF-8");
        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);

        Template temp = cfg.getTemplate("controller.ftl");

        // Create the root hash
        Map<String, Object> root = new HashMap<String, Object>();

        root.put("packageName", cbean.getPackageName());
        root.put("className", cbean.getClassName());
        root.put("requestMapping", cbean.getRootPath());

        root.put("methods", cbean.getMethods());


        File dir = new File("E:/workspace/RamlParser/src/main/java/com/gaoke/controller");
        if (!dir.exists()) {
            dir.mkdirs();
        }
        OutputStream fos = new FileOutputStream(new File(dir, cbean.getClassName()+".java")); //java文件的生成目录
        Writer out = new OutputStreamWriter(fos);
        temp.process(root, out);

        fos.flush();
        fos.close();

        System.out.println("com.gen code success!");
    }

    public void gen() throws IOException, TemplateException {

        Configuration cfg = new Configuration();

        URL url = Resources.getResource("codeTemplate");
        cfg.setDirectoryForTemplateLoading(new File(url.getPath()));
        cfg.setDefaultEncoding("UTF-8");
        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);

        Template temp = cfg.getTemplate("controller.ftl");  // load E:/Work/Freemarker/templates/person.ftl

        // Create the root hash
        Map<String, Object> root = new HashMap<String, Object>();

        root.put("packageName", "com/controller");
        root.put("className", "PersonController");
        root.put("requestMapping", "/");

        List<ControllerBean> list = new ArrayList<>();
        ControllerBean c1 = new ControllerBean();
//        c1.setGetOrPost("PostMapping");
//        c1.setMappingPath("/users");
//        c1.setMethodName("usersList");
//
//        ControllerBean c2 = new ControllerBean();
//        c2.setGetOrPost("PostMapping");
//        c2.setMappingPath("/users2");
//        c2.setMethodName("usersList2");

        list.add(c1);
//        list.add(c2);


        root.put("methods", list);

//      Writer out = new OutputStreamWriter(System.out);
//      Writer out = new OutputStreamWriter(System.out);
        File dir = new File("E:/workspace/RamlParser/src/main/java/com.controller");
        if (!dir.exists()) {
            dir.mkdirs();
        }
        OutputStream fos = new FileOutputStream(new File(dir, "PersonController.java")); //java文件的生成目录
        Writer out = new OutputStreamWriter(fos);
        temp.process(root, out);

        fos.flush();
        fos.close();

        System.out.println("com.gen code success!");
    }
}
