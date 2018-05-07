package cn.com.architecture.net.netty4.websocket.context;

/**
 * 协议号定义规则：
 * 最高位： 为3时是服务器进程内部事件
 * 为1时是客户端发给服务器的协议
 * 为2时是对就的服务器发回客户端协议，
 * 比如请求登录 10001 对应返回的是20001
 * 不同系统： 高2位(除最高位外表示协议属于哪个业务系统) 10001(20001) 登录创角
 * 10101(20101) 角色信息 ...
 * Created by xuwenwu on 2017/2/27.
 */
public interface MsgConstant {
	//usr_defined start
	/**
 	 * 服务器进程内部协议
 	 */
	short S2P_TRANSMIT                = 30000; // 转发消息
	short P2P_WALK                    = 30001; // 玩家行走
	short P2M_ADD_AVATAR              = 30002; // 增加玩家
	short P2P_DEL_AVATAR              = 30003; // 减少玩家
	short P2P_WALK_SYNC               = 30004; // 玩家行走同步
    short P2P_TICK                    = 30005; // 发送同步
	short P2M_ADD_ACTOR               = 30006; // 增加Actor
	//usr_defined end

	//new_protocol
	/**  玩家登录  **/
	short REQ_LOGIN					= 10001;
	short RESP_LOGIN					= 20001;

	//new_protocol
	/**  创角  **/
	short REQ_CREATE_PLAYER					= 10002;
	short RESP_CREATE_PLAYER					= 20002;

	//new_protocol
	/**  进入游戏  **/
	short REQ_ENTER_GAME					= 10003;
	short RESP_ENTER_GAME					= 20003;

	//new_protocol
	/**  战斗模式切换  **/
	short REQ_CHANGE_PKMOD					= 10004;
	short RESP_CHANGE_PKMOD					= 20004;

	//new_protocol
	/**  同步时钟  **/
	short REQ_TIME_SYNC					= 10005;
	short RESP_TIME_SYNC					= 20005;

	//new_protocol
	/**  挂机离线受益  **/
	short REQ_OFFLINE_INCOME					= 10006;
	short RESP_OFFLINE_INCOME					= 20006;

	//new_protocol
	/**  账号登录测试  **/
	short REQ_LOGIN_CHECK					= 10007;
	short RESP_LOGIN_CHECK					= 20007;

	//new_protocol
	/**  重连  **/
	short REQ_RECONNECT					= 10008;
	short RESP_RECONNECT					= 20008;

	//new_protocol
	/**  战斗模式通知  **/
	short REQ_PKMOD_NOTICE					= 10009;
	short RESP_PKMOD_NOTICE					= 20009;

	//new_protocol
	/**  玩家登录  **/
	short REQ_LOGIN_INFO_DEBUG					= 10010;
	short RESP_LOGIN_INFO_DEBUG					= 20010;

	//new_protocol
	/**  测试DB  **/
	short REQ_TEST_DB					= 10011;
	short RESP_TEST_DB					= 20011;

	//new_protocol
	/**  挂机离线受益(每小时)  **/
	short REQ_OFFLINE_INCOME_INFO					= 10012;
	short RESP_OFFLINE_INCOME_INFO					= 20012;

	//new_protocol
	/**  作弊  **/
	short REQ_CHEAT					= 10013;
	short RESP_CHEAT					= 20013;

	//new_protocol
	/**  领取活动错失奖励  **/
	short REQ_ACTIVITY_REWARD_LOST_GET					= 10014;
	short RESP_ACTIVITY_REWARD_LOST_GET					= 20014;

	//new_protocol
	/**  改名  **/
	short REQ_CHANGE_NAME					= 10015;
	short RESP_CHANGE_NAME					= 20015;

	//new_protocol
	/**  直达创角  **/
	short REQ_CREATE_AND_LOGIN					= 10016;
	short RESP_CREATE_AND_LOGIN					= 20016;

	//new_protocol
	/**  AOI类  **/
	short REQ_AOI_MESSAGE					= 10100;
	short RESP_AOI_MESSAGE					= 20100;

	//new_protocol
	/**  进入场景  **/
	short REQ_ENTER_SCENE					= 10101;
	short RESP_ENTER_SCENE					= 20101;

	//new_protocol
	/**  场景行走  **/
	short REQ_WALK_SCENE					= 10102;
	short RESP_WALK_SCENE					= 20102;

	//new_protocol
	/**  离开场景  **/
	short REQ_LEAVE_SCENE					= 10103;
	short RESP_LEAVE_SCENE					= 20103;

	//new_protocol
	/**  行走同步  **/
	short REQ_WALK_SYNC					= 10104;
	short RESP_WALK_SYNC					= 20104;

	//new_protocol
	/**  行走停止  **/
	short REQ_WALK_STOP					= 10105;
	short RESP_WALK_STOP					= 20105;

	//new_protocol
	/**  更新场景动态数据  **/
	short REQ_UPDATE_SCENE_DYNDATA					= 10106;
	short RESP_UPDATE_SCENE_DYNDATA					= 20106;

	//new_protocol
	/**  玩家更改外形  **/
	short REQ_CHANGE_MODEL					= 10107;
	short RESP_CHANGE_MODEL					= 20107;

	//new_protocol
	/**  玩家更改速度  **/
	short REQ_CHANGE_SPEED					= 10108;
	short RESP_CHANGE_SPEED					= 20108;

	//new_protocol
	/**  进入场景确认  **/
	short REQ_ENTER_CONFIRM					= 10109;
	short RESP_ENTER_CONFIRM					= 20109;

	//new_protocol
	/**  获取玩家的坐标  **/
	short REQ_PLAYER_POSITION					= 10110;
	short RESP_PLAYER_POSITION					= 20110;

	//new_protocol
	/**  移除  **/
	short REQ_REMOVE_AVATAR					= 10111;
	short RESP_REMOVE_AVATAR					= 20111;

	//new_protocol
	/**  Avatar死亡  **/
	short REQ_AVATAR_DIE					= 10112;
	short RESP_AVATAR_DIE					= 20112;

	//new_protocol
	/**  外形隐藏OR显示  **/
	short REQ_MODEL_HIDE					= 10113;
	short RESP_MODEL_HIDE					= 20113;

	//new_protocol
	/**  刷新buff  **/
	short REQ_BUFF_INFOS					= 10114;
	short RESP_BUFF_INFOS					= 20114;

	//new_protocol
	/**  切线  **/
	short REQ_CHANGE_LINE					= 10115;
	short RESP_CHANGE_LINE					= 20115;

	//new_protocol
	/**  显示当前地图所有线  **/
	short REQ_SHOW_LINE					= 10116;
	short RESP_SHOW_LINE					= 20116;

	//new_protocol
	/**  查看玩家信息  **/
	short REQ_CHECK_PLAYER_INFO					= 10120;
	short RESP_CHECK_PLAYER_INFO					= 20120;

	//new_protocol
	/**  攻击  **/
	short REQ_ATTACK					= 10200;
	short RESP_ATTACK					= 20200;

	//new_protocol
	/**  攻击准备  **/
	short REQ_ATTACK_READY					= 10201;
	short RESP_ATTACK_READY					= 20201;

	//new_protocol
	/**  受击数据  **/
	short REQ_HIT_DATA					= 10202;
	short RESP_HIT_DATA					= 20202;

	//new_protocol
	/**  buff伤害  **/
	short REQ_BUFF_HIT					= 10203;
	short RESP_BUFF_HIT					= 20203;

	//new_protocol
	/**  地图boss信息  **/
	short REQ_BOSS_SCENE_INFO					= 10301;
	short RESP_BOSS_SCENE_INFO					= 20301;

	//new_protocol
	/**  boss疲劳  **/
	short REQ_BOSS_FATIGUE					= 10302;
	short RESP_BOSS_FATIGUE					= 20302;

	//new_protocol
	/**  boss击杀信息  **/
	short REQ_BOSS_KILL_INFO					= 10303;
	short RESP_BOSS_KILL_INFO					= 20303;

	//new_protocol
	/**  关注  **/
	short REQ_BOSS_ATTENTION					= 10304;
	short RESP_BOSS_ATTENTION					= 20304;

	//new_protocol
	/**  关注信息  **/
	short REQ_BOSS_ATTENTION_LIST					= 10305;
	short RESP_BOSS_ATTENTION_LIST					= 20305;

	//new_protocol
	/**  击杀奖励数据  **/
	short REQ_BOSS_KILL_REWARD_LIST					= 10306;
	short RESP_BOSS_KILL_REWARD_LIST					= 20306;

	//new_protocol
	/**  蛮荒禁地信息  **/
	short REQ_WILD_INFO					= 10307;
	short RESP_WILD_INFO					= 20307;

	//new_protocol
	/**  BOSS复活通知  **/
	short REQ_BOSS_REBORN_NOTICE					= 10308;
	short RESP_BOSS_REBORN_NOTICE					= 20308;

	//new_protocol
	/**  进入boss地图  **/
	short REQ_BOSS_CHALLENGE					= 10311;
	short RESP_BOSS_CHALLENGE					= 20311;

	//new_protocol
	/**  蛮荒禁地进入  **/
	short REQ_WILD_ENTER					= 10312;
	short RESP_WILD_ENTER					= 20312;

	//new_protocol
	/**  boss归属  **/
	short REQ_BOSS_OWNER					= 10321;
	short RESP_BOSS_OWNER					= 20321;

	//new_protocol
	/**  蛮荒怒气变化通知  **/
	short REQ_WILD_ANGER_NOTICE					= 10322;
	short RESP_WILD_ANGER_NOTICE					= 20322;

	//new_protocol
	/**  复活  **/
	short REQ_REVIVE					= 10401;
	short RESP_REVIVE					= 20401;

	//new_protocol
	/**  采集  **/
	short REQ_COLLECT					= 10402;
	short RESP_COLLECT					= 20402;

	//new_protocol
	/**  完成采集  **/
	short REQ_COMPLETE_COLLECT					= 10403;
	short RESP_COMPLETE_COLLECT					= 20403;

