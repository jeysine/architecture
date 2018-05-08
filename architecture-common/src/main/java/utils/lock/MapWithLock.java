package utils.lock;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;

/**
 * @author lst
 * 2018年5月8日 上午9:55:37
 */
public class MapWithLock<K, V> extends ObjWithLock<Map<K, V>> {
	private static final long serialVersionUID = -652862323697152866L;
	private static final Logger log = LoggerFactory.getLogger(MapWithLock.class);

	/**
	 * @param map
	 * @author lst
	 */
	public MapWithLock(Map<K, V> map) {
		super(map);
	}

	/**
	 * @param map
	 * @param lock
	 * @author lst
	 */
	public MapWithLock(Map<K, V> map, ReentrantReadWriteLock lock) {
		super(map, lock);
	}

	/**
	 * 
	 * @param key
	 * @param value
	 * @return
	 * @author lst
	 */
	public V put(K key, V value) {
		WriteLock writeLock = this.getLock().writeLock();
		writeLock.lock();
		try {
			Map<K, V> map = this.getObj();
			return map.put(key, value);
		} catch (Throwable e) {
			log.error(e.getMessage(), e);
		} finally {
			writeLock.unlock();
		}
		return null;
	}
	
	/**
	 * 
	 * @param key
	 * @param value
	 * @return
	 * @author lst
	 */
	public V putIfAbsent(K key, V value) {
		WriteLock writeLock = this.getLock().writeLock();
		writeLock.lock();
		try {
			Map<K, V> map = this.getObj();
			V oldValue = map.putIfAbsent(key, value);
			if (oldValue == null) {
				return value;
			} else {
				return oldValue;
			}
			
		} catch (Throwable e) {
			log.error(e.getMessage(), e);
		} finally {
			writeLock.unlock();
		}
		return null;
	}

	/**
	 * 
	 * @param otherMap
	 * @author lst
	 */
	public void putAll(Map<K, V> otherMap) {
		if (otherMap == null || otherMap.isEmpty()) {
			return;
		}
		
		WriteLock writeLock = this.getLock().writeLock();
		writeLock.lock();
		try {
			Map<K, V> map = this.getObj();
			map.putAll(otherMap);
		} catch (Throwable e) {
			log.error(e.getMessage(), e);
		} finally {
			writeLock.unlock();
		}
	}

	/**
	 * 
	 * @param key
	 * @return
	 * @author lst
	 */
	public V remove(K key) {
		WriteLock writeLock = this.getLock().writeLock();
		writeLock.lock();
		try {
			Map<K, V> map = this.getObj();
			return map.remove(key);
		} catch (Throwable e) {
			log.error(e.getMessage(), e);
		} finally {
			writeLock.unlock();
		}
		return null;
	}

	/**
	 * clear
	 * @author lst
	 */
	public void clear() {
		WriteLock writeLock = this.getLock().writeLock();
		writeLock.lock();
		try {
			Map<K, V> map = this.getObj();
			map.clear();
		} catch (Throwable e) {
			log.error(e.getMessage(), e);
		} finally {
			writeLock.unlock();
		}
	}

	/**
	 * 
	 * @param key
	 * @return
	 * @author lst
	 */
	public V get(K key) {
		ReadLock readLock = this.getLock().readLock();
		readLock.lock();
		try {
			Map<K, V> map = this.getObj();
			return map.get(key);
		} catch (Throwable e) {
			log.error(e.getMessage(), e);
		} finally {
			readLock.unlock();
		}
		return null;
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
			Map<K, V> map = this.getObj();
			return map.size();
		} finally {
			readLock.unlock();
		}
	}

}
