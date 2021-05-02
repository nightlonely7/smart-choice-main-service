package au.com.nab.smartchoice.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface LogService {
    void logHttpRequest(String logId, String requestBody, HttpServletRequest httpServletRequest);

    void logHttpResponse(String logId, String responseBody, HttpServletResponse httpServletResponse);
}
