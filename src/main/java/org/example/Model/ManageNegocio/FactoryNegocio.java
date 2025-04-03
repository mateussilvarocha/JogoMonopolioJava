package org.example.Model.ManageNegocio;

import java.util.HashMap;
public class FactoryNegocio {

  private static final HashMap<String, Class<? extends NegocioTemplate>> tipos = new HashMap<>();

        // Inicializa os tipos disponíveis
        static {
            tipos.put("Mercearia", Mercearia.class);
            // Adicione mais tipos aqui conforme necessário
        }

        // Método para criar um Negócio dinamicamente com base no tipo
        public static NegocioTemplate criarNegocio(String tipo, String nome) {
            Class<? extends NegocioTemplate> negocioClass = tipos.get(tipo);

            if (negocioClass != null) {
                try {
                    return negocioClass.getConstructor(String.class).newInstance(nome);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            System.out.println("Tipo de negócio '" + tipo + "' não encontrado.");
            return null;
        }
    }
