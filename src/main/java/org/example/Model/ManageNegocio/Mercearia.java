package org.example.Model.ManageNegocio;

import org.example.Controller.JogoController;
import org.example.Model.Personagem;

import java.util.HashMap;
import java.util.Map;

public class Mercearia extends NegocioTemplate {


    public Mercearia(String nome) {
        super(nome);
    }
    public void iniciarEstoque(){
        addItem("Arroz", 10.0f);
        addItem("Pão", 5.0f);
        addItem("Bolo", 15.0f);
    }

}
