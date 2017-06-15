package com.eframe.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.eframe.model.Notification;
import com.eframe.service.NotificationService;

@RestController
public class NotificationController {
	
	@Autowired
	NotificationService notificationService;
	
	/**
	 * Check for notifications
	 * 
	 * @return List<Client>
	 */
	@RequestMapping(method = RequestMethod.POST ,value = "/notifications")
	public ResponseEntity<Long> check() {
		while(true) {
			Long notifCount = notificationService.countByIsPulled(false);
			if (notifCount > 0) return ResponseEntity.ok(notifCount);
			try {
				Thread.sleep(1500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Get unPulled notifications
	 * 
	 * @return List<Client>
	 */
	@RequestMapping(method = RequestMethod.GET ,value = "/notifications")
	public ResponseEntity<List<Notification>> fetch() {
		List<Notification> notifications = notificationService.findByIsPulled(false);
		for( Notification notification : notifications) notification.setPulled(true);
		return ResponseEntity.ok(notificationService.save(notifications));
	}
}
