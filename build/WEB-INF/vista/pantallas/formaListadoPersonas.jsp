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
<script language="javascript" type="text/javascript">
<!--
  function EliminarPersona(PersonaName){
    return confirm("¿Desea eliminar la persona '" + PersonaName + "'?")
  }
-->
</script>
    <br>
    <font size='5'><fmt:message key="formaListadoPersonas.titulo" /></font>
   
      <div class="table" style="width:100%"  id="tablecontent">
          <div class="tr">
              <div class="td" colspan="4" style="padding-top:25px; padding-bottom:25px;">
                  <a href="solicitarRegistroPersona.do" class="HipervinculoAdmon boton">Agregar nueva persona</a>
              </div>
          </div>
          <div class="tr">
              <div class="td" colspan="4">
                 <html:errors />
              </div>
          </div>
          <div class="tr enlaces" style="background:#CCCCCC">
           <div class="td" style="width:16%"><b id="nombres" onclick="nombre()">
            <fmt:message key="formaListadoPersonas.etiqueta.nombres" /></b></div>
           <div class="td" style="width:16%"><b id="apellidos" onclick="apellido()">
            <fmt:message key="formaListadoPersonas.etiqueta.apellidos" /></b></div>
           <div class="td" style="width:16%"><b id="direccion" onclick="direccion()">
            <fmt:message key="formaListadoPersonas.etiqueta.direccion" /></b></div>
           <div class="td" style="width:16%"><b id="telefono" onclick="telefono()">
            <fmt:message key="formaListadoPersonas.etiqueta.telefono" /></b></div>
           <div class="td" style="width:16%"><b id="ciudad" onclick="telefono()">
            <fmt:message key="formaListadoPersonas.etiqueta.ciudad" /></b></div>
           
           <div class="td"  style="width:16%"><b><fmt:message key="formaListadoPersonas.etiqueta.administracion" /></b></div>
          </div>
          <c:forEach var="persona" items="${formaListadoPersonas.personas}">
              <div class="tr">
                  <div class="td" align="left" style="width:16%"><c:out value="${persona.nombres}"/></div>
                  <div class="td" align="left" style="width:16%"><c:out value="${persona.apellidos}"/></div>
                  <div class="td" align="left" style="width:16%"><c:out value="${persona.direccion}"/></div>
                  <div class="td" align="left" style="width:16%"><c:out value="${persona.telefono}"/></div>
                  <div class="td" align="left" style="width:16%">
                    <c:forEach var="ciudad" items="${formaListadoPersonas.ciudades}">
                      <c:if test="${ciudad.id == persona.idCiudad}">
                        <c:out value="${ciudad.nombre}"/>
                      </c:if>
                    </c:forEach>
                  </div>
                  <div class="td" align="left" style="width:16%">
               <!--       <a href='solicitarModificarPersona.do?id=<c:out value="${persona.id}"/>'
               class="HipervinculoAdmon">
                          <fmt:message key="formaListadoPersonas.etiqueta.modificar" />
                      </a>-->
                      <a href='procesarEliminarPersona.do?id=<c:out value="${persona.id}"/>'
               onClick="javascript: return EliminarPersona('<c:out value="${persona.nombres}"/>')"
               class="HipervinculoAdmon">
                          <fmt:message key="formaListadoPersonas.etiqueta.eliminar" />
                      </a>
                  </div>
              </div>
          </c:forEach>
          <div class="tr">
              <div class="td" colspan="4" align="right" style="padding-top:25px;"><b>Total:</b> ${formaListadoPersonas.contador}</div>
          </div>
      </div>
      