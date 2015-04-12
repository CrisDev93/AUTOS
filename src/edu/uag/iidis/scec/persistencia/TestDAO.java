package edu.uag.iidis.scec.persistencia;

import org.hibernate.*;
import org.hibernate.type.*;
import org.hibernate.criterion.Example;
//import org.hibernate.classic.*;


import edu.uag.iidis.scec.excepciones.ExcepcionInfraestructura;
import edu.uag.iidis.scec.modelo.Test;
import edu.uag.iidis.scec.persistencia.hibernate.HibernateUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.Collection;
import java.util.List;


public class TestDAO {

    private Log log = LogFactory.getLog(TestDAO.class);

    public TestDAO() {
    }


    public Test buscarPorId(Long idTest, boolean bloquear)
            throws ExcepcionInfraestructura {

        Test test = null;

        if (log.isDebugEnabled()) {
            log.debug(">buscarPorID(" + idTest + ", " + bloquear + ")");
        }

        try {
            if (bloquear) {
                test = (Test)HibernateUtil.getSession()
                                                .load(Test.class, 
                                                      idTest, 
                                                      LockMode.UPGRADE);
            } else {
                test = (Test)HibernateUtil.getSession()
                                                .load(Test.class,
                                                      idTest);
            }
        } catch (HibernateException ex) {
            if (log.isWarnEnabled()) {
                log.warn("<HibernateException");
            }

            throw new ExcepcionInfraestructura(ex);
        }
        return test;
    }


    public Collection buscarTodos()
            throws ExcepcionInfraestructura {

        Collection test;

        if (log.isDebugEnabled()) {
            log.debug(">buscarTodos()");
        }

        try {
            test = HibernateUtil.getSession()
                                    .createCriteria(Test.class)
                                    .list();
        } catch (HibernateException e) {
            if (log.isWarnEnabled()) {
                log.warn("<HibernateException");
            }
            throw new ExcepcionInfraestructura(e);
        }
        return test;
    }


    public Collection buscarPorEjemplo(Test test)
            throws ExcepcionInfraestructura {


        Collection tests;
 
        if (log.isDebugEnabled()) {
            log.debug(">buscarPorEjemplo()");
        }

        try {
            Criteria criteria = HibernateUtil.getSession()
                                             .createCriteria(Test.class);
            tests = criteria.add(Example.create(test)).list();
        } catch (HibernateException e) {
            if (log.isWarnEnabled()) {
                log.warn("<HibernateException");
            }
            throw new ExcepcionInfraestructura(e);
        }
        return tests;
    }


    public void hazPersistente(Test test)
            throws ExcepcionInfraestructura {

        if (log.isDebugEnabled()) {
            log.debug(">hazPersistente(Test)");
        }

        try {
            HibernateUtil.getSession().saveOrUpdate(test);
        } catch (HibernateException e) {
            if (log.isWarnEnabled()) {
                log.warn("<HibernateException");
            }
            throw new ExcepcionInfraestructura(e);
        }
    }


    public void hazTransitorio(Test test)
            throws ExcepcionInfraestructura {

        if (log.isDebugEnabled()) {
            log.debug(">hazTransitorio(Test)");
        }

        try {
            HibernateUtil.getSession().delete(test);
        } catch (HibernateException e) {
            if (log.isWarnEnabled()) {
                log.warn("<HibernateException");
            }
            throw new ExcepcionInfraestructura(e);
        }
    }

    public boolean existeTest(String nombreTest)
            throws ExcepcionInfraestructura {

        if (log.isDebugEnabled()) {
            log.debug(">existeTest(nombreTest)");
        }

        try {
			
			

			String hql = "select nombre from Test where nombre = :nombre";
			
			 if (log.isDebugEnabled()) {
           		 log.debug(hql + nombreTest);
        	}
		
			Query query = HibernateUtil.getSession()
										.createQuery(hql);
			if (log.isDebugEnabled()) {
           		 log.debug("<<<<<<<<< create query ok " );
        	}

			query.setParameter("nombre", nombreTest);
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

    public Collection generarTest(Long idt)
            throws ExcepcionInfraestructura {
               
        Collection test;


        try {
            
            String hql = "from Testgenerado where idt = :id";
            
             if (log.isDebugEnabled()) {
                 log.debug(hql  + idt);
            }
        
            Query query = HibernateUtil.getSession()
                                        .createQuery(hql);
            

            query.setParameter("id", idt);

            
            if (log.isDebugEnabled()) {
                 log.debug("  ***query:   "+hql );
            }

            test = query.list();

            return test;

        } catch (HibernateException ex) {
            if (log.isWarnEnabled()) {
                log.warn("<HibernateException *******************");
                ex.printStackTrace();
            }
            throw new ExcepcionInfraestructura(ex);
        }
    }

    public Collection generarHistorialTest(Long idt)
            throws ExcepcionInfraestructura {
               
        Collection test;


        try {
            
            String hql = "from Historiatest where idt = :id";
            
             if (log.isDebugEnabled()) {
                 log.debug(hql  + idt);
            }
        
            Query query = HibernateUtil.getSession()
                                        .createQuery(hql);
            

            query.setParameter("id", idt);

            
            if (log.isDebugEnabled()) {
                 log.debug("  ***query:   "+hql );
            }

            test = query.list();

            return test;

        } catch (HibernateException ex) {
            if (log.isWarnEnabled()) {
                log.warn("<HibernateException *******************");
                ex.printStackTrace();
            }
            throw new ExcepcionInfraestructura(ex);
        }
    }

}
