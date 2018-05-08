package utils.akka;

/**
 * Created by lst on 2018/4/28.
 */
public class AkkaConstant {

    static String tcpHead = "akka.tcp://";

    public static String getServerUrl(String systemName,String ip,int port,String actorName){
        return getServerUrl(systemName,ip+":"+port,actorName);
    }

    public static String getServerUrl(String systemName,String host,String actorName){
        return tcpHead+systemName+"@"+host+"/user/"+actorName;
    }

}
