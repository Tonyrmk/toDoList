<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<meta charset="UTF-8">
<title>jsp file</title>
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">
</head>

<body>
	<div class="container">
		<form:form method="post" commandName="todo">
			<fieldset class="form-group">
				<form:label path="desc">Description</form:label>
				<form:input path="desc" type="text" class="form-control"
				required="required"/>
	            <form:errors path="desc" cssClass="text-warning"/>

			</fieldset>

			           <fieldset class="form-group">
            				<form:label path="targetDate">Date</form:label>
            				<form:input path="targetDate" type="text" class="form-control"
            				required="required"/>
            	            <form:errors path="targetDate" cssClass="text-warning"/>

            			</fieldset>

             <fieldset class="form-group">
                        				<form:label path="done">Status</form:label>
                        				<form:input path="done" type="text" class="form-control"
                        				required="required"/>
                        	            <form:errors path="done" cssClass="text-warning"/>

                        			</fieldset>


			<button type="submit" class="btn btn-success">Add</button>
		</form:form>
	</div>

<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</body>
</html>

