<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>

<script type = "text/javascript">
	function validate() {
		var invalid = /^[\w ]+$/;
		
		if (document.editItem.game.value == "" || !invalid.test(document.editItem.game.value)) {
			alert("Invalid character or game name is empty!");
			document.editItem.game.focus();
			return false;
		}
		var invalid = /^[\w ]+$/;
		
		if (document.editItem.year.value == "" || isNaN(document.editItem.year.value)) {
			alert("Year not a number or year field is empty!");
			document.editItem.year.focus();
			return false;
		}
		
		return true;
	}
</script>

<meta charset="ISO-8859-1">
<title>Edit Page</title>
</head>
<body>
<form name = "editItem" onsubmit = "return(validate());" action = "editItemServlet" method="post">
Game: <input type = "text" name = "game" value= "${itemToEdit.game}">
Year: <input type = "text" name = "year" value= "${itemToEdit.year}">
<input type = "hidden" name = "id" value="${itemToEdit.id}">
<input type = "submit" value="Save Edited Item">
</form>
</body>
</html>