package au.com.nab.smartchoice.service.impl;

import au.com.nab.smartchoice.configuration.kafka.TopicConfiguration;
import au.com.nab.smartchoice.dto.kafkamessage.HttpLogKafkaMessage;
import au.com.nab.smartchoice.service.LogService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.*;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
@Slf4j
public class LogServiceImpl implements LogService {

    private final KafkaTemplate<String, String> kafkaTemplate;
    private final ObjectMapper objectMapper;

    @Override
    @Async
    public void logHttpRequest(String logId, String requestBody, HttpServletRequest httpServletRequest) {
        var httpLogKafkaMessage = new HttpLogKafkaMessage();
        httpLogKafkaMessage.setLogId(logId);
        httpLogKafkaMessage.setRequestedAt(LocalDateTime.now());
        httpLogKafkaMessage.setRequestLine(httpServletRequest.getMethod() + " " + httpServletRequest.getRequestURL().toString());
        try {
            httpLogKafkaMessage.setSrcIp(Inet4Address.getLocalHost().getHostAddress());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        try {
            httpLogKafkaMessage.setDesIp(InetAddress.getByName(new URL(
                    httpServletRequest.getRequestURL().toString()).getHost()).getHostAddress());
        } catch (UnknownHostException | MalformedURLException e) {
            e.printStackTrace();
        }
        Map<String, Object> headers = new LinkedHashMap<>();
        Collections.list(httpServletRequest.getHeaderNames()).forEach(headerName ->
                headers.put(headerName, String.join(";", Collections.list(httpServletRequest.getHeaders(headerName)))));
        httpLogKafkaMessage.setRequestHeader(headers);
        httpLogKafkaMessage.setRequestBody(requestBody);
        String httpLogKafkaMessageStr = null;
        try {
            httpLogKafkaMessageStr = objectMapper.writeValueAsString(httpLogKafkaMessage);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        log.info(httpLogKafkaMessageStr);
        kafkaTemplate.send(TopicConfiguration.LOG_TOPIC, httpLogKafkaMessageStr);
    }

    @Override
    @Async
    public void logHttpResponse(String logId, String responseBody, HttpServletResponse httpServletResponse) {
        var httpLogKafkaMessage = new HttpLogKafkaMessage();
        httpLogKafkaMessage.setLogId(logId);
        httpLogKafkaMessage.setRespondedAt(LocalDateTime.now());
        httpLogKafkaMessage.setResponseStatus(httpServletResponse.getStatus());
        Map<String, Object> headers = new LinkedHashMap<>();
        httpServletResponse.getHeaderNames().forEach(headerName ->
                headers.put(headerName, String.join(";", httpServletResponse.getHeaders(headerName))));
        httpLogKafkaMessage.setResponseHeader(headers);
        httpLogKafkaMessage.setResponseBody(responseBody);
        String httpLogKafkaMessageStr = null;
        try {
            httpLogKafkaMessageStr = objectMapper.writeValueAsString(httpLogKafkaMessage);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        log.info(httpLogKafkaMessageStr);
        kafkaTemplate.send(TopicConfiguration.LOG_TOPIC, httpLogKafkaMessageStr);
    }
}
