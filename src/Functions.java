import java.util.ArrayList;
import java.util.List;

public class Functions {
    private String name;
    private List<String> guestsList = new ArrayList<>();
    private List<String> noPayList = new ArrayList<>();

    public void addList(String name) {
        guestsList.add(name);
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
        String guestNoPayToRemove = getGuestsList(position);
        this.noPayList.remove(guestNoPayToRemove);
        this.guestsList.remove(position);
    }

    public void noPayListAdd(String name) {
        this.noPayList.add(name);

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

    static void clearConsole() {                // Only works in ANSI Escape Code terminals
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public int payersNumber() {
        return guestsList.size() - noPayList.size();
    }
}
