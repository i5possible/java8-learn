package lambda;

import java.util.*;

public class ProductComparator {
    public static void main(String[] args) throws InterruptedException {
        List<Map<String, Object>> list = new ArrayList<>();
        list.add(createMap("yhd", 27, Boolean.TRUE));
        list.add(createMap("yym", 29, Boolean.FALSE));
        list.add(createMap("xmw", 27, Boolean.TRUE));
        list.add(createMap("rrr", 26, Boolean.TRUE));

        printList(list);
        //Boolean.TURE靠前
        list.sort(genderComparator());
        printList(list);
        list.sort(nameComparator());
        printList(list);
        list.sort(ageComparator());
        printList(list);
        //Boolean.FALSE 最靠前, 按数字正序，按名称正，
        list.sort(genderComparator()
                .thenComparing(ageComparator())
                .thenComparing(nameComparator()));
        printList(list);


        Thread.sleep(2000);
    }

    private static Comparator<Map<String, Object>> ageComparator() {
        return (mapA, mapB) -> {
            Integer aAge = (Integer) mapA.get("age");
            Integer bAge = (Integer) mapB.get("age");
            return aAge.compareTo(bAge);
        };
    }

    private static Comparator<Map<String, Object>> nameComparator() {
        return (mapA, mapB) -> {
            String aName = mapA.get("name").toString();
            String bName = mapB.get("name").toString();
            return aName.compareTo(bName);
        };
    }

    private static Comparator<Map<String, Object>> genderComparator() {
        return (mapA, mapB) -> {
            Boolean aGender = (Boolean) mapA.get("gender");
            Boolean bGender = (Boolean) mapB.get("gender");
            if(aGender && bGender) {
                return 0;
            } else if (aGender && !bGender) {
                return 1;
            } else if (!aGender && bGender) {
                return -1;
            } else {
                return 0;
            }
        };
    }

    private static void printList(List<Map<String, Object>> list) {
        list.forEach( item -> {
            System.out.println(item.get("name"));
        });
        System.out.println();
    }

    public static Map<String, Object> createMap(String name, Integer age, Boolean gender) {
        Map<String, Object> map = new HashMap<>(4);
        map.put("name", name);
        map.put("age", age);
        map.put("gender", gender);
        return map;
    }
}
