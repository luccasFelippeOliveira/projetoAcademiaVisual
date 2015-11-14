/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataBase;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author afnsoo
 */
@Entity
@Table(name = "treinador")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Treinador.findAll", query = "SELECT t FROM Treinador t"),
    @NamedQuery(name = "Treinador.findById", query = "SELECT t FROM Treinador t WHERE t.id = :id"),
    @NamedQuery(name = "Treinador.findByNome", query = "SELECT t FROM Treinador t WHERE t.nome = :nome"),
    @NamedQuery(name = "Treinador.findByIdade", query = "SELECT t FROM Treinador t WHERE t.idade = :idade"),
    @NamedQuery(name = "Treinador.findByEndereco", query = "SELECT t FROM Treinador t WHERE t.endereco = :endereco"),
    @NamedQuery(name = "Treinador.findByTelefone", query = "SELECT t FROM Treinador t WHERE t.telefone = :telefone"),
    @NamedQuery(name = "Treinador.findByAdm", query = "SELECT t FROM Treinador t WHERE t.adm = :adm"),
    @NamedQuery(name = "Treinador.findByCpf", query = "SELECT t FROM Treinador t WHERE t.cpf = :cpf"),
    @NamedQuery(name = "Treinador.findByDatacriacao", query = "SELECT t FROM Treinador t WHERE t.datacriacao = :datacriacao")})
public class Treinador implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(name = "nome", nullable = false, length = 40)
    private String nome;
    @Basic(optional = false)
    @Column(name = "idade", nullable = false)
    private int idade;
    @Basic(optional = false)
    @Column(name = "endereco", nullable = false, length = 40)
    private String endereco;
    @Basic(optional = false)
    @Column(name = "telefone", nullable = false, length = 15)
    private String telefone;
    @Basic(optional = false)
    @Column(name = "adm", nullable = false)
    private int adm;
    @Basic(optional = false)
    @Column(name = "cpf", nullable = false, length = 15)
    private String cpf;
    @Basic(optional = false)
    @Column(name = "datacriacao", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date datacriacao;

    public Treinador() {
    }

    public Treinador(Integer id) {
        this.id = id;
    }

    public Treinador(Integer id, String nome, int idade, String endereco, String telefone, int adm, String cpf, Date datacriacao) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
        this.endereco = endereco;
        this.telefone = telefone;
        this.adm = adm;
        this.cpf = cpf;
        this.datacriacao = datacriacao;
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

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public int getAdm() {
        return adm;
    }

    public void setAdm(int adm) {
        this.adm = adm;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getDatacriacao() {
        return datacriacao;
    }

    public void setDatacriacao(Date datacriacao) {
        this.datacriacao = datacriacao;
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
        if (!(object instanceof Treinador)) {
            return false;
        }
        Treinador other = (Treinador) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DataBase.Treinador[ id=" + id + " ]";
    }
    
}
