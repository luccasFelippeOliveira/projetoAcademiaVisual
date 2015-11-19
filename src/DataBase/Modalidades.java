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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.xml.bind.annotation.XmlRootElement;

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
    private static final long serialVersionUID = 1L;
    @Id
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
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getHorarioInicio() {
        return horarioInicio;
    }

    public void setHorarioInicio(float horarioInicio) {
        this.horarioInicio = horarioInicio;
    }

    public float getHorarioFinal() {
        return horarioFinal;
    }

    public void setHorarioFinal(float horarioFinal) {
        this.horarioFinal = horarioFinal;
    }

    public float getMaxAlunos() {
        return maxAlunos;
    }

    public void setMaxAlunos(float maxAlunos) {
        this.maxAlunos = maxAlunos;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
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
        return "DataBase.Modalidades[ id=" + id + " ]";
    }
    
}
