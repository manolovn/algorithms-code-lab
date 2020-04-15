package dev.manolovn.flattendictionary;

import java.util.HashMap;
import java.util.Map;

public class FlattenDictionary {

    static HashMap<String, String> flattenDictionary(HashMap<String, Object> dict) {
        HashMap<String, String> output = new HashMap<>();
        recursion(output, "", dict);
        return output;
    }

    private static void recursion(HashMap<String, String> o, String initKey, HashMap<String, Object> dict) {
        for (Map.Entry<String, Object> entry : dict.entrySet()) {
            Object value = entry.getValue();
            if (value instanceof String) {
                o.put(buildKey(initKey, entry.getKey()), (String) value);
            } else {
                recursion(o, buildKey(initKey, entry.getKey()), (HashMap<String, Object>) value);
            }
        }
    }

    private static String buildKey(String initKey, String key) {
        if (key.isEmpty()) {
            return initKey;
        }
        return initKey.isEmpty() ? key : initKey + "." + key;
    }
}
