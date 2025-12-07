package org.example.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyFileReader{

    public PropertyFileReader(){

    }
    public static String readKey(String key) throws IOException {

        FileInputStream fileInputStream=null;
        Properties properties=null;
        try {
            fileInputStream=new FileInputStream(System.getProperty("user.dir")+"/src/main/resources/data.properties");
            properties=new Properties();
            properties.load(fileInputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            try {
                fileInputStream.close();
            }catch (Exception e){
                e.printStackTrace();
            }

        }
        return properties.getProperty(key);

    }
}
