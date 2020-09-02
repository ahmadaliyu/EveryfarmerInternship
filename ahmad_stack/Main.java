package com.profprof1;

import java.util.Iterator;
import java.util.List;

public class Main {
     public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>(5);
        stack.push(2);
        stack.push(5);
        stack.push(6);

         System.out.println("popped " + stack.pop());
         System.out.println("popped " + stack.pop());
         

//        stack.clear();
//        stack.isEmpty();
//         System.out.println("The stack size is " + stack.size());

     }
}

class Stack<T>{
    int top;
    T[] elements;

    public Stack(int stackSize){
        this.elements = (T[]) new Object[stackSize];      // generic stack array
        this.top = -1;
    }

    public void push(T value){
        elements[++top] = value;     // increment top in elements by one, then set it to be the value
        System.out.println(value);
    }
   public T pop(){
        if(top == -1){
            return null;
        }
        return elements[top--];
    }

    public void clear(){
         top = -1;
    }

    public boolean isEmpty(){
        if(top == -1){
            System.out.println(true);
        }
        return false;
    }

    public int size() {
        return top + 1;
    }
}



