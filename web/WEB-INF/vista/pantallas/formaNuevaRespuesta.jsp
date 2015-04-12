    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt" %>
    <%@ taglib uri="/WEB-INF/vista/etiquetas/struts-html.tld" prefix="html" %>
    <%@ page contentType="text/html;charset=UTF-8" language="java" %>


    <div id="pregunta">
      <form action="procesarRegistroRespuesta.do" method="post">
      <h1>Nueva Respuesta</h1>
      <select id="seleccionar" name="idTest" onchange="listaSecciones()">
        <option>Elegir Test</option>
        <c:forEach var="test" items="${formaNuevaRespuesta.test}">
            <option value='<c:out value="${test.id}"/>'><c:out value="${test.nombre}"/></option>
        </c:forEach>
      </select>
      <br><br>
      <select id="seleccionaropcion" name="idSeccion" onchange="listaPreguntas()">
        <option>Elegir Seccion</option>
      </select>
      <br><br>
      <select id="seleccionaropcionpregunta" name="idPregunta">
        <option></option>
      </select>
      <br><br>
      <input type="text" name="respuesta" class="pregunta" placeholder="Respuesta">
      <select name="correcta" value="formaNuevaRespuesta.correcta">
        <option value="false">Incorrecta</option>
        <option value="true">Correcta</option>
      </select>
      <br><br>

      <input type="submit" value="Nueva Respuesta" class="envio" /><br><br>
      </form>
    </div>