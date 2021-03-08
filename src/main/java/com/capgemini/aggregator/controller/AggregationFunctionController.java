package com.capgemini.aggregator.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.aggregator.properties.AggregationFunctionConfig;
import com.capgemini.aggregator.service.AggregationFunctionSaturationMatrixImpl;
import com.capgemini.aggregator.service.AggregationFunctionServiceImpl;

@RestController
@RequestMapping(path = "/dynamics")
public class AggregationFunctionController<T> 
{    
    @Autowired
    AggregationFunctionConfig config;
    
    
    @Autowired
    AggregationFunctionServiceImpl serviceimpl;
  
    @Autowired
    AggregationFunctionSaturationMatrixImpl afunimpl;
   

    
    /*Performance metrics from appdynamics*/
    
    List<String> perfmetrics = new ArrayList<String>(10);
   
    /*Controller and YML Health Check */
    
    @GetMapping(path="/", produces = "application/json")
    public String getAppDynamicsStream() 
    {
    	System.out.println("Retrieving KPI's from yml "+"KPI's are" +config);
    	return config+"Read performance metrics, weights from yml";
    }
    
    /*Controller end point to invoke compute saturation score service*/
    
    @GetMapping(path="/saturation", produces = "application/json")
    public String getSaturation() 
    {
    	
    	return ":::Saturation-score::";
    }
    
    
    @GetMapping(path="/ymlweights", produces = "text/html")
    public String getPerfMatrix() 
    {
    	System.out.println();
    	return ":::Metric-data::" +config;
    }
   
   @GetMapping(path="/sreindex", produces = "application/json")
   public String getSatScoreMatric() throws IOException 
   {
   	System.out.println(afunimpl.SaturationMatrix());
   	return "::SRE-aggregate-score::"+afunimpl.SaturationMatrix();
  }
  
  
    
  
  
}
