package utils.lock;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 自带读写锁的对象.
 *
 * @author lst
 */
public class ObjWithLock<T> implements Serializable {
	/**
	 * 
	 */
	private T obj = null;

	/**
	 * 
	 */
	private ReentrantReadWriteLock lock = null;
	private static final Logger log = LoggerFactory.getLogger(ObjWithLock.class);

	/**
	 * 
	 * @param obj
	 * @author lst
	 */
	public ObjWithLock(T obj) {
		this(obj, new ReentrantReadWriteLock());
	}

	/**
	 * 
	 * @param obj
	 * @param lock
	 * @author lst
	 */
	public ObjWithLock(T obj, ReentrantReadWriteLock lock) {
		super();
		this.obj = obj;
		this.lock = lock;
	}

	/**
	 * 
	 * @return
	 * @author lst
	 */
	public ReentrantReadWriteLock getLock() {
		return lock;
	}

	/**
	 * 
	 * @return
	 * @author lst
	 */
	public T getObj() {
		return obj;
	}

	/**
	 * 
	 * @param obj
	 * @author lst
	 */
	public void setObj(T obj) {
		this.obj = obj;
	}
	
	private static final long serialVersionUID = -3048283373239453901L;

	/**
	 * 执行读操作,将加锁逻辑内置,防止业务层面犯错(譬如lock放到try里面,如果lock失效,在finally里会报错)
	 * @param task
	 * @author lst
	 */
	public void readExec(Task task){
		ReentrantReadWriteLock.ReadLock readLock = getLock().readLock();
		readLock.lock();
		try{
			task.exec();
		}catch(Exception e){
			log.error(e.getMessage(), e);
		}finally {
			readLock.unlock();
		}
	}

	/**
	 * 执行读操作,将加锁逻辑内置,防止业务层面犯错(譬如lock放到try里面,如果lock失效,在finally里会报错)
	 * @param task
	 * @author lst
	 */
	public T readExec(ValueTask<T> task){
		ReentrantReadWriteLock.ReadLock readLock = getLock().readLock();
		readLock.lock();
		try{
			return task.exec();
		}catch(Exception e){
			log.error(e.getMessage(), e);
			return null;
		}finally {
			readLock.unlock();
		}
	}

}
