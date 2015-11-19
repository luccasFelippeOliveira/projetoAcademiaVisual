/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DAO.exceptions.NonexistentEntityException;
import DAO.exceptions.PreexistingEntityException;
import DataBase.Treinador;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author afnsoo
 */
public class TreinadorJpaController implements Serializable {

    public TreinadorJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Treinador treinador) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(treinador);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findTreinador(treinador.getId()) != null) {
                throw new PreexistingEntityException("Treinador " + treinador + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Treinador treinador) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            treinador = em.merge(treinador);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = treinador.getId();
                if (findTreinador(id) == null) {
                    throw new NonexistentEntityException("The treinador with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Treinador treinador;
            try {
                treinador = em.getReference(Treinador.class, id);
                treinador.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The treinador with id " + id + " no longer exists.", enfe);
            }
            em.remove(treinador);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Treinador> findTreinadorEntities() {
        return findTreinadorEntities(true, -1, -1);
    }

    public List<Treinador> findTreinadorEntities(int maxResults, int firstResult) {
        return findTreinadorEntities(false, maxResults, firstResult);
    }

    private List<Treinador> findTreinadorEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Treinador.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Treinador findTreinador(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Treinador.class, id);
        } finally {
            em.close();
        }
    }

    public int getTreinadorCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Treinador> rt = cq.from(Treinador.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
