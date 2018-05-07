package cn.com.architecture.net.netty4.websocket.processors;

import com.linlongyx.h5.webgame.constant.MsgConstant;
import com.linlongyx.h5.webgame.processors.achievement.AchievementInfoProcessor;
import com.linlongyx.h5.webgame.processors.achievement.AchievementRefreshProcessor;
import com.linlongyx.h5.webgame.processors.achievement.GetAchievementAwardProcessor;
import com.linlongyx.h5.webgame.processors.activeCode.ActiveCodeGetProcessor;
import com.linlongyx.h5.webgame.processors.activeCode.ChannelGiftGetProcessor;
import com.linlongyx.h5.webgame.processors.aoi.*;
import com.linlongyx.h5.webgame.processors.aoi.ChangeLineProcessor;
import com.linlongyx.h5.webgame.processors.aoi.ChangeSpeedProcessor;
import com.linlongyx.h5.webgame.processors.aoi.ShowLineProcessor;
import com.linlongyx.h5.webgame.processors.arena.*;
import com.linlongyx.h5.webgame.processors.bag.*;
import com.linlongyx.h5.webgame.processors.bloc.*;
import com.linlongyx.h5.webgame.processors.blueCloud.BlueCloudEnterProcessor;
import com.linlongyx.h5.webgame.processors.blueCloud.BlueCloudScoreNoticeProcessor;
import com.linlongyx.h5.webgame.processors.book.BookInfoProcessor;
import com.linlongyx.h5.webgame.processors.book.BookReceiveProcessor;
import com.linlongyx.h5.webgame.processors.bosshome.*;
import com.linlongyx.h5.webgame.processors.bosshome.BossRebornNoticeProcessor;
import com.linlongyx.h5.webgame.processors.chat.*;
import com.linlongyx.h5.webgame.processors.chat.ChatSysBulletinProcessor;
import com.linlongyx.h5.webgame.processors.chess.*;
import com.linlongyx.h5.webgame.processors.common.*;
import com.linlongyx.h5.webgame.processors.equip.*;
import com.linlongyx.h5.webgame.processors.equip.EquipRefineProcessor;
import com.linlongyx.h5.webgame.processors.exam.ExamAnswerProcessor;
import com.linlongyx.h5.webgame.processors.exam.ExamInfoProcessor;
import com.linlongyx.h5.webgame.processors.exam.ExamItemUseProcessor;
import com.linlongyx.h5.webgame.processors.fashion.*;
import com.linlongyx.h5.webgame.processors.fight.AttackProcessor;
import com.linlongyx.h5.webgame.processors.fight.AttackReadyProcessor;
import com.linlongyx.h5.webgame.processors.fight.BuffHitProcessor;
import com.linlongyx.h5.webgame.processors.fight.HitDataProcessor;
import com.linlongyx.h5.webgame.processors.firstReCharge.FirstReChargeGetProcessor;
import com.linlongyx.h5.webgame.processors.firstReCharge.FirstReChargeInfoProcessor;
import com.linlongyx.h5.webgame.processors.firstReCharge.FirstWorthReChargeGetProcessor;
import com.linlongyx.h5.webgame.processors.flushList.*;
import com.linlongyx.h5.webgame.processors.friend.*;
import com.linlongyx.h5.webgame.processors.general.*;
import com.linlongyx.h5.webgame.processors.invest.InvestPlanBuyProcessor;
import com.linlongyx.h5.webgame.processors.invest.InvestPlanGetProcessor;
import com.linlongyx.h5.webgame.processors.invest.InvestPlanInfoProcessor;
import com.linlongyx.h5.webgame.processors.levelReward.LevelRewardGetProcessor;
import com.linlongyx.h5.webgame.processors.levelReward.LevelRewardInfoProcessor;
import com.linlongyx.h5.webgame.processors.levelupGift.LevelupGiftInfoProcessor;
import com.linlongyx.h5.webgame.processors.levelupGift.LevelupGiftOpenProcessor;
import com.linlongyx.h5.webgame.processors.login.*;
import com.linlongyx.h5.webgame.processors.loginReward.LoginRewardGetProcessor;
import com.linlongyx.h5.webgame.processors.loginReward.LoginRewardInfoProcessor;
import com.linlongyx.h5.webgame.processors.lover.*;
import com.linlongyx.h5.webgame.processors.mail.*;
import com.linlongyx.h5.webgame.processors.mail.MailAllDeleteProcessor;
import com.linlongyx.h5.webgame.processors.mail.MailAllExtractProcessor;
import com.linlongyx.h5.webgame.processors.market.*;
import com.linlongyx.h5.webgame.processors.marry.*;
import com.linlongyx.h5.webgame.processors.monthCard.MonthCardBuyProcessor;
import com.linlongyx.h5.webgame.processors.monthCard.MonthCardGetProcessor;
import com.linlongyx.h5.webgame.processors.monthCard.MonthCardInfoProcessor;
import com.linlongyx.h5.webgame.processors.multiIns.*;
import com.linlongyx.h5.webgame.processors.party.*;
import com.linlongyx.h5.webgame.processors.peak.*;
import com.linlongyx.h5.webgame.processors.personalBoss.PersonalBossInfoProcessor;
import com.linlongyx.h5.webgame.processors.personalBoss.PersonalEnterProcessor;
import com.linlongyx.h5.webgame.processors.pet.*;
import com.linlongyx.h5.webgame.processors.pray.PrayGetProcessor;
import com.linlongyx.h5.webgame.processors.pray.PrayInfoProcessor;
import com.linlongyx.h5.webgame.processors.ranking.RankingProcessor;
import com.linlongyx.h5.webgame.processors.recharge.*;
import com.linlongyx.h5.webgame.processors.rune.*;
import com.linlongyx.h5.webgame.processors.seriesRecharge.SeriesRechargeGetProcessor;
import com.linlongyx.h5.webgame.processors.seriesRecharge.SeriesRechargeInfoProcessor;
import com.linlongyx.h5.webgame.processors.serverOpen.CollectReceiveProcessor;
import com.linlongyx.h5.webgame.processors.serverOpen.CreateBlocReceiveProcessor;
import com.linlongyx.h5.webgame.processors.serverOpen.ServerOpenInfoProcessor;
import com.linlongyx.h5.webgame.processors.setting.*;
import com.linlongyx.h5.webgame.processors.shop.*;
import com.linlongyx.h5.webgame.processors.sign.*;
import com.linlongyx.h5.webgame.processors.singleIns.*;
import com.linlongyx.h5.webgame.processors.singleIns.LastTotleExpProcessor;
import com.linlongyx.h5.webgame.processors.skill.*;
import com.linlongyx.h5.webgame.processors.task.*;
import com.linlongyx.h5.webgame.processors.team.*;
import com.linlongyx.h5.webgame.processors.title.TitleActivateProcessor;
import com.linlongyx.h5.webgame.processors.title.TitleInfoProcessor;
import com.linlongyx.h5.webgame.processors.title.TitleWearProcessor;
import com.linlongyx.h5.webgame.processors.transfer.StageUpProcessor;
import com.linlongyx.h5.webgame.processors.transfer.TransferNoticeProcessor;
import com.linlongyx.h5.webgame.processors.treasure.*;
import com.linlongyx.h5.webgame.processors.treasure.TreasureDepotGetProcessor;
import com.linlongyx.h5.webgame.processors.treasure.TreasureDepotInfoProcessor;
import com.linlongyx.h5.webgame.processors.vip.VipInfoProcessor;
import com.linlongyx.h5.webgame.proto.binary.achievement.AchievementInfoRequest;
import com.linlongyx.h5.webgame.proto.binary.achievement.AchievementRefreshRequest;
import com.linlongyx.h5.webgame.proto.binary.achievement.GetAchievementAwardRequest;
import com.linlongyx.h5.webgame.proto.binary.activeCode.ActiveCodeGetRequest;
import com.linlongyx.h5.webgame.proto.binary.activeCode.ChannelGiftGetRequest;
import com.linlongyx.h5.webgame.proto.binary.aoi.*;
import com.linlongyx.h5.webgame.proto.binary.aoi.ChangeLineRequest;
import com.linlongyx.h5.webgame.proto.binary.aoi.ChangeSpeedRequest;
import com.linlongyx.h5.webgame.proto.binary.aoi.ShowLineRequest;
import com.linlongyx.h5.webgame.proto.binary.arena.*;
import com.linlongyx.h5.webgame.proto.binary.bag.*;
import com.linlongyx.h5.webgame.proto.binary.bloc.*;
import com.linlongyx.h5.webgame.proto.binary.blueCloud.BlueCloudEnterRequest;
import com.linlongyx.h5.webgame.proto.binary.blueCloud.BlueCloudScoreNoticeRequest;
import com.linlongyx.h5.webgame.proto.binary.book.BookInfoRequest;
import com.linlongyx.h5.webgame.proto.binary.book.BookReceiveRequest;
import com.linlongyx.h5.webgame.proto.binary.bosshome.*;
import com.linlongyx.h5.webgame.proto.binary.bosshome.BossRebornNoticeRequest;
import com.linlongyx.h5.webgame.proto.binary.chat.*;
import com.linlongyx.h5.webgame.proto.binary.chat.ChatSysBulletinRequest;
import com.linlongyx.h5.webgame.proto.binary.chess.*;
import com.linlongyx.h5.webgame.proto.binary.common.*;
import com.linlongyx.h5.webgame.proto.binary.equip.*;
import com.linlongyx.h5.webgame.proto.binary.equip.EquipRefineRequest;
import com.linlongyx.h5.webgame.proto.binary.exam.ExamAnswerRequest;
import com.linlongyx.h5.webgame.proto.binary.exam.ExamInfoRequest;
import com.linlongyx.h5.webgame.proto.binary.exam.ExamItemUseRequest;
import com.linlongyx.h5.webgame.proto.binary.fashion.*;
import com.linlongyx.h5.webgame.proto.binary.fight.AttackReadyRequest;
import com.linlongyx.h5.webgame.proto.binary.fight.AttackRequest;
import com.linlongyx.h5.webgame.proto.binary.fight.BuffHitRequest;
import com.linlongyx.h5.webgame.proto.binary.fight.HitDataRequest;
import com.linlongyx.h5.webgame.proto.binary.firstReCharge.FirstReChargeGetRequest;
import com.linlongyx.h5.webgame.proto.binary.firstReCharge.FirstReChargeInfoRequest;
import com.linlongyx.h5.webgame.proto.binary.firstReCharge.FirstWorthReChargeGetRequest;
import com.linlongyx.h5.webgame.proto.binary.flushList.*;
import com.linlongyx.h5.webgame.proto.binary.friend.*;
import com.linlongyx.h5.webgame.proto.binary.general.*;
import com.linlongyx.h5.webgame.proto.binary.invest.InvestPlanBuyRequest;
import com.linlongyx.h5.webgame.proto.binary.invest.InvestPlanGetRequest;
import com.linlongyx.h5.webgame.proto.binary.invest.InvestPlanInfoRequest;
import com.linlongyx.h5.webgame.proto.binary.levelReward.LevelRewardGetRequest;
import com.linlongyx.h5.webgame.proto.binary.levelReward.LevelRewardInfoRequest;
import com.linlongyx.h5.webgame.proto.binary.levelupGift.LevelupGiftInfoRequest;
import com.linlongyx.h5.webgame.proto.binary.levelupGift.LevelupGiftOpenRequest;
import com.linlongyx.h5.webgame.proto.binary.login.*;
import com.linlongyx.h5.webgame.proto.binary.loginReward.LoginRewardGetRequest;
import com.linlongyx.h5.webgame.proto.binary.loginReward.LoginRewardInfoRequest;
import com.linlongyx.h5.webgame.proto.binary.lover.*;
import com.linlongyx.h5.webgame.proto.binary.mail.*;
import com.linlongyx.h5.webgame.proto.binary.mail.MailAllDeleteRequest;
import com.linlongyx.h5.webgame.proto.binary.mail.MailAllExtractRequest;
import com.linlongyx.h5.webgame.proto.binary.market.*;
import com.linlongyx.h5.webgame.proto.binary.marry.*;
import com.linlongyx.h5.webgame.proto.binary.monthCard.MonthCardBuyRequest;
import com.linlongyx.h5.webgame.proto.binary.monthCard.MonthCardGetRequest;
import com.linlongyx.h5.webgame.proto.binary.monthCard.MonthCardInfoRequest;
import com.linlongyx.h5.webgame.proto.binary.multiIns.*;
import com.linlongyx.h5.webgame.proto.binary.party.*;
import com.linlongyx.h5.webgame.proto.binary.peak.*;
import com.linlongyx.h5.webgame.proto.binary.personalBoss.PersonalBossInfoRequest;
import com.linlongyx.h5.webgame.proto.binary.personalBoss.PersonalEnterRequest;
import com.linlongyx.h5.webgame.proto.binary.pet.*;
import com.linlongyx.h5.webgame.proto.binary.pray.PrayGetRequest;
import com.linlongyx.h5.webgame.proto.binary.pray.PrayInfoRequest;
import com.linlongyx.h5.webgame.proto.binary.ranking.RankingRequest;
import com.linlongyx.h5.webgame.proto.binary.recharge.*;
import com.linlongyx.h5.webgame.proto.binary.rune.*;
import com.linlongyx.h5.webgame.proto.binary.seriesRecharge.SeriesRechargeGetRequest;
import com.linlongyx.h5.webgame.proto.binary.seriesRecharge.SeriesRechargeInfoRequest;
import com.linlongyx.h5.webgame.proto.binary.serverOpen.CollectReceiveRequest;
import com.linlongyx.h5.webgame.proto.binary.serverOpen.CreateBlocReceiveRequest;
import com.linlongyx.h5.webgame.proto.binary.serverOpen.ServerOpenInfoRequest;
import com.linlongyx.h5.webgame.proto.binary.setting.*;
import com.linlongyx.h5.webgame.proto.binary.shop.*;
import com.linlongyx.h5.webgame.proto.binary.sign.*;
import com.linlongyx.h5.webgame.proto.binary.singleIns.*;
import com.linlongyx.h5.webgame.proto.binary.singleIns.LastTotleExpRequest;
import com.linlongyx.h5.webgame.proto.binary.skill.*;
import com.linlongyx.h5.webgame.proto.binary.task.*;
import com.linlongyx.h5.webgame.proto.binary.team.*;
import com.linlongyx.h5.webgame.proto.binary.title.TitleActivateRequest;
import com.linlongyx.h5.webgame.proto.binary.title.TitleInfoRequest;
import com.linlongyx.h5.webgame.proto.binary.title.TitleWearRequest;
import com.linlongyx.h5.webgame.proto.binary.transfer.StageUpRequest;
import com.linlongyx.h5.webgame.proto.binary.transfer.TransferNoticeRequest;
import com.linlongyx.h5.webgame.proto.binary.treasure.*;
import com.linlongyx.h5.webgame.proto.binary.treasure.TreasureDepotGetRequest;
import com.linlongyx.h5.webgame.proto.binary.treasure.TreasureDepotInfoRequest;
import com.linlongyx.h5.webgame.proto.binary.vip.VipInfoRequest;

