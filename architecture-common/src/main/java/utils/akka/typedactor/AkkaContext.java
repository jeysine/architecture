package utils.akka.typedactor;

import akka.actor.*;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;

final public class AkkaContext {
	public final static String SYSTEM_NAME ="world2";

	private final static ActorSystem SYSTEM = ActorSystem.create(SYSTEM_NAME);

	public static ActorSystem system(){
		return SYSTEM;
	}

	/**
	 * 打印jvm中所有的actor
	 *
	 * 用于检查actor泄露
	 */
	public static void printActors(){
		try{
			Method m = ActorSystemImpl.class.getDeclaredMethod("printTree");
			LoggerFactory.getLogger(AkkaContext.class).info((String) m.invoke(SYSTEM));
		} catch (Exception e) {
			LoggerFactory.getLogger(AkkaContext.class).error("!!!", e);
		}
	}

	/**
	 * 停止一个TypedActor
	 * @param o
	 */
	public static void stopTypedActor(Object o){
		TypedActor.get(SYSTEM).stop(o);
	}

	/**
	 * 创建一个TypedActor
	 * @param interfaceCls
	 * @param implementationCls
	 * @param <T>
	 * @return
	 */
	public static <T> T createTypedActor(Class<T> interfaceCls, Class implementationCls) {

		return TypedActor.get(SYSTEM).typedActorOf(new TypedProps<T>(interfaceCls, implementationCls));

	}

	/**
	 * 获得一个TypedActor的ActorRef
	 *
	 * @param typedActor
	 * @return
	 */
	public static ActorRef getTypedActorRef(Object typedActor) {
		return TypedActor.get(SYSTEM).getActorRefFor(typedActor);
	}

	/**
	 * 获取一个远程的TypedActor
	 *
	 * @param interfaceCls
	 * @param actorRef
	 * @param <T>
	 * @return
	 */
	public static <T> T getRemoteTypedActor (Class<T> interfaceCls, ActorRef actorRef){
		return TypedActor.get(SYSTEM).typedActorOf(new TypedProps<T>(interfaceCls), actorRef);
	}
}
