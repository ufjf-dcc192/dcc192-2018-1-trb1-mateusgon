package br.ufjf.dcc192;

public class ItemDoPedido {
    
    private Item item;
    private Integer quantidade;

    public ItemDoPedido(Item item, Integer quantidade) {
        this.item = item;
        this.quantidade = quantidade;
    }

    public ItemDoPedido() {
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }
    
    
}
