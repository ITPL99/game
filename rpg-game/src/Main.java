import lacation.Position;

public class Main {
    public static void main(String[] args) {
        Position<Integer> link = new Position<>();
        link.start(1);
        link.goRights(2);
        link.goLeft();
        link.goUp(3);
        link.goDown();
        link.goDown(4);
        link.goUp();
        link.goLeft(5);
        link.printHeritage();
    }
}