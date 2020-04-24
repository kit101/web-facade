package com.kit.web.facade;

import com.kit.web.facade.resolver.GlableExceptionResolver;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.TimeZone;

/**
 * @version V1.0
 * @desc:
 * @author: k7kit
 * @date: 2019-10-23
 */
@Configuration
public class FacadeConfiguration {

    @Bean
    @Primary
    public ObjectMapper jacksonObjectMapper(Jackson2ObjectMapperBuilder builder) {
        ObjectMapper objectMapper = builder.createXmlMapper(false).build();
        // 通过该方法对mapper对象进行设置，所有序列化的对象都将按改规则进行系列化
        // Include.Include.ALWAYS 默认
        // Include.NON_DEFAULT 属性为默认值不序列化
        // Include.NON_EMPTY 属性为 空（""） 或者为 NULL 都不序列化，则返回的json是没有这个字段的。这样对移动端会更省流量
        // Include.NON_NULL 属性为NULL 不序列化
        // objectMapper.setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
        // 遇到未知字段是否抛出 JsonMappingException异常
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        // 允许出现特殊字符和转义符
        objectMapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_CONTROL_CHARS, true);
        // 允许出现单引号
        objectMapper.configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true);
        // 时区
        objectMapper.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));
        // 时间格式
        objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS"));
        // 字段保留，将null值转为""
        objectMapper.getSerializerProvider().setNullValueSerializer(new JsonSerializer<Object>() {
            @Override
            public void serialize(Object o, JsonGenerator generator, SerializerProvider provider) throws IOException {
                generator.writeString("");
            }
        });
        return objectMapper;
    }


    @Bean
    public GlableExceptionResolver glableExceptionResolver(){
        return new GlableExceptionResolver();
    }
}
