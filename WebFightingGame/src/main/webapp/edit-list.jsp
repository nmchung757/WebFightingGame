<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>

<script type = "text/javascript">
	function validate() {
		var invalid = /^[\w ]+$/;
		
		if (document.editList.listName.value == "" || !invalid.test(document.editList.listName.value)) {
			alert("Invalid character or list name is empty!");
			document.editList.listName.focus();
			return false;
		}
		var invalid = /^[\w ]+$/;
		
		if (document.editList.developerName.value == "" || !invalid.test(document.editList.developerName.value)) {
			alert("Invalid character or developer name is empty!");
			document.editList.developerName.focus();
			return false;
		}
		
		return true;
	}
</script>

<meta charset="ISO-8859-1">
<title>Edit An Existing List</title>
</head>
<body>
<form name = "editList" onsubmit = "return(validate());" action = "editListDetailsServlet" method="post">
<input type ="hidden" name = "id" value= "${listToEdit.id}">
List Name: <input type ="text" name = "listName" value= "${listToEdit.listName}"><br />
Developer Name: <input type = "text" name = "developerName" value="${listToEdit.developer.developerName}"><br />

Available Items:<br />

<select name="allItemsToAdd" multiple size="6">
<c:forEach items="${requestScope.allItems}" var="currentitem">
	<option value = "${currentitem.id}">${currentitem.game} | ${currentitem.year}</option>
</c:forEach>
</select>
<br />
<input type = "submit" value="Edit List and Add Items">
</form>
<a href = "index.html">Go add new items instead.</a>
</body>
</html>