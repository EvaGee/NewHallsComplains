package com.halls.complain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Status {
	@Id
    public String regno;
	
	public boolean myStatus;

	public String getRegno() {
		return regno;
	}

	public void setRegno(String regno) {
		this.regno = regno;
	}

	public boolean isMyStatus() {
		return myStatus;
	}

	public void setMyStatus(boolean myStatus) {
		this.myStatus = myStatus;
	}
	
}
