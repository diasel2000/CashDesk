package cashdesk.controller.filters;

import cashdesk.model.entity.Users;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Login Filter
 *
 * @author Anatolii Huzov
 * @version 1.0
 */
public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;
        HttpSession session = request.getSession ( false );
        if ((session == null || session.getAttribute ( "loggedIn" ) == null)) {
            response.sendRedirect ( request.getContextPath () + "/public/login.jsp" );
        } else {
            filterChain.doFilter ( request, response );
        }
    }

    @Override
    public void destroy() {

    }
}
