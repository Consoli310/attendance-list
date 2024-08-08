import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
       Convidados convidados = new Convidados();


       while(true){
        convidados.mainUses();
        int x = sc.nextInt();
        sc.nextLine();

        switch (x) {

            case 1:
                System.out.println("Digite os nomes seguidos de enter (ou 'sair'):");
                while(true) {
                    String name = sc.nextLine();
                    if (!Objects.equals(name, "sair")) {
                        convidados.addList(name);
                    } else {
                        break;
                    }
                }
                break;


            case 2:
                System.out.println("Digite o número do convidado que vai sair da lista:");
                int position = sc.nextInt();
                sc.nextLine();
                position = position - 1;
                if(position > convidados.listaConvidados.size() || position < 1){
                    System.out.println("Número inválido");
                }
                else {
                    convidados.removeList(position);
                }
                break;


            case 3:
                System.out.println("Lista completa de convidados:");
                int contador = 1;
                for (String y : convidados.listaConvidados) {
                    System.out.println(contador + " - " + y);
                    contador += 1;
                }
                break;


            case 4:
                System.out.println("Lista menores de 5 anos: ");
                int contador2 = 1;
                convidados.noPay();
                for(String name : convidados.listaNoPay){
                    System.out.println(contador2 + " - " + name);
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