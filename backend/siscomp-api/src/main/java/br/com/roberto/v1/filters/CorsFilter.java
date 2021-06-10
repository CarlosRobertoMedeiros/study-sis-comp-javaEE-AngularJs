package br.com.roberto.v1.filters;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class CorsFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletResponse response = (HttpServletResponse) servletResponse;
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.setHeader("Access-Control-Allow-Methods", "GET, HEAD, OPTIONS, POST, PUT, DELETE");
        response.setHeader("Access-Control-Allow-Headers", "" +
                "X-Requested-With, " +
                "Authorization, " +
                "Accept-Version, " +
                "Content-MD5, " +
                "CSRF-Token" +
                "Origin, " +
                "Accept, " +
                "X-Requested-With, " +
                "Content-Type, " +
                "Access-Control-Request-Method, " +
                "Access-Control-Request-Headers");
        response.setHeader("Accept-Encoding", "gzip, deflate");
        response.setHeader("Accept-Language", "pt-BR,pt;q=0.9,en-US;q=0.8,en;q=0.7");
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }

}