public enum MsgProcessorRegister {


    /**
     * 玩家更改外形
     **/
    ChangeModel(MsgConstant.REQ_CHANGE_MODEL, ChangeModelProcessor.class, ChangeModelRequest.class),

    /**
     * 进入场景确认
     **/
    EnterConfirm(MsgConstant.REQ_ENTER_CONFIRM, EnterConfirmProcessor.class, EnterConfirmRequest.class),

    /**
     * 进入场景
     **/
    EnterScene(MsgConstant.REQ_ENTER_SCENE, EnterSceneProcessor.class, EnterSceneRequest.class),

    /**
     * 离开场景
     **/
    LeaveScene(MsgConstant.REQ_LEAVE_SCENE, LeaveSceneProcessor.class, LeaveSceneRequest.class),

    /**
     * AOI类
     **/
    SceneAOIMessage(MsgConstant.REQ_AOI_MESSAGE, SceneAOIMessageProcessor.class, SceneAOIMessageRequest.class),

    /**
     * 更新场景动态数据
     **/
    UpdateSceneDynData(MsgConstant.REQ_UPDATE_SCENE_DYNDATA, UpdateSceneDynDataProcessor.class, UpdateSceneDynDataRequest.class),

    /**
     * 场景行走
     **/
    WalkScene(MsgConstant.REQ_WALK_SCENE, WalkSceneProcessor.class, WalkSceneRequest.class),

    /**
     * 行走停止
     **/
    WalkStop(MsgConstant.REQ_WALK_STOP, WalkStopProcessor.class, WalkStopRequest.class),

    /**
     * 行走同步
     **/
    WalkSync(MsgConstant.REQ_WALK_SYNC, WalkSyncProcessor.class, WalkSyncRequest.class),

    /**
     * 竞技场信息
     **/
    ArenaInfo(MsgConstant.REQ_ARENA_INFO, ArenaInfoProcessor.class, ArenaInfoRequest.class),


    /**
     * 竞技场挑战开始
     **/
    ArenaStart(MsgConstant.REQ_ARENA_START, ArenaStartProcessor.class, ArenaStartRequest.class),

    /**
     * 加格子
     **/
    BagAddGrid(MsgConstant.REQ_BAG_ADD_GRID, BagAddGridProcessor.class, BagAddGridRequest.class),

    /**
     * 快速购买
     **/
    BagBuy(MsgConstant.REQ_BAG_BUY, BagBuyProcessor.class, BagBuyRequest.class),

    /**
     * 元宝转绑元
     **/
    BagChangeCCY(MsgConstant.REQ_BAG_CHANGE_CCY, BagChangeCCYProcessor.class, BagChangeCCYRequest.class),

    /**
     * 物品合成
     **/
    BagCompose(MsgConstant.REQ_BAG_COMPOSE, BagComposeProcessor.class, BagComposeRequest.class),

    /**
     * 物品分解
     **/
    BagDecompose(MsgConstant.REQ_BAG_DECOMPOSE, BagDecomposeProcessor.class, BagDecomposeRequest.class),

    /**
     * 掉落
     **/
    BagDrop(MsgConstant.REQ_BAG_DROP, BagDropProcessor.class, BagDropRequest.class),

    /**
     * 背包通知
     **/
    BagNotice(MsgConstant.REQ_BAG_NOTICE, BagNoticeProcessor.class, BagNoticeRequest.class),

    /**
     * 打开背包
     **/
    BagOpen(MsgConstant.REQ_BAG_OPEN, BagOpenProcessor.class, BagOpenRequest.class),

    /**
     * 出售道具
     **/
    BagSellItem(MsgConstant.REQ_BAG_SELL_ITEM, BagSellItemProcessor.class, BagSellItemRequest.class),

    /**
     * 使用道具
     **/
    BagUseItem(MsgConstant.REQ_BAG_USE_ITEM, BagUseItemProcessor.class, BagUseItemRequest.class),

    /**
     * 聊天
     **/
    Chat(MsgConstant.REQ_CHAT, ChatProcessor.class, ChatRequest.class),

    /**
     * 频道广播
     **/
    ChatBroadcast(MsgConstant.REQ_CHAT_BROADCAST, ChatBroadcastProcessor.class, ChatBroadcastRequest.class),

    /**
     * 频道聊天
     **/
    ChatByChannel(MsgConstant.REQ_CHAT_BYCHANNEL, ChatByChannelProcessor.class, ChatByChannelRequest.class),

    /**
     * 打开私聊
     **/
    ChatOpen(MsgConstant.REQ_CHAT_OPEN, ChatOpenProcessor.class, ChatOpenRequest.class),

    /**
     * 屏幕中央广播
     **/
    ChatRadiate(MsgConstant.REQ_CHAT_RADIATE, ChatRadiateProcessor.class, ChatRadiateRequest.class),

    /**
     * 属性更新
     **/
    AttrUpdate(MsgConstant.REQ_ATTR_UPDATE, AttrUpdateProcessor.class, AttrUpdateRequest.class),

    /**
     * 玩家keyvalue信息更新
     **/
    KeyValueUpdate(MsgConstant.REQ_KEYVALUE_UPDATE, KeyValueUpdateProcessor.class, KeyValueUpdateRequest.class),

    /**
     * 玩家获得奖励弹窗
     **/
    RewardNotice(MsgConstant.REQ_REWARD_NOTICE, RewardNoticeProcessor.class, RewardNoticeRequest.class),

    /**
     * 装备列表
     **/
    EquipList(MsgConstant.REQ_EQUIP_LIST, EquipListProcessor.class, EquipListRequest.class),

    /**
     * 装备替换
     **/
    EquipReplace(MsgConstant.REQ_EQUIP_REPLACE, EquipReplaceProcessor.class, EquipReplaceRequest.class),

    /**
     * 镶嵌
     **/
    EquipStoneUp(MsgConstant.REQ_EQUIP_STONEUP, EquipStoneUpProcessor.class, EquipStoneUpRequest.class),

    /**
     * 镶嵌
     **/
    EquipStoneRemove(MsgConstant.REQ_EQUIP_STONE_REMOVE, EquipStoneRemoveProcessor.class, EquipStoneRemoveRequest.class),


    /**
     * 装备洗练
     **/
    EquipClear(MsgConstant.REQ_EQUIP_CLEAR, EquipClearProcessor.class, EquipClearRequest.class),

    /**
     * 装备洗练开孔
     **/
    EquipClearOpen(MsgConstant.REQ_EQUIP_CLEAR_OPEN, EquipClearOpenProcessor.class, EquipClearOpenRequest.class),

    /**
     * 当前强化熟练度
     **/
    StrengthExp(MsgConstant.REQ_STRENGTH_EXP, StrengthExpProcessor.class, StrengthExpRequest.class),

    /**
     * 当前洗练次数
     **/
    ClearFreeCount(MsgConstant.REQ_CLEAR_COUNT, ClearCountProcessor.class, ClearCountRequest.class),

    /**
     * 强化
     **/
    EquipStrengthUp(MsgConstant.REQ_EQUIP_STRENGTHUP, EquipStrengthUpProcessor.class, EquipStrengthUpRequest.class),

    /**
     * 攻击
     **/
    Attack(MsgConstant.REQ_ATTACK, AttackProcessor.class, AttackRequest.class),

    /**
     * 攻击准备
     **/
    AttackReady(MsgConstant.REQ_ATTACK_READY, AttackReadyProcessor.class, AttackReadyRequest.class),

    /**
     * 受击数据
     **/
    HitData(MsgConstant.REQ_HIT_DATA, HitDataProcessor.class, HitDataRequest.class),

    /**
     * 申请好友
     **/
    FriendApply(MsgConstant.REQ_FRIEND_APPLY, FriendApplyProcessor.class, FriendApplyRequest.class),

    /**
     * 获取申请列表
     **/
    FriendApplyList(MsgConstant.REQ_FRIEND_APPLY_LIST, FriendApplyListProcessor.class, FriendApplyListRequest.class),

    /**
     * 拉黑
     **/
    FriendBlack(MsgConstant.REQ_FRIEND_BLACK, FriendBlackProcessor.class, FriendBlackRequest.class),

    /**
     * 取消拉黑
     **/
    FriendCancelBlack(MsgConstant.REQ_FRIEND_CANCEL_BLACK, FriendCancelBlackProcessor.class, FriendCancelBlackRequest.class),

    /**
     * 处理好友申请
     **/
    FriendDealApply(MsgConstant.REQ_FRIEND_DEAL_APPLY, FriendDealApplyProcessor.class, FriendDealApplyRequest.class),

    /**
     * 删除好友
     **/
    FriendDelete(MsgConstant.REQ_FRIEND_DELETE, FriendDeleteProcessor.class, FriendDeleteRequest.class),

    /**
     * 好友登录推送
     **/
    FriendLoginNotice(MsgConstant.REQ_FRIEND_LOGIN_NOTICE, FriendLoginNoticeProcessor.class, FriendLoginNoticeRequest.class),

    /**
     * 打开好友界面
     **/
    FriendOpen(MsgConstant.REQ_FRIEND_OPEN, FriendOpenProcessor.class, FriendOpenRequest.class),

    /**
     * 读聊天
     **/
    FriendReadChat(MsgConstant.REQ_FRIEND_READ_CHAT, FriendReadChatProcessor.class, FriendReadChatRequest.class),

    /**
     * 获取推荐列表
     **/
    FriendRecommend(MsgConstant.REQ_FRIEND_RECOMMEND, FriendRecommendProcessor.class, FriendRecommendRequest.class),

    /**
     * 发聊天
     **/
    FriendSendChat(MsgConstant.REQ_FRIEND_SEND_CHAT, FriendSendChatProcessor.class, FriendSendChatRequest.class),

    /**
     * 搜索
     **/
    FriendSerach(MsgConstant.REQ_FRIEND_SEARCH, FriendSerachProcessor.class, FriendSerachRequest.class),

