package chapter6;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Queue;

/**
 * ref : https://www.baeldung.com/java-breadth-first-search
 */
public class BFSTree {

    public static void main(String[] args) {
        Tree<Integer> root = Tree.of(10);
        Tree<Integer> rootFirstChild = root.addChild(2);
        Tree<Integer> depthMostChild = rootFirstChild.addChild(3);
        Tree<Integer> rootSecondChild = root.addChild(4);

        Optional<Tree<Integer>> item = search(4, root);
        if (item.isPresent())
            System.out.println("Found");
        else System.out.println("Not Found");
    }

    static <T> Optional<Tree<T>> search(T value, Tree<T> root) {
        Queue<Tree<T>> queue = new ArrayDeque<>();
        queue.add(root);

        Tree<T> currentNode;
        while (!queue.isEmpty()) {
            currentNode = queue.remove();

            if (currentNode.getValue().equals(value)) {
                return Optional.of(currentNode);
            } else {
                queue.addAll(currentNode.getChildren());
            }
        }
        return Optional.empty();
    }
}

class Tree<T> {

    private T value;
    private List<Tree<T>> children;

    Tree(T value) {
        this.value = value;
        this.children = new ArrayList<>();
    }

    static <T> Tree<T> of(T value) {
        return new Tree<>(value);
    }

    Tree<T> addChild(T value) {
        Tree<T> newChild = new Tree<>(value);
        children.add(newChild);
        return newChild;
    }

    List<Tree<T>> getChildren() {
        return Collections.unmodifiableList(children);
    }

    T getValue() {
        return value;
    }

}
