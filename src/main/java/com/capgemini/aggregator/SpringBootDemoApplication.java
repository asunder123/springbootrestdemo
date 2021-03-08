package com.capgemini.aggregator;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.capgemini.aggregator.properties.AggregationFunctionConfig;
import com.splunk.Service;
import com.splunk.ServiceArgs; 

@SpringBootApplication 
@SpringBootConfiguration
public class SpringBootDemoApplication  {

	@Autowired
	private AggregationFunctionConfig config;
	
    public static void main(String[] args) {
        SpringApplication.run(SpringBootDemoApplication.class, args);
   
    }

	
	}

