package com.tr.dynamic.datasource.config;

import java.util.Objects;

/**
 * @author taorun
 * @date 2022/12/16 16:51
 */
public class DataSourceContextHolder {
    private static final ThreadLocal<String> holder = new ThreadLocal<>();

    public static String defaultDbKey = "db1"; // 初始化的时候默认使用 db1

    public static void setDataSource(String type) {
        holder.set(type);
    }

    public static String getDataSource() {
        String dbKey = holder.get();
        if (Objects.nonNull(dbKey)) {
            defaultDbKey = dbKey;
        }
        return defaultDbKey;
    }

    public static void clear() {
        holder.remove();
    }
}
