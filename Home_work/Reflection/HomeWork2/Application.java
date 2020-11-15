package Home_work.Reflection.HomeWork2;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Application {

    public static void main(String[] args) {
        toString("Home_work.Reflection.HomeWork2.SomeClassTstAnnotation");
    }

    //***************************************************************************************************************

    public static void toString(String nameClass) {
        try {
            Class anyClass = Class.forName(nameClass);
            if (anyClass.isAnnotationPresent(Config.class)) {

                Constructor tmpConstructor = anyClass.getDeclaredConstructor(int.class, String.class, String[].class);
                if (tmpConstructor != null) {
                    tmpConstructor.setAccessible(true);
                    Object obj  = tmpConstructor.newInstance(1, "test", null);

                    Field[] fields = anyClass.getDeclaredFields();
                    for (Field field : fields) {
                        if (field.isAnnotationPresent(Required.class)) {
                            field.setAccessible(true);
                            String nameField = field.getName();
                            nameField = nameField.substring(0, 1).toUpperCase() + nameField.substring(1);
                            Method method = anyClass.getDeclaredMethod("set" + nameField, field.getType());
                            if (method != null){
                                if (field.getType() == int.class){
                                    method.setAccessible(true);
                                    method.invoke(obj, 2);
                                } else if (field.getType() == String.class){
                                    method.setAccessible(true);
                                    method.invoke(obj, "Test Annotations");
                                }
                            }
                        }
                    }
                    Method method = anyClass.getDeclaredMethod("toString");
                    method.setAccessible(true);
                    System.out.println(method.invoke(obj));
                }
            }
        } catch (ClassNotFoundException | NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
