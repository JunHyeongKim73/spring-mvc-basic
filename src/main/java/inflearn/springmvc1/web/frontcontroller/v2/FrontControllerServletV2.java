package inflearn.springmvc1.web.frontcontroller.v2;

import inflearn.springmvc1.web.frontcontroller.MyView;
import inflearn.springmvc1.web.frontcontroller.v2.ControllerV2;
import inflearn.springmvc1.web.frontcontroller.v2.controller.MemberFormControllerV2;
import inflearn.springmvc1.web.frontcontroller.v2.controller.MemberListControllerV2;
import inflearn.springmvc1.web.frontcontroller.v2.controller.MemberSaveControllerV2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "frontControllerServeletV2", urlPatterns = "/front-controller/v2/*")
public class FrontControllerServletV2 extends HttpServlet {

    private final Map<String, ControllerV2> controllerMap = new HashMap<>();

    public FrontControllerServletV2() {
        controllerMap.put("/front-controller/v2/members/new-form", new MemberFormControllerV2());
        controllerMap.put("/front-controller/v2/members/save", new MemberSaveControllerV2());
        controllerMap.put("/front-controller/v2/members", new MemberListControllerV2());
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        final String requestURI = request.getRequestURI();

        final ControllerV2 controller = controllerMap.get(requestURI);

        if (controller == null) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        final MyView myView = controller.process(request, response);
        myView.render(request, response);
    }
}
