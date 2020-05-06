package com.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.data.Notification;
import com.presentation.MainWindow;
import com.src.model.ItemBean;
import com.src.model.ItemsAggregateBean;
import com.src.model.NotificationBean;
import com.src.model.NotificationsAggregateBean;

import java.util.Date;

import org.slf4j.*;

/**
 * @author imssbora
 */
@SpringBootApplication(scanBasePackages= "com")/*
@EntityScan(basePackages = {"com.src.repos", "org.axonframework.eventsourcing.eventstore.jpa",
		"org.axonframework.eventhandling.saga.repository.jpa", 
		 "org.axonframework.eventhandling.tokenstore.jpa"})*/
@EntityScan(basePackages = {"com.mypackage",
                            "org.axonframework.eventsourcing.eventstore.jpa",
                            //"org.axonframework.eventhandling.saga.repository.jpa",
                            "org.axonframework.modelling.saga.repository.jpa",
                            "org.axonframework.eventhandling.tokenstore.jpa",
                            "com.src.repos"})
@EnableJpaRepositories("com.src.repos")

public class WasteLessApplication implements CommandLineRunner{
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
    
  //  @Autowired
   // NotificationRepository notRep;
    
   // @Autowired
   // ItemRepository itemRep;
    
    @Autowired
    WastelessController controller;
     
    public static void main(String[] args) {
    	SpringApplicationBuilder builder = new SpringApplicationBuilder(WasteLessApplication.class);
    	builder.headless(false);
    	ConfigurableApplicationContext context = builder.run(args);
    }
 
    public void run(String... args) throws Exception 
    {       
    	
    	//WebLookAndFeel.install(WebDarkSkin.class);
       
        
       MainWindow mw = new MainWindow();
       Utils utils = new Utils(mw, controller);
    	/*
    	NotificationBean notification = new NotificationBean();
    	notification.setMessage("MyNotification");
    	controller.addNotification(111, notification);
    	System.out.println(controller.getNotifications(111));
    	System.out.println(controller.getNotifications(111));
    	System.out.println(controller.getNotifications(111));
    	System.out.println(controller.getNotifications(111));
    	*/
    	//controller.deleteNotification(111, 1);

        /*
    	ItemsAggregateBean library = new ItemsAggregateBean();
    	library.setItemsAggregateId(111);
    	library.setName("myLibrary");
    	controller.addItemsAggregate(library);
    	ItemBean book = new ItemBean();
    	//book.setItemId(41);
    	book.setName("myOtherItem");
    	book.setCalories(300);
    	book.setQuantity(500);
    	book.setPurchase(new Date());
    	book.setExpiration(new Date());
    	//controller.addItem(111, book);
    	controller.deleteItem(111, 2);
    	System.out.println(controller.getItems(111));
    	System.out.println(controller.getItems(111));
    	System.out.println(controller.getItems(111));
    	System.out.println(controller.getItems(111));
    	*/
    }
}