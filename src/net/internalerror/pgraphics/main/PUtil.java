package net.internalerror.pgraphics.main;

public class PUtil {

    public static Object choose(Object[] objects) {
        int len = objects.length;
        int index = (int) (Math.random() * len);
        return objects[index];
    }

    public static Object choose(Object[] objects, Object... excluded) {
        int len = objects.length;
        int index = (int) (Math.random() * len);
        Object result = objects[index];
        for (Object o : excluded) {
            if (result == o) {
                result = choose(objects, excluded);
            }
        }
        return result;
    }

    public static int indexOf(Object[] objects, Object object){
        for (int i = 0; i < objects.length; i++) {
            if (object == objects[i]) return i;
        }
        return -1;
    }

}
