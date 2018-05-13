package cn.com.architecture.net.netty4;

import cn.com.architecture.net.proto.ChatMsg;

/**
 * Created by li on 2018/5/13.
 */

public class ProtoTest {


    public static void main(String args[]){


        ChatMsg.C2SGetFriendChat.Builder builder = ChatMsg.C2SGetFriendChat.newBuilder();


        builder.setFriendId(1);
        builder.setIsFirst(true);

        System.out.println(builder);

        System.out.println(builder.build().toString());


    }

}
