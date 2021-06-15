//1- Pacote
package devcalc;
// 2 - Bibliotecas
import java.util.Scanner;

// 3 - Classe
public class Calc {
    //3.1 - Atributos
    static Scanner entrada = new Scanner(System.in); // entrada = input

    //3.2 - Métodos e Funções
    public static void main(String[] args){

        // Exibe o menu da calculadora
        System.out.println(">>> CALCULADORA <<<");
        System.out.println("(1) - SOMAR \n(2) - SUBTRAIR \n(3) - MULTIPLICAR \n(4) - DIVIDIR");
        System.out.print("Escolha o calculo: ");

        // Recebe a opção desejada
        int opcao = entrada.nextInt();
        int num1 = 0;
        int num2 = 0;
        // Pergunta os valores a serem usados no calculo

        if (opcao >= 1 && opcao <= 4) {
            System.out.print("Entre o 1º numero: ");
            num1 = entrada.nextInt();
            System.out.print("Entre o 2º numero: ");
            num2 = entrada.nextInt();
            System.out.print("O resultado é: ");
        }
        switch (opcao){
            case 1:
                System.out.println(somarDoisNumeros(num1, num2));
                break;

            default:
                System.out.println("Opção Invalida!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                break;
        }


    }
    public static int somarDoisNumeros(int num1, int num2){
        return num1 + num2;
    }

}