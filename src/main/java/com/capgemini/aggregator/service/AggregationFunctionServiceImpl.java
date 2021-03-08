package com.capgemini.aggregator.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import com.capgemini.aggregator.properties.AggregationFunctionConfig;


@Service 
public class AggregationFunctionServiceImpl {
	
    @Autowired
   AggregationFunctionConfig config;
	
   /* To Implement: Dynamically fetch values from AppDynamics using Spliterator */
   /* Matching the performance metrics received from appdynamics */

/*		   
	private double saturation;
	private double latency = Math.random();
	private double throughput  = Math.random();
	private double errorrate  = Math.random();
	private double[] array = {latency,throughput,errorrate}; */

    
    /*Fetch max performance metric value */
 /*   public static double getMax(double[] array2){ 
      double  maxValue = array2[0]; 
      for(int i=1;i < array2.length;i++){ 
        if(array2[i] > maxValue){ 
           maxValue = array2[i]; 
        } 
      } 
      return  maxValue; 
    } */
   
    /*Fetch min performance metric value */
   /* public static double getMin(double[] array2){ 
      double minValue = array2[0]; 
      for(int i=1;i<array2.length;i++){ 
        if(array2[i] < minValue){ 
          minValue = array2[i]; 
        } 
      }
        return minValue;
      }
	
    /*
      Normalize the performance metrics from appdynamics
      */
    
   /* private double normalizedlatency =  (latency-getMin(array))/(getMax(array)-getMin(array));
    private double normalizedthroughput = (throughput-getMin(array))/(getMax(array)-getMin(array));
    private double normalizederrorrate =  (errorrate-getMin(array))/(getMax(array)-getMin(array));
    
    /*
    Calculates the saturation score based on performance metrics from appdynamics
    */
    
	/*public double computeSaturation() {
		//System.out.println("Min value of perf metric " +getMin(array) );                  
		//System.out.println("Max value of perf metric " +getMax(array) );
		System.out.println("Normalized errorate is "+normalizederrorrate);
		System.out.println("Normalized latency is "+normalizedlatency);
		System.out.println("Normalized throughput is " +normalizedthroughput);
		double weightedlatency = normalizedlatency*(config.getweights().get(0));
		double weightedthroughput = normalizedthroughput*(config.getweights().get(1));
		double weightederrorrate = normalizedlatency*(config.getweights().get(2));
		double totalweight = (config.getweights().get(0)+config.getweights().get(1)+config.getweights().get(2));
		System.out.println("Weighted latency is ::::"+weightedlatency);
		System.out.println("Weighted latency is ::::"+weightedthroughput);
		System.out.println("Weighted latency is ::::"+weightederrorrate);
		double[] array = {weightederrorrate,weightedlatency,weightedthroughput};
		saturation = (( weightedlatency+weightedthroughput+weightederrorrate)/totalweight)*100;
		return saturation;
	
	} */
	
}
