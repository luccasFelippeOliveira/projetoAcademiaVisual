/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DAO.exceptions.NonexistentEntityException;
import DAO.exceptions.PreexistingEntityException;
import DataBase.Modalidades;
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
public class ModalidadesJpaController implements Serializable {

    public ModalidadesJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Modalidades modalidades) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(modalidades);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findModalidades(modalidades.getId()) != null) {
                throw new PreexistingEntityException("Modalidades " + modalidades + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Modalidades modalidades) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            modalidades = em.merge(modalidades);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = modalidades.getId();
                if (findModalidades(id) == null) {
                    throw new NonexistentEntityException("The modalidades with id " + id + " no longer exists.");
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
            Modalidades modalidades;
            try {
                modalidades = em.getReference(Modalidades.class, id);
                modalidades.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The modalidades with id " + id + " no longer exists.", enfe);
            }
            em.remove(modalidades);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Modalidades> findModalidadesEntities() {
        return findModalidadesEntities(true, -1, -1);
    }

    public List<Modalidades> findModalidadesEntities(int maxResults, int firstResult) {
        return findModalidadesEntities(false, maxResults, firstResult);
    }

    private List<Modalidades> findModalidadesEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Modalidades.class));
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

    public Modalidades findModalidades(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Modalidades.class, id);
        } finally {
            em.close();
        }
    }

    public int getModalidadesCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Modalidades> rt = cq.from(Modalidades.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
