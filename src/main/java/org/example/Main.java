package org.example;

import org.example.Controller.JogoController;
import org.example.Controller.Player;
import org.example.Model.GameEventManager;

import java.util.HashMap;
import java.util.Map;


public class Main {

    public static void telaMenu(){
        GameEventManager.getInstancia().triggerEvent("NOVO_PERSONAGEM", "Joao");

    }
    public static void iniciarJogo(){

        // Criando e manipulando o jogo
        // Adicionando itens aos negócios
        //iste metodo não é preciso mais a penas se o dev quiser adicionar mais itens de forma rapida

        //java não tem  preenchido inline
        //blocos anônimos ou métodos utilitários
//        Map<String, Object> dadosItem = new HashMap<>(){{
//            put("negocio", "Mercearia");
//            put("item", "Arroz");
//            put("preco", 10.0f);
//        }};
//
//        GameEventManager.getInstancia().triggerEvent("CRIAR_ITEM", dadosItem);
        //Blocos unitarios
//        public static Map<String, Object> criarDadosItem(String negocio, String item, float preco) {
//            Map<String, Object> map = new HashMap<>();
//            map.put("negocio", negocio);
//            map.put("item", item);
//            map.put("preco", preco);
//            return map;
//        }
//        GameEventManager.getInstancia().triggerEvent(
//                "CRIAR_ITEM",
//                criarDadosItem("Mercearia", "Arroz", 10.0f)
//        );

        GameEventManager.getInstancia().triggerEvent(
                "CRIAR_ITEM",
                Map.of(
                        "negocio", "Mercearia",
                        "item", "Arroz",
                        "preco", 10.0f
                )
        );
        GameEventManager.getInstancia().triggerEvent(
                "CRIAR_ITEM",
                Map.of(
                        "negocio", "Mercearia",
                        "item", "Bolo",
                        "preco", 15.0f
                )
        );
        GameEventManager.getInstancia().triggerEvent(
                "CRIAR_ITEM",
                Map.of(
                        "negocio", "Mercearia",
                        "item", "Pão",
                        "preco", 5.0f
                )
        );
        // Removendo um ite
        JogoController.getInstancia().removerItem("Padaria", "Bolo");

    }
    public static void simulandoManipulacaoUsuario(){
        //Usuario abre o MenuIniciar e cria o personagem
        telaMenu();

        //Controlando o personagem

        // Criando negócios para o personagem
        JogoController.getInstancia().fundarNegocio("Mercearia", "Comercio");
        JogoController.getInstancia().fundarNegocio( "Padaria", "Comercio");
        JogoController.getInstancia().listarItens("Mercearia");
        // Comprando um item
        GameEventManager.getInstancia().triggerEvent(
                "COMPRAR_ITEM",
                Map.of(
                        "negocio", "Mercearia",
                        "item", "Arroz"
                )
        );
        GameEventManager.getInstancia().triggerEvent(
                "COMPRAR_ITEM",
                Map.of(
                        "negocio", "Mercearia",
                        "item", "Arroz"
                )
        );
        GameEventManager.getInstancia().triggerEvent(
                "COMPRAR_ITEM",
                Map.of(
                        "negocio", "Mercearia",
                        "item", "Arroz"
                )
        );
        GameEventManager.getInstancia().triggerEvent(
                "COMPRAR_ITEM",
                Map.of(
                        "negocio", "Mercearia",
                        "item", "Arroz"
                )
        );
        GameEventManager.getInstancia().triggerEvent(
                "COMPRAR_ITEM",
                Map.of(
                        "negocio", "Mercearia",
                        "item", "Arroz"
                )
        );

        GameEventManager.getInstancia().addListener("RETORNO_SALDO_PERSONAGEM", data -> {
            System.out.println(data);
        });
        GameEventManager.getInstancia().triggerEvent("GET_SALDO_PERSONAGEM", null);

        GameEventManager.getInstancia().addListener("RETORNO_SALDO_NEGOCIO", data->{
            //RETORNA O OBJETO NEGOCIO:
                System.out.println(data);
        });
        GameEventManager.getInstancia().triggerEvent("GET_SALDO_NEGOCIO", "Mercearia");

        GameEventManager.getInstancia().addListener("RETORNO_ESTOQUE_NEGOCIO", data->{
            //RETORNA O OBJETO NEGOCIO:
            System.out.println("ESTE É O ESTOQUE");
            System.out.println(data);
        });
        GameEventManager.getInstancia().triggerEvent("GET_ESTOQUE_NEGOCIO", "Mercearia");

    }
    public static void main(String[] args) {
        JogoController.getInstancia(); // Garantir carregamento
        Player.getInstancia();         // Agora seguro usar

        simulandoManipulacaoUsuario();

    }
}

//valores de Objetos:
//JogoModel-personagensDoPlayer

//Player| >Negocio|> Item|
//      |         |      |-nome, quandidade, valorVenda, valorCompra
//      |         |- nome, saldo, estoqueItem
//      |-nome, saldo, compainhaNegocios