package com.springframework.guru.javalistoperations;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class ArrayListDemo {

    public static void main(String[] args) {
        ArrayList<String> employee = new ArrayList();
        employee.add("Steve");
        employee.add("Jack");
        employee.add("Mark");
        employee.add("John");
        System.out.println(employee);
        System.out.println(employee.size());
        employee.add(3, "Clark");
        System.out.println(employee);
        employee.set(2, "Mathews");
        System.out.println(employee);
        employee.remove("Steve");
        employee.remove("John");
        System.out.println(employee);
        Collections.sort(employee);
        Iterator var2 = employee.iterator();

        while (var2.hasNext()) {
            String str = (String) var2.next();
            System.out.println(str);
        }

    }
}