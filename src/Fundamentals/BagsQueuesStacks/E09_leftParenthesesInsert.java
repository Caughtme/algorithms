package Fundamentals.BagsQueuesStacks;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.Stack;

public class E09_leftParenthesesInsert {
    /**
     * Insert the left parentheses
     * @return the expression with the inserted left parentheses
     */
    public static String leftParenthesesInsert() {
        Stack<String> ops = new Stack<>();
        Stack<String> vals = new Stack<>();
        // List<String> exp = new ArrayList<>();
        while (!StdIn.isEmpty())
        {
            String s = StdIn.readString();
            if (s.equals("+") | s.equals("-") | s.equals("*") | s.equals("/") | s.equals("sqrt"))
            {
                ops.push(s);
            }
            else if (s.equals(")")) {
                String val1 = vals.pop();
                String val2 = vals.pop();
                String ops1 = ops.pop();
                vals.push("( " + val2 + " " + ops1 + " " + val1 + " )");
            }
            else vals.push(s);
        }
        return vals.toString();
    }
    public static void main(String[] args) {
        String s = leftParenthesesInsert();
        System.out.println(s);
    }
}
