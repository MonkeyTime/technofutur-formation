<?xml version="1.0" encoding="ISO-8859-1" ?>
<jsp:root xmlns:jsp="http://java.sun.com/JSP/Page"
	xmlns:c="http://java.sun.com/jsp/jstl/core" version="2.0">
	<jsp:directive.page language="java"
		contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" />

	<jsp:directive.page import="java.util.ArrayList" />
	<jsp:useBean id="lotto" class="be.wavenet.lotto.LottoProcessor"
		scope="application" />
	<jsp:declaration><![CDATA[private ArrayList<Integer> getMyNumbers(HttpServletRequest request) {
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		for (int i = 1; i <= 42; i++) {
			String n = request.getParameter("n" + i);
			if (n != null)
				numbers.add(i);
			if (numbers.size() == 6)
				break;
		}
		return numbers;
	}]]></jsp:declaration>
	<jsp:text>
		<![CDATA[ <?xml version="1.0" encoding="ISO-8859-1" ?> ]]>
	</jsp:text>
	<jsp:text>
		<![CDATA[ <!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd"> ]]>
	</jsp:text>
	<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
	<title>Example Lotto 4 - Result</title>
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
			<jsp:scriptlet>lotto.setMyNumbers(getMyNumbers(request));</jsp:scriptlet>
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
</jsp:root>