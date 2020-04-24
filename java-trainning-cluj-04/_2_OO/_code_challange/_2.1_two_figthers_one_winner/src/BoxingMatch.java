public class BoxingMatch {
    Fighter fighter1;
    Fighter fighter2;

    public BoxingMatch(Fighter fighter1, Fighter fighter2){
        this.fighter1 = fighter1;
        this.fighter2 = fighter2;
    }

    public String fight(){
        while (this.fighter1.getHealth() > 0 && this.fighter2.getHealth() > 0){
            this.fighter1.attack(this.fighter2);
            if (fighter2.getHealth() <= 0){
                break;
            }
            this.fighter2.attack(this.fighter1);
        }

        if (this.fighter1.getHealth() == 0){
            return "Winner " + fighter2.getName();
        } else {
            return "Winner " + fighter1.getName();
        }
    }
}
