import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Convidados {

    Scanner sc = new Scanner(System.in);
    String name;
    List<String> listaConvidados = new ArrayList<>();
    List<String> listaNoPay = new ArrayList<>();

    public void addList(String name){
        listaConvidados.add(name);
    }

    public Scanner getSc() {
        return sc;
    }

    public void setSc(Scanner sc) {
        this.sc = sc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getListaConvidados(int indice) {
            return this.listaConvidados.get(indice);
    }

    public void setListaConvidados(List<String> listaConvidados) {
        this.listaConvidados = listaConvidados;
    }

    public List<String> getListaNoPay() {
        return listaNoPay;
    }

    public void setListaNoPay(List<String> listaNoPay) {
        this.listaNoPay = listaNoPay;
    }

    public void mainUses(){
        System.out.println("**********************************");
        System.out.println("1 - Adicionar convidados");
        System.out.println("2 - Remover convidados");
        System.out.println("3 - Ver lista completa");
        System.out.println("4 - Ver lista não pagantes");
        System.out.println("5 - Calcular excedentes");
        System.out.println("**********************************");
    }

    public void removeList(int position){
        this.listaConvidados.remove(position);
    }

    public void noPay(){
        for(String x : this.listaConvidados){
            if (x.contains("-5")){
                this.listaNoPay.add(x);
            }
        }
    }

    public void calcExcedentes() {
        System.out.println("O pacote da festa é para quantos convidados?");
        int totalConvidadosPacote = sc.nextInt();
        sc.nextLine();
        int valor = 0;

        if (totalPagantes() > totalConvidadosPacote) {
            valor = (totalPagantes() - totalConvidadosPacote) * 55;
            System.out.println("Número de excedentes = " + (totalPagantes() - totalConvidadosPacote));
            System.out.println("Valor a ser pago: " + valor);
        }else {
            System.out.println("Não há excedentes");
        }
    }

    public int totalPagantes(){
        return listaConvidados.size() - listaNoPay.size();
    }
}
