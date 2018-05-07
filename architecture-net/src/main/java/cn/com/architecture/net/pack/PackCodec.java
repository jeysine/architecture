package cn.com.architecture.net.pack;

import cn.com.architecture.net.utils.BytesConfuse;
import cn.com.architecture.net.utils.LittleEndianCodec;

import java.io.Serializable;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * PackCodec
 *
 * @author chao
 * @version 1.0 - 2014-05-30
 */
public class PackCodec {
	
	static Set<Integer> encryptCmdsSet = null;//需要加密的协议
	static byte[] encryptBox = null;//加密的key
	
	/**
	 * 设置需要加密的协议号
	 * @param cmds 协议号
	 * @param encryptKey 加密的key
	 */
	public static void initEncrypt(int[] cmds,String _encryptKey){
		encryptBox = BytesConfuse.create_box(_encryptKey);
		if(encryptCmdsSet == null){
			encryptCmdsSet = new HashSet<>();
		}else{
			encryptCmdsSet.clear();
		}
		
		if(cmds != null){
			for (int ccc : cmds) {
				encryptCmdsSet.add(ccc);
			}
		}
	}

	/**头长度*/
	private static final int LEN = 4;

	public static Pack decode(byte[] data){
		int it = 0;
		int cmd = LittleEndianCodec.readInt(data, it);
		byte[] newdata = Arrays.copyOfRange(data, it + LEN, data.length);
		
		if(encryptCmdsSet != null && encryptCmdsSet.contains(cmd)){//加解密
//			System.out.println("解密前:");
//			BytesConfuse.printBytes(newdata);
			newdata = BytesConfuse.encryptAndDecode(encryptBox, newdata, 0, newdata.length);
//			System.out.println("解密后:");
//			BytesConfuse.printBytes(newdata);
		}

		return new Pack(cmd, newdata);
	}

	public static byte[] encode(int cmd, byte[] data) {
		if(encryptCmdsSet != null && encryptCmdsSet.contains(cmd)){//加解密
//			System.out.println("加密前:");
//			BytesConfuse.printBytes(data);
			data = BytesConfuse.encryptAndDecode(encryptBox, data, 0, data.length);
//			System.out.println("加密后:");
//			BytesConfuse.printBytes(data);
		}
		
		byte[] res = new byte[data.length+LEN];
		int it = 0;
		LittleEndianCodec.writeInt(res, it, cmd);
		it += LEN;

		for (int i=0; i < data.length; ++i){
			res[it + i] = data[i];
		}
		return res;
	}

	public static byte[] encode(Pack pack) {
		return encode(pack.cmd, pack.data);
	}

	public static final class Pack implements Serializable{
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		public final int cmd;
		public final byte[] data;

		public Pack(int cmd, byte[] data) {
			this.cmd = cmd;
			this.data = data;
		}
		
		public int getDataLength(){
			return data == null?0:data.length;
		}
	}

}