    /**
     * 好友状态改变推送
     **/
    FriendStateNotice(MsgConstant.REQ_FRIEND_STATE_NOTICE, FriendStateNoticeProcessor.class, FriendStateNoticeRequest.class),

    /**
     * 采集
     **/
    Collect(MsgConstant.REQ_COLLECT, CollectProcessor.class, CollectRequest.class),

    /**
     * 完成采集
     **/
    CompleteCollect(MsgConstant.REQ_COMPLETE_COLLECT, CompleteCollectProcessor.class, CompleteCollectRequest.class),

    /**
     * 复活
     **/
    Revive(MsgConstant.REQ_REVIVE, ReviveProcessor.class, ReviveRequest.class),

    /**
     * 战斗模式切换
     **/
    ChangePKMod(MsgConstant.REQ_CHANGE_PKMOD, ChangePKModProcessor.class, ChangePKModRequest.class),

    /**
     * 创角
     **/
    CreatePlayer(MsgConstant.REQ_CREATE_PLAYER, CreatePlayerProcessor.class, CreatePlayerRequest.class),

    /**
     * 进入游戏
     **/
    EnterGame(MsgConstant.REQ_ENTER_GAME, EnterGameProcessor.class, EnterGameRequest.class),

    /**
     * 账号登录测试
     **/
    LoginCheck(MsgConstant.REQ_LOGIN_CHECK, LoginCheckProcessor.class, LoginCheckRequest.class),

    /**
     * 账号登录
     **/
    LoginInfo(MsgConstant.REQ_LOGIN, LoginInfoProcessor.class, LoginInfoRequest.class),

    /**
     * 挂机离线受益
     **/
    OfflineIncome(MsgConstant.REQ_OFFLINE_INCOME, OfflineIncomeProcessor.class, OfflineIncomeRequest.class),

    /**
     * 战斗模式通知
     **/
    PKModNotice(MsgConstant.REQ_PKMOD_NOTICE, PKModNoticeProcessor.class, PKModNoticeRequest.class),

    /**
     * 重连
     **/
    Reconnect(MsgConstant.REQ_RECONNECT, ReconnectProcessor.class, ReconnectRequest.class),

    /**
     * 同步时钟
     **/
    TimeSync(MsgConstant.REQ_TIME_SYNC, TimeSyncProcessor.class, TimeSyncRequest.class),

    /**
     * 删除邮件
     **/
    MailDelete(MsgConstant.REQ_MAIL_DELETE, MailDeleteProcessor.class, MailDeleteRequest.class),

    /**
     * 收取邮件附件
     **/
    MailExtract(MsgConstant.REQ_MAIL_EXTRACT, MailExtractProcessor.class, MailExtractRequest.class),

    /**
     * 邮件列表
     **/
    MailList(MsgConstant.REQ_MAIL_LIST, MailListProcessor.class, MailListRequest.class),

    /**
     * 邮件提醒
     **/
    MailNotice(MsgConstant.REQ_MAIL_NOTICE, MailNoticeProcessor.class, MailNoticeRequest.class),

    /**
     * 读邮件
     **/
    MailRead(MsgConstant.REQ_MAIL_READ, MailReadProcessor.class, MailReadRequest.class),

    /**
     * 发邮件
     **/
    MailSend(MsgConstant.REQ_MAIL_SEND, MailSendProcessor.class, MailSendRequest.class),

    /**
     * 宠骑换皮肤
     **/
    ChangeSkin(MsgConstant.REQ_CHANGE_SKIN, ChangeSkinProcessor.class, ChangeSkinRequest.class),
    /**
     * 宠物吃装备
     **/
    EatEquip(MsgConstant.REQ_EAT_EQUIP, EatEquipProcessor.class, EatEquipRequest.class),

    /**
     * 宠骑增加经验
     **/
    PetAddExp(MsgConstant.REQ_PET_ADD_BLESS, PetAddBlessProcessor.class, PetAddBlessRequest.class),

    /**
     * 宠骑增加丹药
     **/
    PetAddPanacea(MsgConstant.REQ_PET_ADD_PANACEA, PetAddPanaceaProcessor.class, PetAddPanaceaRequest.class),

    /**
     * 查看宠骑信息
     **/
    PetList(MsgConstant.REQ_PET_LIST, PetListProcessor.class, PetListRequest.class),

    /**
     * 祝福类信息
     **/
    PetCheck(MsgConstant.REQ_PET_CHECK, PetCheckProcessor.class, PetCheckRequest.class),


    /**
     * 排行榜
     **/
    Ranking(MsgConstant.REQ_RANKING, RankingProcessor.class, RankingRequest.class),


    /**
     * 购买商品
     **/
    BuyGoods(MsgConstant.REQ_BUG_GOODS, BuyGoodsProcessor.class, BuyGoodsRequest.class),

    /**
     * 商店列表
     **/
    ShopList(MsgConstant.REQ_SHOP_LIST, ShopListProcessor.class, ShopListRequest.class),

    /**
     * 技能列表
     **/
    SkillList(MsgConstant.REQ_SKILL_LIST, SkillListProcessor.class, SkillListRequest.class),

    /**
     * 交换技能位置
     **/
    SkillSwap(MsgConstant.REQ_SKILL_SWAP, SkillSwapProcessor.class, SkillSwapRequest.class),

    /**
     * 被动技能列表
     **/
    PassiveSkillList(MsgConstant.REQ_PASSIVE_SKILL_LIST, PassiveSkillListProcessor.class, PassiveSkillListRequest.class),

    /**
     * 每日必做升级
     **/
    TaskActivity(MsgConstant.REQ_TASK_ACTIVITY, TaskActivityProcessor.class, TaskActivityRequest.class),

    /**
     * 日常任务找回经验
     **/
    TaskBack(MsgConstant.REQ_TASK_BACK, TaskBackProcessor.class, TaskBackRequest.class),

    /**
     * 客户端进度
     **/
    TaskClientSchedule(MsgConstant.REQ_TASK_CLIENT_SCHEDULE, TaskClientScheduleProcessor.class, TaskClientScheduleRequest.class),

    /**
     * 主线完成任务
     **/
    TaskComplete(MsgConstant.REQ_TASK_COMPLETE, TaskCompleteProcessor.class, TaskCompleteRequest.class),

    /**
     * 日常任务完成
     **/
    TaskDailyComplete(MsgConstant.REQ_TASK_DAILY_COMPLETE, TaskDailyCompleteProcessor.class, TaskDailyCompleteRequest.class),

    /**
     * 完成新手引导
     **/
    TaskGuide(MsgConstant.REQ_TASK_GUIDE, TaskGuideProcessor.class, TaskGuideRequest.class),

    /**
     * 玩家任务信息
     **/
    TaskInfo(MsgConstant.REQ_TASK_INFO, TaskInfoProcessor.class, TaskInfoRequest.class),


    /**
     * 称号激活
     **/
    TitleActivate(MsgConstant.REQ_TITLE_ACTIVATE, TitleActivateProcessor.class, TitleActivateRequest.class),

    /**
     * 称号信息
     **/
    TitleInfo(MsgConstant.REQ_TITLE_INFO, TitleInfoProcessor.class, TitleInfoRequest.class),

    /**
     * 称号幻化
     **/
    TitleWear(MsgConstant.REQ_TITLE_WEAR, TitleWearProcessor.class, TitleWearRequest.class),

    /**
     * 时装信息
     **/
    FashionInfo(MsgConstant.REQ_FASHION_INFO, FashionInfoProcessor.class, FashionInfoRequest.class),

    /**
     * 时装幻化
     **/
    FashionWear(MsgConstant.REQ_FASHION_WEAR, FashionWearProcessor.class, FashionWearRequest.class),

    /**
     * 获取玩家的坐标
     **/
    PlayerPosition(MsgConstant.REQ_PLAYER_POSITION, PlayerPositionProcessor.class, PlayerPositionRequest.class),

    /**
     * 单条好友完整信息推送
     **/
    FriendInfoNotice(MsgConstant.REQ_FRIEND_INFO_NOTICE, FriendInfoNoticeProcessor.class, FriendInfoNoticeRequest.class),

    /**
     * 获得签到信息
     **/
    SignInfo(MsgConstant.REQ_SIGN_INFO, SignInfoProcessor.class, SignInfoRequest.class),

    /**
     * 签到操作
     **/
    ToSign(MsgConstant.REQ_TO_SIGN, ToSignProcessor.class, ToSignRequest.class),

    /**
     * 领取登陆奖励礼包
     **/
    LoginRewardGet(MsgConstant.REQ_LOGIN_REWARD_GET, LoginRewardGetProcessor.class, LoginRewardGetRequest.class),

    /**
     * 获取登陆奖励信息
     **/
    LoginRewardInfo(MsgConstant.REQ_LOGIN_REWARD_INFO, LoginRewardInfoProcessor.class, LoginRewardInfoRequest.class),

    /**
     * 领取月卡奖励
     **/
    MonthCardGet(MsgConstant.REQ_MONTH_CARD_GET, MonthCardGetProcessor.class, MonthCardGetRequest.class),

    /**
     * 获取月卡信息
     **/
    MonthCardInfo(MsgConstant.REQ_MONTH_CARD_INFO, MonthCardInfoProcessor.class, MonthCardInfoRequest.class),

    /**
     * 获取首充信息
     **/
    FirstReChargeInfo(MsgConstant.REQ_FIRST_RECHARGE_INFO, FirstReChargeInfoProcessor.class, FirstReChargeInfoRequest.class),

    /**
     * 领取首充奖励
     **/
    FirstReChargeGet(MsgConstant.REQ_FIRST_RECHARGE_GET, FirstReChargeGetProcessor.class, FirstReChargeGetRequest.class),

    /**
     * 领取超值首充奖励
     **/
    FirstWorthReChargeGet(MsgConstant.REQ_FIRST_WORTH_RECHARGE_GET, FirstWorthReChargeGetProcessor.class, FirstWorthReChargeGetRequest.class),

    /**
     * 购买投资计划
     **/
    InvestPlanBuy(MsgConstant.REQ_INVEST_PLAN_BUY, InvestPlanBuyProcessor.class, InvestPlanBuyRequest.class),

    /**
     * 领取投资计划奖励
     **/
    InvestPlanGet(MsgConstant.REQ_INVEST_PLAN_GET, InvestPlanGetProcessor.class, InvestPlanGetRequest.class),

    /**
     * 获取投资计划信息
     **/
    InvestPlanInfo(MsgConstant.REQ_INVEST_PLAN_INFO, InvestPlanInfoProcessor.class, InvestPlanInfoRequest.class),

    /**
     * 领取激活码
     **/
    ActiveCodeGet(MsgConstant.REQ_ACTIVE_CODE_GET, ActiveCodeGetProcessor.class, ActiveCodeGetRequest.class),


    /**
     * 领取等级礼包
     **/
    LevelRewardGet(MsgConstant.REQ_LEVEL_REWARD_GET, LevelRewardGetProcessor.class, LevelRewardGetRequest.class),

    /**
     * 获得等级礼包信息
     **/
    LevelRewardInfo(MsgConstant.REQ_LEVEL_REWARD_INFO, LevelRewardInfoProcessor.class, LevelRewardInfoRequest.class),

    /**
     * 玩家登录
     **/
    LoginInfoDebug(MsgConstant.REQ_LOGIN_INFO_DEBUG, LoginInfoDebugProcessor.class, LoginInfoDebugRequest.class),

    /**
     * vip信息
     **/
    VipInfo(MsgConstant.REQ_VIP_INFO, VipInfoProcessor.class, VipInfoRequest.class),

    /**
     * 获取连续累充奖励
     **/
    SeriesRechargeGet(MsgConstant.REQ_SERIES_RECHARGE_GET, SeriesRechargeGetProcessor.class, SeriesRechargeGetRequest.class),

    /**
     * 获得连续累充信息
     **/
    SeriesRechargeInfo(MsgConstant.REQ_SERIES_RECHARGE_INFO, SeriesRechargeInfoProcessor.class, SeriesRechargeInfoRequest.class),

    /**
     * 新技能
     **/
    SkillNew(MsgConstant.REQ_SKILL_NEW, SkillNewProcessor.class, SkillNewRequest.class),

    /**
     * 申请加入仙盟
     **/
    ApplyBloc(MsgConstant.REQ_APPLY_BLOC, ApplyBlocProcessor.class, ApplyBlocRequest.class),

    /**
     * 测试DB
     **/
    TestDB(MsgConstant.REQ_TEST_DB, TestDBProcessor.class, TestDBRequest.class),

    /**
     * 申请处理
     **/
    ApplyDeal(MsgConstant.REQ_APPLY_DEAL, ApplyDealProcessor.class, ApplyDealRequest.class),

