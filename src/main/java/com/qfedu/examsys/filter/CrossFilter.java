package com.qfedu.examsys.filter;


import org.springframework.context.annotation.Configuration;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Configuration
@WebFilter("/*")
public class CrossFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {

        System.out.println(((HttpServletRequest)req).getRequestURI());

        HttpServletResponse httpServletResponse = (HttpServletResponse) resp;

        // * 任意ip的路径都可以跨域访问
        httpServletResponse.setHeader("Access-Control-Allow-Origin", "*");
        //httpServletResponse.setHeader("Access-Control-Allow-Headers", "x-requested-with,Authorization,accept,content-type,token,uname");
        // * 任意的请求头可以跨域
        httpServletResponse.setHeader("Access-Control-Allow-Headers", "*");
        // 允许跨域的提交方式
        httpServletResponse.setHeader("Access-Control-Allow-Methods", "OPTIONS,GET,POST,DELETE,PUT");
        httpServletResponse.setHeader("Access-Control-Allow-Credentials", "true");
        chain.doFilter(req, resp);
    }

    @Override
    public void destroy() {

    }
}
