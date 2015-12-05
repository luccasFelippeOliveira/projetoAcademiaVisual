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
import DataBase.Cadastroaluno;
import DataBase.Treinador;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

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
        if (treinador.getCadastroalunoCollection() == null) {
            treinador.setCadastroalunoCollection(new ArrayList<Cadastroaluno>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Collection<Cadastroaluno> attachedCadastroalunoCollection = new ArrayList<Cadastroaluno>();
            for (Cadastroaluno cadastroalunoCollectionCadastroalunoToAttach : treinador.getCadastroalunoCollection()) {
                cadastroalunoCollectionCadastroalunoToAttach = em.getReference(cadastroalunoCollectionCadastroalunoToAttach.getClass(), cadastroalunoCollectionCadastroalunoToAttach.getId());
                attachedCadastroalunoCollection.add(cadastroalunoCollectionCadastroalunoToAttach);
            }
            treinador.setCadastroalunoCollection(attachedCadastroalunoCollection);
            em.persist(treinador);
            for (Cadastroaluno cadastroalunoCollectionCadastroaluno : treinador.getCadastroalunoCollection()) {
                Treinador oldTreinadorIdOfCadastroalunoCollectionCadastroaluno = cadastroalunoCollectionCadastroaluno.getTreinadorId();
                cadastroalunoCollectionCadastroaluno.setTreinadorId(treinador);
                cadastroalunoCollectionCadastroaluno = em.merge(cadastroalunoCollectionCadastroaluno);
                if (oldTreinadorIdOfCadastroalunoCollectionCadastroaluno != null) {
                    oldTreinadorIdOfCadastroalunoCollectionCadastroaluno.getCadastroalunoCollection().remove(cadastroalunoCollectionCadastroaluno);
                    oldTreinadorIdOfCadastroalunoCollectionCadastroaluno = em.merge(oldTreinadorIdOfCadastroalunoCollectionCadastroaluno);
                }
            }
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
            Treinador persistentTreinador = em.find(Treinador.class, treinador.getId());
            Collection<Cadastroaluno> cadastroalunoCollectionOld = persistentTreinador.getCadastroalunoCollection();
            Collection<Cadastroaluno> cadastroalunoCollectionNew = treinador.getCadastroalunoCollection();
            Collection<Cadastroaluno> attachedCadastroalunoCollectionNew = new ArrayList<Cadastroaluno>();
            for (Cadastroaluno cadastroalunoCollectionNewCadastroalunoToAttach : cadastroalunoCollectionNew) {
                cadastroalunoCollectionNewCadastroalunoToAttach = em.getReference(cadastroalunoCollectionNewCadastroalunoToAttach.getClass(), cadastroalunoCollectionNewCadastroalunoToAttach.getId());
                attachedCadastroalunoCollectionNew.add(cadastroalunoCollectionNewCadastroalunoToAttach);
            }
            cadastroalunoCollectionNew = attachedCadastroalunoCollectionNew;
            treinador.setCadastroalunoCollection(cadastroalunoCollectionNew);
            treinador = em.merge(treinador);
            for (Cadastroaluno cadastroalunoCollectionOldCadastroaluno : cadastroalunoCollectionOld) {
                if (!cadastroalunoCollectionNew.contains(cadastroalunoCollectionOldCadastroaluno)) {
                    cadastroalunoCollectionOldCadastroaluno.setTreinadorId(null);
                    cadastroalunoCollectionOldCadastroaluno = em.merge(cadastroalunoCollectionOldCadastroaluno);
                }
            }
            for (Cadastroaluno cadastroalunoCollectionNewCadastroaluno : cadastroalunoCollectionNew) {
                if (!cadastroalunoCollectionOld.contains(cadastroalunoCollectionNewCadastroaluno)) {
                    Treinador oldTreinadorIdOfCadastroalunoCollectionNewCadastroaluno = cadastroalunoCollectionNewCadastroaluno.getTreinadorId();
                    cadastroalunoCollectionNewCadastroaluno.setTreinadorId(treinador);
                    cadastroalunoCollectionNewCadastroaluno = em.merge(cadastroalunoCollectionNewCadastroaluno);
                    if (oldTreinadorIdOfCadastroalunoCollectionNewCadastroaluno != null && !oldTreinadorIdOfCadastroalunoCollectionNewCadastroaluno.equals(treinador)) {
                        oldTreinadorIdOfCadastroalunoCollectionNewCadastroaluno.getCadastroalunoCollection().remove(cadastroalunoCollectionNewCadastroaluno);
                        oldTreinadorIdOfCadastroalunoCollectionNewCadastroaluno = em.merge(oldTreinadorIdOfCadastroalunoCollectionNewCadastroaluno);
                    }
                }
            }
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
            Collection<Cadastroaluno> cadastroalunoCollection = treinador.getCadastroalunoCollection();
            for (Cadastroaluno cadastroalunoCollectionCadastroaluno : cadastroalunoCollection) {
                cadastroalunoCollectionCadastroaluno.setTreinadorId(null);
                cadastroalunoCollectionCadastroaluno = em.merge(cadastroalunoCollectionCadastroaluno);
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
    
        public Treinador findLogin(String login) {
        EntityManager em = getEntityManager();
        try {
            return em.createNamedQuery("Treinador.findByLogin", Treinador.class).setParameter("login", login).getSingleResult();
        } catch (Exception e) {            
            return null;
        } finally {
            em.close();
        }
    }
    
}
