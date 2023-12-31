package inflearn.springmvc1.web.frontcontroller.v2.controller;

import inflearn.springmvc1.domain.member.Member;
import inflearn.springmvc1.domain.member.MemberRepository;
import inflearn.springmvc1.web.frontcontroller.MyView;
import inflearn.springmvc1.web.frontcontroller.v1.ControllerV1;
import inflearn.springmvc1.web.frontcontroller.v2.ControllerV2;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MemberSaveControllerV2 implements ControllerV2 {

    private MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    public MyView process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        final String username = request.getParameter("username");
        final int age = Integer.parseInt(request.getParameter("age"));

        final Member member = new Member(username, age);
        memberRepository.save(member);

        // 모델에 데이터를 보관
        request.setAttribute("member", member);

        return new MyView("/WEB-INF/views/save-result.jsp");
    }
}
