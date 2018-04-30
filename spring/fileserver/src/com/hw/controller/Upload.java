package com.hw.controller;

import org.springframework.web.multipart.MultipartFile;

public class Upload {

	String name;
	MultipartFile file;

	public Upload() {
	}

	public Upload(MultipartFile file) {

		this.file = file;
	}

	public Upload(String name) {

		this.name = name;

	}

	public Upload(String name, MultipartFile file) {

		this.name = name;
		this.file = file;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}

}
