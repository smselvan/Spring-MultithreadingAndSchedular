package com.example.demo.controller;

import java.util.concurrent.ExecutionException;

import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.UserService;


@RestController
public class UserController extends Thread {
	
	@Autowired UserService service;
	
	@GetMapping("/getEmpList")
	  public  String findEmpList()throws InterruptedException, ExecutionException, SchedulerException {	
//		UserController controller=new UserController();
//		UserController controller2=new UserController();
//		UserController controller3=new UserController();
//		
//		Thread t1=new Thread();
//		Thread t2=new Thread();
//		Thread t3=new Thread();
//		
//		
//		 t1.setPriority(MAX_PRIORITY);
//		 t2.setPriority(MIN_PRIORITY);
//		 t3.setPriority(NORM_PRIORITY);
//		
//		
//		t3.setName(service.getEmpList2());
//		t2.setName(service.getEmpList3());
//		t1.setName(service.getEmpList4());
//		
//		
//		t1.start();
//		t2.start();
//		t3.start();
//		
		
		
		service.getEmpList1();
		service.getEmpList2();
		service.getEmpList3();
		service.getEmpList4();
		
		return "Processs Staterd";
	}	
}
