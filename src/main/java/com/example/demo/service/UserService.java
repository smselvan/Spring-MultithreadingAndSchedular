

package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
//import java.util.Timer;

import org.quartz.CronScheduleBuilder;
import org.quartz.CronTrigger;
import org.quartz.Job;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.example.demo.model.UserModel;

@Service
public class UserService implements Job{
	
	UserModel model=new UserModel();
	
	private static final Logger log = LoggerFactory.getLogger(UserService.class);
	
	
	Thread t=new Thread();
	public void getEmpList1() throws InterruptedException, SchedulerException
	{
	 SchedulerFactory factory =new StdSchedulerFactory(); 
	 Scheduler scheduler=factory.getScheduler();
	 JobDetail job=JobBuilder.newJob(UserService.class).build();
		
		
	 CronTrigger trigger=TriggerBuilder.newTrigger().withSchedule(CronScheduleBuilder.cronSchedule("0 01 18 * * ?")).build();
			
	scheduler.scheduleJob(job ,trigger);
	scheduler.start();

	}
	
	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
			List<UserModel> EmpList1=new ArrayList<>();
			Thread t=new Thread(()->
			{
				for (int i = 0; i < 1; i++) {	 
					
					model.setId(1001);
					model.setName("Muthu");
					model.setEmail("muthu123@gmail.com");
					model.setGender("male");
					EmpList1.add(model);
					log.info("Employee List 1"+model.toString());	 
			}
			});
			t.start();
		log.info("Employee List 1"+model.toString());
	}
	@Scheduled(cron="0 29 11 * * ?")
	public void getEmpList2() throws InterruptedException
	       {
		    List<UserModel> EmpList2=new ArrayList<>();
			Thread t=new Thread(() ->
			{
				for (int i = 0; i <1; i++) {
					model.setId(2001);
					model.setName("selvan");
					model.setEmail("selvan@gmail.com");
					model.setGender("male");
					log.info("Employee List 2"+model.toString());			 
				   }	
			});
		    
		   EmpList2.add(model);
		   t.setPriority(Thread.NORM_PRIORITY);
			System.out.println ("Norm_priority  -->"+t.getPriority());
       t.start();
	}
	@Scheduled(cron="0 29 11 * * ?")
	public void getEmpList3() throws InterruptedException
	{
		
		
			List<UserModel> EmpList3=new ArrayList<>();
			Thread t=new Thread(() ->
			{
				for (int i = 0; i <1; i++) {
					model.setId(3001);
					model.setName("Vishva");
					model.setEmail("Vishva@gmail.com");
					model.setGender("male");
				 	log.info("Employee List 3"+model.toString());
			}	
			});
				
			EmpList3.add(model);
			
		t.setPriority(Thread.MIN_PRIORITY);
	System.out.println ("Min_priority  -->"+t.getPriority());
         t.start();
	}
	@Scheduled(cron="0 29 11 * * ?")
	public void getEmpList4() throws InterruptedException
	{ 
		   
		     List<UserModel> EmpList4=new ArrayList<>();
		 	Thread t=new Thread(()->
		 	{
		 		 for (int i = 0; i <1; i++) {	
				         model.setId(4001);
				         model.setName("Ram");
				         model.setEmail("Ram@gmail.com");
				         model.setGender("male");
					EmpList4.add(model);	
					log.info("Employee List 4"+model.toString()); 
				} 
		 	});
		 	  t.setPriority(Thread.MAX_PRIORITY);
		 		System.out.println ("Max_priority  -->"+t.getPriority());
	        	 t.start();
	}   
  }
	








//CronScheduleBuilder.cronSchedule("* * 12 * * ?")