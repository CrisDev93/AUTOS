package edu.uag.iidis.scec.persistencia;

import org.hibernate.*;
import org.hibernate.type.*;
import org.hibernate.criterion.Example;
//import org.hibernate.classic.*;


import edu.uag.iidis.scec.excepciones.ExcepcionInfraestructura;
import edu.uag.iidis.scec.modelo.Seccion;
import edu.uag.iidis.scec.persistencia.hibernate.HibernateUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.Collection;
import java.util.List;


public class SeccionDAO {

    private Log log = LogFactory.getLog(SeccionDAO.class);

    public SeccionDAO() {
    }


    public Seccion buscarPorId(Long idSeccion, boolean bloquear)
            throws ExcepcionInfraestructura {

        Seccion seccion = null;

        if (log.isDebugEnabled()) {
            log.debug(">buscarPorID(" + idSeccion + ", " + bloquear + ")");
        }

        try {
            if (bloquear) {
                seccion = (Seccion)HibernateUtil.getSession()
                                                .load(Seccion.class, 
                                                      idSeccion, 
                                                      LockMode.UPGRADE);
            } else {
                seccion = (Seccion)HibernateUtil.getSession()
                                                .load(Seccion.class,
                                                      idSeccion);
            }
        } catch (HibernateException ex) {
            if (log.isWarnEnabled()) {
                log.warn("<HibernateException");
            }

            throw new ExcepcionInfraestructura(ex);
        }
        return seccion;
    }


    public Collection buscarTodos()
            throws ExcepcionInfraestructura {

        Collection secciones;

        if (log.isDebugEnabled()) {
            log.debug(">buscarTodos()");
        }

        try {
            secciones = HibernateUtil.getSession()
                                    .createCriteria(Seccion.class)
                                    .list();
									
			  log.debug(">buscarTodos() ---- list	");									
        } catch (HibernateException e) {
            if (log.isWarnEnabled()) {
                log.warn("<HibernateException");
            }
            throw new ExcepcionInfraestructura(e);
        }
        return secciones;
    }


    public Collection buscarPorEjemplo(Seccion seccion)
            throws ExcepcionInfraestructura {


        Collection secciones;
 
        if (log.isDebugEnabled()) {
            log.debug(">buscarPorEjemplo()");
        }

        try {
            Criteria criteria = HibernateUtil.getSession()
                                             .createCriteria(Seccion.class);
            secciones = criteria.add(Example.create(seccion)).list();
        } catch (HibernateException e) {
            if (log.isWarnEnabled()) {
                log.warn("<HibernateException");
            }
            throw new ExcepcionInfraestructura(e);
        }
        return secciones;
    }


    public void hazPersistente(Seccion seccion)
            throws ExcepcionInfraestructura {

        if (log.isDebugEnabled()) {
            log.debug(">hazPersistente(Seccion)");
        }

        try {
            HibernateUtil.getSession().saveOrUpdate(seccion);
        } catch (HibernateException e) {
            if (log.isWarnEnabled()) {
                log.warn("<HibernateException");
            }
            throw new ExcepcionInfraestructura(e);
        }
    }


    public void hazTransitorio(Seccion seccion)
            throws ExcepcionInfraestructura {

        if (log.isDebugEnabled()) {
            log.debug(">hazTransitorio(Seccion)");
        }

        try {
            HibernateUtil.getSession().delete(seccion);
        } catch (HibernateException e) {
            if (log.isWarnEnabled()) {
                log.warn("<HibernateException");
            }
            throw new ExcepcionInfraestructura(e);
        }
    }
    public Collection buscarPorNombre(String nombreSeccion)
            throws ExcepcionInfraestructura {

        Collection secciones;


        try {
            
            String hql = "select nombre from Test where nombre = :nombre";
            
             if (log.isDebugEnabled()) {
                 log.debug(hql + nombreSeccion);
            }
        
            Query query = HibernateUtil.getSession()
                                        .createQuery(hql);
            

            query.setParameter("nombre", nombreSeccion);

            
            if (log.isDebugEnabled()) {
                 log.debug("  ***query:   "+hql );
            }

            secciones = query.list();

            return secciones;

        } catch (HibernateException ex) {
            if (log.isWarnEnabled()) {
                log.warn("<HibernateException *******************");
            }
            throw new ExcepcionInfraestructura(ex);
        }
    }

    public Collection buscarPorTest(Long idp)
            throws ExcepcionInfraestructura {
               
        Collection secciones;


        try {
            
            String hql = "from Seccion where idTest = :id";
            
             if (log.isDebugEnabled()) {
                 log.debug(hql + idp);
            }
        
            Query query = HibernateUtil.getSession()
                                        .createQuery(hql);
            

            query.setParameter("id", idp);

            
            if (log.isDebugEnabled()) {
                 log.debug("  ***query:   "+hql );
            }

            secciones = query.list();

            return secciones;

        } catch (HibernateException ex) {
            if (log.isWarnEnabled()) {
                log.warn("<HibernateException *******************");
                ex.printStackTrace();
            }
            throw new ExcepcionInfraestructura(ex);
        }
    }

    public boolean existeSeccion(String nombreSeccion)
            throws ExcepcionInfraestructura {

        if (log.isDebugEnabled()) {
            log.debug("existeSeccion");
        }

        try {
 
			String hql = "select nombre from Seccion where nombre = :nombre";
			
			 if (log.isDebugEnabled()) {
           		 log.debug(hql + nombreSeccion);
        	}
		
			Query query = HibernateUtil.getSession()
										.createQuery(hql);
			if (log.isDebugEnabled()) {
           		 log.debug("<<<<<<<<< create query ok " );
        	}

			query.setParameter("nombre", nombreSeccion);
			if (log.isDebugEnabled()) {
           		 log.debug("<<<<<<<<< set Parameter ok antes del query list >>>>>");
        	}
			List results = query.list();
			int resultado = results.size();
			if (log.isDebugEnabled()) {
           		 log.debug("<<<<<<<<< Result size " + resultado);
        	}
            if (resultado == 0) {
               return false;
            }
            
            return true;

        } catch (HibernateException ex) {
            if (log.isWarnEnabled()) {
                log.warn("<HibernateException *******************");
            }
            throw new ExcepcionInfraestructura(ex);
        }
    }


}
