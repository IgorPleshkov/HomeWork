package com.itmo.jjd.Lesson12.HomeWork2;

import java.io.File;
import java.io.FileReader;

public class StartProgram {
    public static void someMethod() {
        RuntimeException[] exceptions = new RuntimeException[9];
        //----------------
        try {
            int a = 10 / 0;
        } catch (RuntimeException e) {
            exceptions[0] = e;
        }
        //----------------
        try {
            int[] arr = new int[5];
            arr[6] = 11;
        } catch (RuntimeException e) {
            exceptions[1] = e;
        }
        //----------------
        try {
            Object data = "str";
            data = (Integer) data;
        } catch (RuntimeException e) {
            exceptions[2] = e;
        }
        //----------------
        try {
            String a = null;
            a.charAt(0);
        } catch (RuntimeException e) {
            exceptions[3] = e;
        }
        //----------------
        try {
            String a = "abc";
            char b = a.charAt(5);
        } catch (RuntimeException e) {
            exceptions[4] = e;
        }
        //----------------
        try {
            String a = "abc";
            int b = Integer.parseInt(a);
        } catch (RuntimeException e) {
            exceptions[5] = e;
        }
        //----------------
        //----------------
        //----------------
        //----------------

        for (Exception e : exceptions) {
            if (!(e == null))
                System.out.println(e.getMessage());
        }
    }

}