	//new_protocol
	/**  境界升级  **/
	short REQ_STATE_UP_LEVEL					= 10404;
	short RESP_STATE_UP_LEVEL					= 20404;

	//new_protocol
	/**  小飞鞋  **/
	short REQ_FLY_SHOES					= 10405;
	short RESP_FLY_SHOES					= 20405;

	//new_protocol
	/**  邮件列表  **/
	short REQ_MAIL_LIST					= 10501;
	short RESP_MAIL_LIST					= 20501;

	//new_protocol
	/**  读邮件  **/
	short REQ_MAIL_READ					= 10502;
	short RESP_MAIL_READ					= 20502;

	//new_protocol
	/**  收取邮件附件  **/
	short REQ_MAIL_EXTRACT					= 10503;
	short RESP_MAIL_EXTRACT					= 20503;

	//new_protocol
	/**  发邮件  **/
	short REQ_MAIL_SEND					= 10504;
	short RESP_MAIL_SEND					= 20504;

	//new_protocol
	/**  删除邮件  **/
	short REQ_MAIL_DELETE					= 10505;
	short RESP_MAIL_DELETE					= 20505;

	//new_protocol
	/**  邮件提醒  **/
	short REQ_MAIL_NOTICE					= 10506;
	short RESP_MAIL_NOTICE					= 20506;

	//new_protocol
	/**  收取邮件附件  **/
	short REQ_MAIL_ALL_EXTRACT					= 10507;
	short RESP_MAIL_ALL_EXTRACT					= 20507;

	//new_protocol
	/**  删除全部邮件  **/
	short REQ_MAIL_ALL_DELETE					= 10508;
	short RESP_MAIL_ALL_DELETE					= 20508;

	//new_protocol
	/**  屏幕中央广播  **/
	short REQ_CHAT_RADIATE					= 10601;
	short RESP_CHAT_RADIATE					= 20601;

	//new_protocol
	/**  聊天  **/
	short REQ_CHAT					= 10602;
	short RESP_CHAT					= 20602;

	//new_protocol
	/**  频道广播  **/
	short REQ_CHAT_BROADCAST					= 10603;
	short RESP_CHAT_BROADCAST					= 20603;

	//new_protocol
	/**  频道聊天  **/
	short REQ_CHAT_BYCHANNEL					= 10604;
	short RESP_CHAT_BYCHANNEL					= 20604;

	//new_protocol
	/**  打开私聊  **/
	short REQ_CHAT_OPEN					= 10605;
	short RESP_CHAT_OPEN					= 20605;

	//new_protocol
	/**  系统公告  **/
	short REQ_CHAT_SYS_BULLETIN					= 10606;
	short RESP_CHAT_SYS_BULLETIN					= 20606;

	//new_protocol
	/**  打开背包  **/
	short REQ_BAG_OPEN					= 10701;
	short RESP_BAG_OPEN					= 20701;

	//new_protocol
	/**  使用道具  **/
	short REQ_BAG_USE_ITEM					= 10702;
	short RESP_BAG_USE_ITEM					= 20702;

	//new_protocol
	/**  出售道具  **/
	short REQ_BAG_SELL_ITEM					= 10703;
	short RESP_BAG_SELL_ITEM					= 20703;

	//new_protocol
	/**  背包通知  **/
	short REQ_BAG_NOTICE					= 10704;
	short RESP_BAG_NOTICE					= 20704;

	//new_protocol
	/**  快速购买  **/
	short REQ_BAG_BUY					= 10705;
	short RESP_BAG_BUY					= 20705;

	//new_protocol
	/**  物品合成  **/
	short REQ_BAG_COMPOSE					= 10706;
	short RESP_BAG_COMPOSE					= 20706;

	//new_protocol
	/**  物品分解  **/
	short REQ_BAG_DECOMPOSE					= 10707;
	short RESP_BAG_DECOMPOSE					= 20707;

	//new_protocol
	/**  元宝转绑元  **/
	short REQ_BAG_CHANGE_CCY					= 10708;
	short RESP_BAG_CHANGE_CCY					= 20708;

	//new_protocol
	/**  加格子  **/
	short REQ_BAG_ADD_GRID					= 10709;
	short RESP_BAG_ADD_GRID					= 20709;

	//new_protocol
	/**  掉落  **/
	short REQ_BAG_DROP					= 10710;
	short RESP_BAG_DROP					= 20710;

	//new_protocol
	/**  获取宝箱信息  **/
	short REQ_BAG_BOX_INFO					= 10711;
	short RESP_BAG_BOX_INFO					= 20711;

	//new_protocol
	/**  开启背包宝箱  **/
	short REQ_BAG_BOX_OPEN					= 10712;
	short RESP_BAG_BOX_OPEN					= 20712;

	//new_protocol
	/**  整理背包  **/
	short REQ_BAG_COLLECT					= 10713;
	short RESP_BAG_COLLECT					= 20713;

	//new_protocol
	/**  移动背包  **/
	short REQ_BAG_MOVE					= 10714;
	short RESP_BAG_MOVE					= 20714;

	//new_protocol
	/**  打开背包仓库  **/
	short REQ_BAG_POT_OPEN					= 10715;
	short RESP_BAG_POT_OPEN					= 20715;

	//new_protocol
	/**  移动背包仓库  **/
	short REQ_BAG_POT_MOVE					= 10716;
	short RESP_BAG_POT_MOVE					= 20716;

	//new_protocol
	/**  整理背包  **/
	short REQ_BAG_POT_COLLECT					= 10717;
	short RESP_BAG_POT_COLLECT					= 20717;

	//new_protocol
	/**  背包到仓库  **/
	short REQ_BAG_POT_ADD					= 10718;
	short RESP_BAG_POT_ADD					= 20718;

	//new_protocol
	/**  仓库到背包  **/
	short REQ_BAG_POT_DELETE					= 10719;
	short RESP_BAG_POT_DELETE					= 20719;



	//new_protocol
	/**  开启可选择道具的宝箱  **/
	short REQ_BAG_CHOOSE_BOX_OPEN					= 10720;
	short RESP_BAG_CHOOSE_BOX_OPEN					= 20720;

	//new_protocol
	/**  使用红包道具  **/
	short REQ_BAG_RED_USE					= 10721;
	short RESP_BAG_RED_USE					= 20721;

	//new_protocol
	/**  强化  **/
	short REQ_EQUIP_STRENGTHUP					= 10801;
	short RESP_EQUIP_STRENGTHUP					= 20801;

	//new_protocol
	/**  镶嵌  **/
	short REQ_EQUIP_STONEUP					= 10802;
	short RESP_EQUIP_STONEUP					= 20802;

	//new_protocol
	/**  装备替换  **/
	short REQ_EQUIP_REPLACE					= 10805;
	short RESP_EQUIP_REPLACE					= 20805;

	//new_protocol
	/**  装备列表  **/
	short REQ_EQUIP_LIST					= 10806;
	short RESP_EQUIP_LIST					= 20806;

	//new_protocol
	/**  装备卸下  **/
	short REQ_EQUIP_REMOVE					= 10807;
	short RESP_EQUIP_REMOVE					= 20807;

	//new_protocol
	/**  成长目标信息  **/
	short REQ_GROW_GOAL_INFO					= 10811;
	short RESP_GROW_GOAL_INFO					= 20811;

	//new_protocol
	/**  宝石卸下  **/
	short REQ_EQUIP_STONE_REMOVE					= 10812;
	short RESP_EQUIP_STONE_REMOVE					= 20812;

	//new_protocol
	/**  装备合成  **/
	short REQ_EQUIP_COMPOSE					= 10813;
	short RESP_EQUIP_COMPOSE					= 20813;

	//new_protocol
	/**  装备合成可消耗装备  **/
	short REQ_EQUIP_COMPOSECANEXPENDLIST					= 10814;
	short RESP_EQUIP_COMPOSECANEXPENDLIST					= 20814;

	//new_protocol
	/**  装备洗练开孔  **/
	short REQ_EQUIP_CLEAR_OPEN					= 10815;
	short RESP_EQUIP_CLEAR_OPEN					= 20815;

	//new_protocol
	/**  当前强化熟练度  **/
	short REQ_STRENGTH_EXP					= 10816;
	short RESP_STRENGTH_EXP					= 20816;

	//new_protocol
	/**  当日洗练次数  **/
	short REQ_CLEAR_COUNT					= 10817;
	short RESP_CLEAR_COUNT					= 20817;

	//new_protocol
	/**  装备洗练  **/
	short REQ_EQUIP_CLEAR					= 10818;
	short RESP_EQUIP_CLEAR					= 20818;

	//new_protocol
	/**  装备套装锻造  **/
	short REQ_EQUIP_SUIT_FORGE					= 10820;
	short RESP_EQUIP_SUIT_FORGE					= 20820;

	//new_protocol
	/**  守护续费  **/
	short REQ_GUARD_RENEW					= 10821;
	short RESP_GUARD_RENEW					= 20821;

	//new_protocol
	/**  宝石精炼  **/
	short REQ_EQUIP_REFINE					= 10822;
	short RESP_EQUIP_REFINE					= 20822;

	//new_protocol
	/**  技能列表  **/
	short REQ_SKILL_LIST					= 10901;
	short RESP_SKILL_LIST					= 20901;

	//new_protocol
	/**  新技能  **/
	short REQ_SKILL_NEW					= 10902;
	short RESP_SKILL_NEW					= 20902;

    //new_protocol
    /**  交换技能位置  **/
    short REQ_SKILL_SWAP					= 10904;
    short RESP_SKILL_SWAP					= 20904;

    //new_protocol
    /**  被动技能列表  **/
    short REQ_PASSIVE_SKILL_LIST					= 10905;
    short RESP_PASSIVE_SKILL_LIST					= 20905;

	//new_protocol
	/**  玩家keyvalue信息更新  **/
	short REQ_KEYVALUE_UPDATE					= 11001;
	short RESP_KEYVALUE_UPDATE					= 21001;

