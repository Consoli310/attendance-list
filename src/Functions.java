import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Functions {
    Scanner sc = new Scanner(System.in);
    private String name;
    private List<String> guestsList = new ArrayList<>();
    private List<String> noPayList = new ArrayList<>();

    public void addList(String name) {
        guestsList.add(name);
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

    public String getGuestsList(int indice) {
        return this.guestsList.get(indice);
    }

    public List<String> getGuestsList() {
        return this.guestsList;
    }


    public List<String> getNoPayList() {
        return noPayList;
    }


    public void removeList(int position) {
        for (String noPay : guestsList){
            if (Objects.equals(noPay, getGuestsList(position))){
                this.noPayList.remove(noPay);
            }
        }
        this.guestsList.remove(position);
    }

    public void noPayListAdd() {
        for (String x : this.guestsList) {
            if (x.contains("-")) {
                this.noPayList.add(x);
            }
        }
    }
    public boolean isSurplus(int guestPackage){
        if (guestsList.size() - noPayList.size()  > guestPackage){
            return true;
        }else{
            return false;
        }
    }

    public double surplusCalc(int guestPackage, double surplusValue){
        return (payersNumber() - guestPackage) * surplusValue;
    }

    static void clearConsole() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public int payersNumber() {
        return guestsList.size() - noPayList.size();
    }
}
