package com.conjur.poc;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import com.cyberark.conjur.api.Conjur;

public class JavaConjurConnect {
	
	public static void main(String[] args) {
		System.out.println("Retrieved Secret->>" + getSecret("data/JAVAPOC/javapwd"));
	}
	
	
	
	
	private static void setEnvVariables()
	{
				
		ReadPropFile propFile= new ReadPropFile();
		
		System.setProperty("CONJUR_ACCOUNT", propFile.getConjurAccount());
		System.setProperty("CONJUR_APPLIANCE_URL", propFile.getApplianceURL());
		System.setProperty("CONJUR_AUTHN_API_KEY",  propFile.getUserAPIKey());
		System.setProperty("CONJUR_AUTHN_LOGIN", propFile.getUserLogin());	    		
		

	       
	}
	
	public static String getSecret(String variableID)
	{
		
		  setEnvVariables();
		  
		  System.out.println("**********Start:Printing Environment Variables*********");
		  
		  System.out.println("Conjur Account->>"+System.getProperty("CONJUR_ACCOUNT"));
		  System.out.println("Conjur Appliance URL->>"+System.getProperty("CONJUR_APPLIANCE_URL"));
		  System.out.println("Conjur Api Key->>"+System.getProperty("CONJUR_AUTHN_API_KEY"));
		  System.out.println("Conjur Outh Login->>"+System.getProperty("CONJUR_AUTHN_LOGIN"));
		  
		  System.out.println("**********Start:Printing Environment Variables*********");
		  
		 
		 Conjur conjur = new Conjur();
		 
		String secret = conjur.variables().retrieveSecret(variableID);
		System.out.println(variableID + ": " + secret);
		
		try {
		     FileWriter myWriter = new FileWriter("c:\\conjur\\secret.txt");
		     String secterTxt = "Retrieveed Secret : :" + secret;
		        myWriter.write(secterTxt);
		        myWriter.close();
		        
		      
		    } catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
		
		return secret;
	}
	

}
