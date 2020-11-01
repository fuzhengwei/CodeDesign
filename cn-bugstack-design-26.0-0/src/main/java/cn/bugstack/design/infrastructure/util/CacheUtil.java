package cn.bugstack.design.infrastructure.util;

import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service("cacheUtil")
public class CacheUtil {

    public static Map<Long, Object> cacheMap = new ConcurrentHashMap<>();

}
