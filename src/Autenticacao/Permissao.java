/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Autenticacao;

/**
 *
 * @author Luccas
 */
public class Permissao {
    /*Classe representa o sistema de permissões do aplicativo.
    *Utiliza a classe Validacao para as validações do login/senha.
    */
    
    
    
    public final static byte P_ALUNO = 1;
    public final static byte P_TREINADOR = 2;
    public final static byte P_ADMINISTRADOR = 4;
    
    private byte permissaoUsuario;
    
    public byte getPermissaoUsuario() {
        return this.permissaoUsuario;
    }
    public void setPermissaoUsuario(byte permissao) {
        this.permissaoUsuario = permissao;
    }
    
    public boolean isUsuario() {
        return permissaoUsuario == P_ALUNO;
    }
    
    public boolean isTreinador() {
        return permissaoUsuario == P_TREINADOR;
    }
    
    
}
