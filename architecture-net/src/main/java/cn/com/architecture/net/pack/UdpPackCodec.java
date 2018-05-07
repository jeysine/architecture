package cn.com.architecture.net.pack;



import cn.com.architecture.net.utils.LittleEndianCodec;

import java.io.Serializable;
import java.util.Arrays;

/**
 * 战斗服上行专用的数据包:和游戏服有点不同,多了几个udp必要的参数
 *
 * @author Pan
 * 2015年12月1日
 */
public class UdpPackCodec {

	/**头长度*/
	private static final int LEN = 4*3;//3个int:sessionId + packageId + CMD + protoBytes

	public static Pack decode(byte[] data){
		int it = 0;
		int sessionId = LittleEndianCodec.readInt(data, it + 0);
		int packageId = LittleEndianCodec.readInt(data, it + 4);
		int cmd = LittleEndianCodec.readInt(data, it + 8);
		byte[] newdata = Arrays.copyOfRange(data, it + LEN, data.length);

		return new Pack(cmd,sessionId,packageId,newdata);
	}

	public static byte[] encode(int cmd,int sessionId,int packageId,byte[] data) {
		byte[] res = new byte[data.length+LEN];
		int it = 0;
		LittleEndianCodec.writeInt(res, it + 0, sessionId);
		LittleEndianCodec.writeInt(res, it + 4, packageId);
		LittleEndianCodec.writeInt(res, it + 8, cmd);
		it += LEN;

		for (int i=0; i < data.length; ++i){
			res[it + i] = data[i];
		}
		return res;
	}

	public static byte[] encode(Pack pack) {
		return encode(pack.cmd,pack.sessionId,pack.packageId,pack.data);
	}

	public static final class Pack implements Serializable{
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		public final int cmd;//消息命令号
		public final int sessionId;//进入战斗前分配的通信令牌,代表一个玩家.因为是udp通信,防止玩家恶意模仿别人发送数据包
		public final int packageId;	//数据包id,用于处理丢包重传
		public final byte[] data;
		public long recTime;	//收到的时间,用于处理udp排序

		public Pack(int cmd,int sessionId,int packageId, byte[] data) {
			this.cmd = cmd;
			this.sessionId = sessionId;
			this.packageId = packageId;
			this.data = data;
		}
	}

}
