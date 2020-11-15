package Home_work.Reflection.HomeWork2;

import java.util.Arrays;

@Config
public class SomeClassTstAnnotation {
    @Required
    private int someInt;
    @Required
    private String someString;
    private String[] someArrayString;

    public SomeClassTstAnnotation(int someInt, String someString, String[] someArrayString) {
        this.someInt = someInt;
        this.someString = someString;
        this.someArrayString = someArrayString;
    }

    public int getSomeInt() {
        return someInt;
    }

    public void setSomeInt(int someInt) {
        this.someInt = someInt;
    }

    public String getSomeString() {
        return someString;
    }

    public void setSomeString(String someString) {
        this.someString = someString;
    }

    public String[] getSomeArrayString() {
        return someArrayString;
    }

    public void setSomeArrayString(String[] someArrayString) {
        this.someArrayString = someArrayString;
    }

    @Override
    public String toString() {
        return "SomeClassTstAnnotation{" +
                "someInt=" + someInt +
                ", someString='" + someString + '\'' +
                ", someArrayString=" + Arrays.toString(someArrayString) +
                '}';
    }
}