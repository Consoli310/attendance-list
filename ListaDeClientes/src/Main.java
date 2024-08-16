import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
       Convidados convidados = new Convidados();


       while(true) {

           int choice = 0;

           while(true) {
               convidados.mainUses();
               String entrada = sc.nextLine();
               try {
                   choice = Integer.parseInt(entrada);
               } catch (NumberFormatException e) {
                   System.out.println("Você não digitou um número");
               }
               if (choice > 5 || choice < 0) {
                   System.out.println("Digite um número entre 1 a 5");
                   break;
               }
               if(choice < 5 && choice > 0){
                   break;
               }
           }

        switch (choice) {

            case 1:
                System.out.println("Digite os nomes seguidos de enter (ou 'sair'):");
                while (true) {
                    String name = sc.nextLine();
                    if (!Objects.equals(name, "sair")) {
                        convidados.addList(name);
                    } else {
                        break;
                    }
                }
                break;


            case 2:
                while(true) {
                    int choiceInt = 0;
                    System.out.println("Digite o número entre 1 e " + convidados.listaConvidados.size() + ":");
                    String escolha = sc.nextLine();
                    if (Objects.equals(escolha, "sair")) {
                        break;
                    }
                    try {
                        choiceInt = Integer.parseInt(escolha);
                    } catch (NumberFormatException e) {
                        System.out.println("Você não digitou um número");
                    }
                    if (choiceInt > convidados.listaConvidados.size() || choiceInt < 0) {
                        System.out.println("Você não digitou um número válido");
                    }
                    if(choiceInt > 0 && choiceInt <= convidados.listaConvidados.size()){
                        String guest = convidados.getListaConvidados((choiceInt - 1));
                        convidados.removeList((choiceInt - 1));
                        System.out.println(guest + " foi removido.");
                        break;
                    }
                }
            case 3:
                System.out.println("Lista completa de convidados:");
                int contador = 1;
                for (String name : convidados.listaConvidados) {
                    System.out.println("||||  " + contador + " - " + name);
                    contador += 1;
                }
                break;


            case 4:
                System.out.println("Lista menores de 5 anos: ");
                int contador2 = 1;
                convidados.noPay();
                for(String name : convidados.listaNoPay){
                    System.out.println("||||  " + contador2 + " - " + name);
                    contador2 += 1;
                }

                break;

            case 5:
                convidados.calcExcedentes();
                break;
        }
        }
    }
}