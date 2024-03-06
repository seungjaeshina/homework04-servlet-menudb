<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>main</title>
</head>
<body>
<h1>tbl_menu 테이블에서 menu_code를 이용하여 메뉴 정보 조회해오기 </h1>
<form action="${pageContext.servletContext.contextPath}/tbl_menu/select">
    <label>조회할 메뉴</label>
    <input type="text" name="menuCode" id="menuCode">
    <button>조회하기</button>
</form>

<h1>menudb 테이블에서 직원  전체 정보 조회 (주문 가능한 메뉴만 조회)</h1>
<button onclick="location.href='${pageContext.servletContext.contextPath}/tbl_menu/list'">
    메뉴 정보 전체 조회하기
</button>

<h1>menudb 테이블에서 신규 메뉴 등록</h1>
<form action="${pageContext.servletContext.contextPath }/tbl_menu/insert" method="post">
메뉴이름 : <input type="text" name="menuName"><br>
메뉴가격 : <input type="text" name="menuPrice"><br>
카테고리코드 :
        <select name="categoryCode">
            <option value="1">식사</option>
            <option value="2">음료</option>
            <option value="3">디저트</option>
            <option value="4">한식</option>
            <option value="5">중식</option>
            <option value="6">일식</option>
            <option value="7">퓨전</option>
            <option value="8">커피</option>
            <option value="9">쥬스</option>
            <option value="10">기타</option>
            <option value="11">동양</option>
            <option value="12">서양</option>
            <option value="16">신카테고리</option>
            <option value="18">뉴카테</option>
        </select>
        <br>

    <button type="submit">등록하기</button>
</form>
<h1>menudb 테이블 에서 메뉴 수정</h1>
<form action="${ pageContext.servletContext.contextPath}/tbl_menu/update" method="post">
    메뉴코드 : <input type="text" name="menuCode"/>
    변경할 메뉴 이름 : <input type="text" name="menuName"/>
    <button type="submit">메뉴 변경</button>
</form>


<h1>menudb 테이블에서 메뉴 정보 삭제</h1>
<form action="${ pageContext.servletContext.contextPath }/tbl_menu/delete" method="post">
    사번 : <input type="text" name="menuCode"/>
    <button type="submit">메뉴 정보 삭제</button>
</form>

</body>
</html>
