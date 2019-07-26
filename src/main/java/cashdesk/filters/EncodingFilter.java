package cashdesk.filters;

import org.apache.log4j.Logger;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class EncodingFilter implements Filter {
    private static final Logger LOGGER = Logger.getLogger(EncodingFilter.class);

    private static final String ENCODING_TYPE = "encoding_type";
    private String encodingTypeValue;


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        encodingTypeValue = filterConfig.
                getInitParameter(ENCODING_TYPE);
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        LOGGER.debug("Set encoding type " + encodingTypeValue);

        request.setCharacterEncoding(encodingTypeValue);
        response.setCharacterEncoding(encodingTypeValue);
        response.setContentType("text/html; charset=" + encodingTypeValue);
        boolean redirect = Boolean.parseBoolean(request.getParameter("redirect"));
        if(redirect){
            httpServletResponse.sendError(HttpServletResponse.SC_NOT_FOUND);
            request.setAttribute("greeting", "Not found! Sorry");
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }else {
            filterChain.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {

    }
}
