package start;

import javax.swing.*;
import java.lang.reflect.Field;
import java.util.ArrayList;

/**
 * @Author: Diia101
 */
public class ReflectionExample {
    /**
     *
     * @param objects
     * @param object
     * @param <T>
     * @return JTable
     */
    public static <T> JTable retrieveProperties(ArrayList<T> objects, Object object) {

        ArrayList<String> header = new ArrayList<>();
        for (Field field : object.getClass().getDeclaredFields()) {
            field.setAccessible(true); // set modifier to public
            Object value;
            try {
                header.add(field.getName());
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            }

        }
        Object[][] data = new Object[objects.size()][header.size()];
        for(int i=0;i<objects.size();i++)
        {int j=0;
            for (Field field : objects.get(i).getClass().getDeclaredFields()) {
                field.setAccessible(true); // set modifier to public
                Object value;
                try {
                    value=field.get(objects.get(i));
                    data[i][j]=value;
                    j++;
                } catch (IllegalArgumentException | IllegalAccessException e) {
                    e.printStackTrace();
                }

            }
        }

        JTable jTable = new JTable(data,header.toArray());
        return jTable;
    }
}
