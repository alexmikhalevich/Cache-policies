package com.cache;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("LRU cache tests")
class CTest {
    private static ICache _cache;
    private static final int _CACHE_SIZE = 20;
    private static List<EPolicy> _caches_pols;
    private static Iterator<EPolicy> _pols_iter;

    @BeforeAll
    static void init_all() {
        _caches_pols = Arrays.asList(EPolicy.LRU,
                                     EPolicy.MRU,
                                     EPolicy.RR);
        _pols_iter = _caches_pols.iterator();
    }

    @Test
    static void test_cache() {
        _cache.put(100, -_CACHE_SIZE);
        Integer val = (Integer)_cache.get(100);
        assertEquals(val.intValue(), -_CACHE_SIZE);
    }

    @Test
    static void test_caches() {
        if (_pols_iter.hasNext()) {
            EPolicy cur_cache_pol = _pols_iter.next();
            _cache = CCacheFactory.create(_CACHE_SIZE, cur_cache_pol);
            for (int i = 0; i < _CACHE_SIZE; ++i) {
                _cache.put(i, _CACHE_SIZE + i);
            }
            System.out.println("Testing " + cur_cache_pol.toString());
            test_cache();
        }
    }
}
