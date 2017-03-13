package servlet;

import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class EncodingFilter implements Filter {

	private String encoding;    
    private HashMap<String,String> params = new HashMap<String,String>();    
    // ��Ŀ����ʱ���Ѿ���������    
    public void destroy() {    
        params=null;    
        encoding=null;    
    }    
    public void doFilter(ServletRequest req, ServletResponse resp,FilterChain chain) throws IOException, ServletException {    
        //System.out.println("before encoding " + encoding + " filter��");    
        req.setCharacterEncoding(encoding);    
        chain.doFilter(req, resp);          
        //System.out.println("after encoding " + encoding + " filter��");    
        //System.err.println("----------------------------------------");    
    }    
     
    // ��Ŀ����ʱ���Ѿ����ж�ȡ    
    public void init(FilterConfig config) throws ServletException {    
        //System.out.println("begin do the encoding filter!");    
        encoding = config.getInitParameter("encoding");    
        for (Enumeration<?> e = config.getInitParameterNames(); e.hasMoreElements();) {    
            String name = (String) e.nextElement();    
            String value = config.getInitParameter(name);    
            params.put(name, value);    
        }    
    }    

}
