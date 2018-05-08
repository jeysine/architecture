package cn.com.architecture.net.netty4.websocket.quartz;
/*
 * Created on Sep 21, 2006
 * 
 * This class is to run triggers which has already registered on scheduler.
 * Using JDBCJobStore, it will retrieve data from database and run
 */


import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.impl.StdSchedulerFactory;

public class JobStoreRunner {
	
	public JobStoreRunner(){}
	
	private static JobStoreRunner instance = null;
	
	public static JobStoreRunner getInstance(){
		if(instance == null){
			instance = new JobStoreRunner();
		}
		return instance;
	}
    public void task() throws SchedulerException { 
        SchedulerFactory schedulerFactory = new StdSchedulerFactory(); 
        Scheduler scheduler = schedulerFactory.getScheduler();
        scheduler.start();
    }
    
    public static void main (String args[]) {
        try {
            JobStoreRunner qRunner = new JobStoreRunner();
            qRunner.task();
            System.out.println("JobStoreRunner tigger start.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
