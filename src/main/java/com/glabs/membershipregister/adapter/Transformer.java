package com.glabs.membershipregister.adapter;

public interface Transformer<K,V> {
    V transform(K value);
}
