package org.example.Model.ManageNegocio;

import java.util.HashMap;

public abstract class NegocioTemplate {
    private String nome;
    private float saldo;
    private HashMap<String, Item> estoque = new HashMap<>();
    private static final FactoryItem factoryItem = new FactoryItem();

    public NegocioTemplate(String nome) {
        this.nome = nome; // Usa método para tipar o tipo
    }

    public void comprar(String nomeItem) {
        if (estoque.containsKey(nomeItem)) {
            Item item = estoque.get(nomeItem);
            System.out.println("Item encontrado: " + nomeItem);
            item.addItem();
        } else {
            System.out.println("Item não encontrado.");
        }
    }


    public void addItem(String nomeItem, float valorItem) {
        estoque.put(nomeItem, factoryItem.createItem(nomeItem,valorItem));  // Adiciona um novo item
    }


    public HashMap<String, Item> getEstoque() {
        return estoque;
    }

}
