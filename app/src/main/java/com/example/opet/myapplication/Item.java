package com.example.opet.myapplication;


import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class Item {

    @PrimaryKey(autoGenerate = true)
    private long id;
    @ColumnInfo(name = "nome_item")
    private String nome;
    @ColumnInfo(name="qtde_item")
    private int qtde;
    @ColumnInfo(name="categoria")
    private String categoria;


    public Item (){

    }

    public Item(String nome, int qtde, String categoria) {
        this.nome = nome;
        this.qtde = qtde;
        this.categoria = categoria;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQtde() {
        return qtde;
    }

    public void setQtde(int qtde) {
        this.qtde = qtde;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
}
