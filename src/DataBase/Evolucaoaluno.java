/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataBase;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author afnsoo
 */
@Entity
@Table(name = "evolucaoaluno")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Evolucaoaluno.findAll", query = "SELECT e FROM Evolucaoaluno e"),
    @NamedQuery(name = "Evolucaoaluno.findByPercGordura", query = "SELECT e FROM Evolucaoaluno e WHERE e.percGordura = :percGordura"),
    @NamedQuery(name = "Evolucaoaluno.findByPercMassaMagra", query = "SELECT e FROM Evolucaoaluno e WHERE e.percMassaMagra = :percMassaMagra"),
    @NamedQuery(name = "Evolucaoaluno.findByDataMedicao", query = "SELECT e FROM Evolucaoaluno e WHERE e.dataMedicao = :dataMedicao"),
    @NamedQuery(name = "Evolucaoaluno.findByPeso", query = "SELECT e FROM Evolucaoaluno e WHERE e.peso = :peso"),
    @NamedQuery(name = "Evolucaoaluno.findById", query = "SELECT e FROM Evolucaoaluno e WHERE e.id = :id")})
public class Evolucaoaluno implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "percGordura", nullable = false)
    private float percGordura;
    @Basic(optional = false)
    @Column(name = "percMassaMagra", nullable = false)
    private float percMassaMagra;
    @Basic(optional = false)
    @Column(name = "dataMedicao", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dataMedicao;
    @Basic(optional = false)
    @Column(name = "peso", nullable = false)
    private float peso;
    @Id @GeneratedValue
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @JoinColumn(name = "alunoId", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Aluno alunoId;

    public Evolucaoaluno() {
    }

    public Evolucaoaluno(Integer id) {
        this.id = id;
    }

    public Evolucaoaluno(Integer id, float percGordura, float percMassaMagra, Date dataMedicao, float peso) {
        this.id = id;
        this.percGordura = percGordura;
        this.percMassaMagra = percMassaMagra;
        this.dataMedicao = dataMedicao;
        this.peso = peso;
    }

    public float getPercGordura() {
        return percGordura;
    }

    public void setPercGordura(float percGordura) {
        float oldPercGordura = this.percGordura;
        this.percGordura = percGordura;
        changeSupport.firePropertyChange("percGordura", oldPercGordura, percGordura);
    }

    public float getPercMassaMagra() {
        return percMassaMagra;
    }

    public void setPercMassaMagra(float percMassaMagra) {
        float oldPercMassaMagra = this.percMassaMagra;
        this.percMassaMagra = percMassaMagra;
        changeSupport.firePropertyChange("percMassaMagra", oldPercMassaMagra, percMassaMagra);
    }

    public Date getDataMedicao() {
        return dataMedicao;
    }

    public void setDataMedicao(Date dataMedicao) {
        Date oldDataMedicao = this.dataMedicao;
        this.dataMedicao = dataMedicao;
        changeSupport.firePropertyChange("dataMedicao", oldDataMedicao, dataMedicao);
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        float oldPeso = this.peso;
        this.peso = peso;
        changeSupport.firePropertyChange("peso", oldPeso, peso);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        Integer oldId = this.id;
        this.id = id;
        changeSupport.firePropertyChange("id", oldId, id);
    }

    public Aluno getAlunoId() {
        return alunoId;
    }

    public void setAlunoId(Aluno alunoId) {
        Aluno oldAlunoId = this.alunoId;
        this.alunoId = alunoId;
        changeSupport.firePropertyChange("alunoId", oldAlunoId, alunoId);
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
        if (!(object instanceof Evolucaoaluno)) {
            return false;
        }
        Evolucaoaluno other = (Evolucaoaluno) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DataBase.Evolucaoaluno[ id=" + id + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
