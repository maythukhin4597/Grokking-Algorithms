package chapter6;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.HashSet;
import java.util.Optional;
import java.util.Queue;
import java.util.Set;

/**
 * ref : https://www.baeldung.com/java-breadth-first-search
 */
public class BFSGraph {

    public static void main(String[] args) {
        Node<Integer> start = new Node<>(10);
        Node<Integer> firstNeighbor = new Node<>(2);
        start.connect(firstNeighbor);

        Node<Integer> firstNeighborNeighbor = new Node<>(3);
        firstNeighbor.connect(firstNeighborNeighbor);
        firstNeighborNeighbor.connect(start);

        Node<Integer> secondNeighbor = new Node<>(4);
        start.connect(secondNeighbor);

        Optional<Node<Integer>> item = search(4, firstNeighborNeighbor);
        if (item.isPresent())
            System.out.println("Found");
        else System.out.println("Not Found");
    }

    static <T> Optional<Node<T>> search(T value, Node<T> start) {
        Queue<Node<T>> queue = new ArrayDeque<>();
        queue.add(start);

        Node<T> currentNode;
        Set<Node<T>> alreadyVisited = new HashSet<>();

        while (!queue.isEmpty()) {
            currentNode = queue.remove();

            if (currentNode.getValue().equals(value)) {
                return Optional.of(currentNode);
            } else {
                alreadyVisited.add(currentNode);
                queue.addAll(currentNode.getNeighbors());
                queue.removeAll(alreadyVisited);
            }
        }
        return Optional.empty();
    }
}

class Node<T> {

    private T value;
    private Set<Node<T>> neighbors;

    Node(T value) {
        this.value = value;
        this.neighbors = new HashSet<>();
    }

    T getValue() {
        return value;
    }

    Set<Node<T>> getNeighbors() {
        return Collections.unmodifiableSet(neighbors);
    }

    void connect(Node<T> node) {
        if (this == node) throw new IllegalArgumentException("Can't connect node to itself");
        this.neighbors.add(node);
        node.neighbors.add(this);
    }
}
