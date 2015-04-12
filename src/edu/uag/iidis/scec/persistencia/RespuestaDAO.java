package edu.uag.iidis.scec.persistencia;

import org.hibernate.*;
import org.hibernate.type.*;
import org.hibernate.criterion.Example;
//import org.hibernate.classic.*;


import edu.uag.iidis.scec.excepciones.ExcepcionInfraestructura;
import edu.uag.iidis.scec.modelo.Respuesta;
import edu.uag.iidis.scec.persistencia.hibernate.HibernateUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.Collection;
import java.util.List;
import java.util.Iterator;

public class RespuestaDAO {

    private Log log = LogFactory.getLog(RespuestaDAO.class);

    public RespuestaDAO() {
    }


    public Respuesta buscarPorId(Long idRespuesta, boolean bloquear)
            throws ExcepcionInfraestructura {

        Respuesta respuesta = null;

        if (log.isDebugEnabled()) {
            log.debug(">buscarPorID(" + idRespuesta + ", " + bloquear + ")");
        }

        try {
            if (bloquear) {
                respuesta = (Respuesta)HibernateUtil.getSession()
                                                .load(Respuesta.class, 
                                                      idRespuesta, 
                                                      LockMode.UPGRADE);
            } else {
                respuesta = (Respuesta)HibernateUtil.getSession()
                                                .load(Respuesta.class,
                                                      idRespuesta);
            }
        } catch (HibernateException ex) {
            if (log.isWarnEnabled()) {
                log.warn("<HibernateException");
            }

            throw new ExcepcionInfraestructura(ex);
        }
        return respuesta;
    }




    public Collection buscarTodos()
            throws ExcepcionInfraestructura {

        Collection respuestas;

        if (log.isDebugEnabled()) {
            log.debug(">buscarTodos()");
        }

        try {
            respuestas = HibernateUtil.getSession()
                                    .createCriteria(Respuesta.class)
                                    .list();
									
			  log.debug(">buscarTodos() ---- list	");									
        } catch (HibernateException e) {
            if (log.isWarnEnabled()) {
                log.warn("<HibernateException");
            }
            throw new ExcepcionInfraestructura(e);
        }
        return respuestas;
    }


    public Collection buscarPorEjemplo(Respuesta respuesta)
            throws ExcepcionInfraestructura {
        Collection respuestas;
 
        if (log.isDebugEnabled()) {
            log.debug(">buscarPorEjemplo()");
        }

        try {
            Criteria criteria = HibernateUtil.getSession().createCriteria(Respuesta.class);
            respuestas = criteria.add(Example.create(respuesta)).list();
        } catch (HibernateException e) {
            if (log.isWarnEnabled()) {
                log.warn("<HibernateException");
            }
            throw new ExcepcionInfraestructura(e);
        }
        return respuestas;
    }


    public void hazPersistente(Respuesta respuesta)
            throws ExcepcionInfraestructura {

        if (log.isDebugEnabled()) {
            log.debug(">hazPersistente(Pregunta)");
        }

        try {

            HibernateUtil.getSession().saveOrUpdate(respuesta);

        } catch (HibernateException e) {
            if (log.isWarnEnabled()) {
                log.warn("<HibernateException");
            }
            throw new ExcepcionInfraestructura(e);
        }
    }


    public Long getIdRespuesta(String res){
        Long idres=new Long("0");

        Collection respuestas=this.buscarTodos();
        Iterator<Respuesta> it=respuestas.iterator();
        while(it.hasNext()){
            Respuesta respuesta=it.next();
            if(respuesta.getRespuesta().equals(res)){
                idres=respuesta.getId();
                break;
            }
        }
        
        return idres;

    }

    public boolean numeroRespuestas(Long idPregunta){
              try {
            
            String hql = "select respuesta from Respuesta where idPregunta = :Nombres";
           
        
            Query query = HibernateUtil.getSession()
                                        .createQuery(hql);

            query.setParameter("Nombres", idPregunta);
            if (log.isDebugEnabled()) {
                 log.debug("Verificar num de respuestas"+hql);
            }
            List results = query.list();
            int resultado = results.size();
            if (log.isDebugEnabled()) {
                 log.debug("<<<<<<<<< Result size " + resultado);
            }
            if (resultado < 3) {
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

    public void hazTransitorio(Respuesta respuesta)
            throws ExcepcionInfraestructura {

        if (log.isDebugEnabled()) {
            log.debug(">hazTransitorio(Pregunta)");
        }

        try {
            HibernateUtil.getSession().delete(respuesta);
        } catch (HibernateException e) {
            if (log.isWarnEnabled()) {
                log.warn("<HibernateException");
            }
            throw new ExcepcionInfraestructura(e);
        }
    }

    public boolean existeRespuesta(String nombreRespuesta)
            throws ExcepcionInfraestructura {

        if (log.isDebugEnabled()) {
            log.debug(">existePregunta(nombrePregunta)");
        }

        try {
			
			String hql = "select respuesta from Respuesta where respuesta = :Nombres";
			
			 if (log.isDebugEnabled()) {
           		 log.debug(hql + nombreRespuesta);
        	}
		
			Query query = HibernateUtil.getSession()
										.createQuery(hql);
			if (log.isDebugEnabled()) {
           		 log.debug("<<<<<<<<< create query ok " );
        	}

			query.setParameter("Nombres", nombreRespuesta);
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

    
   

}
