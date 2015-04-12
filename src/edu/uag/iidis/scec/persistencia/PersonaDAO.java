package edu.uag.iidis.scec.persistencia;

import org.hibernate.*;
import org.hibernate.type.*;
import org.hibernate.criterion.Example;
//import org.hibernate.classic.*;


import edu.uag.iidis.scec.excepciones.ExcepcionInfraestructura;
import edu.uag.iidis.scec.modelo.Persona;
import edu.uag.iidis.scec.persistencia.hibernate.HibernateUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.Collection;
import java.util.List;


public class PersonaDAO {

    private Log log = LogFactory.getLog(PersonaDAO.class);

    public PersonaDAO() {
    }


    public Persona buscarPorId(Long idPersona, boolean bloquear)
            throws ExcepcionInfraestructura {

        Persona persona = null;

        if (log.isDebugEnabled()) {
            log.debug(">buscarPorID(" + idPersona + ", " + bloquear + ")");
        }

        try {
            if (bloquear) {
                persona = (Persona)HibernateUtil.getSession()
                                                .load(Persona.class, 
                                                      idPersona, 
                                                      LockMode.UPGRADE);
            } else {
                persona = (Persona)HibernateUtil.getSession()
                                                .load(Persona.class,
                                                      idPersona);
            }
        } catch (HibernateException ex) {
            if (log.isWarnEnabled()) {
                log.warn("<HibernateException");
            }

            throw new ExcepcionInfraestructura(ex);
        }
        return persona;
    }


    public Collection buscarTodos()
            throws ExcepcionInfraestructura {

        Collection personas;

        if (log.isDebugEnabled()) {
            log.debug(">buscarTodos()");
        }

        try {
            personas = HibernateUtil.getSession()
                                    .createCriteria(Persona.class)
                                    .list();
									
			  log.debug(">buscarTodos() ---- list	");									
        } catch (HibernateException e) {
            if (log.isWarnEnabled()) {
                log.warn("<HibernateException");
            }
            throw new ExcepcionInfraestructura(e);
        }
        return personas;
    }


    public Collection buscarPorEjemplo(Persona persona)
            throws ExcepcionInfraestructura {


        Collection personas;
 
        if (log.isDebugEnabled()) {
            log.debug(">buscarPorEjemplo()");
        }

        try {
            Criteria criteria = HibernateUtil.getSession()
                                             .createCriteria(Persona.class);
            personas = criteria.add(Example.create(persona)).list();
        } catch (HibernateException e) {
            if (log.isWarnEnabled()) {
                log.warn("<HibernateException");
            }
            throw new ExcepcionInfraestructura(e);
        }
        return personas;
    }


    public void hazPersistente(Persona persona)
            throws ExcepcionInfraestructura {

        if (log.isDebugEnabled()) {
            log.debug(">hazPersistente(persona)");
        }

        try {
            HibernateUtil.getSession().saveOrUpdate(persona);
        } catch (HibernateException e) {
            if (log.isWarnEnabled()) {
                log.warn("<HibernateException");
            }
            throw new ExcepcionInfraestructura(e);
        }
    }


    public void hazTransitorio(Persona persona)
            throws ExcepcionInfraestructura {

        if (log.isDebugEnabled()) {
            log.debug(">hazTransitorio(persona)");
        }

        try {
            HibernateUtil.getSession().delete(persona);
        } catch (HibernateException e) {
            if (log.isWarnEnabled()) {
                log.warn("<HibernateException");
            }
            throw new ExcepcionInfraestructura(e);
        }
    }

    public boolean existePersona(String nombrePersona)
            throws ExcepcionInfraestructura {

        if (log.isDebugEnabled()) {
            log.debug(">existePersona(nombrePersona)");
        }

        try {
			
			
 
			String hql = "select Nombres from Persona where Nombres = :Nombres";
			
			 if (log.isDebugEnabled()) {
           		 log.debug(hql + nombrePersona);
        	}
		
			Query query = HibernateUtil.getSession()
										.createQuery(hql);
			if (log.isDebugEnabled()) {
           		 log.debug("<<<<<<<<< create query ok " );
        	}

			query.setParameter("Nombres", nombrePersona);
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
    public Collection ordenarPor(String tipo, int tipoInt)
            throws ExcepcionInfraestructura {

        Collection ciudades;

        if (log.isDebugEnabled()) {
            log.debug(">existeRol(nombreRol)");
        }
        String add="";
        if (tipoInt==0) {
            add="ASC";
        } else if(tipoInt==1) {
            add="DESC";
        }
        try {
            String hql="from Persona";
            if(tipo.equals("nombres")) {
                hql = "from Persona order by Nombres "+add;
            } else if(tipo.equals("apellidos")) {
                hql = "from Persona order by Apellidos "+add;
            } else if(tipo.equals("direccion")) {
                hql = "from Persona order by Direccion "+add;
            } else if(tipo.equals("telefono")) {
                hql = "from Persona order by Telefono "+add;
            } else if(tipo.equals("ciudad")) {
                hql = "from Persona order by idCiudad "+add;
            } 
            
             if (log.isDebugEnabled()) {
                 log.debug(hql);
            }
        
            Query query = HibernateUtil.getSession()
                                        .createQuery(hql);
            if (log.isDebugEnabled()) {
                 log.debug("<<<<<<<<< create query ok " );
            }

            if (log.isDebugEnabled()) {
                 log.debug("<<<<<<<<< set Parameter ok antes del query list >>>>>");
            }
            ciudades = query.list();

            return ciudades;

        } catch (HibernateException ex) {
            if (log.isWarnEnabled()) {
                log.warn("<HibernateException *******************");
            }
            throw new ExcepcionInfraestructura(ex);
        }
    }

}
