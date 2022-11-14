package Fundamentals.BagsQueuesStacks;

import edu.princeton.cs.algs4.StdIn;

public class E04_Parentheses {
    public static void main(String[] args) {
        int count = 0;
        Stack<String> left = new Stack<>();
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if (item.equals("(") || item.equals("{") || item.equals("[")) {
                left.push(item);
            }
            else if(item.equals(")") || item.equals("}") || item.equals("]")) {
                String leftParentheses = left.pop();
                if(!item.equals(leftParentheses)) { count++; }
            }
        }
        if(count > 0) {
            System.out.println("false");
        }
        else System.out.println("true");
    }
}