package lab3_6_2;

import java.lang.reflect.Field;


/**
 * Created by r2-d2 on 21.04.16.
 */
public class Main {
    private char value[] = new char[]{'a', 'b', 'c', 'd'};

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        String myStr = "abcd";
        Main main = new Main();
        Class cls = main.getClass();
        Field field = cls.getDeclaredField("value");
        field.setAccessible(true);
        char[] fOld = (char[]) field.get(main);
        System.out.println("Old string value: " + new String(fOld));
        System.out.println(myStr);
        char[] v = {'z', 'x', 'c', 'v'};
        field.set(main, v);
        char[] fNew = (char[]) field.get(main);
        System.out.println("New string value: " + new String(fNew));
    }
}
