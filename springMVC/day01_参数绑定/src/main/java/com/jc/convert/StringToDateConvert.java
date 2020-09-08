package com.jc.convert;

import org.springframework.core.convert.converter.Converter;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StringToDateConvert implements Converter<String, Date> {

    @Override
    public Date convert(String source) {
        if (source == null || "".equals(source.trim())) {
            throw new RuntimeException("请输入日期");
        }
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date date = df.parse(source);
            return date;
        } catch (ParseException e) {
            throw new RuntimeException("日期格式不正确");
        }
    }
}
