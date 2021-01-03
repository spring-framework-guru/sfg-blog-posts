package com.springframework.guru.javalistoperations;

import java.util.Iterator;
import java.util.LinkedList;

public class LinkedListDemo {

        public LinkedListDemo() {
        }

        public static void main(String[] args) {
            LinkedList<String> laptop = new LinkedList();
            laptop.add("HP");
            laptop.add("Lenovo");
            System.out.println(laptop);
            laptop.addFirst("Apple");
            System.out.println(laptop);
            laptop.addLast("Compaq");
            System.out.println(laptop);
            laptop.set(3, "Dell");
            System.out.println(laptop);
            Iterator iterator = laptop.iterator();

            while(iterator.hasNext()) {
                System.out.print((String)iterator.next());
            }

        }
    }


