package au.com.nab.smartchoice.filter;

import au.com.nab.smartchoice.service.LogService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@RequiredArgsConstructor
public class LoggingFilter implements Filter {

    private final LogService logService;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        String logId = "product-service-" + System.currentTimeMillis();
        logService.logHttpRequest(logId, "{}", (HttpServletRequest) request);
        chain.doFilter(request, response);
        logService.logHttpResponse(logId, "{}", (HttpServletResponse) response);
    }
}
