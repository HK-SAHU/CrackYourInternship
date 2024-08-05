class MyStack {
    
    public Queue<Integer> q1;
    public Queue<Integer> q2;

    public MyStack() {
        q1= new LinkedList<>();
        q2= new LinkedList<>();
    }
    
    public void push(int x) {
        q2.add(x);
        
        // push all the elements of q1 to q2
        while(!q1.isEmpty()){
            q2.add(q1.poll());
        }
        
        // swap the names of the q1 and q2
        Queue<Integer> temp = q1;
        q1= q2;
        q2= temp;
    }
    
    public int pop() {
        if(q1.isEmpty()){
            return 0;
        }
        return q1.poll();
    }
    
    public int top() {
        if(q1.isEmpty()){
            return 0;
        }
        return q1.peek();
    }
    
    public boolean empty() {
        return q1.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */