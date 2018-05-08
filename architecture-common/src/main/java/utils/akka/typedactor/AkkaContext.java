package utils.akka.typedactor;

import akka.actor.*;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;

final public class AkkaContext {
	public final static String SYSTEM_NAME ="architeture";

	public static ActorSystem system(){
		return inner.SYSTEM;
	}

	private static class inner{//延迟初始化
		private final static ActorSystem SYSTEM = ActorSystem.create(SYSTEM_NAME);
	}

	/**
	 * 打印jvm中所有的actor
	 *
	 * 用于检查actor泄露
	 */
	public static void printActors(){
		try{
			Method m = ActorSystemImpl.class.getDeclaredMethod("printTree");
			LoggerFactory.getLogger(AkkaContext.class).info((String) m.invoke(system()));
		} catch (Exception e) {
			LoggerFactory.getLogger(AkkaContext.class).error("!!!", e);
		}
	}

	/**
	 * 停止一个TypedActor
	 * @param o
	 */
	public static void stopTypedActor(Object o){
		TypedActor.get(system()).stop(o);
	}

	/**
	 * 创建一个TypedActor
	 * @param interfaceCls
	 * @param implementationCls
	 * @param <T>
	 * @return
	 */
	public static <T> T createTypedActor(Class<T> interfaceCls, Class implementationCls) {

		return TypedActor.get(system()).typedActorOf(new TypedProps<T>(interfaceCls, implementationCls));

	}

	/**
	 * 获得一个TypedActor的ActorRef
	 *
	 * @param typedActor
	 * @return
	 */
	public static ActorRef getTypedActorRef(Object typedActor) {
		return TypedActor.get(system()).getActorRefFor(typedActor);
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
		return TypedActor.get(system()).typedActorOf(new TypedProps<T>(interfaceCls), actorRef);
	}
}
