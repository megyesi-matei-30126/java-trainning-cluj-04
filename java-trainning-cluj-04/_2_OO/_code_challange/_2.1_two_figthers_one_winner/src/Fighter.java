import java.util.Random;

public class Fighter {
    private String name;
    private double health;
    private double damagePerAttack;

    public Fighter(){
        this.name = "Matei";
        this.health = 100;
        this.damagePerAttack = 20;
    }

    public Fighter(String name, double health, double damagePerAttack){
        this.name = name;
        this.health = health;
        this.damagePerAttack = damagePerAttack;
    }

    public void attack(Fighter opponent){
        opponent.health -= this.getDamagePerAttack();
        if (opponent.getHealth() < 0){
            opponent.setHealth(0);
        }
        System.out.println( "Fighter " + this.name + " attack " + opponent.getName() + "\n" + "opponent's life is: " + opponent.getHealth());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getHealth() {
        return health;
    }

    public void setHealth(double health) {
        this.health = health;
    }

    public double getDamagePerAttack() {
        return damagePerAttack;
    }

    public void setDamagePerAttack(double damagePerAttack) {
        this.damagePerAttack = damagePerAttack;
    }

    @Override
    public String toString() {
        return "Fighter{" +
                "name='" + name + '\'' +
                ", health=" + health +
                ", damagePerAttack=" + damagePerAttack +
                '}';
    }
}
