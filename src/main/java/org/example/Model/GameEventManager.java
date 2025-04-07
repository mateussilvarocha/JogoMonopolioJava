package org.example.Model;
//O conceito de Game Event (Evento de Jogo) é amplamente utilizado no desenvolvimento de jogos para lidar com interações
// e mudanças de estado de maneira eficiente e desacoplada. Esse conceito se baseia no Padrão Observer
// e no Event-Driven Programming (Programação Orientada a Eventos).

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Consumer;

public class GameEventManager {
    private static GameEventManager instancia;
    private HashMap<String, Set<Consumer<Object>>> listeners = new HashMap<>();

    private GameEventManager(){}
    public static GameEventManager getInstancia(){
        if(instancia==null){
            instancia = new GameEventManager();
        }
        return instancia;
    }
    // Adiciona um listener para um evento específico
    public void addListener(String event, Consumer<Object> listener){
        listeners.computeIfAbsent(event, k -> new HashSet<>()).add(listener);
    }
    // Dispara um evento e notifica os ouvintes
    public void triggerEvent(String event, Object data){
        if(listeners.containsKey(event)){
            for(Consumer<Object> listener : listeners.get(event)){
                listener.accept(data);
            }
        }
    }
}
