package br.ufjf.dcc192;

import java.util.ArrayList;
import java.util.List;

public class Mesas {
    private Integer numero;
    private String nome;
    private List <Pedido> pedidos;

    public Mesas() {
    }

    public Mesas(String nome, Integer numero) {
        this.nome = nome;
        this.numero = numero;
        this.pedidos = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List <Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List <Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    @Override
    public String toString() {
        return this.nome; //To change body of generated methods, choose Tools | Templates.
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }
}
