    <%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c' %>
    <%@ taglib uri='http://java.sun.com/jstl/fmt' prefix='fmt' %>
    <%@ taglib uri='/WEB-INF/vista/etiquetas/struts-html.tld' prefix='html' %>
    <%@ page contentType="text/html;charset=UTF-8" language="java" %>

    <option>Elegir Seccion</option>
    <c:forEach var="pregunta" items="${formaListadoPreguntasOpcion.pregunta}">
		<option value="<c:out value='${pregunta.id}'/>"><c:out value="${pregunta.pregunta}"/></option>
	</c:forEach>