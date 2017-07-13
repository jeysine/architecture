package utils;

/**
 * Created by jeysine on 2017/7/13.
 */
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Base64Utils extends Base64 {
    private static Logger logger = LoggerFactory.getLogger(Base64Utils.class);
    private static int BUFFER_SIZE = 4092;

    private Base64Utils() {
        throw new IllegalAccessError("Utility class");
    }

    /**
     * 将图片文件转化为字节数组字符串，并对其进行Base64编码处理
     *
     * @param path
     *            图片路径
     * @return base64字符串
     */
    public static String imageToBase64(String path) throws IOException {
        // 读取图片字节数组
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try (InputStream in = new FileInputStream(path)) {
            byte[] data = new byte[BUFFER_SIZE];
            int count = 0;
            while ((count = in.read(data, 0, BUFFER_SIZE)) != -1) {
                baos.write(data, 0, count);
            }
        } catch (FileNotFoundException e) {
            logger.error("file path {} not found", path, e);
        }
        return encodeBase64String(baos.toByteArray());// 返回Base64编码过的字节数组字符串
    }

    /**
     * 处理Base64解码并写图片到指定位置
     *
     * @param base64
     *            图片Base64数据
     * @param path
     *            图片保存路径
     * @return
     */
    public static boolean base64ToImageFile(String base64, String path) throws IOException {// 对字节数组字符串进行Base64解码并生成图片
        // 生成jpeg图片
        try (OutputStream out = new FileOutputStream(path)) {
            return base64ToImageOutput(base64, out);
        } catch (FileNotFoundException e) {
            logger.trace("file path {} not found", path, e);
        }
        return false;
    }

    /**
     * 处理Base64解码并输出流
     *
     * @param base64
     * @param ops
     * @return
     */
    public static boolean base64ToImageOutput(String base64, OutputStream ops) throws IOException {
        if (base64 == null) { // 图像数据为空
            return false;
        }
        try (OutputStream out = ops) {
            // Base64解码
            byte[] bytes = Base64.decodeBase64(base64);
            for (int i = 0; i < bytes.length; ++i) {
                if (bytes[i] < 0) {// 调整异常数据
                    bytes[i] += 256;
                }
            }
            // 生成jpeg图片
            out.write(bytes);
            out.flush();
            return true;
        }
    }
}
