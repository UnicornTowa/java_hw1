public class DendroidGuard extends Creature{
    void setAttack(){
        attack = r.nextInt(10, 15);
    }
    void setDefence(){
        defence = 12;
    }

    public DendroidGuard() {
        name = "Dendroid guard";
        defence = 12;
        health = 55;
        speed = 3;
        xCoordinate = 25 * numOfCreatures;
        setAttack();
        numOfCreatures++;
        specialCooldown = 4;
    }

    @Override
    void special() {
        System.out.println("SPECIAL! " + name + " roots " + enemy.name + ", its attack and defence decreased for 1 turn");
        enemy.attack -= 10;
        enemy.defence -= 10;
        specialCooldown = 2;
    }
}
