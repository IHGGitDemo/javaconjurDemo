package com.conjur.poc;

import java.io.FileReader;
import java.util.Properties;

public class ReadPropFile {

	private String conjurAccount;
	private String userLogin;
	private String userAPIKey;
	private String applianceURL;
	Properties prop =null; 
	
	public ReadPropFile()
	{
		 prop = new Properties();
		try {
		FileReader reader = new FileReader("conf/application.properties");

        Properties prop1 = new Properties();
        prop1.load(reader);
       // System.out.println("loaded"+prop1.getProperty("CONJUR_ACCOUNT"));
        setApplianceURL(prop1.getProperty("applianceURL"));
        setConjurAccount(prop1.getProperty("conjurAccount"));
        setUserAPIKey(prop1.getProperty("userAPIKey"));
        setUserLogin(prop1.getProperty("userLogin"));
        
				
			//prop.load(stream);
		} catch (Exception e) {
			
			e.printStackTrace();
		}

	}
	public String getConjurAccount() {
		return conjurAccount;
	}

	public void setConjurAccount(String conjurAccount) {
		this.conjurAccount = conjurAccount;
	}

	public String getUserLogin() {
		return userLogin;
	}

	public void setUserLogin(String userLogin) {
		this.userLogin = userLogin;
	}

	public String getUserAPIKey() {
		return userAPIKey;
	}

	public void setUserAPIKey(String userAPIKey) {
		this.userAPIKey = userAPIKey;
	}

	public String getApplianceURL() {
		return applianceURL;
	}

	public void setApplianceURL(String applianceURL) {
		this.applianceURL = applianceURL;
	}

	
	 
	public static void main(String[] args) {
		Properties prop = new Properties();
		try {
		FileReader reader = new FileReader("conf/application.properties");

        Properties prop1 = new Properties();
        prop1.load(reader);
        System.out.println("loaded"+prop1.getProperty("CONJUR_ACCOUNT"));
        System.out.println("loaded"+new ReadPropFile().getApplianceURL());
        
				
			//prop.load(stream);
		} catch (Exception e) {
			
			e.printStackTrace();
		}

	}

}
