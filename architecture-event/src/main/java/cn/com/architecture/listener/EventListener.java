package cn.com.architecture.listener;

import cn.com.architecture.entity.Event;

public interface EventListener {
	public String getId();
	public void handleEvent(Event event);
}
