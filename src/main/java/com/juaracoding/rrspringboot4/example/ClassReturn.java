package com.juaracoding.rrspringboot4.example;

import java.time.LocalDateTime;
import java.util.List;

public class ClassReturn {
	private String data;
	private LocalDateTime timestamp;
	private Integer version;
	private List<String> list;

	private ClassStudent cs;

	public List<String> getList() {
		return list;
	}

	public void setList(List<String> list) {
		this.list = list;
	}

	public ClassStudent getCs() {
		return cs;
	}

	public void setCs(ClassStudent cs) {
		this.cs = cs;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}
}
