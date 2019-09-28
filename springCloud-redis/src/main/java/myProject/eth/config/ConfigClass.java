package myProject.eth.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
 
/**
 * @author <a href="h_sn999@126.com">hsn</a>
 * @Discription
 * @Data 2017-9-12
 * @Version 1.0.0
 */

/**
 *classpath路径：locations={"classpath:application-bean1.xml","classpath:application-bean2.xml"}
 * file路径： locations ={"file:d:/test/application-bean1.xml"};
 */
@Configuration
@ImportResource(locations={"classpath:application-bean.xml"})
//@ImportResource(locations={"file:d:/test/application-bean1.xml"})
public class ConfigClass {
 
}