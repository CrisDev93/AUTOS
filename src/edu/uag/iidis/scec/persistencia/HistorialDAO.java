package edu.uag.iidis.scec.persistencia;

import org.hibernate.*;
import org.hibernate.type.*;
import org.hibernate.criterion.Example;
//import org.hibernate.classic.*;


import edu.uag.iidis.scec.excepciones.ExcepcionInfraestructura;
import edu.uag.iidis.scec.modelo.Historial;
import edu.uag.iidis.scec.modelo.Pregunta;
import edu.uag.iidis.scec.persistencia.hibernate.HibernateUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.Collection;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;


public class HistorialDAO {

    private Log log = LogFactory.getLog(HistorialDAO.class);

    public HistorialDAO() {
    }


    public Historial buscarPorId(Long idHistorial, boolean bloquear)
            throws ExcepcionInfraestructura {

        Historial historial = null;

        if (log.isDebugEnabled()) {
            log.debug(">buscarPorID(" + idHistorial + ", " + bloquear + ")");
        }

        try {
            if (bloquear) {
                historial = (Historial)HibernateUtil.getSession()
                                                .load(Historial.class, 
                                                      idHistorial, 
                                                      LockMode.UPGRADE);
            } else {
                historial = (Historial)HibernateUtil.getSession()
                                                .load(Historial.class,
                                                      idHistorial);
            }
        } catch (HibernateException ex) {
            if (log.isWarnEnabled()) {
                log.warn("<HibernateException");
            }

            throw new ExcepcionInfraestructura(ex);
        }
        return historial;
    }


    public Collection buscarTodos()
            throws ExcepcionInfraestructura {

        Collection historiales;

        if (log.isDebugEnabled()) {
            log.debug(">buscarTodos()");
        }

        try {
            historiales = HibernateUtil.getSession()
                                    .createCriteria(Historial.class)
                                    .list();
									
			  log.debug(">buscarTodos() ---- list	");									
        } catch (HibernateException e) {
            if (log.isWarnEnabled()) {
                log.warn("<HibernateException");
            }
            throw new ExcepcionInfraestructura(e);
        }
        return historiales;
    }


    public Collection buscarPorEjemplo(Historial historial)
            throws ExcepcionInfraestructura {


        Collection historiales;
 
        if (log.isDebugEnabled()) {
            log.debug(">buscarPorEjemplo()");
        }

        try {
            Criteria criteria = HibernateUtil.getSession()
                                             .createCriteria(Historial.class);
            historiales = criteria.add(Example.create(historial)).list();
        } catch (HibernateException e) {
            if (log.isWarnEnabled()) {
                log.warn("<HibernateException");
            }
            throw new ExcepcionInfraestructura(e);
        }
        return historiales;
    }


    public void hazPersistente(Historial historial)
            throws ExcepcionInfraestructura {

        if (log.isDebugEnabled()) {
            log.debug(">hazPersistente(Historial)");
        }

        try {
            HibernateUtil.getSession().saveOrUpdate(historial);
        } catch (HibernateException e) {
            if (log.isWarnEnabled()) {
                log.warn("<HibernateException");
            }
            throw new ExcepcionInfraestructura(e);
        }
    }


    public void hazPersistentes(ArrayList historiales)
            throws ExcepcionInfraestructura {
                PreguntaDAO dao=new PreguntaDAO();
                Long aux=null;
        if (log.isDebugEnabled()) {
            log.debug(">hazPersistentes(Historial)");
        }

        try {
            Iterator<Historial> it=historiales.iterator();
        while(it.hasNext()){
            Historial historial=it.next();
            Pregunta pregunta=dao.buscarPorId(historial.getidPregunta(),true);
            if(pregunta.getIdRespuestaCorrecta().equals(historial.getidRespuesta())){
                    aux=new Long("1");
            }else{  aux=new Long("0");}
            historial.setResultado(aux);
            HibernateUtil.getSession().saveOrUpdate(historial);
        }
           
        } catch (HibernateException e) {
            if (log.isWarnEnabled()) {
                log.warn("<HibernateException"+e.getMessage());
            }
            throw new ExcepcionInfraestructura(e);
        }
    }


    public void hazTransitorio(Historial Historial)
            throws ExcepcionInfraestructura {

        if (log.isDebugEnabled()) {
            log.debug(">hazTransitorio(Historial)");
        }

        try {
            HibernateUtil.getSession().delete(Historial);
        } catch (HibernateException e) {
            if (log.isWarnEnabled()) {
                log.warn("<HibernateException");
            }
            throw new ExcepcionInfraestructura(e);
        }
    }

    
   

}
