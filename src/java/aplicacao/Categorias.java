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
public class Categorias {

    private Integer id;
    //private String nome;
    private String descricao;
    
    private Collection<Lancamentos> lancamentosCollection;

    public Categorias() {
    }

    public Categorias(Integer id) {
        this.id = id;
    }

    public Categorias(Integer id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    // teria que colocar um get nome e um set nome?
    
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    public Collection<Lancamentos> getLancamentosCollection() {
        return lancamentosCollection;
    }

    public void setLancamentosCollection(Collection<Lancamentos> lancamentosCollection) {
        this.lancamentosCollection = lancamentosCollection;
    }
    
    
}
