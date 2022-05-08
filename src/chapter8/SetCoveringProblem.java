package chapter8;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class SetCoveringProblem {

    static Set<String> finalStations = new LinkedHashSet<>();

    public static void main(String[] args) {
        Map<String, Set<String>> stations = SetCoveringData.getStations();
        Set<String> states = SetCoveringData.getStates();

        while (!states.isEmpty()) {
            states = findBestStation(states, stations);
        }
        finalStations.forEach(System.out::println);
    }

    private static Set<String> findBestStation(Set<String> states, Map<String, Set<String>> stations) {
        //  states_covered is a set of all the states this station covers
        Set<String> statesCovered = new HashSet<>();
        String bestStation = null;
        //  loop over every station to see which one is the best station
        for (Map.Entry<String, Set<String>> each : stations.entrySet()) {
            Set<String> statesCoveredByStation = each.getValue();
            // a set of states that were in both states_needed and states_for_station.
            statesCoveredByStation.retainAll(states);
            // check whether this station covers more states than the current best_station.
            if (statesCoveredByStation.size() > statesCovered.size()) {
                bestStation = each.getKey();
                statesCovered = statesCoveredByStation;
            }
        }
        // update states_needed. Because this station covers some states, those states aren’t needed anymore
        states.removeAll(statesCovered);
        finalStations.add(bestStation);
        return states;
    }

}
