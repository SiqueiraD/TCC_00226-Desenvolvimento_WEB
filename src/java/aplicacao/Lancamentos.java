/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacao;

import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author danil
 */
public class Lancamentos {

    private Integer id;
    
    private BigDecimal valor;
    
    private String operacao;
    
    private Date data;
    
    private String descricao;
   
    private Categorias idCategoria;
    
    private Contas idConta;

    public Lancamentos() {
    }

    public Lancamentos(Integer id) {
        this.id = id;
    }

    public Lancamentos(Integer id, BigDecimal valor, String operacao, Date data) {
        this.id = id;
        this.valor = valor;
        this.operacao = operacao;
        this.data = data;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public String getOperacao() {
        return operacao;
    }

    public void setOperacao(String operacao) {
        this.operacao = operacao;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Categorias getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Categorias idCategoria) {
        this.idCategoria = idCategoria;
    }

    public Contas getIdConta() {
        return idConta;
    }

    public void setIdConta(Contas idConta) {
        this.idConta = idConta;
    }

    
}
