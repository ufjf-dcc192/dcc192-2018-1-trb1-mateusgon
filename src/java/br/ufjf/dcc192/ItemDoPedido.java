package br.ufjf.dcc192;

public class ItemDoPedido {
    
    private Integer id;
    private Item item;
    private Integer quantidade;

    public ItemDoPedido(Integer id, Item item, Integer quantidade) {
        this.id = id;
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
    
}
