package utils.akka.remote;

import akka.actor.*;
import com.typesafe.config.ConfigFactory;
import scala.collection.immutable.Stream;
import utils.akka.AkkaConstant;

/**
 * Created by lst on 2018/4/28.
 */
public class TestClient extends UntypedAbstractActor {

    //远程Actor
    ActorSelection remoteActor  = null;
    //当前Actor
    ActorRef localActor = null;

    @Override
    public void preStart() throws Exception {
        remoteActor = getContext().actorSelection(AkkaConstant.getServerUrl(Constant.serverAkkaSystemName, Constant.host,"server"));
        //remoteActor = getContext().actorSelection("akka.tcp://lxw1234@127.0.0.1:2555/user/server");
        System.out.println("远程服务端地址 : " + remoteActor);
    }

    public void onReceive(Object message) throws Throwable {

        System.out.println("客户端收到消息:"+message);

    }

    public static void main(String args[]){

        ActorSystem clinetSystem = ActorSystem.create(Constant.clientAkkaSystemName, ConfigFactory.load(Constant.configFile).getConfig(Constant.clientConfig));
        clinetSystem.actorOf(Props.create(TestClient.class));

    }

}