    /**
     * 仙盟申请列表
     **/
    ApplyList(MsgConstant.REQ_APPLY_LIST, ApplyListProcessor.class, ApplyListRequest.class),

    /**
     * 任免副盟
     **/
    AppointVice(MsgConstant.REQ_APPOINT_VICE, AppointViceProcessor.class, AppointViceRequest.class),

    /**
     * 仙盟信息
     **/
    BlocInfo(MsgConstant.REQ_BLOC_INFO, BlocInfoProcessor.class, BlocInfoRequest.class),

    /**
     * 仙盟列表
     **/
    BlocList(MsgConstant.REQ_BLOC_LIST, BlocListProcessor.class, BlocListRequest.class),


    /**
     * 创建仙盟
     **/
    CreateBloc(MsgConstant.REQ_CREATE_BLOC, CreateBlocProcessor.class, CreateBlocRequest.class),

    /**
     * 捐献列表
     **/
    DonateLog(MsgConstant.REQ_DONATE_LOG, DonateLogProcessor.class, DonateLogRequest.class),

    /**
     * 离开联盟
     **/
    LeaveBloc(MsgConstant.REQ_LEAVE_BLOC, LeaveBlocProcessor.class, LeaveBlocRequest.class),

    /**
     * 成员列表
     **/
    MemberList(MsgConstant.REQ_MEMBER_LIST, MemberListProcessor.class, MemberListRequest.class),

    /**
     * 搜索仙盟
     **/
    SearchBloc(MsgConstant.REQ_SEARCH_BLOC, SearchBlocProcessor.class, SearchBlocRequest.class),

    /**
     * 转让盟主
     **/
    TransferBloc(MsgConstant.REQ_TRANSFER_BLOC, TransferBlocProcessor.class, TransferBlocRequest.class),

    /**
     * 修改公告
     **/
    ChangeNotice(MsgConstant.REQ_CHANGE_NOTICE, ChangeNoticeProcessor.class, ChangeNoticeRequest.class),

    /**
     * 成长目标信息
     **/
    GrowGoalInfo(MsgConstant.REQ_GROW_GOAL_INFO, GrowGoalInfoProcessor.class, GrowGoalInfoRequest.class),

    /**
     * 购买挑战次数
     **/
    BuyTimes(MsgConstant.REQ_BUY_TIMES, BuyTimesProcessor.class, BuyTimesRequest.class),

    /**  单人副本排行  **/

    /**
     * 扫荡副本
     **/
    ClearChallenge(MsgConstant.REQ_CLEAR_CHALLENGE, ClearChallengeProcessor.class, ClearChallengeRequest.class),

    /**
     * 仙盟申请列表红点
     **/
    ApplyRed(MsgConstant.REQ_APPLY_RED, ApplyRedProcessor.class, ApplyRedRequest.class),

    /**
     * 加成属性更新
     **/
    AdditionUpdate(MsgConstant.REQ_ADDITION_UPDATE, AdditionUpdateProcessor.class, AdditionUpdateRequest.class),

    /**
     * 领取连续签到奖励
     **/
    SignSeriesGet(MsgConstant.REQ_SIGN_SERIES_GET, SignSeriesGetProcessor.class, SignSeriesGetRequest.class),

    /**
     * 移除
     **/
    RemoveAvatar(MsgConstant.REQ_REMOVE_AVATAR, RemoveAvatarProcessor.class, RemoveAvatarRequest.class),

    /**
     * 完成新手引导
     **/
    TaskGuideDot(MsgConstant.REQ_TASK_GUIDE_DOT, TaskGuideDotProcessor.class, TaskGuideDotRequest.class),

    /**
     * 挂机离线受益(每小时)
     **/
    OfflineIncomeInfo(MsgConstant.REQ_OFFLINE_INCOME_INFO, OfflineIncomeInfoProcessor.class, OfflineIncomeInfoRequest.class),

    /**
     * Avatar死亡
     **/
    AvatarDie(MsgConstant.REQ_AVATAR_DIE, AvatarDieProcessor.class, AvatarDieRequest.class),


    /**
     * 时装脱下
     **/
    FashionTakeOff(MsgConstant.REQ_FASHION_TAKE_OFF, FashionTakeOffProcessor.class, FashionTakeOffRequest.class),

    /**
     * 获取鉴宝信息
     **/
    ChessBoardInfo(MsgConstant.REQ_CHESS_BOARD_INFO, ChessBoardInfoProcessor.class, ChessBoardInfoRequest.class),

    /**
     * 开启宝箱
     **/
    ChessBoardOpen(MsgConstant.REQ_CHESS_BOARD_OPEN, ChessBoardOpenProcessor.class, ChessBoardOpenRequest.class),

    /**
     * 抛骰子
     **/
    ChessBoardPlay(MsgConstant.REQ_CHESS_BOARD_PLAY, ChessBoardPlayProcessor.class, ChessBoardPlayRequest.class),

    /**
     * 立刻开启宝箱
     **/
    ChessBoardUse(MsgConstant.REQ_CHESS_BOARD_USE, ChessBoardUseProcessor.class, ChessBoardUseRequest.class),

    /**
     * 一键申请处理
     **/
    ApplyDealAKey(MsgConstant.REQ_APPLY_DEAL_AKEY, ApplyDealAKeyProcessor.class, ApplyDealAKeyRequest.class),

    /**
     * 获得奖励提示
     **/
    ChessBoardNotice(MsgConstant.REQ_CHESS_BOARD_NOTICE, ChessBoardNoticeProcessor.class, ChessBoardNoticeRequest.class),

    /**
     * 仙盟技能信息
     **/
    BlocSkillInfo(MsgConstant.REQ_BLOC_SKILL_INFO, BlocSkillInfoProcessor.class, BlocSkillInfoRequest.class),

    /**
     * 仙盟技能升级
     **/
    BlocSkillLevelup(MsgConstant.REQ_BLOC_SKILL_LEVELUP, BlocSkillLevelupProcessor.class, BlocSkillLevelupRequest.class),

    /**
     * 获取宝箱信息
     **/
    BagBoxInfo(MsgConstant.REQ_BAG_BOX_INFO, BagBoxInfoProcessor.class, BagBoxInfoRequest.class),

    /**
     * 开启背包宝箱
     **/
    BagBoxOpen(MsgConstant.REQ_BAG_BOX_OPEN, BagBoxOpenProcessor.class, BagBoxOpenRequest.class),

    /**
     * 延迟奖励弹窗
     **/
    DelayRewardNotice(MsgConstant.REQ_DELAY_REWARD_NOTICE, DelayRewardNoticeProcessor.class, DelayRewardNoticeRequest.class),

    /**
     * 仙盟红包推送
     **/
    BlocRedPush(MsgConstant.REQ_BLOC_RED_PUSH, BlocRedPushProcessor.class, BlocRedPushRequest.class),

    /**
     * 仙盟红包领取
     **/
    BlocRedGet(MsgConstant.REQ_BLOC_RED_GET, BlocRedGetProcessor.class, BlocRedGetRequest.class),

    /**
     * 作弊
     **/
    Cheat(MsgConstant.REQ_CHEAT, CheatProcessor.class, CheatRequest.class),

    /**
     * 领取活动错失奖励
     **/
    ActivityRewardLostGet(MsgConstant.REQ_ACTIVITY_REWARD_LOST_GET, ActivityRewardLostGetProcessor.class, ActivityRewardLostGetRequest.class),

    /**
     * 领取平台礼包
     **/
    ChannelGiftGet(MsgConstant.REQ_CHANNEL_GIFT_GET, ChannelGiftGetProcessor.class, ChannelGiftGetRequest.class),

    /**
     * 整理背包
     **/
    BagCollect(MsgConstant.REQ_BAG_COLLECT, BagCollectProcessor.class, BagCollectRequest.class),

    /**
     * 背包到仓库
     **/
    BagPotAdd(MsgConstant.REQ_BAG_POT_ADD, BagPotAddProcessor.class, BagPotAddRequest.class),

    /**
     * 整理背包
     **/
    BagPotCollect(MsgConstant.REQ_BAG_POT_COLLECT, BagPotCollectProcessor.class, BagPotCollectRequest.class),

    /**
     * 仓库到背包
     **/
    BagPotDelete(MsgConstant.REQ_BAG_POT_DELETE, BagPotDeleteProcessor.class, BagPotDeleteRequest.class),

    /**
     * 移动背包仓库
     **/
    BagPotMove(MsgConstant.REQ_BAG_POT_MOVE, BagPotMoveProcessor.class, BagPotMoveRequest.class),

    /**
     * 打开背包仓库
     **/
    BagPotOpen(MsgConstant.REQ_BAG_POT_OPEN, BagPotOpenProcessor.class, BagPotOpenRequest.class),

    /**
     * 移动背包
     **/
    BagMove(MsgConstant.REQ_BAG_MOVE, BagMoveProcessor.class, BagMoveRequest.class),

    /**
     * 设置
     **/
    SettingData(MsgConstant.REQ_SETTING_DATA, SettingDataProcessor.class, SettingDataRequest.class),

    /**
     * 更改设置
     **/
    ChangeSetting(MsgConstant.REQ_CHANGE_SETTING, ChangeSettingProcessor.class, ChangeSettingRequest.class),

    /**  解锁与上锁  **/
    ChangeLockState(MsgConstant.REQ_CHANGE_LOCK_STATE, ChangeLockStateProcessor.class, ChangeLockStateRequest.class),

    /**  修改密码  **/
    ChangePswd(MsgConstant.REQ_CHANGE_PSWD, ChangePswdProcessor.class, ChangePswdRequest.class),

    /**  修改密码  **/
    ClearPswd(MsgConstant.REQ_CLEAR_PSWD, ClearPswdProcessor.class, ClearPswdRequest.class),

    /**  安全锁信息  **/
    SaveLockInfo(MsgConstant.REQ_SAVE_LOCK_INFO, SafeLockInfoProcessor.class, SafeLockInfoRequest.class),

    /**  设置密码  **/
    SetPswd(MsgConstant.REQ_SET_PSWD, SetPswdProcessor.class, SetPswdRequest.class),

    /**
     * 主线支线任务
     **/
    TaskBranchComplete(MsgConstant.REQ_TASK_BRANCH_COMPLETE, TaskBranchCompleteProcessor.class, TaskBranchCompleteRequest.class),

    /**
     * 装备合成
     **/
    EquipCompose(MsgConstant.REQ_EQUIP_COMPOSE, EquipComposeProcessor.class, EquipComposeRequest.class),

    /**
     * 经验本信息
     **/
    ExpInsInfo(MsgConstant.REQ_EXP_INS_INFO, ExpInsInfoProcessor.class, ExpInsInfoRequest.class),

    /**
     * boss出现通知
     **/
    BossAppear(MsgConstant.REQ_BOSS_APPEAR, BossAppearProcessor.class, BossAppearRequest.class),

    /**
     * 退出副本(单人本和多人本)
     **/
    ExitSingleIns(MsgConstant.REQ_EXIT_SINGLE_INS, ExitSingleInsProcessor.class, ExitSingleInsRequest.class),

    /**
     * 攻打副本怪物,验证技能的CD时间
     **/
    FightSingleSceneActor(MsgConstant.REQ_FIGHT_SINGLE_SCENEACTOR, FightSingleSceneActorProcessor.class, FightSingleSceneActorRequest.class),

    /**
     * 副本挑战
     **/
    InsChallenge(MsgConstant.REQ_INS_CHALLENGE, InsChallengeProcessor.class, InsChallengeRequest.class),

    /**
     * 守护仙灵
     **/
    ShxlInfo(MsgConstant.REQ_SHXL_INFO, ShxlInfoProcessor.class, ShxlInfoRequest.class),

    /**
     * 仙帝宝库
     **/
    XdbkInfo(MsgConstant.REQ_XDBK_INFO, XdbkInfoProcessor.class, XdbkInfoRequest.class),

    /**
     * 诛仙塔
     **/
    ZxTowerInfo(MsgConstant.REQ_ZXTOWER_INFO, ZxTowerInfoProcessor.class, ZxTowerInfoRequest.class),

    /**
     * 副本剩余时间
     **/
    InsLeftTime(MsgConstant.REQ_INS_LEFT_TIME, InsLeftTimeProcessor.class, InsLeftTimeRequest.class),

    /**
     * 杀死副本目标
     **/
    KillSingleSceneActor(MsgConstant.REQ_KILL_SINGLE_SCENEACTOR, KillSingleSceneActorProcessor.class, KillSingleSceneActorRequest.class),

