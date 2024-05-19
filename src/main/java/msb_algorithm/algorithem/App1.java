package msb_algorithm.algorithem;

/***
 *
 * 将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
 *
 * 比如输入字符串为 "PAYPALISHIRING" 行数为 3 时，排列如下：
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 *
 * P Y A I H R N
 * A P L S I I G
 *
 *
 * P     I     N
 * A   L S   I G
 * Y A   H R
 * P     I
 *
 *
 * P       H
 * A     S I
 * Y   I   R
 * P L     I G
 * A       N
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。
 *   1   0，1，2，3，4，5
 *   2   0,2,4,6,8
 *   3   0,4,8,12
 *   4   0,6,12
 *   5   0,8
 *   N   0 2 x (N - 1)
 * 请你实现这个将字符串进行指定行数变换的函数：
 *
 * string convert(string s, int numRows);
 *
 *
 */
public class App1 {

    public static void main(String[] args) {
//        convert("A",1);
        // convert("PAYPALISHIRING",3); // "PAAHHNNAPLSIIGYYIIRR"
        //   convert("PAYPALISHIRING",4); // "PINALSIGYIHNPI" / "PINALSIGYAHRPI"
        boolean res1 = true, res11 = true, res111 = true, res1111 = true;
        boolean res2 = false;
        boolean res3 = true;
        res1 |= res2;     // true
        res11 &= res2;    // false
        res111 ^= res2;   // true
        res1111 ^= res3;  // false
        System.out.println( "res1:" +res1);
        System.out.println( "res11:" +res11);
        System.out.println( "res111:" +res111);
        System.out.println( "res1111:" +res1111);
    }

    public static String convert(String s, int numRows) {
        if (numRows == 1) return s;
        StringBuilder res = new StringBuilder();
        int length = s.length(), start;
        boolean isDown = true;

        for (int i = 0; i < numRows; i++) {

            start = i;
            if (i == numRows - 1) isDown = false;
            else isDown = true;

            while (start < length) {
                res.append(s.charAt(start));
                if (isDown) {
                    start += 2 * (numRows - 1 - i);
                } else {
                    start += 2 * i;
                }

                if (i == 0) isDown = true;
                else if (i == numRows - 1) isDown = false;
                else isDown = !isDown;
            }
        }
        return res.toString();
    }
}
