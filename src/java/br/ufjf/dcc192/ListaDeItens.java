package br.ufjf.dcc192;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ListaDeItens {
    private static ArrayList<Item> itens;
    
    public static List<Item> getInstance()
    {
        if (itens==null)
        {
            itens = new ArrayList<>();
            Item item[] = new Item[20];
            item[0] = new Item(0, "Pepperoni (Pepperoni e Manjericão)", "Pizza Salgada", 42.90);
            item[1] = new Item(1, "Champignon (Champignon e Azeitona Preta)", "Pizza Salgada", 40.90);
            item[2] = new Item(2, "Pizza Ao Alho (Alho torrado e azeite)", "Pizza Salgada", 40.90);
            item[3] = new Item(3, "Portuguesa (Presunto, ovo, cebola e azeitona preta)", "Pizza Salgada", 41.90);
            item[4] = new Item(4, "Frango c/ Requeijão (Peito de frango, azeitona preta e requeijão)", "Pizza Salgada", 42.90);
            item[5] = new Item(5, "4 queijos (Provolone, requeijão, parmesão e mussarela)", "Pizza Salgada", 43.90);
            item[6] = new Item(6, "Napolitana (Parmesão e muito mais rodelas de tomate)", "Pizza Salgada", 41.90);
            item[7] = new Item(7, "Palmito (Presunto, palmito, azeitona preta e manjericão)", "Pizza Salgada", 42.90);
            item[8] = new Item(8, "Banana com Canela (Mussarela, Banana, açúcar, canela)", "Pizza Doce", 40.90);
            item[9] = new Item(9, "Brigadeiro (Mussarela, chocolate e granulado de chocolate)", "Pizza Doce", 41.90);
            item[10] = new Item(10, "Roma (Mussarela, banana, açúcar, canela e chocolate)", "Pizza Doce", 43.90);
            item[11] = new Item(11, "Bibiena (Massa de chocolate, chocolate, mini-confetes)", "Pizza Doce", 43.90);
            item[12] = new Item(12, "Sorve Napolitano", "Sobremesa", 5.00);
            item[13] = new Item(13, "Petit Gateau e Sorvete Napolitano", "Sobremesa", 13.00);
            item[14] = new Item(14, "Banana Split", "Sobremesa", 10.00);
            item[15] = new Item(15, "Milk Shake", "Sobremesa", 9.00);
            item[16] = new Item(16, "Refrigerante 600ml", "Bebida", 6.00);
            item[17] = new Item(17, "Refrigerante 1,5lts", "Bebida", 10.00);
            item[18] = new Item(18, "Suco Copo 500ml", "Bebida", 5.00);
            item[19] = new Item(19, "Cerveja Long Neck", "Bebida", 7.00);
            for (int i = 0; i < 20; i++)
            {
                itens.add(item[i]);
            }
        }
        return itens;
    }
    
    public ArrayList<Item> getItem() {
        return itens;
    }
    
    public String getTipo (int i)
    {
        Item f = itens.get(i);        
        return f.getTipoItem();
    }
    
    public String nomeValor (int i)
    {
        Item f = itens.get(i);
        String resultado = String.format("%.2f", f.getValor());
        return f.getNome() + " - R$" + resultado;
    }
    
    public Item getItemPosicao(int i)
    {
        Item f = itens.get(i);
        return f;
    }
    
    public void setItem(ArrayList<Item> item) {
        this.itens = item;
    }
}
