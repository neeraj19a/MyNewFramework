package com.gurpreet.pages;

import java.io.IOException;

import org.testng.annotations.Test;

import com.gurpreet.project.PropertyReader;

public class Test1 {
	
	@Test
	public void function1Test1() throws IOException{
		PropertyReader propertyReader=new PropertyReader();
		propertyReader.bringObjectProperty();
		System.out.println(System.getProperty("env"));
		
		if(System.getProperty("env").equalsIgnoreCase("test")){
		System.out.println("Property updated and found");
		}
		
		else {
			System.out.println("Property not updated or not found");
		}
	}

	
	
	@Test(groups="my")
	public void function2Test1(){
		System.out.println("In Function2 of test 1 class");
	}
	
	@Test
	public void function3Test1(){
		System.out.println("In Function3 of test 1 class");
	}
	

}
