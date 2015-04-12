    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt" %>
    <%@ taglib uri="/WEB-INF/vista/etiquetas/struts-html.tld" prefix="html" %>
    <%@ page contentType="text/html;charset=UTF-8" language="java" %>

    <br>
    <div id="seccion">
      <form action="procesarRegistroSeccion.do" method="post">
      <h1>Nueva Sección</h1>
      <select name="idTest" value="formaNuevaSeccion.idTest">
        <c:forEach var="test" items="${formaNuevaSeccion.test}">
            <option value='<c:out value="${test.id}"/>'><c:out value="${test.nombre}"/></option>
        </c:forEach>
      </select>
      <br><br>
      <input type="text" name="nombre" placeholder="Nombre Sección" value="${formaNuevaSeccion.nombre}"/><br><br>
      <input type="submit" value="Agregar Sección" class="envio" /><br><br>
      </form>
    </div>