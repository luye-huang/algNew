import java.util.HashSet;
import java.util.List;

public class lc841KeysandRooms {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int cntRoom = rooms.size();
        HashSet<Integer> queue = new HashSet<>();
        HashSet<Integer> tmp = new HashSet<>();
        int[] visited = new int[cntRoom + 1];
        visited[0] = 1;
        queue.addAll(rooms.get(0));
        while (!queue.isEmpty() && cntRoom > 1) {
            for (Integer key : queue) {
                if (visited[key] == 0) {
                    visited[key] = 1;
                    --cntRoom;
                    tmp.addAll(rooms.get(key));
                }
            }
            queue.clear();
            queue.addAll(tmp);
            tmp.clear();
        }
        return cntRoom - 1 == 0;
    }
}
