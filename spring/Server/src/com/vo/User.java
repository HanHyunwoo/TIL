package com.vo;

public class User {
	/*
	 * USERID VARCHAR(20) NOT NULL, -- ���̵� 
	 * USERPW VARCHAR(20) NULL, 	-- ��й�ȣ
	 * USERPHONE VARCHAR(20) NULL,  -- ��ȭ��ȣ 
	 * USERBIRTH VARCHAR(20) NULL,  -- �������
	 * USERADDR VARCHAR(100) NULL,  -- �ּ� 
	 * CATE NUMBER(1) NULL 			-- ������
	 */

	String USERID;
	String USERPW;
	String USERPHONE;
	String USERBIRTH;
	String USERADDR;
	String CATE;

	public String getUSERID() {
		return USERID;
	}

	public void setUSERID(String uSERID) {
		USERID = uSERID;
	}

	public String getUSERPW() {
		return USERPW;
	}

	public void setUSERPW(String uSERPW) {
		USERPW = uSERPW;
	}

	public String getUSERPHONE() {
		return USERPHONE;
	}

	public void setUSERPHONE(String uSERPHONE) {
		USERPHONE = uSERPHONE;
	}

	public String getUSERBIRTH() {
		return USERBIRTH;
	}

	public void setUSERBIRTH(String uSERBIRTH) {
		USERBIRTH = uSERBIRTH;
	}

	public String getUSERADDR() {
		return USERADDR;
	}

	public void setUSERADDR(String uSERADDR) {
		USERADDR = uSERADDR;
	}

	public String getCATE() {
		return CATE;
	}

	public void setCATE(String cATE) {
		CATE = cATE;
	}
}
