package com.gaoke.gen;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.common.io.Resources;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;




public class JavaBeanGen {
    public static void main(String[] args) {

        try {
            new JavaBeanGen().gen();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TemplateException e) {
            e.printStackTrace();
        }
    }

    public void gen() throws IOException, TemplateException{

        Configuration cfg = new Configuration();

        URL url = Resources.getResource("codeTemplate");
        cfg.setDirectoryForTemplateLoading(new File(url.getPath()));
        cfg.setDefaultEncoding("UTF-8");
        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);

        Template temp = cfg.getTemplate("com.bean.ftl");  // load E:/Work/Freemarker/templates/person.ftl

        // Create the root hash
        Map<String, Object> root = new HashMap<String, Object>();

        root.put("packageName", "com/bean");
        root.put("className", "Person");
        root.put("author", "Ricky Fung");

        List<Attribute> attr_list = new ArrayList<Attribute>();
        attr_list.add(new Attribute("id", "Long"));
        attr_list.add(new Attribute("name", "String"));
        attr_list.add(new Attribute("age", "Integer"));
        attr_list.add(new Attribute("hobby", "List<String>"));

        root.put("attrs", attr_list);

//      Writer out = new OutputStreamWriter(System.out);
//      Writer out = new OutputStreamWriter(System.out);
        File dir = new File("E:/workspace/RamlParser/src/main/java/com.bean");
        if(!dir.exists()){
            dir.mkdirs();
        }
        OutputStream fos = new  FileOutputStream( new File(dir, "Person.java")); //java文件的生成目录
        Writer out = new OutputStreamWriter(fos);
        temp.process(root, out);

        fos.flush();
        fos.close();

        System.out.println("com.gen code success!");
    }

}
