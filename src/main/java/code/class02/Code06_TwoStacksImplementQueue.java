package code.class02;

import java.util.Stack;

/**
 * 用栈实现队列
 */
public class Code06_TwoStacksImplementQueue {

    /**
     * 使用两个栈，一个push栈，一个pop栈
     * 1. 数据push进push栈，再倒入pop栈中，但要一次性倒完
     * 2. 如果pop栈没有被拿完，不能倒数据
     * 3. 倒数据的行为在任何时候都可以，但要遵循以上两点
     */
    public static class TwoStacksQueue {

        public Stack<Integer> pushStack;
        public Stack<Integer> popStack;

        public TwoStacksQueue() {
            this.pushStack = new Stack<Integer>();
            this.popStack = new Stack<Integer>();
        }

        // push栈向pop栈倒入数据
        public void pushToPop() {
            if (popStack.empty()) { // 当pop栈为空的时候导数据
                while (!pushStack.empty()) { // 一次性倒完
                    pushStack.push(popStack.pop());
                }
            }
        }

        public void add(int newNum) {
            pushStack.push(newNum);
            pushToPop();
        }

        public int poll() {
            return popStack.pop();
        }

        public int peek() {
            pushToPop();
            return popStack.peek();
        }

    }

}
