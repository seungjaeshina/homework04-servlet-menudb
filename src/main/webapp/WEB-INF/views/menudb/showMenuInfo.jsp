<%--
  Created by IntelliJ IDEA.
  User: sinseungjae
  Date: 3/6/24
  Time: 15:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>메뉴 정보</title>
</head>
<body>
<h1>${ param.menuCode}번 메뉴의 정보</h1>
<h4>메뉴이름 : ${selectedMenu.menuName}</h4>
<h4>가격 : ${selectedMenu.menuPrice}</h4>
<h4>카테고리코드 : ${selectedMenu.categoryCode}</h4>
<h4>주문 가능한 상태 : ${selectedMenu.orderableStatus}</h4>

</body>
</html>
