<%@ page import="hello.servlet.domain.Member" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<body>
성공
<ul>
  <%--<li>id=<%=((Member)request.getAttribute("member")).getId()%></li>
  <li>id=<%=((Member)request.getAttribute("member")).getUsername()%></li>
  <li>id=<%=((Member)request.getAttribute("member")).getAge()%></li>--%>

  <li>id=${member.id}</li>
  <li>username=${member.username}</li>
  <li>age=${member.age}</li>
</ul>
<a href="/index.html">메인</a>
</body>
</html>
