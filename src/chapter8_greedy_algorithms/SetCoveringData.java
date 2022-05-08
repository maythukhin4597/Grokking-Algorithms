package chapter8_greedy_algorithms;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class SetCoveringData {

    static Set<String> getStates() {
        Set<String> statesNeededToCover = new LinkedHashSet<>();
        statesNeededToCover.add("mt");
        statesNeededToCover.add("wa");
        statesNeededToCover.add("or");
        statesNeededToCover.add("id");
        statesNeededToCover.add("nv");
        statesNeededToCover.add("ut");
        statesNeededToCover.add("ca");
        statesNeededToCover.add("az");
        return statesNeededToCover;
    }

    static Map<String, Set<String>> getStations() {
        Map<String, Set<String>> stations = new LinkedHashMap<>();
        stations.put("kone", new HashSet() {{
            add("id");
            add("nv");
            add("ut");
        }});
        stations.put("ktwo", new HashSet() {{
            add("wa");
            add("id");
            add("mt");
        }});
        stations.put("kthree", new HashSet() {{
            add("or");
            add("nv");
            add("ca");
        }});
        stations.put("kfour", new HashSet() {{
            add("nv");
            add("ut");
        }});
        stations.put("kfive", new HashSet() {{
            add("ca");
            add("az");
        }});
        return stations;
    }
}
