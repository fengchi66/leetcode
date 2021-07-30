package code.class02;

import java.util.Stack;

/**
 * 实现一个特殊的栈，在基本功能的基础上，再实现返回栈中最小元素的功能
 * 1. pop、push、getMin操作的复杂度都是O(1)
 * 2. 设计栈的类型可以使用现成的栈结构
 */
public class Code05_GetMinStack {

    /**
     * 使用两个栈：一个数据站和一个最小栈，数据栈记录压入的数据，最小栈栈顶始终记录最小值，两个栈同步压入、同步弹出
     */
    public class MyStack {

        private Stack<Integer> dataStack;
        private Stack<Integer> minStack;

        public MyStack() {
            this.dataStack = new Stack<Integer>();
            this.minStack = new Stack<Integer>();
        }

        // 入栈
        public void push(int newNum) {
            if (minStack.isEmpty() || newNum < getMin()) // 最小栈为空或者当前值小于最小栈中最小值
                minStack.push(newNum);
            else // 当前>=最小栈中最小值,将当前最小栈的栈顶再次压入
                minStack.push(minStack.peek());
        }

        // 出栈
        public int pop() {
            // 最小栈和数据栈同步pop
            if (dataStack.isEmpty())
                throw new RuntimeException("");
            minStack.pop();
            return dataStack.pop();
        }

        // 获取最小值
        public int getMin() {
            if (this.minStack.isEmpty())
                throw new RuntimeException("");
            return this.minStack.peek();
        }
    }

}
