package org.example.Model;

import org.example.Model.ManageNegocio.FactoryNegocio;
import org.example.Model.ManageNegocio.NegocioTemplate;

import java.util.HashMap;

public class Personagem {
    private String nome;
    private float saldo;
    private HashMap<String, NegocioTemplate> negocios = new HashMap<>();
    private static final FactoryNegocio factoryNegocio = new FactoryNegocio();

    public Personagem(String nome) {
        this.nome = nome;
        this.saldo = 0;  // Inicializando o saldo
    }

    public Object criarNegocio(String nome, String tipo) {

        NegocioTemplate negocio = factoryNegocio.criarNegocio(nome, tipo);
        if(negocio  == null){
            return null;
        }
        negocios.put(nome, negocio);
        return negocio;
    }

    public HashMap<String, NegocioTemplate> getNegocios() {
        return negocios;
    }

    public int getNumeroDeNegocios() {
        return negocios.size();
    }

    public void saqueSaldo(float valor){
        saldo -= valor;
    }
    public void depositoSaldo(float valor){
        saldo += valor;
    }

    public float getSaldo(){return saldo;}
    public String getNome() {
        return nome;
    }
}
