package chapter8;

import util.Tuple;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;

public class ClassroomScheduling {

    static List<String> processed = new ArrayList<>();
    static HashSet<String> scheduledClasses = new LinkedHashSet<>();

    private static void scheduleClasses(LocalTime startTime, LocalTime endTime, Map<String, Tuple<LocalTime, LocalTime>> classes) {
        Map.Entry<String, Tuple<LocalTime, LocalTime>> firstClass = findSoonestClass(classes);
        while (firstClass != null) {
            if (firstClass.getValue().getF().compareTo(startTime) >= 0 && firstClass.getValue().getS().compareTo(endTime) <= 0) {
                scheduledClasses.add(firstClass.getKey());
                startTime = firstClass.getValue().getS();
            }
            processed.add(firstClass.getKey());
            firstClass = findSoonestClass(classes);
        }
    }

    private static Map.Entry<String, Tuple<LocalTime, LocalTime>> findSoonestClass(Map<String, Tuple<LocalTime, LocalTime>> classes) {
        return classes.entrySet()
                .stream()
                .filter(each -> !processed.contains(each.getKey()))
                .min(Comparator.comparing(each -> each.getValue().getS()))
                .orElse(null);
    }

    public static void main(String[] args) {

        Map<String, Tuple<LocalTime, LocalTime>> classes = new HashMap<>();
        classes.put("Art", new Tuple<>(LocalTime.of(9, 0), LocalTime.of(10, 0)));
        classes.put("Eng", new Tuple<>(LocalTime.of(9, 30), LocalTime.of(10, 30)));
        classes.put("Math", new Tuple<>(LocalTime.of(10, 0), LocalTime.of(11, 0)));
        classes.put("CS", new Tuple<>(LocalTime.of(10, 30), LocalTime.of(11, 30)));
        classes.put("Music", new Tuple<>(LocalTime.of(11, 0), LocalTime.of(12, 0)));
        LocalTime startTime = LocalTime.of(9, 0);
        LocalTime endTime = LocalTime.of(12, 0);

        scheduleClasses(startTime, endTime, classes);

        scheduledClasses.forEach(System.out::println);
    }
}
