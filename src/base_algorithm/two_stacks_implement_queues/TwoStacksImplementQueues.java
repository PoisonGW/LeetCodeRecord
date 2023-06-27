package base_algorithm.two_stacks_implement_queues;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

/**
 * 两个堆栈实现队列
 *
 * @author Poison
 * @date 2023/06/15
 */
public class TwoStacksImplementQueues {

    Stack<Integer> in = new Stack<>();
    Stack<Integer> out = new Stack<>();


    public TwoStacksImplementQueues() {

    }

    public void appendTail(int value) {
        in.push(value);
    }

    public int deleteHead() {
        // 将in中的逐个弹出到out中
        if (out.isEmpty()) {
            if(in.isEmpty()){
                return -1;
            }
            while (!in.isEmpty()) {
                out.push(in.pop());
            }
        }
        return out.pop();
    }
}
