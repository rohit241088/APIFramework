package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class PropertiesHelper {
    private Properties properties;
    private Map<String,Object> keysValues=null;
    public PropertiesHelper(String filePath){
        FileInputStream in =null;
        try{
            in=new FileInputStream(filePath);
            properties=new Properties();
            properties.load(in);
            in.close();
            keysValues=new HashMap<>();

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public Object getValue(String key) {
        if (keysValues.size() == 0) {
            Set<Object> keys = this.properties.keySet();
            Iterator<Object> iterator = keys.iterator();
            while (iterator.hasNext()) {
                String k = (String) iterator.next();
                keysValues.put(k, properties.getProperty(k));
            }

        }
        return keysValues.get(key);

    }



}
