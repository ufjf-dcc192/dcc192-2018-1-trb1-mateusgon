package br.ufjf.dcc192;

import java.util.ArrayList;
import java.util.List;

public class Pedido {

    private String nome;
    private Integer numero;
    private List<ItemDoPedido> itemDoPedido;
    private boolean statusAberto;
    private String aberto;
    private String fechado;
    private Double valor;

    public Pedido(String nome, Integer numero) {
        this.nome = nome;
        this.numero = numero;
    }

    public Pedido(String nome, Integer numero, boolean statusAberto, String aberto, String fechado, Double valor) {
        this.nome = nome;
        this.numero = numero;
        this.statusAberto = statusAberto;
        this.aberto = aberto;
        this.fechado = fechado;
        this.valor = valor;
    }
    
    public Pedido ()
    {
        itemDoPedido = new ArrayList<ItemDoPedido>();
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<ItemDoPedido> getItemDoPedido() {
        return itemDoPedido;
    }

    public void setItemDoPedido(List<ItemDoPedido> itemDoPedido) {
        this.itemDoPedido = itemDoPedido;
    }

    public boolean isStatusAberto() {
        return statusAberto;
    }

    public void setStatusAberto(boolean statusAberto) {
        this.statusAberto = statusAberto;
    }

    public String getAberto() {
        return aberto;
    }

    public void setAberto(String aberto) {
        this.aberto = aberto;
    }

    public String getFechado() {
        return fechado;
    }

    public void setFechado(String fechado) {
        this.fechado = fechado;
    }

    public Double getValor() {
        Double valor = 0.0;
        for (ItemDoPedido idp : itemDoPedido)
        {
            valor = valor + idp.getItem().getValor() * idp.getQuantidade();
        }
        this.valor = valor;
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        String resultado = String.format("%.2f", this.valor);
        if (isStatusAberto())
            return this.nome + " - R$" + resultado + " - Aberto: " + this.aberto + " - Status: Aberto";
        else
            return this.nome + " - R$" + resultado + " - Fechado: " + this.fechado + " - Status: Fechado";
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    
}
