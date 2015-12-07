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
import DataBase.Exercicios;
import DataBase.Modalidades;
import DataBase.Treinos;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author afnsoo
 */
public class TreinosJpaController implements Serializable {

    public TreinosJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Treinos treinos) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Aluno alunoId = treinos.getAlunoId();
            if (alunoId != null) {
                alunoId = em.getReference(alunoId.getClass(), alunoId.getId());
                treinos.setAlunoId(alunoId);
            }
            Exercicios exercicioId = treinos.getExercicioId();
            if (exercicioId != null) {
                exercicioId = em.getReference(exercicioId.getClass(), exercicioId.getId());
                treinos.setExercicioId(exercicioId);
            }
            Modalidades modalidadeId = treinos.getModalidadeId();
            if (modalidadeId != null) {
                modalidadeId = em.getReference(modalidadeId.getClass(), modalidadeId.getId());
                treinos.setModalidadeId(modalidadeId);
            }
            em.persist(treinos);
            if (alunoId != null) {
                alunoId.getTreinosCollection().add(treinos);
                alunoId = em.merge(alunoId);
            }
            if (exercicioId != null) {
                exercicioId.getTreinosCollection().add(treinos);
                exercicioId = em.merge(exercicioId);
            }
            if (modalidadeId != null) {
                modalidadeId.getTreinosCollection().add(treinos);
                modalidadeId = em.merge(modalidadeId);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findTreinos(treinos.getId()) != null) {
                throw new PreexistingEntityException("Treinos " + treinos + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Treinos treinos) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Treinos persistentTreinos = em.find(Treinos.class, treinos.getId());
            Aluno alunoIdOld = persistentTreinos.getAlunoId();
            Aluno alunoIdNew = treinos.getAlunoId();
            Exercicios exercicioIdOld = persistentTreinos.getExercicioId();
            Exercicios exercicioIdNew = treinos.getExercicioId();
            Modalidades modalidadeIdOld = persistentTreinos.getModalidadeId();
            Modalidades modalidadeIdNew = treinos.getModalidadeId();
            if (alunoIdNew != null) {
                alunoIdNew = em.getReference(alunoIdNew.getClass(), alunoIdNew.getId());
                treinos.setAlunoId(alunoIdNew);
            }
            if (exercicioIdNew != null) {
                exercicioIdNew = em.getReference(exercicioIdNew.getClass(), exercicioIdNew.getId());
                treinos.setExercicioId(exercicioIdNew);
            }
            if (modalidadeIdNew != null) {
                modalidadeIdNew = em.getReference(modalidadeIdNew.getClass(), modalidadeIdNew.getId());
                treinos.setModalidadeId(modalidadeIdNew);
            }
            treinos = em.merge(treinos);
            if (alunoIdOld != null && !alunoIdOld.equals(alunoIdNew)) {
                alunoIdOld.getTreinosCollection().remove(treinos);
                alunoIdOld = em.merge(alunoIdOld);
            }
            if (alunoIdNew != null && !alunoIdNew.equals(alunoIdOld)) {
                alunoIdNew.getTreinosCollection().add(treinos);
                alunoIdNew = em.merge(alunoIdNew);
            }
            if (exercicioIdOld != null && !exercicioIdOld.equals(exercicioIdNew)) {
                exercicioIdOld.getTreinosCollection().remove(treinos);
                exercicioIdOld = em.merge(exercicioIdOld);
            }
            if (exercicioIdNew != null && !exercicioIdNew.equals(exercicioIdOld)) {
                exercicioIdNew.getTreinosCollection().add(treinos);
                exercicioIdNew = em.merge(exercicioIdNew);
            }
            if (modalidadeIdOld != null && !modalidadeIdOld.equals(modalidadeIdNew)) {
                modalidadeIdOld.getTreinosCollection().remove(treinos);
                modalidadeIdOld = em.merge(modalidadeIdOld);
            }
            if (modalidadeIdNew != null && !modalidadeIdNew.equals(modalidadeIdOld)) {
                modalidadeIdNew.getTreinosCollection().add(treinos);
                modalidadeIdNew = em.merge(modalidadeIdNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = treinos.getId();
                if (findTreinos(id) == null) {
                    throw new NonexistentEntityException("The treinos with id " + id + " no longer exists.");
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
            Treinos treinos;
            try {
                treinos = em.getReference(Treinos.class, id);
                treinos.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The treinos with id " + id + " no longer exists.", enfe);
            }
            Aluno alunoId = treinos.getAlunoId();
            if (alunoId != null) {
                alunoId.getTreinosCollection().remove(treinos);
                alunoId = em.merge(alunoId);
            }
            Exercicios exercicioId = treinos.getExercicioId();
            if (exercicioId != null) {
                exercicioId.getTreinosCollection().remove(treinos);
                exercicioId = em.merge(exercicioId);
            }
            Modalidades modalidadeId = treinos.getModalidadeId();
            if (modalidadeId != null) {
                modalidadeId.getTreinosCollection().remove(treinos);
                modalidadeId = em.merge(modalidadeId);
            }
            em.remove(treinos);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Treinos> findTreinosEntities() {
        return findTreinosEntities(true, -1, -1);
    }

    public List<Treinos> findTreinosEntities(int maxResults, int firstResult) {
        return findTreinosEntities(false, maxResults, firstResult);
    }

    private List<Treinos> findTreinosEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Treinos.class));
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
    public List<Treinos> findTreinosByAlunoId(Aluno alunoID) {
        EntityManager em = getEntityManager();
        List<Treinos> l;
        try {
            Query q;
            q = em.createNamedQuery("Treinos.findByAlunoId");
            q.setParameter("alunoId", alunoID);
            l = q.getResultList();
            return l;
        }finally {
            em.close();
        }
        
    }

    public Treinos findTreinos(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Treinos.class, id);
        } finally {
            em.close();
        }
    }

    public int getTreinosCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Treinos> rt = cq.from(Treinos.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