    /**
     * 玩家属性
     **/
    RefreshActor(MsgConstant.REQ_REFRESH_ACTOR, RefreshActorProcessor.class, RefreshActorRequest.class),

    /**
     * 刷新副本怪物
     **/
    RefreshSceneActor(MsgConstant.REQ_REFRESH_SCENE_ACTOR, RefreshSceneActorProcessor.class, RefreshSceneActorRequest.class),

    /**
     * 副本挑战结果
     **/
    ResultChallenge(MsgConstant.REQ_RESULT_CHALLENGE, ResultChallengeProcessor.class, ResultChallengeRequest.class),

    /**
     * 获取随机数列表
     **/
    SingleInsRands(MsgConstant.REQ_ENTER_SINGLE_RANDS, SingleInsRandsProcessor.class, SingleInsRandsRequest.class),

    /**
     * 购买次数
     **/
    BuySingleInsNum(MsgConstant.REQ_BUY_SINGLE_INS_NUM, BuySingleInsNumProcessor.class, BuySingleInsNumRequest.class),

    /**
     * 清副本cd
     **/
    ClearCd(MsgConstant.REQ_CLEAR_CD, ClearCdProcessor.class, ClearCdRequest.class),

    /**
     * 当前波数
     **/
    CurBatch(MsgConstant.REQ_CUR_BATCH, CurBatchProcessor.class, CurBatchRequest.class),

    /**
     * 总经验
     **/
    TotleExp(MsgConstant.REQ_TOTLE_EXP, TotleExpProcessor.class, TotleExpRequest.class),

    /**
     * 鼓舞
     **/
    Inspire(MsgConstant.REQ_INSPIRE, InspireProcessor.class, InspireRequest.class),

    /**
     * 申请加入队伍
     **/
    TeamApplyJoin(MsgConstant.REQ_TEAM_APPLY_JOIN, TeamApplyJoinProcessor.class, TeamApplyJoinRequest.class),
    /**
     * 队伍自动匹配
     **/
    TeamAutoMatch(MsgConstant.REQ_TEAM_AUTO_MATCH, TeamAutoMatchProcessor.class, TeamAutoMatchRequest.class),

    /**
     * 一键拒绝申请
     **/
    TeamBatchRejectApply(MsgConstant.REQ_TEAM_BATCH_REJECT_APPLY, TeamBatchRejectApplyProcessor.class, TeamBatchRejectApplyRequest.class),

    /**
     * 取消队伍自动匹配
     **/
    TeamCancelAutoMatch(MsgConstant.REQ_TEAM_CANCEL_AUTO_MATCH, TeamCancelAutoMatchProcessor.class, TeamCancelAutoMatchRequest.class),

    /**
     * 更改队伍属性
     **/
    TeamChangeProp(MsgConstant.REQ_TEAM_CHANGE_PROP, TeamChangePropProcessor.class, TeamChangePropRequest.class),

    /**
     * 更改队伍属性通知
     **/
    TeamChangePropResp(MsgConstant.REQ_TEAM_CHANGE_PROP_RESP, TeamChangePropRespProcessor.class, TeamChangePropRespRequest.class),

    /**
     * 便捷组队
     **/
    TeamConvenientMatch(MsgConstant.REQ_TEAM_CON_MATCH, TeamConvenientMatchProcessor.class, TeamConvenientMatchRequest.class),

    /**
     * 创建队伍
     **/
    TeamCreate(MsgConstant.REQ_TEAM_CREATE, TeamCreateProcessor.class, TeamCreateRequest.class),

    /**
     * 邀请加入队伍
     **/
    TeamInvite(MsgConstant.REQ_TEAM_INVITE, TeamInviteProcessor.class, TeamInviteRequest.class),

    /**
     * 邀请加入队伍世界频道通知
     **/
    TeamInviteNotice(MsgConstant.REQ_TEAM_INVITE_NOTICE, TeamInviteNoticeProcessor.class, TeamInviteNoticeRequest.class),

    /**
     * 邀请加入队伍通知
     **/
    TeamInviteResp(MsgConstant.REQ_TEAM_INVITE_RESP, TeamInviteRespProcessor.class, TeamInviteRespRequest.class),

    /**
     * 批准加入队伍
     **/
    TeamJoin(MsgConstant.REQ_TEAM_JOIN, TeamJoinProcessor.class, TeamJoinRequest.class),

    /**
     * 踢出队伍
     **/
    TeamKickout(MsgConstant.REQ_TEAM_KICKOUT, TeamKickoutProcessor.class, TeamKickoutRequest.class),

    /**
     * 离开队伍
     **/
    TeamLeave(MsgConstant.REQ_TEAM_LEAVE, TeamLeaveProcessor.class, TeamLeaveRequest.class),

    /**
     * 队伍通知
     **/
    TeamMatchResp(MsgConstant.REQ_TEAM_MATCH_RESP, TeamMatchRespProcessor.class, TeamMatchRespRequest.class),

    /**
     * 拒绝申请
     **/
    TeamRejectApply(MsgConstant.REQ_TEAM_REJECT_APPLY, TeamRejectApplyProcessor.class, TeamRejectApplyRequest.class),

    /**
     * 附近队伍
     **/
    TeamNearby(MsgConstant.REQ_TEAM_NEARBY, TeamNearbyProcessor.class, TeamNearbyRequest.class),

    /**
     * 获取申请列表
     **/
    TeamApplyQueue(MsgConstant.REQ_TEAM_APPLY_QUEUE, TeamApplyQueueProcessor.class, TeamApplyQueueRequest.class),

    /**
     * 移交队长
     **/
    TeamExchangeLeader(MsgConstant.REQ_TEAM_EXCHANGE_LEADER, TeamExchangeLeaderProcessor.class, TeamExchangeLeaderRequest.class),

    /**  队员切换场景  **/
    TeamMemberScene(MsgConstant.REQ_TEAM_MEMBER_SCENE, TeamMemberSceneProcessor.class, TeamMemberSceneRequest.class),

    /**  切换场景通知  **/
    TeamSceneNotice(MsgConstant.REQ_TEAM_SCENE_NOTICE, TeamSceneNoticeProcessor.class, TeamSceneNoticeRequest.class),

    /**  申请通知  **/
    TeamApplyNotice(MsgConstant.REQ_TEAM_APPLY_NOTICE, TeamApplyNoticeProcessor.class, TeamApplyNoticeRequest.class),

    /**
     * 符文分解
     **/
    RuneDecompose(MsgConstant.REQ_RUNE_DECOMPOSE, RuneDecomposeProcessor.class, RuneDecomposeRequest.class),

    /**
     * 符文兑换
     **/
    RuneExchange(MsgConstant.REQ_RUNE_EXCHANGE, RuneExchangeProcessor.class, RuneExchangeRequest.class),

    /**
     * 符文镶嵌
     **/
    RuneSet(MsgConstant.REQ_RUNE_SET, RuneSetProcessor.class, RuneSetRequest.class),

    /**
     * 符文升级
     **/
    RuneUpLevel(MsgConstant.REQ_RUNE_UP_LEVEL, RuneUpLevelProcessor.class, RuneUpLevelRequest.class),

    /**
     * 查看符文信息
     **/
    RuneCheck(MsgConstant.REQ_RUNE_CHECK, RuneCheckProcessor.class, RuneCheckRequest.class),

    /**
     * 改名
     **/
    ChangeName(MsgConstant.REQ_CHANGE_NAME, ChangeNameProcessor.class, ChangeNameRequest.class),

    /**
     * 直达创角
     **/
    CreateAndLogin(MsgConstant.REQ_CREATE_AND_LOGIN, CreateAndLoginProcessor.class, CreateAndLoginRequest.class),
    /**
     * 日常任务找回信息
     **/
    TaskBackInfo(MsgConstant.REQ_TASK_BACK_INFO, TaskBackInfoProcessor.class, TaskBackInfoRequest.class),

    /**
     * 日常任务找回奖励
     **/
    TaskShapeChange(MsgConstant.REQ_TASK_SHAPE_CHANGE, TaskShapeChangeProcessor.class, TaskShapeChangeRequest.class),

    /**
     * 符文添加
     **/
    RuneAdd(MsgConstant.REQ_RUNE_ADD, RuneAddProcessor.class, RuneAddRequest.class),

    /**
     * 竞技场鼓励
     **/
    ArenaEncourage(MsgConstant.REQ_ARENA_ENCOURAGE, ArenaEncourageProcessor.class, ArenaEncourageRequest.class),

    /**
     * 竞技场刷新
     **/
    ArenaRefresh(MsgConstant.REQ_ARENA_REFRESH, ArenaRefreshProcessor.class, ArenaRefreshRequest.class),

    /**
     * 仙盟升级
     **/
    BlocUpLevel(MsgConstant.REQ_BLOC_UP_LEVEL, BlocUpLevelProcessor.class, BlocUpLevelRequest.class),

    /**
     * 仙盟升级
     **/
    BlocSetting(MsgConstant.REQ_BLOC_SETTING, BlocSettingProcessor.class, BlocSettingRequest.class),

    /**
     * 仙盟工资领取
     **/
    BlocWages(MsgConstant.REQ_BLOC_WAGES, BlocWagesProcessor.class, BlocWagesRequest.class),


    /**
     * 仙盟升级
     **/
    BlocSettingInfo(MsgConstant.REQ_BLOC_SETTING_INFO, BlocSettingInfoProcessor.class, BlocSettingInfoRequest.class),

    /**
     * 申请加入仙盟
     **/
    BlocChange(MsgConstant.REQ_BLOC_CHANGE, BlocChangeProcessor.class, BlocChangeRequest.class),

    /**
     * 职位变更
     **/
    PositionChange(MsgConstant.REQ_POSITION_CHANGE, PositionChangeProcessor.class, PositionChangeRequest.class),

    /**
     * 进入boss地图
     **/
    BossChallenge(MsgConstant.REQ_BOSS_CHALLENGE, BossChallengeProcessor.class, BossChallengeRequest.class),

    /**
     * 地图boss信息
     **/
    BossSceneInfo(MsgConstant.REQ_BOSS_SCENE_INFO, BossSceneInfoProcessor.class, BossSceneInfoRequest.class),

    /**
     * 赏金任务完成
     **/
    TaskBountyComplete(MsgConstant.REQ_TASK_BOUNTY_COMPLETE, TaskBountyCompleteProcessor.class, TaskBountyCompleteRequest.class),

    /**
     * 外形隐藏OR显示
     **/
    ModelHide(MsgConstant.REQ_MODEL_HIDE, ModelHideProcessor.class, ModelHideRequest.class),

    /**
     * 时装激活
     **/
    FashionDecompose(MsgConstant.REQ_FASHION_DECOMPOSE, FashionDecomposeProcessor.class, FashionDecomposeRequest.class),

    /**
     * 时装升级
     **/
    FashionUpLevel(MsgConstant.REQ_FASHION_UP_LEVEL, FashionUpLevelProcessor.class, FashionUpLevelRequest.class),

    /**
     * 时装升星
     **/
    FashionUpStar(MsgConstant.REQ_FASHION_UP_STAR, FashionUpStarProcessor.class, FashionUpStarRequest.class),

    /**
     * 境界升级
     **/
    StateUpLevel(MsgConstant.REQ_STATE_UP_LEVEL, StateUpLevelProcessor.class, StateUpLevelRequest.class),

    /**
     * 宠骑幻化激活
     **/
    PetIllusionActive(MsgConstant.REQ_PET_ILLUSION_ACTIVE, PetIllusionActiveProcessor.class, PetIllusionActiveRequest.class),

    /**
     * 宠骑幻化激活
     **/
    PetIllusionAddBless(MsgConstant.REQ_PET_ILLUSION_ADD_BLESS, PetIllusionAddBlessProcessor.class, PetIllusionAddBlessRequest.class),

    /**
     * 祝福幻化激活
     **/
    BlessIllusionActive(MsgConstant.REQ_BLESS_ILLUSION_ACTIVE, BlessIllusionActiveProcessor.class, BlessIllusionActiveRequest.class),

    /**
     * 宠骑幻化激活
     **/
    BlessIllusionUpLevel(MsgConstant.REQ_BLESS_ILLUSION_UP_LEVEL, BlessIllusionUpLevelProcessor.class, BlessIllusionUpLevelRequest.class),

    /**
     * 元宝一键完成
     **/
    TaskCCYBDone(MsgConstant.REQ_TASK_CCYB_DONE, TaskCCYBDoneProcessor.class, TaskCCYBDoneRequest.class),

