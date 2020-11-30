package com.iiitb.serverConnect;

import java.util.ArrayList;

public class Status {
	private boolean success;
	private String key;
	private String link;
	private String expiry;
	
	public Status() {
	}
	public Status(boolean success, String key, String link, String expiry) {
		super();
		this.success = success;
		this.key = key;
		this.link = link;
		this.expiry = expiry;
	}
	public Status(String obj) {
		ArrayList<Integer> comma = new ArrayList<Integer>();
		int index = obj.indexOf(",");
		while (index >= 0) {
			comma.add(index);
		    index = obj.indexOf(",", index + 1);
		}
		int s =  obj.indexOf("\"success\"");
		s = s+"\"success\"".length()+1;
		String stat = obj.substring(s,comma.get(0));
		if(stat.equals("true")) {
			this.success = true;
		}
		else {
			this.success = false;
		}
		int k =  obj.indexOf("\"key\"");
		k = k+"\"key\"".length()+2;
		this.key = obj.substring(k,comma.get(1)-1);
		int l = obj.indexOf("\"link\"");
		l = l+"\"link\"".length()+2;
		this.link = obj.substring(l,comma.get(2)-1);
		int e = obj.indexOf("\"expiry\"");
		e = e+"\"expiry\"".length()+2;
		this.expiry = obj.substring(e,obj.length()-3);
	}
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public String getExpiry() {
		return expiry;
	}
	public void setExpiry(String expiry) {
		this.expiry = expiry;
	} 
}

