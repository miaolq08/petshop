<%@ page language="java" contentType="text/html; charset=utf-8"	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>电脑网站支付return_url</title>
	<script type="text/javascript" src="/index/js/jquery.min.js"></script>
</head>
<body>
<script>
	$(function () {
		window.location.href="order/payok?id="${order.id}+"&userId="${user.id};
	})
</script>
</body>
</html>