	//new_protocol
	/**  玩家获得奖励弹窗  **/
	short REQ_REWARD_NOTICE					= 11002;
	short RESP_REWARD_NOTICE					= 21002;

	//new_protocol
	/**  属性更新  **/
	short REQ_ATTR_UPDATE					= 11003;
	short RESP_ATTR_UPDATE					= 21003;

	//new_protocol
	/**  加成属性更新  **/
	short REQ_ADDITION_UPDATE					= 11004;
	short RESP_ADDITION_UPDATE					= 21004;

	//new_protocol
	/**  延迟奖励弹窗  **/
	short REQ_DELAY_REWARD_NOTICE					= 11005;
	short RESP_DELAY_REWARD_NOTICE					= 21005;

	//new_protocol
	/**  玩家巅峰竞技信息  **/
	short REQ_PEAK_INFO					= 11101;
	short RESP_PEAK_INFO					= 21101;

	//new_protocol
	/**  领取段位奖励  **/
	short REQ_PEAK_GET_RANK_REWARD					= 11102;
	short RESP_PEAK_GET_RANK_REWARD					= 21102;

	//new_protocol
	/**  领取段位奖励  **/
	short REQ_PEAK_GET_DAILY_REWARD					= 11103;
	short RESP_PEAK_GET_DAILY_REWARD					= 21103;

	//new_protocol
	/**  开始匹配  **/
	short REQ_PEAK_FIGHT					= 11104;
	short RESP_PEAK_FIGHT					= 21104;

	//new_protocol
	/**  战斗结果  **/
	short REQ_PEAK_RESULT					= 11105;
	short RESP_PEAK_RESULT					= 21105;

	//new_protocol
	/**  匹配成功  **/
	short REQ_PEAK_MATCHED					= 11106;
	short RESP_PEAK_MATCHED					= 21106;

	//new_protocol
	/**  进入战斗场景  **/
	short REQ_PEAK_ENTER					= 11107;
	short RESP_PEAK_ENTER					= 21107;

	//new_protocol
	/**  积分排行  **/
	short REQ_PEAK_RANK_LIST					= 11108;
	short RESP_PEAK_RANK_LIST					= 21108;

	//new_protocol
	/**  青云之颠进入  **/
	short REQ_BLUE_CLOUD_ENTER					= 11201;
	short RESP_BLUE_CLOUD_ENTER					= 21201;

	//new_protocol
	/**  青云之颠积分通知  **/
	short REQ_BLUE_CLOUD_SCORE_NOTICE					= 11202;
	short RESP_BLUE_CLOUD_SCORE_NOTICE					= 21202;

	//new_protocol
	/**  仙盟晚宴问题推送  **/
	short REQ_PARTY_QUESTION_PUSH					= 11301;
	short RESP_PARTY_QUESTION_PUSH					= 21301;

	//new_protocol
	/**  仙盟答题信息推送  **/
	short REQ_PARTY_INFO_PUSH					= 11302;
	short RESP_PARTY_INFO_PUSH					= 21302;

	//new_protocol
	/**  仙盟答题加分推送  **/
	short REQ_PARTY_SCORE_ADD					= 11303;
	short RESP_PARTY_SCORE_ADD					= 21303;

	//new_protocol
	/**  进入仙盟晚宴  **/
	short REQ_PARTY_ENTER					= 11304;
	short RESP_PARTY_ENTER					= 21304;

	//new_protocol
	/**  领取烧猪  **/
	short REQ_PARTY_GET_PIG					= 11305;
	short RESP_PARTY_GET_PIG					= 21305;

	//new_protocol
	/**  仙盟晚宴当前累计奖励  **/
	short REQ_PARTY_REWARD_INFO					= 11306;
	short RESP_PARTY_REWARD_INFO					= 21306;

	//new_protocol
	/**  查看符文信息  **/
	short REQ_RUNE_CHECK					= 11501;
	short RESP_RUNE_CHECK					= 21501;

	//new_protocol
	/**  符文镶嵌  **/
	short REQ_RUNE_SET					= 11502;
	short RESP_RUNE_SET					= 21502;

	//new_protocol
	/**  符文升级  **/
	short REQ_RUNE_UP_LEVEL					= 11503;
	short RESP_RUNE_UP_LEVEL					= 21503;

	//new_protocol
	/**  符文兑换  **/
	short REQ_RUNE_EXCHANGE					= 11504;
	short RESP_RUNE_EXCHANGE					= 21504;

	//new_protocol
	/**  符文分解  **/
	short REQ_RUNE_DECOMPOSE					= 11505;
	short RESP_RUNE_DECOMPOSE					= 21505;

	//new_protocol
	/**  符文添加  **/
	short REQ_RUNE_ADD					= 11506;
	short RESP_RUNE_ADD					= 21506;

    //new_protocol
    /**  转职升阶  **/
    short REQ_STAGE_UP					= 11601;
    short RESP_STAGE_UP					= 21601;

    //new_protocol
    /**  转职升阶通知  **/
    short REQ_TRANSFER_NOTICE					= 11602;
    short RESP_TRANSFER_NOTICE					= 21602;

	//new_protocol
	/**  竞技场信息  **/
	short REQ_ARENA_INFO					= 11701;
	short RESP_ARENA_INFO					= 21701;

	//new_protocol
	/**  竞技场挑战开始  **/
	short REQ_ARENA_START					= 11703;
	short RESP_ARENA_START					= 21703;

	//new_protocol
	/**  购买挑战次数  **/
	short REQ_BUY_TIMES					= 11706;
	short RESP_BUY_TIMES					= 21706;

	//new_protocol
	/**  竞技场鼓励  **/
	short REQ_ARENA_ENCOURAGE					= 11709;
	short RESP_ARENA_ENCOURAGE					= 21709;

	//new_protocol
	/**  竞技场刷新  **/
	short REQ_ARENA_REFRESH					= 11710;
	short RESP_ARENA_REFRESH					= 21710;

    //new_protocol
    /**  在售道具列表  **/
    short REQ_MARKET_ITEM_LIST					= 11801;
    short RESP_MARKET_ITEM_LIST					= 21801;

    //new_protocol
    /**  搜索道具  **/
    short REQ_SEARCH_ITEM					= 11802;
    short RESP_SEARCH_ITEM					= 21802;

    //new_protocol
    /**  购买道具  **/
    short REQ_BUY_MARKET_ITEM					= 11803;
    short RESP_BUY_MARKET_ITEM					= 21803;

    //new_protocol
    /**  在售物品  **/
    short REQ_ONSALE_ITEMS					= 11804;
    short RESP_ONSALE_ITEMS					= 21804;

    //new_protocol
    /**  出售物品  **/
    short REQ_TOSALE_ITEMS					= 11805;
    short RESP_TOSALE_ITEMS					= 21805;

    //new_protocol
    /**  交易记录列表  **/
    short REQ_DEAL_RECORDS					= 11806;
    short RESP_DEAL_RECORDS					= 21806;

    //new_protocol
    /**  手动下架物品  **/
    short REQ_OFFSALE_ITEMS					= 11807;
    short RESP_OFFSALE_ITEMS					= 21807;

    //new_protocol
    /**  符文寻宝  **/
    short REQ_TREASURE_RUNE					= 11901;
    short RESP_TREASURE_RUNE					= 21901;

    //new_protocol
    /**  符文寻宝信息  **/
    short REQ_RUNE_INFO					= 11902;
    short RESP_RUNE_INFO					= 21902;

    //new_protocol
    /**  装备寻宝  **/
    short REQ_TREASURE_EQUIP					= 11903;
    short RESP_TREASURE_EQUIP					= 21903;

    //new_protocol
    /**  个人纪录  **/
    short REQ_PERSONAL_RECORD					= 11904;
    short RESP_PERSONAL_RECORD					= 21904;

    //new_protocol
    /**  全服记录  **/
    short REQ_ALL_RECORD					= 11905;
    short RESP_ALL_RECORD					= 21905;

    //new_protocol
    /**  积分兑换道具  **/
    short REQ_POINT_EXCHANGE					= 11906;
    short RESP_POINT_EXCHANGE					= 21906;

    //new_protocol
    /**  巅峰寻宝  **/
    short REQ_TREASURE_TOP					= 11907;
    short RESP_TREASURE_TOP					= 21907;

	//new_protocol
	/**  寻宝仓库取出  **/
	short REQ_TREASURE_DEPOT_GET					= 11930;
	short RESP_TREASURE_DEPOT_GET					= 21930;

	//new_protocol
	/**  寻宝仓库信息  **/
	short REQ_TREASURE_DEPOT_INFO					= 11931;
	short RESP_TREASURE_DEPOT_INFO					= 21931;

    //new_protocol
    /**  获得冲级豪礼信息  **/
    short REQ_LEVELUP_GIFT_INFO					= 12001;
    short RESP_LEVELUP_GIFT_INFO					= 22001;

    //new_protocol
    /**  领取冲级豪礼  **/
    short REQ_LEVELUP_GIFT_OPEN					= 12002;
    short RESP_LEVELUP_GIFT_OPEN					= 22002;

    //new_protocol
    /**  每日累充信息  **/
    short REQ_RECHARGE_DAILY_INFO					= 12101;
    short RESP_RECHARGE_DAILY_INFO					= 22101;

    //new_protocol
    /**  领取累充奖励  **/
    short REQ_RECHARGE_DAILY_OPEN					= 12102;
    short RESP_RECHARGE_DAILY_OPEN					= 22102;

    //new_protocol
    /**  开服7日充值  **/
    short REQ_RECHARGE_OPENSERVER_INFO					= 12103;
    short RESP_RECHARGE_OPENSERVER_INFO					= 22103;

    //new_protocol
    /**  领取开服7日充值奖励  **/
    short REQ_RECHARGE_OPENSERVER_GET					= 12104;
    short RESP_RECHARGE_OPENSERVER_GET					= 22104;

