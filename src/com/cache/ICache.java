package com.cache;

public interface ICache {
    void put(Object key, Object val);
    Object get(Object key);
    void invalidate(Object key);
}
