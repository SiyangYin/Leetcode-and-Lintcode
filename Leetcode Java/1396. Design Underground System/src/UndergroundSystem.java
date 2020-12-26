import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class UndergroundSystem {
    
    class Route {
        String start, end;
    
        public Route(String start, String end) {
            if (start.compareTo(end) <= 0) {
                this.start = start;
                this.end = end;
            } else {
                this.start = end;
                this.end = start;
            }
        }
    
        @Override
        public boolean equals(Object o) {
            Route route = (Route) o;
            return start.equals(route.start) && end.equals(route.end);
        }
    
        @Override
        public int hashCode() {
            return Objects.hash(start, end);
        }
    }
    
    class RouteInfo {
        int count;
        double totalTime;
    
        public RouteInfo(int count, double totalTime) {
            this.count = count;
            this.totalTime = totalTime;
        }
    }
    
    class CheckinInfo {
        String station;
        int time;
    
        public CheckinInfo(String station, int time) {
            this.station = station;
            this.time = time;
        }
    }
    
    private Map<Route, RouteInfo> routeInfoMap;
    private Map<Integer, CheckinInfo> idToStationAndTime;
    
    public UndergroundSystem() {
        routeInfoMap = new HashMap<>();
        idToStationAndTime = new HashMap<>();
    }
    
    public void checkIn(int id, String stationName, int t) {
        idToStationAndTime.put(id, new CheckinInfo(stationName, t));
    }
    
    public void checkOut(int id, String stationName, int t) {
        CheckinInfo checkinInfo = idToStationAndTime.get(id);
        Route route = new Route(checkinInfo.station, stationName);
        if (!routeInfoMap.containsKey(route)) {
            int timeCost = t - checkinInfo.time;
            routeInfoMap.put(route, new RouteInfo(1, timeCost));
        } else {
            RouteInfo routeInfo = routeInfoMap.get(route);
            routeInfo.count++;
            routeInfo.totalTime += t - checkinInfo.time;
            routeInfoMap.put(route, routeInfo);
        }
    }
    
    public double getAverageTime(String startStation, String endStation) {
        Route route = new Route(startStation, endStation);
        RouteInfo routeInfo = routeInfoMap.get(route);
        
        return routeInfo.totalTime / routeInfo.count;
    }
}
