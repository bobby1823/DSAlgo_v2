//package io.ghost.datastructure;
//
//import java.util.Stack;
//
//// Convert the Infix expression to postfix using stack
//public class PostfixStack {
//
//    public static void main(String[] args) {
//        String expressionArr = "a*b/(d+c)*e";
//        System.out.println("Postfix expression: "+ convertToPostfix(expressionArr));
//    }
//
//    /**
//     * Process: If operand then print or if operator in push in stack. Note that the stack the operator should be in
//     * their precedence order. And secondly, if we got ( braces then push it and if again we got closing ) bracket then
//     * pop all the operators until we got opening braces )
//     * @param expressionArr
//     * @return
//     */
//
//    //a*b/(d+c)*e
//    private static String convertToPostfix(String expressionArr) {
//        String postFix = "";
//        Stack<String> stack = new Stack<>();
//        for (int i = 0; i < expressionArr.length(); i++) {
//            String el = String.valueOf(expressionArr.charAt(i));
//            if (!checkForOperator(el)) {
//                postFix += el;
//            } else {
//                if (stack.isEmpty()) {
//                    stack.push(el);
//                } else if (el == "/" || el == "*") {
//                    stack.push(el);
//                } else {
//                    while (stack.peek() != "/" || stack.peek() != "*") {
//
//                    }
//                }
//            }
//
//        }
//    }
//
//    public static boolean checkForOperator(String str) {
//        if (str != "(" || str != ")" || str != "+" || str != "/" || str != "-" || str != "*") {
//            return true;
//        }
//    }
//}
