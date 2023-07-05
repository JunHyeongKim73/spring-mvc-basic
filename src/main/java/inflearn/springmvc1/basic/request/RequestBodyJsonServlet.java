package inflearn.springmvc1.basic.request;

import com.fasterxml.jackson.databind.ObjectMapper;
import inflearn.springmvc1.basic.HelloData;
import org.springframework.util.StreamUtils;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

@WebServlet(name = "requestBodyJsonServlet", urlPatterns = "/request-body-json")
public class RequestBodyJsonServlet extends HttpServlet {

    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        final ServletInputStream inputStream = request.getInputStream();
        final String body = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);

        System.out.println("body = " + body);

        final HelloData data = objectMapper.readValue(body, HelloData.class);
        
        System.out.println("data.getUserName() = " + data.getUsername());
        System.out.println("data.getAge() = " + data.getAge());
    }
}
