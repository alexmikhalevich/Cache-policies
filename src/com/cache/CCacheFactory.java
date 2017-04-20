package com.cache;

public class CCacheFactory {
    public static ICache create(int cache_size, EPolicy policy) {
        if (policy == EPolicy.LRU) {
            return new CLRUCache(cache_size);
        }
        else if (policy == EPolicy.MRU) {
            return new CMRUCache(cache_size);
        }
        else if (policy == EPolicy.RR) {
            return new CRRCache(cache_size);
        }
        else {
            throw new RuntimeException("Invalid policy");
        }
    }
}
