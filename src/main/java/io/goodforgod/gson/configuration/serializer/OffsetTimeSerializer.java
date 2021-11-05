package io.goodforgod.gson.configuration.serializer;

import com.google.gson.*;
import io.goodforgod.gson.configuration.DateTimeFormatters;
import java.lang.reflect.Type;
import java.time.OffsetTime;
import java.time.format.DateTimeFormatter;

/**
 * @see OffsetTimeSerializer
 * @author Anton Kurako (GoodforGod)
 * @since 25.04.2021
 */
public class OffsetTimeSerializer implements JsonSerializer<OffsetTime> {

    public static final OffsetTimeSerializer INSTANCE = new OffsetTimeSerializer();

    private final DateTimeFormatter formatter;

    public OffsetTimeSerializer() {
        this(DateTimeFormatters.OFFSET_TIME_ISO);
    }

    public OffsetTimeSerializer(DateTimeFormatter formatter) {
        this.formatter = formatter;
    }

    @Override
    public JsonElement serialize(OffsetTime src, Type typeOfSrc, JsonSerializationContext context) {
        return new JsonPrimitive(formatter.toFormat(OffsetTime::from).format(src));
    }
}
