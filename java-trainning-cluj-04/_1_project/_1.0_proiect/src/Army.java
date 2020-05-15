
import java.util.ArrayList;
import java.util.List;

public class Army {
    static List<Soldier> soldati = new ArrayList<>();
    static List<Soldier> soldati2 = new ArrayList<>();

    public Army() {
        soldati = new ArrayList<>();
        soldati2 = new ArrayList<>();
    }

    public List<Soldier> getSoldati() {
        return soldati;
    }

    public static List<Soldier> getSoldati2() {
        return soldati2;
    }
}
