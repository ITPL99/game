package graph;

import java.util.*;

public class MyGraph<E> {

    private final Map<E, List<E>> graph = new HashMap<>();

    public void addVertex(E vertex){
        graph.putIfAbsent(vertex, new ArrayList<>());
    }

    public void addEdge(E vertexOne,E vertexTwo){
        graph.get(vertexOne).add(vertexTwo);
        graph.get(vertexTwo).add(vertexOne);
    }

    public List<E> getDependencies(E vertex){
        return graph.get(vertex);
    }

    public void search(E startVertex){
        Set<E> visited = new HashSet<>();
        searchHelper(startVertex, visited);
    }

    private void searchHelper(E vertex, Set<E> visited){
        if(!visited.contains(vertex)){
            visited.add(vertex);
            System.out.println(vertex);
            for(E vertextwo : getDependencies(vertex)){
                searchHelper(vertextwo, visited);
            }
        }
    }
}
