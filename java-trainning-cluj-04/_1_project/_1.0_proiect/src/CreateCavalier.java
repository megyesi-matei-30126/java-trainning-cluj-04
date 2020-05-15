public class CreateCavalier implements SoldierInterface {
    @Override
    public Soldier create() {
        return new Cavalier();
    }
}
