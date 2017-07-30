package utils;

import utils.okhttputil.utils.RandomUtils;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.security.SecureRandom;
import java.text.MessageFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//import common.core.Def;
//import common.core.StaticData;

/**
 * 字符串工具集类
 *
 * @author eric
 *
 */
public class StringUtils extends org.apache.commons.lang3.StringUtils {


    /**
     * 大数字格式化,不加
     *
     * @param val
     * @return
     */
    public static String formatBigNumber(int val) {
        return formatBigNumber(val, true);
    }

    /**
     * 大数字格式化
     *
     * @param val
     * @return
     */
    public static String formatBigNumber(int val,boolean flag) {
        int base = 10000;
        if (val < base) {
            if(flag){
                return val + "";
            }else{
                return 0 + "";
            }
        }
        if(flag){
            return val / base + "w";
        }else{
            return val / base + "";
        }

    }

    /**
     * 加密当前时间
     */
    private static String TIME_KEY = "current_time";

    /**
     * 解密当前时间
     */
    public static long decryptTime(String timeStr) {
        if (isEmpty(timeStr))
            return 0;
        String time = decrypt(timeStr, TIME_KEY);
        try {
            if (StringUtils.isNumeric(time))
                return Long.parseLong(time);
            return 0;
        } catch (Exception e) {
            return 0;
        }
    }

    /**
     * 如果系统中存在旧版本的数据，则此值不能修改，否则在进行密码解析的时候出错
     */
    private static final String PASSWORD_CRYPT_KEY = "clickcom";

    private final static String DES = "DES";

    public final static String ISO8859_1 = "8859_1";

    public static String removeLastChar(String old){
        if(old==null || old.length()<2){
            return old;
        }
        String newString = old.substring(0,old.length()-1);
        return newString;
    }

    /**
     * 数据解密
     *
     * @param data
     * @param key
     *            密钥
     * @return
     * @throws Exception
     */
    public final static String decrypt(String data, String key) {
        if (data == null || key == null)
            return null;
        try {
            return new String(
                    decrypt(hex2byte(data.getBytes()), key.getBytes()));
        } catch (Exception e) {
            // e.printStackTrace();
        }
        return null;
    }

