public class FightObserver implements Observer {
    @Override
    public void update(String msg) {
        Interfata.resultBattle.add(msg);
    }
}
