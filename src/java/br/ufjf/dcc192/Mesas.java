package br.ufjf.dcc192;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
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
        Calendar c = Calendar.getInstance();
        Date data = c.getTime();
        SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");     
        String str = fmt.format(data);            
        Pedido p = new Pedido("Pedido 0", 0, true, str);
        pedidos.add(p);
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
