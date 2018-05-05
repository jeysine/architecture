package utils.akka.cluster;
/**
 * Created by li on 2018/4/28.
 */

import akka.actor.ActorSystem;
import akka.actor.Props;
import com.typesafe.config.ConfigFactory;

public class AkkaCluster2 {

    public static void main(String [] args){
        System.out.println("Start simpleClusterListener");
        ActorSystem system = ActorSystem.create("akkaClusterTest", ConfigFactory.load("akkaCluster2.conf"));
        system.actorOf(Props.create(SimpleClusterListener.class), "simpleClusterListener");
        System.out.println("Started simpleClusterListener");
    }
}
