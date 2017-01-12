package com.huaDevelopers.controllers.Rest;

import java.util.HashMap;
import java.util.Map;

public final class JsonObjectWrapper {
    private JsonObjectWrapper() {}

    public static <E> Map<String, E> withLabel(String label, E wrappedObject) {
        HashMap<String, E> map = new HashMap<String, E>();
        map.put(label, wrappedObject);
        return map;
    }
}
