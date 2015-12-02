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
import javax.persistence.GeneratedValue;
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
@Table(name = "ultimodiatreinoaluno")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ultimodiatreinoaluno.findAll", query = "SELECT u FROM Ultimodiatreinoaluno u"),
    @NamedQuery(name = "Ultimodiatreinoaluno.findByUltimoDia", query = "SELECT u FROM Ultimodiatreinoaluno u WHERE u.ultimoDia = :ultimoDia"),
    @NamedQuery(name = "Ultimodiatreinoaluno.findById", query = "SELECT u FROM Ultimodiatreinoaluno u WHERE u.id = :id")})
public class Ultimodiatreinoaluno implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "ultimoDia", nullable = false)
    private int ultimoDia;
    @Id @GeneratedValue
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @JoinColumn(name = "alunoId", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Aluno alunoId;
    @JoinColumn(name = "modalidadeId", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Modalidades modalidadeId;

    public Ultimodiatreinoaluno() {
    }

    public Ultimodiatreinoaluno(Integer id) {
        this.id = id;
    }

    public Ultimodiatreinoaluno(Integer id, int ultimoDia) {
        this.id = id;
        this.ultimoDia = ultimoDia;
    }

    public int getUltimoDia() {
        return ultimoDia;
    }

    public void setUltimoDia(int ultimoDia) {
        this.ultimoDia = ultimoDia;
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
        if (!(object instanceof Ultimodiatreinoaluno)) {
            return false;
        }
        Ultimodiatreinoaluno other = (Ultimodiatreinoaluno) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DataBase.Ultimodiatreinoaluno[ id=" + id + " ]";
    }
    
}
