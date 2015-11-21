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
@Table(name = "treinos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Treinos.findAll", query = "SELECT t FROM Treinos t"),
    @NamedQuery(name = "Treinos.findByRepeticoes", query = "SELECT t FROM Treinos t WHERE t.repeticoes = :repeticoes"),
    @NamedQuery(name = "Treinos.findBySeries", query = "SELECT t FROM Treinos t WHERE t.series = :series"),
    @NamedQuery(name = "Treinos.findByDia", query = "SELECT t FROM Treinos t WHERE t.dia = :dia"),
    @NamedQuery(name = "Treinos.findById", query = "SELECT t FROM Treinos t WHERE t.id = :id")})
public class Treinos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "repeticoes", nullable = false)
    private int repeticoes;
    @Basic(optional = false)
    @Column(name = "series", nullable = false)
    private int series;
    @Basic(optional = false)
    @Column(name = "dia", nullable = false)
    private int dia;
    @Id
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @JoinColumn(name = "alunoId", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Aluno alunoId;
    @JoinColumn(name = "exercicioId", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Exercicios exercicioId;
    @JoinColumn(name = "modalidadeId", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Modalidades modalidadeId;

    public Treinos() {
    }

    public Treinos(Integer id) {
        this.id = id;
    }

    public Treinos(Integer id, int repeticoes, int series, int dia) {
        this.id = id;
        this.repeticoes = repeticoes;
        this.series = series;
        this.dia = dia;
    }

    public int getRepeticoes() {
        return repeticoes;
    }

    public void setRepeticoes(int repeticoes) {
        this.repeticoes = repeticoes;
    }

    public int getSeries() {
        return series;
    }

    public void setSeries(int series) {
        this.series = series;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
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

    public Exercicios getExercicioId() {
        return exercicioId;
    }

    public void setExercicioId(Exercicios exercicioId) {
        this.exercicioId = exercicioId;
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
        if (!(object instanceof Treinos)) {
            return false;
        }
        Treinos other = (Treinos) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DataBase.Treinos[ id=" + id + " ]";
    }
    
}
