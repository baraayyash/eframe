package com.eframe.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.eframe.Repository.NotificationRepository;
import com.eframe.model.Notification;

public class NotificationService {

	@Autowired
	private NotificationRepository notificationRepository;

	public List<Notification> findAll() {
		return notificationRepository.findAll();
	}

	public Notification findOne(String id) {
		return notificationRepository.findOne(id);
	}

	public Notification save(Notification notification) {
		return notificationRepository.save(notification);
	}
	
	public Long countByNotificationId(String id) {
		return notificationRepository.countByNotificationId(id);
	}
	
	public List<Notification> findByIsPulled(boolean isPulled) {
		return notificationRepository.findByIsPulled(isPulled);
	}
}
