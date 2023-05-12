import java.util.*;

public class Main {
    public static void main(String[] args) {
        HashMap<Integer, String> hashMap = new HashMap<>();
        hashMap.put(1, "One");
        hashMap.put(2, "Two");
        hashMap.put(3, "Three");

        MyHashSet<Integer> hashSet = new MyHashSet<>();

        System.out.println(hashSet.add(12));
        System.out.println(hashSet.add(12));
        System.out.println(hashSet.remove(12));
        System.out.println(hashSet.remove(12));
    }
}
