package org.example.Controller;

import org.example.Model.JogoModel;
import org.example.Model.ManageNegocio.NegocioTemplate;
import org.example.Model.Personagem;


public class JogoController extends JogoModel {
// descreve a logica de comportamento do usario e do sistema alem de conectar a outras class
// continuar implementando os conceitos de POE (Programação Orientada a Eventos) dentro do chat "correção de codigo java no chat gpt"
    private Player player;

    public JogoController(){
        player = new Player(this).getInstancia();
    }


    // Cria um novo negócio para o personagem
    public void fundarNegocio(String nomePersonagem, String nomeNegocio, String tipoNegocio) {
        Personagem personagem = getPersonagem(nomePersonagem);
        if (personagem != null) {
            personagem.criarNegocio(nomeNegocio, tipoNegocio);
            System.out.println("Negócio " + nomeNegocio + " criado para " + nomePersonagem + ".");
        } else {
            System.out.println("Personagem " + nomePersonagem + " não encontrado.");
        }
    }


    public Player getPlayer(){
        return player;
    }
    // Compra um item de um negócio
    public void comprarItem(String nomePersonagem, String nomeNegocio, String nomeItem) {
        Personagem personagem = getPersonagem(nomePersonagem);
        if (personagem != null) {
            NegocioTemplate negocio =  personagem.getNegocios().get(nomeNegocio);
            if (negocio != null) {
                negocio.comprar(nomeItem);
            } else {
                System.out.println("Negócio " + nomeNegocio + " não encontrado.");
            }
        } else {
            System.out.println("Personagem " + nomePersonagem + " não encontrado.");
        }
    }




}
