package inflearn.springmvc1.basic.response;

import com.fasterxml.jackson.databind.ObjectMapper;
import inflearn.springmvc1.basic.HelloData;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "responseJsonServlet", urlPatterns = "/response-json")
public class ResponseJsonServlet extends HttpServlet {

    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("application/json");
        response.setCharacterEncoding("utf-8");

        final HelloData data = new HelloData();
        data.setUsername("kim");
        data.setAge(20);

        final String result = objectMapper.writeValueAsString(data);
        final PrintWriter writer = response.getWriter();
        writer.println(result);
    }
}
