package may.week1;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Day2_CourseScheduleIII {
    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses, (a, b) -> a[1] - b[1]);
        // store max duration of course
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        int timeElapsed = 0;
        for (int course[] : courses) {
            if (timeElapsed + course[0] <= course[1]) {
                timeElapsed += course[0];
                pq.offer(course[0]);
            }
            else if (!pq.isEmpty() && pq.peek() > course[0]) {
                timeElapsed = timeElapsed - pq.poll();
                pq.offer(course[0]);
                timeElapsed += course[0];
            }
        }
        return pq.size();
    }
}
