package org.example.Controller;

public class Player {
    private Player instancia;
    private JogoController jogoController;

    public Player(JogoController jogocontroller){
        jogoController = jogocontroller;
    }

    public Player getInstancia() {
        if(instancia == null){
            instancia = new Player(jogoController);
        }
        return instancia;
    }
//informa os padroes de comportamento do usuario

    public void newGame( String nomePersonagem){
        jogoController.criarPersonagem(nomePersonagem);
    }

    //persistencia de dados
//    getSavePlayer(){
//
//    }
}
