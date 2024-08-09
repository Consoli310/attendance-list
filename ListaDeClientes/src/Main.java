import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
       Convidados convidados = new Convidados();


       while(true){
        convidados.mainUses();
        String entrada = sc.nextLine();
        int choice = 0;

        while(true){
            try{
                choice = Integer.parseInt(entrada);
            }catch(NumberFormatException e){
                System.out.println("Escolha uma opção entre 1 e 5");
                entrada = sc.nextLine();
            }
            if(choice >= 1 && choice <= 5){
                break;
            }else{
                System.out.println("Escolha uma opção entre 1 e 5");
                entrada = sc.nextLine();
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

                int numero = 0;
                System.out.println("Digite o número entre 1 e " + convidados.listaConvidados.size() + ":");
                String escolha = sc.nextLine();
                if (Objects.equals(escolha, "sair")){
                    break;
                }
                while (true) {
                    try {
                        numero = Integer.parseInt(escolha);
                    } catch (NumberFormatException e) {
                        System.out.println("Digite um número entre 1 e " + convidados.listaConvidados.size() + ":");
                    }
                    if (numero > 0 && numero <= convidados.listaConvidados.size()) {
                        System.out.println("Convidado(a) " + convidados.getListaConvidados((numero - 1)) + " removido!");
                        convidados.removeList((numero - 1));
                        break;
                    }
                    else{
                        System.out.println("Tente novamente");
                        entrada = sc.nextLine();
                    }
                    if(Objects.equals(entrada, "sair")) break;
                }

                break;
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