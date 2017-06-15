package com.eframe.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eframe.model.Notification;

public interface NotificationRepository extends JpaRepository<Notification, String> {
	Long countByIsPulled(boolean isPulled);
	List<Notification> findByIsPulled(boolean isPulled);
	List<Notification> save(List<Notification> notifications);
}
