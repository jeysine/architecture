package utils.code.generate;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

/**
 * Introduced for avoiding catching UnsupportedEncodingException
 *
 * @author leon
 *
 */
public abstract class EncodingUtil {

	public static byte[] utf8Bytes(String input) {
		try {
			return input.getBytes(StandardCharsets.UTF_8.toString());
		} catch (UnsupportedEncodingException e) {
			// must not happen
			throw new IllegalStateException("Why UTF-8 is not supported in this system!", e);
		}
	}

	public static String utf8UrlEncode(String input) {
		try {
			return URLEncoder.encode(input, StandardCharsets.UTF_8.toString());
		} catch (UnsupportedEncodingException e) {
			// must not happen
			throw new IllegalStateException("Why UTF-8 is not supported in this system!", e);
		}
	}

	public static String utf8UrlDecode(String input) {
		try {
			return URLDecoder.decode(input, StandardCharsets.UTF_8.toString());
		} catch (UnsupportedEncodingException e) {
			// must not happen
			throw new IllegalStateException("Why UTF-8 is not supported in this system!", e);
		}
	}

}
