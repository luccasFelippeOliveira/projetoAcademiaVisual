/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataBase;

import DAO.ModalidadesJpaController;
import DAO.ProdutosJpaController;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManagerFactory;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Persistence;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.swing.JOptionPane;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author afnsoo
 */
@Entity
@Table(name = "produtos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Produtos.findAll", query = "SELECT p FROM Produtos p"),
    @NamedQuery(name = "Produtos.findById", query = "SELECT p FROM Produtos p WHERE p.id = :id"),
    @NamedQuery(name = "Produtos.findByNome", query = "SELECT p FROM Produtos p WHERE p.nome = :nome"),
    @NamedQuery(name = "Produtos.findByPreco", query = "SELECT p FROM Produtos p WHERE p.preco = :preco"),
    @NamedQuery(name = "Produtos.findByDesconto", query = "SELECT p FROM Produtos p WHERE p.desconto = :desconto")})
public class Produtos implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id @GeneratedValue
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(name = "nome", nullable = false, length = 40)
    private String nome;
    @Basic(optional = false)
    @Lob
    @Column(name = "descricao", nullable = false, length = 65535)
    private String descricao;
    @Basic(optional = false)
    @Column(name = "preco", nullable = false)
    private float preco;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "desconto", precision = 12)
    private Float desconto;

    public Produtos() {
    }

    public Produtos(Integer id) {
        this.id = id;
    }

    public Produtos(Integer id, String nome, String descricao, float preco) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        String oldDescricao = this.descricao;
        this.descricao = descricao;
        changeSupport.firePropertyChange("descricao", oldDescricao, descricao);
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        float oldPreco = this.preco;
        this.preco = preco;
        changeSupport.firePropertyChange("preco", oldPreco, preco);
    }

    public Float getDesconto() {
        return desconto;
    }

    public void setDesconto(Float desconto) {
        Float oldDesconto = this.desconto;
        this.desconto = desconto;
        changeSupport.firePropertyChange("desconto", oldDesconto, desconto);
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
        if (!(object instanceof Produtos)) {
            return false;
        }
        Produtos other = (Produtos) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DataBase.Produtos[ id=" + id + " ]";
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
            ProdutosJpaController produtoController = new ProdutosJpaController(emf);
            produtoController.create(this);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public void alterar(){
        try{
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("AcademiaVisualPU");
            ProdutosJpaController produtoController = new ProdutosJpaController(emf);
            produtoController.edit(this);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public void excluir(){
        try{
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("AcademiaVisualPU");
            ProdutosJpaController produtoController = new ProdutosJpaController(emf);
            produtoController.destroy(this.getId());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
}
