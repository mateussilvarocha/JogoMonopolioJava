package org.example.Viwer;

import java.util.Scanner;

public class UI_Terminal {
    private static UI_Terminal instancia;
    private boolean constancia = true;

    public UI_Terminal(){

    }
    public static UI_Terminal getInstance(){
        if(instancia == null){
            instancia = new UI_Terminal();
        }
        return instancia;
    }
    public void run(){
        while(constancia){
           Scanner scanner = new Scanner(System.in);
           String continuar = scanner.nextLine();



            if(continuar.equals("s")){
                constancia = false;
            }
        }
    }
}
