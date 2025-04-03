package org.example.Model;

import org.example.Model.ManageNegocio.Item;
import org.example.Model.ManageNegocio.NegocioTemplate;

import java.util.HashMap;

public class JogoModel {

    private HashMap<String, Personagem> personagens = new HashMap<>();
    // Recupera um personagem pelo nome
    public Personagem getPersonagem(String nome) {
        return personagens.get(nome);
    }

    // Cria um novo personagem
    public void criarPersonagem(String nome) {
        if (!personagens.containsKey(nome)) {
            Personagem personagem = new Personagem(nome);
            personagens.put(nome, personagem);
            System.out.println("Personagem " + nome + " criado.");
        } else {
            System.out.println("Personagem " + nome + " já existe.");
        }
    }

    // Adiciona um item ao estoque de um negócio
    public void criarItemEmNegocio(String nomePersonagem, String nomeNegocio, String nomeItem, float valorCompra) {
        Personagem personagem = getPersonagem(nomePersonagem);
        if (personagem != null) {
            NegocioTemplate negocio = personagem.getNegocios().get(nomeNegocio);
            if (negocio != null) {
                negocio.addItem(nomeItem, valorCompra);
                System.out.println("Item " + nomeItem + " adicionado ao negócio " + nomeNegocio + ".");
            } else {
                System.out.println("Negócio " + nomeNegocio + " não encontrado.");
            }
        } else {
            System.out.println("Personagem " + nomePersonagem + " não encontrado.");
        }
    }
    // Remover um item do estoque de um negócio
    public void removerItem(String nomePersonagem, String nomeNegocio, String nomeItem) {
        Personagem personagem = getPersonagem(nomePersonagem);
        if (personagem != null) {
            NegocioTemplate negocio = personagem.getNegocios().get(nomeNegocio);
            if (negocio != null) {
                if (negocio.getEstoque().containsKey(nomeItem)) {
                    negocio.getEstoque().remove(nomeItem);
                    System.out.println("Item " + nomeItem + " removido do negócio " + nomeNegocio + ".");
                } else {
                    System.out.println("Item " + nomeItem + " não encontrado no estoque.");
                }
            } else {
                System.out.println("Negócio " + nomeNegocio + " não encontrado.");
            }
        } else {
            System.out.println("Personagem " + nomePersonagem + " não encontrado.");
        }
    }
    // Listar os itens de um negócio
    public void listarItens(String nomePersonagem, String nomeNegocio) {
        Personagem personagem = getPersonagem(nomePersonagem);
        if (personagem != null) {
            NegocioTemplate negocio = personagem.getNegocios().get(nomeNegocio);
            if (negocio != null) {
                System.out.println("Itens no negócio " + nomeNegocio + ":");
                for (String itemNome : negocio.getEstoque().keySet()) {
                    Item item = negocio.getEstoque().get(itemNome); // Obtendo o item pelo nome
                    System.out.println("- " + itemNome + " | Quantidade: " + item.getQuantidade() + " | Valor de Compra: " + item.getValorCompra() + " | Valor de Venda: " + item.getValorVenda());
                }


            } else {
                System.out.println("Negócio " + nomeNegocio + " não encontrado.");
            }
        } else {
            System.out.println("Personagem " + nomePersonagem + " não encontrado.");
        }
    }

    //persistencia de dados
//    getSaveNegociosAndCompétidores(){
//
//    }
}
