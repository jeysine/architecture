package utils.akka.remote;

import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.actor.UntypedAbstractActor;
import akka.actor.UntypedActor;
import com.typesafe.config.ConfigFactory;

/**
 * Created by world3-007 on 2018/4/28.
 */
public class TestServer extends UntypedAbstractActor {

    public void onReceive(Object message) throws Throwable {
        System.out.println("服务器收到消息:"+message);
    }

    public static void main(String args[]){
        ActorSystem serverSystem = ActorSystem.create(Constant.serverAkkaSystemName, ConfigFactory.load(Constant.configFile).getConfig(Constant.serverConfig));
        serverSystem.actorOf(Props.create(TestServer.class), "server");
    }
}
