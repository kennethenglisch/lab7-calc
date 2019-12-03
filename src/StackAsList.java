
public class StackAsList implements Stack {

	Node head;

	public StackAsList() {
		head = null;
	}
	
	public static void main(String[] args) throws StackUnderflow{
		Stack stack = new StackAsList();
		stack.push(5);
		stack.push(6);
		System.out.println(stack.toString());
	}
	
	@Override
	public void push(Object data) {
		Node pushedNode;
		if (head == null) {
			pushedNode = new Node(data, null);
		} else {
			pushedNode = new Node(data, head);

		}
		head = pushedNode;

	}
	

	@Override
	public void pop() throws StackUnderflow {
		Node poppedNode;
		if (head == null) {
			throw new StackUnderflow();
		} else {
			poppedNode = head;
			head = poppedNode.next;
		}
	}
	
	@Override
	public Object top() throws StackUnderflow{
		if(head != null) {
		return head.data;
		}
		else {
			throw new StackUnderflow();
		}
		
	}

	@Override
	public boolean isEmpty() {
		return (head == null);
	}

	@Override
	public String toString() {
		String stackString = "";
		stackString += "[";
		for (Node first = head; first != null; first = first.next) {
			stackString += first.data;

			if (first.next != null)
				stackString += ", ";
		}
		stackString += "]";

		return stackString;
	}
}