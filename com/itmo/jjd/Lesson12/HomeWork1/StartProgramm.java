package com.itmo.jjd.Lesson12.HomeWork1;

import java.io.FileNotFoundException;
import java.nio.file.AccessDeniedException;
import java.util.jar.JarException;

public class StartProgramm {
    public static void StartP() {
        Status[] statuses = Status.values();
        for (Status s : statuses) {
            try {
                ExampleException.throwException(s);
            } catch (FileNotFoundException e) {
                System.out.println(e.getMessage() + " Что то пошло не так!");
            } catch (AccessDeniedException e) {
                System.out.println(e.getMessage());
                try {
                    throw new AccessDeniedException("Доступ запрещен 2!!!");
                } catch (AccessDeniedException e1){
                    System.out.println(e1.getMessage());
                }
            } catch (JarException e){
                e.printStackTrace();
            }
        }
    }
}
