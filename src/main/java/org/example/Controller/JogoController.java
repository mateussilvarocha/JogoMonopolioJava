package org.example.Controller;

import org.example.Model.GameEventManager;
import org.example.Model.JogoModel;
import org.example.Model.Personagem;

import java.util.Map;


public class JogoController extends JogoModel {
// descreve a logica de comportamento do usario e do sistema alem de conectar a outras class
// continuar implementando os conceitos de POE (Programação Orientada a Eventos) dentro do chat "correção de codigo java no chat gpt"

    private static JogoController instancia;

    private JogoController(){
        GameEventManager.getInstancia().addListener("INICIAR_GAME", data -> {
            iniciarJogador((Personagem) data);
            System.out.println("Iniciando o jogo");
        });

        GameEventManager.getInstancia().addListener("CRIAR_ITEM", data -> {
            if (data instanceof Map<?, ?> dados) {
                String nomeNegocio = (String) dados.get("negocio");
                String nomeItem = (String) dados.get("item");
                Float preco = ((Number) dados.get("preco")).floatValue();
                criarItemEmNegocio(nomeNegocio, nomeItem, preco);
            }
        });
    }
    public static JogoController getInstancia() {
        if (instancia == null) {
            instancia = new JogoController();
        }
        return instancia;
    }


    // Cria um novo negócio para o personagem
    public void fundarNegocio(String nomeNegocio, String tipoNegocio) {
        if (personagemAtual != null) {
            personagemAtual.criarNegocio(nomeNegocio, tipoNegocio);
            System.out.println("Negócio " + nomeNegocio + " criado para " + personagemAtual.getNome() + ".");
        } else {
            System.out.println("Personagem  não instanciado.");
        }
    }



}
