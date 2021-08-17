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
public class Contas {

    private Integer id;
    
    private String nomeConta;
    
    private String banco;
    
    private String agencia;
    
    private String contaCorrente;
    
    private Collection<Lancamentos> lancamentosCollection;
    
    private Usuarios idUsuario;

    public Contas() {
    }

    public Contas(Integer id) {
        this.id = id;
    }

    public Contas(Integer id, String nomeConta, String banco, String agencia, String contaCorrente) {
        this.id = id;
        this.nomeConta = nomeConta;
        this.banco = banco;
        this.agencia = agencia;
        this.contaCorrente = contaCorrente;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNomeConta() {
        return nomeConta;
    }

    public void setNomeConta(String nomeConta) {
        this.nomeConta = nomeConta;
    }

    public String getBanco() {
        return banco;
    }

    public void setBanco(String banco) {
        this.banco = banco;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public String getContaCorrente() {
        return contaCorrente;
    }

    public void setContaCorrente(String contaCorrente) {
        this.contaCorrente = contaCorrente;
    }
    
    public Collection<Lancamentos> getLancamentosCollection() {
        return lancamentosCollection;
    }

    public void setLancamentosCollection(Collection<Lancamentos> lancamentosCollection) {
        this.lancamentosCollection = lancamentosCollection;
    }

    public Usuarios getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuarios idUsuario) {
        this.idUsuario = idUsuario;
    }

    
}
