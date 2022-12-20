package com.siscon.prodinfo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity                // INFORMA AO SPRING QUE ESTA CLASSE È UMA ENTIDADE
public class Produto {
    
    // DECLARAÇÃO DE VARIÁVEIS
    @Id                      //informa ao SPRING que essa variável será o identificador
    private Long codigo;

    //informa ao SPRING que essa variável é uma coluna com nome, não pode ser null e não se repete
    @Column(name = "nomeProd", nullable=false, unique=true)  
    private String nomeProd;

    //informa ao SPRING que essa variável é uma coluna com nome, não pode ser null
    @Column(name = "descricaoProd", nullable=false)
    private String descricaoProd;

    //informa ao SPRING que essa variável é uma coluna com nome, não pode ser null
    @Column(name = "marcaProd", nullable=false)
    private String marcaProd;

    //informa ao SPRING que essa variável é uma coluna com nome, não pode ser null
    @Column(name = "valorProd", nullable=false)
    private Double valorProd;


    // CONSTRUTORES
    public Produto(){
    }
    
    public Produto(Long codigo, String nomeProd, String descricaoProd, String marcaProd, Double valorProd){
        this.codigo = codigo;
        this.nomeProd = nomeProd;
        this.descricaoProd = descricaoProd;
        this.marcaProd = marcaProd;
        this.valorProd = valorProd;
    }

    //Getters e Setters
    public Long getCodigo() {
        return codigo;
    }
    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }
    public String getNomeProd() {
        return nomeProd;
    }
    public void setNomeProd(String nomeProd) {
        this.nomeProd = nomeProd;
    }
    public String getDescricaoProd() {
        return descricaoProd;
    }
    public void setDescricaoProd(String descricaoProd) {
        this.descricaoProd = descricaoProd;
    }
    public String getMarcaProd() {
        return marcaProd;
    }
    public void setMarcaProd(String marcaProd) {
        this.marcaProd = marcaProd;
    }
    public Double getValorProd() {
        return valorProd;
    }
    public void setValorProd(Double valorProd) {
        this.valorProd = valorProd;
    }
}