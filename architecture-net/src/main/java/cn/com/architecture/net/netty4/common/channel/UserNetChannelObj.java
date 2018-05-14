package cn.com.architecture.net.netty4.common.channel;

import io.netty.channel.ChannelHandlerContext;

/**
 * 玩家连接描述对象,可以是远程网关也可以是游戏服本身有网关功能
 *
 * Created by li on 2018/5/13.
 */
public class UserNetChannelObj {
    private long channelId;//分配的网络链接id
    private long accountId;//对应登录的账号id
    private long createTime;//创建时间
    private String ip;//登录ip
    private int edition; 		// 版本号,暂时发:1000
    private int terminalType;//终端操作系统类型:客户端定义,区分安卓,ios等
    private String terminalInfo; //终端信息描述
    private String deviceName; //设备名
    private String deviceID; //设备ID
    private int areaId;//当前登录分区id
    private boolean isDead = false;//是否无效了
//    private INetActor actor;

    //网络对象
    private ChannelHandlerContext ctx;//tcp连接对象:游戏服本身有网关功能时,通过游戏服网关连接上来的连接

    public UserNetChannelObj(long channelId,String ip){
        this.channelId = channelId;
        this.ip = ip;
        this.createTime = System.currentTimeMillis();
        //this.actor = AkkaContext.createTypedActor(INetActor.class, NetActor.class);
    }

//    public void initClientInfo(net.good321.proto.CommonMsg.ClientInfo cf){
//        channel = cf.getChannel(); 		// 渠道号
//        subchannel = cf.getSubchannel();
//        language = cf.getLanguage();	// 语言版本:int LANG_ZHCN = 0;	// 中文-简体
//        edition = cf.getEdition(); 		// 版本号,暂时发:1000
//        terminalType = cf.getTerminalType();//终端操作系统类型:客户端定义,区分安卓,ios等
//        terminalInfo = cf.getTerminalInfo(); //终端信息描述
//        deviceName = cf.getDeviceName(); //设备名
//        deviceID = cf.getDeviceID(); //设备ID
//        gamecenterID = cf.getGamecenterID(); //ios的gamecenterID
//        gamecenterName = cf.getGamecenterName(); //ios的gamecenter昵称
//        udfa = cf.getUdfa(); // ios的广告参数
//        usedResourceVersion = cf.getUsedResourceVersion();//玩家资源版本号
//        adChannelId = cf.getAdChannel();
//        adSubChannelId = cf.getAdSubChannel();
//    }

//    public INetActor getActor() {
//        return actor;
//    }

//    public void stopAkkaActor() {
//        //停止AkkaContext
//        AkkaContext.stopTypedActor(actor);
//    }

    public long getChannelId() {
        return channelId;
    }

    public void setChannelId(long channelId) {
        this.channelId = channelId;
    }

    public long getAccountId() {
        return accountId;
    }

    public void setAccountId(long accountId) {
        this.accountId = accountId;
    }

    public long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public int getEdition() {
        return edition;
    }

    public void setEdition(int edition) {
        this.edition = edition;
    }

    public int getTerminalType() {
        return terminalType;
    }

    public void setTerminalType(int terminalType) {
        this.terminalType = terminalType;
    }

    public String getTerminalInfo() {
        return terminalInfo;
    }

    public void setTerminalInfo(String terminalInfo) {
        this.terminalInfo = terminalInfo;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public String getDeviceID() {
        return deviceID;
    }

    public void setDeviceID(String deviceID) {
        this.deviceID = deviceID;
    }

    public int getAreaId() {
        return areaId;
    }

    public void setAreaId(int areaId) {
        this.areaId = areaId;
    }

    public boolean isDead() {
        return isDead;
    }

    public void setDead(boolean isDead) {
        this.isDead = isDead;
    }

    /**
     * 踢下线
     */
    public void kickOut() {
        ctx.close();
    }

    public void pushBytes(byte[] sendBytes) {
        ctx.channel().writeAndFlush(sendBytes);
    }

    /**
     * 是否是本地网关对象
     * @return
     */
    public boolean isLocalChannel(){
        return ctx != null;
    }

    public void setChannelHandlerContext(ChannelHandlerContext ctx) {
        this.ctx = ctx;
    }

}
