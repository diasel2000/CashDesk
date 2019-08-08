package cashdesk.controller.filters;

import cashdesk.model.entity.Users;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        Users users =(Users)((HttpServletRequest)servletRequest).getSession().getAttribute("user");
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String loginURI = request.getContextPath()+"/public/login.jsp";
        String path = request.getRequestURI();
        String roles = "";
        if(path.contains("supervisor")) roles ="supervisor";
        else if (path.contains("adminCaisher")) roles ="adminCaisher";
        else if (path.contains("caisher")) roles ="caisher";
        switch (roles){
            case "supervisor":
                if (users!=null&&(users.getRole() == "supervisor" || users.getRole() == "adminCaisher")) {
                    filterChain.doFilter(servletRequest, servletResponse);

                } else {
                    response.sendRedirect(loginURI);
                }
                break;
            case "adminCaisher":
                if (users!=null&&users.getRole() == "adminCaisher") {
                    filterChain.doFilter(servletRequest, servletResponse);
                } else {
                    response.sendRedirect(loginURI);
                }
                break;
            case "caisher":
                if (users!=null&&(users.getRole() == "caisher" || users.getRole() == "adminCaisher")) {
                    filterChain.doFilter(servletRequest, servletResponse);
                } else {
                    response.sendRedirect(loginURI);
                }
                break;
            default:
                filterChain.doFilter(servletRequest, servletResponse);
        }    }

    @Override
    public void destroy() {

    }
}
