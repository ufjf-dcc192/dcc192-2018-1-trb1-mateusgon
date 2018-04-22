package br.ufjf.dcc192;

public class Item {
    private String nome;
    private String tipoItem;
    private Double valor;
    

    public Item() {
    }

    public Item(String nome, String tipoItem, Double valor) {
        this.nome = nome;
        this.tipoItem = tipoItem;
        this.valor = valor;
    }

    @Override
    public String toString() {
        String resultado = String.format("%.2f", this.valor);
        return nome + " - R$" + resultado;
    }

    public String getTipoItem() {
        return tipoItem;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public void setTipoItem(String tipoItem) {
        this.tipoItem = tipoItem;
    }    
}
