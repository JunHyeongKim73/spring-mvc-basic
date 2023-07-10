package inflearn.springmvc1.web.frontcontroller.v5.adapter;

import inflearn.springmvc1.web.frontcontroller.ModelView;
import inflearn.springmvc1.web.frontcontroller.v4.ControllerV4;
import inflearn.springmvc1.web.frontcontroller.v5.MyHandlerAdapter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ControllerV4HandlerAdapter implements MyHandlerAdapter {

    @Override
    public boolean supports(Object handler) {
        return (handler instanceof ControllerV4);
    }

    @Override
    public ModelView handle(HttpServletRequest request, HttpServletResponse response, Object handler) throws ServletException, IOException {
        final ControllerV4 controller = (ControllerV4) handler;

        final Map<String, String> paramMap = createParamMap(request);
        final Map<String, Object> model = new HashMap<>();

        final String viewName = controller.process(paramMap, model);

        final ModelView mv = new ModelView(viewName);
        mv.setModel(model);

        return mv;
    }

    private Map<String, String> createParamMap(HttpServletRequest request) {
        final Map<String, String> paramMap = new HashMap<>();
        request.getParameterNames().asIterator()
                .forEachRemaining(paramName -> paramMap.put(paramName, request.getParameter(paramName)));
        return paramMap;
    }


}