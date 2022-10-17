import java.util.Random;

import static java.lang.Math.abs;

public abstract class Creature {
    String name;
    int defence;
    int attack;
    int range = 1;
    int health;
    int speed;
    int xCoordinate;
    boolean dead = false;
    int specialCooldown;
    static Random r = new Random();
    static int numOfCreatures = 0;
    Creature enemy;



    abstract void setAttack();
    abstract void setDefence();
    abstract void Special();

    public void Attack(){
        int damage = attack - enemy.defence;
        if (damage < 0)
            damage = 0;
        enemy.health -= damage;
        System.out.println(name + " attacked " + enemy.name + " and dealed " + damage + " damage" +
                            System.lineSeparator() +
                            enemy.name + " now has " + enemy.health + " health!");
        enemy.die();
    }
    public void Defence(Creature target){
        target.Attack();
    } // ????

    void move(int x){
        if (abs(x) <= speed) {
            xCoordinate += x;
            System.out.println(name + " moved " + abs(x) + " cells, now standing at " + xCoordinate);
        }
    }
    public void moveToTarget(){
        int delta = enemy.xCoordinate - xCoordinate;
        int ideal = delta - delta/abs(delta)*range;
        if (abs(ideal) > speed)
            ideal = speed*(ideal/abs(ideal));
        move(ideal);
    }
    public void die(){
        if (health <= 0){
            System.out.println(name + " dies, :(");
            dead = true;
        }
    }

}
