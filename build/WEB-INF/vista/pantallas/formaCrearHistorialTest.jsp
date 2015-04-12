    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt" %>
    <%@ taglib uri="/WEB-INF/vista/etiquetas/struts-html.tld" prefix="html" %>
    <%@ page contentType="text/html;charset=UTF-8" language="java" %>
<style>
  .HipervinculoAdmon{
    color:#000000;
	text-decoration:none;
  }
  
  .HipervinculoAdmon:hover{
    color:#006666;
	text-decoration:underline;
  }
</style>

   
      <div class="table" style="width:100%"  id="tablecontent">
          <div class="tr enlaces" style="background:#CCCCCC">
           <div class="td" style="width:16%"><b id="nombre">
            <fmt:message key="formaListadoTest.etiqueta.nombre" /></b></div>
          </div>
          <%
          int contar = 0; 
          int i=0;  //index arreglo de preguntas
          int j=0;  //index arreglo respuestas
          %>
          <c:forEach var="historiatest" items="${formaCrearHistorialTest.historiatest}">
              <div class="tr">
                <div class="td" align="left" style="width:20%" ><c:out value="${historiatest.nombre}"/></div>
                <div class="td" align="left" style="width:20%" ><c:out value="${historiatest.pregunta}"/></div>
                <div class="td" align="left" style="width:20%" ><c:out value="${historiatest.respuesta}"/></div>
                <c:if test="${historiatest.idr == historiatest.idrc}">
                   <div class="td" align="left" style="width:20%" >Respuesta Correcta</div>
                </c:if>
                <c:if test="${historiatest.idr != historiatest.idrc}">
                   <div class="td" align="left" style="width:20%" >Respuesta Incorrecta</div>
                </c:if>
              </div>
          </c:forEach>
          <div class="tr">
              <div class="td" colspan="4" align="right" style="padding-top:25px;"><b>Total:</b> ${formaCrearHistorialTest.contador}</div>
          </div>
      </div>