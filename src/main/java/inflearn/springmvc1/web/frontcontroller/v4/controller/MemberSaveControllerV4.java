package inflearn.springmvc1.web.frontcontroller.v4.controller;

import inflearn.springmvc1.domain.member.Member;
import inflearn.springmvc1.domain.member.MemberRepository;
import inflearn.springmvc1.web.frontcontroller.ModelView;
import inflearn.springmvc1.web.frontcontroller.v3.ControllerV3;
import inflearn.springmvc1.web.frontcontroller.v4.ControllerV4;

import java.util.Map;

public class MemberSaveControllerV4 implements ControllerV4 {

    private MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    public String process(Map<String, String> paramMap, Map<String, Object> model) {
        final String username = paramMap.get("username");
        final int age = Integer.parseInt(paramMap.get("age"));

        final Member member = new Member(username, age);
        memberRepository.save(member);

        model.put("member", member);

        return "save-result";
    }
}
