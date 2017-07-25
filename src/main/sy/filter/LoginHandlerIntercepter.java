package sy.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import sy.model.User;

public class LoginHandlerIntercepter implements HandlerInterceptor   {

	 public boolean preHandle(HttpServletRequest request,
            HttpServletResponse response, Object handler) throws Exception {
        System.out.println("-------��action֮ǰִ��,�������true,��������ִ��--------");
//	        System.out.println(request.getParameter("name"));
        // �˴�ʵ�ֵ�½�������ж�
        if(request.getSession().getAttribute("user")==null){
            response.sendRedirect(request.getContextPath() + "/user/tologin.do");
            return false;
        }else{
            return true;
        }
    }
 
    public void postHandle(HttpServletRequest request,
            HttpServletResponse response, Object handler,
            ModelAndView modelAndView) throws Exception {
        System.out.println("----��Action ����ִ�����֮��,ִ��(û�����쳣�Ļ�)----------");
    }
 
    public void afterCompletion(HttpServletRequest request,
            HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
        System.out.println("----��Action ����ִ�����֮��,�����Ƿ��׳��쳣,ͨ�����������쳣����----------");
    }


	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
