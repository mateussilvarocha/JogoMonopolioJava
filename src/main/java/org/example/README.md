
# Sistema de Simulação de Negócios

Este projeto é uma aplicação em Java que simula um sistema de gerenciamento de personagens e negócios. O sistema permite a criação de personagens, fundação de negócios, adição e remoção de itens em estoque, e a simulação de interações do usuário como compras e listagem de saldos.

## Estrutura do Projeto

```
org.example
│
├── Controller
│   ├── JogoController.java  # Controlador principal da aplicação
│   └── Player.java          # Controlador de ações do jogador
│
├── Model
│   ├── JogoModel.java       # Contém a lógica central do jogo
│   ├── GameEventManager.java# Gerenciador de eventos baseado em POE
│   └── ManageNegocio
│       ├── NegocioTemplate.java # Template base para negócios
│       └── Item.java            # Representação de um item no estoque
│
└── Main.java               # Classe principal para execução e simulação
```

## Funcionalidades

- **Criação de Personagens**: Inicialização de novos jogadores com um nome único.
- **Fundação de Negócios**: Associar negócios ao personagem, como mercearias e padarias.
- **Gerenciamento de Itens**: Adicionar e remover itens dos negócios, simulando estoques.
- **Sistema de Compras**: Simulação de compras pelos personagens, com impacto no saldo.
- **Listagem de Itens e Saldos**: Verificar estoque e finanças de personagens e negócios.
- **Arquitetura baseada em eventos (POE)**: Interações e comportamentos são tratados por meio de eventos.

## Exemplo de Simulação

```java
public static void simulandoManipulacaoUsuario(){
    // Criação de personagem e negócios
    telaMenu();
    JogoController.getInstancia().fundarNegocio("Joao", "Mercearia", "Comercio");

    // Adição de itens
    JogoController.getInstancia().criarItemEmNegocio("Joao", "Mercearia", "Arroz", 10.0f);

    // Compras
    Player.getInstancia().comprarItem("Joao", "Mercearia", "Arroz");

    // Consulta de saldos
    Player.getInstancia().getSaldoPersonagem("Joao");
    Player.getInstancia().getSaldoNegocio("Joao", "Mercearia");
}
```

## Requisitos

- Java 8 ou superior
- IDE ou terminal para compilação e execução

## Execução

Para executar a simulação:

```bash
javac -d bin src/org/example/Main.java
java -cp bin org.example.Main
```

## Licença

Este projeto é de uso educacional e livre para modificações.
