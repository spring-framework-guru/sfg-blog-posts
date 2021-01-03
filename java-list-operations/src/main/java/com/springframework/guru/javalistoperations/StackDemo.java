package com.springframework.guru.javalistoperations;

import java.util.Stack;

public class StackDemo {
    public static void main(String[] args) {
        Stack product = new Stack();
        product.push("Desktop");
        product.push("Camera");
        product.push("Laptop");
        product.push("Hard Drive");

        System.out.println("The product at the top of the"
                + " stack is: " + product.peek());

        System.out.println("Removed product is : " + product.pop());

        System.out.println("Iterated Stack after removing product is :" );
        product.forEach(n -> { System.out.println(n); });
    }
}
