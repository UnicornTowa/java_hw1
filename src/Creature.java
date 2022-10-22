import java.util.Random;

import static java.lang.Math.abs;

public abstract class Creature {
    protected String name;
    protected int defence;
    protected int attack;
    protected int range = 1;
    protected int health;
    protected int speed;
    protected int xCoordinate;
    protected boolean dead = false;
    protected int specialCooldown;
    protected static Random r = new Random();
    protected Creature enemy;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDefence() {
        return defence;
    }

    public void setDefence(int defence) {
        this.defence = defence;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getRange() {
        return range;
    }

    public void setRange(int range) {
        this.range = range;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getxCoordinate() {
        return xCoordinate;
    }

    public void setxCoordinate(int xCoordinate) {
        this.xCoordinate = xCoordinate;
    }

    public boolean isDead() {
        return dead;
    }

    public void setDead(boolean dead) {
        this.dead = dead;
    }

    public int getSpecialCooldown() {
        return specialCooldown;
    }

    public void setSpecialCooldown(int specialCooldown) {
        this.specialCooldown = specialCooldown;
    }

    public static Random getR() {
        return r;
    }

    public static void setR(Random r) {
        Creature.r = r;
    }

    public Creature getEnemy() {
        return enemy;
    }

    public void setEnemy(Creature enemy) {
        this.enemy = enemy;
    }

    abstract void setAttack();
    abstract void setDefence();
    abstract void special();

    public void attackEnemy(){
        int damage = attack - enemy.defence;
        if (damage < 0)
            damage = 0;
        enemy.health -= damage;
        System.out.println(name + " attacked " + enemy.name + " and dealed " + damage + " damage" +
                            System.lineSeparator() +
                            enemy.name + " now has " + enemy.health + " health!");
        enemy.die();
    }


    private void move(int x){
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
