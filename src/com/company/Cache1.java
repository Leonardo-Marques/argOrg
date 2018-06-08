package com.company;
import java.util.ArrayList;
import java.util.HashMap;

public class Cache1 {
    private HashMap<String, ArrayList> cache = new HashMap<>();
    private int hit;
    private int miss;
    public Cache1() {
    }

    public HashMap<String, ArrayList> getCache() {
        return cache;
    }

    public int getHit() {
        return hit;
    }

    public int getMiss() {
        return miss;
    }

    public void add(String linha, String tag, String pal) {
        ArrayList<String> aux = new ArrayList<>();
        aux.add(tag);
        aux.add(pal);
        if (cache.get(linha) != null){
            if (cache.get(linha).contains(tag))hit++;
            else{
                miss++;
                cache.put(linha, aux);
            }
        }else cache.put(linha, aux);
    }

    @Override
    public String toString() {
        return cache.toString();
    }
}
