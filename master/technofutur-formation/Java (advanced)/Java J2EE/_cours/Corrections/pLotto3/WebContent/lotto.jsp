<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.ArrayList"%>
<jsp:useBean id="lotto" class="be.wavenet.lotto.LottoProcessor"
	scope="application" />
<%!private ArrayList<Integer> getMyNumbers(HttpServletRequest request) {
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		for (int i = 1; i <= 42; i++) {
			String n = request.getParameter("n" + i);
			if (n != null)
				numbers.add(i);
			if (numbers.size() == 6)
				break;
		}
		return numbers;
	}%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Example Lotto 3 - Result</title>
</head>
<body>
<h1>Lotto result</h1>
<div>

<table border="1">
	<tr>
		<c:forEach var="result" items="${lotto.result}">
			<td><c:out value="${result}" /></td>
		</c:forEach>
	</tr>
</table>
</div>
<h1>Your numbers</h1>
<div>
<table border="1">
	<tr>
		<%
			lotto.setMyNumbers(getMyNumbers(request));
		%>
		<c:forEach var="myNumber" items="${lotto.myNumbers}">
			<td><c:out value="${myNumber}" /></td>
		</c:forEach>
	</tr>
</table>
</div>
<h1>Your winning numbers (<c:out
	value="${lotto.myWinningNumbersCount}" />)</h1>
<div>
<table border="1">
	<tr>
		<c:forEach var="myWinningNumber" items="${lotto.myWinningNumbers}">
			<td><c:out value="${myWinningNumber}" /></td>
		</c:forEach>
	</tr>
</table>
</div>
</body>
</html>