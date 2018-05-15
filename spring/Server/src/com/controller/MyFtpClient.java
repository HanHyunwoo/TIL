package com.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import com.oroinc.net.ftp.FTPClient;
import com.oroinc.net.ftp.FTPFile;
import com.oroinc.net.ftp.FTPReply;

public class MyFtpClient {

	private static final String sServer = "70.12.114.146"; // 서버 아이피
	private static final int iPort = 22;
	private static final String sId = "ozo"; // 사용자 아이디
	private static final String sPassword = "1234"; // 비밀번호

	private static final String sUpDir = "C:\\logs";
	private static final String sDownDir = "D:/laredoute_dev/FTP/download";
	private static final String sLogDir = "D:/laredoute_dev/FTP/log";


	FTPClient ftpClient;

	public MyFtpClient() {
		ftpClient = new FTPClient();
	}

	// 서버로 연결
	private void connect() {
		try {
			ftpClient.connect(sServer, iPort);
			int reply;
			// 연결 시도후, 성공했는지 응답 코드 확인
			reply = ftpClient.getReplyCode();

			if (!FTPReply.isPositiveCompletion(reply)) {
				ftpClient.disconnect();
				System.out.println("서버로부터 연결을 거부당했습니다");
			}

		} catch (IOException ioe) {
			if (ftpClient.isConnected()) {
				try {
					ftpClient.disconnect();
				} catch (IOException f) {
					//
				}
			}
			System.out.println("서버에 연결할 수 없습니다");
		}
	}

	// 계정과 패스워드로 로그인
	private boolean login() {

		try {
			this.connect();
			return ftpClient.login(sId, sPassword);
		} catch (IOException ioe) {
			System.out.println("서버에 로그인 하지 못했습니다");
		}
		return false;
	}

	// 서버로부터 로그아웃
	private boolean logout() {

		try {
			return ftpClient.logout();
		} catch (IOException ioe) {
			System.out.println("로그아웃이 하지 못했습니다");
		}
		return false;
	}

	// FTP의 ls 명령, 모든 파일 리스트를 가져온다
	private FTPFile[] list() {

		FTPFile[] files = null;
		try {
			files = this.ftpClient.listFiles();
			return files;
		} catch (IOException ioe) {
			System.out.println("서버로부터 파일 리스트를 가져오지 못했습니다");
		}
		return null;
	}

	// 파일을 전송 받는다
	private boolean get(String source, String target, String name) {

		boolean flag = false;

		OutputStream output = null;
		try {
			// 받는 파일 생성 이 위치에 이 이름으로 파일 생성된다
			File local = new File(sDownDir, name);
			output = new FileOutputStream(local);
		} catch (FileNotFoundException fnfe) {
			System.out.println("다운로드할 디렉토리가 없습니다");
			return flag;
		}

		File file = new File(source);
		try {
			if (ftpClient.retrieveFile(source, output)) {
				flag = true;
			}
		} catch (IOException ioe) {
			System.out.println("파일을 다운로드 하지 못했습니다");
		}
		return flag;
	}

	// 파일을 전송 받는다 위의 method 와 return 값이 달라서 하나 더 만들었다
	private File getFile(String source, String name) {

		OutputStream output = null;
		File local = null;
		try {
			// 받는 파일 생성
			local = new File(sDownDir, name);
			output = new FileOutputStream(local);
		} catch (FileNotFoundException fnfe) {
			System.out.println("다운로드할 디렉토리가 없습니다");
		}

		File file = new File(source);
		try {
			if (ftpClient.retrieveFile(source, output)) {
				//
			}
		} catch (IOException ioe) {
			System.out.println("파일을 다운로드 하지 못했습니다");
		}
		return local;
	}

	// 파일을 전송 한다
	private boolean put(String fileName, String targetName) {

		boolean flag = false;
		InputStream input = null;
		File local = null;

		try {
			local = new File(sUpDir, fileName);
			input = new FileInputStream(local);
		} catch (FileNotFoundException e) {
			return flag;
		}

		try {

			// targetName 으로 파일이 올라간다

			if (ftpClient.storeFile(targetName, input)) {
				flag = true;
			}
		} catch (IOException e) {
			System.out.println("파일을 전송하지 못했습니다");
			return flag;
		}
		return flag;

	}

	// 서버 디렉토리 이동
	private void cd(String path) {

		try {
			ftpClient.changeWorkingDirectory(path);
		} catch (IOException ioe) {
			System.out.println("폴더를 이동하지 못했습니다");
		}
	}

	// 서버로부터 연결을 닫는다
	private void disconnect() {

		try {
			ftpClient.disconnect();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}

	private void setFileType(int iFileType) {
		try {
			ftpClient.setFileType(iFileType);
		} catch (Exception e) {
			System.out.println("파일 타입을 설정하지 못했습니다");
		}
	}

}