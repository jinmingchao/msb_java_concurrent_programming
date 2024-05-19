package msb_algorithm.test_20231117.App1;

public class App {

    public static void main(String[] args) {
        //1.
//        People p = new People();
//        Student s = new Student();
//        Teacher t = new Teacher();
//        test(s);
//        test(t);
        //2. user replace() instead of using replaceAll();

        String s = "I,m Bob, My father's name is Bob, And my grandfather's name is also Bob.";
        while(s.indexOf("Bob") > -1) {
           s =  s.replace("Bob","Alice");
        }
        System.out.println(s);

    }

    private static void test(People p) {
        Class<? extends People> clazz =p.getClass();
        People p1 = clazz.cast(p);
        System.out.println(p1.getClass().getName());
        String packageName = p1.getClass().getName();
        System.out.println(packageName.substring(packageName.lastIndexOf(".") + 1));
        System.out.println(p1.getName());

    }


}
