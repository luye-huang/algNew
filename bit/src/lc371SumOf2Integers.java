import org.junit.Test;

public class lc371SumOf2Integers {
    public int getSum(int a, int b) {
        if (a == 0) return b;
        if (b == 0) return a;

        while (b != 0) {
            int carry = a & b;
            a = a ^ b;
            b = carry << 1;
        }

        return a;
    }


    public int getSubtract(int a, int b) {
        while (b != 0) {
            int borrow = ~a & b;
            a = a ^ b;
            b = borrow << 1;
        }

        return a;
    }

    @Test
    public void test() {
//        System.out.println(getSum(3, 3));
        System.out.println(getSum(7, 3));
        System.out.println(getSubtract(7, 3));
        // 0111
        // 0011

        // 0011, 0100, 0110
        // 0100, 0010, 1000
        // 0000, 1010, 0000
    }
}
