package com.itmo.jjd.Lesson12.HomeWork1;

import java.io.FileNotFoundException;
import java.nio.file.AccessDeniedException;
import java.util.jar.JarException;

public class ExampleException {
    static void throwException(Status status) throws JarException, FileNotFoundException, AccessDeniedException{
        if (status.name().equals("FILE_NOT_FOUND")){
            throw new FileNotFoundException();
        }
        else if(status.name().equals("ACCESS_DENIED")){
            throw new AccessDeniedException("Доступ запрещен!!!");
        }
        else if (status.name().equals("JAR_ERROR")){
            throw new JarException();
        }
    }
}
