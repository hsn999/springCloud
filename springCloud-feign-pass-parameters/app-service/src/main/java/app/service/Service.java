package app.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.openfeign.EnableFeignClients;



/**
 * Hello world!
 *
 */
@SpringBootApplication(scanBasePackages = {"app.service"}, exclude = DataSourceAutoConfiguration.class)
public class Service 
{
    public static void main( String[] args )
    {
    	 SpringApplication.run(Service.class, args);
    }
}