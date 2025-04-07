package org.example.Controller;

import org.example.Model.GameEventManager;
import org.example.Model.ManageNegocio.Item;
import org.example.Model.ManageNegocio.NegocioTemplate;
import org.example.Model.Personagem;

import java.util.HashMap;
import java.util.Map;

public class Player {
    private static Player instancia;
    private Personagem personagemAtual;
    private boolean playerIniciado = false;

    private Player(){
        GameEventManager.getInstancia().addListener("NOVO_PERSONAGEM", data -> {
            newGame((String) data);
            System.out.println("Criando um personagem dentro do player");
        });
        GameEventManager.getInstancia().addListener("COMPRAR_ITEM", data -> {
            if(playerIniciado){
                if (data instanceof Map<?, ?> dados) {
                    String nomeNegocio = (String) dados.get("negocio");
                    String nomeItem = (String) dados.get("item");
                    comprarItem(nomeNegocio, nomeItem);
                    System.out.println("Comprando item");
                }
            else {
                System.out.println("Player ainda não iniciado.");
            }


        }});
        GameEventManager.getInstancia().addListener("GET_SALDO_PERSONAGEM", data ->{
            if (playerIniciado) {
                float saldo = getSaldoPersonagem();
                GameEventManager.getInstancia().triggerEvent("RETORNO_SALDO_PERSONAGEM", saldo);
            } else {
                System.out.println("Player ainda não iniciado.");
            }
        });

        GameEventManager.getInstancia().addListener("GET_SALDO_NEGOCIO", data -> {
            if(playerIniciado) {
                GameEventManager.getInstancia().triggerEvent("RETORNO_SALDO_NEGOCIO", getSaldoNegocio((String) data));
            }else {
                System.out.println("Player ainda não iniciado.");
            }
        });
        GameEventManager.getInstancia().addListener("GET_ESTOQUE_NEGOCIO", data -> {
            if(playerIniciado) {
                GameEventManager.getInstancia().triggerEvent("RETORNO_ESTOQUE_NEGOCIO", getEstoqueNegocio((String)data));
            }else {
                System.out.println("Player ainda não iniciado.");
            }
        });


    }
    public static Player getInstancia() {

        if(instancia == null){
            instancia = new Player();
        }
        return instancia;
    }

    // Compra um item de um negócio
    public void comprarItem(String nomeNegocio, String nomeItem) {
        if(playerIniciado) {
            if (personagemAtual != null) {
                NegocioTemplate negocio = personagemAtual.getNegocios().get(nomeNegocio);
                if (negocio != null) {
                    negocio.comprar(nomeItem);
                } else {
                    System.out.println("Negócio " + nomeNegocio + " não encontrado.");
                }
            } else {
                System.out.println("Personagem  não instanciado.");
            }
        }else {
            System.out.println("Inicie o seu personagem primeiro");
        }
    }
    //Setar primeiro durante o menu

    public void setPersonagem (Personagem personagem){
        personagemAtual = personagem;
        System.out.println();

    }
    public boolean isPlayerIniciado() {
        return playerIniciado;
    }


    public float getSaldoPersonagem(){
        if(playerIniciado ) {

            System.out.println(personagemAtual.getSaldo());
            return personagemAtual.getSaldo();
        }
        return 0;
    }

    public float getSaldoNegocio(String nomeNegocio){
        if(playerIniciado) {
            System.out.println(personagemAtual.getNegocios().get(nomeNegocio).getSaldo());
            return personagemAtual.getNegocios().get(nomeNegocio).getSaldo();
        }
        return 0;
    }
    public HashMap<String, Item> getEstoqueNegocio(String nomeNegocio){
        if(playerIniciado){
            NegocioTemplate negocio = personagemAtual.getNegocios().get(nomeNegocio);
            if (negocio != null) {
                System.out.println("Itens no negócio " + nomeNegocio + ":");
                for (String itemNome : negocio.getEstoque().keySet()) {
                    Item item = negocio.getEstoque().get(itemNome); // Obtendo o item pelo nome
                    System.out.println("- " + itemNome + " | Quantidade: " + item.getQuantidade() + " | Valor de Compra: " + item.getValorCompra() + " | Valor de Venda: " + item.getValorVenda());
                }
                return negocio.getEstoque();
            } else {
                System.out.println("Negócio " + nomeNegocio + " não encontrado.");
            }
        }
        return null;
    }

//informa os padroes de comportamento do usuario

    public void newGame( String nomePersonagem){

        Personagem personagem = JogoController.getInstancia().criarPersonagem(nomePersonagem);
        if(personagem != null) {
            isPlayerIniciado();

            setPersonagem(personagem);
            GameEventManager.getInstancia().triggerEvent("INICIAR_GAME", personagemAtual);
        }
    }

    //persistencia de dados
//    getSavePlayer(){
//
//    }
}
