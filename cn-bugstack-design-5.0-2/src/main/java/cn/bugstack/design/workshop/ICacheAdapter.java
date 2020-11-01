package cn.bugstack.design.workshop;

import java.util.concurrent.TimeUnit;

/**
 * 车间适配器
 */
public interface ICacheAdapter {

    String get(String key);

    void set(String key, String value);

    void set(String key, String value, long timeout, TimeUnit timeUnit);

    void del(String key);

}
