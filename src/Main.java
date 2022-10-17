public class Main {
    public static void main(String[] args) {
        Unicorn a = new Unicorn();
        DendroidGuard b = new DendroidGuard();
        Combat combat = new Combat(a, b);
        combat.start();
    }
}