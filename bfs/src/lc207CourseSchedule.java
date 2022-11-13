import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class lc207CourseSchedule {
    //两种解法：1 找闭环 2 找可达的点，用degree标识。先找到degree初始可达的点，在用这些走一遍，最后判断可达的点是不是全部
    public boolean canFinish(int n, int[][] prerequisites) {
//        HashMap<Integer, HashSet<Integer>> taskToPre = new HashMap<>();
//        for (int[] prerequisite : prerequisites) {
//            int task = prerequisite[0], pre = prerequisite[1];
//            if (taskToPre.containsKey(task)) {
//                taskToPre.get(task).add(pre);
//            } else {
//                HashSet<Integer> set = new HashSet<>();
//                set.add(pre);
//                taskToPre.put(task, set);
//            }
//            HashSet<Integer> pres = new HashSet<>();
//            pres.addAll(taskToPre.get(task));
//            while (!pres.isEmpty()) {
//                HashSet<Integer> nextPre = new HashSet<>();
//                for (int p : pres) {
//                    if (p == task) {
//                        return false;
//                    }
//                    nextPre.addAll(taskToPre.getOrDefault(p, new HashSet<>()));
//                }
//                pres.clear();
//                pres.addAll(nextPre);
//            }
//        }
//        return true;


        ArrayList<Integer>[] G = new ArrayList[n];
        int[] degree = new int[n];
        ArrayList<Integer> bfs = new ArrayList();
        for (int i = 0; i < n; ++i) G[i] = new ArrayList<Integer>();
        for (int[] e : prerequisites) {
            G[e[1]].add(e[0]);
            degree[e[0]]++;
        }
        for (int i = 0; i < n; ++i) if (degree[i] == 0) bfs.add(i);
        for (int i = 0; i < bfs.size(); ++i)
            for (int j : G[bfs.get(i)])
                if (--degree[j] == 0) bfs.add(j);
        return bfs.size() == n;
    }

    @Test
    public void test() {
//        System.out.println(canFinish(2, new int[][]{{1, 0}, {0, 1}}));
        System.out.println(canFinish(8, new int[][]{{1, 0}, {5, 4},{1, 2}, {6, 7}}));
//        System.out.println(canFinish(3, new int[][]{{1, 0}, {0, 2}, {2, 1}}));
    }
}
