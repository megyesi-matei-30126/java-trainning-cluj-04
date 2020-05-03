import java.util.ArrayList;
import java.util.List;

public class RealEstateAgentProxy implements ConditionToRent {
    private List<Apartament> apartamentList;

    public RealEstateAgentProxy() {
        this.apartamentList = new ArrayList<>();
    }

    public void represent(Apartament apratament) {
        System.out.println(apratament.toString() + " represent");
        this.apartamentList.add(apratament);
    }

    @Override
    public Apartament rent(Student student, Apartament apartament) {
        if (student.getName().trim().startsWith("P")) {
            return null;
        } else {
            if (searchApartament(apartament)) {
                if (student.getMoney() >= apartament.getMonthlyRentCost()) {
                    System.out.println(student + " rented" + apartament.toString());
                } else {
                    System.out.println(student.toString() + " not enoughy money for rent this " + apartament.toString());
                    System.out.println(apartament.toString() + " not rent!");
                }
            } else {
                System.out.println(apartament.toString() + " not found");
            }
            return apartament;
        }
    }

    public boolean searchApartament(Apartament apartament) {
        for (Apartament apartament1 : this.apartamentList) {
            if (apartament1.equals(apartament)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "RealEstateAgentProxy{" +
                "apartamentList=" + apartamentList +
                '}';
    }
}
