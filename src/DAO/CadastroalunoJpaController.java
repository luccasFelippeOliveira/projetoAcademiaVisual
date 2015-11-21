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
import DataBase.Cadastroaluno;
import DataBase.Treinador;
import DataBase.Modalidades;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author afnsoo
 */
public class CadastroalunoJpaController implements Serializable {

    public CadastroalunoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Cadastroaluno cadastroaluno) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Aluno alunoId = cadastroaluno.getAlunoId();
            if (alunoId != null) {
                alunoId = em.getReference(alunoId.getClass(), alunoId.getId());
                cadastroaluno.setAlunoId(alunoId);
            }
            Treinador treinadorId = cadastroaluno.getTreinadorId();
            if (treinadorId != null) {
                treinadorId = em.getReference(treinadorId.getClass(), treinadorId.getId());
                cadastroaluno.setTreinadorId(treinadorId);
            }
            Modalidades modalidadeId = cadastroaluno.getModalidadeId();
            if (modalidadeId != null) {
                modalidadeId = em.getReference(modalidadeId.getClass(), modalidadeId.getId());
                cadastroaluno.setModalidadeId(modalidadeId);
            }
            em.persist(cadastroaluno);
            if (alunoId != null) {
                alunoId.getCadastroalunoCollection().add(cadastroaluno);
                alunoId = em.merge(alunoId);
            }
            if (treinadorId != null) {
                treinadorId.getCadastroalunoCollection().add(cadastroaluno);
                treinadorId = em.merge(treinadorId);
            }
            if (modalidadeId != null) {
                modalidadeId.getCadastroalunoCollection().add(cadastroaluno);
                modalidadeId = em.merge(modalidadeId);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findCadastroaluno(cadastroaluno.getId()) != null) {
                throw new PreexistingEntityException("Cadastroaluno " + cadastroaluno + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Cadastroaluno cadastroaluno) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Cadastroaluno persistentCadastroaluno = em.find(Cadastroaluno.class, cadastroaluno.getId());
            Aluno alunoIdOld = persistentCadastroaluno.getAlunoId();
            Aluno alunoIdNew = cadastroaluno.getAlunoId();
            Treinador treinadorIdOld = persistentCadastroaluno.getTreinadorId();
            Treinador treinadorIdNew = cadastroaluno.getTreinadorId();
            Modalidades modalidadeIdOld = persistentCadastroaluno.getModalidadeId();
            Modalidades modalidadeIdNew = cadastroaluno.getModalidadeId();
            if (alunoIdNew != null) {
                alunoIdNew = em.getReference(alunoIdNew.getClass(), alunoIdNew.getId());
                cadastroaluno.setAlunoId(alunoIdNew);
            }
            if (treinadorIdNew != null) {
                treinadorIdNew = em.getReference(treinadorIdNew.getClass(), treinadorIdNew.getId());
                cadastroaluno.setTreinadorId(treinadorIdNew);
            }
            if (modalidadeIdNew != null) {
                modalidadeIdNew = em.getReference(modalidadeIdNew.getClass(), modalidadeIdNew.getId());
                cadastroaluno.setModalidadeId(modalidadeIdNew);
            }
            cadastroaluno = em.merge(cadastroaluno);
            if (alunoIdOld != null && !alunoIdOld.equals(alunoIdNew)) {
                alunoIdOld.getCadastroalunoCollection().remove(cadastroaluno);
                alunoIdOld = em.merge(alunoIdOld);
            }
            if (alunoIdNew != null && !alunoIdNew.equals(alunoIdOld)) {
                alunoIdNew.getCadastroalunoCollection().add(cadastroaluno);
                alunoIdNew = em.merge(alunoIdNew);
            }
            if (treinadorIdOld != null && !treinadorIdOld.equals(treinadorIdNew)) {
                treinadorIdOld.getCadastroalunoCollection().remove(cadastroaluno);
                treinadorIdOld = em.merge(treinadorIdOld);
            }
            if (treinadorIdNew != null && !treinadorIdNew.equals(treinadorIdOld)) {
                treinadorIdNew.getCadastroalunoCollection().add(cadastroaluno);
                treinadorIdNew = em.merge(treinadorIdNew);
            }
            if (modalidadeIdOld != null && !modalidadeIdOld.equals(modalidadeIdNew)) {
                modalidadeIdOld.getCadastroalunoCollection().remove(cadastroaluno);
                modalidadeIdOld = em.merge(modalidadeIdOld);
            }
            if (modalidadeIdNew != null && !modalidadeIdNew.equals(modalidadeIdOld)) {
                modalidadeIdNew.getCadastroalunoCollection().add(cadastroaluno);
                modalidadeIdNew = em.merge(modalidadeIdNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = cadastroaluno.getId();
                if (findCadastroaluno(id) == null) {
                    throw new NonexistentEntityException("The cadastroaluno with id " + id + " no longer exists.");
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
            Cadastroaluno cadastroaluno;
            try {
                cadastroaluno = em.getReference(Cadastroaluno.class, id);
                cadastroaluno.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The cadastroaluno with id " + id + " no longer exists.", enfe);
            }
            Aluno alunoId = cadastroaluno.getAlunoId();
            if (alunoId != null) {
                alunoId.getCadastroalunoCollection().remove(cadastroaluno);
                alunoId = em.merge(alunoId);
            }
            Treinador treinadorId = cadastroaluno.getTreinadorId();
            if (treinadorId != null) {
                treinadorId.getCadastroalunoCollection().remove(cadastroaluno);
                treinadorId = em.merge(treinadorId);
            }
            Modalidades modalidadeId = cadastroaluno.getModalidadeId();
            if (modalidadeId != null) {
                modalidadeId.getCadastroalunoCollection().remove(cadastroaluno);
                modalidadeId = em.merge(modalidadeId);
            }
            em.remove(cadastroaluno);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Cadastroaluno> findCadastroalunoEntities() {
        return findCadastroalunoEntities(true, -1, -1);
    }

    public List<Cadastroaluno> findCadastroalunoEntities(int maxResults, int firstResult) {
        return findCadastroalunoEntities(false, maxResults, firstResult);
    }

    private List<Cadastroaluno> findCadastroalunoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Cadastroaluno.class));
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

    public Cadastroaluno findCadastroaluno(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Cadastroaluno.class, id);
        } finally {
            em.close();
        }
    }

    public int getCadastroalunoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Cadastroaluno> rt = cq.from(Cadastroaluno.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
