package uinterface;

// essa é a classe responsável pelas interações do usuário ao menu - uma espécie de main2

import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.time.*;

public class InterfaceUsuario {
    LocalDate d0 = LocalDate.parse("21/05/2026", DateTimeFormatter.ofPattern("dd/MM/yyyy"));

    public void exibirMenu() {
        System.out.println(" ======== MENU PRINCIPAL ======== ");
        System.out.println("1 - Calcular novo IMC");
        System.out.println("2 - Ver tabela de referência IMC");
        System.out.println("3 - Histórico de Consultas");
        System.out.println("4 - Sobre o sistema");
        System.out.println("0 - Sair");
    }

    public String lerNome(Scanner sc) {
        System.out.print("Informe seu nome: ");
        String nome = sc.nextLine();
        return nome;
    }

    public double lerPeso(Scanner sc){
        System.out.print("Informe seu peso (em kg): ");
        double peso = sc.nextDouble();

        while(peso <= 0) {
            System.out.print("PESO INVÁLIDO. INFORME NOVAMENTE: ");
            peso = sc.nextDouble();
        }

        return peso;
    }

    public double lerAltura(Scanner sc){
        System.out.print("Informe sua altura (em metros): ");
        double altura = sc.nextDouble();

        while(altura <= 0) {
            System.out.println("ALTURA INVÁLIDA. INFORME NOVAMENTE: ");
            altura = sc.nextDouble();
        }

        return altura;
    }

    public int lerOpcao(Scanner sc) {
        System.out.print("Selecione uma opção -> ");
        int opcao = sc.nextInt();
        sc.nextLine();
        return opcao;
    }

    public String exibirTabela(){
        return " ======== TABELA DE REFERÊNCIA IMC ========\n" +
                "Intervalo IMC   |   Classificação Clínica\n" +
                "      < 18.5    |   Abaixo do peso\n" +
                "  18.5 a 24.9   |   Peso normal\n" +
                "  25.0 a 29.9   |   Sobrepeso\n" +
                "  30.0 a 34.9   |   Obesidade Grau I\n" +
                "  35.0 a 39.9   |   Obesidade Grau II\n" +
                "      >= 40.0   |   Obesidade Grau III";
    }

    public String toString(){
        return " ==================== SOBRE O SISTEMA ====================\n " +
                "IMC Calc é uma aplicação desenvolvida em Java com o objetivo\n" +
                "de realizar o cálculo do Índice de Massa Corporal (IMC),\n" +
                "fornecendo ao usuário uma classificação baseada nos padrões\n" +
                "de referência estabelecidos pela Organização Mundial da Saúde.\n\n" +

                "Além de sua funcionalidade prática, o projeto foi concebido\n" +
                "como uma iniciativa de estudo voltada ao fortalecimento dos\n" +
                "fundamentos da linguagem Java e à consolidação de conceitos\n" +
                "essenciais do desenvolvimento backend, incluindo:\n" +
                "- Programação Orientada a Objetos (POO);\n" +
                "- Estruturas condicionais e de repetição;\n" +
                "- Organização em camadas;\n" +
                "- Manipulação de entrada de dados;\n" +
                "- Encapsulamento e separação de responsabilidades.\n\n" +

                "Versão do Sistema: v1.0\n" +
                "Sistema desenvolvido em: " + d0.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) + "\n" +
                "=========================================================";
    }
}
