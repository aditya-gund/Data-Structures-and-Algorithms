import java.util.LinkedList;
import java.util.Queue;

public class MyStack{
    Queue<Integer> queue1;
    Queue<Integer> queue2;
    MyStack(){
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }
    public void push(int x){
            queue1.offer(x);
    }
    public int pop(){
        while (queue1.size()>1) {
            queue2.offer(queue1.poll());
        }
        int topElement = queue1.poll();
        swap(queue1,queue2);
        return topElement;
    }
    public int top(){
        int topElement = queue1.poll();
        queue2.offer(topElement);
        swap(queue1, queue2);
        return topElement;
    }
    public void swap(Queue<Integer> queue1,Queue<Integer> queue2){
        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2=temp;
    }
    public boolean empty(){
        return queue1.isEmpty() && queue2.isEmpty();
    }
    public static void main(String[] args) {
         MyStack myStack = new MyStack();
        myStack.push(1);
        myStack.push(2);
        System.out.println(myStack.top()); 
        System.out.println(myStack.pop()); 
        System.out.println(myStack.empty());
    }
}