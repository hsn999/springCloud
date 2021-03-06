package app.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.openfeign.EnableFeignClients;

import springfox.documentation.swagger2.annotations.EnableSwagger2;



/**
 * Hello world!
 *
 */
@SpringBootApplication(scanBasePackages = {"app.gateway"}, exclude = DataSourceAutoConfiguration.class)
@EnableFeignClients
public class Gateway 
{
    public static void main( String[] args )
    {
    	 SpringApplication.run(Gateway.class, args);
    }
}
