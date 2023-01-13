package main;

import view.TelaPrincipal;

/**
 * A classe Main permite a execução da aplicação tendo, como único método,
 * o método main.
 * 
 * @author Alisson Jaques
 */
public class Main {
    /**
     * O método main permite a execução da aplicação, ele cria uma instância da 
     * classe TelaPrincipal e faz uso da mesma, possibilitando ao usuário a 
     * interação com o sistema.
     * 
     * @param args os argumentos que podem ser passados ao método, via linha de comando,
     * mas que neste caso serão ignorados
     */
    public static void main(String args[]){
        TelaPrincipal tela = new TelaPrincipal();
        tela.setVisible(true);
        //tela.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }
} // fim do método Main
