package com.gaoke.gen;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.google.common.io.Resources;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import org.apache.tomcat.util.json.JSONParser;
import org.json.JSONObject;

import java.io.*;
import java.net.URL;

public class JsonParse {

    public static void main(String[] args) {
        URL url = Resources.getResource("schema/a-req-schema.json");

        try {
            String jsonRead = readJsonData(url.getPath());
            Gson gson = new Gson();

             JsonElement el  = JsonParser.parseString(jsonRead);

            System.out.println();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static String readJsonData(String filePahtName) throws IOException {
        StringBuffer strbuffer = new StringBuffer();
        File myFile = new File(filePahtName);
        if (!myFile.exists()) {
            System.err.println("不能找到文件" + filePahtName+"，请检查文件地址");
        }

        try ( FileInputStream fis = new FileInputStream(filePahtName);
              InputStreamReader inputStreamReader = new InputStreamReader(fis, "UTF-8");//乱码的话可以换成 GBK    //将字节流转化为字符输入流
              BufferedReader in  = new BufferedReader(inputStreamReader);  ){
            String str;
            while ((str = in.readLine()) != null) {
                strbuffer.append(str);  //new String(str,"UTF-8")
            }

        } catch (IOException e) {
            e.getStackTrace();
        }
        return strbuffer.toString();
    }

    public void readJson(String json){

    }
}
