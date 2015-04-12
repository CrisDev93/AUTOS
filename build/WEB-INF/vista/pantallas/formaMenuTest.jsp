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

</script>
    <div id="seleccion">
        <div id="menu">
            <a href="irNuevos.do"><p><fmt:message key="formaMenuTest.etiqueta.nuevotest" /></p></a>
            <a href="solicitarListarTest.do"><p><fmt:message key="formaMenuTest.etiqueta.listatest" /></p></a>
        </div>
    </div>