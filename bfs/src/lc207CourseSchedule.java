import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.HashSet;

public class lc207CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, HashSet<Integer>> taskToPre = new HashMap<>();
        for (int[] prerequisite : prerequisites) {
            int task = prerequisite[0], pre = prerequisite[1];
            if (taskToPre.containsKey(task)) {
                taskToPre.get(task).add(pre);
            } else {
                HashSet<Integer> set = new HashSet<>();
                set.add(pre);
                taskToPre.put(task, set);
            }
            HashSet<Integer> pres = new HashSet<>();
            pres.addAll(taskToPre.get(task));
            while (!pres.isEmpty()) {
                HashSet<Integer> nextPre = new HashSet<>();
                for (int p : pres) {
                    if (p == task) {
                        return false;
                    }
                    nextPre.addAll(taskToPre.getOrDefault(p, new HashSet<>()));
                }
                pres.clear();
                pres.addAll(nextPre);
            }
        }
        return true;
    }

    @Test
    public void test() {
        System.out.println(canFinish(2, new int[][]{{1, 0}, {0, 1}}));
        System.out.println(canFinish(2, new int[][]{{1, 0}, {5, 5}}));
        System.out.println(canFinish(2, new int[][]{{1, 0}, {0, 2}, {2, 1}}));
    }
}
