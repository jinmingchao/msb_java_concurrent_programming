package concurrent_tool.thread_three_features.threadlocal;

import algorithm.test_20231117.App1.Student;

public class App_1 {
    public static void main(String[] args) {
        ThreadLocal threadLocal = new ThreadLocal<Student>();
        threadLocal.set(new Student());

    }
    static class innerClass{
        static int age;
    }
}

class outerClass {

}
