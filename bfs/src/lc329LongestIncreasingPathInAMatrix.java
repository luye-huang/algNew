import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class lc329LongestIncreasingPathInAMatrix {
    int[][] cache;

    public int longestIncreasingPath(int[][] matrix) {
        int height = matrix.length, width = matrix[0].length;
        int ret = 0;
        cache = new int[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                int cellMaxLength = 1;
                if (cache[i][j] > 0) {
                    cellMaxLength = Math.max(ret, cache[i][j]);
                } else {
                    Queue<LinkedList<int[]>> queue = new LinkedList<>();
                    LinkedList<int[]> linkedList = new LinkedList<>();
                    linkedList.add(new int[]{i, j});
                    queue.offer(linkedList);
                    while (!queue.isEmpty()) {
                        LinkedList<int[]> ele = queue.poll();
                        int[] cur = ele.getLast();
                        int curX = cur[0], curY = cur[1];
                        ArrayList<int[]> neighbors = getNeighbors(curX, curY, height, width, matrix);
                        if (neighbors.size() == 0) {
                            for (int k = 0; k < ele.size(); k++) {
                                int[] spot = ele.get(k);
                                cache[spot[0]][spot[1]] = Math.max(cache[spot[0]][spot[1]], ele.size() - k);
                            }
                            cellMaxLength = Math.max(cellMaxLength, ele.size());
                        } else {
                            for (int[] neighbor : neighbors) {
                                int neighborX = neighbor[0];
                                int neighborY = neighbor[1];
                                if (cache[neighborX][neighborY] > 0) {
                                    for (int k = 0; k < ele.size(); k++) {
                                        int[] spot = ele.get(k);
                                        cache[spot[0]][spot[1]] = Math.max(cache[spot[0]][spot[1]], ele.size() - k + cache[neighborX][neighborY]);
                                    }
                                    cellMaxLength = Math.max(cellMaxLength, cache[neighborX][neighborY] + ele.size());
                                } else {
                                    LinkedList<int[]> subList = new LinkedList<>();
                                    Collections.addAll(subList, new int[ele.size()][ele.size()]);
                                    Collections.copy(subList, ele);
                                    subList.add(new int[]{neighborX, neighborY});
                                    queue.offer(subList);
                                }
                            }
                        }

                    }
                }
//                cache[i][j] = cellMaxLength;
                ret = Math.max(ret, cellMaxLength);
            }
        }
        return ret;
    }

    private ArrayList<int[]> getNeighbors(int x, int y, int height, int width, int[][] matrix) {
        ArrayList<int[]> arrayList = new ArrayList<>();
        if (x - 1 >= 0 && matrix[x][y] > matrix[x - 1][y]) {
            arrayList.add(new int[]{x - 1, y});
        }
        if (x + 1 < height && matrix[x][y] > matrix[x + 1][y]) {
            arrayList.add(new int[]{x + 1, y});
        }
        if (y - 1 >= 0 && matrix[x][y] > matrix[x][y - 1]) {
            arrayList.add(new int[]{x, y - 1});
        }
        if (y + 1 < width && matrix[x][y] > matrix[x][y + 1]) {
            arrayList.add(new int[]{x, y + 1});
        }
        return arrayList;
    }

    @Test
    public void test() {
        System.out.println(longestIncreasingPath(new int[][]{{3, 4, 5}, {3, 2, 6}, {2, 2, 1}}));
        System.out.println(longestIncreasingPath(new int[][]{{9, 9, 4}, {6, 6, 8}, {2, 1, 1}}));
    }
}

