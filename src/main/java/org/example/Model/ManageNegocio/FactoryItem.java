package org.example.Model.ManageNegocio;

public class FactoryItem {

    public final Item createItem(String nome,float valorItem){
        Item item = new Item(nome);
        item.setValorVenda(valorItem);
        item.setValorCompra(valorItem);
        return item;
    }
}
