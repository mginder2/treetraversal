//Author: Matteo Ginder
//Date: 10/7/2021

import java.util.Stack;

public class MyStack {
    Stack<Integer> s;
    Integer min;
 
    public MyStack(){
        s = new Stack<Integer>();
    }
 
    // Prints min element of MyStack
    public void getMin(){
        // Get the smallest number in the entire stack
        if (s.isEmpty())
            System.out.println("Stack is empty");
 
        else
            System.out.println("Minimum Element in the " + " stack is: " + min);
    }
 
    // prints top element of MyStack
    public void peek(){
        if (s.isEmpty()){
            System.out.println("Stack is empty ");
            return;
        }
 
        Integer t = s.peek(); // Top element.
 
        System.out.print("Top Most Element is: ");
        
        if (t < min)
            System.out.println(min);
        else
            System.out.println(t);
    }
 
    // Removes the top element from MyStack
    public void pop(){
        if (s.isEmpty()){
            System.out.println("Stack is empty");
            return;
        }
 
        System.out.print("Top Most Element Removed: ");
        Integer t = s.pop();

        if (t < min){
            System.out.println(min);
            min = 2*min - t;
        }
 
        else
            System.out.println(t);
    }
 
    // Insert new number into MyStack
    public void push(Integer x){
        if (s.isEmpty()){
            min = x;
            s.push(x);
            System.out.println("Number Inserted: " + x);
            return;
        }
 
        // If new number is less than original min
        if (x < min){
            s.push(2*x - min);
            min = x;
        }
 
        else
            s.push(x);
 
        System.out.println("Number Inserted: " + x);
    }
}
