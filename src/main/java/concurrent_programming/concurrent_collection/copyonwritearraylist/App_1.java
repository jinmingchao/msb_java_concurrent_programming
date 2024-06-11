package concurrent_programming.concurrent_collection.copyonwritearraylist;

import java.util.concurrent.CopyOnWriteArrayList;

public class App_1 {
    public static void main(String[] args) {
        CopyOnWriteArrayList<Integer> list = new CopyOnWriteArrayList<>();
        list.get(0);
        list.add(1);
            list.add(0,1);
//        System.arraycopy();


        // break outer 直接跳出外部代码块
        // 所以下面System.out.println("22222"); 不执行
        outer: if(1 == 1) {
            System.out.println("11111");
            int i = 0;
            while (i < 10) {
                i++;
                break outer;
            }
            System.out.println("22222");
    }
    }
}
