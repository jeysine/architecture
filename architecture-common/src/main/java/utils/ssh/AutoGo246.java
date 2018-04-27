package utils.ssh;

import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.ChannelShell;
import utils.TimeWatcherUtils;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * 246
 * @author list 
 * 1.项目自动化打包 pack() 
 * 2.备份linux服务器的包 backup() 
 * 3.上传包到linux服务器 upload()
 * 4.自动解压 unzip()
 */
public class AutoGo246 {
	
	static String linuxRootPath = "/root/program/w3/";//linux根目录

	static String gamePath = linuxRootPath+"gameserver/";

	static String fightPath = linuxRootPath+"fightserver/";

	static String dbPath = linuxRootPath+"dbserver/";

	static String managerPath = linuxRootPath+"manageserver/";

	static String loginPath = linuxRootPath+"loginserver/";

	static String basePath = "E:\\pan\\work\\workSpace\\good_Eclipse44_w3\\";

	static String localExportBasePath = basePath + "export\\zip\\";

	static String host = "10.6.8.246";
	static int port = 22;
	static String username = "";
	static String password = "";

	static String gameZip = "gameserver.zip";

	static String fightZip = "fightserver.zip";

	static String dbZip = "dbserver.zip";

	static String loginZip = "loginserver.zip";

	static String managerZip = "manageserver.zip";

	static Map<String, String> pathMap = new HashMap<>();

	static TimeWatcherUtils timer = TimeWatcherUtils.getInstance();

	public static void main(String args[]) throws Exception {
		
		timer.setTimeType(TimeWatcherUtils.SEC);

		timer.func(() -> {
			pack();
		},"pack");// 打包
		
		timer.func(() -> {
			uploadFile();
		},"uploadFile");//上传文件

	}

	/**
	 * 上传文件
	 * @throws Exception
	 */
	public static void uploadFile() throws Exception {// 上传文件

//		ChannelSftp sftp = SFTPUtil.getInstance().connect(host, port, username,
//				password);
		
		ChannelSftp sftp = ShellUtil.connect(host, username,
				password,port,ChannelSftp.class);

		pathMap.put(gamePath, localExportBasePath + gameZip);// 游戏服

		pathMap.put(fightPath, localExportBasePath + fightZip);// 战斗服

		pathMap.put(dbPath, localExportBasePath + dbZip);// db服

		pathMap.put(managerPath, localExportBasePath + managerZip);// 管理服

		pathMap.put(loginPath, localExportBasePath + loginZip);// 登录服

		for (String linuxPath : pathMap.keySet()) {
			String localPath = pathMap.get(linuxPath);
			SFTPUtil.upload(linuxPath, localPath, sftp);
		}

		SFTPUtil.disConnect(sftp);

	}

	/**
	 * 打包
	 * @throws Exception
	 */
	public static void pack() throws Exception {// 打包
		String path = basePath + "package.bat";

		Runtime rt = Runtime.getRuntime();
		Process process = rt.exec("cmd /c start " + path);
		InputStream is = process.getInputStream();
		BufferedReader reader = new BufferedReader(new InputStreamReader(is));
		String line1;
		while ((line1 = reader.readLine()) != null) {
			System.out.println(line1);
		}
		process.waitFor();// 打包完毕
	}
	
	/**
	 * 测试指令
	 * @throws Exception
	 */
	public static void lsDir()throws Exception {
		ChannelShell shell = ShellUtil.connect(host, username, password, port,ChannelShell.class);
		
		CmdList cmdList = new CmdList();
		
		cmdList.cd(linuxRootPath)
					.ls()
					.exit();
		
		ShellUtil.exec(shell, cmdList.getCmds());

		ShellUtil.disConnect(shell);
		
	}

}
