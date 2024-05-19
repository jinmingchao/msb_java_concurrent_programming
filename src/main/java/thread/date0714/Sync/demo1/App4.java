package thread.date0714.Sync.demo1;

public class App4 {
    public static void main(String[] args) {
        //TODO Class对象是一个单例
        Class c1 = App4.class;
        Class c2 = App4.class;
        Class c3 = App4.class;
        System.out.println(c1 == c2 && c2 == c3);
    }
}
