<%--
  Created by IntelliJ IDEA.
  User: 苗国庆
  Date: 2020/8/20
  Time: 21:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<script src="js/jquery.js" type="text/javascript"></script>
<body>
<a href="http://localhost:8080" id="aj" ><h1 id="jump" align="center">跳转中。。。。。</h1></a>
<%--<h1 align="center">跳转中</h1>--%>
</body>
<script>
    setInterval(function(){ $("#jump").trigger("click"); }, 3000);
</script>
</html>
