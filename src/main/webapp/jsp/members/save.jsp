<%@ page import="inflearn.springmvc1.domain.member.Member" %>
<%@ page import="inflearn.springmvc1.domain.member.MemberRepository" %><%--
  Created by IntelliJ IDEA.
  User: junhyeong
  Date: 2023/07/06
  Time: 23:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    final MemberRepository memberRepository = MemberRepository.getInstance();

    System.out.println("MemberSaveServlet.service");
    final String username = request.getParameter("username");
    final int age = Integer.parseInt(request.getParameter("age"));

    final Member member = new Member(username, age);
    memberRepository.save(member);
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
성공
<ul>
    <li>id = <%= member.getId() %></li>
    <li>username = <%= member.getUsername() %></li>
    <li>age = <%= member.getAge() %></li>
</ul>
</body>
</html>
