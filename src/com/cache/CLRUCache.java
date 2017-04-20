package com.cache;

public class CLRUCache extends CAbstractCache {
    public CLRUCache(int cache_size) {
        super(cache_size);
    }

    public synchronized void put(Object key, Object val) {
        if (_list.size() == _cache_size) {
            prune();
        }
        _list.addFirst(key);
        _map.put(key, val);
    }

    public synchronized Object get(Object key) {
        boolean res = _list.remove(key);
        if (res) {
            _list.addFirst(key);
            return _map.get(key);
        }
        return null;
    }
}
