package com.cyk.easy.pay.common.utils;


import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Map;

/**
 * @author yukang.chen
 */
public class DateUtil {

    public enum DatePattern {
        DAY_DATETIME_FORMAT,
        NORM_DATETIME_FORMAT
    }

    private static final DateTimeFormatter DAY_DATETIME_FORMATTER = DateTimeFormatter.ofPattern("yyyyMMdd");
    private static final DateTimeFormatter NORM_DATETIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    private static final Map<DatePattern, DateTimeFormatter> FORMATTER_MAP = Map.of(
            DatePattern.DAY_DATETIME_FORMAT, DAY_DATETIME_FORMATTER,
            DatePattern.NORM_DATETIME_FORMAT, NORM_DATETIME_FORMATTER
    );

    public static String format(long timestamp, DatePattern pattern) {
        DateTimeFormatter formatter = FORMATTER_MAP.get(pattern);
        if (formatter == null) {
            throw new IllegalArgumentException("Unsupported date pattern: " + pattern);
        }
        LocalDateTime dateTime = LocalDateTime.ofInstant(Instant.ofEpochMilli(timestamp), ZoneId.systemDefault());
        return dateTime.format(formatter);
    }

}
