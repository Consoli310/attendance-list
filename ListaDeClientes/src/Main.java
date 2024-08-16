import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Convidados convidados = new Convidados();


        while (true) {

            int choice = 0;

            while (true) {
                convidados.mainUses();
                String entrada = sc.nextLine();
                try {
                    choice = Integer.parseInt(entrada);
                } catch (NumberFormatException e) {
                    Convidados.clearConsole();
                    System.out.println("Você não digitou um número");
                }
                if (choice > 5 || choice < 1) {
                    Convidados.clearConsole();
                    System.out.println("Digite um número entre 1 a 5");
                } else {
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
                    Convidados.clearConsole();
                    break;


                case 2:
                    while (true) {
                        int choiceInt = 0;
                        System.out.println("Digite o número entre 1 e " + convidados.getListaConvidados().size() + ":");
                        String escolha = sc.nextLine();
                        if (Objects.equals(escolha, "sair")) {
                            break;
                        }
                        try {
                            choiceInt = Integer.parseInt(escolha);
                        } catch (NumberFormatException e) {
                            Convidados.clearConsole();
                            System.out.println("Você não digitou um número");
                        }
                        if (choiceInt > convidados.getListaConvidados().size() || choiceInt < 0) {
                            Convidados.clearConsole();
                            System.out.println("Você não digitou um número válido");
                        }
                        if (choiceInt > 0 && choiceInt <= convidados.getListaConvidados().size()) {
                            String guest = convidados.getListaConvidados((choiceInt - 1));
                            convidados.removeList((choiceInt - 1));
                            Convidados.clearConsole();
                            System.out.println(guest + " foi removido.");
                            break;
                        }
                    }
                    break;
                case 3:
                    Convidados.clearConsole();
                    if (convidados.getListaConvidados().isEmpty()) {
                        System.out.println("A lista está vazia.");
                        break;
                    }
                    System.out.println("Lista completa de convidados:");
                    int contador = 1;
                    for (String name : convidados.getListaConvidados()) {
                        System.out.println("||||  " + contador + " - " + name);
                        contador += 1;
                    }
                    break;


                case 4:
                    Convidados.clearConsole();
                    convidados.noPay();
                    if (convidados.getListaNoPay().isEmpty()) {
                        System.out.println("A lista está vazia.");
                        break;
                    }
                    System.out.println("Lista menores de 5 anos: ");
                    contador = 1;
                    for (String name : convidados.getListaNoPay()) {
                        System.out.println("||||  " + contador + " - " + name);
                        contador += 1;
                    }

                    break;

                case 5:
                    convidados.calcExcedentes();
                    break;

            }

        }
    }
}