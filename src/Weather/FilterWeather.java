package Weather;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter("/getTemperature2")
public class FilterWeather implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        Cookie[] cookies = ((HttpServletRequest) servletRequest).getCookies();
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("lokalizacja")) {
                filterChain.doFilter(servletRequest, servletResponse);
                return;
            }
        }
        servletResponse.getWriter().println("No city cookie!");
    }

    @Override
    public void destroy() {

    }

}