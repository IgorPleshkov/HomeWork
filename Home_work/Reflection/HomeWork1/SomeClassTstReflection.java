package Home_work.Reflection.HomeWork1;

import com.itmo.jjd.Lesson17.Config;
import com.itmo.jjd.Lesson17.Required;

public class SomeClassTstReflection {
    private int someInt;
    private String someString;
    private String[] someArrayString;

    public SomeClassTstReflection(int someInt, String someString, String[] someArrayString) {
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
}
