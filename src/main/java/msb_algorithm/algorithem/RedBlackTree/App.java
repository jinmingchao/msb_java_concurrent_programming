package msb_algorithm.algorithem.RedBlackTree;

import java.util.HashMap;
import java.util.Map;

public class App {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();

        map.put(1,"XiaoMing");
        map.put(2,"XiaoLi");
        map.put(3,"XiaoQiang");

        map.put(1, "XiaoXiaoMing");
        map.put(1, "XiaoXiaoXiaoMing");
    }
}
