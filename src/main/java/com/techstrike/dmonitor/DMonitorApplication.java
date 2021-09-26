package com.techstrike.dmonitor;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DMonitorApplication {

	public static void main(String[] args) {
		SpringApplication.run(DMonitorApplication.class, args);
		
		try {
			
			var basePath = new File(DMonitorApplication.class.getProtectionDomain().getCodeSource().getLocation().toURI()).getPath();
			Path cfgFile = Paths.get(basePath + "/Config.cfg");
			boolean fileExists = Files.exists(cfgFile);
			System.out.println(cfgFile.toString() + " " + fileExists);
			FileInputStream file = new FileInputStream(cfgFile.toFile());
			Properties prop = new Properties();
			prop.load(file);
			var newAppString = prop.getProperty("teststring");
			System.setProperty("configuration.teststring", newAppString);
//			var propertiesInFile = Files.readAllLines(cfgFile);
//			System.out.println(propertiesInFile.toString());
//			var propertyString =propertiesInFile.get(0);
//			prop.setProperty(propertyString, null)
			
			
//			prop.ad
			System.out.println("testing");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	
	}

}