    /**
     * 客户端进度单独taskID
     **/
    TaskClientScheduleSingle(MsgConstant.REQ_TASK_CLIENT_SCHEDULE_SINGLE, TaskClientScheduleSingleProcessor.class, TaskClientScheduleSingleRequest.class),

    /**
     * 转生任务完成
     **/
    TaskTransferComplete(MsgConstant.REQ_TASK_TRANSFER_COMPLETE, TaskTransferCompleteProcessor.class, TaskTransferCompleteRequest.class), /**
     * 转职升阶
     **/
    StageUp(MsgConstant.REQ_STAGE_UP, StageUpProcessor.class, StageUpRequest.class),

    /**
     * 转职升阶通知
     **/
    TransferNotice(MsgConstant.REQ_TRANSFER_NOTICE, TransferNoticeProcessor.class, TransferNoticeRequest.class),


    /**
     * boss疲劳
     **/
    BossFatigue(MsgConstant.REQ_BOSS_FATIGUE, BossFatigueProcessor.class, BossFatigueRequest.class),

    /**
     * boss归属
     **/
    BossOwner(MsgConstant.REQ_BOSS_OWNER, BossOwnerProcessor.class, BossOwnerRequest.class),

    /**
     * boss击杀信息
     **/
    BossKillInfo(MsgConstant.REQ_BOSS_KILL_INFO, BossKillInfoProcessor.class, BossKillInfoRequest.class),

    /**
     * 关注
     **/
    BossAttention(MsgConstant.REQ_BOSS_ATTENTION, BossAttentionProcessor.class, BossAttentionRequest.class),

    /**
     * 关注信息
     **/
    BossAttentionList(MsgConstant.REQ_BOSS_ATTENTION_LIST, BossAttentionListProcessor.class, BossAttentionListRequest.class),

    /**
     * 仙盟boss通知
     **/
    BlocBossEnter(MsgConstant.REQ_BLOC_BOSS_ENTER, BlocBossEnterProcessor.class, BlocBossEnterRequest.class),

    /**
     * 仙盟boss通知
     **/
    BlocBossNotice(MsgConstant.REQ_BLOC_BOSS_NOTICE, BlocBossNoticeProcessor.class, BlocBossNoticeRequest.class),

    /**
     * 仙盟boss开启
     **/
    BlocBossOpen(MsgConstant.REQ_BLOC_BOSS_OPEN, BlocBossOpenProcessor.class, BlocBossOpenRequest.class),

    /**
     * 兽粮上交
     **/
    BlocFoodSubmit(MsgConstant.REQ_BLOC_FOOD_SUBMIT, BlocFoodSubmitProcessor.class, BlocFoodSubmitRequest.class),

    /**
     * 宠骑祝福幻化信息
     **/
    PetIllusionInfo(MsgConstant.REQ_PET_ILLUSION_INFO, PetIllusionInfoProcessor.class, PetIllusionInfoRequest.class),

    /**
     * 交答案
     **/
    ExamAnswer(MsgConstant.REQ_EXAM_ANSWER, ExamAnswerProcessor.class, ExamAnswerRequest.class),

    /**
     * 答题信息
     **/
    ExamInfo(MsgConstant.REQ_EXAM_INFO, ExamInfoProcessor.class, ExamInfoRequest.class),

    /**
     * 使用答题道具
     **/
    ExamItemUse(MsgConstant.REQ_EXAM_ITEM_USE, ExamItemUseProcessor.class, ExamItemUseRequest.class),

    /**
     * 仙盟boss信息
     **/
    BlocBossInfo(MsgConstant.REQ_BLOC_BOSS_INFO, BlocBossInfoProcessor.class, BlocBossInfoRequest.class),


    /**
     * 仙盟boss剩余时间通知
     **/
    BlocBossRemainTime(MsgConstant.REQ_BLOC_BOSS_REMAIN_TIME, BlocBossRemainTimeProcessor.class, BlocBossRemainTimeRequest.class),

    /**
     * 获取祈福奖励
     **/
    PrayGet(MsgConstant.REQ_PRAY_GET, PrayGetProcessor.class, PrayGetRequest.class),

    /**
     * 祈福信息
     **/
    PrayInfo(MsgConstant.REQ_PRAY_INFO, PrayInfoProcessor.class, PrayInfoRequest.class),

    /**
     * 接护送任务
     **/
    TaskBeautyAccepet(MsgConstant.REQ_TASK_BEAUTY_ACCEPET, TaskBeautyAccepetProcessor.class, TaskBeautyAccepetRequest.class),

    /**
     * 护送美女完成
     **/
    TaskBeautyComplete(MsgConstant.REQ_TASK_BEAUTY_COMPLETE, TaskBeautyCompleteProcessor.class, TaskBeautyCompleteRequest.class),


    /**
     * 副本确认状态通知
     **/
    ConfirmNotice(MsgConstant.REQ_CONFIRM_NOTICE, ConfirmNoticeProcessor.class, ConfirmNoticeRequest.class),

    /**
     * 装备本信息
     **/
    EquipInsInfo(MsgConstant.REQ_EQUIP_INS_INFO, EquipInsInfoProcessor.class, EquipInsInfoRequest.class),

    /**
     * 副本确认
     **/
    InsConfirm(MsgConstant.REQ_INS_CONFIRM, InsConfirmProcessor.class, InsConfirmRequest.class),

    /**
     * 开启副本
     **/
    OpenIns(MsgConstant.REQ_OPEN_INS, OpenInsProcessor.class, OpenInsRequest.class),

    /**
     * 装备副本结果
     **/
    ResultEquipIns(MsgConstant.REQ_RESULT_EQUIP_INS, ResultEquipInsProcessor.class, ResultEquipInsRequest.class),

    /**
     * 副本剩余时间通知
     **/
    InsRemainTime(MsgConstant.REQ_INS_REMAIN_TIME, InsRemainTimeProcessor.class, InsRemainTimeRequest.class),

    /**
     * 击杀奖励数据
     **/
    BossKillRewardList(MsgConstant.REQ_BOSS_KILL_REWARD_LIST, BossKillRewardListProcessor.class, BossKillRewardListRequest.class),

    /**
     * 购买道具
     **/
    BuyMarketItem(MsgConstant.REQ_BUY_MARKET_ITEM, BuyMarketItemProcessor.class, BuyMarketItemRequest.class),
    /**
     * 购买月卡
     **/
    MonthCardBuy(MsgConstant.REQ_MONTH_CARD_BUY, MonthCardBuyProcessor.class, MonthCardBuyRequest.class),

    /**
     * 交易记录列表
     **/
    DealRecords(MsgConstant.REQ_DEAL_RECORDS, DealRecordsProcessor.class, DealRecordsRequest.class),

    /**
     * 在售道具列表
     **/
    MarketItemList(MsgConstant.REQ_MARKET_ITEM_LIST, MarketItemListProcessor.class, MarketItemListRequest.class),

    /**
     * 在售物品
     **/
    OnSaleItems(MsgConstant.REQ_ONSALE_ITEMS, OnSaleItemsProcessor.class, OnSaleItemsRequest.class),

    /**
     * 搜索道具
     **/
    SearchItem(MsgConstant.REQ_SEARCH_ITEM, SearchItemProcessor.class, SearchItemRequest.class),

    /**
     * 出售物品
     **/
    ToSaleItem(MsgConstant.REQ_TOSALE_ITEMS, ToSaleItemProcessor.class, ToSaleItemRequest.class),

    /**
     * 手动下架物品
     **/
    OffSaleItem(MsgConstant.REQ_OFFSALE_ITEMS, OffSaleItemProcessor.class, OffSaleItemRequest.class),

    /**
     * 成就信息
     **/
    AchievementInfo(MsgConstant.REQ_ACHIEVEMENT_INFO, AchievementInfoProcessor.class, AchievementInfoRequest.class),

    /**
     * 获取成就奖励
     **/
    GetAchievementAward(MsgConstant.REQ_GET_ACHIEVEMENT_AWARD, GetAchievementAwardProcessor.class, GetAchievementAwardRequest.class),

    /**
     * 小飞鞋
     **/
    FlyShoes(MsgConstant.REQ_FLY_SHOES, FlyShoesProcessor.class, FlyShoesRequest.class),

    /**
     * 仙盟红包明细
     **/
    BlocRedDetail(MsgConstant.REQ_BLOC_RED_DETAIL, BlocRedDetailProcessor.class, BlocRedDetailRequest.class),

    /**
     * 仙盟红包列表
     **/
    BlocRedList(MsgConstant.REQ_BLOC_RED_LIST, BlocRedListProcessor.class, BlocRedListRequest.class),

    /**
     * 仙盟红包推送
     **/
    BlocRedSend(MsgConstant.REQ_BLOC_RED_SEND, BlocRedSendProcessor.class, BlocRedSendRequest.class),

    /**
     * v6发红包
     **/
    VipSendRed(MsgConstant.REQ_VIP_SEND_RED, VipSendRedProcessor.class, VipSendRedRequest.class),


    /**
     * 蛮荒怒气变化通知
     **/
    WildAngerNotice(MsgConstant.REQ_WILD_ANGER_NOTICE, WildAngerNoticeProcessor.class, WildAngerNoticeRequest.class),

    /**
     * 蛮荒禁地进入
     **/
    WildEnter(MsgConstant.REQ_WILD_ENTER, WildEnterProcessor.class, WildEnterRequest.class),

    /**
     * 蛮荒禁地信息
     **/
    WildInfo(MsgConstant.REQ_WILD_INFO, WildInfoProcessor.class, WildInfoRequest.class),

    /**
     * 开始匹配
     **/
    PeakFight(MsgConstant.REQ_PEAK_FIGHT, PeakFightProcessor.class, PeakFightRequest.class),

    /**
     * 领取段位奖励
     **/
    PeakGetDailyReward(MsgConstant.REQ_PEAK_GET_DAILY_REWARD, PeakGetDailyRewardProcessor.class, PeakGetDailyRewardRequest.class),

    /**
     * 领取段位奖励
     **/
    PeakGetRankReward(MsgConstant.REQ_PEAK_GET_RANK_REWARD, PeakGetRankRewardProcessor.class, PeakGetRankRewardRequest.class),

    /**
     * 玩家巅峰竞技信息
     **/
    PeakInfo(MsgConstant.REQ_PEAK_INFO, PeakInfoProcessor.class, PeakInfoRequest.class),

    /**
     * 战斗结果
     **/
    PeakResult(MsgConstant.REQ_PEAK_RESULT, PeakResultProcessor.class, PeakResultRequest.class),

    /**
     * 进入战斗场景
     **/
    PeakEnter(MsgConstant.REQ_PEAK_ENTER, PeakEnterProcessor.class, PeakEnterRequest.class),

    /**
     * 匹配成功
     **/
    PeakMatched(MsgConstant.REQ_PEAK_MATCHED, PeakMatchedProcessor.class, PeakMatchedRequest.class),

    /**
     * 积分排行
     **/
    PeakRankList(MsgConstant.REQ_PEAK_RANK_LIST, PeakRankListProcessor.class, PeakRankListRequest.class),

    /**
     * 刷新成就种类
     **/
    AchievementRefresh(MsgConstant.REQ_ACHIEVEMENT_REFRESH, AchievementRefreshProcessor.class, AchievementRefreshRequest.class),
    /**
     * 全服记录
     **/
    AllRecord(MsgConstant.REQ_ALL_RECORD, AllRecordProcessor.class, AllRecordRequest.class),

    /**
     * 个人纪录
     **/
    PersonRecord(MsgConstant.REQ_PERSONAL_RECORD, PersonRecordProcessor.class, PersonRecordRequest.class),

    /**
     * 积分兑换道具
     **/
    PointExchange(MsgConstant.REQ_POINT_EXCHANGE, PointExchangeProcessor.class, PointExchangeRequest.class),

    /**
     * 符文寻宝信息
     **/
    RuneInfo(MsgConstant.REQ_RUNE_INFO, RuneInfoProcessor.class, RuneInfoRequest.class),

    /**
     * 装备寻宝
     **/
    TreasureEquip(MsgConstant.REQ_TREASURE_EQUIP, TreasureEquipProcessor.class, TreasureEquipRequest.class),

    /**
     * 符文寻宝
     **/
    TreasureRune(MsgConstant.REQ_TREASURE_RUNE, TreasureRuneProcessor.class, TreasureRuneRequest.class),

    /**
     * 巅峰寻宝
     **/
    TreasureTop(MsgConstant.REQ_TREASURE_TOP, TreasureTopProcessor.class, TreasureTopRequest.class),


