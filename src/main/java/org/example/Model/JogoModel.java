package org.example.Model;

import org.example.Model.ManageNegocio.Item;
import org.example.Model.ManageNegocio.NegocioTemplate;

import java.util.HashMap;

public class JogoModel {

    protected Personagem personagemAtual;

    private HashMap<String, Personagem> personagens = new HashMap<>();
    // Recupera um personagem pelo nome
    public Personagem getPersonagem(String nome) {
        return personagens.get(nome);
    }

    public void iniciarJogador(Personagem personagem){
        personagemAtual = personagem;
    }
    // Cria um novo personagem
    public Personagem criarPersonagem(String nome) {
        if (!personagens.containsKey(nome)) {
            Personagem personagem = new Personagem(nome);
            personagens.put(nome, personagem);
            System.out.println("Personagem " + nome + " criado.");
            return personagem;
        } else {
            System.out.println("Personagem " + nome + " já existe.");
            return null;
        }

    }

    // Adiciona um item ao estoque de um negócio
    // esta classe será determinada pela propria classe Negocio
    // seguirei adicionando o estoque em uma persistencia para quando houver mudança pelo desenvolvedor
    //vou ter que primeiro persistir as classe e lincalas ao mediador
    //direcionarei este metodo direto ao estoque do tipo de negocio correspondente globalmente

    public void criarItemEmNegocio(String nomeNegocio, String nomeItem, float valorCompra) {

        if (personagemAtual != null) {
            NegocioTemplate negocio = personagemAtual.getNegocios().get(nomeNegocio);
            if (negocio != null) {
                negocio.addItem(nomeItem, valorCompra);
                System.out.println("Item " + nomeItem + " adicionado ao negócio " + nomeNegocio + ".");
            } else {
                System.out.println("Negócio " + nomeNegocio + " não encontrado.");
            }
        } else {
            System.out.println("Personagem  não instanciado.");
        }
    }
    // Remover um item do estoque de um negócio
    public void removerItem(String nomeNegocio, String nomeItem) {
        if (personagemAtual != null) {
            NegocioTemplate negocio = personagemAtual.getNegocios().get(nomeNegocio);
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
            System.out.println("Personagem  não instanciado.");
        }
    }
    // Listar os itens de um negócio
    public void listarItens(String nomeNegocio) {
        if (personagemAtual != null) {
            NegocioTemplate negocio = personagemAtual.getNegocios().get(nomeNegocio);
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
            System.out.println("Personagem  não instanciado.");
        }
    }

    //persistencia de dados
//    getSaveNegociosAndCompétidores(){
//
//    }
}
