/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacao;

import java.util.Collection;

/**
 *
 * @author danil
 */
public class Usuarios {

    private Integer id;
    
    private String nome;
    
    private String cpf;
    
    private String senha;
    
    private String suspenso;
    
    private Collection<Contas> contasCollection;

    public Usuarios() {
        this.id = 0;
    }

    public Usuarios(Integer id) {
        this.id = id;
    }

    public Usuarios(Integer id, String nome, String cpf, String senha, String suspenso) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.senha = senha;
        this.suspenso = suspenso;
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

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getSuspenso() {
        return suspenso;
    }

    public void setSuspenso(String suspenso) {
        this.suspenso = suspenso;
    }
    
    public Collection<Contas> getContasCollection() {
        return contasCollection;
    }

    public void setContasCollection(Collection<Contas> contasCollection) {
        this.contasCollection = contasCollection;
    }

    
}
