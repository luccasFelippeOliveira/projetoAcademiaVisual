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
import DataBase.Modalidades;
import DataBase.Ultimodiatreinoaluno;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author afnsoo
 */
public class UltimodiatreinoalunoJpaController implements Serializable {

    public UltimodiatreinoalunoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Ultimodiatreinoaluno ultimodiatreinoaluno) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Aluno alunoId = ultimodiatreinoaluno.getAlunoId();
            if (alunoId != null) {
                alunoId = em.getReference(alunoId.getClass(), alunoId.getId());
                ultimodiatreinoaluno.setAlunoId(alunoId);
            }
            Modalidades modalidadeId = ultimodiatreinoaluno.getModalidadeId();
            if (modalidadeId != null) {
                modalidadeId = em.getReference(modalidadeId.getClass(), modalidadeId.getId());
                ultimodiatreinoaluno.setModalidadeId(modalidadeId);
            }
            em.persist(ultimodiatreinoaluno);
            if (alunoId != null) {
                alunoId.getUltimodiatreinoalunoCollection().add(ultimodiatreinoaluno);
                alunoId = em.merge(alunoId);
            }
            if (modalidadeId != null) {
                modalidadeId.getUltimodiatreinoalunoCollection().add(ultimodiatreinoaluno);
                modalidadeId = em.merge(modalidadeId);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findUltimodiatreinoaluno(ultimodiatreinoaluno.getId()) != null) {
                throw new PreexistingEntityException("Ultimodiatreinoaluno " + ultimodiatreinoaluno + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Ultimodiatreinoaluno ultimodiatreinoaluno) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Ultimodiatreinoaluno persistentUltimodiatreinoaluno = em.find(Ultimodiatreinoaluno.class, ultimodiatreinoaluno.getId());
            Aluno alunoIdOld = persistentUltimodiatreinoaluno.getAlunoId();
            Aluno alunoIdNew = ultimodiatreinoaluno.getAlunoId();
            Modalidades modalidadeIdOld = persistentUltimodiatreinoaluno.getModalidadeId();
            Modalidades modalidadeIdNew = ultimodiatreinoaluno.getModalidadeId();
            if (alunoIdNew != null) {
                alunoIdNew = em.getReference(alunoIdNew.getClass(), alunoIdNew.getId());
                ultimodiatreinoaluno.setAlunoId(alunoIdNew);
            }
            if (modalidadeIdNew != null) {
                modalidadeIdNew = em.getReference(modalidadeIdNew.getClass(), modalidadeIdNew.getId());
                ultimodiatreinoaluno.setModalidadeId(modalidadeIdNew);
            }
            ultimodiatreinoaluno = em.merge(ultimodiatreinoaluno);
            if (alunoIdOld != null && !alunoIdOld.equals(alunoIdNew)) {
                alunoIdOld.getUltimodiatreinoalunoCollection().remove(ultimodiatreinoaluno);
                alunoIdOld = em.merge(alunoIdOld);
            }
            if (alunoIdNew != null && !alunoIdNew.equals(alunoIdOld)) {
                alunoIdNew.getUltimodiatreinoalunoCollection().add(ultimodiatreinoaluno);
                alunoIdNew = em.merge(alunoIdNew);
            }
            if (modalidadeIdOld != null && !modalidadeIdOld.equals(modalidadeIdNew)) {
                modalidadeIdOld.getUltimodiatreinoalunoCollection().remove(ultimodiatreinoaluno);
                modalidadeIdOld = em.merge(modalidadeIdOld);
            }
            if (modalidadeIdNew != null && !modalidadeIdNew.equals(modalidadeIdOld)) {
                modalidadeIdNew.getUltimodiatreinoalunoCollection().add(ultimodiatreinoaluno);
                modalidadeIdNew = em.merge(modalidadeIdNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = ultimodiatreinoaluno.getId();
                if (findUltimodiatreinoaluno(id) == null) {
                    throw new NonexistentEntityException("The ultimodiatreinoaluno with id " + id + " no longer exists.");
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
            Ultimodiatreinoaluno ultimodiatreinoaluno;
            try {
                ultimodiatreinoaluno = em.getReference(Ultimodiatreinoaluno.class, id);
                ultimodiatreinoaluno.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The ultimodiatreinoaluno with id " + id + " no longer exists.", enfe);
            }
            Aluno alunoId = ultimodiatreinoaluno.getAlunoId();
            if (alunoId != null) {
                alunoId.getUltimodiatreinoalunoCollection().remove(ultimodiatreinoaluno);
                alunoId = em.merge(alunoId);
            }
            Modalidades modalidadeId = ultimodiatreinoaluno.getModalidadeId();
            if (modalidadeId != null) {
                modalidadeId.getUltimodiatreinoalunoCollection().remove(ultimodiatreinoaluno);
                modalidadeId = em.merge(modalidadeId);
            }
            em.remove(ultimodiatreinoaluno);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Ultimodiatreinoaluno> findUltimodiatreinoalunoEntities() {
        return findUltimodiatreinoalunoEntities(true, -1, -1);
    }

    public List<Ultimodiatreinoaluno> findUltimodiatreinoalunoEntities(int maxResults, int firstResult) {
        return findUltimodiatreinoalunoEntities(false, maxResults, firstResult);
    }

    private List<Ultimodiatreinoaluno> findUltimodiatreinoalunoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Ultimodiatreinoaluno.class));
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

    public Ultimodiatreinoaluno findUltimodiatreinoaluno(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Ultimodiatreinoaluno.class, id);
        } finally {
            em.close();
        }
    }

    public int getUltimodiatreinoalunoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Ultimodiatreinoaluno> rt = cq.from(Ultimodiatreinoaluno.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
