public class CreateArcher implements SoldierInterface {
    @Override
    public Soldier create() {
        return new Archer();
    }
}
