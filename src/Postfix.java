import java.util.Scanner;

public class Postfix {
	Stack postfixStack = new StackAsList();

	public Postfix() {
	}

	public static void main(String[] args) throws IncorrectString {
		Postfix postfix = new Postfix();
		try {
			
			postfix.inputInfixString();
		} catch (StackUnderflow e) { // TODO Auto-generated catch block e.printStackTrace();
			
		}
	}

	public int evaluate(String pfx) throws StackUnderflow, IncorrectString {
		if (pfx.isEmpty()) {
			throw new IncorrectString();
		}
		int postfix = 0;
		for (int i = 0; i <= pfx.length() - 1; i++) {
			char current = pfx.charAt(i);
			if (Character.isDigit(current)) {
				postfixStack.push(Integer.parseInt(String.valueOf(current)));
			} else {
				int right = (Integer) (postfixStack.top());
				postfixStack.pop();
				int left = (Integer) (postfixStack.top());
				postfixStack.pop();
				if (current == '+') {
					postfix = left + right;
				} else if (current == '-') {
					postfix = left - right;
				} else if (current == '*') {
					postfix = left * right;
				} else if (current == '/') {
					postfix = left / right;
				} else if (current == '^') {
					postfix = (int) Math.pow(left, right);
				} else {
					System.out.println("An unexpected operator occured");
				}
				postfixStack.push(postfix);
			}
		}
		return (int) postfixStack.top();
	}

	public String infixToPostfix(String ifx) throws StackUnderflow, IncorrectString {
		if (!correctString(ifx)) {
			throw new IncorrectString();
		}
		String postfixString = "";
		Stack pfxStack = new StackAsList();
		for (int i = 0; i <= ifx.length() - 1; i++) {
			char current = ifx.charAt(i);
			if (Character.isDigit(current)) {
				postfixString += current;
			} else {
				if (pfxStack.isEmpty()) {
					pfxStack.push(current);
				} else {
					if (hierarchy(current, (Character) pfxStack.top())) {
						pfxStack.push(current);
					} else if (current != ')') {
						while (!pfxStack.isEmpty() && !hierarchy(current, (Character) pfxStack.top())) {
							postfixString += pfxStack.top();
							pfxStack.pop();
						}
						pfxStack.push(current);
					} else {
						while ((Character) pfxStack.top() != '(') {
							postfixString += pfxStack.top();
							pfxStack.pop();
						}
						if ((Character) pfxStack.top() == '(') {
							pfxStack.pop();
						}
					}
				}
			}
		}
		while (!pfxStack.isEmpty()) {
			postfixString += pfxStack.top();
			pfxStack.pop();
		}
		return postfixString;
	}

	public boolean hierarchy(char operator, char operatorStack) {
		if (operator == operatorStack) {
			return false;
		} else if (operator == '^') {
			return true;
		} else if ((operator == '*' || operator == '/') && (operatorStack == '+' || operatorStack == '-')) {
			return true;
		} else if (((operator == '+' || operator == '-') && (operatorStack == '+' || operatorStack == '-'))
				|| ((operator == '*' || operator == '/') && (operatorStack == '*' || operatorStack == '/'))) {
			return false;
		} else if (operator == '(' || operatorStack == '(') {
			return true;
		}
		return false;
	}

	public boolean correctString(String string) {
		if (!Character.isDigit(string.charAt(0))) {
			if(string.charAt(0) != '(') {
				return false;
			}
		} else if (!Character.isDigit(string.charAt(string.length() - 1))) {
			if(string.charAt(string.length() - 1) != ')') {
				return false;
			}
		}
		for (int i = 0; i <= string.length() - 2; i++) {
			char current = string.charAt(i);
			char next = string.charAt(i + 1);
			if (Character.isDigit(current) && Character.isDigit(next)) {
				return false;
			} else if ((!Character.isDigit(current) && current != '(' && current != ')')
					&& (!Character.isDigit(next) && next != '(' && next != ')')) {
				return false;
			}

		}
		return true;
	}
	
	public void inputInfixString()throws StackUnderflow, IncorrectString{
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter an infix String:");
		String infix = scanner.nextLine();
		System.out.println("Your postfix String looks like this: ");
		String postfix = infixToPostfix(infix);
		System.out.println(postfix);
		System.out.println("The result is: ");
		System.out.println(evaluate(postfix));
	}

}


