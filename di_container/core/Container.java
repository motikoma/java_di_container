package di_container.core;

import di_container.annotation.Resource;
import di_container.dataaccess.ItemDaoImpl;
import di_container.logic.ItemDao;

import java.io.File;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public class Container {
    public Object getInstance(Class clazz) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, ClassNotFoundException {

        Object obj = clazz.getConstructor().newInstance();

        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {

            Annotation[] annotations = field.getDeclaredAnnotations();
            for (Annotation annotation : annotations) {

                if(annotation instanceof Resource){
                    Class target = this.findImplClass(field.getType());
                    Object instance = this.getInstance(target);

                    field.setAccessible(true);
                    field.set(obj, instance);
                }
            }
        }

        return obj;
    }

    // targetDir下層のクラスのリストを返す
    private static List<File> getClassList(File targetDir) {
        List<File> list = new ArrayList<>();
        File[] files = targetDir.listFiles();
        for (File file : files) {
            if (file.isDirectory()) {
                list.addAll(getClassList(file));
                continue;
            }
            if (file.getName().endsWith(".class")) {
                list.add(file);
            }
        }
        return list;
    }

    // targetとマッチするクラスを返す
    private static Class findImplClass(Class target) throws ClassNotFoundException {
        // 現在実行中のクラスにひもづくクラスのリストを返す
        String classPath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
        File root = new File(classPath);
        List<File> list = getClassList(root);

        // 完全修飾名を取得して、tartetにマッチするクラスを返す
        for (File file : list) {
            String name = file.getAbsolutePath().replace(classPath, "").replace("/", ".").replace(".class", "");

            Class clazz = Class.forName(name);
            if(clazz.isInterface()){
                continue;
            }
            if(target.isAssignableFrom(clazz)){
                return clazz;
            }
        }
        return null;
    }
}
