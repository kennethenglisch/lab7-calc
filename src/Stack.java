public interface Stack{
	
	public void push(Object data);
	
	public void pop() throws StackUnderflow;
	
	public Object top() throws StackUnderflow;
	
	public boolean isEmpty();
	
}

