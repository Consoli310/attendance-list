import javax.print.attribute.standard.NumberOfInterveningJobs;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Functions functions = new Functions();


        while (true) {

            int choice = 0;

            while (true) {
                System.out.println("**********************************");
                System.out.println("1 - Adicionar convidados");
                System.out.println("2 - Remover convidados");
                System.out.println("3 - Ver lista completa");
                System.out.println("4 - Ver lista não pagantes");
                System.out.println("5 - Calcular excedentes");
                System.out.println("**********************************");
                String entry = sc.nextLine();

                if (Objects.equals(entry, "EXIT")) {
                    System.out.println("Tem certeza que deseja encerrar o programa? (s/n)");
                    String exit = sc.nextLine();
                    if (Objects.equals(exit, "s")) {
                        System.exit(0);
                    } else {
                        Functions.clearConsole();
                    }
                }
                try {
                    choice = Integer.parseInt(entry);
                } catch (NumberFormatException e) {
                    Functions.clearConsole();
                    System.out.println("Você não digitou um número");
                }
                if (choice > 5 || choice < 1) {
                    Functions.clearConsole();
                    System.out.println("Digite um número entre 1 a 5");
                } else {
                    break;
                }
            }

            switch (choice) {

                case 1:
                    Functions.clearConsole();
                    System.out.println("Digite os nomes seguidos de enter (ou 'sair'):");
                    while (true) {
                        String name = sc.nextLine();
                        if (!Objects.equals(name, "sair")) {
                            functions.addList(name);
                        } else {
                            break;
                        }
                    }
                    functions.noPayListAdd();
                    Functions.clearConsole();
                    break;

                case 2:
                    while (true) {
                        Functions.clearConsole();
                        int choiceInt = 0;
                        System.out.println("Digite o número do convidado a ser removido(ou 'sair')");
                        String escolha = sc.nextLine();
                        if (Objects.equals(escolha, "sair")) {
                            Functions.clearConsole();
                            break;
                        }
                        try {
                            choiceInt = Integer.parseInt(escolha);
                        } catch (NumberFormatException e) {
                            Functions.clearConsole();
                            System.out.println("Você não digitou um número");
                        }
                        if (choiceInt > functions.getGuestsList().size() || choiceInt < 0) {
                            Functions.clearConsole();
                            System.out.println("Você não digitou um número válido");
                        }
                        if (choiceInt > 0 && choiceInt <= functions.getGuestsList().size()) {
                            String guest = functions.getGuestsList((choiceInt - 1));
                            functions.removeList((choiceInt - 1));
                            Functions.clearConsole();
                            System.out.println(guest + " foi removido(a).");
                            break;
                        }
                    }
                    break;

                case 3:
                    Functions.clearConsole();
                    if (functions.getGuestsList().isEmpty()) {
                        System.out.println("A lista está vazia.");
                        break;
                    }
                    System.out.println("Lista completa de convidados:");
                    int count = 1;
                    for (String name : functions.getGuestsList()) {
                        System.out.println("-->  " + count + " - " + name);
                        count += 1;
                    }
                    break;

                case 4:
                    Functions.clearConsole();
                    if (functions.getNoPayList().isEmpty()) {
                        System.out.println("A lista está vazia.");
                        break;
                    }
                    System.out.println("Lista menores de 5 anos: ");
                    count = 1;
                    for (String name : functions.getNoPayList()) {
                        System.out.println("-->  " + count + " - " + name);
                        count += 1;
                    }

                    break;

                case 5:
                    Functions.clearConsole();
                    int guestPackage = 0;
                    String entry = "";
                    System.out.println("O pacote da festa é para quantos convidados? (sair)");
                    entry = sc.nextLine();
                    if (entry.equalsIgnoreCase("sair")) {
                        Functions.clearConsole();
                        break;
                    }
                    while (true) {
                        try {
                            guestPackage = Integer.parseInt(entry);
                            break;
                        } catch (NumberFormatException e) {
                            Functions.clearConsole();
                            System.out.println("Digite um valor válido");
                            entry = sc.nextLine();
                        }
                    }

                    while (true) {

                        if (functions.isSurplus(guestPackage)) {
                            Functions.clearConsole();
                            System.out.println("Qual o valor para cada excedente? (sair)");
                            entry = sc.nextLine();
                            if (entry.equalsIgnoreCase("sair")) {
                                Functions.clearConsole();
                                break;
                            }
                            try {
                                double surplusValue = Double.parseDouble(entry);
                                Functions.clearConsole();
                                System.out.println("Valor total em excedentes R$" + functions.surplusCalc(guestPackage, surplusValue));
                                break;
                            } catch (NumberFormatException e) {
                                Functions.clearConsole();
                                System.out.println("Digite um valor válido");
                            }
                        } else {
                            Functions.clearConsole();
                            Functions.clearConsole();
                            System.out.println("Não há excedentes.");
                            break;
                        }
                    }
                    break;

            }

        }
    }
}