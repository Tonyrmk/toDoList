
<%@include file="common/header.jspf"%>
<%@include file="common/navigation.jspf"%>

<div class="container">
<table class="table table-striped">
<caption> This is ${userName}'s' todos list</caption>
<caption> <spring:message code="todo.caption"/></caption>
<tr>
<th>Description</th>
<th>Date</th>
<th>Completed</th>
<th></th>
<th></th>
</tr>
<c:forEach items="${todos}" var="todo">
<tr>
<td>${todo.desc}</td>
<td><fmt:formatDate pattern="dd/MM/yyyy" value="${todo.targetDate}"/></td>
<td>${todo.done}</td>
<td><a href="/update-todo?id=${todo.id}" class="btn btn-info" value = "Update"/>Update</td>
<td><a href="/delete-todo?id=${todo.id}" class="btn btn-danger" value = "Delete"/>Delete</td>
</tr>
</c:forEach>
</table>


<div><a class = "btn btn-success" href="/add-todo">add new todo</a><div>
<%@include file="common/footer.jspf"%>