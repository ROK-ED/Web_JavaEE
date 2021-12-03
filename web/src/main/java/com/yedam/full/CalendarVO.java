package com.yedam.full;

public class CalendarVO {
 private String title;
 private String startDay;
 private String endDay;
 private String url;
 private int groupId;
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public String getStartDay() {
	return startDay;
}
public void setStartDay(String startDay) {
	this.startDay = startDay;
}
public String getEndDay() {
	return endDay;
}
public void setEndDay(String endDay) {
	this.endDay = endDay;
}
public String getUrl() {
	return url;
}
public void setUrl(String url) {
	this.url = url;
}
public int getGroupId() {
	return groupId;
}
public void setGroupId(int groupId) {
	this.groupId = groupId;
}
@Override
public String toString() {
	return "CalendarVO [title=" + title + ", startDay=" + startDay + ", endDay=" + endDay + ", url=" + url
			+ ", groupId=" + groupId + "]";
}
 
}
