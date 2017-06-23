package config;

import converters.EmployeeResponseConverter;
import org.dozer.DozerBeanMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    @Bean
    public DozerBeanMapper dozerBean(){
        DozerBeanMapper dozerBeanMapper = new DozerBeanMapper();
        dozerBeanMapper.addMapping(new EmployeeResponseConverter());
        return dozerBeanMapper;

    }

}
