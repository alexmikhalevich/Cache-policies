package com.cache;

import java.util.HashMap;
import java.util.LinkedList;

public abstract class CAbstractCache implements ICache {
    protected int _cache_size;
    protected HashMap _map;
    protected LinkedList _list;

    public CAbstractCache(int cache_size) {
        _cache_size = cache_size;
        _map = new HashMap(_cache_size);
        _list = new LinkedList();
    }

    public abstract void put(Object key, Object val);

    public abstract Object get(Object key);

    public void invalidate(Object key) {
        _list.remove(key);
        _map.remove(key);
    }

    public void prune() {
        Object key = _list.removeLast();
        _map.remove(key);
    }
}
