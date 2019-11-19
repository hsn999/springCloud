package app.gateway.aop;


import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import app.gateway.threadLocal.PassParameters;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;
 
/**
 * @author hsn
 */
@Aspect
@Order(85)
@Component
public class ApiRequestAspect {
	private static Logger logger = LoggerFactory.getLogger(ApiRequestAspect.class);
 

	@Pointcut("execution (* app.gateway.controller.ApiController.*(..)) ")
	private void anyMethod() {
	}
 
	/**
	 * 方法调用之前调用
	 */
	@Before("anyMethod()")
	public void doBefore(){
		logger.info("开始处理请求信息！");
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
				.getRequest();
 
		Map<String,String> map = new HashMap<>();
		String username = request.getParameter("username");
		String token = request.getParameter("token");
		
		map.put("username", username);
		map.put("token", token);
		
		//将map放到threadLocal中
		PassParameters.set(map);
	}
 
	/**
	 * 方法之后调用
	 */
	@AfterReturning(pointcut = "anyMethod()")
	public void  doAfterReturning(){
		
	}
	
}