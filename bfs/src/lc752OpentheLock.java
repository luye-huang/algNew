import org.testng.annotations.Test;

import java.util.*;

// deadends 一旦碰撞可以永久去掉，不必继续参与循环，因为处理的节点已经被visited记录
// 刚找到邻居节点时就判断是否与终点相等。提前这个判断就不会让它再产生邻居节点
// 字符串截取时， 先转charArray比用substring快, 用string builder和charArray差不多
// 用hashset比用queue遍历快
public class lc752OpentheLock {

    public int openLock(String[] deadends, String target) {
        if (Arrays.stream(deadends).anyMatch(x -> x.equals("0000"))) {
            return -1;
        }
        if (target.equals("0000")) {
            return 0;
        }
        int ret = 0;
//        Queue<String> queue = new LinkedList<>();
        HashSet<String> queue = new HashSet<>();
        HashSet<String> tmp = new HashSet<>();
        HashMap<String, Boolean> visited = new HashMap<>();
        HashMap<String, Boolean> deadEnds = new HashMap<>();
        for (String deadend : deadends) {
            deadEnds.put(deadend, true);
        }

        queue.add("0000");
        visited.put("0000", true);
        while (!queue.isEmpty()) {
            for (String cur : queue) {
                ArrayList<String> list = new ArrayList<>();
                for (int i = 0; i < 4; i++) {
                    char[] arr = cur.toCharArray();
                    char ori = arr[i];
                    arr[i] = ori == '9' ? '0' : (char) (ori + 1);
                    String change = String.valueOf(arr);
//                String change = cur.charAt(i) == '0' ? cur.substring(0, i) + '9' + cur.substring(i + 1) : cur.substring(0, i) + (char) (cur.charAt(i) - 1) + cur.substring(i + 1);
                    if (change.equals(target)) {
                        return ret + 1;
                    }
                    if (!visited.containsKey(change)) {
                        list.add(change);
                        visited.put(change, true);
                    }

                    arr[i] = ori;
                    arr[i] = ori == '0' ? '9' : (char) (ori - 1);
                    change = String.valueOf(arr);
//                change = cur.charAt(i) == '9' ? cur.substring(0, i) + '0' + cur.substring(i + 1) : cur.substring(0, i) + (char) (cur.charAt(i) + 1) + cur.substring(i + 1);
                    if (change.equals(target)) {
                        return ret + 1;
                    }
                    if (!visited.containsKey(change)) {
                        list.add(change);
                        visited.put(change, true);
                    }

                }

                for (int j = 0; j < list.size() && !deadEnds.isEmpty(); j++) {
                    if (deadEnds.containsKey(list.get(j))) {
                        deadEnds.remove(list.get(j));
                        list.remove(j--);
                    }
                }
                tmp.addAll(list);
            }

            ++ret;
            queue.clear();
            queue.addAll(tmp);
            tmp.clear();
        }
        return -1;
    }
//    public int openLock(String[] deadends, String target) {
//        if (Arrays.stream(deadends).anyMatch(x -> x.equals("0000"))) {
//            return -1;
//        }
//        if (target.equals("0000")) {
//            return 0;
//        }
//        int ret = 0;
//        Queue<String> queue = new LinkedList<>();
////        HashSet<String> queue = new HashSet<>();
//        Queue<String> tmp = new LinkedList<>();
//        HashMap<String, Boolean> visited = new HashMap<>();
//        HashMap<String, Boolean> deadEnds = new HashMap<>();
//        for (String deadend : deadends) {
//            deadEnds.put(deadend, true);
//        }
//
//        queue.add("0000");
//        visited.put("0000", true);
//        while (!queue.isEmpty()) {
//            int sz = queue.size();
//            while (sz > 0) {
//                String cur = queue.poll();
//                --sz;
//                ArrayList<String> list = new ArrayList<>();
//                for (int i = 0; i < 4; i++) {
//                    char[] arr = cur.toCharArray();
//                    char ori = arr[i];
//                    arr[i] = ori == '9' ? '0' : (char) (ori + 1);
//                    String change = String.valueOf(arr);
////                String change = cur.charAt(i) == '0' ? cur.substring(0, i) + '9' + cur.substring(i + 1) : cur.substring(0, i) + (char) (cur.charAt(i) - 1) + cur.substring(i + 1);
//                    if (change.equals(target)) {
//                        return ret + 1;
//                    }
//                    if (!visited.containsKey(change)) {
//                        list.add(change);
//                        visited.put(change, true);
//                    }
//
//                    arr[i] = ori;
//                    arr[i] = ori == '0' ? '9' : (char) (ori - 1);
//                    change = String.valueOf(arr);
////                change = cur.charAt(i) == '9' ? cur.substring(0, i) + '0' + cur.substring(i + 1) : cur.substring(0, i) + (char) (cur.charAt(i) + 1) + cur.substring(i + 1);
//                    if (change.equals(target)) {
//                        return ret + 1;
//                    }
//                    if (!visited.containsKey(change)) {
//                        list.add(change);
//                        visited.put(change, true);
//                    }
//
//                }
//
//                for (int j = 0; j < list.size() && !deadEnds.isEmpty(); j++) {
//                    if (deadEnds.containsKey(list.get(j))) {
//                        deadEnds.remove(list.get(j));
//                        list.remove(j--);
//                    }
//                }
//                tmp.addAll(list);
//            }
//
//            ++ret;
////            queue.clear();
//            queue.addAll(tmp);
//            tmp.clear();
//        }
//        return -1;
//    }

    @Test
    public void test() {
        System.out.println(openLock(new String[]{"0201", "0101", "0102", "1212", "2002"}, "0202"));
        System.out.println(openLock(new String[]{"8888"}, "0009"));
        System.out.println(openLock(new String[]{"0000"}, "0009"));
        String str = "12345";
        char[] arr = str.toCharArray();
        System.out.println(Arrays.toString(arr));
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            iterator.next();
            iterator.remove();
//            break;
        }
//        for (int i = 0; i < list.size(); i++) {
//            list.remove(i--);
//        }
        System.out.println("size:" + list.size());
    }
}
