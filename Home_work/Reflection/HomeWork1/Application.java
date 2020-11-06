package Home_work.Reflection.HomeWork1;

import java.lang.reflect.Field;
import java.util.Arrays;

/*

    Написать рефлексивный public static String toString(Object o), который принимает на вход объект и выводит информацию по его свойствам в формате: имя свойства - значение свойства

 */

public class Application {
    public static void main(String[] args) {
        String[] arr = {"one", "two", "three"};
        SomeClassTstReflection tstClass = new SomeClassTstReflection(15, "Строка", arr);
        System.out.println(toString(tstClass));
    }

    public static String toString(Object o){
        Class newClass = o.getClass();
        Field[] fields = newClass.getDeclaredFields();
        StringBuilder stringBuilder = new StringBuilder();
        for (Field f : fields){
            f.setAccessible(true);
            try {
                String str = f.get(o) instanceof String[] ? Arrays.toString((String[]) f.get(o)) : f.get(o).toString();
                stringBuilder.append("Имя поля: " + f.getName() + " | Тип: " + f.getType().getSimpleName() + " | Значение поля: " + str + "\n");
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return stringBuilder.toString();
    }
}


