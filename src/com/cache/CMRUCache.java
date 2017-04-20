package com.cache;

public class CMRUCache extends CAbstractCache {
    public CMRUCache(int cache_size) {
        super(cache_size);
    }

    @Override
    public synchronized void put(Object key, Object val) {
        if (_list.size() == _cache_size) {
            prune();
        }
        _list.addLast(key);
        _map.put(key, val);
    }

    @Override
    public synchronized Object get(Object key) {
        boolean res = _list.remove(key);
        if (res) {
            _list.addLast(key);
            return _map.get(key);
        }
        return null;
    }
}
