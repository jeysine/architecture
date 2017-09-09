package cn.com.architecture.service.impl;

import cn.com.architecture.service.TestService;
import cn.com.architecture.service.test.entity.TestEntity;

import java.util.concurrent.atomic.AtomicLong;


public class TestServiceImpl implements TestService {

	public static AtomicLong atomicLong = new AtomicLong(0L);

	public TestEntity save(TestEntity entity) {
		return null;
	}

	public TestEntity findById(String id) {
		return null;
	}

	public void delete(String s) {
	}


	public Iterable<TestEntity> findAll() {
		return null;
	}

	public long count() {
		return atomicLong.incrementAndGet();
	}


	public boolean exists(String s) {
		return false;
	}


	public TestEntity getNewUser() {
		TestEntity entity = new TestEntity();
		entity.setId(atomicLong.incrementAndGet());
		entity.setName("1231");
		return entity;
	}
}
