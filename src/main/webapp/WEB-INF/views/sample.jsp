<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<fmt:requestEncoding value="UTF-8" />

<!doctype html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>whyNot SAMPLE</title>
<script src="https://code.jquery.com/jquery-3.2.1.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
	});
</script>
</head>
<body>
	<div>
		<table border="1">
			<tr>
				<th colspan="3">SAMPLE : MODEL</th>
			</tr>
			<c:forEach items="${sample }" var="sam" varStatus="status">
				<!-- .index는 0부터 시작하고 .count는 1부터 시작한다. -->
				<tr>
					<td>&nbsp;${status.count}&nbsp;</td>
					<td>&nbsp;${sam.model}</td>
					<td>&nbsp;${sample[status.index]}</td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<div>
		<h3>삼성 DB변환</h3>
		<h3></h3>
	</div>

</body>
</html>