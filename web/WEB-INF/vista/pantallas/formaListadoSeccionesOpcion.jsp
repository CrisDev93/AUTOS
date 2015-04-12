    <%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c' %>
    <%@ taglib uri='http://java.sun.com/jstl/fmt' prefix='fmt' %>
    <%@ taglib uri='/WEB-INF/vista/etiquetas/struts-html.tld' prefix='html' %>
    <%@ page contentType="text/html;charset=UTF-8" language="java" %>

    <option>Elegir Seccion</option>
    <c:forEach var="test" items="${formaListadoSeccionesOpcion.seccion}">
		<option value="<c:out value='${test.id}'/>"><c:out value="${test.nombre}"/></option>
	</c:forEach>