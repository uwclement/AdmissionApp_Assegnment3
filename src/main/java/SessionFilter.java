import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

public class SessionFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpResponse = (HttpServletResponse) servletResponse;
        HttpSession session = httpRequest.getSession(false);

        String requestURI = httpRequest.getRequestURI();
        boolean loggedIn = session != null && session.getAttribute("user") != null ;
        boolean loginRequest = requestURI.endsWith("Login.jsp") || requestURI.endsWith("LoginServlet");

        if (loggedIn || loginRequest) {
            chain.doFilter(servletRequest, servletResponse);
        } else {
            httpResponse.sendRedirect(httpRequest.getContextPath() + "/Login.jsp");
        }
    }
    }