    //new_protocol
    /**  绑元礼包剩余可领取天数  **/
    short REQ_RECHARGE_CCY_BIND					= 12105;
    short RESP_RECHARGE_CCY_BIND					= 22105;

    //new_protocol
	/**  主线完成任务  **/
	short REQ_TASK_COMPLETE					= 12201;
	short RESP_TASK_COMPLETE					= 22201;

	//new_protocol
	/**  主线支线任务  **/
	short REQ_TASK_BRANCH_COMPLETE					= 12202;
	short RESP_TASK_BRANCH_COMPLETE					= 22202;

	//new_protocol
	/**  赏金任务完成  **/
	short REQ_TASK_BOUNTY_COMPLETE					= 12203;
	short RESP_TASK_BOUNTY_COMPLETE					= 22203;

	//new_protocol
	/**  日常任务完成  **/
	short REQ_TASK_DAILY_COMPLETE					= 12204;
	short RESP_TASK_DAILY_COMPLETE					= 22204;

	//new_protocol
	/**  日常活跃度升级  **/
	short REQ_TASK_ACTIVITY					= 12205;
	short RESP_TASK_ACTIVITY					= 22205;

	//new_protocol
	/**  玩家任务信息  **/
	short REQ_TASK_INFO					= 12206;
	short RESP_TASK_INFO					= 22206;

	//new_protocol
	/**  日常任务找回经验  **/
	short REQ_TASK_BACK					= 12207;
	short RESP_TASK_BACK					= 22207;

	//new_protocol
	/**  完成新手引导  **/
	short REQ_TASK_GUIDE					= 12208;
	short RESP_TASK_GUIDE					= 22208;

	//new_protocol
	/**  客户端进度  **/
	short REQ_TASK_CLIENT_SCHEDULE					= 12209;
	short RESP_TASK_CLIENT_SCHEDULE					= 22209;

	//new_protocol
	/**  完成新手引导  **/
	short REQ_TASK_GUIDE_DOT					= 12210;
	short RESP_TASK_GUIDE_DOT					= 22210;

	//new_protocol
	/**  日常积分奖励  **/
	short REQ_TASK_DAILY_PROCESS					= 12212;
	short RESP_TASK_DAILY_PROCESS					= 22212;

	//new_protocol
	/**  日常任务找回信息  **/
	short REQ_TASK_BACK_INFO					= 12213;
	short RESP_TASK_BACK_INFO					= 22213;

	//new_protocol
	/**  日常任务找回奖励  **/
	short REQ_TASK_SHAPE_CHANGE					= 12214;
	short RESP_TASK_SHAPE_CHANGE					= 22214;

	//new_protocol
	/**  元宝一键完成  **/
	short REQ_TASK_CCYB_DONE					= 12215;
	short RESP_TASK_CCYB_DONE					= 22215;

	//new_protocol
	/**  客户端进度单独taskID  **/
	short REQ_TASK_CLIENT_SCHEDULE_SINGLE					= 12216;
	short RESP_TASK_CLIENT_SCHEDULE_SINGLE					= 22216;

	//new_protocol
	/**  转生任务完成  **/
	short REQ_TASK_TRANSFER_COMPLETE					= 12217;
	short RESP_TASK_TRANSFER_COMPLETE					= 22217;

	//new_protocol
	/**  接护送任务  **/
	short REQ_TASK_BEAUTY_ACCEPET					= 12218;
	short RESP_TASK_BEAUTY_ACCEPET					= 22218;

	//new_protocol
	/**  护送美女完成  **/
	short REQ_TASK_BEAUTY_COMPLETE					= 12219;
	short RESP_TASK_BEAUTY_COMPLETE					= 22219;

	//new_protocol
	/**  仙盟捐献任务  **/
	short REQ_BLOC_DONATE_TASK_COMPLETE					= 12220;
	short RESP_BLOC_DONATE_TASK_COMPLETE					= 22220;

	//new_protocol
	/**  限时活动开启通知  **/
	short REQ_DAILY_OPEN_NOTICE					= 12221;
	short RESP_DAILY_OPEN_NOTICE					= 22221;

	//new_protocol
	/**  空请求  **/
	short REQ_EMPTY_REQUEST					= 12222;
	short RESP_EMPTY_REQUEST					= 22222;

	//new_protocol
	/**  获取任务  **/
	short REQ_GET_TASK					= 12223;
	short RESP_GET_TASK					= 22223;

	//new_protocol
	/**  获取结婚系统信息  **/
	short REQ_MARRY_SYS_INFO					= 12301;
	short RESP_MARRY_SYS_INFO					= 22301;

	//new_protocol
	/**  结婚系统提亲信息  **/
	short REQ_MARRY_SYS_PROPOSE_INFO					= 12302;
	short RESP_MARRY_SYS_PROPOSE_INFO					= 22302;

	//new_protocol
	/**  结婚系统发送提亲  **/
	short REQ_MARRY_SYS_PROPOSE_SEND					= 12303;
	short RESP_MARRY_SYS_PROPOSE_SEND					= 22303;

	//new_protocol
	/**  结婚系统接受提亲  **/
	short REQ_MARRY_SYS_PROPOSE_RECEIVE					= 12304;
	short RESP_MARRY_SYS_PROPOSE_RECEIVE					= 22304;

	//new_protocol
	/**  结婚系统婚期预约信息  **/
	short REQ_MARRY_SYS_APPOINT_INFO					= 12305;
	short RESP_MARRY_SYS_APPOINT_INFO					= 22305;

	//new_protocol
	/**  结婚系统婚期预约选择  **/
	short REQ_MARRY_SYS_APPOINT_MAKE					= 12306;
	short RESP_MARRY_SYS_APPOINT_MAKE					= 22306;

	//new_protocol
	/**  结婚系统宾客邀请信息  **/
	short REQ_MARRY_SYS_INVITE_INFO					= 12307;
	short RESP_MARRY_SYS_INVITE_INFO					= 22307;

	//new_protocol
	/**  结婚系统发送宾客邀请  **/
	short REQ_MARRY_SYS_INVITE_SEND					= 12308;
	short RESP_MARRY_SYS_INVITE_SEND					= 22308;

	//new_protocol
	/**  结婚系统提亲结果  **/
	short REQ_MARRY_SYS_PROPOSE_RESULT					= 12309;
	short RESP_MARRY_SYS_PROPOSE_RESULT					= 22309;

	//new_protocol
	/**  结婚系统推送提亲信息  **/
	short REQ_MARRY_SYS_PROPOSE_PUSH					= 12310;
	short RESP_MARRY_SYS_PROPOSE_PUSH					= 22310;

	//new_protocol
	/**  婚期预约信息,有人预约时间时主动推送  **/
	short REQ_MARRY_SYS_APPOINT_PUSH					= 12311;
	short RESP_MARRY_SYS_APPOINT_PUSH					= 22311;

	//new_protocol
	/**  结婚系统离婚  **/
	short REQ_MARRY_SYS_DIVORCE					= 12312;
	short RESP_MARRY_SYS_DIVORCE					= 22312;

	//new_protocol
	/**  宴会推送  **/
	short REQ_MARRY_INS_NOTICE					= 12320;
	short RESP_MARRY_INS_NOTICE					= 22320;

	//new_protocol
	/**  宴会入口信息  **/
	short REQ_MARRY_INS_ENTRY_INFO					= 12321;
	short RESP_MARRY_INS_ENTRY_INFO					= 22321;

	//new_protocol
	/**  索取请柬  **/
	short REQ_MARRY_INS_ASK_FOR_CARD					= 12322;
	short RESP_MARRY_INS_ASK_FOR_CARD					= 22322;

	//new_protocol
	/**  参与宴会  **/
	short REQ_MARRY_INS_JOIN_PARTY					= 12323;
	short RESP_MARRY_INS_JOIN_PARTY					= 22323;

	//new_protocol
	/**  送花  **/
	short REQ_MARRY_INS_SEND_FLOWER					= 12324;
	short RESP_MARRY_INS_SEND_FLOWER					= 22324;

	//new_protocol
	/**  场景内申请人的信息  **/
	short REQ_MARRY_INS_GUEST_INFO					= 12325;
	short RESP_MARRY_INS_GUEST_INFO					= 22325;

	//new_protocol
	/**  宾客管理  **/
	short REQ_MARRY_INS_GUEST_HANDLE					= 12326;
	short RESP_MARRY_INS_GUEST_HANDLE					= 22326;

	//new_protocol
	/**  宾客邀请次数购买  **/
	short REQ_MARRY_INS_GUEST_BUY					= 12327;
	short RESP_MARRY_INS_GUEST_BUY					= 22327;

	//new_protocol
	/**  婚礼祝福信息  **/
	short REQ_MARRY_BLESS_INFO					= 12340;
	short RESP_MARRY_BLESS_INFO					= 22340;

	//new_protocol
	/**  婚礼祝福  **/
	short REQ_MARRY_BLESS					= 12341;
	short RESP_MARRY_BLESS					= 22341;

	//new_protocol
	/**  仙缘信息  **/
	short REQ_LOVER_INFO					= 12401;
	short RESP_LOVER_INFO					= 22401;

	//new_protocol
	/**  仙缘等级升级  **/
	short REQ_LOVER_LEVEL_UP					= 12402;
	short RESP_LOVER_LEVEL_UP					= 22402;

	//new_protocol
	/**  仙缘称号信息  **/
	short REQ_LOVER_TITLE_INFO					= 12403;
	short RESP_LOVER_TITLE_INFO					= 22403;

	//new_protocol
	/**  仙缘称号领取  **/
	short REQ_LOVER_TITLE_REC					= 12404;
	short RESP_LOVER_TITLE_REC					= 22404;

	//new_protocol
	/**  仙缘副本信息  **/
	short REQ_LOVER_INS_INFO					= 12405;
	short RESP_LOVER_INS_INFO					= 22405;

