package utils;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.AnnotationUtils;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

public class JsonUtil {

	private static Logger logger = LoggerFactory.getLogger(JsonUtil.class);

	private static ObjectMapper objectMapper = null;

	static {

		setObjectMapper(new ObjectMapper());

	}

	public static String stringify(Object object) {

		try {
			return getObjectMapper().writeValueAsString(object);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}

		return null;
	}

	public static String stringify(Object object, String... properties) {

		try {
			return getObjectMapper().writer(
					new SimpleFilterProvider().addFilter(
							AnnotationUtils.getValue(
									AnnotationUtils.findAnnotation(object.getClass(), JsonFilter.class)).toString(),
							SimpleBeanPropertyFilter.filterOutAllExcept(properties))).writeValueAsString(object);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}

		return null;
	}

	public static void stringify(OutputStream out, Object object) {

		try {
			getObjectMapper().writeValue(out, object);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
	}

	public static void stringify(OutputStream out, Object object, String... properties) {

		try {
			getObjectMapper().writer(
					new SimpleFilterProvider().addFilter(
							AnnotationUtils.getValue(
									AnnotationUtils.findAnnotation(object.getClass(), JsonFilter.class)).toString(),
							SimpleBeanPropertyFilter.filterOutAllExcept(properties))).writeValue(out, object);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
	}

	public static <T> T parse(String json, Class<T> clazz) {

		if (json == null || json.length() == 0) {
			return null;
		}

		try {
			return getObjectMapper().readValue(json, clazz);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}

		return null;
	}

	public static <T> T parse(Object obj, Class<T> clazz) {

		if (obj == null) {
			return null;
		}

		try {
			return getObjectMapper().convertValue(obj, clazz);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}

		return null;
	}

	@SuppressWarnings("unchecked")
	public static Map<String, Object> parseToMap(String json) {
		if (json == null || json.length() == 0) {
			return null;
		}
		try {
			return (Map<String, Object>) getObjectMapper().readValue(json, Map.class);
		} catch (Exception e) {
			logger.error("Parse json string {} to map is failed", json, e);
		}

		return null;
	}

	@SuppressWarnings("rawtypes")
	private static JavaType getCollectionType(Class<? extends Collection> collectionClass, Class<?> elementClass) {
		return getObjectMapper().getTypeFactory().constructCollectionType(collectionClass, elementClass);
	}

	/**
	 * 转换为List<xxxModel>
	 * 
	 * @param json
	 * @param elementClass
	 * @return
	 * @throws IOException
	 * @throws JsonMappingException
	 */
	public static <T> List<T> parseToList(String json, Class<T> elementClass) throws JsonMappingException, IOException {
		if (json == null || json.length() == 0) {
			return Collections.emptyList();
		}
		return getObjectMapper().readValue(json, getCollectionType(List.class, elementClass));
	}

	public static ObjectMapper getObjectMapper() {
		objectMapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
		objectMapper.configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true);
		return objectMapper;
	}

	public static void setObjectMapper(ObjectMapper objectMapper) {
		JsonUtil.objectMapper = objectMapper;
	}
}