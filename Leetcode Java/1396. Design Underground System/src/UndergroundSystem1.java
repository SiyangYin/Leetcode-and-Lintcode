import java.util.*;

public class UndergroundSystem1 {
    Map<Integer, List> map1;
    Map<String, double[]> map2;
    public UndergroundSystem1() {
        map1 = new HashMap<>();
        map2 = new HashMap<>();
    }

    public void checkIn(int id, String stationName, int t) {
        map1.put(id, Arrays.asList(stationName, t));
    }

    public void checkOut(int id, String stationName, int t) {
        List list = map1.get(id);
        String key = (String)list.get(0) + "-" + stationName;
        double[] arr = map2.getOrDefault(key, new double[2]);
        arr[0]++;
        arr[1] += t - (int)list.get(1);
        map2.putIfAbsent(key, arr);
    }

    public double getAverageTime(String startStation, String endStation) {
        double[] arr = map2.get(startStation + "-" + endStation);
        return arr[1] / arr[0];
    }

    public static void main(String[] args) {
        UndergroundSystem1 undergroundSystem1 = new UndergroundSystem1();
        undergroundSystem1.checkIn(45,"Leyton",3);
        undergroundSystem1.checkIn(32,"Paradise",8);
        undergroundSystem1.checkIn(27,"Leyton",10);
        undergroundSystem1.checkOut(45,"Waterloo",15);
        undergroundSystem1.checkOut(27,"Waterloo",20);
        undergroundSystem1.checkOut(32,"Cambridge",22);
        System.out.println(undergroundSystem1.getAverageTime("Paradise","Cambridge"));
        System.out.println(undergroundSystem1.getAverageTime("Leyton","Waterloo"));
        undergroundSystem1.checkIn(10,"Leyton",24);
        System.out.println(undergroundSystem1.getAverageTime("Leyton","Waterloo"));
        undergroundSystem1.checkOut(10,"Waterloo",38);
        System.out.println(undergroundSystem1.getAverageTime("Leyton","Waterloo"));
    }
}
