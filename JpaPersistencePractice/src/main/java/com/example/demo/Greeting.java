package com.example.demo;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Greeting {
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  @NotNull
  @Min(1)
	
	private long id;
  
  
  @NotNull
  @Size(min=2,max=39)
  
	private String content;
	
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
}