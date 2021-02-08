package com.example.demo.uploader;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;


@ConfigurationProperties(prefix="storage")
@Service("StorageService")
public class StorageProperties {

	/**
	 * Folder location for storing files
	 */
	private String location = "photos";

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

}
