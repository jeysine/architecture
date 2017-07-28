package cn.com.architecture.service;

import cn.com.architecture.entity.Event;
import cn.com.architecture.listener.EventListener;

public interface EventService {
	public void publish(Event event) throws EventServiceException;
	public void subscribe(String eventType, EventListener listener) throws EventServiceException;
}
