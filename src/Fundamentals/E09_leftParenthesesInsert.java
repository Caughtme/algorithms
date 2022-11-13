package Fundamentals;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.Queue;
import java.util.*;

public class E09_leftParenthesesInsert {
    /**
     * Insert the left parentheses
     * @return the expression with the inserted left parentheses
     */
    public static String leftParenthesesInsert() {
        Queue<String> ops = new Queue<>();
        Queue<String> vals = new Queue<>();
        List<String> exp = new ArrayList<>();
        StringBuilder expr = new StringBuilder();
        while (!StdIn.isEmpty())
        {
            String s = StdIn.readString();
            if (s.equals("+") | s.equals("-") | s.equals("*") | s.equals("/") | s.equals("sqrt"))
            {
                ops.enqueue(s);
            }
            else if (s.equals(")")) {
                exp.add("(");
                exp.add(vals.dequeue());
                exp.add(ops.dequeue());
                exp.add(vals.dequeue());
                exp.add(")");
            }
            else vals.enqueue(s);
        }
        for(String se : exp) {
            expr.append(se);
            expr.append(" ");
        }
        return expr.toString();
    }
    public static void main(String[] args) {
        String s = leftParenthesesInsert();
        System.out.println(s);
    }
}
