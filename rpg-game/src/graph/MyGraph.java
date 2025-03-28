package graph;

import java.util.*;

public class MyGraph{

    Node addOrGetNode(HashMap<Integer,Node> graph, int value){
        if(value == -1) return null;
        if(graph.containsKey(value))return graph.get(value);
        Node node = new Node(value);
        graph.put(value,node);
        return node;
    }

    HashMap<Integer,Node> createGraph(int[][] graphData){
        HashMap<Integer, Node> graph = new HashMap<>();
        for(int[] row : graphData){
            Node node = addOrGetNode(graph,row[0]);
            Node adjacentNode = addOrGetNode(graph, row[1]);
            if(adjacentNode==null)continue;
            Edge edge =new Edge(adjacentNode, row[2]);
            node.edges.add(edge);
            adjacentNode.parents.put(node, edge);
        }
        return graph;
    }

    void DFSWrap(HashMap<Integer, Node> graph){
        HashSet<Node> passed = new HashSet<>();
        for(Map.Entry<Integer, Node> graphEntry : graph.entrySet()){
            Node node = graphEntry.getValue();
            if(!passed.contains(node)) DFS(node,passed);
        }
    }

    void DFS(Node node, HashSet<Node> passed){
        Stack<Node> stack = new Stack<>();
        stack.push(node);
        while (stack.size() != 0){
            node = stack.peek();
            if(!passed.contains(node)){
                System.out.println(node.value);
                passed.add(node);
            }
            boolean hasChildren = false;
            for(Edge edge : node.edges){
                if(!passed.contains(edge.adjacebnNode)){
                    stack.push(edge.adjacebnNode);
                    hasChildren = true;
                    break;
                }
            }
            if(!hasChildren) stack.pop();
        }
    }

    boolean getPath(Node start,
                    Node end,
                    HashSet<Node> passed,
                    LinkedList<Node> path){
        if(start == end){
            path.addFirst(start);
            return true;
        }
        passed.add(start);
        for(Edge edge:start.edges){
            if(!passed.contains(edge.adjacebnNode)){
                if(getPath(edge.adjacebnNode, end, passed, path)){
                    path.addFirst(start);
                    return true;
                }
            }
        }
        return false;

    }

    List<LinkedHashSet<Node>> getPathAllWrap(Node start, Node end){
        List<LinkedHashSet<Node>> paths = new ArrayList<>();
        if(start == null) return paths;
        getPathAll(start, end, new LinkedHashSet<>(),paths);
        return paths;
    }

    void getPathAll(Node start,
                    Node end,
                    LinkedHashSet<Node> passed,
                    List<LinkedHashSet<Node>> path){
        if(start == end){
            path.add((LinkedHashSet<Node>)passed.clone());
            path.get(path.size() - 1).add(end);
        }
        passed.add(start);
        for(Edge edge:start.edges){
            if(!passed.contains(edge.adjacebnNode)){
                getPathAll(edge.adjacebnNode, end, passed, path);
            }
        }
        passed.remove(start);
    }

    void BFS(Node node, HashSet<Node> visiting){
        LinkedList<Node> queue = new LinkedList<>();
        queue.add(node);
        visiting.add(node);
        while(!queue.isEmpty()){
            node = queue.removeFirst();
            System.out.println(node.value);
            for(Edge edge: node.edges){
                if(!visiting.contains(edge.adjacebnNode)){
                    queue.addLast(edge.adjacebnNode);
                    System.out.println(edge.adjacebnNode.value);
                }
            }
        }
    }

    void BFSWrap(HashMap<Integer, Node> graph){
        HashSet<Node> visiting = new HashSet<>();
        for(Map.Entry<Integer,Node> entry:graph.entrySet()){
            if(!visiting.contains(entry.getValue())){
                BFS(entry.getValue(),visiting);
            }
        }
    }


}
