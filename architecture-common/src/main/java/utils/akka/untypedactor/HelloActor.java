package utils.akka.untypedactor;

import akka.actor.*;

/**
 * Created by world3-007 on 2018/4/27.
 */
public class HelloActor extends UntypedAbstractActor {

    static ActorSystem system = ActorSystem.create("toStringActor");

    static ActorRef ref = system.actorOf(Props.create(HelloActor.class),"toString");
    static ActorRef ref1 = system.actorOf(Props.create(HelloActor2.class),"toString2");

    public void onReceive(Object message) throws Throwable {

        System.out.println(message.toString());

        ActorRef r = system.actorFor("akka://toStringActor/user/toString2");

        r.tell(message,getSelf());

    }

    public static void main(String[] args) {

        for(int i=0;i<1;i++) {
            ref.tell("test"+i,ref);
        }
        system.stop(ref1);
        system.stop(ref);
        system.terminate();

        System.out.println("[结束]=======================");
    }

}
