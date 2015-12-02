/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DAO.exceptions.IllegalOrphanException;
import DAO.exceptions.NonexistentEntityException;
import DAO.exceptions.PreexistingEntityException;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import DataBase.Ultimodiatreinoaluno;
import java.util.ArrayList;
import java.util.Collection;
import DataBase.Cadastroaluno;
import DataBase.Modalidades;
import DataBase.Treinos;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

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
        if (modalidades.getUltimodiatreinoalunoCollection() == null) {
            modalidades.setUltimodiatreinoalunoCollection(new ArrayList<Ultimodiatreinoaluno>());
        }
        if (modalidades.getCadastroalunoCollection() == null) {
            modalidades.setCadastroalunoCollection(new ArrayList<Cadastroaluno>());
        }
        if (modalidades.getTreinosCollection() == null) {
            modalidades.setTreinosCollection(new ArrayList<Treinos>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Collection<Ultimodiatreinoaluno> attachedUltimodiatreinoalunoCollection = new ArrayList<Ultimodiatreinoaluno>();
            for (Ultimodiatreinoaluno ultimodiatreinoalunoCollectionUltimodiatreinoalunoToAttach : modalidades.getUltimodiatreinoalunoCollection()) {
                ultimodiatreinoalunoCollectionUltimodiatreinoalunoToAttach = em.getReference(ultimodiatreinoalunoCollectionUltimodiatreinoalunoToAttach.getClass(), ultimodiatreinoalunoCollectionUltimodiatreinoalunoToAttach.getId());
                attachedUltimodiatreinoalunoCollection.add(ultimodiatreinoalunoCollectionUltimodiatreinoalunoToAttach);
            }
            modalidades.setUltimodiatreinoalunoCollection(attachedUltimodiatreinoalunoCollection);
            Collection<Cadastroaluno> attachedCadastroalunoCollection = new ArrayList<Cadastroaluno>();
            for (Cadastroaluno cadastroalunoCollectionCadastroalunoToAttach : modalidades.getCadastroalunoCollection()) {
                cadastroalunoCollectionCadastroalunoToAttach = em.getReference(cadastroalunoCollectionCadastroalunoToAttach.getClass(), cadastroalunoCollectionCadastroalunoToAttach.getId());
                attachedCadastroalunoCollection.add(cadastroalunoCollectionCadastroalunoToAttach);
            }
            modalidades.setCadastroalunoCollection(attachedCadastroalunoCollection);
            Collection<Treinos> attachedTreinosCollection = new ArrayList<Treinos>();
            for (Treinos treinosCollectionTreinosToAttach : modalidades.getTreinosCollection()) {
                treinosCollectionTreinosToAttach = em.getReference(treinosCollectionTreinosToAttach.getClass(), treinosCollectionTreinosToAttach.getId());
                attachedTreinosCollection.add(treinosCollectionTreinosToAttach);
            }
            modalidades.setTreinosCollection(attachedTreinosCollection);
            em.persist(modalidades);
            for (Ultimodiatreinoaluno ultimodiatreinoalunoCollectionUltimodiatreinoaluno : modalidades.getUltimodiatreinoalunoCollection()) {
                Modalidades oldModalidadeIdOfUltimodiatreinoalunoCollectionUltimodiatreinoaluno = ultimodiatreinoalunoCollectionUltimodiatreinoaluno.getModalidadeId();
                ultimodiatreinoalunoCollectionUltimodiatreinoaluno.setModalidadeId(modalidades);
                ultimodiatreinoalunoCollectionUltimodiatreinoaluno = em.merge(ultimodiatreinoalunoCollectionUltimodiatreinoaluno);
                if (oldModalidadeIdOfUltimodiatreinoalunoCollectionUltimodiatreinoaluno != null) {
                    oldModalidadeIdOfUltimodiatreinoalunoCollectionUltimodiatreinoaluno.getUltimodiatreinoalunoCollection().remove(ultimodiatreinoalunoCollectionUltimodiatreinoaluno);
                    oldModalidadeIdOfUltimodiatreinoalunoCollectionUltimodiatreinoaluno = em.merge(oldModalidadeIdOfUltimodiatreinoalunoCollectionUltimodiatreinoaluno);
                }
            }
            for (Cadastroaluno cadastroalunoCollectionCadastroaluno : modalidades.getCadastroalunoCollection()) {
                Modalidades oldModalidadeIdOfCadastroalunoCollectionCadastroaluno = cadastroalunoCollectionCadastroaluno.getModalidadeId();
                cadastroalunoCollectionCadastroaluno.setModalidadeId(modalidades);
                cadastroalunoCollectionCadastroaluno = em.merge(cadastroalunoCollectionCadastroaluno);
                if (oldModalidadeIdOfCadastroalunoCollectionCadastroaluno != null) {
                    oldModalidadeIdOfCadastroalunoCollectionCadastroaluno.getCadastroalunoCollection().remove(cadastroalunoCollectionCadastroaluno);
                    oldModalidadeIdOfCadastroalunoCollectionCadastroaluno = em.merge(oldModalidadeIdOfCadastroalunoCollectionCadastroaluno);
                }
            }
            for (Treinos treinosCollectionTreinos : modalidades.getTreinosCollection()) {
                Modalidades oldModalidadeIdOfTreinosCollectionTreinos = treinosCollectionTreinos.getModalidadeId();
                treinosCollectionTreinos.setModalidadeId(modalidades);
                treinosCollectionTreinos = em.merge(treinosCollectionTreinos);
                if (oldModalidadeIdOfTreinosCollectionTreinos != null) {
                    oldModalidadeIdOfTreinosCollectionTreinos.getTreinosCollection().remove(treinosCollectionTreinos);
                    oldModalidadeIdOfTreinosCollectionTreinos = em.merge(oldModalidadeIdOfTreinosCollectionTreinos);
                }
            }
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

    public void edit(Modalidades modalidades) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Modalidades persistentModalidades = em.find(Modalidades.class, modalidades.getId());
            Collection<Ultimodiatreinoaluno> ultimodiatreinoalunoCollectionOld = persistentModalidades.getUltimodiatreinoalunoCollection();
            Collection<Ultimodiatreinoaluno> ultimodiatreinoalunoCollectionNew = modalidades.getUltimodiatreinoalunoCollection();
            Collection<Cadastroaluno> cadastroalunoCollectionOld = persistentModalidades.getCadastroalunoCollection();
            Collection<Cadastroaluno> cadastroalunoCollectionNew = modalidades.getCadastroalunoCollection();
            Collection<Treinos> treinosCollectionOld = persistentModalidades.getTreinosCollection();
            Collection<Treinos> treinosCollectionNew = modalidades.getTreinosCollection();
            List<String> illegalOrphanMessages = null;
            for (Ultimodiatreinoaluno ultimodiatreinoalunoCollectionOldUltimodiatreinoaluno : ultimodiatreinoalunoCollectionOld) {
                if (!ultimodiatreinoalunoCollectionNew.contains(ultimodiatreinoalunoCollectionOldUltimodiatreinoaluno)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Ultimodiatreinoaluno " + ultimodiatreinoalunoCollectionOldUltimodiatreinoaluno + " since its modalidadeId field is not nullable.");
                }
            }
            for (Cadastroaluno cadastroalunoCollectionOldCadastroaluno : cadastroalunoCollectionOld) {
                if (!cadastroalunoCollectionNew.contains(cadastroalunoCollectionOldCadastroaluno)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Cadastroaluno " + cadastroalunoCollectionOldCadastroaluno + " since its modalidadeId field is not nullable.");
                }
            }
            for (Treinos treinosCollectionOldTreinos : treinosCollectionOld) {
                if (!treinosCollectionNew.contains(treinosCollectionOldTreinos)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Treinos " + treinosCollectionOldTreinos + " since its modalidadeId field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Collection<Ultimodiatreinoaluno> attachedUltimodiatreinoalunoCollectionNew = new ArrayList<Ultimodiatreinoaluno>();
            for (Ultimodiatreinoaluno ultimodiatreinoalunoCollectionNewUltimodiatreinoalunoToAttach : ultimodiatreinoalunoCollectionNew) {
                ultimodiatreinoalunoCollectionNewUltimodiatreinoalunoToAttach = em.getReference(ultimodiatreinoalunoCollectionNewUltimodiatreinoalunoToAttach.getClass(), ultimodiatreinoalunoCollectionNewUltimodiatreinoalunoToAttach.getId());
                attachedUltimodiatreinoalunoCollectionNew.add(ultimodiatreinoalunoCollectionNewUltimodiatreinoalunoToAttach);
            }
            ultimodiatreinoalunoCollectionNew = attachedUltimodiatreinoalunoCollectionNew;
            modalidades.setUltimodiatreinoalunoCollection(ultimodiatreinoalunoCollectionNew);
            Collection<Cadastroaluno> attachedCadastroalunoCollectionNew = new ArrayList<Cadastroaluno>();
            for (Cadastroaluno cadastroalunoCollectionNewCadastroalunoToAttach : cadastroalunoCollectionNew) {
                cadastroalunoCollectionNewCadastroalunoToAttach = em.getReference(cadastroalunoCollectionNewCadastroalunoToAttach.getClass(), cadastroalunoCollectionNewCadastroalunoToAttach.getId());
                attachedCadastroalunoCollectionNew.add(cadastroalunoCollectionNewCadastroalunoToAttach);
            }
            cadastroalunoCollectionNew = attachedCadastroalunoCollectionNew;
            modalidades.setCadastroalunoCollection(cadastroalunoCollectionNew);
            Collection<Treinos> attachedTreinosCollectionNew = new ArrayList<Treinos>();
            for (Treinos treinosCollectionNewTreinosToAttach : treinosCollectionNew) {
                treinosCollectionNewTreinosToAttach = em.getReference(treinosCollectionNewTreinosToAttach.getClass(), treinosCollectionNewTreinosToAttach.getId());
                attachedTreinosCollectionNew.add(treinosCollectionNewTreinosToAttach);
            }
            treinosCollectionNew = attachedTreinosCollectionNew;
            modalidades.setTreinosCollection(treinosCollectionNew);
            modalidades = em.merge(modalidades);
            for (Ultimodiatreinoaluno ultimodiatreinoalunoCollectionNewUltimodiatreinoaluno : ultimodiatreinoalunoCollectionNew) {
                if (!ultimodiatreinoalunoCollectionOld.contains(ultimodiatreinoalunoCollectionNewUltimodiatreinoaluno)) {
                    Modalidades oldModalidadeIdOfUltimodiatreinoalunoCollectionNewUltimodiatreinoaluno = ultimodiatreinoalunoCollectionNewUltimodiatreinoaluno.getModalidadeId();
                    ultimodiatreinoalunoCollectionNewUltimodiatreinoaluno.setModalidadeId(modalidades);
                    ultimodiatreinoalunoCollectionNewUltimodiatreinoaluno = em.merge(ultimodiatreinoalunoCollectionNewUltimodiatreinoaluno);
                    if (oldModalidadeIdOfUltimodiatreinoalunoCollectionNewUltimodiatreinoaluno != null && !oldModalidadeIdOfUltimodiatreinoalunoCollectionNewUltimodiatreinoaluno.equals(modalidades)) {
                        oldModalidadeIdOfUltimodiatreinoalunoCollectionNewUltimodiatreinoaluno.getUltimodiatreinoalunoCollection().remove(ultimodiatreinoalunoCollectionNewUltimodiatreinoaluno);
                        oldModalidadeIdOfUltimodiatreinoalunoCollectionNewUltimodiatreinoaluno = em.merge(oldModalidadeIdOfUltimodiatreinoalunoCollectionNewUltimodiatreinoaluno);
                    }
                }
            }
            for (Cadastroaluno cadastroalunoCollectionNewCadastroaluno : cadastroalunoCollectionNew) {
                if (!cadastroalunoCollectionOld.contains(cadastroalunoCollectionNewCadastroaluno)) {
                    Modalidades oldModalidadeIdOfCadastroalunoCollectionNewCadastroaluno = cadastroalunoCollectionNewCadastroaluno.getModalidadeId();
                    cadastroalunoCollectionNewCadastroaluno.setModalidadeId(modalidades);
                    cadastroalunoCollectionNewCadastroaluno = em.merge(cadastroalunoCollectionNewCadastroaluno);
                    if (oldModalidadeIdOfCadastroalunoCollectionNewCadastroaluno != null && !oldModalidadeIdOfCadastroalunoCollectionNewCadastroaluno.equals(modalidades)) {
                        oldModalidadeIdOfCadastroalunoCollectionNewCadastroaluno.getCadastroalunoCollection().remove(cadastroalunoCollectionNewCadastroaluno);
                        oldModalidadeIdOfCadastroalunoCollectionNewCadastroaluno = em.merge(oldModalidadeIdOfCadastroalunoCollectionNewCadastroaluno);
                    }
                }
            }
            for (Treinos treinosCollectionNewTreinos : treinosCollectionNew) {
                if (!treinosCollectionOld.contains(treinosCollectionNewTreinos)) {
                    Modalidades oldModalidadeIdOfTreinosCollectionNewTreinos = treinosCollectionNewTreinos.getModalidadeId();
                    treinosCollectionNewTreinos.setModalidadeId(modalidades);
                    treinosCollectionNewTreinos = em.merge(treinosCollectionNewTreinos);
                    if (oldModalidadeIdOfTreinosCollectionNewTreinos != null && !oldModalidadeIdOfTreinosCollectionNewTreinos.equals(modalidades)) {
                        oldModalidadeIdOfTreinosCollectionNewTreinos.getTreinosCollection().remove(treinosCollectionNewTreinos);
                        oldModalidadeIdOfTreinosCollectionNewTreinos = em.merge(oldModalidadeIdOfTreinosCollectionNewTreinos);
                    }
                }
            }
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

    public void destroy(Integer id) throws IllegalOrphanException, NonexistentEntityException {
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
            List<String> illegalOrphanMessages = null;
            Collection<Ultimodiatreinoaluno> ultimodiatreinoalunoCollectionOrphanCheck = modalidades.getUltimodiatreinoalunoCollection();
            for (Ultimodiatreinoaluno ultimodiatreinoalunoCollectionOrphanCheckUltimodiatreinoaluno : ultimodiatreinoalunoCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Modalidades (" + modalidades + ") cannot be destroyed since the Ultimodiatreinoaluno " + ultimodiatreinoalunoCollectionOrphanCheckUltimodiatreinoaluno + " in its ultimodiatreinoalunoCollection field has a non-nullable modalidadeId field.");
            }
            Collection<Cadastroaluno> cadastroalunoCollectionOrphanCheck = modalidades.getCadastroalunoCollection();
            for (Cadastroaluno cadastroalunoCollectionOrphanCheckCadastroaluno : cadastroalunoCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Modalidades (" + modalidades + ") cannot be destroyed since the Cadastroaluno " + cadastroalunoCollectionOrphanCheckCadastroaluno + " in its cadastroalunoCollection field has a non-nullable modalidadeId field.");
            }
            Collection<Treinos> treinosCollectionOrphanCheck = modalidades.getTreinosCollection();
            for (Treinos treinosCollectionOrphanCheckTreinos : treinosCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Modalidades (" + modalidades + ") cannot be destroyed since the Treinos " + treinosCollectionOrphanCheckTreinos + " in its treinosCollection field has a non-nullable modalidadeId field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
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
    
    public Modalidades findModalidadeByNome(String nome) {
        EntityManager em = getEntityManager();
        try {
            return em.createNamedQuery("Modalidades.findByNome", Modalidades.class).setParameter("nome", nome).getSingleResult();
        } catch (Exception e) {            
            return null;
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
