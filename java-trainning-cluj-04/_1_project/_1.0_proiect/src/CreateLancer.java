public class CreateLancer implements SoldierInterface {
    @Override
    public Soldier create() {
        return new Lancer();
    }
}
