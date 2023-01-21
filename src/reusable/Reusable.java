package reusable;

import java.io.FileInputStream;
import java.util.Properties;

public class Reusable {


    public String readPropertiesFile(String Key){

        String value = null;
        Properties prop = new Properties();
        try{
            prop.load(new FileInputStream(System.getProperty("user.dir")+"/testData.properties"));
            value = prop.getProperty(Key);
        }
        catch(Exception e){}

        return value;
    }




}
