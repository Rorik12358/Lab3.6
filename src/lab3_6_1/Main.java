package lab3_6_1;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by m18 on 18.04.2016.
 */
public class Main {
    public static void main(String[] args) {
        Class cls = MyClass.class;
        MyClass myClass = null;
        Constructor[] constructors = cls.getConstructors();
        for (Constructor constructor : constructors) {
            Class[] parametresTypes = constructor.getParameterTypes();
            for (Class parametresType : parametresTypes) {
                System.out.println(parametresType.getTypeName() + " ");
            }
            System.out.println("---------");
        }
        try {
            myClass = (MyClass) constructors[1].newInstance(9, 9, 9, 9);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        System.out.println(myClass);
        System.out.print("Fields: ");
        Field[] fields = cls.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            Class type = field.getType();
            if(type == int.class){
                try {
                    System.out.print(field.getInt(myClass)+" ");
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println();
        System.out.print("methods: ");
        Method[] methods = cls.getDeclaredMethods();
        for (Method method : methods) {
            System.out.print(method.getName()+" ");
        }
        System.out.println();
        System.out.println("getters method: ");
        for (Method method : methods) {
            if(method.getName().substring(0,3).equals("get")){
                try {
                    System.out.println(method.invoke(myClass));
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
