package com.cache;

import java.util.Random;

public class CRRCache extends CAbstractCache {
    private Random _random;

    public CRRCache(int cache_size) {
        super(cache_size);
        _random = new Random(System.currentTimeMillis());
    }

    @Override
    public synchronized void put(Object key, Object val) {
        Object obj = _map.get(key);
        if (obj != null) {
            _map.put(key, val);
            return;
        }

        if (_list.size() >= _cache_size) {
            int rand_index = _random.nextInt(_list.size());
            Object rand_key = _list.get(rand_index);
            _list.remove(rand_index);
            _map.remove(rand_key);
        }
        _list.addLast(key);
        _map.put(key, val);
    }

    @Override
    public Object get(Object key) {
        return _map.get(key);
    }
}
