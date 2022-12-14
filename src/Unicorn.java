public class Unicorn extends Creature{

    void setAttack(){
        attack = r.nextInt(18, 23);
    }
    void setDefence(){
        defence = 14;
    }

    public Unicorn() {
        name = "Unicorn";
        defence = 14;
        health = 90;
        speed = 7;
        xCoordinate = 25 * numOfCreatures;
        setAttack();
        numOfCreatures++;
        specialCooldown = 4;
    }

    @Override
    void special() {
        if (attack >= enemy.health + enemy.defence) {
            attackEnemy();
            return;
        }
        else {System.out.println("SPECIAL! " + name + " is swept away by the rainbow as well as debuffs. Take a break!");
        attack = r.nextInt(18, 23);
        defence = 14;
        if (xCoordinate - 10 >= 0)
            xCoordinate -=  10;
        else if (xCoordinate + 10 <= 25) {
            xCoordinate += 10;
        }
        else xCoordinate = 0;
            specialCooldown = 4;
        }

    }
}