    /**
     * 仙盟仓库信息
     **/
    BlocDepotInfo(MsgConstant.REQ_BLOC_DEPOT_INFO, BlocDepotInfoProcessor.class, BlocDepotInfoRequest.class),

    /**
     * 仙盟捐献
     **/
    BlocDonate(MsgConstant.REQ_BLOC_DONATE, BlocDonateProcessor.class, BlocDonateRequest.class),

    /**
     * 仙盟装备销毁
     **/
    BlocEquipDestroy(MsgConstant.REQ_BLOC_EQUIP_DESTROY, BlocEquipDestroyProcessor.class, BlocEquipDestroyRequest.class),

    /**
     * 仙盟仓库积分兑换
     **/
    DepotScoreExchange(MsgConstant.REQ_DEPOT_SCORE_EXCHANGE, DepotScoreExchangeProcessor.class, DepotScoreExchangeRequest.class),


    /**
     * 仙盟仓库道具添加通知
     **/
    BlocDepotAddNotice(MsgConstant.REQ_BLOC_DEPOT_ADD_NOTICE, BlocDepotAddNoticeProcessor.class, BlocDepotAddNoticeRequest.class),

    /**
     * 仙盟仓库道具移除通知
     **/
    BlocDepotRemoveNotice(MsgConstant.REQ_BLOC_DEPOT_REMOVE_NOTICE, BlocDepotRemoveNoticeProcessor.class, BlocDepotRemoveNoticeRequest.class),

    /**
     * 开启可选择道具的宝箱
     **/
    BagChooseBoxOpen(MsgConstant.REQ_BAG_CHOOSE_BOX_OPEN, BagChooseBoxOpenProcessor.class, BagChooseBoxOpenRequest.class),

    /**
     * 刷新buff
     **/
    BuffInfos(MsgConstant.REQ_BUFF_INFOS, BuffInfosProcessor.class, BuffInfosRequest.class),

    /**
     * 青云之颠进入
     **/
    BlueCloudEnter(MsgConstant.REQ_BLUE_CLOUD_ENTER, BlueCloudEnterProcessor.class, BlueCloudEnterRequest.class),

    /**
     * 青云之颠积分通知
     **/
    BlueCloudScoreNotice(MsgConstant.REQ_BLUE_CLOUD_SCORE_NOTICE, BlueCloudScoreNoticeProcessor.class, BlueCloudScoreNoticeRequest.class),

    /**
     * buff伤害
     **/
    BuffHit(MsgConstant.REQ_BUFF_HIT, BuffHitProcessor.class, BuffHitRequest.class),

    /**
     * 使用红包道具
     **/
    BagRedUse(MsgConstant.REQ_BAG_RED_USE, BagRedUseProcessor.class, BagRedUseRequest.class),

    /**
     * 获得冲级豪礼信息
     **/
    LevelupGiftInfo(MsgConstant.REQ_LEVELUP_GIFT_INFO, LevelupGiftInfoProcessor.class, LevelupGiftInfoRequest.class),

    /**
     * 领取冲级豪礼
     **/
    LevelupGiftOpen(MsgConstant.REQ_LEVELUP_GIFT_OPEN, LevelupGiftOpenProcessor.class, LevelupGiftOpenRequest.class),

    /**
     * 每日累充信息
     **/
    RechargeDailyInfo(MsgConstant.REQ_RECHARGE_DAILY_INFO, RechargeDailyInfoProcessor.class, RechargeDailyInfoRequest.class),

    /**
     * 领取累充奖励
     **/
    RechargeDailyOpen(MsgConstant.REQ_RECHARGE_DAILY_OPEN, RechargeDailyOpenProcessor.class, RechargeDailyOpenRequest.class),

    /**
     * 领取开服7日充值奖励
     **/
    RechargeOpenServerGet(MsgConstant.REQ_RECHARGE_OPENSERVER_GET, RechargeOpenServerGetProcessor.class, RechargeOpenServerGetRequest.class),

    /**
     * 开服7日充值
     **/
    RechargeOpenServerInfo(MsgConstant.REQ_RECHARGE_OPENSERVER_INFO, RechargeOpenServerInfoProcessor.class, RechargeOpenServerInfoRequest.class),

    /**  每日累充信息  **/
    RechargeCcyBind(MsgConstant.REQ_RECHARGE_CCY_BIND, RechargeCcyBindProcessor.class, RechargeCcyBindRequest.class),

    /**
     * 天书寻主信息
     **/
    BookInfo(MsgConstant.REQ_BOOK_INFO, BookInfoProcessor.class, BookInfoRequest.class),

    /**
     * 领取天书寻主奖励
     **/
    BookReceive(MsgConstant.REQ_BOOK_RECEIVE, BookReceiveProcessor.class, BookReceiveRequest.class),

    /**
     * 领取冲榜奖励
     **/
    FlushListGet(MsgConstant.REQ_FLUSH_LIST_GET, FlushListGetProcessor.class, FlushListGetRequest.class),

    /**
     * 冲榜活动信息
     **/
    FlushListInfo(MsgConstant.REQ_FLUSH_LIST_INFO, FlushListInfoProcessor.class, FlushListInfoRequest.class),

    /**
     * 冲榜活动排行榜信息
     **/
    FlushListRankInfo(MsgConstant.REQ_FLUSH_LIST_RANK_INFO, FlushListRankInfoProcessor.class, FlushListRankInfoRequest.class),

    /**
     * 获取集字活动奖励
     **/
    CollectReceive(MsgConstant.REQ_COLLEC_RECEIVE, CollectReceiveProcessor.class, CollectReceiveRequest.class),

    /**
     * 获取开宗立派奖励
     **/
    CreateBlocReceive(MsgConstant.REQ_CREATE_BLOC_RECEIVE, CreateBlocReceiveProcessor.class, CreateBlocReceiveRequest.class),

    /**
     * 开服狂欢信息
     **/
    ServerOpenInfo(MsgConstant.REQ_SERVER_OPEN_INFO, ServerOpenInfoProcessor.class, ServerOpenInfoRequest.class),

    /**
     * 查看玩家信息
     **/
    CheckPlayerInfo(MsgConstant.REQ_CHECK_PLAYER_INFO, CheckPlayerInfoProcessor.class, CheckPlayerInfoRequest.class),

    /**
     * 装备套装锻造
     **/
    EquipSuitForge(MsgConstant.REQ_EQUIP_SUIT_FORGE, EquipSuitForgeProcessor.class, EquipSuitForgeRequest.class),

    /**
     * 装备卸下
     **/
    EquipRemove(MsgConstant.REQ_EQUIP_REMOVE, EquipRemoveProcessor.class, EquipRemoveRequest.class),

    /**
     * 守护续费
     **/
    GuardRenew(MsgConstant.REQ_GUARD_RENEW, GuardRenewProcessor.class, GuardRenewRequest.class),

    /**
     * 个人Boss信息
     **/
    PersonalBossInfo(MsgConstant.REQ_PERSONAL_BOSS_INFO, PersonalBossInfoProcessor.class, PersonalBossInfoRequest.class),

    /**
     * 个人Boss进入地图
     **/
    PersonalEnter(MsgConstant.REQ_PERSONAL_ENTER, PersonalEnterProcessor.class, PersonalEnterRequest.class),

	/**  仙盟捐献任务  **/
	BlocDonateTaskComplete(MsgConstant.REQ_BLOC_DONATE_TASK_COMPLETE, BlocDonateTaskCompleteProcessor.class, BlocDonateTaskCompleteRequest.class),

	/**  日常积分奖励  **/
	TaskDailyProcess(MsgConstant.REQ_TASK_DAILY_PROCESS, TaskDailyProcessProcessor.class, TaskDailyProcessRequest.class),

	/**  仙盟答题信息推送  **/
	PartyInfoPush(MsgConstant.REQ_PARTY_INFO_PUSH, PartyInfoPushProcessor.class, PartyInfoPushRequest.class),

	/**  仙盟晚宴问题推送  **/
	PartyQuestionPush(MsgConstant.REQ_PARTY_QUESTION_PUSH, PartyQuestionPushProcessor.class, PartyQuestionPushRequest.class),

	/**  仙盟答题加分推送  **/
	PartyScoreAdd(MsgConstant.REQ_PARTY_SCORE_ADD, PartyScoreAddProcessor.class, PartyScoreAddRequest.class),

	/**  进入仙盟晚宴  **/
	PartyEnter(MsgConstant.REQ_PARTY_ENTER, PartyEnterProcessor.class, PartyEnterRequest.class),

	/**  领取烧猪  **/
	PartyGetPig(MsgConstant.REQ_PARTY_GET_PIG, PartyGetPigProcessor.class, PartyGetPigRequest.class),

	/**  仙盟晚宴当前累计奖励  **/
	PartyRewardInfo(MsgConstant.REQ_PARTY_REWARD_INFO, PartyRewardInfoProcessor.class, PartyRewardInfoRequest.class),

	/**  限时活动开启通知  **/
	DailyOpenNotice(MsgConstant.REQ_DAILY_OPEN_NOTICE, DailyOpenNoticeProcessor.class, DailyOpenNoticeRequest.class),

	/**  获取寻宝积分奖励  **/
	GetTreasurePointReward(MsgConstant.REQ_GET_TREASURE_POINT_REWARD, GetTreasurePointRewardProcessor.class, GetTreasurePointRewardRequest.class),

	/**  寻宝积分信息  **/
	TreasurePointInfo(MsgConstant.REQ_TREASURE_POINT_INFO, TreasurePointInfoProcessor.class, TreasurePointInfoRequest.class),

	/**  宝石精炼  **/
	EquipRefine(MsgConstant.REQ_EQUIP_REFINE, EquipRefineProcessor.class, EquipRefineRequest.class),

	/**  购买七日活动商品  **/
	BuySevenDayGoods(MsgConstant.REQ_BUY_SEVEN_DAY_GOODS, BuySevenDayGoodsProcessor.class, BuySevenDayGoodsRequest.class),

	/**  获取七日活动奖励  **/
	ReceiveSevenDayReward(MsgConstant.REQ_RECEIVE_SEVEN_DAY_REWARD, ReceiveSevenDayRewardProcessor.class, ReceiveSevenDayRewardRequest.class),

	/**  七日活动信息  **/
	SevenDayInfo(MsgConstant.REQ_SEVEN_DAY_INFO, SevenDayInfoProcessor.class, SevenDayInfoRequest.class),
	/**  获赠好友花朵  **/
	FriendGetFlowers(MsgConstant.REQ_FRIEND_GET_FLOWERS, FriendGetFlowersProcessor.class, FriendGetFlowersRequest.class),

	/**  公告奖励领取  **/
	NoticeRewardGet(MsgConstant.REQ_NOTICE_REWARD_GET, NoticeRewardGetProcessor.class, NoticeRewardGetRequest.class),

	/**  公告奖励领取信息  **/
	NoticeRewardInfo(MsgConstant.REQ_NOTICE_REWARD_INFO, NoticeRewardInfoProcessor.class, NoticeRewardInfoRequest.class),

	/**  玩家更改速度  **/
	ChangeSpeed(MsgConstant.REQ_CHANGE_SPEED, ChangeSpeedProcessor.class, ChangeSpeedRequest.class),

	/**  系统公告  **/
	ChatSysBulletin(MsgConstant.REQ_CHAT_SYS_BULLETIN, ChatSysBulletinProcessor.class, ChatSysBulletinRequest.class),

	/**  BOSS复活通知  **/
	BossRebornNotice(MsgConstant.REQ_BOSS_REBORN_NOTICE, BossRebornNoticeProcessor.class, BossRebornNoticeRequest.class),
	/**  移除仇人  **/
	FriendRemoveEnemy(MsgConstant.REQ_FRIEND_REMOVE_ENEMY, FriendRemoveEnemyProcessor.class, FriendRemoveEnemyRequest.class),

	/**  空请求  **/
	EmptyRequest(MsgConstant.REQ_EMPTY_REQUEST, EmptyRequestProcessor.class, EmptyRequestRequest.class),

	/**  获取任务  **/
	GetTask(MsgConstant.REQ_GET_TASK, GetTaskProcessor.class, GetTaskRequest.class),

	/**  赠送好友花朵  **/
	FriendSendingFlowers(MsgConstant.REQ_FRIEND_SENDING_FLOWERS, FriendSendingFlowersProcessor.class, FriendSendingFlowersRequest.class),

	/**  回吻  **/
	FriendThinkFlower(MsgConstant.REQ_FRIEND_THINK_FLOWERS, FriendThinkFlowerProcessor.class, FriendThinkFlowerRequest.class),
	/**  购买仙缘副本挑战次数  **/
	LoverBuyTimes(MsgConstant.REQ_LOVER_BUY_TIMES, LoverBuyTimesProcessor.class, LoverBuyTimesRequest.class),

