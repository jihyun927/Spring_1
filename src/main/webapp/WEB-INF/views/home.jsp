<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
<link href="./resources/css/home.css" rel="stylesheet">
	<title>Home</title>
</head>
<body>
	<h1>
		Hello world!  Spring
	</h1>

	<P>  The time on the server is ${serverTime}. </P>

	<img id="img1"  alt="" src="./resources/images/Jellyfish.jpg">
	
	<a href="./notice/noticeList?name=notice">Go Notice</a>
	<a href="./qna/qnaList">Go QnA</a>

</body>
</html>
