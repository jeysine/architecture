package utils.ssh;

/**
 * cmd拼接工具类
 * @author Administrator
 *
 */
public class CmdUtil {
	
	public static String cd() {
		return "cd";
	}
	
	public static String cd(String path) {
		return "cd " + path;
	}

	public static String unZip(String zipName) {
		return "unzip -o " + zipName;
	}

	public static String exit() {
		return "exit";
	}
	
	public static String backUpZip(String zipName) {
		return "cp "+zipName+" "+zipName+".bak";
	}
	
	public static String ls(){
		return "ls";
	}

}
