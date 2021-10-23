//Author: Matteo Ginder
//Date: 10/7/2021

import java.util.Stack;
import java.util.Scanner;

public class Hw4Main {
    public static void main(String[] args){
        String infix;
        String postfix;
        Scanner s = new Scanner(System.in);
        
        //Problem 1A
        System.out.println("Enter infix notation equation");
        infix = s.nextLine();
        infix = infix.replaceAll("\\s","");
        
        System.out.println(infixToPostfix(infix));
        System.out.println();
        System.out.println();
        
        //Problem 1B
        System.out.println("Enter postfix notation equation");
        postfix = s.nextLine();
        postfix = postfix.replaceAll("\\s","");
        
        System.out.println(evaluatePostfix(postfix));
        System.out.println();
        System.out.println();
        
        //Problem 2A
        BinaryTree bt = new BinaryTree();
        
        bt = bt.createBinaryTree();
        
        bt.traverseInOrder(bt.root);
        System.out.println();
        System.out.println();
        
        //Problem 2B
        bt.traverseLevelOrder();
        System.out.println();
        System.out.println();
        
        //Problem 3 is in MyStack
    }
    
    static int Prec(char ch){
        switch (ch){
        case '+':
        case '-':
            return 1;
      
        case '*':
        case '/':
            return 2;
      
        case '^':
            return 3;
        }
        return -1;
    }
      
    static String infixToPostfix(String exp){
        String result = new String("");
        Stack<Character> stack = new Stack<>();
         
        for (int i = 0; i<exp.length(); ++i){
            char c = exp.charAt(i);
             
            if (Character.isLetterOrDigit(c))
                result += c;
        
            else if (c == '(')
                stack.push(c);
             
            else if (c == ')'){
                while (!stack.isEmpty() &&
                        stack.peek() != '(')
                    result += stack.pop();
                 
                    stack.pop();
            }
            else{
                while (!stack.isEmpty() && Prec(c) <= Prec(stack.peek())){
                    result += stack.pop();
                }
                stack.push(c);
            }
      
        }
      
        while (!stack.isEmpty()){
            if(stack.peek() == '(')
                return "Invalid Expression";
            result += stack.pop();
         }
        return result;
    }
    
    static int evaluatePostfix(String exp){
        //create a stack
        Stack<Integer> stack=new Stack<>();
         
        // Scan all characters one by one
        for(int i=0;i<exp.length();i++){
            char c=exp.charAt(i);
            
            if(Character.isDigit(c))
            stack.push(c - '0');
            
            else{
                int val1 = stack.pop();
                int val2 = stack.pop();
                 
                switch(c){
                    case '+':
                    stack.push(val2+val1);
                    break;
                     
                    case '-':
                    stack.push(val2- val1);
                    break;
                     
                    case '/':
                    stack.push(val2/val1);
                    break;
                     
                    case '*':
                    stack.push(val2*val1);
                    break;
                }
            }
        }
        return stack.pop();   
    }
}
