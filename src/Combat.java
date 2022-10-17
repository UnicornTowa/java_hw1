import static java.lang.Math.abs;

public class Combat {
    private final Creature a;
    private final Creature b;
    public Combat(Creature a, Creature b){
        this.a = a;
        this.b = b;
    }

    private void action(Creature actor){
        if (abs(actor.xCoordinate - actor.enemy.xCoordinate) > actor.range){
            actor.moveToTarget();
        }
        else {
            if (actor.specialCooldown <= 0){
                actor.special();
                return;
            }
            else {
                actor.attackEnemy();
                actor.setAttack();
                actor.enemy.setDefence();
            }
        }
        actor.specialCooldown--;
    }
    public void start(){
        a.enemy = b;
        b.enemy = a;
        while (!(a.dead | b.dead)) {
            if (Creature.r.nextInt(51) > 25)
                action(a);
            else action(b);
        }
    }
}