	//new_protocol
	/**  仙缘副本抽奖  **/
	short REQ_LOVER_INS_LUCK					= 12406;
	short RESP_LOVER_INS_LUCK					= 22406;

	//new_protocol
	/**  仙缘副本抽奖通知  **/
	short REQ_LOVER_INS_LUCK_NOTICE					= 12407;
	short RESP_LOVER_INS_LUCK_NOTICE					= 22407;

	//new_protocol
	/**  仙缘副本邀请挑战  **/
	short REQ_LOVER_INS_INVITE					= 12408;
	short RESP_LOVER_INS_INVITE					= 22408;

	//new_protocol
	/**  仙缘副本被邀请挑战通知  **/
	short REQ_LOVER_INS_INVITE_NOTICE					= 12409;
	short RESP_LOVER_INS_INVITE_NOTICE					= 22409;

	//new_protocol
	/**  仙缘副本进入挑战  **/
	short REQ_LOVER_INS_ENTER					= 12410;
	short RESP_LOVER_INS_ENTER					= 22410;

	//new_protocol
	/**  购买仙缘副本挑战次数  **/
	short REQ_LOVER_BUY_TIMES					= 12411;
	short RESP_LOVER_BUY_TIMES					= 22411;

	//new_protocol
	/**  仙缘副本离开挑战  **/
	short REQ_LOVER_INS_LEAVE					= 12413;
	short RESP_LOVER_INS_LEAVE					= 22413;

	//new_protocol
	/**  仙缘副本抽奖双倍通知  **/
	short REQ_LOVER_INS_LUCK_DOUBLE					= 12414;
	short RESP_LOVER_INS_LUCK_DOUBLE					= 22414;

	//new_protocol
	/**  仙缘副本击杀怪物数量  **/
	short REQ_LOVER_INS_KILL_MONSTER_NUM					= 12419;
	short RESP_LOVER_INS_KILL_MONSTER_NUM					= 22419;

	//new_protocol
	/**  仙娃信息  **/
	short REQ_BABY_INFO					= 12450;
	short RESP_BABY_INFO					= 22450;

	//new_protocol
	/**  仙娃激活  **/
	short REQ_BABY_ACTIVATE					= 12451;
	short RESP_BABY_ACTIVATE					= 22451;

	//new_protocol
	/**  仙娃升级  **/
	short REQ_BABY_UP_LEVEL					= 12452;
	short RESP_BABY_UP_LEVEL					= 22452;

	//new_protocol
	/**  购买宝匣  **/
	short REQ_TREASURE_BOX_BUY					= 12453;
	short RESP_TREASURE_BOX_BUY					= 22453;

	//new_protocol
	/**  宝匣领取  **/
	short REQ_TREASURE_BOX_GET					= 12454;
	short RESP_TREASURE_BOX_GET					= 22454;

	//new_protocol
	/**  请求仙侣购买宝匣  **/
	short REQ_TREASURE_BOX_BUY_APPLY					= 12455;
	short RESP_TREASURE_BOX_BUY_APPLY					= 22455;

	//new_protocol
	/**  宝匣购买请求推送  **/
	short REQ_TREASURE_BOX_BUY_APPLY_PUSH					= 12456;
	short RESP_TREASURE_BOX_BUY_APPLY_PUSH					= 22456;

	//new_protocol
	/**  宝匣信息  **/
	short REQ_TREASURE_BOX_INFO					= 12457;
	short RESP_TREASURE_BOX_INFO					= 22457;

	/**  请求对方购买仙缘副本  **/
	short REQ_LOVER_ASK_BUY					= 12415;
	short RESP_LOVER_ASK_BUY					= 22415;

	//new_protocol
	/**  仙侣请求自己购买仙缘副本  **/
	short REQ_LOVER_ASK_BUY_NOTICE					= 12416;
	short RESP_LOVER_ASK_BUY_NOTICE					= 22416;

	//new_protocol
	/**  邀请异性好友仙缘组队  **/
	short REQ_LOVER_INS_INVITE_FRIEND					= 12417;
	short RESP_LOVER_INS_INVITE_FRIEND					= 22417;

	//new_protocol
	/**  邀请伴侣仙缘组队  **/
	short REQ_LOVER_INS_INVITE_LOVER					= 12418;
	short RESP_LOVER_INS_INVITE_LOVER					= 22418;

	//new_protocol
	/**  冲榜活动信息  **/
	short REQ_FLUSH_LIST_INFO					= 12501;
	short RESP_FLUSH_LIST_INFO					= 22501;

	//new_protocol
	/**  冲榜活动排行榜信息  **/
	short REQ_FLUSH_LIST_RANK_INFO					= 12502;
	short RESP_FLUSH_LIST_RANK_INFO					= 22502;

	//new_protocol
	/**  领取冲榜奖励  **/
	short REQ_FLUSH_LIST_GET					= 12503;
	short RESP_FLUSH_LIST_GET					= 22503;

	//new_protocol
	/**  寻宝积分信息  **/
	short REQ_TREASURE_POINT_INFO					= 12504;
	short RESP_TREASURE_POINT_INFO					= 22504;

	//new_protocol
	/**  获取寻宝积分奖励  **/
	short REQ_GET_TREASURE_POINT_REWARD					= 12505;
	short RESP_GET_TREASURE_POINT_REWARD					= 22505;

	//new_protocol
	/**  七日活动信息  **/
	short REQ_SEVEN_DAY_INFO					= 12506;
	short RESP_SEVEN_DAY_INFO					= 22506;

	//new_protocol
	/**  获取七日活动奖励  **/
	short REQ_RECEIVE_SEVEN_DAY_REWARD					= 12507;
	short RESP_RECEIVE_SEVEN_DAY_REWARD					= 22507;

	//new_protocol
	/**  购买七日活动商品  **/
	short REQ_BUY_SEVEN_DAY_GOODS					= 12508;
	short RESP_BUY_SEVEN_DAY_GOODS					= 22508;

	//new_protocol
	/**  经验本信息  **/
	short REQ_EXP_INS_INFO					= 13001;
	short RESP_EXP_INS_INFO					= 23001;

    //new_protocol
    /**  仙帝宝库  **/
    short REQ_XDBK_INFO					= 13007;
    short RESP_XDBK_INFO					= 23007;

    //new_protocol
    /**  守护仙灵  **/
    short REQ_SHXL_INFO					= 13008;
    short RESP_SHXL_INFO					= 23008;

    //new_protocol
    /**  诛仙塔  **/
    short REQ_ZXTOWER_INFO					= 13009;
    short RESP_ZXTOWER_INFO					= 23009;

    //new_protocol
    /**  扫荡副本  **/
    short REQ_CLEAR_CHALLENGE					= 13010;
    short RESP_CLEAR_CHALLENGE					= 23010;

	//new_protocol
	/**  副本挑战  **/
	short REQ_INS_CHALLENGE					= 13011;
	short RESP_INS_CHALLENGE					= 23011;

	//new_protocol
	/**  获取随机数列表  **/
	short REQ_ENTER_SINGLE_RANDS					= 13012;
	short RESP_ENTER_SINGLE_RANDS					= 23012;

	//new_protocol
	/**  玩家属性  **/
	short REQ_REFRESH_ACTOR					= 13013;
	short RESP_REFRESH_ACTOR					= 23013;

	//new_protocol
	/**  刷新副本怪物  **/
	short REQ_REFRESH_SCENE_ACTOR					= 13014;
	short RESP_REFRESH_SCENE_ACTOR					= 23014;

	//new_protocol
	/**  副本剩余时间  **/
	short REQ_INS_LEFT_TIME					= 13015;
	short RESP_INS_LEFT_TIME					= 23015;

	//new_protocol
	/**  boss出现通知  **/
	short REQ_BOSS_APPEAR					= 13016;
	short RESP_BOSS_APPEAR					= 23016;

	//new_protocol
	/**  副本挑战结果  **/
	short REQ_RESULT_CHALLENGE					= 13017;
	short RESP_RESULT_CHALLENGE					= 23017;

	//new_protocol
	/**  退出副本(单人本和多人本)  **/
	short REQ_EXIT_SINGLE_INS					= 13018;
	short RESP_EXIT_SINGLE_INS					= 23018;

	//new_protocol
	/**  购买次数  **/
	short REQ_BUY_SINGLE_INS_NUM					= 13019;
	short RESP_BUY_SINGLE_INS_NUM					= 23019;

	//new_protocol
	/**  当前波数  **/
	short REQ_CUR_BATCH					= 13020;
	short RESP_CUR_BATCH					= 23020;

	//new_protocol
	/**  攻打副本怪物,验证技能的CD时间  **/
	short REQ_FIGHT_SINGLE_SCENEACTOR					= 13021;
	short RESP_FIGHT_SINGLE_SCENEACTOR					= 23021;

	//new_protocol
	/**  杀死副本目标  **/
	short REQ_KILL_SINGLE_SCENEACTOR					= 13022;
	short RESP_KILL_SINGLE_SCENEACTOR					= 23022;

	//new_protocol
	/**  鼓舞  **/
	short REQ_INSPIRE					= 13023;
	short RESP_INSPIRE					= 23023;

	//new_protocol
	/**  总经验  **/
	short REQ_TOTLE_EXP					= 13024;
	short RESP_TOTLE_EXP					= 23024;

	//new_protocol
	/**  清副本cd  **/
	short REQ_CLEAR_CD					= 13025;
	short RESP_CLEAR_CD					= 23025;

	//new_protocol
	/**  最后获取的经验  **/
	short REQ_LAST_TOTLE_EXP					= 13026;
	short RESP_LAST_TOTLE_EXP					= 23026;

	//new_protocol
	/**  商店列表  **/
	short REQ_SHOP_LIST					= 13101;
	short RESP_SHOP_LIST					= 23101;

	//new_protocol
	/**  购买商品  **/
	short REQ_BUG_GOODS					= 13102;
	short RESP_BUG_GOODS					= 23102;

	/**  查看宠骑信息  **/
	short REQ_PET_LIST					= 13307;
	short RESP_PET_LIST					= 23307;


