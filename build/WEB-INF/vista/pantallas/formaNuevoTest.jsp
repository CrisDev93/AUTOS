    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt" %>
    <%@ taglib uri="/WEB-INF/vista/etiquetas/struts-html.tld" prefix="html" %>
    <%@ page contentType="text/html;charset=UTF-8" language="java" %>


    <br>
    

    <div id="test">
      <form action="procesarRegistroTest.do" method="post">
      <h1>Nuevo Test</h1>
      <input type="text" name="nombre" placeholder="Nombre Test" value="${formaNuevoTest.nombre}"/><br><br>
      <input type="submit" value="Nuevo Test" class="envio" /><br><br>
      </form>
    </div>