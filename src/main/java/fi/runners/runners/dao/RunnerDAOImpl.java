package fi.runners.runners.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;

import org.springframework.context.annotation.Bean;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;

import fi.runners.runners.model.Runner;

public class RunnerDAOImpl implements RunnerDAO {

	private EntityManagerFactory emf;
	
	@Bean
	public EntityManagerFactory getEntityManagerFactory() {
		return new LocalEntityManagerFactoryBean()
				.getNativeEntityManagerFactory();
	}

	@PersistenceUnit
    public void setEntityManagerFactory(EntityManagerFactory emf) {
        this.emf = emf;
    }
	
	@Override
	public List<Runner> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Runner find(Runner r) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(Runner r) {
		EntityManager em = this.emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
            em.persist(r);
            tx.commit();
        }
        finally {
            if (em != null) {
                em.close();
            }
        }
	}

}
