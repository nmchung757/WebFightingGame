<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>

<script type = "text/javascript">
	function validate() {
		var invalid = /^[\w ]+$/;
		
		if (document.newList.listName.value == "" || !invalid.test(document.newList.listName.value)) {
			alert("Invalid character or list name is empty!");
			document.newList.listName.focus();
			return false;
		}
		var invalid = /^[\w ]+$/;
		
		if (document.newList.developerName.value == "" || !invalid.test(document.newList.developerName.value)) {
			alert("Invalid character or developer name is empty!");
			document.newList.developerName.focus();
			return false;
		}
		
		return true;
	}
</script>

<meta charset="ISO-8859-1">
<title>Create a new list</title>
</head>
<body>
<form name = "newList" onsubmit = "return(validate());" action = "createNewListServlet" method="post">
List Name: <input type = "text" name = "listName"><br />
Developer Name: <input type = "text" name = "developerName"><br />

Available Items:<br />
<select name="allItemsToAdd" multiple size="6">
<c:forEach items="${requestScope.allItems}" var="currentitem">
	<option value = "${currentitem.id}">${currentitem.game} | ${currentitem.year}</option>
</c:forEach>
</select>
<br />
<input type = "submit" value="Create Lists and Add Items">
</form>
<a href = "index.html">Go add new items instead.</a>
</body>
</html>