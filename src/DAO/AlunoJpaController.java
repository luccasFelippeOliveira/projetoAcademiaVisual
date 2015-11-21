/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DAO.exceptions.IllegalOrphanException;
import DAO.exceptions.NonexistentEntityException;
import DAO.exceptions.PreexistingEntityException;
import DataBase.Aluno;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import DataBase.Evolucaoaluno;
import java.util.ArrayList;
import java.util.Collection;
import DataBase.Ultimodiatreinoaluno;
import DataBase.Cadastroaluno;
import DataBase.Treinos;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author afnsoo
 */
public class AlunoJpaController implements Serializable {

    public AlunoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Aluno aluno) throws PreexistingEntityException, Exception {
        if (aluno.getEvolucaoalunoCollection() == null) {
            aluno.setEvolucaoalunoCollection(new ArrayList<Evolucaoaluno>());
        }
        if (aluno.getUltimodiatreinoalunoCollection() == null) {
            aluno.setUltimodiatreinoalunoCollection(new ArrayList<Ultimodiatreinoaluno>());
        }
        if (aluno.getCadastroalunoCollection() == null) {
            aluno.setCadastroalunoCollection(new ArrayList<Cadastroaluno>());
        }
        if (aluno.getTreinosCollection() == null) {
            aluno.setTreinosCollection(new ArrayList<Treinos>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Collection<Evolucaoaluno> attachedEvolucaoalunoCollection = new ArrayList<Evolucaoaluno>();
            for (Evolucaoaluno evolucaoalunoCollectionEvolucaoalunoToAttach : aluno.getEvolucaoalunoCollection()) {
                evolucaoalunoCollectionEvolucaoalunoToAttach = em.getReference(evolucaoalunoCollectionEvolucaoalunoToAttach.getClass(), evolucaoalunoCollectionEvolucaoalunoToAttach.getId());
                attachedEvolucaoalunoCollection.add(evolucaoalunoCollectionEvolucaoalunoToAttach);
            }
            aluno.setEvolucaoalunoCollection(attachedEvolucaoalunoCollection);
            Collection<Ultimodiatreinoaluno> attachedUltimodiatreinoalunoCollection = new ArrayList<Ultimodiatreinoaluno>();
            for (Ultimodiatreinoaluno ultimodiatreinoalunoCollectionUltimodiatreinoalunoToAttach : aluno.getUltimodiatreinoalunoCollection()) {
                ultimodiatreinoalunoCollectionUltimodiatreinoalunoToAttach = em.getReference(ultimodiatreinoalunoCollectionUltimodiatreinoalunoToAttach.getClass(), ultimodiatreinoalunoCollectionUltimodiatreinoalunoToAttach.getId());
                attachedUltimodiatreinoalunoCollection.add(ultimodiatreinoalunoCollectionUltimodiatreinoalunoToAttach);
            }
            aluno.setUltimodiatreinoalunoCollection(attachedUltimodiatreinoalunoCollection);
            Collection<Cadastroaluno> attachedCadastroalunoCollection = new ArrayList<Cadastroaluno>();
            for (Cadastroaluno cadastroalunoCollectionCadastroalunoToAttach : aluno.getCadastroalunoCollection()) {
                cadastroalunoCollectionCadastroalunoToAttach = em.getReference(cadastroalunoCollectionCadastroalunoToAttach.getClass(), cadastroalunoCollectionCadastroalunoToAttach.getId());
                attachedCadastroalunoCollection.add(cadastroalunoCollectionCadastroalunoToAttach);
            }
            aluno.setCadastroalunoCollection(attachedCadastroalunoCollection);
            Collection<Treinos> attachedTreinosCollection = new ArrayList<Treinos>();
            for (Treinos treinosCollectionTreinosToAttach : aluno.getTreinosCollection()) {
                treinosCollectionTreinosToAttach = em.getReference(treinosCollectionTreinosToAttach.getClass(), treinosCollectionTreinosToAttach.getId());
                attachedTreinosCollection.add(treinosCollectionTreinosToAttach);
            }
            aluno.setTreinosCollection(attachedTreinosCollection);
            em.persist(aluno);
            for (Evolucaoaluno evolucaoalunoCollectionEvolucaoaluno : aluno.getEvolucaoalunoCollection()) {
                Aluno oldAlunoIdOfEvolucaoalunoCollectionEvolucaoaluno = evolucaoalunoCollectionEvolucaoaluno.getAlunoId();
                evolucaoalunoCollectionEvolucaoaluno.setAlunoId(aluno);
                evolucaoalunoCollectionEvolucaoaluno = em.merge(evolucaoalunoCollectionEvolucaoaluno);
                if (oldAlunoIdOfEvolucaoalunoCollectionEvolucaoaluno != null) {
                    oldAlunoIdOfEvolucaoalunoCollectionEvolucaoaluno.getEvolucaoalunoCollection().remove(evolucaoalunoCollectionEvolucaoaluno);
                    oldAlunoIdOfEvolucaoalunoCollectionEvolucaoaluno = em.merge(oldAlunoIdOfEvolucaoalunoCollectionEvolucaoaluno);
                }
            }
            for (Ultimodiatreinoaluno ultimodiatreinoalunoCollectionUltimodiatreinoaluno : aluno.getUltimodiatreinoalunoCollection()) {
                Aluno oldAlunoIdOfUltimodiatreinoalunoCollectionUltimodiatreinoaluno = ultimodiatreinoalunoCollectionUltimodiatreinoaluno.getAlunoId();
                ultimodiatreinoalunoCollectionUltimodiatreinoaluno.setAlunoId(aluno);
                ultimodiatreinoalunoCollectionUltimodiatreinoaluno = em.merge(ultimodiatreinoalunoCollectionUltimodiatreinoaluno);
                if (oldAlunoIdOfUltimodiatreinoalunoCollectionUltimodiatreinoaluno != null) {
                    oldAlunoIdOfUltimodiatreinoalunoCollectionUltimodiatreinoaluno.getUltimodiatreinoalunoCollection().remove(ultimodiatreinoalunoCollectionUltimodiatreinoaluno);
                    oldAlunoIdOfUltimodiatreinoalunoCollectionUltimodiatreinoaluno = em.merge(oldAlunoIdOfUltimodiatreinoalunoCollectionUltimodiatreinoaluno);
                }
            }
            for (Cadastroaluno cadastroalunoCollectionCadastroaluno : aluno.getCadastroalunoCollection()) {
                Aluno oldAlunoIdOfCadastroalunoCollectionCadastroaluno = cadastroalunoCollectionCadastroaluno.getAlunoId();
                cadastroalunoCollectionCadastroaluno.setAlunoId(aluno);
                cadastroalunoCollectionCadastroaluno = em.merge(cadastroalunoCollectionCadastroaluno);
                if (oldAlunoIdOfCadastroalunoCollectionCadastroaluno != null) {
                    oldAlunoIdOfCadastroalunoCollectionCadastroaluno.getCadastroalunoCollection().remove(cadastroalunoCollectionCadastroaluno);
                    oldAlunoIdOfCadastroalunoCollectionCadastroaluno = em.merge(oldAlunoIdOfCadastroalunoCollectionCadastroaluno);
                }
            }
            for (Treinos treinosCollectionTreinos : aluno.getTreinosCollection()) {
                Aluno oldAlunoIdOfTreinosCollectionTreinos = treinosCollectionTreinos.getAlunoId();
                treinosCollectionTreinos.setAlunoId(aluno);
                treinosCollectionTreinos = em.merge(treinosCollectionTreinos);
                if (oldAlunoIdOfTreinosCollectionTreinos != null) {
                    oldAlunoIdOfTreinosCollectionTreinos.getTreinosCollection().remove(treinosCollectionTreinos);
                    oldAlunoIdOfTreinosCollectionTreinos = em.merge(oldAlunoIdOfTreinosCollectionTreinos);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findAluno(aluno.getId()) != null) {
                throw new PreexistingEntityException("Aluno " + aluno + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Aluno aluno) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Aluno persistentAluno = em.find(Aluno.class, aluno.getId());
            Collection<Evolucaoaluno> evolucaoalunoCollectionOld = persistentAluno.getEvolucaoalunoCollection();
            Collection<Evolucaoaluno> evolucaoalunoCollectionNew = aluno.getEvolucaoalunoCollection();
            Collection<Ultimodiatreinoaluno> ultimodiatreinoalunoCollectionOld = persistentAluno.getUltimodiatreinoalunoCollection();
            Collection<Ultimodiatreinoaluno> ultimodiatreinoalunoCollectionNew = aluno.getUltimodiatreinoalunoCollection();
            Collection<Cadastroaluno> cadastroalunoCollectionOld = persistentAluno.getCadastroalunoCollection();
            Collection<Cadastroaluno> cadastroalunoCollectionNew = aluno.getCadastroalunoCollection();
            Collection<Treinos> treinosCollectionOld = persistentAluno.getTreinosCollection();
            Collection<Treinos> treinosCollectionNew = aluno.getTreinosCollection();
            List<String> illegalOrphanMessages = null;
            for (Evolucaoaluno evolucaoalunoCollectionOldEvolucaoaluno : evolucaoalunoCollectionOld) {
                if (!evolucaoalunoCollectionNew.contains(evolucaoalunoCollectionOldEvolucaoaluno)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Evolucaoaluno " + evolucaoalunoCollectionOldEvolucaoaluno + " since its alunoId field is not nullable.");
                }
            }
            for (Ultimodiatreinoaluno ultimodiatreinoalunoCollectionOldUltimodiatreinoaluno : ultimodiatreinoalunoCollectionOld) {
                if (!ultimodiatreinoalunoCollectionNew.contains(ultimodiatreinoalunoCollectionOldUltimodiatreinoaluno)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Ultimodiatreinoaluno " + ultimodiatreinoalunoCollectionOldUltimodiatreinoaluno + " since its alunoId field is not nullable.");
                }
            }
            for (Cadastroaluno cadastroalunoCollectionOldCadastroaluno : cadastroalunoCollectionOld) {
                if (!cadastroalunoCollectionNew.contains(cadastroalunoCollectionOldCadastroaluno)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Cadastroaluno " + cadastroalunoCollectionOldCadastroaluno + " since its alunoId field is not nullable.");
                }
            }
            for (Treinos treinosCollectionOldTreinos : treinosCollectionOld) {
                if (!treinosCollectionNew.contains(treinosCollectionOldTreinos)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Treinos " + treinosCollectionOldTreinos + " since its alunoId field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Collection<Evolucaoaluno> attachedEvolucaoalunoCollectionNew = new ArrayList<Evolucaoaluno>();
            for (Evolucaoaluno evolucaoalunoCollectionNewEvolucaoalunoToAttach : evolucaoalunoCollectionNew) {
                evolucaoalunoCollectionNewEvolucaoalunoToAttach = em.getReference(evolucaoalunoCollectionNewEvolucaoalunoToAttach.getClass(), evolucaoalunoCollectionNewEvolucaoalunoToAttach.getId());
                attachedEvolucaoalunoCollectionNew.add(evolucaoalunoCollectionNewEvolucaoalunoToAttach);
            }
            evolucaoalunoCollectionNew = attachedEvolucaoalunoCollectionNew;
            aluno.setEvolucaoalunoCollection(evolucaoalunoCollectionNew);
            Collection<Ultimodiatreinoaluno> attachedUltimodiatreinoalunoCollectionNew = new ArrayList<Ultimodiatreinoaluno>();
            for (Ultimodiatreinoaluno ultimodiatreinoalunoCollectionNewUltimodiatreinoalunoToAttach : ultimodiatreinoalunoCollectionNew) {
                ultimodiatreinoalunoCollectionNewUltimodiatreinoalunoToAttach = em.getReference(ultimodiatreinoalunoCollectionNewUltimodiatreinoalunoToAttach.getClass(), ultimodiatreinoalunoCollectionNewUltimodiatreinoalunoToAttach.getId());
                attachedUltimodiatreinoalunoCollectionNew.add(ultimodiatreinoalunoCollectionNewUltimodiatreinoalunoToAttach);
            }
            ultimodiatreinoalunoCollectionNew = attachedUltimodiatreinoalunoCollectionNew;
            aluno.setUltimodiatreinoalunoCollection(ultimodiatreinoalunoCollectionNew);
            Collection<Cadastroaluno> attachedCadastroalunoCollectionNew = new ArrayList<Cadastroaluno>();
            for (Cadastroaluno cadastroalunoCollectionNewCadastroalunoToAttach : cadastroalunoCollectionNew) {
                cadastroalunoCollectionNewCadastroalunoToAttach = em.getReference(cadastroalunoCollectionNewCadastroalunoToAttach.getClass(), cadastroalunoCollectionNewCadastroalunoToAttach.getId());
                attachedCadastroalunoCollectionNew.add(cadastroalunoCollectionNewCadastroalunoToAttach);
            }
            cadastroalunoCollectionNew = attachedCadastroalunoCollectionNew;
            aluno.setCadastroalunoCollection(cadastroalunoCollectionNew);
            Collection<Treinos> attachedTreinosCollectionNew = new ArrayList<Treinos>();
            for (Treinos treinosCollectionNewTreinosToAttach : treinosCollectionNew) {
                treinosCollectionNewTreinosToAttach = em.getReference(treinosCollectionNewTreinosToAttach.getClass(), treinosCollectionNewTreinosToAttach.getId());
                attachedTreinosCollectionNew.add(treinosCollectionNewTreinosToAttach);
            }
            treinosCollectionNew = attachedTreinosCollectionNew;
            aluno.setTreinosCollection(treinosCollectionNew);
            aluno = em.merge(aluno);
            for (Evolucaoaluno evolucaoalunoCollectionNewEvolucaoaluno : evolucaoalunoCollectionNew) {
                if (!evolucaoalunoCollectionOld.contains(evolucaoalunoCollectionNewEvolucaoaluno)) {
                    Aluno oldAlunoIdOfEvolucaoalunoCollectionNewEvolucaoaluno = evolucaoalunoCollectionNewEvolucaoaluno.getAlunoId();
                    evolucaoalunoCollectionNewEvolucaoaluno.setAlunoId(aluno);
                    evolucaoalunoCollectionNewEvolucaoaluno = em.merge(evolucaoalunoCollectionNewEvolucaoaluno);
                    if (oldAlunoIdOfEvolucaoalunoCollectionNewEvolucaoaluno != null && !oldAlunoIdOfEvolucaoalunoCollectionNewEvolucaoaluno.equals(aluno)) {
                        oldAlunoIdOfEvolucaoalunoCollectionNewEvolucaoaluno.getEvolucaoalunoCollection().remove(evolucaoalunoCollectionNewEvolucaoaluno);
                        oldAlunoIdOfEvolucaoalunoCollectionNewEvolucaoaluno = em.merge(oldAlunoIdOfEvolucaoalunoCollectionNewEvolucaoaluno);
                    }
                }
            }
            for (Ultimodiatreinoaluno ultimodiatreinoalunoCollectionNewUltimodiatreinoaluno : ultimodiatreinoalunoCollectionNew) {
                if (!ultimodiatreinoalunoCollectionOld.contains(ultimodiatreinoalunoCollectionNewUltimodiatreinoaluno)) {
                    Aluno oldAlunoIdOfUltimodiatreinoalunoCollectionNewUltimodiatreinoaluno = ultimodiatreinoalunoCollectionNewUltimodiatreinoaluno.getAlunoId();
                    ultimodiatreinoalunoCollectionNewUltimodiatreinoaluno.setAlunoId(aluno);
                    ultimodiatreinoalunoCollectionNewUltimodiatreinoaluno = em.merge(ultimodiatreinoalunoCollectionNewUltimodiatreinoaluno);
                    if (oldAlunoIdOfUltimodiatreinoalunoCollectionNewUltimodiatreinoaluno != null && !oldAlunoIdOfUltimodiatreinoalunoCollectionNewUltimodiatreinoaluno.equals(aluno)) {
                        oldAlunoIdOfUltimodiatreinoalunoCollectionNewUltimodiatreinoaluno.getUltimodiatreinoalunoCollection().remove(ultimodiatreinoalunoCollectionNewUltimodiatreinoaluno);
                        oldAlunoIdOfUltimodiatreinoalunoCollectionNewUltimodiatreinoaluno = em.merge(oldAlunoIdOfUltimodiatreinoalunoCollectionNewUltimodiatreinoaluno);
                    }
                }
            }
            for (Cadastroaluno cadastroalunoCollectionNewCadastroaluno : cadastroalunoCollectionNew) {
                if (!cadastroalunoCollectionOld.contains(cadastroalunoCollectionNewCadastroaluno)) {
                    Aluno oldAlunoIdOfCadastroalunoCollectionNewCadastroaluno = cadastroalunoCollectionNewCadastroaluno.getAlunoId();
                    cadastroalunoCollectionNewCadastroaluno.setAlunoId(aluno);
                    cadastroalunoCollectionNewCadastroaluno = em.merge(cadastroalunoCollectionNewCadastroaluno);
                    if (oldAlunoIdOfCadastroalunoCollectionNewCadastroaluno != null && !oldAlunoIdOfCadastroalunoCollectionNewCadastroaluno.equals(aluno)) {
                        oldAlunoIdOfCadastroalunoCollectionNewCadastroaluno.getCadastroalunoCollection().remove(cadastroalunoCollectionNewCadastroaluno);
                        oldAlunoIdOfCadastroalunoCollectionNewCadastroaluno = em.merge(oldAlunoIdOfCadastroalunoCollectionNewCadastroaluno);
                    }
                }
            }
            for (Treinos treinosCollectionNewTreinos : treinosCollectionNew) {
                if (!treinosCollectionOld.contains(treinosCollectionNewTreinos)) {
                    Aluno oldAlunoIdOfTreinosCollectionNewTreinos = treinosCollectionNewTreinos.getAlunoId();
                    treinosCollectionNewTreinos.setAlunoId(aluno);
                    treinosCollectionNewTreinos = em.merge(treinosCollectionNewTreinos);
                    if (oldAlunoIdOfTreinosCollectionNewTreinos != null && !oldAlunoIdOfTreinosCollectionNewTreinos.equals(aluno)) {
                        oldAlunoIdOfTreinosCollectionNewTreinos.getTreinosCollection().remove(treinosCollectionNewTreinos);
                        oldAlunoIdOfTreinosCollectionNewTreinos = em.merge(oldAlunoIdOfTreinosCollectionNewTreinos);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = aluno.getId();
                if (findAluno(id) == null) {
                    throw new NonexistentEntityException("The aluno with id " + id + " no longer exists.");
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
            Aluno aluno;
            try {
                aluno = em.getReference(Aluno.class, id);
                aluno.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The aluno with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Collection<Evolucaoaluno> evolucaoalunoCollectionOrphanCheck = aluno.getEvolucaoalunoCollection();
            for (Evolucaoaluno evolucaoalunoCollectionOrphanCheckEvolucaoaluno : evolucaoalunoCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Aluno (" + aluno + ") cannot be destroyed since the Evolucaoaluno " + evolucaoalunoCollectionOrphanCheckEvolucaoaluno + " in its evolucaoalunoCollection field has a non-nullable alunoId field.");
            }
            Collection<Ultimodiatreinoaluno> ultimodiatreinoalunoCollectionOrphanCheck = aluno.getUltimodiatreinoalunoCollection();
            for (Ultimodiatreinoaluno ultimodiatreinoalunoCollectionOrphanCheckUltimodiatreinoaluno : ultimodiatreinoalunoCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Aluno (" + aluno + ") cannot be destroyed since the Ultimodiatreinoaluno " + ultimodiatreinoalunoCollectionOrphanCheckUltimodiatreinoaluno + " in its ultimodiatreinoalunoCollection field has a non-nullable alunoId field.");
            }
            Collection<Cadastroaluno> cadastroalunoCollectionOrphanCheck = aluno.getCadastroalunoCollection();
            for (Cadastroaluno cadastroalunoCollectionOrphanCheckCadastroaluno : cadastroalunoCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Aluno (" + aluno + ") cannot be destroyed since the Cadastroaluno " + cadastroalunoCollectionOrphanCheckCadastroaluno + " in its cadastroalunoCollection field has a non-nullable alunoId field.");
            }
            Collection<Treinos> treinosCollectionOrphanCheck = aluno.getTreinosCollection();
            for (Treinos treinosCollectionOrphanCheckTreinos : treinosCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Aluno (" + aluno + ") cannot be destroyed since the Treinos " + treinosCollectionOrphanCheckTreinos + " in its treinosCollection field has a non-nullable alunoId field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(aluno);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Aluno> findAlunoEntities() {
        return findAlunoEntities(true, -1, -1);
    }

    public List<Aluno> findAlunoEntities(int maxResults, int firstResult) {
        return findAlunoEntities(false, maxResults, firstResult);
    }

    private List<Aluno> findAlunoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Aluno.class));
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

    public Aluno findAluno(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Aluno.class, id);
        } finally {
            em.close();
        }
    }

    public int getAlunoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Aluno> rt = cq.from(Aluno.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
