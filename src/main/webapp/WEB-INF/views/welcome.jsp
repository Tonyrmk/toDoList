<%@include file="common/header.jspf"%>
<%@include file="common/navigation.jspf"%>
<div class="container">
<h1>Welcome ${userName}</h1></br>
<h1>Chose your language <h2>
<li><a href="/?language=en">EN</a></li>
<li><a href="/?language=ua">UA</a></li>
</br>
<h2> <caption> <spring:message code="youCan.caption"/></caption>
 <a href="/list-todos">ToDos</a>
 <caption><spring:message code="list.caption"/></caption></h2>
<h2>просто текст</h2>
</div>

<%@include file="common/footer.jspf"%>