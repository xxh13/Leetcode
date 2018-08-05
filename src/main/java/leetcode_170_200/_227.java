package leetcode_170_200;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class _227 {


	@Test
	public void test1() {
		String s = "(3 + 23) * 1";
		System.out.println(getSuffix(s));
	}

	@Test
	public void test2() {
		String s = "(1+(4+5+2)-3)+(6+8)";
		System.out.println(calculate(s));
	}

	public int calculate(String s) {
		List<String> suffix = getSuffix(s.replace(" ", ""));
		Stack<Integer> stack = new Stack<>();

		for (String element : suffix) {
			try {
				stack.push(Integer.parseInt(element));
			} catch (Exception e) {
				int right = stack.pop();
				if (stack.empty()) return right;
				int left = stack.pop();
				switch (element) {
					case "+" : stack.push(left + right); break;
					case "-" : stack.push(left - right); break;
					case "*" : stack.push(left * right); break;
					case "/" : stack.push(left / right); break;
					default: break;
				}
			}
		}

		return stack.pop();
	}

	private List<String> getSuffix(String s) {
		Stack<Character> operatorStack = new Stack<>();
		List<String> list = new ArrayList<>();

		char[] chars = s.toCharArray();
		StringBuilder sb = new StringBuilder();
		for (char c : chars) {
			if (c != ' ') {
				if (c >= '0' && c <= '9') {
					sb.append(c);
				} else {
					if (sb.length() > 0) {
						list.add(sb.toString());
						sb.delete(0, sb.length());
					}

					if (operatorStack.empty() || c == '(') {
						operatorStack.push(c);
					} else {
						if (c == ')') {
							while (!operatorStack.empty() && operatorStack.peek() != '(') {
								list.add(operatorStack.pop().toString());
							}
							operatorStack.pop();
						} else {
							while (!operatorStack.empty() && getOrder(operatorStack.peek()) >= getOrder(c)) {
								list.add(operatorStack.pop().toString());
							}
							operatorStack.push(c);
						}
					}
				}
			}
		}

		if (sb.length() != 0) {
			list.add(sb.toString());
		}

		while (!operatorStack.empty()) {
			list.add(operatorStack.pop().toString());
		}

		return list;
	}


	private int getOrder(char c) {
		int order = 0;
		switch (c) {
			case '+': order = 2; break;
			case '-': order = 2; break;
			case '*': order = 5; break;
			case '/': order = 5; break;
			default: order = 0;
		}

		return order;
	}

}
