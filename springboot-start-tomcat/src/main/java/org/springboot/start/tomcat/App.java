package org.springboot.start.tomcat;

import static org.springframework.boot.SpringApplication.run;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ConfigurableApplicationContext;



/**
 * Hello world!
 *
 */

@SpringBootApplication
@EnableCaching
@EnableAutoConfiguration
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        ConfigurableApplicationContext run = run(App.class, args);
    }
}
