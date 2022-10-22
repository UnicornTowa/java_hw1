import static java.lang.Math.abs;

public class Combat implements Game{
    private Creature a;
    private Creature b;
    public void startCombat(String name1, String name2){
        if (name1.equals("Unicorn") && name2.equals("DendroidGuard")){
            this.a = new Unicorn(0);
            this.b = new DendroidGuard(25);
            start();
        } else if (name2.equals("Unicorn") && name1.equals("DendroidGuard")) {
            this.b = new Unicorn(25);
            this.a = new DendroidGuard(0);
            start();
        }
        else throw new IllegalArgumentException();
    }
//    public Combat(Creature a, Creature b){
//        this.a = a;
//        this.b = b;
//    }

    private void action(Creature actor){
        if (abs(actor.getxCoordinate() - actor.getEnemy().getxCoordinate()) > actor.getRange()){
            actor.moveToTarget();
        }
        else {
            if (actor.getSpecialCooldown() <= 0){
                actor.special();
                return;
            }
            else {
                actor.attackEnemy();
                actor.setAttack();
                actor.enemy.setDefence();
            }
        }
        actor.setSpecialCooldown(actor.getSpecialCooldown() - 1);;
    }
    private void start(){
        a.setEnemy(b);
        b.setEnemy(a);
        while (!(a.isDead() | b.isDead())) {
            if (Creature.getR().nextInt(51) > 25) {
                action(a);
            }
            else { action(b);}
        }
    }
}
