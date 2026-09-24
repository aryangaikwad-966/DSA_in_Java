import java.util.*;

class Solution {
    public int calculate(String s) {

        Stack<Integer> stack = new Stack<>();

        int num= 0;
        char operation = '+';

        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            if (Character.isDigit(ch)) {

                num = num * 10 + (ch - '0');

            }

            if ((!Character.isDigit(ch) && ch != ' ') || i == s.length() - 1) {

                if (operation == '+') {

            stack.push(num);

                } else if (operation == '-') {

                    stack.push(-num);

                } else {

                    int a = stack.pop();

                    int result;

                    if (operation == '*') {
                        result = a * num;
                    } else {
                        result = a / num;
                    }

                    stack.push(result);
                }

                operation = ch;
                num = 0;
            }
        }

        int result = 0;

        while (!stack.isEmpty()) {
            result += stack.pop();
        }

        return result;
    }
}