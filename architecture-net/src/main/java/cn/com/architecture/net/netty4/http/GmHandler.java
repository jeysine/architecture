/**
 * @author like
 * @date 2011-3-8
 */
package cn.com.architecture.net.netty4.http;

import io.netty.buffer.ByteBuf;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.codec.http.FullHttpResponse;
import static io.netty.handler.codec.http.HttpResponseStatus.INTERNAL_SERVER_ERROR;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GmHandler implements IAdminHandler {

	private static final Logger logger = LoggerFactory
			.getLogger(GmHandler.class);

	@Override
	public void exec(FullHttpRequest request, FullHttpResponse response) {
		// TODO Auto-generated method stub
		ByteArrayOutputStream bos = null;
		ObjectOutputStream oos = null;
		try {
			ByteBuf cb = request.content();
			byte[] b = cb.array();
			ByteArrayInputStream bis = new ByteArrayInputStream(b);
			ObjectInputStream data = new ObjectInputStream(bis);
			String className = data.readUTF();
			String methodName = data.readUTF();
			int count = data.read();
			Class c = Class.forName(className);
			//#debug
			//System.out.println(className + "." + methodName);
			List<Class> cl = new ArrayList<Class>();
			List<Object> vl = new ArrayList<Object>();
			for (int i = 0; i < count ; i++) {
				cl.add((Class) data.readObject());
				vl.add(data.readObject());
			}
			Class[] cls = new Class[cl.size()];
			cl.toArray(cls);
			String mk = toMethodKey(className, methodName, cls);
			Method m = methods.get(mk);
			if (m == null) {
				m = c.getMethod(methodName, cls);
				methods.put(mk, m);
			}
			Object[] values = new Object[vl.size()];
			vl.toArray(values);
			Object o = m.invoke(c, values);
			bos = new ByteArrayOutputStream();
			oos = new ObjectOutputStream(bos);
			oos.writeObject(o);
			oos.flush();
			response.content().writeBytes(bos.toByteArray());
			cl.clear();
			vl.clear();
		} catch (Exception e) {
			e.printStackTrace();
			try {
				response.setStatus(INTERNAL_SERVER_ERROR);//.setStatus(HttpStatus.SC_INTERNAL_SERVER_ERROR);
				bos = new ByteArrayOutputStream();
				DataOutputStream dos = new DataOutputStream(bos);
				dos.writeUTF(e.getClass() + "." + e.getMessage());
				bos.flush();
				response.content().writeBytes(bos.toByteArray());
				bos.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} finally {
			if (oos != null)
				try {
					oos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}

	private static Map<String, Method> methods = new HashMap<String, Method>();

	public static String toMethodKey(String cl, String method, Class[] clas) {
		StringBuilder sb = new StringBuilder();
		sb.append(cl).append(".").append(method);
		for (Class c : clas) {
			sb.append(c.getName()).append(",");
		}
		String s = sb.toString();
		sb = null;
		return s;
	}

}
