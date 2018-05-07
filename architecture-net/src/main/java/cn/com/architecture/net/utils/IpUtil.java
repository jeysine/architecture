package cn.com.architecture.net.utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.*;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;

public class IpUtil {
	
	static String[] localIp = {//局域网ip的起始
			"10.",
			"192.168.",
			"172.16.",
			"172.17.",
			"172.18.",
			"172.19.",
			"172.20.",
			"172.21.",
			"172.22.",
			"172.23.",
			"172.24.",
			"172.25.",
			"172.26.",
			"172.27.",
			"172.28.",
			"172.29.",
			"172.30.",
			"172.31."
	};
	
	/**
	 * 
	 * @param dest_url
	 *            -- 地址
	 * @param commString
	 *            -- 参数
	 * @param requestMode
	 *            -- 请求方式 POST or GET
	 * @return
	 */
	private static String connectURL(String dest_url, String commString,
			String requestMode) {
		String rec_string = "";

		URL url = null;
		HttpURLConnection urlconn = null;
		try {
			url = new URL(dest_url);
			urlconn = (HttpURLConnection) url.openConnection();
			urlconn.setRequestProperty("content-type", "text/plain");
			urlconn.setRequestMethod(requestMode);
			urlconn.setDoInput(true);
			if (requestMode.equalsIgnoreCase("POST")) {
				urlconn.setDoOutput(true);
				OutputStream out = urlconn.getOutputStream();
				out.write(commString.getBytes("UTF8"));
				out.flush();
				out.close();
			}
			BufferedReader rd = new BufferedReader(new InputStreamReader(
					urlconn.getInputStream()));

			StringBuffer sb = new StringBuffer();
			int ch;
			while ((ch = rd.read()) > -1)
				sb.append((char) ch);
			rec_string = sb.toString();
			rd.close();
			urlconn.disconnect();
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
		return rec_string;
	}
	
	/**
	 * 是否局域网ip
	 * @param ip
	 * @return
	 */
	public static boolean isLocalIp(String ip) {
		//内网IP是以下面几个段开头的: 
		//10.x.x.x
		//192.168.x.x
		//172.16.x.x至172.31.x.x
		for (String ipStart : localIp) {
			if(ip.startsWith(ipStart)){//内网ip不检查
//				System.out.println("内网ip不检查:" + pa.ip);
				return true;
			}
		}
		
		return false;
	}
	
	/**
	 * getLocalHostName
	 * @return
	 */
	public static String getLocalHostName() {
		String hostName;
		try {
			InetAddress addr = InetAddress.getLocalHost();
			hostName = addr.getHostName();
		} catch (Exception ex) {
			hostName = "";
		}
		return hostName;
	}

	/**
	 * 获取本地所有ip,包括多网卡
	 * @return
	 */
	public static String[] getAllLocalHostIPv4() {
		System.out.println("开始获取ip地址:");
		List<String> ipList = new ArrayList<>();
		try {
			Enumeration<NetworkInterface> netInterfaces = NetworkInterface.getNetworkInterfaces();
		    while (netInterfaces.hasMoreElements()) {
		    	NetworkInterface ni = netInterfaces.nextElement();//网络接口
		    	if(ni.isLoopback() || ni.isPointToPoint() || !ni.isUp() || ni.isVirtual()){
		    		System.out.println("无效网卡:" + ni.getDisplayName() 
		    				+ ",isLoopback()=" + ni.isLoopback()
		    				+ ",isPointToPoint()=" + ni.isPointToPoint()
		    				+ ",isUp()=" + ni.isUp()
		    				+ ",isVirtual()=" + ni.isVirtual()
		    				);
		    		continue;
		    	}
//		        System.out.println("DisplayName:" + ni.getDisplayName());
//		        System.out.println("Name:" + ni.getName());  
		        Enumeration<InetAddress> ips = ni.getInetAddresses();
		        while (ips.hasMoreElements()) {
		        	InetAddress ip = ips.nextElement();
		        	if(isIpv6(ip)){
		        		continue;
		        	}
		        	ipList.add(ip.getHostAddress());
					System.out.println("ip=" + ip);
		        }  
		    }
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		String[] ret = null;
		if(ipList.size() > 0){
			ret = new String[ipList.size()];
			for (int i = 0; i < ret.length; i++) {
				ret[i] = ipList.get(i);
			}
		}else{
			System.out.println("获取ip地址失败!");
		}
		
		return ret;
	}

	/**
	 * 判断是不是ipv6
	 * @param ip
	 * @return
	 */
	private static boolean isIpv6(InetAddress ip) {
		return (ip instanceof Inet6Address);
	}

	public static void main(String[] args) {
//		System.out.println("ip=" + getIpInfo("121.14.199.236","city"));
		String[] ips = getAllLocalHostIPv4();
		if(ips != null){
			for (String ip : ips) {
				System.out.println("ip=" + ip);
			}
		}
	}

}
