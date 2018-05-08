package cn.com.architecture.net.utils;

/**
 * 简单数组混淆和提取
 *
 * @author Pan
 * 2017年2月5日
 */
public class BytesConfuse {

	public static void main(String[] args) {
		byte[] data = new byte[50];//偶数测试
//		byte[] data = new byte[51];//奇数测试
		for (byte i = 0; i < data.length; i++) {
			data[i] = i;
		}
		
		String default_key = "good321net";//good321net
		
		System.out.println("测试-原始=");
		printBytes(data);
		
		byte[] box = create_box(default_key);
		
		byte[] data_1 = encryptAndDecode(box,data,0,data.length);
		System.out.println("测试-混淆=" + isSameBytes(data, data_1));
		printBytes(data_1);
		
		byte[] data_2 = encryptAndDecode(box,data_1,0,data_1.length);
		System.out.println("测试-提取=" + isSameBytes(data, data_2));
		printBytes(data_2);
	}
	
    private static int B_SIZE = 0xff;

    public static byte[] create_box(String key)
    {
        byte[] buffer = new byte[B_SIZE];
        for (int i = 0; i < B_SIZE; i++)
        {
            buffer[i] = (byte) i;
        }
        byte[] buffer2 = new byte[B_SIZE];
        for (int j = 0; j < B_SIZE; j++)
        {
            buffer2[j] = (byte) key.charAt(j % key.length());
        }
        int index = 0;
        int num4 = 0;
        while (index < B_SIZE)
        {
            num4 = ((num4 + (buffer[index]&0xff)) + (buffer2[index]&0xff)) % B_SIZE;
            byte num5 = buffer[index];
//            System.out.println(index + "/" + num4);
            buffer[index] = buffer[num4];
            buffer[num4] = num5;
            index++;
        }
        return buffer;
    }

    public static byte[] encryptAndDecode(byte[] box, byte[] msg, int index, int length)
    {
        int num = index;
        int offset = 0;
        while (offset < length)
        {
            msg[num] = (byte) (msg[num] ^ box[offset % B_SIZE]);

            offset++;
            num++;
        }
        
        return msg;
    }
	
	public static void printBytes(byte[] inData){
		for (int i = 0; i < inData.length; i++) {
			System.out.print(inData[i]);
			if(i != inData.length - 1){
				System.out.print(",");
			}
		}
		System.out.println();
	}
	
	public static boolean isSameBytes(byte[] inData1,byte[] inData2){
		if(inData1.length != inData2.length){
			return false;
		}
		
		for (int i = 0; i < inData2.length; i++) {
			if(inData1[i] != inData2[i]){
				return false;
			}
		}
		
		return true;
	}

}
