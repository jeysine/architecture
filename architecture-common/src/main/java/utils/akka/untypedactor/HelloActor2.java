package utils.akka.untypedactor;

import akka.actor.UntypedAbstractActor;

/**
 * Created by world3-007 on 2018/4/27.
 */
public class HelloActor2 extends UntypedAbstractActor {

    public void onReceive(Object message) throws Throwable {

        System.out.println("messageFrom:"+getSender()+",message:"+message.toString());

    }

}