	//new_protocol
	/**  宠骑换皮肤  **/
	short REQ_CHANGE_SKIN					= 13309;
	short RESP_CHANGE_SKIN					= 23309;

	//new_protocol
	/**  宠骑增加经验  **/
	short REQ_PET_ADD_BLESS					= 13310;
	short RESP_PET_ADD_BLESS					= 23310;

	//new_protocol
	/**  宠物吃装备  **/
	short REQ_EAT_EQUIP					= 13311;
	short RESP_EAT_EQUIP					= 23311;

	//new_protocol
	/**  宠骑增加丹药  **/
	short REQ_PET_ADD_PANACEA					= 13312;
	short RESP_PET_ADD_PANACEA					= 23312;

	//new_protocol
	/**  祝福类信息  **/
	short REQ_PET_CHECK					= 13313;
	short RESP_PET_CHECK					= 23313;

	//new_protocol
	/**  宠骑幻化激活  **/
	short REQ_PET_ILLUSION_ACTIVE					= 13314;
	short RESP_PET_ILLUSION_ACTIVE					= 23314;

	//new_protocol
	/**  宠骑幻化激活  **/
	short REQ_PET_ILLUSION_ADD_BLESS					= 13315;
	short RESP_PET_ILLUSION_ADD_BLESS					= 23315;

	//new_protocol
	/**  祝福幻化激活  **/
	short REQ_BLESS_ILLUSION_ACTIVE					= 13316;
	short RESP_BLESS_ILLUSION_ACTIVE					= 23316;

	//new_protocol
	/**  宠骑幻化激活  **/
	short REQ_BLESS_ILLUSION_UP_LEVEL					= 13317;
	short RESP_BLESS_ILLUSION_UP_LEVEL					= 23317;

	//new_protocol
	/**  宠骑祝福幻化信息  **/
	short REQ_PET_ILLUSION_INFO					= 13318;
	short RESP_PET_ILLUSION_INFO					= 23318;

	//new_protocol
	/**  打开好友界面  **/
	short REQ_FRIEND_OPEN					= 13401;
	short RESP_FRIEND_OPEN					= 23401;

	//new_protocol
	/**  好友登录推送  **/
	short REQ_FRIEND_LOGIN_NOTICE					= 13402;
	short RESP_FRIEND_LOGIN_NOTICE					= 23402;

	//new_protocol
	/**  读聊天  **/
	short REQ_FRIEND_READ_CHAT					= 13403;
	short RESP_FRIEND_READ_CHAT					= 23403;

	//new_protocol
	/**  发聊天  **/
	short REQ_FRIEND_SEND_CHAT					= 13404;
	short RESP_FRIEND_SEND_CHAT					= 23404;

	//new_protocol
	/**  搜索  **/
	short REQ_FRIEND_SEARCH					= 13405;
	short RESP_FRIEND_SEARCH					= 23405;

	//new_protocol
	/**  获取申请列表  **/
	short REQ_FRIEND_APPLY_LIST					= 13406;
	short RESP_FRIEND_APPLY_LIST					= 23406;

	//new_protocol
	/**  获取推荐列表  **/
	short REQ_FRIEND_RECOMMEND					= 13407;
	short RESP_FRIEND_RECOMMEND					= 23407;

	//new_protocol
	/**  申请好友  **/
	short REQ_FRIEND_APPLY					= 13408;
	short RESP_FRIEND_APPLY					= 23408;

	//new_protocol
	/**  处理好友申请  **/
	short REQ_FRIEND_DEAL_APPLY					= 13409;
	short RESP_FRIEND_DEAL_APPLY					= 23409;

	//new_protocol
	/**  删除好友  **/
	short REQ_FRIEND_DELETE					= 13410;
	short RESP_FRIEND_DELETE					= 23410;

	//new_protocol
	/**  拉黑  **/
	short REQ_FRIEND_BLACK					= 13411;
	short RESP_FRIEND_BLACK					= 23411;

	//new_protocol
	/**  取消拉黑  **/
	short REQ_FRIEND_CANCEL_BLACK					= 13412;
	short RESP_FRIEND_CANCEL_BLACK					= 23412;

	//new_protocol
	/**  好友状态改变推送  **/
	short REQ_FRIEND_STATE_NOTICE					= 13413;
	short RESP_FRIEND_STATE_NOTICE					= 23413;

	//new_protocol
	/**  单条好友完整信息推送  **/
	short REQ_FRIEND_INFO_NOTICE					= 13414;
	short RESP_FRIEND_INFO_NOTICE					= 23414;

	//new_protocol
	/**  赠送好友花朵  **/
	short REQ_FRIEND_SENDING_FLOWERS					= 13415;
	short RESP_FRIEND_SENDING_FLOWERS					= 23415;

	//new_protocol
	/**  获赠好友花朵  **/
	short REQ_FRIEND_GET_FLOWERS					= 13416;
	short RESP_FRIEND_GET_FLOWERS					= 23416;

	//new_protocol
	/**  回吻  **/
	short REQ_FRIEND_THINK_FLOWERS					= 13417;
	short RESP_FRIEND_THINK_FLOWERS					= 23417;

	//new_protocol
	/**  移除仇人  **/
	short REQ_FRIEND_REMOVE_ENEMY					= 13418;
	short RESP_FRIEND_REMOVE_ENEMY					= 23418;

	//new_protocol
	/**  赠送花朵全服通知  **/
	short REQ_SENDING_FLOWERS_NOTICE					= 13419;
	short RESP_SENDING_FLOWERS_NOTICE					= 23419;

	//new_protocol
	/**  排行榜  **/
	short REQ_RANKING					= 13501;
	short RESP_RANKING					= 23501;



	//new_protocol
	/**  装备本信息  **/
	short REQ_EQUIP_INS_INFO					= 13601;
	short RESP_EQUIP_INS_INFO					= 23601;

	//new_protocol
	/**  开启副本  **/
	short REQ_OPEN_INS					= 13602;
	short RESP_OPEN_INS					= 23602;

	//new_protocol
	/**  副本确认状态通知  **/
	short REQ_CONFIRM_NOTICE					= 13603;
	short RESP_CONFIRM_NOTICE					= 23603;

	//new_protocol
	/**  副本确认  **/
	short REQ_INS_CONFIRM					= 13604;
	short RESP_INS_CONFIRM					= 23604;

	//new_protocol
	/**  装备副本结果  **/
	short REQ_RESULT_EQUIP_INS					= 13605;
	short RESP_RESULT_EQUIP_INS					= 23605;

	//new_protocol
	/**  副本剩余时间通知  **/
	short REQ_INS_REMAIN_TIME					= 13606;
	short RESP_INS_REMAIN_TIME					= 23606;

	//new_protocol
	/**  称号信息  **/
	short REQ_TITLE_INFO					= 13801;
	short RESP_TITLE_INFO					= 23801;

	//new_protocol
	/**  称号激活  **/
	short REQ_TITLE_ACTIVATE					= 13802;
	short RESP_TITLE_ACTIVATE					= 23802;

	//new_protocol
	/**  称号幻化  **/
	short REQ_TITLE_WEAR					= 13803;
	short RESP_TITLE_WEAR					= 23803;

	//new_protocol
	/**  时装信息  **/
	short REQ_FASHION_INFO					= 13901;
	short RESP_FASHION_INFO					= 23901;


	//new_protocol
	/**  时装幻化  **/
	short REQ_FASHION_WEAR					= 13903;
	short RESP_FASHION_WEAR					= 23903;

	//new_protocol
	/**  时装脱下  **/
	short REQ_FASHION_TAKE_OFF					= 13904;
	short RESP_FASHION_TAKE_OFF					= 23904;

	//new_protocol
	/**  时装激活  **/
	short REQ_FASHION_DECOMPOSE					= 13905;
	short RESP_FASHION_DECOMPOSE					= 23905;

	//new_protocol
	/**  时装升星  **/
	short REQ_FASHION_UP_STAR					= 13906;
	short RESP_FASHION_UP_STAR					= 23906;

	//new_protocol
	/**  时装升级  **/
	short REQ_FASHION_UP_LEVEL					= 13907;
	short RESP_FASHION_UP_LEVEL					= 23907;

	//new_protocol
	/**  获得签到信息  **/
	short REQ_SIGN_INFO					= 14301;
	short RESP_SIGN_INFO					= 24301;

	//new_protocol
	/**  签到操作  **/
	short REQ_TO_SIGN					= 14302;
	short RESP_TO_SIGN					= 24302;

	//new_protocol
	/**  领取连续签到奖励  **/
	short REQ_SIGN_SERIES_GET					= 14303;
	short RESP_SIGN_SERIES_GET					= 24303;

	//new_protocol
	/**  公告奖励领取信息  **/
	short REQ_NOTICE_REWARD_INFO					= 14304;
	short RESP_NOTICE_REWARD_INFO					= 24304;

	//new_protocol
	/**  公告奖励领取  **/
	short REQ_NOTICE_REWARD_GET					= 14305;
	short RESP_NOTICE_REWARD_GET					= 24305;

	//new_protocol
	/**  获取登陆奖励信息  **/
	short REQ_LOGIN_REWARD_INFO					= 14501;
	short RESP_LOGIN_REWARD_INFO					= 24501;

	//new_protocol
	/**  领取登陆奖励礼包  **/
	short REQ_LOGIN_REWARD_GET					= 14502;
	short RESP_LOGIN_REWARD_GET					= 24502;

	//new_protocol
	/**  获取月卡信息  **/
	short REQ_MONTH_CARD_INFO					= 14701;
	short RESP_MONTH_CARD_INFO					= 24701;

	//new_protocol
	/**  购买月卡  **/
	short REQ_MONTH_CARD_BUY					= 14702;
	short RESP_MONTH_CARD_BUY					= 24702;

	//new_protocol
	/**  领取月卡奖励  **/
	short REQ_MONTH_CARD_GET					= 14703;
	short RESP_MONTH_CARD_GET					= 24703;

