import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int towns = sc.nextInt();
        Map<Integer, Integer> map = fillMapFromInput(sc, towns);

        int totalDistance = getTotalDistance(map);
        int totalFood = getTotalFood(map);
        int mostFood = getMostFood(map);

        printResult(map, totalDistance, totalFood, mostFood);
    }

    public static Map<Integer, Integer> fillMapFromInput(Scanner sc, int n) {
        Map<Integer, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {
            int distance = sc.nextInt();
            int food = sc.nextInt();
            map.put(distance, food);
        }
        return map;
    }

    public static int getMostFood(Map<Integer, Integer> map) {
        int mostFood = 0;
        for (int key : map.keySet()) {
            if (map.get(key) > mostFood) {
                mostFood = map.get(key);
            }
        }
        return mostFood;
    }

    public static int getTotalFood(Map<Integer, Integer> map) {
        int totalFood = 0;
        for (int key : map.keySet()) {
            totalFood += map.get(key);
        }
        return totalFood;
    }

    public static int getTotalDistance(Map<Integer, Integer> map) {
        int totalDistance = 0;
        for (int key : map.keySet()) {
            totalDistance += key;
        }
        return totalDistance;
    }

    public static void printResult(Map<Integer, Integer> map, int totalDistance, int totalFood, int mostFood) {
        if (totalFood < totalDistance) {
            System.out.println("NO");
        } else {
            List<Integer> keys = new ArrayList<>(map.keySet());

            for (int key : map.keySet()) {
                if (map.get(key) == mostFood) {
                    int index = keys.indexOf(key);
                    System.out.println(index + 1);
                    break;
                }
            }
        }
    }
}