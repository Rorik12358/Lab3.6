package lab3_6_3;

import lab3_6_1.MyClass;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by r2-d2 on 22.04.16.
 */
public class Main {
    public static void main(String[] args) throws IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchMethodException {
        Class cls = MyClass.class;
        Constructor[] constructors = cls.getConstructors();
        MyClass myClass = null;
        for (Constructor constructor : constructors) {
            if (constructor.getParameterCount() == 1) {
                myClass = (MyClass) constructor.newInstance(15);
            }
        }
        Method method = cls.getDeclaredMethod("setA", int.class);
        method.invoke(myClass, 33);
        Field[] fields = cls.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            System.out.println("Name: " + field.getName());
            System.out.println("Type: " + field.getType().getName());
            System.out.println("Value: " + field.get(myClass));
            System.out.println();
        }

    }
}
