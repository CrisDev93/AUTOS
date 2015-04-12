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
          <form action="procesarCrearTest.do">

            <input type="text" name="name" placeholder="Escriba su nombre" value="${formaCrearTest.name}"> 
          <%
          int contar = 0; boolean aux=true;
          int i=0;  //index arreglo de preguntas
          %>
          <c:forEach var="test" items="${formaCrearTest.test}">
          <% if(aux){%>
              <input type="hidden" name="idTest" value="<c:out value='${test.idt}'/>"> 
           <% aux=false;}%>

            <%
            if (contar == 0) { %>
              <div class="tr">
                  <div class="td" align="left" style="width:20%" ><c:out value="${test.pregunta}"/></div>
                  <input type="hidden" name="preguntas[<%=i%>]" value="<c:out value='${test.idp}'/>"/> 
              </div>
              <select name="respuestas[<%=i%>]">
                <option>Elige la respuesta correcta</option>
            <% } %>
                  <option value="<c:out value='${test.idr}'/>" ><c:out value="${test.respuesta}"/></option>
            <%
            contar++;
            if (contar == 3) { %>
              </select>
            <% contar = 0;i++;
            }  %>
          </c:forEach>
          <div class="tr">
              <div class="td" colspan="4" align="right" style="padding-top:25px;"><b>Total:</b> ${formaListadoTest.contador}</div>
          </div>
          <input type="submit" value="Enviar" class="envio" />
        </form>
      </div>