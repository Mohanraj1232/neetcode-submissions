class MinStack {
    Stack<int[]> stk;

    public MinStack() {
        stk = new Stack();
    }
    
    public void push(int val) {
        if(stk.isEmpty()) stk.push(new int[] {val ,val});
        else stk.push(new int[] {val ,Math.min(val ,stk.peek()[1])});
    }
    
    public void pop() {
        stk.pop();
    }
    
    public int top() {
        return stk.peek()[0];
    }
    
    public int getMin() {
        return stk.peek()[1];
    }
}
