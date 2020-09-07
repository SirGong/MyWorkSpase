<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String basePath = request.getScheme()
            + "://"
            + request.getServerName()
            + ":"
            + request.getServerPort()
            + request.getContextPath()
            + "/";

    pageContext.setAttribute("basePath",basePath);
%>
<html>
<head>
    <title>HelloWorld</title>
</head>
<body>
    <a href="hello">hello</a>

    <a href="/springMVC/getResources/1">获取资源</a>

    <form action="/springMVC/addResources" method="post">
        <input type="submit" value="添加资源"/>
    </form>

    <form action="/springMVC/updateResources/1" method="post">
        <input type="hidden" name="_method" value="put"/>
        <input type="submit" value="修改资源"/>
    </form>

    <form action="/springMVC/deleteResources/1" method="post">
        <input type="hidden" name="_method" value="delete"/>
        <input type="submit" value="删除资源"/>
    </form>

    <hr>
    <a href="/springMVC/handle01?username=hello">参数测试</a><br>
    <hr>

    <form method="post" action="/springMVC/book">
        书名：<input type="text" name="name"/><br>
        作者：<input type="text" name="author"/><br>
        价格：<input type="text" name="price"/><br>
        库存：<input type="text" name="stock"/><br>
        销量：<input type="text" name="sales"/><br>
        <input type="submit" value="保存"/><br>
    </form>
</body>
</html>
