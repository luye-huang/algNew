import org.junit.Test;

public class lc1962RemoveStonestoMinimizetheTotal {
    public int minStoneSum(int[] piles, int k) {
        int sum = 0;
        for (int i = 0; i < piles.length; i++) {
            sum += piles[i];
            shiftUp(piles, i);
        }
        while (k > 0) {
            sum -= piles[0] / 2;
            piles[0] = piles[0] - piles[0] / 2;
            shiftDown(piles, 0);
            k--;
        }
        return sum;
    }

    private void shiftUp(int[] heap, int idx) {
        int parent = (idx - 1) / 2;
        while (parent >= 0 && heap[idx] > heap[parent]) {
            int tmp = heap[idx];
            heap[idx] = heap[parent];
            heap[parent] = tmp;
            idx = parent;
            parent = (parent - 1) / 2;
        }
    }

    private void shiftDown(int[] heap, int idx) {
        int maxChild = idx * 2 + 1;
        if (maxChild < heap.length - 1 && heap[maxChild] < heap[maxChild + 1]) {
            maxChild++;
        }
        while (maxChild < heap.length && heap[idx] < heap[maxChild]) {
            int tmp = heap[idx];
            heap[idx] = heap[maxChild];
            heap[maxChild] = tmp;
            idx = maxChild;
            maxChild = maxChild * 2 + 1;
            if (maxChild < heap.length - 1 && heap[maxChild] < heap[maxChild + 1]) {
                maxChild++;
            }
        }
    }

    @Test
    public void test() {
        System.out.println(minStoneSum(new int[]{4, 3, 6, 7}, 3));
        System.out.println(minStoneSum(new int[]{5, 4, 9}, 2));
        //[140,7118,7899,4157,8413,9275,2844,7653,3359,1194,5739,50,7954,8736,1073,9693,7947,5487,7526,4374,8240,7542,452,1308,5696,2846,6628,4183,2210,887,2664,8184,6254,7613,4831,2554,171,4632,9133,7658,30,6005,558,8815,6265,9246,7255,3350,5054,8164,2186,7927,8824,4960,1257,4227,5130,4984,5468,5115,6439,8489,1523,8331,3451,6409,9769,8692,2451,8269,1461,5048,672,3817,7497,9197,3803,8563,4547,1004,1834,1835,6214,5974,3502,5217,5835,1268]
        //92
        System.out.println(minStoneSum(new int[]{140, 7118, 7899, 4157, 8413, 9275, 2844, 7653, 3359, 1194, 5739, 50, 7954, 8736, 1073, 9693, 7947, 5487, 7526, 4374, 8240, 7542, 452, 1308, 5696, 2846, 6628, 4183, 2210, 887, 2664, 8184, 6254, 7613, 4831, 2554, 171, 4632, 9133, 7658, 30, 6005, 558, 8815, 6265, 9246, 7255, 3350, 5054, 8164, 2186, 7927, 8824, 4960, 1257, 4227, 5130, 4984, 5468, 5115, 6439, 8489, 1523, 8331, 3451, 6409, 9769, 8692, 2451, 8269, 1461, 5048, 672, 3817, 7497, 9197, 3803, 8563, 4547, 1004, 1834, 1835, 6214, 5974, 3502, 5217, 5835, 1268}, 92));
        System.out.println(minStoneSum(new int[]{10000}, 10000));
    }
}
