package com.eframe.utils;

import org.springframework.data.domain.Page;

public class ListResponse {

	Object content;
	Long recordsTotal;
	int recordsFiltered;
	int draw;

	public ListResponse(Page listData) {
		this.content = listData.getContent();
		this.recordsTotal = listData.getTotalElements();
		this.recordsFiltered = listData.getNumberOfElements();
	}
	
	public ListResponse(Page listData, int draw) {
		this(listData);
		System.out.println("++" + draw);
		this.draw = draw;
	}
	
	public Object getContent() {
		return content;
	}
	public void setContent(Object content) {
		this.content = content;
	}
	public Long getRecordsTotal() {
		return recordsTotal;
	}
	public void setRecordsTotal(Long recordsTotal) {
		this.recordsTotal = recordsTotal;
	}
	public int getRecordsFiltered() {
		return recordsFiltered;
	}
	public void setRecordsFiltered(int recordsFiltered) {
		this.recordsFiltered = recordsFiltered;
	}

	public int getDraw() {
		return draw;
	}

	public void setDraw(int draw) {
		this.draw = draw;
	}
}
