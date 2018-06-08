package com.company;

import java.util.ArrayList;
import java.util.HashMap;

public class CacheA2 {
    private HashMap<String, Long> mem = new HashMap<>();
    private HashMap<String, String> cache = new HashMap<>();
    private int hit;
    private int miss;

    public int getHit() {
        return hit;
    }

    public int getMiss() {
        return miss;
    }

    public CacheA2() {}

    public HashMap<String, String> getCache() {
        return cache;
    }

    public void add(String tag, String pal) {
        if (mem.containsKey(tag)){
            hit++;
        }else if (mem.size() >= 32){
            long aux = 0;
            String key = null;
            for (String s : mem.keySet()) {
                if (mem.get(s) > aux){
                    aux = mem.get(s);
                    key = s;
                }
            }
            mem.remove(key);
            mem.put(tag, System.nanoTime());
            cache.remove(key);
            cache.put(tag, pal);
            miss++;
        }else{
            mem.put(tag, System.nanoTime());
            miss++;
            cache.put(tag, pal);
        }
    }

}
