package chapter6;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Hashtable;
import java.util.List;

public class BreadthFirstSearch {

    public static void main(String[] args) {
        Hashtable<String, List<String>> friends = new Hashtable<>() {
            {
                put("you", List.of("alice", "bob", "claire"));
                put("alice", List.of("peggy"));
                put("bob", List.of("peggy", "anuj"));
                put("claire", List.of("thom", "jonny"));
                put("peggy", new ArrayList<>());
                put("anuj", new ArrayList<>());
                put("thom", new ArrayList<>());
                put("jonny", new ArrayList<>());
            }
        };
        System.out.println(breadthFirstSearch(friends));
    }

    static boolean breadthFirstSearch(Hashtable<String, List<String>> friends) {
        String initialSearchKey = "you";
        List<String> searched = new ArrayList<>();
        Deque<String> searchQueue = new ArrayDeque(friends.get(initialSearchKey));

        while (!searchQueue.isEmpty()) {
            String item = searchQueue.removeFirst();
            if (!searched.contains(item)) {
                if (isSeller(item)) {
                    return true;
                } else {
                    searchQueue.addAll(friends.get(item));
                    searched.add(item);
                }
            }
        }
        return false;
    }

    static boolean isSeller(String item) {
        return item.startsWith("m");
    }

}
