package march.week3;

import java.util.HashMap;
import java.util.Map;

public class Day6_DesignUndergroundSystem {
    private static final String DELIMETER = ",";
    private Map<Integer, Event> arrivals;
    private Map<String, Average> averages;

    public Day6_DesignUndergroundSystem() {
        arrivals = new HashMap();
        averages = new HashMap();
    }

    public void checkIn(int id, String stationName, int t) {
        arrivals.put(id, new Event(id, stationName, t));
    }

    public void checkOut(int id, String stationName, int t) {
        Event arrival = arrivals.remove(id);
        int diff = t - arrival.time;

        String key = arrival.stationName + DELIMETER + stationName;
        Average average = averages.containsKey(key) ? averages.get(key) : new Average();
        average.updateAverage(diff);

        averages.put(key, average);
    }

    public double getAverageTime(String startStation, String endStation) {
        String key = startStation + DELIMETER + endStation;
        return averages.get(key).getAverage();
    }

    private static class Event {
        int id;
        String stationName;
        int time;
        Event(int id, String stationName, int t) {
            this.id = id;
            this.stationName = stationName;
            this.time = t;
        }
    }

    private static class Average {
        double total;
        int count;

        Average() {}

        Average(int total, int count) {
            this.total = total;
            this.count = count;
        }

        public void updateAverage(int diff) {
            ++this.count;
            this.total += diff;
        }

        public double getAverage() {
            return total / count;
        }
    }
}
