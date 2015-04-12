package edu.uag.iidis.scec.servicios;

import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import edu.uag.iidis.scec.modelo.Pregunta;
import edu.uag.iidis.scec.excepciones.*;
import edu.uag.iidis.scec.persistencia.PreguntaDAO;
import edu.uag.iidis.scec.persistencia.hibernate.*;

public class ManejadorPreguntas {
    private Log log = LogFactory.getLog(ManejadorRoles.class);
    private PreguntaDAO dao;

    public ManejadorPreguntas() {
        dao = new PreguntaDAO();
    }


    public Collection listarPreguntas() {
        Collection resultado;

        if (log.isDebugEnabled()) {
            log.debug(">guardarUsuario(usuario)");
        }

        try {
            HibernateUtil.beginTransaction();
            resultado = dao.buscarTodos();
            HibernateUtil.commitTransaction();
            return resultado;         
        } catch (ExcepcionInfraestructura e) {
            HibernateUtil.rollbackTransaction();
            return null;
        } finally {
            HibernateUtil.closeSession();
        }
    }

    public Collection buscarPreguntasSeccion(Long preguntaBuscar) {
        Collection resultado;

        if (log.isDebugEnabled()) {
            log.debug(">***Buscar Seccion:"+preguntaBuscar);
        }

        try {
            HibernateUtil.beginTransaction();
            resultado = dao.buscarPorSeccion(preguntaBuscar);
            HibernateUtil.commitTransaction();
            log.debug(">***Saliendo de manejadorPreguntas");
            return resultado;         
        } catch (ExcepcionInfraestructura e) {
            HibernateUtil.rollbackTransaction();
            return null;
        } finally {
            HibernateUtil.closeSession();
        }
    }

/*
    public Collection listarPreguntasOrd(String tipo, int tipoInt) {

        Collection resultado;

        try {
            HibernateUtil.beginTransaction();
            resultado = dao.ordenarPor(tipo, tipoInt);
            HibernateUtil.commitTransaction();

              if (log.isDebugEnabled()) {
            log.debug("***Manejador Preguntas ordenar: ok");
        }

            return resultado;         
       
        } catch (ExcepcionInfraestructura e) {
             if (log.isDebugEnabled()) {
            log.debug("***Manejador Preguntas ordenar: failed");
        }
            HibernateUtil.rollbackTransaction();
            return null;
        } finally {
            HibernateUtil.closeSession();
        }
    }*/

    public void eliminarPregunta(Long id) {
        if (log.isDebugEnabled()) {
            log.debug(">eliminarPregunta(Pregunta)");
        }
        try {
            HibernateUtil.beginTransaction();           
            Pregunta pregunta = dao.buscarPorId(id, true);
            if (pregunta != null) {
              dao.hazTransitorio(pregunta);
            }
            HibernateUtil.commitTransaction();
        } catch (ExcepcionInfraestructura e) {
            HibernateUtil.rollbackTransaction();
            if (log.isWarnEnabled()) {
                log.warn("<ExcepcionInfraestructura");
            }
        } finally {
            HibernateUtil.closeSession();
        }

    }

    public int crearPregunta(Pregunta pregunta) {

        int resultado;

        if (log.isDebugEnabled()) {
            log.debug(">guardarPregunta(Pregunta)");
        }

        try {
            HibernateUtil.beginTransaction();           
            
            if (dao.existePregunta(pregunta.getPregunta())) {
               resultado = 1; // Excepción. El nombre de Pregunta ya existe
            } else {

               dao.hazPersistente(pregunta);

               resultado = 0; // Exito. Pregunta se creo satisfactoriamente.
            }

            HibernateUtil.commitTransaction();

        } catch (ExcepcionInfraestructura e) {
            HibernateUtil.rollbackTransaction();

            if (log.isWarnEnabled()) {
                log.warn("<ExcepcionInfraestructura");
            }
            resultado = 2;    // Excepción. Falla en la infraestructura
        } finally {
            HibernateUtil.closeSession();
        }
        return resultado;
    }    
}
