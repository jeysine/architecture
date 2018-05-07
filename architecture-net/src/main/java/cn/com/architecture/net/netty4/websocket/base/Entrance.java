/*
 *
 * @Copyright: 2017 www.linlongyx.com Inc. All rights reserved.
 * @Note：Only for linlongyx game project. Leaked and used for other commercial purposes is prohibited
 * @Date: 17-3-27 下午10:43
 * /
 */

package cn.com.architecture.net.netty4.websocket.base;

/**
 * 入口状态
 * Created by linchm on 2016-12-15.
 */
public class Entrance {
    private boolean openFlag;

    public Entrance() {
        this.openFlag = true;
    }

    public boolean isOpenFlag() {
        return openFlag;
    }

    public void setOpenFlag(boolean openFlag) {
        this.openFlag = openFlag;
    }
}
