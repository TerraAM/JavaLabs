package myConnect;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.Connection;


public class Connect {
    public Connection getConnection() throws IOException ,SQLException{
        Properties props = new Properties();
        FileInputStream in = new FileInputStream("prop/mydb.properties");
        props.load(in);
        in.close();
        String url = props.getProperty("jdbc.url");
        String username = props.getProperty("jdbc.username");
        String password = props.getProperty("jdbc.password");
        return DriverManager.getConnection(url,username,password);
    }
}
