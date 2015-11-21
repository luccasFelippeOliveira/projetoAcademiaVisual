/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DAO.exceptions.NonexistentEntityException;
import DAO.exceptions.PreexistingEntityException;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import DataBase.Aluno;
import DataBase.Evolucaoaluno;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author afnsoo
 */
public class EvolucaoalunoJpaController implements Serializable {

    public EvolucaoalunoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Evolucaoaluno evolucaoaluno) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Aluno alunoId = evolucaoaluno.getAlunoId();
            if (alunoId != null) {
                alunoId = em.getReference(alunoId.getClass(), alunoId.getId());
                evolucaoaluno.setAlunoId(alunoId);
            }
            em.persist(evolucaoaluno);
            if (alunoId != null) {
                alunoId.getEvolucaoalunoCollection().add(evolucaoaluno);
                alunoId = em.merge(alunoId);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findEvolucaoaluno(evolucaoaluno.getId()) != null) {
                throw new PreexistingEntityException("Evolucaoaluno " + evolucaoaluno + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Evolucaoaluno evolucaoaluno) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Evolucaoaluno persistentEvolucaoaluno = em.find(Evolucaoaluno.class, evolucaoaluno.getId());
            Aluno alunoIdOld = persistentEvolucaoaluno.getAlunoId();
            Aluno alunoIdNew = evolucaoaluno.getAlunoId();
            if (alunoIdNew != null) {
                alunoIdNew = em.getReference(alunoIdNew.getClass(), alunoIdNew.getId());
                evolucaoaluno.setAlunoId(alunoIdNew);
            }
            evolucaoaluno = em.merge(evolucaoaluno);
            if (alunoIdOld != null && !alunoIdOld.equals(alunoIdNew)) {
                alunoIdOld.getEvolucaoalunoCollection().remove(evolucaoaluno);
                alunoIdOld = em.merge(alunoIdOld);
            }
            if (alunoIdNew != null && !alunoIdNew.equals(alunoIdOld)) {
                alunoIdNew.getEvolucaoalunoCollection().add(evolucaoaluno);
                alunoIdNew = em.merge(alunoIdNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = evolucaoaluno.getId();
                if (findEvolucaoaluno(id) == null) {
                    throw new NonexistentEntityException("The evolucaoaluno with id " + id + " no longer exists.");
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
            Evolucaoaluno evolucaoaluno;
            try {
                evolucaoaluno = em.getReference(Evolucaoaluno.class, id);
                evolucaoaluno.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The evolucaoaluno with id " + id + " no longer exists.", enfe);
            }
            Aluno alunoId = evolucaoaluno.getAlunoId();
            if (alunoId != null) {
                alunoId.getEvolucaoalunoCollection().remove(evolucaoaluno);
                alunoId = em.merge(alunoId);
            }
            em.remove(evolucaoaluno);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Evolucaoaluno> findEvolucaoalunoEntities() {
        return findEvolucaoalunoEntities(true, -1, -1);
    }

    public List<Evolucaoaluno> findEvolucaoalunoEntities(int maxResults, int firstResult) {
        return findEvolucaoalunoEntities(false, maxResults, firstResult);
    }

    private List<Evolucaoaluno> findEvolucaoalunoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Evolucaoaluno.class));
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

    public Evolucaoaluno findEvolucaoaluno(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Evolucaoaluno.class, id);
        } finally {
            em.close();
        }
    }

    public int getEvolucaoalunoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Evolucaoaluno> rt = cq.from(Evolucaoaluno.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
