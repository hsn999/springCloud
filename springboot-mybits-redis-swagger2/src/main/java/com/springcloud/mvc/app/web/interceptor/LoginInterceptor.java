package com.springcloud.mvc.app.web.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.springcloud.mvc.app.constant.MvcConstant;
import com.springcloud.mvc.app.dto.TokenInfo;
import com.springcloud.mvc.app.dto.UserInfoDTO;
import com.springcloud.mvc.app.enums.ErrorCodeEnum;
import com.springcloud.mvc.app.service.ITokenService;
import com.springcloud.mvc.app.wrapper.ResultWrapper;
import com.springcloud.mvc.common.constant.SysConstant;
import com.springcloud.mvc.common.util.JsonUtil;
import com.springcloud.mvc.common.util.ThreadLocalMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class LoginInterceptor implements HandlerInterceptor {
    @Autowired
    private ITokenService tokenService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {

        String accessToken = null;
        String userAttr = null;

        accessToken = request.getHeader(MvcConstant.HTTP_HEADER_MVC_ACCESS_TOKEN);
        
        userAttr = request.getHeader("userAttr");

        if (null == accessToken) {
            accessToken = request.getParameter(MvcConstant.RQE_PARAM_MVC_ACCESS_TOKEN);
        }


        ResultWrapper  resultWrapper =null;
        response.setHeader("Content-Type", "application/json;charset=utf-8");

        /**
         * 用户没有传递token，返回错误信息给用户
         */
        if (null == accessToken) {
            ThreadLocalMap.remove(SysConstant.THREAD_LOCAL_KEY_LOGIN_USER);
            resultWrapper = ResultWrapper.failure(ErrorCodeEnum.UNAUTHORIZED);
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            try {
                response.getWriter().println(JsonUtil.toJson(resultWrapper));
            } catch (Exception e) {
                e.printStackTrace();
            }

            return false;
        }

        /**
         * token错误
         */
        TokenInfo tokenInfo = tokenService.getTokenInfo(accessToken);
        if (null == tokenInfo) {
            ThreadLocalMap.remove(SysConstant.THREAD_LOCAL_KEY_LOGIN_USER);
            resultWrapper = ResultWrapper.failure(ErrorCodeEnum.BAD_ACCESS_TOKEN);
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            try {
                response.getWriter().println(JsonUtil.toJson(resultWrapper));
            } catch (Exception e) {
                e.printStackTrace();
            }

            return false;
        }

        /**
         * 将UserInfo设置到ThreadLocal
         */
        UserInfoDTO userInfoDTO = new UserInfoDTO();
        userInfoDTO.setUserId(tokenInfo.getUserId());
        ThreadLocalMap.put(SysConstant.THREAD_LOCAL_KEY_LOGIN_USER, userInfoDTO);
        return true;
    }

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		
	}
}
