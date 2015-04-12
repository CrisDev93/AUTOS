    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt" %>
    <%@ taglib uri="/WEB-INF/vista/etiquetas/struts-html.tld" prefix="html" %>
    <%@ page contentType="text/html;charset=UTF-8" language="java" %>


    <br>
    <font size='5'><fmt:message key="formaNuevaPersona.titulo" /></font>

    <form id="forma" action="procesarRegistroPersona.do" method="post">
        <div class="table">
            <div class="tr">
                <div class="td" colspan="2">
                   <html:errors />
                </div>
            </div>
            <div class="tr">
                <div class="td" align="right">
                    <fmt:message key="formaNuevaPersona.etiqueta.nombres" />
                </div>
                <div class="td" align="left">
                    <input type="text" 
                           name="nombres" 
                           size="50" 
                           maxlength="100" 
                           value="${formaNuevaPersona.nombres}" />
                </div>
            </div>
            <div class="tr">
                <div class="td" align="right">
                    <fmt:message key="formaNuevaPersona.etiqueta.apellidos" />
                </div>
                <div class="td" align="left">
                    <input type="text" 
                           name="apellidos" 
                           size="50" 
                           maxlength="100" 
                           value="${formaNuevaPersona.apellidos}" />
                </div>
            </div>
            <div class="tr">
                <div class="td" align="right">
                    <fmt:message key="formaNuevaPersona.etiqueta.direccion" />
                </div>
                <div class="td" align="left">
                    <input type="text" 
                           name="direccion" 
                           size="50" 
                           maxlength="100" 
                           value="${formaNuevaPersona.direccion}" />
                </div>
            </div>
            <div class="tr">
                <div class="td" align="right">
                    <fmt:message key="formaNuevaPersona.etiqueta.telefono" />
                </div>
                <div class="td" align="left">
                    <input type="text" 
                           name="telefono" 
                           size="50" 
                           maxlength="100" 
                           value="${formaNuevaPersona.telefono}" />
                </div>
            </div>
            <div class="tr">
                <div class="td" align="right">
                    <fmt:message key="formaNuevaPersona.etiqueta.ciudad" />
                </div>
                <div class="td" align="left" style="position:relative">
                    <input type="text" 
                           id ="ciudadBuscar" autocomplete="off" />
                    <div class="buscar">
                      <ul>
                      </ul>
                    </div>
                    <input type="text" 
                           id="idCiudad"
                           name="idCiudad" 
                           size="50" 
                           style="display:none"
                           maxlength="100" />
                  
              <!--      <select name="idCiudad" >
                      <c:forEach var="ciudad" items="${formaNuevaPersona.ciudades}">
                        <option value='<c:out value="${ciudad.id}" />'><c:out value="${ciudad.nombre}" /></option>
                      </c:forEach>
                    </select>
                -->
                </div>
            </div>
            <div class="tr">
                <div class="td" align="right">
                    <fmt:message key="formaNuevaPersona.etiqueta.estado" />
                </div>
                <div class="td" align="left" style="position:relative">
                    <div id="estadoNombre"></div>
                </div>
            </div>
            <div class="tr">
                <div class="td" style="width:400px;" align="center">
                    <input type="submit" 
                           name="submit"
                           value="Agregar y terminar"/>
                    <input type="submit" 
                           name="submit"
                           value="Agregar y volver"
                           onclick="forma.action='procesarRegistroPersona.do?volver=si'"/>
                    <input type="button"
                           value="Reset"
                           onclick="location.href='solicitarRegistroPersona.do'" />
                    <input type="submit" 
                           name="org.apache.struts.taglib.html.CANCEL" 
                           value="cancelar" 
                           onclick="bCancel=true;">    
                </div>
            </div>
        </div>
    </form>