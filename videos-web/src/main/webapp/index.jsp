
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>

<html>
<body>
<h2>Hello World!</h2>

<%
    String path = request.getContextPath();
%>
<a href=<%=path%>/user/index>前端登录</a><br/>
<a href=<%=path%>/admin/tologin>后端登录</a>
</body>
</html>
