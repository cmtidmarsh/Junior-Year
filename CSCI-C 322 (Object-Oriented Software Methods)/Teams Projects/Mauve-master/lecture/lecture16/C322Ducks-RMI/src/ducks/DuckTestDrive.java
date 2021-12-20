package ducks;

public class DuckTestDrive {
    public static void main(String[] args) {
        MallardDuck duck = new MallardDuck();

        WildTurkey turkey = new WildTurkey();
        Duck turkeyAdapter = new TurkeyAdapter(turkey);

        System.out.println("The ducks.Turkey says...");
        turkey.gobble();
        turkey.fly();

        System.out.println("\nThe ducks.Duck says...");
        testDuck(duck);

        System.out.println("\nThe ducks.TurkeyAdapter says...");
        testDuck(turkeyAdapter);
    }

    static void testDuck(Duck duck) {
        duck.quack();
        duck.fly();
    }
}