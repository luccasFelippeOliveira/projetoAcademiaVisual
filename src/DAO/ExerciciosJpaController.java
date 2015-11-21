/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DAO.exceptions.IllegalOrphanException;
import DAO.exceptions.NonexistentEntityException;
import DAO.exceptions.PreexistingEntityException;
import DataBase.Exercicios;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import DataBase.Treinos;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

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
        if (exercicios.getTreinosCollection() == null) {
            exercicios.setTreinosCollection(new ArrayList<Treinos>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Collection<Treinos> attachedTreinosCollection = new ArrayList<Treinos>();
            for (Treinos treinosCollectionTreinosToAttach : exercicios.getTreinosCollection()) {
                treinosCollectionTreinosToAttach = em.getReference(treinosCollectionTreinosToAttach.getClass(), treinosCollectionTreinosToAttach.getId());
                attachedTreinosCollection.add(treinosCollectionTreinosToAttach);
            }
            exercicios.setTreinosCollection(attachedTreinosCollection);
            em.persist(exercicios);
            for (Treinos treinosCollectionTreinos : exercicios.getTreinosCollection()) {
                Exercicios oldExercicioIdOfTreinosCollectionTreinos = treinosCollectionTreinos.getExercicioId();
                treinosCollectionTreinos.setExercicioId(exercicios);
                treinosCollectionTreinos = em.merge(treinosCollectionTreinos);
                if (oldExercicioIdOfTreinosCollectionTreinos != null) {
                    oldExercicioIdOfTreinosCollectionTreinos.getTreinosCollection().remove(treinosCollectionTreinos);
                    oldExercicioIdOfTreinosCollectionTreinos = em.merge(oldExercicioIdOfTreinosCollectionTreinos);
                }
            }
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

    public void edit(Exercicios exercicios) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Exercicios persistentExercicios = em.find(Exercicios.class, exercicios.getId());
            Collection<Treinos> treinosCollectionOld = persistentExercicios.getTreinosCollection();
            Collection<Treinos> treinosCollectionNew = exercicios.getTreinosCollection();
            List<String> illegalOrphanMessages = null;
            for (Treinos treinosCollectionOldTreinos : treinosCollectionOld) {
                if (!treinosCollectionNew.contains(treinosCollectionOldTreinos)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Treinos " + treinosCollectionOldTreinos + " since its exercicioId field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Collection<Treinos> attachedTreinosCollectionNew = new ArrayList<Treinos>();
            for (Treinos treinosCollectionNewTreinosToAttach : treinosCollectionNew) {
                treinosCollectionNewTreinosToAttach = em.getReference(treinosCollectionNewTreinosToAttach.getClass(), treinosCollectionNewTreinosToAttach.getId());
                attachedTreinosCollectionNew.add(treinosCollectionNewTreinosToAttach);
            }
            treinosCollectionNew = attachedTreinosCollectionNew;
            exercicios.setTreinosCollection(treinosCollectionNew);
            exercicios = em.merge(exercicios);
            for (Treinos treinosCollectionNewTreinos : treinosCollectionNew) {
                if (!treinosCollectionOld.contains(treinosCollectionNewTreinos)) {
                    Exercicios oldExercicioIdOfTreinosCollectionNewTreinos = treinosCollectionNewTreinos.getExercicioId();
                    treinosCollectionNewTreinos.setExercicioId(exercicios);
                    treinosCollectionNewTreinos = em.merge(treinosCollectionNewTreinos);
                    if (oldExercicioIdOfTreinosCollectionNewTreinos != null && !oldExercicioIdOfTreinosCollectionNewTreinos.equals(exercicios)) {
                        oldExercicioIdOfTreinosCollectionNewTreinos.getTreinosCollection().remove(treinosCollectionNewTreinos);
                        oldExercicioIdOfTreinosCollectionNewTreinos = em.merge(oldExercicioIdOfTreinosCollectionNewTreinos);
                    }
                }
            }
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

    public void destroy(Integer id) throws IllegalOrphanException, NonexistentEntityException {
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
            List<String> illegalOrphanMessages = null;
            Collection<Treinos> treinosCollectionOrphanCheck = exercicios.getTreinosCollection();
            for (Treinos treinosCollectionOrphanCheckTreinos : treinosCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Exercicios (" + exercicios + ") cannot be destroyed since the Treinos " + treinosCollectionOrphanCheckTreinos + " in its treinosCollection field has a non-nullable exercicioId field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
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
