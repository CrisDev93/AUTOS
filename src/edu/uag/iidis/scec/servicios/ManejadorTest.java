package edu.uag.iidis.scec.servicios;

import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import edu.uag.iidis.scec.modelo.Test;
import edu.uag.iidis.scec.excepciones.*;
import edu.uag.iidis.scec.persistencia.TestDAO;
import edu.uag.iidis.scec.persistencia.hibernate.*;

public class ManejadorTest {
    private Log log = LogFactory.getLog(ManejadorTest.class);
    private TestDAO dao;

    public ManejadorTest() {
        dao = new TestDAO();
    }

    public Collection generarTest(Long id) {
        Collection resultado;

        if (log.isDebugEnabled()) {
            log.debug(">guardarUsuario(usuario)");
        }

        try {
            HibernateUtil.beginTransaction();
            resultado = dao.generarTest(id);
            HibernateUtil.commitTransaction();
            return resultado;         
        } catch (ExcepcionInfraestructura e) {
            HibernateUtil.rollbackTransaction();
            return null;
        } finally {
            HibernateUtil.closeSession();
        }
    }
    public Collection generarHistorialTest(Long id) {
        Collection resultado;

        if (log.isDebugEnabled()) {
            log.debug(">guardarUsuario(usuario)");
        }

        try {
            HibernateUtil.beginTransaction();
            resultado = dao.generarHistorialTest(id);
            HibernateUtil.commitTransaction();
            return resultado;         
        } catch (ExcepcionInfraestructura e) {
            HibernateUtil.rollbackTransaction();
            return null;
        } finally {
            HibernateUtil.closeSession();
        }
    }

    public Collection listarTest() {
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

    public void eliminarTest(Long id) {
        if (log.isDebugEnabled()) {
            log.debug(">eliminarTest(Test)");
        }
        try {
            HibernateUtil.beginTransaction();           
            Test test = dao.buscarPorId(id, true);
            if (test != null) {
              dao.hazTransitorio(test);
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

    public int crearTest(Test test) {

        int resultado;

        if (log.isDebugEnabled()) {
            log.debug(">guardarTest(Test)");
        }

        try {
            HibernateUtil.beginTransaction();           
            
            if (dao.existeTest(test.getNombre())) {
               resultado = 1; // Excepci�n. El nombre de rol ya existe
            } else {

               dao.hazPersistente(test);

               resultado = 0; // Exito. El rol se creo satisfactoriamente.
            }

            HibernateUtil.commitTransaction();

        } catch (ExcepcionInfraestructura e) {
            HibernateUtil.rollbackTransaction();

            if (log.isWarnEnabled()) {
                log.warn("<ExcepcionInfraestructura");
            }
            resultado = 2;    // Excepci�n. Falla en la infraestructura
        } finally {
            HibernateUtil.closeSession();
        }
        return resultado;
    }    
}
