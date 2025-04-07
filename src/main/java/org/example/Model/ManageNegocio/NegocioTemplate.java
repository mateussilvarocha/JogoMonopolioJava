package org.example.Model.ManageNegocio;

import java.util.HashMap;

public abstract class NegocioTemplate {
    private String nome;
    private float saldo;
    private HashMap<String, Item> estoque = new HashMap<>();
    private static final FactoryItem factoryItem = new FactoryItem();

    public NegocioTemplate(String nome) {
        iniciarEstoque();
        this.nome = nome; // Usa método para tipar o tipo
    }

    public void comprar(String nomeItem) {
        if (estoque.containsKey(nomeItem)) {
            Item item = estoque.get(nomeItem);

            if (getSaldo() > 0) {
                item.putItem(); // Remove 1 do estoque
                saldo += item.getValorCompra(); // Adiciona o valor ao saldo
                System.out.println("Compra realizada: " + nomeItem + " comprador por R$ " + item.getValorCompra());
            } else {
                System.out.println("Saldo insuficiente para comprar o item: " + nomeItem);
            }

        } else {
            System.out.println("Item não encontrado no estoque: " + nomeItem);
        }
    }
    public void vender(String nomeItem) {

        if (estoque.containsKey(nomeItem)) {
            Item item = estoque.get(nomeItem);

            if (item.getQuantidade() > 0) {
                item.putItem(); // Remove 1 do estoque
                saldo += item.getValorVenda(); // Adiciona o valor ao saldo
                System.out.println("Venda realizada: " + nomeItem + " vendido por R$ " + item.getValorVenda());
            } else {
                System.out.println("Estoque insuficiente para o item: " + nomeItem);
            }

        } else {
            System.out.println("Item não encontrado no estoque: " + nomeItem);
        }

    }


    public void addItem(String nomeItem, float valorItem) {
        estoque.put(nomeItem, factoryItem.createItem(nomeItem,valorItem));  // Adiciona um novo item
    }
    public void iniciarEstoque(){}

    public String getNome(){return nome;}

    public float getSaldo(){return saldo;}

    public HashMap<String, Item> getEstoque() {
        return estoque;
    }

}
