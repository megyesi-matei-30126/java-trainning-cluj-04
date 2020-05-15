public class BattleSimulation {
    public static void main(String[] args) {
        Fight fight = new Fight();
        FightObserver fightObserver = new FightObserver();
        fight.register(fightObserver);
        Interfata i = new Interfata(fight);
    }
}
