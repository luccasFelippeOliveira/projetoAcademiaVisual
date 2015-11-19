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
import javax.persistence.UniqueConstraint;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author afnsoo
 */
@Entity
@Table(name = "treinador", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"cpf"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Treinador.findAll", query = "SELECT t FROM Treinador t"),
    @NamedQuery(name = "Treinador.findById", query = "SELECT t FROM Treinador t WHERE t.id = :id"),
    @NamedQuery(name = "Treinador.findByNome", query = "SELECT t FROM Treinador t WHERE t.nome = :nome"),
    @NamedQuery(name = "Treinador.findByCpf", query = "SELECT t FROM Treinador t WHERE t.cpf = :cpf"),
    @NamedQuery(name = "Treinador.findByDataNascimento", query = "SELECT t FROM Treinador t WHERE t.dataNascimento = :dataNascimento"),
    @NamedQuery(name = "Treinador.findByEndereco", query = "SELECT t FROM Treinador t WHERE t.endereco = :endereco"),
    @NamedQuery(name = "Treinador.findByLogin", query = "SELECT t FROM Treinador t WHERE t.login = :login"),
    @NamedQuery(name = "Treinador.findBySenha", query = "SELECT t FROM Treinador t WHERE t.senha = :senha"),
    @NamedQuery(name = "Treinador.findByAdministrador", query = "SELECT t FROM Treinador t WHERE t.administrador = :administrador"),
    @NamedQuery(name = "Treinador.findByEmail", query = "SELECT t FROM Treinador t WHERE t.email = :email")})
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
    @Column(name = "cpf", nullable = false, length = 15)
    private String cpf;
    @Basic(optional = false)
    @Column(name = "dataNascimento", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dataNascimento;
    @Basic(optional = false)
    @Column(name = "endereco", nullable = false, length = 40)
    private String endereco;
    @Basic(optional = false)
    @Column(name = "login", nullable = false, length = 15)
    private String login;
    @Basic(optional = false)
    @Column(name = "senha", nullable = false, length = 60)
    private String senha;
    @Basic(optional = false)
    @Column(name = "administrador", nullable = false)
    private int administrador;
    @Basic(optional = false)
    @Column(name = "email", nullable = false, length = 40)
    private String email;

    public Treinador() {
    }

    public Treinador(Integer id) {
        this.id = id;
    }

    public Treinador(Integer id, String nome, String cpf, Date dataNascimento, String endereco, String login, String senha, int administrador, String email) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.endereco = endereco;
        this.login = login;
        this.senha = senha;
        this.administrador = administrador;
        this.email = email;
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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getAdministrador() {
        return administrador;
    }

    public void setAdministrador(int administrador) {
        this.administrador = administrador;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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