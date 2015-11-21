/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataBase;

import DAO.AlunoJpaController;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Persistence;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "alunoId")
    private Collection<Evolucaoaluno> evolucaoalunoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "alunoId")
    private Collection<Ultimodiatreinoaluno> ultimodiatreinoalunoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "alunoId")
    private Collection<Cadastroaluno> cadastroalunoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "alunoId")
    private Collection<Treinos> treinosCollection;
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        String oldCpf = this.cpf;
        this.cpf = cpf;
        changeSupport.firePropertyChange("cpf", oldCpf, cpf);
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        Date oldDataNascimento = this.dataNascimento;
        this.dataNascimento = dataNascimento;
        changeSupport.firePropertyChange("dataNascimento", oldDataNascimento, dataNascimento);
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        float oldPeso = this.peso;
        this.peso = peso;
        changeSupport.firePropertyChange("peso", oldPeso, peso);
    }

    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        float oldAltura = this.altura;
        this.altura = altura;
        changeSupport.firePropertyChange("altura", oldAltura, altura);
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        String oldEndereco = this.endereco;
        this.endereco = endereco;
        changeSupport.firePropertyChange("endereco", oldEndereco, endereco);
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        String oldLogin = this.login;
        this.login = login;
        changeSupport.firePropertyChange("login", oldLogin, login);
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        String oldSenha = this.senha;
        this.senha = senha;
        changeSupport.firePropertyChange("senha", oldSenha, senha);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        String oldEmail = this.email;
        this.email = email;
        changeSupport.firePropertyChange("email", oldEmail, email);
    }

    public Date getValidade() {
        return validade;
    }

    public void setValidade(Date validade) {
        Date oldValidade = this.validade;
        this.validade = validade;
        changeSupport.firePropertyChange("validade", oldValidade, validade);
    }

    public Date getUltimaEntrada() {
        return ultimaEntrada;
    }

    public void setUltimaEntrada(Date ultimaEntrada) {
        Date oldUltimaEntrada = this.ultimaEntrada;
        this.ultimaEntrada = ultimaEntrada;
        changeSupport.firePropertyChange("ultimaEntrada", oldUltimaEntrada, ultimaEntrada);
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

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
    //funções para incluir, alterar e excluir utilizando o jpaController.
    public void incluir(){
        try{
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("AcademiaVisualPU");
            AlunoJpaController alunoController = new AlunoJpaController(emf);
            alunoController.create(this);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public void alterar(){
        try{
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("AcademiaVisualPU");
            AlunoJpaController alunoController = new AlunoJpaController(emf);
            alunoController.edit(this);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public void excluir(){
        try{
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("AcademiaVisualPU");
            AlunoJpaController alunoController = new AlunoJpaController(emf);
            alunoController.destroy(this.getId());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    @XmlTransient
    public Collection<Evolucaoaluno> getEvolucaoalunoCollection() {
        return evolucaoalunoCollection;
    }

    public void setEvolucaoalunoCollection(Collection<Evolucaoaluno> evolucaoalunoCollection) {
        this.evolucaoalunoCollection = evolucaoalunoCollection;
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
    
}