	//new_protocol
	/**  获取首充信息  **/
	short REQ_FIRST_RECHARGE_INFO					= 14801;
	short RESP_FIRST_RECHARGE_INFO					= 24801;

	//new_protocol
	/**  领取首充奖励  **/
	short REQ_FIRST_RECHARGE_GET					= 14802;
	short RESP_FIRST_RECHARGE_GET					= 24802;

    //new_protocol
    /**  领取超值首充奖励  **/
    short REQ_FIRST_WORTH_RECHARGE_GET					= 14803;
    short RESP_FIRST_WORTH_RECHARGE_GET					= 24803;

	//new_protocol
	/**  仙盟信息  **/
	short REQ_BLOC_INFO					= 15101;
	short RESP_BLOC_INFO					= 25101;

	//new_protocol
	/**  仙盟列表  **/
	short REQ_BLOC_LIST					= 15102;
	short RESP_BLOC_LIST					= 25102;

	//new_protocol
	/**  创建仙盟  **/
	short REQ_CREATE_BLOC					= 15103;
	short RESP_CREATE_BLOC					= 25103;

	//new_protocol
	/**  申请加入仙盟  **/
	short REQ_APPLY_BLOC					= 15104;
	short RESP_APPLY_BLOC					= 25104;


	//new_protocol
	/**  申请处理  **/
	short REQ_APPLY_DEAL					= 15106;
	short RESP_APPLY_DEAL					= 25106;

	//new_protocol
	/**  搜索仙盟  **/
	short REQ_SEARCH_BLOC					= 15107;
	short RESP_SEARCH_BLOC					= 25107;

	//new_protocol
	/**  成员列表  **/
	short REQ_MEMBER_LIST					= 15109;
	short RESP_MEMBER_LIST					= 25109;

	//new_protocol
	/**  捐献列表  **/
	short REQ_DONATE_LOG					= 15110;
	short RESP_DONATE_LOG					= 25110;

	//new_protocol
	/**  任免副盟  **/
	short REQ_APPOINT_VICE					= 15111;
	short RESP_APPOINT_VICE					= 25111;

	//new_protocol
	/**  离开联盟  **/
	short REQ_LEAVE_BLOC					= 15112;
	short RESP_LEAVE_BLOC					= 25112;

	//new_protocol
	/**  转让盟主  **/
	short REQ_TRANSFER_BLOC					= 15113;
	short RESP_TRANSFER_BLOC					= 25113;


	//new_protocol
	/**  仙盟申请列表  **/
	short REQ_APPLY_LIST					= 15115;
	short RESP_APPLY_LIST					= 25115;

	//new_protocol
	/**  修改公告  **/
	short REQ_CHANGE_NOTICE					= 15116;
	short RESP_CHANGE_NOTICE					= 25116;

	//new_protocol
	/**  仙盟申请列表红点  **/
	short REQ_APPLY_RED					= 15119;
	short RESP_APPLY_RED					= 25119;

	//new_protocol
	/**  一键申请处理  **/
	short REQ_APPLY_DEAL_AKEY					= 15120;
	short RESP_APPLY_DEAL_AKEY					= 25120;

	//new_protocol
	/**  仙盟技能信息  **/
	short REQ_BLOC_SKILL_INFO					= 15121;
	short RESP_BLOC_SKILL_INFO					= 25121;

	//new_protocol
	/**  仙盟技能升级  **/
	short REQ_BLOC_SKILL_LEVELUP					= 15122;
	short RESP_BLOC_SKILL_LEVELUP					= 25122;

	//new_protocol
	/**  仙盟红包推送  **/
	short REQ_BLOC_RED_PUSH					= 15123;
	short RESP_BLOC_RED_PUSH					= 25123;

	//new_protocol
	/**  仙盟红包领取  **/
	short REQ_BLOC_RED_GET					= 15124;
	short RESP_BLOC_RED_GET					= 25124;

	//new_protocol
	/**  仙盟升级  **/
	short REQ_BLOC_UP_LEVEL					= 15125;
	short RESP_BLOC_UP_LEVEL					= 25125;

	//new_protocol
	/**  仙盟升级  **/
	short REQ_BLOC_SETTING					= 15126;
	short RESP_BLOC_SETTING					= 25126;

	//new_protocol
	/**  仙盟工资领取  **/
	short REQ_BLOC_WAGES					= 15127;
	short RESP_BLOC_WAGES					= 25127;

	//new_protocol
	/**  仙盟申请设置信息  **/
	short REQ_BLOC_SETTING_INFO					= 15128;
	short RESP_BLOC_SETTING_INFO					= 25128;

	//new_protocol
	/**  仙盟变更  **/
	short REQ_BLOC_CHANGE					= 15129;
	short RESP_BLOC_CHANGE					= 25129;

	//new_protocol
	/**  职位变更  **/
	short REQ_POSITION_CHANGE					= 15130;
	short RESP_POSITION_CHANGE					= 25130;

	//new_protocol
	/**  兽粮上交  **/
	short REQ_BLOC_FOOD_SUBMIT					= 15131;
	short RESP_BLOC_FOOD_SUBMIT					= 25131;

	//new_protocol
	/**  仙盟boss开启  **/
	short REQ_BLOC_BOSS_OPEN					= 15132;
	short RESP_BLOC_BOSS_OPEN					= 25132;

	//new_protocol
	/**  仙盟boss通知  **/
	short REQ_BLOC_BOSS_NOTICE					= 15133;
	short RESP_BLOC_BOSS_NOTICE					= 25133;

	//new_protocol
	/**  仙盟boss通知  **/
	short REQ_BLOC_BOSS_ENTER					= 15134;
	short RESP_BLOC_BOSS_ENTER					= 25134;

	//new_protocol
	/**  仙盟boss信息  **/
	short REQ_BLOC_BOSS_INFO					= 15135;
	short RESP_BLOC_BOSS_INFO					= 25135;


	//new_protocol
	/**  仙盟boss剩余时间通知  **/
	short REQ_BLOC_BOSS_REMAIN_TIME					= 15136;
	short RESP_BLOC_BOSS_REMAIN_TIME					= 25136;

	//new_protocol
	/**  仙盟红包列表  **/
	short REQ_BLOC_RED_LIST					= 15150;
	short RESP_BLOC_RED_LIST					= 25150;

	//new_protocol
	/**  仙盟红包明细  **/
	short REQ_BLOC_RED_DETAIL					= 15151;
	short RESP_BLOC_RED_DETAIL					= 25151;

	//new_protocol
	/**  仙盟红包推送  **/
	short REQ_BLOC_RED_SEND					= 15152;
	short RESP_BLOC_RED_SEND					= 25152;

	//new_protocol
	/**  v6发红包  **/
	short REQ_VIP_SEND_RED					= 15153;
	short RESP_VIP_SEND_RED					= 25153;

	//new_protocol
	/**  仙盟仓库信息  **/
	short REQ_BLOC_DEPOT_INFO					= 15160;
	short RESP_BLOC_DEPOT_INFO					= 25160;

	//new_protocol
	/**  仙盟捐献  **/
	short REQ_BLOC_DONATE					= 15161;
	short RESP_BLOC_DONATE					= 25161;

	//new_protocol
	/**  仙盟仓库积分兑换  **/
	short REQ_DEPOT_SCORE_EXCHANGE					= 15162;
	short RESP_DEPOT_SCORE_EXCHANGE					= 25162;

	//new_protocol
	/**  仙盟装备销毁  **/
	short REQ_BLOC_EQUIP_DESTROY					= 15163;
	short RESP_BLOC_EQUIP_DESTROY					= 25163;

	//new_protocol
	/**  仙盟仓库道具添加通知  **/
	short REQ_BLOC_DEPOT_ADD_NOTICE					= 15164;
	short RESP_BLOC_DEPOT_ADD_NOTICE					= 25164;

	//new_protocol
	/**  仙盟仓库道具移除通知  **/
	short REQ_BLOC_DEPOT_REMOVE_NOTICE					= 15165;
	short RESP_BLOC_DEPOT_REMOVE_NOTICE					= 25165;

	//new_protocol
	/**  获取投资计划信息  **/
	short REQ_INVEST_PLAN_INFO					= 15301;
	short RESP_INVEST_PLAN_INFO					= 25301;

	//new_protocol
	/**  领取投资计划奖励  **/
	short REQ_INVEST_PLAN_GET					= 15302;
	short RESP_INVEST_PLAN_GET					= 25302;

	//new_protocol
	/**  购买投资计划  **/
	short REQ_INVEST_PLAN_BUY					= 15303;
	short RESP_INVEST_PLAN_BUY					= 25303;

	//new_protocol
	/**  豪礼活动通知  **/
	short REQ_ACT_GIFT_NOTICE					= 15304;
	short RESP_ACT_GIFT_NOTICE					= 25304;

	//new_protocol
	/**  领取激活码  **/
	short REQ_ACTIVE_CODE_GET					= 15401;
	short RESP_ACTIVE_CODE_GET					= 25401;

	//new_protocol
	/**  领取平台礼包  **/
	short REQ_CHANNEL_GIFT_GET					= 15402;
	short RESP_CHANNEL_GIFT_GET					= 25402;

	//new_protocol
	/**  vip信息  **/
	short REQ_VIP_INFO					= 15501;
	short RESP_VIP_INFO					= 25501;

	//new_protocol
	/**  获得等级礼包信息  **/
	short REQ_LEVEL_REWARD_INFO					= 15701;
	short RESP_LEVEL_REWARD_INFO					= 25701;

	//new_protocol
	/**  领取等级礼包  **/
	short REQ_LEVEL_REWARD_GET					= 15702;
	short RESP_LEVEL_REWARD_GET					= 25702;

	//new_protocol
	/**  获得连续累充信息  **/
	short REQ_SERIES_RECHARGE_INFO					= 15801;
	short RESP_SERIES_RECHARGE_INFO					= 25801;

