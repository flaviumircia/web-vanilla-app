package org.example.misc;

import java.io.*;
import java.util.HashMap;
import java.util.Properties;
import java.util.Scanner;

public class FileReader {
//    private static String formatString(String s){
//        String[] array=s.split("=");
//        return array[1];
//    }
    public HashMap<String,String> readFromFile() throws IOException {
//        Properties properties = new Properties();
//        properties.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("credentials.properties"));

//        FileInputStream ip=new FileInputStream("./src/main/webapp/WEB-INF/credentials.properties");
//        properties.load(ip);

//        HashMap<String,String> map=new HashMap<>();
//            map.put("user",properties.getProperty("username"));
//            map.put("password",properties.getProperty("password"));
        HashMap<String,String> map=new HashMap<>();
        map.put("user","");
        map.put("password","");
        return map;
    }
}
