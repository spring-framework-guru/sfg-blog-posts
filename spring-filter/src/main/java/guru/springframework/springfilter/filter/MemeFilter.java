package guru.springframework.springfilter.filter;

import ch.qos.logback.classic.Level;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@Component
@Slf4j
public class MemeFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig)  {
        log.debug("init() method has been get invoked");
        log.debug("Filter name is "+filterConfig.getFilterName());
        log.debug("ServletContext name is"+filterConfig.getServletContext());
        log.debug("init() method is ended");
    }
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        log.debug("doFilter() method is invoked");
        HttpServletRequest httpServletRequest = (HttpServletRequest)servletRequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse)servletResponse;
        filterChain.doFilter(httpServletRequest, httpServletResponse);
        log.debug("doFilter() method is ended");
    }
    @Override
    public void destroy() {
        log.debug("destroy() method is invoked");
    }
}
