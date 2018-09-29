package club.small.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class XssFilter implements Filter {
    FilterConfig filterConfig = null;
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        filterChain.doFilter(new XssHttpServletRequestWrapper((HttpServletRequest)servletRequest), servletResponse);
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;
    }

    @Override
    public void destroy() {
        this.filterConfig = null;
    }
}
