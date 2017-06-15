package com.eframe.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Notification {
	@Id
	@GenericGenerator(name = "notification_id", strategy = "com.eframe.model.generator.NotificationIdGenerator")
	@GeneratedValue(generator = "notification_id")  
	@Column(name="notification_id")
	private String notificationId;

	@Column(name = "date")
	private LocalDate date;
	private String message;
	
	public String getNotificationId() {
		return notificationId;
	}
	public void setNotificationId(String notificationId) {
		this.notificationId = notificationId;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public boolean isPulled() {
		return isPulled;
	}
	public void setPulled(boolean isPulled) {
		this.isPulled = isPulled;
	}
	private String type;
	private boolean isPulled;
}
