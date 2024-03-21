package ch04;

import java.util.Stack;

public class StackArray {
    private int stackSize;
    private int[] stackArray;

    private int top;

    // 생성자
    public StackArray(int stackSize){

        this.stackSize = stackSize;
        this.stackArray = new int[stackSize];
        this.top = -1; // 아무것도 가리키지 않는다.

    }

    public void push(int num){
        if (!isFull()){ // 스택이 가득 차 있지 않다면, push해줄 것
            this.top++;
            stackArray[top] = num;
        }
        else {
            System.out.println("스택이 가득 차 있어, 더이상 값을 push할 수 없습니다.");
        }
    }

    public int pop(){
        if (isEmpty()){
            return (-1); // 값이 없어서 pop 연산을 수행할 수 없다.
        }
        int temp = stackArray[top];
        this.top--;

        return temp;
    }

    public int peek(){
        if (isEmpty()){
            System.out.println("스택이 비어있습니다");
            return -1;
        }

        return stackArray[this.top];
    }

    public boolean isEmpty(){
        if (this.top == -1)
            return true;
        return false;
    }

    public boolean isFull(){
        return (this.top == stackSize -1);
    }

    public static void main(String[] args) {

        int stackSize = 5;
        StackArray stack = new StackArray(stackSize);

        stack.push(1);
        stack.push(3);
        stack.push(5);

        System.out.println("pop : " + stack.pop());
        System.out.println("peek : " + stack.peek());

        if (stack.isEmpty() == true){
            System.out.println("stack은 비어있습니다.");
        }
        else{
            System.out.println("stack은 비어있지 않습니다.");
        }


    }
}
