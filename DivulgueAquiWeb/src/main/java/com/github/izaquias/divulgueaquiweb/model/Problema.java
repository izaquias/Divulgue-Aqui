
package com.github.izaquias.divulgueaquiweb.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author Izaquias
 */
@Entity
public class Problema implements Serializable {
    @Id
    @GeneratedValue
    private long id;
    @Column(length = 50, nullable = false)
    private String categoria;
    @Column(length = 50, nullable = false)
    private String localidade;
    @Column(length = 8)//Se adicionar "hora" ocorrer um erro excesso não suportado de caracteres! 
    private LocalDate data;
    @Column(length = 100, nullable = false)
    private String descricao;
    @OneToMany
    private Collection<Usuario> usuarios = new ArrayList<>();;//Fazer o devido relacionamento ORM!
    //private List<Usuario> usuarios;
    
    public Problema() {
    }

    public Problema(String categoria, String localidade,LocalDate data, String descricao, Collection<Usuario> usuarios) {
        
        this.categoria = categoria;
        this.localidade = localidade;
        this.descricao = descricao;
        this.usuarios = usuarios;//Ver se não dará complicações futuras!
        //this.usuarios = usuarios;
        //this.data = LocalDate.now();//Verificar se, quando é passado o parâmetro "data" no construtor, faça ocorrer um erro! 
        
    }

    public long getId() {
        return id;
    }

    
    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getLocalidade() {
        return localidade;
    }

    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Collection<Usuario> getUsuario() {
        return usuarios;
    }

    public void setUsuario(Collection<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
    
}
