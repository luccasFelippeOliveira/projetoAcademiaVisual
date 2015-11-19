/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DAO.exceptions.NonexistentEntityException;
import DAO.exceptions.PreexistingEntityException;
import DataBase.Exercicios;
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
public class ExerciciosJpaController implements Serializable {

    public ExerciciosJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Exercicios exercicios) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(exercicios);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findExercicios(exercicios.getId()) != null) {
                throw new PreexistingEntityException("Exercicios " + exercicios + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Exercicios exercicios) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            exercicios = em.merge(exercicios);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = exercicios.getId();
                if (findExercicios(id) == null) {
                    throw new NonexistentEntityException("The exercicios with id " + id + " no longer exists.");
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
            Exercicios exercicios;
            try {
                exercicios = em.getReference(Exercicios.class, id);
                exercicios.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The exercicios with id " + id + " no longer exists.", enfe);
            }
            em.remove(exercicios);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Exercicios> findExerciciosEntities() {
        return findExerciciosEntities(true, -1, -1);
    }

    public List<Exercicios> findExerciciosEntities(int maxResults, int firstResult) {
        return findExerciciosEntities(false, maxResults, firstResult);
    }

    private List<Exercicios> findExerciciosEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Exercicios.class));
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

    public Exercicios findExercicios(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Exercicios.class, id);
        } finally {
            em.close();
        }
    }

    public int getExerciciosCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Exercicios> rt = cq.from(Exercicios.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
