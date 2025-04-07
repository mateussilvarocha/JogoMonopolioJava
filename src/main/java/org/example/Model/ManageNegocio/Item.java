package org.example.Model.ManageNegocio;

public class  Item {
    private String nome;
    private int quantidade = 0;
    private float valorVenda;
    private float valorCompra;

    public Item(String Nome){
        nome= Nome;
    }

    public void addItem(){
        quantidade++;
    }
    public void putItem(){
        quantidade--;
    }

    public final void setValorVenda(float valor){valorVenda = valor;}
    public final void setValorCompra(float valor){valorCompra = valor;}

    public void modValorCompra(float valor){
        float ajuste = valorCompra * (valor / 100);
        valorCompra += ajuste;

    }
    public void modValorVenda(float valor){
        float ajuste = valorVenda * (valor / 100);
        valorVenda += ajuste;
    }

    public float getValorVenda() {
        return valorVenda;
    }

    public float getValorCompra() {
        return valorCompra;
    }

    public int getQuantidade() {
        return quantidade;
    }
}
