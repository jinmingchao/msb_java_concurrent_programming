package msb_algorithm.algorithem;

import java.util.Deque;
import java.util.LinkedList;

/**
 *
 * 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
 *
 * 实现 MinStack 类:
 *
 * MinStack() 初始化堆栈对象。
 * void push(int val) 将元素val推入堆栈。
 * void pop() 删除堆栈顶部的元素。
 * int top() 获取堆栈顶部的元素。
 * int getMin() 获取堆栈中的最小元素。
 *
 * -231 <= val <= 231 - 1
 * pop、top 和 getMin 操作总是在 非空栈 上调用
 * push, pop, top, and getMin最多被调用 3 * 104 次
 *
 *
 */
public class App_20240212 {
    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
    }
}

class MinStack {

    Deque<Integer> stack, assistStack;

    public MinStack() {
        stack = new LinkedList<>();
        assistStack = new LinkedList<>();
    }

    public void push (int val) {
        stack.push(val);
        int minVal;
        if (!assistStack.isEmpty()) {
            minVal = assistStack.peek() > val ? val : assistStack.peek();
        } else {
            minVal = val;
        }

        assistStack.push(minVal);
    }

    public void pop() {
      stack.pop();
      assistStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return assistStack.peek();
    }
}
