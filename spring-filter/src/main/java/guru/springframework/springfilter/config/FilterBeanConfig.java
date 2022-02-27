package guru.springframework.springfilter.config;


import guru.springframework.springfilter.filter.MemeFilter;
import guru.springframework.springfilter.filter.RequestProcessingTimeFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterBeanConfig {

    @Bean
    public FilterRegistrationBean requestMemeFilter() {
        MemeFilter memeFilter=new MemeFilter();
        final FilterRegistrationBean reg = new FilterRegistrationBean(memeFilter);
        reg.addUrlPatterns("/*");
        reg.setOrder(1); //defines filter execution order
        return reg;
    }

    @Bean
    public FilterRegistrationBean requestRequestProcessingTimeFilter() {
        RequestProcessingTimeFilter requestProcessingTimeFilter =new RequestProcessingTimeFilter();
        final FilterRegistrationBean reg = new FilterRegistrationBean(requestProcessingTimeFilter);
        reg.addUrlPatterns("/*");
        reg.setOrder(2); //defines filter execution order
        return reg;
    }


}
