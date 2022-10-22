public class Main {
    public static void main(String[] args)  {
        Unicorn a = new Unicorn(0);
        DendroidGuard b = new DendroidGuard(25);
        //Combat combat = new Combat(a, b);
        //combat.start();
        Combat combat2 = new Combat();
        combat2.startCombat("Unicorn", "DendroidGuard");
    }
}