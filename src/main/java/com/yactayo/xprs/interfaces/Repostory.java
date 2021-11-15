package com.yactayo.xprs.interfaces;

import java.util.List;

public interface Repostory<T> {

    List<T> list();

    T byId(int id);

    void save(T t);

    void delete(int id);
}
