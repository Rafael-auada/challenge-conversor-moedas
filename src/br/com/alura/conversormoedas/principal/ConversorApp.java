package br.com.alura.conversormoedas.principal;

import br.com.alura.conversormoedas.funcoes.Conversor;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class ConversorApp {
    public static void main(String[] args) {
        // declaração de variáveis e criação de objeto conversor e scanner leitura
        Conversor conversor = new Conversor();
        Scanner leitura = new Scanner(System.in);
        int opt = 0;
        double quantia = 0.0;
        System.out.println("**************************************\n"+
                "Bem vindo ao Conversor de Moedas!");

        // começa o loop da parte principal do aplicativo, que se repete enquanto a escolha for diferente de 7
        while(opt!=7){
            System.out.println("""
                    **************************************
                    Escolha uma opção válida:
                    1. Real brasileiro (BRL) =>> Dólar americano (USD)
                    2. Dólar americano (USD) =>> Real brasileiro (BRL)
                    3. Real brasileiro (BRL) =>> Peso argentino (ARS)
                    4. Peso argentino (ARS) =>> Real brasileiro (BRL)
                    5. Real brasileiro (BRL) =>> Euro (EUR)
                    6. Euro (EUR) =>> Real brasileiro (BRL)
                    7. Finalizar programa.
                    """);
            // leitura da opção do usuário
            opt = leitura.nextInt();
            //verificação da opção, caso for uma opção válida e diferente de 7, pede-se a quantia para conversão
            if (opt!=7 && opt<7 && opt>0){
                System.out.println("Digite a quantia a ser convertida:");
                quantia = leitura.nextDouble();
            }
            // Switch para executar o conversor de acordo com a opção do usuário
            switch (opt){
                case 1:
                    // chamada do método converterMoeda com parâmetros de acordo com a opção escolhida
                    conversor.converterMoeda("BRL", "USD", quantia);
                    break;
                case 2:
                    conversor.converterMoeda("USD", "BRL", quantia);
                    break;
                case 3:
                    conversor.converterMoeda("BRL", "ARS", quantia);
                    break;
                case 4:
                    conversor.converterMoeda("ARS", "BRL", quantia);
                    break;
                case 5:
                    conversor.converterMoeda("BRL", "EUR", quantia);
                    break;
                case 6:
                    conversor.converterMoeda("EUR", "BRL", quantia);
                    break;
                case 7:
                    // escolha de saída do programa
                    System.out.println("Programa Finalizado!\n" +
                            "**************************************");
                    break;
                default:
                    // para opções inválidas
                    System.out.println("Você digitou uma opção inválida");
                    break;
            }
        }
    }
}