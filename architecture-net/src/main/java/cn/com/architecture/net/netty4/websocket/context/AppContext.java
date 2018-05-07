package cn.com.architecture.net.netty4.websocket.context;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * Spring ApplicationContext的初始化
 * Created by linchm on 2016/5/18.
 */
public class AppContext implements ApplicationContextAware {
    // App context
    public static final String APP_CONTEXT = "appContext";

    public static final String APP_SESSION = "appSession";

    public static final String JDBC_TEMPLATE = "jdbcTemplate";

    // Servers
    public static final String SERVER_MANAGER = "serverManager";
    public static final String WS_SERVER = "wsServer";
    public static final String TCP_SERVER = "tcpServer";
    public static final String HTTP_SERVER = "httpServer";
    public static final String FLASH_POLICY_SERVER = "flashPolicyServer";

    public static final String DATA_SERVICE = "dataService";
    public static final String DB_INCREMENT_SERVICE = "dbIncrementService";
    public static final String DAO_SERVICE = "daoService";
    public static final String LOOKUP_SERVICE = "lookUpService";
    public static final String PUBMAIL_SERVICE = "pubMailService";
    public static final String CAMP_SERVICE = "campService";
    public static final String GANG_SERVICE = "gangService";
    public static final String GUILD_SERVICE = "guildService";
    public static final String PLAYER_BASE_SERVICE = "playerBaseService";
    public static final String HOT_UPDATE = "hotUpdate";
    public static final String GOODS_SERVICE = "goodsService";
    public static final String EXRANK_SERVICE = "exRankService";
    public static final String RANK_BASE_SERVICE = "rankBaseService";
    public static final String MENTAL_RANK_SERVICE = "mentalRankService";

    // The spring application context.
    private static ApplicationContext applicationContext;

    private static boolean debug;
    private static String serverId;
    private static boolean httpSwitch;
    private static String secretKey;
    private static String url;
    private static String logTable;

    public static String getServerId() {
        return serverId;
    }
    public void setServerId(String serverId) {
        AppContext.serverId = serverId;
    }
    public static boolean getDebug() { return debug; }
    public void setDebug(boolean debug) {
        AppContext.debug = debug;
    }
    public static int getDebugInt() { return debug?1:0; }
    public static String getLogTable() {
        return logTable;
    }
    public void setLogTable(String logTable) {
        AppContext.logTable = logTable;
    }


    //
    public void setApplicationContext(ApplicationContext applicationContext)
            throws BeansException {
        AppContext.applicationContext = applicationContext;
//        daoService = (DAOService) getBean(AppContext.DAO_SERVICE);
    }

    /**
     * This method is used to retrieve a bean by its name. Note that this may
     * result in new bean creation if the scope is set to "prototype" in the
     * bean configuration file.
     *
     * @param beanName The name of the bean as configured in the spring configuration
     *                 file.
     * @return The bean if it is existing or null.
     */
    public static Object getBean(String beanName) {
        if (null == beanName) {
            return null;
        }
        return applicationContext.getBean(beanName);
    }


    /**
     * Called from the main method once the application is initialized. This
     * method is advised by aspectj which will in turn call the start method on
     *
     */
    public void initialized() {

    }

	/**
	 * @return the httpSwitch
	 */
	public static boolean isHttpSwitch() {
		return httpSwitch;
	}

	/**
	 * @param httpSwitch the httpSwitch to set
	 */
	public void setHttpSwitch(boolean httpSwitch) {
		AppContext.httpSwitch = httpSwitch;
	}

    public static String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        AppContext.secretKey = secretKey;
    }

    public static String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        AppContext.url = url;
    }

    public static long getPlayerInitId() {
        return Long.parseLong(serverId)*1000000;
    }
}
