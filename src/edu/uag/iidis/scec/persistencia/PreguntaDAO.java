package edu.uag.iidis.scec.persistencia;

import org.hibernate.*;
import org.hibernate.type.*;
import org.hibernate.criterion.Example;
//import org.hibernate.classic.*;


import edu.uag.iidis.scec.excepciones.ExcepcionInfraestructura;
import edu.uag.iidis.scec.modelo.Pregunta;
import edu.uag.iidis.scec.persistencia.hibernate.HibernateUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.Collection;
import java.util.List;


public class PreguntaDAO {

    private Log log = LogFactory.getLog(PreguntaDAO.class);

    public PreguntaDAO() {
    }

    public Collection buscarPorSeccion(Long idp)
            throws ExcepcionInfraestructura {
               
        Collection secciones;


        try {
            
            String hql = "from Pregunta where idSeccion = :id";
            
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


    public Pregunta buscarPorId(Long idPregunta, boolean bloquear)
            throws ExcepcionInfraestructura {

        Pregunta pregunta = null;

        if (log.isDebugEnabled()) {
            log.debug(">buscarPorID(" + idPregunta + ", " + bloquear + ")");
        }

        try {
            if (bloquear) {
                pregunta = (Pregunta)HibernateUtil.getSession()
                                                .load(Pregunta.class, 
                                                      idPregunta, 
                                                      LockMode.UPGRADE);
            } else {
                pregunta = (Pregunta)HibernateUtil.getSession()
                                                .load(Pregunta.class,
                                                      idPregunta);
            }
        } catch (HibernateException ex) {
            if (log.isWarnEnabled()) {
                log.warn("<HibernateException");
            }

            throw new ExcepcionInfraestructura(ex);
        }
        return pregunta;
    }


    public Collection buscarTodos()
            throws ExcepcionInfraestructura {

        Collection preguntas;

        if (log.isDebugEnabled()) {
            log.debug(">buscarTodos()");
        }

        try {
            preguntas = HibernateUtil.getSession()
                                    .createCriteria(Pregunta.class)
                                    .list();
									
			  log.debug(">buscarTodos() ---- list	");									
        } catch (HibernateException e) {
            if (log.isWarnEnabled()) {
                log.warn("<HibernateException");
            }
            throw new ExcepcionInfraestructura(e);
        }
        return preguntas;
    }


    public Collection buscarPorEjemplo(Pregunta pregunta)
            throws ExcepcionInfraestructura {
        Collection preguntas;
 
        if (log.isDebugEnabled()) {
            log.debug(">buscarPorEjemplo()");
        }

        try {
            Criteria criteria = HibernateUtil.getSession().createCriteria(Pregunta.class);
            preguntas = criteria.add(Example.create(pregunta)).list();
        } catch (HibernateException e) {
            if (log.isWarnEnabled()) {
                log.warn("<HibernateException");
            }
            throw new ExcepcionInfraestructura(e);
        }
        return preguntas;
    }


    public void hazPersistente(Pregunta pregunta)
            throws ExcepcionInfraestructura {

        if (log.isDebugEnabled()) {
            log.debug(">hazPersistente(Pregunta)");
        }

        try {
            HibernateUtil.getSession().saveOrUpdate(pregunta);
        } catch (HibernateException e) {
            if (log.isWarnEnabled()) {
                log.warn("<HibernateException");
            }
            throw new ExcepcionInfraestructura(e);
        }
    }


    public void hazTransitorio(Pregunta pregunta)
            throws ExcepcionInfraestructura {

        if (log.isDebugEnabled()) {
            log.debug(">hazTransitorio(Pregunta)");
        }

        try {
            HibernateUtil.getSession().delete(pregunta);
        } catch (HibernateException e) {
            if (log.isWarnEnabled()) {
                log.warn("<HibernateException");
            }
            throw new ExcepcionInfraestructura(e);
        }
    }

    public boolean existePregunta(String nombrePregunta)
            throws ExcepcionInfraestructura {

        if (log.isDebugEnabled()) {
            log.debug(">existePregunta(nombrePregunta)");
        }

        try {
			
			String hql = "select pregunta from Pregunta where pregunta = :Nombres";
			
			 if (log.isDebugEnabled()) {
           		 log.debug(hql + nombrePregunta);
        	}
		
			Query query = HibernateUtil.getSession()
										.createQuery(hql);
			if (log.isDebugEnabled()) {
           		 log.debug("<<<<<<<<< create query ok " );
        	}

			query.setParameter("Nombres", nombrePregunta);
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
                log.warn("<HibernateException *******************"+ex.getMessage());
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

   

}
