<html>
<body>
<form method="post" action="./feedback/">
	<label>Product name </label>
	<input type="text" name="prodcutName">
	<br>
	<br>
	<label> User name</label>
	<input type="text" name="userName">
	<br>
	<br>
	<label>Ratings</label>
	<input type="number" min=1 max=5 step=1 name="starRating">
	<br>
	<br>
	<label>Feedback</label>
	<input type="text" name="feedbackMsg">
	<br>
	<br>
	<input type="submit" value="submit">
</form>
</body>
</html>