	/**  收取邮件附件  **/
	MailAllExtract(MsgConstant.REQ_MAIL_ALL_EXTRACT, MailAllExtractProcessor.class, MailAllExtractRequest.class),

	/**  寻宝仓库取出  **/
	TreasureDepotGet(MsgConstant.REQ_TREASURE_DEPOT_GET, TreasureDepotGetProcessor.class, TreasureDepotGetRequest.class),

	/**  寻宝仓库信息  **/
	TreasureDepotInfo(MsgConstant.REQ_TREASURE_DEPOT_INFO, TreasureDepotInfoProcessor.class, TreasureDepotInfoRequest.class),

	/**  删除全部邮件  **/
	MailAllDelete(MsgConstant.REQ_MAIL_ALL_DELETE, MailAllDeleteProcessor.class, MailAllDeleteRequest.class),

	/**  赠送花朵全服通知  **/
	SendingFlowersNotice(MsgConstant.REQ_SENDING_FLOWERS_NOTICE, SendingFlowersNoticeProcessor.class, SendingFlowersNoticeRequest.class),

	/**  最后获取的经验  **/
	LastTotleExp(MsgConstant.REQ_LAST_TOTLE_EXP, LastTotleExpProcessor.class, LastTotleExpRequest.class),

	/**  切线  **/
	ChangeLine(MsgConstant.REQ_CHANGE_LINE, ChangeLineProcessor.class, ChangeLineRequest.class),

	/**  显示当前地图所有线  **/
	ShowLine(MsgConstant.REQ_SHOW_LINE, ShowLineProcessor.class, ShowLineRequest.class),

	/**  仙缘信息  **/
	LoverInfo(MsgConstant.REQ_LOVER_INFO, LoverInfoProcessor.class, LoverInfoRequest.class),

	/**  仙缘副本进入挑战  **/
	LoverInsEnter(MsgConstant.REQ_LOVER_INS_ENTER, LoverInsEnterProcessor.class, LoverInsEnterRequest.class),

	/**  仙缘副本信息  **/
	LoverInsInfo(MsgConstant.REQ_LOVER_INS_INFO, LoverInsInfoProcessor.class, LoverInsInfoRequest.class),

	/**  仙缘副本邀请挑战  **/
	LoverInsInvite(MsgConstant.REQ_LOVER_INS_INVITE, LoverInsInviteProcessor.class, LoverInsInviteRequest.class),

	/**  仙缘副本离开挑战  **/
	LoverInsLeave(MsgConstant.REQ_LOVER_INS_LEAVE, LoverInsLeaveProcessor.class, LoverInsLeaveRequest.class),

	/**  仙缘副本抽奖  **/
	LoverInsLuck(MsgConstant.REQ_LOVER_INS_LUCK, LoverInsLuckProcessor.class, LoverInsLuckRequest.class),

	/**  仙缘副本抽奖双倍通知  **/
	LoverInsLuckDouble(MsgConstant.REQ_LOVER_INS_LUCK_DOUBLE, LoverInsLuckDoubleProcessor.class, LoverInsLuckDoubleRequest.class),

	/**  仙缘副本抽奖通知  **/
	LoverInsLuckNotice(MsgConstant.REQ_LOVER_INS_LUCK_NOTICE, LoverInsLuckNoticeProcessor.class, LoverInsLuckNoticeRequest.class),

	/**  仙缘等级升级  **/
	LoverLevelUp(MsgConstant.REQ_LOVER_LEVEL_UP, LoverLevelUpProcessor.class, LoverLevelUpRequest.class),

	/**  仙缘称号信息  **/
	LoverTitleInfo(MsgConstant.REQ_LOVER_TITLE_INFO, LoverTitleInfoProcessor.class, LoverTitleInfoRequest.class),

	/**  仙缘称号领取  **/
	LoverTitleRec(MsgConstant.REQ_LOVER_TITLE_REC, LoverTitleRecProcessor.class, LoverTitleRecRequest.class),

	/**  索取请柬  **/
	MarryInsAskForCard(MsgConstant.REQ_MARRY_INS_ASK_FOR_CARD, MarryInsAskForCardProcessor.class, MarryInsAskForCardRequest.class),

	/**  宴会入口信息  **/
	MarryInsEntryInfo(MsgConstant.REQ_MARRY_INS_ENTRY_INFO, MarryInsEntryInfoProcessor.class, MarryInsEntryInfoRequest.class),

	/**  宾客邀请次数购买  **/
	MarryInsGuestBuy(MsgConstant.REQ_MARRY_INS_GUEST_BUY, MarryInsGuestBuyProcessor.class, MarryInsGuestBuyRequest.class),

	/**  宾客管理  **/
	MarryInsGuestHandle(MsgConstant.REQ_MARRY_INS_GUEST_HANDLE, MarryInsGuestHandleProcessor.class, MarryInsGuestHandleRequest.class),

	/**  场景内申请人的信息  **/
	MarryInsGuestInfo(MsgConstant.REQ_MARRY_INS_GUEST_INFO, MarryInsGuestInfoProcessor.class, MarryInsGuestInfoRequest.class),

	/**  参与宴会  **/
	MarryInsJoinParty(MsgConstant.REQ_MARRY_INS_JOIN_PARTY, MarryInsJoinPartyProcessor.class, MarryInsJoinPartyRequest.class),

	/**  宴会推送  **/
	MarryInsNotice(MsgConstant.REQ_MARRY_INS_NOTICE, MarryInsNoticeProcessor.class, MarryInsNoticeRequest.class),

	/**  送花  **/
	MarryInsSendFlower(MsgConstant.REQ_MARRY_INS_SEND_FLOWER, MarryInsSendFlowerProcessor.class, MarryInsSendFlowerRequest.class),

	/**  结婚系统婚期预约信息  **/
	MarrySysAppointInfo(MsgConstant.REQ_MARRY_SYS_APPOINT_INFO, MarrySysAppointInfoProcessor.class, MarrySysAppointInfoRequest.class),

	/**  结婚系统婚期预约选择  **/
	MarrySysAppointMake(MsgConstant.REQ_MARRY_SYS_APPOINT_MAKE, MarrySysAppointMakeProcessor.class, MarrySysAppointMakeRequest.class),

	/**  婚期预约信息,有人预约时间时主动推送  **/
	MarrySysAppointPush(MsgConstant.REQ_MARRY_SYS_APPOINT_PUSH, MarrySysAppointPushProcessor.class, MarrySysAppointPushRequest.class),

	/**  结婚系统离婚  **/
	MarrySysDivorce(MsgConstant.REQ_MARRY_SYS_DIVORCE, MarrySysDivorceProcessor.class, MarrySysDivorceRequest.class),

	/**  获取结婚系统信息  **/
	MarrySysInfo(MsgConstant.REQ_MARRY_SYS_INFO, MarrySysInfoProcessor.class, MarrySysInfoRequest.class),

	/**  结婚系统宾客邀请信息  **/
	MarrySysInviteInfo(MsgConstant.REQ_MARRY_SYS_INVITE_INFO, MarrySysInviteInfoProcessor.class, MarrySysInviteInfoRequest.class),

	/**  结婚系统发送宾客邀请  **/
	MarrySysInviteSend(MsgConstant.REQ_MARRY_SYS_INVITE_SEND, MarrySysInviteSendProcessor.class, MarrySysInviteSendRequest.class),

	/**  结婚系统提亲信息  **/
	MarrySysProposeInfo(MsgConstant.REQ_MARRY_SYS_PROPOSE_INFO, MarrySysProposeInfoProcessor.class, MarrySysProposeInfoRequest.class),

	/**  结婚系统推送提亲信息  **/
	MarrySysProposePush(MsgConstant.REQ_MARRY_SYS_PROPOSE_PUSH, MarrySysProposePushProcessor.class, MarrySysProposePushRequest.class),

	/**  结婚系统接受提亲  **/
	MarrySysProposeReceive(MsgConstant.REQ_MARRY_SYS_PROPOSE_RECEIVE, MarrySysProposeReceiveProcessor.class, MarrySysProposeReceiveRequest.class),

	/**  结婚系统提亲结果  **/
	MarrySysProposeResult(MsgConstant.REQ_MARRY_SYS_PROPOSE_RESULT, MarrySysProposeResultProcessor.class, MarrySysProposeResultRequest.class),

	/**  结婚系统发送提亲  **/
	MarrySysProposeSend(MsgConstant.REQ_MARRY_SYS_PROPOSE_SEND, MarrySysProposeSendProcessor.class, MarrySysProposeSendRequest.class),
	/**  请求对方购买仙缘副本  **/
	LoverAskBuy(MsgConstant.REQ_LOVER_ASK_BUY, LoverAskBuyProcessor.class, LoverAskBuyRequest.class),

	/**  仙娃激活  **/
	BabyActivate(MsgConstant.REQ_BABY_ACTIVATE, BabyActivateProcessor.class, BabyActivateRequest.class),

	/**  仙娃信息  **/
	BabyInfo(MsgConstant.REQ_BABY_INFO, BabyInfoProcessor.class, BabyInfoRequest.class),

	/**  仙娃升级  **/
	BabyUpLevel(MsgConstant.REQ_BABY_UP_LEVEL, BabyUpLevelProcessor.class, BabyUpLevelRequest.class),

	/**  购买宝匣  **/
	TreasureBoxBuy(MsgConstant.REQ_TREASURE_BOX_BUY, TreasureBoxBuyProcessor.class, TreasureBoxBuyRequest.class),

	/**  请求仙侣购买宝匣  **/
	TreasureBoxBuyApply(MsgConstant.REQ_TREASURE_BOX_BUY_APPLY, TreasureBoxBuyApplyProcessor.class, TreasureBoxBuyApplyRequest.class),

	/**  宝匣购买请求推送  **/
	TreasureBoxBuyApplyPush(MsgConstant.REQ_TREASURE_BOX_BUY_APPLY_PUSH, TreasureBoxBuyApplyPushProcessor.class, TreasureBoxBuyApplyPushRequest.class),

	/**  宝匣领取  **/
	TreasureBoxGet(MsgConstant.REQ_TREASURE_BOX_GET, TreasureBoxGetProcessor.class, TreasureBoxGetRequest.class),

	/**  宝匣信息  **/
	TreasureBoxInfo(MsgConstant.REQ_TREASURE_BOX_INFO, TreasureBoxInfoProcessor.class, TreasureBoxInfoRequest.class),

	/**  婚礼祝福  **/
	MarryBless(MsgConstant.REQ_MARRY_BLESS, MarryBlessProcessor.class, MarryBlessRequest.class),

	/**  婚礼祝福信息  **/
	MarryBlessInfo(MsgConstant.REQ_MARRY_BLESS_INFO, MarryBlessInfoProcessor.class, MarryBlessInfoRequest.class),

	/**  仙侣请求自己购买仙缘副本  **/
	LoverAskBuyNotice(MsgConstant.REQ_LOVER_ASK_BUY_NOTICE, LoverAskBuyNoticeProcessor.class, LoverAskBuyNoticeRequest.class),

	/**  邀请异性好友仙缘组队  **/
	LoverInsInviteFriend(MsgConstant.REQ_LOVER_INS_INVITE_FRIEND, LoverInsInviteFriendProcessor.class, LoverInsInviteFriendRequest.class),

	/**  邀请伴侣仙缘组队  **/
	LoverInsInviteLover(MsgConstant.REQ_LOVER_INS_INVITE_LOVER, LoverInsInviteLoverProcessor.class, LoverInsInviteLoverRequest.class),

	/**  仙缘副本击杀怪物数量  **/
	LoverInsKillMonsterNum(MsgConstant.REQ_LOVER_INS_KILL_MONSTER_NUM, LoverInsKillMonsterNumProcessor.class, LoverInsKillMonsterNumRequest.class),

    //processor_end
    ;
    private short msgCode;
    private Class processor;
    private Class request;
    private boolean isClose;


    MsgProcessorRegister(short msgCode, Class processor, Class request) {
        this.msgCode = msgCode;
        this.processor = processor;
        this.request = request;
        this.request = request;
        this.isClose = false;
    }

    public short getMsgCode() {
        return this.msgCode;
    }

    private boolean isClose() {
        return isClose;
    }

    private void setClose(boolean isClose) {
        this.isClose = isClose;
    }

    public Class getMsgProcessor() {
        return this.processor;
    }

    public Class getRequest() {
        return request;
    }

    public void setRequest(Class request) {
        this.request = request;
    }
}
