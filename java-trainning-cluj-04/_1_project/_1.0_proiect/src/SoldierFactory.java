public class SoldierFactory {
    public static Soldier getSoldier(SoldierInterface soldierInterface) {
        return soldierInterface.create();
    }
}