	//new_protocol
	/**  获取连续累充奖励  **/
	short REQ_SERIES_RECHARGE_GET					= 15802;
	short RESP_SERIES_RECHARGE_GET					= 25802;

	//new_protocol
	/**  获取鉴宝信息  **/
	short REQ_CHESS_BOARD_INFO					= 16401;
	short RESP_CHESS_BOARD_INFO					= 26401;

	//new_protocol
	/**  抛骰子  **/
	short REQ_CHESS_BOARD_PLAY					= 16402;
	short RESP_CHESS_BOARD_PLAY					= 26402;

	//new_protocol
	/**  开启宝箱  **/
	short REQ_CHESS_BOARD_OPEN					= 16403;
	short RESP_CHESS_BOARD_OPEN					= 26403;

	//new_protocol
	/**  立刻开启宝箱  **/
	short REQ_CHESS_BOARD_USE					= 16404;
	short RESP_CHESS_BOARD_USE					= 26404;

	//new_protocol
	/**  获得奖励提示  **/
	short REQ_CHESS_BOARD_NOTICE					= 16405;
	short RESP_CHESS_BOARD_NOTICE					= 26405;

	//new_protocol
	/**  成就信息  **/
	short REQ_ACHIEVEMENT_INFO					= 16701;
	short RESP_ACHIEVEMENT_INFO					= 26701;

	//new_protocol
	/**  获取成就奖励  **/
	short REQ_GET_ACHIEVEMENT_AWARD					= 16702;
	short RESP_GET_ACHIEVEMENT_AWARD					= 26702;

	//new_protocol
	/**  刷新成就种类  **/
	short REQ_ACHIEVEMENT_REFRESH					= 16703;
	short RESP_ACHIEVEMENT_REFRESH					= 26703;

	//new_protocol
	/**  节日活动开启  **/
	short REQ_FESTIVAL_ACT_NOTICE					= 17001;
	short RESP_FESTIVAL_ACT_NOTICE					= 27001;

	//new_protocol
	/**  获取某活动信息  **/
	short REQ_FESTIVAL_ACT_INFO					= 17002;
	short RESP_FESTIVAL_ACT_INFO					= 27002;

	//new_protocol
	/**  领取某活动奖励  **/
	short REQ_FESTIVAL_ACT_REWARD					= 17003;
	short RESP_FESTIVAL_ACT_REWARD					= 27003;

	//new_protocol
	/**  答题信息  **/
	short REQ_EXAM_INFO					= 17501;
	short RESP_EXAM_INFO					= 27501;

	//new_protocol
	/**  交答案  **/
	short REQ_EXAM_ANSWER					= 17502;
	short RESP_EXAM_ANSWER					= 27502;

	//new_protocol
	/**  使用答题道具  **/
	short REQ_EXAM_ITEM_USE					= 17503;
	short RESP_EXAM_ITEM_USE					= 27503;

	//new_protocol
	/**  祈福信息  **/
	short REQ_PRAY_INFO					= 17601;
	short RESP_PRAY_INFO					= 27601;

	//new_protocol
	/**  获取祈福奖励  **/
	short REQ_PRAY_GET					= 17602;
	short RESP_PRAY_GET					= 27602;

	//new_protocol
	/**  天书寻主信息  **/
	short REQ_BOOK_INFO					= 17701;
	short RESP_BOOK_INFO					= 27701;

	//new_protocol
	/**  领取天书寻主奖励  **/
	short REQ_BOOK_RECEIVE					= 17702;
	short RESP_BOOK_RECEIVE					= 27702;

	//new_protocol
	/**  开服狂欢信息  **/
	short REQ_SERVER_OPEN_INFO					= 17801;
	short RESP_SERVER_OPEN_INFO					= 27801;

	//new_protocol
	/**  获取开宗立派奖励  **/
	short REQ_CREATE_BLOC_RECEIVE					= 17802;
	short RESP_CREATE_BLOC_RECEIVE					= 27802;

	//new_protocol
	/**  获取集字活动奖励  **/
	short REQ_COLLEC_RECEIVE					= 17803;
	short RESP_COLLEC_RECEIVE					= 27803;

	//new_protocol
	/**  个人Boss信息  **/
	short REQ_PERSONAL_BOSS_INFO					= 17901;
	short RESP_PERSONAL_BOSS_INFO					= 27901;

	//new_protocol
	/**  个人Boss进入地图  **/
	short REQ_PERSONAL_ENTER					= 17902;
	short RESP_PERSONAL_ENTER					= 27902;

    //new_protocol
    /**  设置  **/
    short REQ_SETTING_DATA					= 18001;
    short RESP_SETTING_DATA					= 28001;

    //new_protocol
    /**  更改设置  **/
    short REQ_CHANGE_SETTING					= 18002;
    short RESP_CHANGE_SETTING					= 28002;

    //new_protocol
    /**  安全锁信息  **/
    short REQ_SAVE_LOCK_INFO					= 18003;
    short RESP_SAVE_LOCK_INFO					= 28003;

    //new_protocol
    /**  设置密码  **/
    short REQ_SET_PSWD					= 18004;
    short RESP_SET_PSWD					= 28004;

    //new_protocol
    /**  修改密码  **/
    short REQ_CHANGE_PSWD					= 18005;
    short RESP_CHANGE_PSWD					= 28005;

    //new_protocol
    /**  修改密码  **/
    short REQ_CLEAR_PSWD					= 18006;
    short RESP_CLEAR_PSWD					= 28006;

    //new_protocol
    /**  解锁与上锁  **/
    short REQ_CHANGE_LOCK_STATE					= 18007;
    short RESP_CHANGE_LOCK_STATE					= 28007;

    //new_protocol
    /**  创建队伍  **/
    short REQ_TEAM_CREATE					= 19001;
    short RESP_TEAM_CREATE					= 29001;

    //new_protocol
    /**  申请加入队伍  **/
    short REQ_TEAM_APPLY_JOIN					= 19002;
    short RESP_TEAM_APPLY_JOIN					= 29002;

    //new_protocol
    /**  批准加入队伍  **/
    short REQ_TEAM_JOIN					= 19003;
    short RESP_TEAM_JOIN					= 29003;

    //new_protocol
    /**  离开队伍  **/
    short REQ_TEAM_LEAVE					= 19004;
    short RESP_TEAM_LEAVE					= 29004;

    //new_protocol
    /**  拒绝申请  **/
    short REQ_TEAM_REJECT_APPLY					= 19005;
    short RESP_TEAM_REJECT_APPLY					= 29005;

    //new_protocol
    /**  一键拒绝申请  **/
    short REQ_TEAM_BATCH_REJECT_APPLY					= 19006;
    short RESP_TEAM_BATCH_REJECT_APPLY					= 29006;

    //new_protocol
    /**  邀请加入队伍  **/
    short REQ_TEAM_INVITE					= 19007;
    short RESP_TEAM_INVITE					= 29007;

    //new_protocol
    /**  更改队伍属性  **/
    short REQ_TEAM_CHANGE_PROP					= 19008;
    short RESP_TEAM_CHANGE_PROP					= 29008;

    //new_protocol
    /**  队伍自动匹配  **/
    short REQ_TEAM_AUTO_MATCH					= 19009;
    short RESP_TEAM_AUTO_MATCH					= 29009;

    //new_protocol
    /**  踢出队伍  **/
    short REQ_TEAM_KICKOUT					= 19010;
    short RESP_TEAM_KICKOUT					= 29010;

    //new_protocol
    /**  邀请加入队伍通知  **/
    short REQ_TEAM_INVITE_RESP					= 19011;
    short RESP_TEAM_INVITE_RESP					= 29011;

    //new_protocol
    /**  更改队伍属性通知  **/
    short REQ_TEAM_CHANGE_PROP_RESP					= 19012;
    short RESP_TEAM_CHANGE_PROP_RESP					= 29012;

    //new_protocol
    /**  邀请加入队伍世界频道通知  **/
    short REQ_TEAM_INVITE_NOTICE					= 19013;
    short RESP_TEAM_INVITE_NOTICE					= 29013;

    //new_protocol
    /**  取消队伍自动匹配  **/
    short REQ_TEAM_CANCEL_AUTO_MATCH					= 19014;
    short RESP_TEAM_CANCEL_AUTO_MATCH					= 29014;

    //new_protocol
    /**  队伍通知  **/
    short REQ_TEAM_MATCH_RESP					= 19015;
    short RESP_TEAM_MATCH_RESP					= 29015;

    //new_protocol
    /**  附近队伍  **/
    short REQ_TEAM_NEARBY					= 19016;
    short RESP_TEAM_NEARBY					= 29016;

    //new_protocol
    /**  便捷组队  **/
    short REQ_TEAM_CON_MATCH					= 19017;
    short RESP_TEAM_CON_MATCH					= 29017;

    //new_protocol
    /**  获取申请列表  **/
    short REQ_TEAM_APPLY_QUEUE					= 19018;
    short RESP_TEAM_APPLY_QUEUE					= 29018;

    //new_protocol
    /**  移交队长  **/
    short REQ_TEAM_EXCHANGE_LEADER					= 19019;
    short RESP_TEAM_EXCHANGE_LEADER					= 29019;

    //new_protocol
    /**  移交队长通知  **/
    short REQ_TEAM_EXCHANGE_LEADER_RESP					= 19020;
    short RESP_TEAM_EXCHANGE_LEADER_RESP					= 29020;

    //new_protocol
    /**  队员切换场景  **/
    short REQ_TEAM_MEMBER_SCENE					= 19021;
    short RESP_TEAM_MEMBER_SCENE					= 29021;

    //new_protocol
    /**  切换场景通知  **/
    short REQ_TEAM_SCENE_NOTICE					= 19022;
    short RESP_TEAM_SCENE_NOTICE					= 29022;

    //new_protocol
    /**  申请通知  **/
    short REQ_TEAM_APPLY_NOTICE					= 19023;
    short RESP_TEAM_APPLY_NOTICE					= 29023;

}