package io.ghost.datastructure;

import java.util.Arrays;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

public class Hashing_ConsistentHashing_Algo {

    private static Hashtable<Integer, LinkedList<String>> hashtableStore;

    public static void main(String[] args) {
        List<String> values = Arrays.asList("Cat", "dog", "mouse", "kitten");
        storeInHashStore(values, 3);
        System.out.println("Done");
    }

    public static void storeInHashStore(List<String> values, int bucket) {
        hashtableStore = new Hashtable<>(bucket);
        values.stream().forEach(v -> {
            int hashKey = hashingFunction(v);
            int bucketKey = hashKey % bucket;
            // Saving in Hashtable
             if (hashtableStore.containsKey(bucketKey)) {
                 LinkedList<String> list = hashtableStore.get(bucketKey);
                 list.add(v);
                 hashtableStore.put(bucketKey, list);
             } else {
                 LinkedList<String> list = new LinkedList<>();
                 list.add(v);
                 hashtableStore.put(bucketKey, list);
             }
        });

    }

    // hashing function. This should be a good hashfunction. As of now we are using default hash of value
    public static int hashingFunction(String value) {
        int id = UUID.randomUUID().hashCode() & Integer.MAX_VALUE;
        return value.hashCode() + id;
    }
}
