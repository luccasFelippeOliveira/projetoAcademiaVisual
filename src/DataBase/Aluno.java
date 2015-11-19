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
@Table(name = "aluno", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"cpf"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Aluno.findAll", query = "SELECT a FROM Aluno a"),
    @NamedQuery(name = "Aluno.findById", query = "SELECT a FROM Aluno a WHERE a.id = :id"),
    @NamedQuery(name = "Aluno.findByNome", query = "SELECT a FROM Aluno a WHERE a.nome = :nome"),
    @NamedQuery(name = "Aluno.findByCpf", query = "SELECT a FROM Aluno a WHERE a.cpf = :cpf"),
    @NamedQuery(name = "Aluno.findByDataNascimento", query = "SELECT a FROM Aluno a WHERE a.dataNascimento = :dataNascimento"),
    @NamedQuery(name = "Aluno.findByPeso", query = "SELECT a FROM Aluno a WHERE a.peso = :peso"),
    @NamedQuery(name = "Aluno.findByAltura", query = "SELECT a FROM Aluno a WHERE a.altura = :altura"),
    @NamedQuery(name = "Aluno.findByEndereco", query = "SELECT a FROM Aluno a WHERE a.endereco = :endereco"),
    @NamedQuery(name = "Aluno.findByLogin", query = "SELECT a FROM Aluno a WHERE a.login = :login"),
    @NamedQuery(name = "Aluno.findBySenha", query = "SELECT a FROM Aluno a WHERE a.senha = :senha"),
    @NamedQuery(name = "Aluno.findByEmail", query = "SELECT a FROM Aluno a WHERE a.email = :email"),
    @NamedQuery(name = "Aluno.findByValidade", query = "SELECT a FROM Aluno a WHERE a.validade = :validade"),
    @NamedQuery(name = "Aluno.findByUltimaEntrada", query = "SELECT a FROM Aluno a WHERE a.ultimaEntrada = :ultimaEntrada")})
public class Aluno implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(name = "nome", nullable = false, length = 40)
    private String nome;
    @Basic(optional = false)
    @Column(name = "cpf", nullable = false, length = 14)
    private String cpf;
    @Basic(optional = false)
    @Column(name = "dataNascimento", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dataNascimento;
    @Basic(optional = false)
    @Column(name = "peso", nullable = false)
    private float peso;
    @Basic(optional = false)
    @Column(name = "altura", nullable = false)
    private float altura;
    @Basic(optional = false)
    @Column(name = "endereco", nullable = false, length = 40)
    private String endereco;
    @Basic(optional = false)
    @Column(name = "login", nullable = false, length = 10)
    private String login;
    @Basic(optional = false)
    @Column(name = "senha", nullable = false, length = 15)
    private String senha;
    @Basic(optional = false)
    @Column(name = "email", nullable = false, length = 40)
    private String email;
    @Basic(optional = false)
    @Column(name = "validade", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date validade;
    @Basic(optional = false)
    @Column(name = "ultimaEntrada", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date ultimaEntrada;

    public Aluno() {
    }

    public Aluno(Integer id) {
        this.id = id;
    }

    public Aluno(Integer id, String nome, String cpf, Date dataNascimento, float peso, float altura, String endereco, String login, String senha, String email, Date validade, Date ultimaEntrada) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.peso = peso;
        this.altura = altura;
        this.endereco = endereco;
        this.login = login;
        this.senha = senha;
        this.email = email;
        this.validade = validade;
        this.ultimaEntrada = ultimaEntrada;
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

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getValidade() {
        return validade;
    }

    public void setValidade(Date validade) {
        this.validade = validade;
    }

    public Date getUltimaEntrada() {
        return ultimaEntrada;
    }

    public void setUltimaEntrada(Date ultimaEntrada) {
        this.ultimaEntrada = ultimaEntrada;
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
        if (!(object instanceof Aluno)) {
            return false;
        }
        Aluno other = (Aluno) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DataBase.Aluno[ id=" + id + " ]";
    }
    
}
