/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataBase;

import DAO.ModalidadesJpaController;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManagerFactory;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Persistence;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;
import javax.swing.JOptionPane;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author afnsoo
 */
@Entity
@Table(name = "modalidades", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"nome"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Modalidades.findAll", query = "SELECT m FROM Modalidades m"),
    @NamedQuery(name = "Modalidades.findById", query = "SELECT m FROM Modalidades m WHERE m.id = :id"),
    @NamedQuery(name = "Modalidades.findByNome", query = "SELECT m FROM Modalidades m WHERE m.nome = :nome"),
    @NamedQuery(name = "Modalidades.findByHorarioInicio", query = "SELECT m FROM Modalidades m WHERE m.horarioInicio = :horarioInicio"),
    @NamedQuery(name = "Modalidades.findByHorarioFinal", query = "SELECT m FROM Modalidades m WHERE m.horarioFinal = :horarioFinal"),
    @NamedQuery(name = "Modalidades.findByMaxAlunos", query = "SELECT m FROM Modalidades m WHERE m.maxAlunos = :maxAlunos"),
    @NamedQuery(name = "Modalidades.findByPreco", query = "SELECT m FROM Modalidades m WHERE m.preco = :preco")})
public class Modalidades implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "modalidadeId")
    private Collection<Ultimodiatreinoaluno> ultimodiatreinoalunoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "modalidadeId")
    private Collection<Cadastroaluno> cadastroalunoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "modalidadeId")
    private Collection<Treinos> treinosCollection;
    private static final long serialVersionUID = 1L;
    @Id @GeneratedValue
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(name = "nome", nullable = false, length = 40)
    private String nome;
    @Basic(optional = false)
    @Column(name = "horarioInicio", nullable = false)
    private float horarioInicio;
    @Basic(optional = false)
    @Column(name = "horarioFinal", nullable = false)
    private float horarioFinal;
    @Basic(optional = false)
    @Column(name = "maxAlunos", nullable = false)
    private float maxAlunos;
    @Basic(optional = false)
    @Column(name = "preco", nullable = false)
    private float preco;

    public Modalidades() {
    }

    public Modalidades(Integer id) {
        this.id = id;
    }

    public Modalidades(Integer id, String nome, float horarioInicio, float horarioFinal, float maxAlunos, float preco) {
        this.id = id;
        this.nome = nome;
        this.horarioInicio = horarioInicio;
        this.horarioFinal = horarioFinal;
        this.maxAlunos = maxAlunos;
        this.preco = preco;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        Integer oldId = this.id;
        this.id = id;
        changeSupport.firePropertyChange("id", oldId, id);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        String oldNome = this.nome;
        this.nome = nome;
        changeSupport.firePropertyChange("nome", oldNome, nome);
    }

    public float getHorarioInicio() {
        return horarioInicio;
    }

    public void setHorarioInicio(float horarioInicio) {
        float oldHorarioInicio = this.horarioInicio;
        this.horarioInicio = horarioInicio;
        changeSupport.firePropertyChange("horarioInicio", oldHorarioInicio, horarioInicio);
    }

    public float getHorarioFinal() {
        return horarioFinal;
    }

    public void setHorarioFinal(float horarioFinal) {
        float oldHorarioFinal = this.horarioFinal;
        this.horarioFinal = horarioFinal;
        changeSupport.firePropertyChange("horarioFinal", oldHorarioFinal, horarioFinal);
    }

    public float getMaxAlunos() {
        return maxAlunos;
    }

    public void setMaxAlunos(float maxAlunos) {
        float oldMaxAlunos = this.maxAlunos;
        this.maxAlunos = maxAlunos;
        changeSupport.firePropertyChange("maxAlunos", oldMaxAlunos, maxAlunos);
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        float oldPreco = this.preco;
        this.preco = preco;
        changeSupport.firePropertyChange("preco", oldPreco, preco);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Modalidades)) {
            return false;
        }
        Modalidades other = (Modalidades) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nome;
    }

    @XmlTransient
    public Collection<Ultimodiatreinoaluno> getUltimodiatreinoalunoCollection() {
        return ultimodiatreinoalunoCollection;
    }

    public void setUltimodiatreinoalunoCollection(Collection<Ultimodiatreinoaluno> ultimodiatreinoalunoCollection) {
        this.ultimodiatreinoalunoCollection = ultimodiatreinoalunoCollection;
    }

    @XmlTransient
    public Collection<Cadastroaluno> getCadastroalunoCollection() {
        return cadastroalunoCollection;
    }

    public void setCadastroalunoCollection(Collection<Cadastroaluno> cadastroalunoCollection) {
        this.cadastroalunoCollection = cadastroalunoCollection;
    }

    @XmlTransient
    public Collection<Treinos> getTreinosCollection() {
        return treinosCollection;
    }

    public void setTreinosCollection(Collection<Treinos> treinosCollection) {
        this.treinosCollection = treinosCollection;
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
    public void incluir(){
        try{
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("AcademiaVisualPU");
            ModalidadesJpaController modalidadeController = new ModalidadesJpaController(emf);
            modalidadeController.create(this);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public void alterar(){
        try{
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("AcademiaVisualPU");
            ModalidadesJpaController modalidadeController = new ModalidadesJpaController(emf);
            modalidadeController.edit(this);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public void excluir(){
        try{
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("AcademiaVisualPU");
            ModalidadesJpaController modalidadeController = new ModalidadesJpaController(emf);
            modalidadeController.destroy(this.getId());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
}
