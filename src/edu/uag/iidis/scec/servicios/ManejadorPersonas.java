package edu.uag.iidis.scec.servicios;

import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import edu.uag.iidis.scec.modelo.Persona;
import edu.uag.iidis.scec.excepciones.*;
import edu.uag.iidis.scec.persistencia.PersonaDAO;
import edu.uag.iidis.scec.persistencia.hibernate.*;

public class ManejadorPersonas {
    private Log log = LogFactory.getLog(ManejadorRoles.class);
    private PersonaDAO dao;

    public ManejadorPersonas() {
        dao = new PersonaDAO();
    }


    public Collection listarPersonas() {
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

    public Collection listarPersonasOrd(String tipo, int tipoInt) {

        Collection resultado;

        try {
            HibernateUtil.beginTransaction();
            resultado = dao.ordenarPor(tipo, tipoInt);
            HibernateUtil.commitTransaction();

              if (log.isDebugEnabled()) {
            log.debug("***Manejador personas ordenar: ok");
        }

            return resultado;         
       
        } catch (ExcepcionInfraestructura e) {
             if (log.isDebugEnabled()) {
            log.debug("***Manejador personas ordenar: failed");
        }
            HibernateUtil.rollbackTransaction();
            return null;
        } finally {
            HibernateUtil.closeSession();
        }
    }

    public void eliminarPersona(Long id) {
        if (log.isDebugEnabled()) {
            log.debug(">eliminarPersona(persona)");
        }
        try {
            HibernateUtil.beginTransaction();           
            Persona persona = dao.buscarPorId(id, true);
            if (persona != null) {
              dao.hazTransitorio(persona);
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

    public int crearPersona(Persona persona) {

        int resultado;

        if (log.isDebugEnabled()) {
            log.debug(">guardarPersona(persona)");
        }

        try {
            HibernateUtil.beginTransaction();           
            
            if (dao.existePersona(persona.getNombres())) {
               resultado = 1; // Excepción. El nombre de persona ya existe
            } else {

               dao.hazPersistente(persona);

               resultado = 0; // Exito. persona se creo satisfactoriamente.
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