    /**
     * 数据加密
     *
     * @param data
     * @param key
     *            密钥
     * @return
     * @throws Exception
     */
    public final static String encrypt(String data, String key) {
        if (data == null || key == null)
            return null;
        try {
            return byte2hex(encrypt(data.getBytes(), key.getBytes()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

//    public static byte[] enBASE64(byte[] bytes) {
//        return Base64Code.encode(bytes);
//    }
//
//    /**
//     * BASE64反编码
//     *
//     * @param bytes
//     * @return byte[]
//     */
//    public static byte[] deBASE64(byte[] bytes) {
//        return Base64Code.decode(bytes);
//    }

    /**
     * BASE64编码
     *
     * @param s
     * @return String
     */
    public static String enBASE64(String s) {
//        if (s != null) {
//            byte abyte0[] = s.getBytes();
//            abyte0 = Base64Code.encode(abyte0);
//            s = new String(abyte0);
//            return s;
//        }
        return null;
        //TODO enBASE64
    }

    /**
     * BASE64反编码
     *
     * @param s
     * @return String
     */
    public static String deBASE64(String s) {
//        if (s != null) {
//            byte abyte0[] = s.getBytes();
//            abyte0 = Base64Code.decode(abyte0);
//            s = new String(abyte0);
//            abyte0 = null;
//            return s;
//        }
        return null;
        //TODO deBASE64
    }

    /**
     * 得到文件的后缀
     *
     * @date 2006-12-21
     * @author eric.chen
     * @param str
     * @return
     */
    public static String getFileExt(String str) {
        if (StringUtils.isEmpty(str)) {
            return "";
        }
        try {
            if (str.lastIndexOf(".") != -1)
                return str.substring(str.lastIndexOf(".") + 1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    private final static String regDate = "^((((1[6-9]|[2-9]\\d)\\d{2})-(0?[13578]|1[02])-(0?[1-9]|[12]\\d|3[01]))|(((1[6-9]|[2-9]\\d)\\d{2})-(0?[13456789]|1[012])-(0?[1-9]|[12]\\d|30))|(((1[6-9]|[2-9]\\d)\\d{2})-0?2-(0?[1-9]|1\\d|2[0-8]))|(((1[6-9]|[2-9]\\d)(0[48]|[2468][048]|[13579][26])|((16|[2468][048]|[3579][26])00))-0?2-29))$";

    /**
     * 判断是否日期 <code>
     *   StringUtils.isDate(null)        = false
     *   StringUtils.isDate("19830109")  = true
     *   StringUtils.isDate("1983109")   = false
     *   StringUtils.isDate("1983-01-09")= true
     * </code>
     *
     * @param d
     *            日期字串，必需大于或等于8位格式是年月日
     * @return
     */
    public static boolean isDate(String d) {
        if (isEmpty(d) || d.length() < 8) {
            return false;
        }
        if (isNumeric(d)) {
            StringBuilder sb = new StringBuilder(d);
            sb.insert(4, "-").insert(7, "-");
            d = sb.toString();
        }

        Pattern pat = Pattern.compile(regDate);
        Matcher mat = pat.matcher(d);
        while (mat.find())
            return true;
        return false;
    }

    private final static String regDateTime = "^((((1[6-9]|[2-9]\\d)\\d{2})-(0?[13578]|1[02])-(0?[1-9]|[12]\\d|3[01]))|(((1[6-9]|[2-9]\\d)\\d{2})-(0?[13456789]|1[012])-(0?[1-9]|[12]\\d|30))|(((1[6-9]|[2-9]\\d)\\d{2})-0?2-(0?[1-9]|1\\d|2[0-8]))|(((1[6-9]|[2-9]\\d)(0[48]|[2468][048]|[13579][26])|((16|[2468][048]|[3579][26])00))-0?2-29)) (20|21|22|23|[0-1]?\\d):[0-5]?\\d:[0-5]?\\d$";


    /**
     * 判断是否日期 <code>
     *   StringUtils.isDateTime(null)        = false
     *   StringUtils.isDateTime("1983-01-09 12:22:00")  = true
     *   StringUtils.isDateTime("1983-01-09 55:69:00")  = false
     *   StringUtils.isDateTime("1983-01-09 12:22")  = false
     * </code>
     *
     * @param d
     *            日期字串，必需是一个标准的日期和时间如1983-01-09 13:12:00
     * @return
     */
    public static boolean isDateTime(String d) {
        if (isEmpty(d)) {
            return false;
        }
        Pattern pat = Pattern.compile(regDateTime);
        Matcher mat = pat.matcher(d);
        while (mat.find())
            return true;
        return false;
    }

    /**
     * 加密
     *
     * @param src
     *            数据源
     * @param key
     *            密钥，长度必须是8的倍数
     * @return 返回加密后的数据
     * @throws Exception
     */
    public static byte[] encrypt(byte[] src, byte[] key) throws Exception {
        // DES算法要求有一个可信任的随机数源
        SecureRandom sr = new SecureRandom();
        // 从原始密匙数据创建DESKeySpec对象
        DESKeySpec dks = new DESKeySpec(key);
        // 创建一个密匙工厂，然后用它把DESKeySpec转换成
        // 一个SecretKey对象
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(DES);
        SecretKey securekey = keyFactory.generateSecret(dks);
        // Cipher对象实际完成加密操作
        Cipher cipher = Cipher.getInstance(DES);
        // 用密匙初始化Cipher对象
        cipher.init(Cipher.ENCRYPT_MODE, securekey, sr);
        // 现在，获取数据并加密
        // 正式执行加密操作
        return cipher.doFinal(src);
    }

    /**
     * 解密
     *
     * @param src
     *            数据源
     * @param key
     *            密钥，长度必须是8的倍数
     * @return 返回解密后的原始数据
     * @throws Exception
     */
    public static byte[] decrypt(byte[] src, byte[] key) throws Exception {
        // DES算法要求有一个可信任的随机数源
        SecureRandom sr = new SecureRandom();
        // 从原始密匙数据创建一个DESKeySpec对象
        DESKeySpec dks = new DESKeySpec(key);
        // 创建一个密匙工厂，然后用它把DESKeySpec对象转换成
        // 一个SecretKey对象
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(DES);
        SecretKey securekey = keyFactory.generateSecret(dks);
        // Cipher对象实际完成解密操作
        Cipher cipher = Cipher.getInstance(DES);
        // 用密匙初始化Cipher对象
        cipher.init(Cipher.DECRYPT_MODE, securekey, sr);
        // 现在，获取数据并解密
        // 正式执行解密操作
        return cipher.doFinal(src);
    }

    /**
     * 二行制转字符串
     *
     * @param b
     * @return
     */
    public static String byte2hex(byte[] b) {
        // String hs = "";
        String stmp = "";
        StringBuilder sb = new StringBuilder();
        for (int n = 0; n < b.length; n++) {
            stmp = (Integer.toHexString(b[n] & 0XFF));
            if (stmp.length() == 1)
                // hs = hs + "0" + stmp;
                sb.append("0").append(stmp);
            else
                // hs = hs + stmp;
                sb.append(stmp);
        }
        return sb.toString().toUpperCase();
    }

    public static byte[] hex2byte(byte[] b) {
        if ((b.length % 2) != 0)
            throw new IllegalArgumentException("长度不是偶数");
        byte[] b2 = new byte[b.length / 2];
        for (int n = 0; n < b.length; n += 2) {
            String item = new String(b, n, 2);
            b2[n / 2] = (byte) Integer.parseInt(item, 16);
        }
        return b2;
    }

    /**
     * 该方法返回一个字符的DBCS编码值
     *
     * @param cc
     * @return int
     */
    protected static int getCode(char cc) {
        byte[] bs = String.valueOf(cc).getBytes();
        int code = (bs[0] << 8) | (bs[1] & 0x00FF);
        if (bs.length < 2)
            code = (int) cc;
        bs = null;
        return code;
    }

    /**
     * 全角转半角
     *
     * @param s
     * @return
     */
    public static String change(String s) {
        String outStr = "";
        String Tstr = "";
        byte[] b = null;
        for (int i = 0; i < s.length(); i++) {
            try {
                Tstr = s.substring(i, i + 1);
                b = Tstr.getBytes("unicode");
            } catch (java.io.UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            if (b[3] == -1) {
                b[2] = (byte) (b[2] + 32);
                b[3] = 0;

                try {
                    outStr = outStr + new String(b, "unicode");
                } catch (java.io.UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            } else
                outStr = outStr + Tstr;
        }
        return outStr;
    }

    private static char split = (char) 1;

    /**
     * 把一个数组变成一个string 用(char)1做分割
     *
     * @date 2007-9-11
     * @author eric.chen
     * @param objs
     * @return
     */
    public static String argToString__(Object... objs) {
        if (objs == null || objs.length == 0)
            return "";

        StringBuilder sb = new StringBuilder();
        for (Object o : objs) {
            sb.append(o).append(split);
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    /**
     * 把一个数组变成一个string
     *
     * @param objs
     * @return
     */
    public static String argToString_(Object... objs) {
        if (objs == null || objs.length == 0)
            return "";

        StringBuilder sb = new StringBuilder();
        for (Object o : objs) {
            sb.append(o);
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    /**
     * 把一个用(char)1分割的字符串变成一个数组
     *
     * @date 2007-9-11
     * @author eric.chen
     * @param str
     * @return
     */
    public static String[] stringToArg(String str) {
        if (StringUtils.isEmpty(str)) {
            return null;
        } else {
            return str.split(String.valueOf(split));
        }
    }

    public static String[] stringToArg(String str, String split1) {
        if (StringUtils.isEmpty(str)) {
            return null;
        } else {
            return str.split(split1);
        }
    }

    /**
     * 反字符串变数组
     *
     * @param str
     * @param split
     * @return
     * @date 2008-11-25
     * @author eric.chan
     */
    public static int[] stringToIntArg(String str, String split) {
        if (isEmpty(str))
            return new int[0];
        String[] strs = str.split(split);
        int[] rt = new int[strs.length];
        for (int i = 0; i < rt.length; i++) {
            rt[i] = Integer.parseInt(strs[i]);
        }
        return rt;
    }

    public static long[] stringToLongArg(String str, String split) {
        if (isEmpty(str))
            return new long[0];
        String[] strs = str.split(split);
        long[] rt = new long[strs.length];
        for (int i = 0; i < rt.length; i++) {
            rt[i] = Long.parseLong(strs[i]);
        }
        return rt;
    }

    public static String argToString(int[] ii, char split) {
        if (ii == null || ii.length == 0)
            return "";
        StringBuilder sb = new StringBuilder();
        for (int i : ii) {
            sb.append(i).append(split);
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    public static Map stringToMap(String str) {
        if (isEmpty(str))
            return new HashMap();
        if (str.equals("-1"))
            return new HashMap();
        String[] strs = str.split(";");
        Map m = new HashMap();
        String[] ss = null;
        for (String s : strs) {
            ss = s.split(",");
            m.put(ss[0], ss[1]);
        }
        return m;
    }

    /**
     * 把字符串二维整数数组，比如key,value格式的字符窜，可以进行这样的转换 [0][0]表示key,[0][1]表示value
     *
     * @author chenpi
     * @since 2009-12-16 上午10:14:24
     * @param str
     * @return
     */
    @SuppressWarnings("unchecked")
    public static int[][] stringToDyIntArg(String str) {
        if (isEmpty(str))
            return null;
        int[][] keyValue;
        String[] strs = str.split(";");
        keyValue = new int[strs.length][2];
        for (int i = 0; i < strs.length; i++) {
            keyValue[i] = StringUtils.stringToIntArg(strs[i], ",");
        }
        return keyValue;
    }

    /**
     * 获取key,value格式的key
     *
     * @author chenpi
     * @since 2009-12-16 上午11:29:19
     * @param str
     * @return
     */
    public static String getItemKey(String str) {
        String[] ss = str.split(",");
        return ss[0];
    }

    /**
     * 获取key,value格式的value
     *
     * @author chenpi
     * @since 2009-12-16 上午11:30:32
     * @param str
     * @return
     */
    public static String getItemValue(String str) {
        String[] ss = str.split(",");
        return ss[1];
    }

    /**
     * 得到一个int数的二进制的某一位的数值 0/1
     *
     * @param i
     * @param bit
     * @return 返回0 或者1
     * @date 2007-12-26
     * @author eric.chan
     */
    public static int getIntBitValue(int i, int bit) {
        return (i & 1 << (bit - 1)) > 0 ? 1 : 0;
        // return (i & intTo16IntMap.get(bit)) >> (bit-1 );
    }

    private static Formatter format = new Formatter();

    public static String formatMsg(String mat, Object... args) {
        return new Formatter().format(mat, args).toString();
    }

    /**
     * 百分比计算 b1/b2 %
     *
     * @param b1
     * @param b2
     * @return 2009-3-5
     * @author lyh
     */
    public static int percent(int b1, int b2) {
        if (b2 > 0)
            return b1 * 100 / b2;
        return 0;
    }

    public static String toGetMethod(String s) {
        char[] ch = s.toCharArray();
        ch[0] = (char) (ch[0] - 32);
        String col = "get" + String.valueOf(ch);
        return col;
    }

    public static String toSetMethod(String s) {
        char[] ch = s.toCharArray();
        if (ch[0] >= 97)
            ch[0] = (char) (ch[0] - 32);
        String col = "set" + String.valueOf(ch);
        return col;
    }

    /**
     * 解释物品功能code字串
     *
     * @param value
     * @return
     * @date 2008-10-21
     * @author eric.chan
     */
	/*public static Integer[] parserItemAttrCode(String value) {
		String[] temps = value.split(",");
		Integer[] codes = new Integer[temps.length];
		for (int i = 0; i < temps.length; i++) {
			codes[i] = NumberUtils.toInt(temps[i]);
		}
		return codes;
	}
	*/

    public static int[] parserItemAttr(String value){
        String[] temps = value.split(",");
        int[] codes = new int[temps.length];
        for (int i = 0;i<temps.length;i++){
            codes[i] = Integer.parseInt(temps[i]);
        }
        return codes;
    }

    /**
     * 填充物品功能code字符串
     *
     * @param value
     * @return 2008-10-22
     * @author lyh
     */
    public static String putItemAttrCode(Integer[] value) {
        StringBuilder sb = new StringBuilder();
        for (Integer code : value) {
            sb.append(code).append(",");
        }
        sb.deleteCharAt(sb.lastIndexOf(","));
        return sb.toString();
    }

    /**
     * java edition readUTF used by java to java
     *
     * @param dos
     * @param str
     * @throws IOException
     */
    public static final void writeUTF(DataOutputStream dos, String str)
            throws IOException {
        if (str == null)
            str = "null";
        int size = str.length();
        dos.writeShort(size);
        short c;
        for (int i = -1; ++i < size;) {
            c = (short) str.charAt(i);
            dos.writeShort(c);
        }
    }

    public static final String readUTF(DataInputStream dis) throws IOException {

        int utflen = dis.readShort();

        StringBuilder temp = new StringBuilder();
        char c;
        for (int i = -1; ++i < utflen;) {
            c = (char) dis.readShort();
            temp.append(c);
        }
        return temp.toString();
    }

    /**
     * 替换字符串
     *
     * @author chenpi
     * @since 2010-7-6 下午05:06:31
     * @param str
     * @param replace
     * @param replacement
     * @return
     */
    public static String replaceAll(String str, String replace,
                                    String replacement) {
        if (str == null || replace == null || replacement == null)
            return "";
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        int index = sb.indexOf(replace);
        while (index != -1) {
            sb.replace(index, index + replace.length(), replacement);
            index = sb.indexOf(replace);
        }
        return sb.toString();
    }

    public static String _10to36(long i) {
        StringBuilder buffer = null;
        buffer = new StringBuilder();
        while (i > 0) {
            buffer.insert(0, _10to36_(i % 36));
            i /= 36;
        }
        String s = buffer.toString();
        return s;
    }

    public static char _10to36_(long i) {
        if (i >= 0 && i <= 9) {
            i = (i + 48);
        } else if (i >= 10 && i <= 35) {
            i = (i + 87);
        } else if (i >= 36 && i <= 61) {
            i = (i + 29);
        }
        return (char) (i);
    }

    /**
     * 将0-9a-zA-z的62进制转换成一个数字
     */
    public static long _36to10(String s) {
        long i = 0;
        for (char c : s.toCharArray()) {
            if (i > 0) {
                i *= 36;
            }
            i += _36to10_(c);
        }

        // for (int index = 0; index < s.length(); index++) {
        // if (index > 0) {
        // i *= 62;
        // }
        // i += decodeCharToInt(s.charAt(index));
        // }
        return i;
    }

    /**
     * 将单位的0-9a-zA-z按顺序转换成数字<br>
     * '0' -> 0<br>
     * '9' -> 9<br>
     * 'a' -> 10<br>
     * 'z' -> 35<br>
     * 'A' -> 36<br>
     * 'Z' -> 61
     */
    public static int _36to10_(char c) {
        int t = 0;
        if (c >= '0' && c <= '9') {
            t = c - 48;
        } else if (c >= 'a' && c <= 'z') {
            t = c - 87;
        } else if (c >= 'A' && c <= 'Z') {
            t = c - 29;
        }
        return t;
    }

    /**
     * 随机万分之一
     *
     * @return
     * @author lyh
     * @date 2010-11-23
     */
    public static int getOneInTenThousand() {
        return RandomUtils.nextInt(10000);
    }

    /**
     * 超链接
     *
     * @author like 2012-8-31 下午02:50:53
     */
    public static void a(StringBuilder ui, String text, String color) {
        // text=\""+text+"\" color=\""+color+"\"/>");
        ui.append("<hrf");
        if (!text.equals("")) {
            ui.append(" ").append(text).append("=\"").append(text)
                    .append("\" ");
        }
        if (!color.equals("")) {
            ui.append(" ").append(color).append("=\"").append(color)
                    .append("\" ");
        }
        ui.append(" />");
    }

    /**
     * 换行符
     *
     * @author like 2012-8-31 下午02:50:56
     */
    public static void br(StringBuilder ui) {
        ui.append("\n");
    }

    /**
     * a参数c居中 l居左r居右
     *
     * @author like 2013-2-28 上午10:02:04
     */
    public static void txt(StringBuilder ui, String height, String color,
                           String text, String a) {
        ui.append("<p>");
        if (!height.equals("")) {
            ui.append(" ").append("height").append("='").append(height)
                    .append("'");
        }
        if (!color.equals("")) {
            ui.append("<c v='").append(color.trim()).append("'>").append(text)
                    .append("</c>");
        } else {
            ui.append(text);
        }
        ui.append(" </p>");
    }

    /**
     * 段落标记 a参数c居中 l居左r居右 显示正行内容，如果超出UI宽度则自动换行
     *
     * @author like 2013-2-28 上午10:12:33
     */
    public static String p(String uidata, String a) {
        if (isNotEmpty(a)) {
            return "<p a='" + a + "'>" + uidata + "</p>";
        } else {
            return "<p>" + uidata + "</p>";
        }
    }

    /**
     * 标题级别 h1 h2 h3
     *
     * @author like 2013-2-28 上午10:15:49
     */
    public static String h(String uidata, String h_) {
        return "<" + h_ + ">" + uidata + "</" + h_ + ">";
    }

    /**
     * 图片链接
     *
     * @author like 2012-8-31 下午02:51:03
     */
    public static String img(String src, String width, String height) {
        String param = "";
        if (isNotEmpty(width)) {
            param = " w='" + width + "' ";
        }
        if (isNotEmpty(height)) {
            param = param + " h='" + height + "' ";
        }
        return "<img" + param + ">" + src + "</img>";

    }

    /**
     * 标记颜色码
     *
     * @author like 2013-2-28 上午10:22:45
     */
    public static String c(String uidata, String color) {
        // <c v='#FF00FF'>This is strike and colour.</c>
        return "<c v='" + color + "'>" + uidata + "</c>";

    }

    /**
     * 换行
     *
     * @author like 2013-2-28 上午10:36:30
     */
    public static String n(String uidata) {
        return uidata + "\n";
    }

    /**
     * 图片超链
     * @author like
     * @param uidata
     * @param v
     * @return
     */
    public static String url(String uidata, String v) {
        if (isNotEmpty(v)) {
            return "<url v='" + v + "'>" + uidata + "</url>";
        } else {
            return "<url>" + uidata + "</url>";
        }
    }

    /**
     * 计算字符串的字符长度，中文算2个字符
     *
     * @param str
     * @return
     */
    public static int charLength(String str) {
        if (isBlank(str)) {
            return 0;
        }
        int valueLength = 0;
        String chinese = "[\u0391-\uFFE5]";
        for (int i = 0; i < str.length(); i++) {
            String temp = str.substring(i, i + 1);
            if (temp.matches(chinese)) {
                // 中文
                valueLength += 2;
            } else {
                valueLength += 1;
            }
        }
        return valueLength;
    }

    public static String _10to61(long i) {
        if (i == 0) {
            return "0";
        }
        StringBuilder buffer = new StringBuilder();
        while (i > 0) {
            buffer.insert(0, _10to61_(i % 61));
            i /= 61;
        }
        return buffer.toString();
    }

    private static char _10to61_(long i) {
        if (i >= 0 && i <= 9) {
            i = (i + 48);
        } else if (i >= 10 && i <= 35) {
            i = (i + 87);
        } else if (i >= 36 && i <= 60) {
            i = (i + 29);
        }
        return (char) (i);
    }

    public static long _61to10(String s) {
        long i = 0;
        for (char c : s.toCharArray()) {
            if (i > 0) {
                i *= 61;
            }
            i += _61to10_(c);
        }
        return i;
    }

    /**
     * 将单位的0-9a-zA-Y按顺序转换成数字<br>
     * Z保留用作字符串分隔
     */
    private static int _61to10_(char c) {
        int t = 0;
        if (c >= '0' && c <= '9') {
            t = c - 48;
        } else if (c >= 'a' && c <= 'z') {
            t = c - 87;
        } else if (c >= 'A' && c <= 'Y') {
            t = c - 29;
        }
        return t;
    }

    //字符村转Integer集合
    public static List<Integer> stringToList(String str){
        if(StringUtils.isEmpty(str)){
            return null;
        }
        List<Integer> list = new ArrayList<Integer>();

        int[] equipAttrIds = StringUtils.stringToIntArg(str, ",");
        for(int i:equipAttrIds){
            list.add(i);
        }
        return list;
    }

    public static List<Integer> stringToList(String str,String c){
        if(StringUtils.isEmpty(str)){
            return null;
        }
        List<Integer> list = new ArrayList<Integer>();

        int[] equipAttrIds = StringUtils.stringToIntArg(str, c);
        for(int i:equipAttrIds){
            list.add(i);
        }
        return list;
    }

    /**
     * function字符串转整形
     * @param str
     * @return
     */
    public static int funcStrToInt(String str){
        int value;
        if (StringUtils.endsWith(str, "%")) {
            value = Integer.parseInt(StringUtils.substring(str, 0, str.length() - 1));
        }else{
            value = Integer.parseInt(str);
        }
        return value;
    }

    /**
     * function字符串转浮点
     * @param str
     * @return
     */
    public static int funcStrToFloat(String str){
        int value;
        if (StringUtils.endsWith(str, "%")) {
            value = Integer.parseInt(StringUtils.substring(str, 0, str.length() - 1));
        }else{
            value = Integer.parseInt(str);
        }
        return value;
    }

    /**
     * function字符串检查是否为百分比数值
     * @param str
     * @return
     */
    public static boolean funcCheckPercent(String str){
        if (StringUtils.endsWith(str, "%")) {
            return true;
        }else{
            return false;
        }
    }

    String regEx="[^0-9]";

    public static int match(String str,String regEx){
        //String[] result = Pattern.compile(regx).split(str);
        //return Integer.parseInt(result[0]);

        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(str);
        int val = Integer.parseInt(m.replaceAll(""));
        return val;
    }

    /**
     * 返回 {res}.properties 中 key 对应的值
     *
     * @param message 源字符串
     * @param args
     * @return
     */
    public static String formatString(String message, Object... args) {
        if (args == null)
            return message;
        if (message != null){
            //return null;
            return MessageFormat.format(message, args);
        }
        return null;

    }


    /**
     * 转换字段名称，如 sys_name 变成 SysName
     * @param str
     * @return
     */
    public static String replaceUnderLineAndUpperCase(String str){
        StringBuffer sb = new StringBuffer();
        sb.append(str);
        int count = sb.indexOf("_");
        while(count!=0){
            int num = sb.indexOf("_",count);
            count = num + 1;
            if(num != -1){
                char ss = sb.charAt(count);
                char ia = (char) (ss - 32);
                sb.replace(count , count + 1,ia + "");
            }
        }
        String result = sb.toString().replaceAll("_","");
        return org.apache.commons.lang3.StringUtils.capitalize(result);
    }

    /**
     * 下划线风格转大写驼峰
     */
    public static String underlineToUpperCamal(String s){
        String[] ss = s.split("_");
        for (int i = 0; i < ss.length; i++) {
            ss[i] = upFirst1(ss[i]);
        }
        return join("", ss);
    }

    /**
     * 大写首字母
     */
    public static String upFirst(String str) {
        return str.substring(0, 1).toUpperCase().concat(str.substring(1));
    }

    /**
     * 首字母大写
     * @author Craig
     * @param str
     */
    public static String upFirst1(String str) {
        char[] strs = str.toCharArray();
        if((strs[0] >= 'a' && strs[0] <= 'z')) {
            strs[0] -= 32;
            return String.valueOf(strs);
        }else {
            return upFirst(str);
        }
    }

    public static String sqlTypeToJavaType(String type){

        if(type.equals("BIGINT")){
            return "java.lang.Long";
        }
        if(type.equals("SMALLINT")){
            return "java.lang.Short";
        }
        if(type.contains("INT")){
            return "java.lang.Integer";
        }
        if(type.equals("FLOAT")){
            return "java.lang.Float";
        }
        if(type.equals("DOUBLE")){
            return "java.lang.Float";
        }
        if(type.contains("CHAR") || type.contains("TEXT")){
            return "java.lang.String";
        }
        if(type.contains("BINARY") || type.contains("BLOB")){
            return "byte[]";
        }
        if(type.contains("DATE") || type.contains("TIME")){
            return "java.util.Date";
        }

        // 其他类型拜托不要用了
        throw new RuntimeException("unsupported type = " + type);
    }

}