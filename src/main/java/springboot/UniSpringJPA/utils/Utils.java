package springboot.UniSpringJPA.utils;

import java.util.ArrayList;
import java.util.List;

public class Utils {

    public static List<Integer> getIntListFromString(List<String> stringList) {
        List<Integer> intlist = new ArrayList<>();
        for (String str : stringList) {
            intlist.add(Integer.parseInt(str));
        }
        return intlist;
    }
}
