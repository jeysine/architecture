package utils.lock;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;

/**
 * @author lst
 * 2018年5月8日 上午9:55:37
 */
public class ListWithLock<T> extends ObjWithLock<List<T>> {
	private static final long serialVersionUID = 8549668315606224029L;
	private static final Logger log = LoggerFactory.getLogger(ListWithLock.class);

	/**
	 * @param list
	 * @author lst
	 */
	public ListWithLock(List<T> list) {
		super(list);
	}

	/**
	 * @param list
	 * @param lock
	 * @author lst
	 */
	public ListWithLock(List<T> list, ReentrantReadWriteLock lock) {
		super(list, lock);
	}
	
	
	/**
	 *
	 * @param t
	 * @return
	 * @author lst
	 */
	public boolean add(T t) {
		WriteLock writeLock = this.getLock().writeLock();
		writeLock.lock();
		try {
			List<T> list = this.getObj();
			return list.add(t);
		} catch (Throwable e) {
			log.error(e.getMessage(), e);
		} finally {
			writeLock.unlock();
		}
		return false;
	}

	/**
	 *
	 *
	 * @author lst
	 */
	public void clear() {
		WriteLock writeLock = this.getLock().writeLock();
		writeLock.lock();
		try {
			List<T> list = this.getObj();
			list.clear();
		} catch (Throwable e) {
			log.error(e.getMessage(), e);
		} finally {
			writeLock.unlock();
		}
	}

	/**
	 *
	 * @param t
	 * @return
	 * @author lst
	 */
	public boolean remove(T t) {
		WriteLock writeLock = this.getLock().writeLock();
		writeLock.lock();
		try {
			List<T> list = this.getObj();
			return list.remove(t);
		} catch (Throwable e) {
			log.error(e.getMessage(), e);
		} finally {
			writeLock.unlock();
		}
		return false;
	}

	/**
	 *
	 * @param t
	 * @return
	 * @author lst
	 */
	public void remove(int index) {
		WriteLock writeLock = this.getLock().writeLock();
		writeLock.lock();
		try {
			List<T> list = this.getObj();
			list.remove(index);
		} catch (Throwable e) {
			log.error(e.getMessage(), e);
		} finally {
			writeLock.unlock();
		}
	}
	
	/**
	 * 
	 * @return
	 * @author lst
	 */
	public int size() {
		ReadLock readLock = this.getLock().readLock();
		readLock.lock();
		try {
			List<T> list = this.getObj();
			return list.size();
		} finally {
			readLock.unlock();
		}
	}
}
