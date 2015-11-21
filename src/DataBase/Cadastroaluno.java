/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataBase;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author afnsoo
 */
@Entity
@Table(name = "cadastroaluno")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cadastroaluno.findAll", query = "SELECT c FROM Cadastroaluno c"),
    @NamedQuery(name = "Cadastroaluno.findById", query = "SELECT c FROM Cadastroaluno c WHERE c.id = :id")})
public class Cadastroaluno implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @JoinColumn(name = "alunoId", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Aluno alunoId;
    @JoinColumn(name = "treinadorId", referencedColumnName = "id")
    @ManyToOne
    private Treinador treinadorId;
    @JoinColumn(name = "modalidadeId", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Modalidades modalidadeId;

    public Cadastroaluno() {
    }

    public Cadastroaluno(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Aluno getAlunoId() {
        return alunoId;
    }

    public void setAlunoId(Aluno alunoId) {
        this.alunoId = alunoId;
    }

    public Treinador getTreinadorId() {
        return treinadorId;
    }

    public void setTreinadorId(Treinador treinadorId) {
        this.treinadorId = treinadorId;
    }

    public Modalidades getModalidadeId() {
        return modalidadeId;
    }

    public void setModalidadeId(Modalidades modalidadeId) {
        this.modalidadeId = modalidadeId;
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
        if (!(object instanceof Cadastroaluno)) {
            return false;
        }
        Cadastroaluno other = (Cadastroaluno) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DataBase.Cadastroaluno[ id=" + id + " ]";
    }
    
}
