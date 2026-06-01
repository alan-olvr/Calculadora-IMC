
/* a Exec será responsável pelas seguintes operações: Ler nome do usuário,
       Coletar dados antropométricos (peso: kg, altura: metros), oferecer um menu
       de repetição contínuo para novos cálculos e garantir o encerramento seguro
       e sob demanda da aplicação.
*/

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Locale;
import entities.Person;
import services.Calculator;
import uinterface.InterfaceUsuario;

public class Exec {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        Locale.setDefault(Locale.US);
        InterfaceUsuario interfaceUser = new InterfaceUsuario();
        List<Person> historico = new ArrayList<>();

        int select = 1;

        do {

           interfaceUser.exibirMenu();

           int opcao = interfaceUser.lerOpcao(sc);
           if(opcao == 0) select = 0;
           System.out.println();

           switch(opcao) {
                case 1:

                    System.out.println("======== CALCULAR NOVO IMC ========");
                    int load = 1;

                    while(load != 0) {
                        String nome = interfaceUser.lerNome(sc);
                        double peso = interfaceUser.lerPeso(sc);
                        double altura = interfaceUser.lerAltura(sc);

                        Person person = new Person(nome, peso, altura);
                        Calculator calc = new Calculator(person);

                        System.out.println("======== RESULTADO ========");
                        System.out.printf("IMC: %.2f\n", calc.calcularImc());
                        System.out.println("Status: " + calc.classificaImc());
                        System.out.println(calc.imcMessage());
                        System.out.println();
                        historico.add(person);

                        System.out.println("Deseja calcular um novo IMC? 1 - SIM | 2 - NÃO");
                        load = sc.nextInt();
                        sc.nextLine();

                        if(load == 2) load = 0;
                    }
                break;

               case 2:
                   System.out.println();
                   System.out.println(interfaceUser.exibirTabela());
                   System.out.println("Verificação concluída!");
                   System.out.println();
               break;

               case 3:

                   System.out.println("----- HISTORICO DE CONSULTAS IMC -----");

                   if(historico.isEmpty()){
                       System.out.println("Não há dados a serem consultados. Selecione a OPÇÃO 1 e insira novos dados para realizar consultas.");
                   }

                   int count = 1;
                   for(Person p : historico) {
                       System.out.printf("[%d] %s | IMC: %.1f - %s\n",
                               count,
                               p.getNome(),
                               p.getImc(),
                               p.getClassificacao());
                       count++;
                   }

                   if(!historico.isEmpty()){
                       System.out.println("Consultas realizadas. Voltando ao MENU...");
                   }

                   System.out.println();
               break;

               case 4:
                    System.out.println(interfaceUser);
                    System.out.println("Voltando ao menu...");
                    System.out.println();
               break;

               default:
                   System.out.println("Opção Inválida. Retornando ao Menu...");
                   System.out.println();
           }
        } while(select != 0);
    }
}