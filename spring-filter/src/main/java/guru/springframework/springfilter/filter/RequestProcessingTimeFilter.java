package guru.springframework.springfilter.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Component
@Slf4j
public class RequestProcessingTimeFilter extends GenericFilterBean {
    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain
            filterChain)throws IOException, ServletException {
                   long time = System.currentTimeMillis();
            try {
                filterChain.doFilter(req, res);
            } finally {
                time = System.currentTimeMillis() - time;
                log.debug("Request was processed in: {}: {} ms ", ((HttpServletRequest) req).getRequestURI(),  time);
            }
        }

      }

