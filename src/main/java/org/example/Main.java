package org.example;

import org.example.Controller.JogoController;
import org.example.Controller.Player;


public class Main {
    static JogoController jogoController = new JogoController();
    static Player player = jogoController.getPlayer();

    public static void telaMenu(){
        player.newGame("Joao");
    }
    public static void iniciarJogo(){

        // Criando e manipulando o jogo
        // Adicionando itens aos negócios
        jogoController.criarItemEmNegocio("Joao", "Mercearia", "Arroz", 10.0f);
        jogoController.criarItemEmNegocio("Joao", "Mercearia", "Pão", 5.0f);
        jogoController.criarItemEmNegocio("Joao", "Mercearia", "Bolo", 15.0f);

        // Removendo um item
        jogoController.removerItem("Joao", "Padaria", "Bolo");

    }
    public static void simulandoManipulacaoUsuario(){
        //usuario abriu o jogo
        iniciarJogo();
        //Usuario abre o MenuIniciar e cria o personagem
        telaMenu();

        //Controlando o personagem

        // Criando negócios para o personagem
        jogoController.fundarNegocio("Joao", "Mercearia", "Comercio");
        jogoController.fundarNegocio("Joao", "Padaria", "Comercio");

        // Comprando um item
        jogoController.comprarItem("Joao", "Mercearia", "Arroz");
        jogoController.comprarItem("Joao", "Mercearia", "Arroz");
        jogoController.comprarItem("Joao", "Mercearia", "Arroz");
        jogoController.comprarItem("Joao", "Mercearia", "Arroz");

        jogoController.listarItens("Joao", "Mercearia");

        // Listando os itens de um negócio
        jogoController.listarItens("Joao", "Padaria");

        // Listando os itens após remoção
        jogoController.listarItens("Joao", "Padaria");
    }
    public static void main(String[] args) {
        simulandoManipulacaoUsuario();

    }
}

//valores de Objetos:
//JogoModel-personagensDoPlayer

//Player| >Negocio|> Item|
//      |         |      |-nome, quandidade, valorVenda, valorCompra
//      |         |- nome, saldo, estoqueItem
//      |-nome, saldo, compainhaNegocios