package stacklist;

public class LLStack {
    class MyNode {
        int data;
        MyNode next;

        public MyNode(int data) {
            this.data=data;
        }
    }
    private MyNode top;
    private int length;

    public LLStack() {
        top=null;
        length=0;
    }

    public int size() {
        return length;
    }
    public boolean isEmpty() {
        if(length ==0) {
            return true;
        }
        else
            return false;
    }
    public void push(int data) {

        MyNode temp = new MyNode(data);
        temp.next = top;
        top= temp;
        length++;

    }
    public int pop() {
        int tempData =0;
        if(isEmpty()) {
            System.out.println("Cannot pop. Stack is empty");
        }
        else {
            tempData = top.data;
            top= top.next;
            length--;
        }
        return tempData;
    }
}
