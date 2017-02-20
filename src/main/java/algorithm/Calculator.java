package algorithm;

import java.util.Stack;

/**
 * The expression string may contain open ( and closing parentheses ), the plus + or minus sign -,
 * non-negative integers and empty spaces .
 *
 * Created by XXH on 2016/7/26.
 */
public class Calculator {

    public static void main(String[] args){
        String s1 = "1 -2 -1";
        System.out.println(new Calculator().calculate_sub(s1));
    }

    // calculate the subexpression with no parentheses
    public int calculate(String s){
        return 0;
    }

    public int calculate_sub(String s) {
        int result = 0;
        StringBuilder num = new StringBuilder();
        char operator = '+';
        char array[] = s.toCharArray();

        for (int i = 0; i < array.length; i++){
            if (array[i] == ' ') continue;
            if (array[i] != '+' && array[i] != '-'){
                num.append(array[i]);
                continue;
            }

            result = getResult(result, Integer.parseInt(num.toString()), operator);
            operator = array[i];
            num.delete(0, num.length());
        }

        result = getResult(result, Integer.parseInt(num.toString()), operator);
        return result;
    }

    public int getResult(int num1, int num2, char operator){
        int result = 0;
        switch (operator){
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
        }
        return result;
    }

    public String getProfixExp(String exp){
        Stack<Character> stack = new Stack<>();
        stack.push('#');
        StringBuilder output = new StringBuilder();

        char[] array = exp.toCharArray();
        char operator;

        for(char c : array){
            if (c >= '0' && c <='9'){
                output.append(c);
            }else if (isOperator(c)){
                if (c == ')'){
                    while ((operator = stack.pop()) != '(' ){
                        output.append(operator);
                    }
                }else {
                    while (getInsidePriority(stack.peek()) > getOutsidePriority(c)) {
                        operator = stack.pop();
                        output.append(operator);
                    }
                    stack.push(c);
                }
            }
        }

        while ((operator = stack.pop()) != '#') {
            output.append(operator);
        }

        return output.toString();
    }

    public boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/' || c == '(' || c== ')';
    }

    public int getOutsidePriority(char operator){
        int priority = 0;
        switch (operator){
            case '+'  :
                priority = 2;
                break;
            case '-' :
                priority = 2;
                break;
            case '*' :
                priority = 4;
                break;
            case '/' :
                priority = 4;
                break;
            case '#' :
                priority = -1;
                break;
            case '(' :
                priority = 6;
                break;
        }

        return priority;
    }

    public int getInsidePriority(char operator){
        int priority = 0;
        switch (operator){
            case '+'  :
                priority = 3;
                break;
            case '-' :
                priority = 3;
                break;
            case '*' :
                priority = 5;
                break;
            case '/' :
                priority = 5;
                break;
            case '#' :
                priority = -1;
                break;
            case '(' :
                priority = 0;
                break;
        }

        return priority;
    }

}
