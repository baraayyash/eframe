package com.eframe.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eframe.model.Notification;

public interface NotificationRepository extends JpaRepository<Notification, String> {
	Long countByNotificationId(String id);
	List<Notification> findByIsPulled(boolean isPulled);
}
