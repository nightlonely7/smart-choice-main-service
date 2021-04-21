package au.com.nab.smartchoice.configuration;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableFeignClients(basePackages = "au.com.nab.smartchoice.feignclient")
public class OpenFeignConfiguration {
}
