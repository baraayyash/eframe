package com.eframe.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eframe.Repository.NotificationRepository;
import com.eframe.model.Notification;

@Service
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
	
	public List<Notification> save(List<Notification> notifications) {
		return notificationRepository.save(notifications);
	}

	public Long countByIsPulled(boolean isPulled) {
		return notificationRepository.countByIsPulled(isPulled);
	}
	
	public List<Notification> findByIsPulled(boolean isPulled) {
		return notificationRepository.findByIsPulled(isPulled);
	}
}
