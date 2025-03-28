import graph.MyGraph;
import lacation.Position;

public class Main {
    public static void main(String[] args) {
        Position<Integer> link = new Position<>();
        link.start(3);
        link.goRights(2);
        link.goLeft();
        link.goLeft(2);
        link.goRights();
        link.goUp(2);
        link.goDown();
        link.goDown(2);
        link.goUp();
        MyGraph<Integer> graph = new MyGraph<>();
        graph.addVertex(5);
        graph.addVertex(6);
        graph.addVertex(4);
        graph.addVertex(2);
        graph.addVertex(1);
        graph.addVertex(9);
        graph.addVertex(13);
        graph.addVertex(15);
        graph.addVertex(16);
        graph.addEdge(5,4);
        graph.search(5);
    }
}