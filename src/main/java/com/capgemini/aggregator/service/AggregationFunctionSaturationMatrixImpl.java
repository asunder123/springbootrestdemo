package com.capgemini.aggregator.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Spliterator;
import java.util.Spliterators;

import org.apache.commons.math3.linear.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.capgemini.aggregator.properties.AggregationFunctionConfig;


import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
@Service 
public class AggregationFunctionSaturationMatrixImpl {

       @Autowired
	   AggregationFunctionConfig config;
       

       
       
       private String[] args  = {"test","test2"};
	 
       
	 public RealMatrix createweightvector() {
      double[] weightarray = {config.getLoad(),config.getThroughput(),config.getNetworkIncoming(),config.getNetworkerrorsminoutgoing(),config.getErrorsperminute(),config.getInferrorsperminute(),config.getNetworkerrorsminincoming(),config.getNetworkerrorsminoutgoing(),config.getHttperrorcodespermin(),config.getAvresptime(),config.getAvendtoendLatency(),config.getGarbagecollection(),config.getCpuusagehm(),config.getCpuusagejvm(),config.getMemoryhw(),config.getMemoryheap(),config.getVolumesusage(),config.getCpusteal(),config.getMemoryswap(),config.getMemorynonheap()};
      RealMatrix weightvector  = MatrixUtils.createRowRealMatrix(weightarray);
      return weightvector;
	 }
	 
	 public void AddElementsSaturation() {
		 m1 = (createweightvector().getSubMatrix(0,0, 12,19)).scalarMultiply(0.007);
			}
	 
	 public void AddElementsLatency() {
		 m2 = createweightvector().getSubMatrix(0,0, 9, 11).scalarMultiply(0.055);
			}
	 
	 public void AddElementsErrors() {
		 m3 =  createweightvector().getSubMatrix(0, 0, 4, 8).scalarMultiply(0.0384);
			}
	 
	 public void AddElementsTraffic() {
		 m4 =  createweightvector().getSubMatrix(0, 0, 0, 3);
			}
	 
	 
	   double[][] matrixDataSaturWeights = new double[1][8];
       RealMatrix m1 = MatrixUtils.createRealMatrix(matrixDataSaturWeights);
  
	   double[][] matrixDataSaturValues = { {Math.random()},{Math.random()},{Math.random()},{Math.random()},{Math.random()},{Math.random()},{Math.random()},{Math.random()}};
	   RealMatrix n1 = new Array2DRowRealMatrix(matrixDataSaturValues);
	 
	   double[][] matrixDataLatencyWeights = new double[1][3];
	   RealMatrix m2 = MatrixUtils.createRealMatrix(matrixDataLatencyWeights);
	   double[][] matrixDataLatencyValues = {{Math.random()},{Math.random()},{Math.random()}};
	   RealMatrix n2 = new Array2DRowRealMatrix(matrixDataLatencyValues);
	   
	   double[][] matrixDataErrorWeights = new double[1][5];
	   RealMatrix m3 = MatrixUtils.createRealMatrix(matrixDataErrorWeights);
	   //RealMatrix m3 = createweightvector().getSubMatrix(0,0, 1,5);
	   double[][] matrixDataErrorValues = {{Math.random()},{Math.random()},{Math.random()},{Math.random()},{Math.random()}};
	   RealMatrix n3  = new Array2DRowRealMatrix(matrixDataErrorValues);
	   
	   double[][] matrixDataTrafficWeights = new double[1][4];
	   RealMatrix m4 = MatrixUtils.createRealMatrix(matrixDataTrafficWeights);
	   double[][] matrixDataTrafficValues  = {{Math.random()},{Math.random()},{Math.random()},{Math.random()}};
	   RealMatrix n4  = new Array2DRowRealMatrix(matrixDataTrafficValues);
	   
	   public RealMatrix SaturationMatrix() throws IOException {
		
		 log.info("Traffic weight vector is  " + createweightvector().getSubMatrix(0, 0, 0, 3));
		 log.info("Error weight vector is " + createweightvector().getSubMatrix(0, 0, 4, 8));
		 log.info("Latency weight vector is " + createweightvector().getSubMatrix(0,0, 9,11));
		 log.info("Saturation weight vector " + createweightvector().getSubMatrix(0,0, 12,19));
		 AddElementsSaturation();
		 RealMatrix p1 = m1.multiply(n1);
		 log.info("Values Satur are " + n1);
		 log.info("Values Satur are " + createweightvector().getSubMatrix(0,0, 6,13));
		 log.info("Saturation Vector is" + createweightvector().getSubMatrix(0,0, 6,13).multiply(n1).scalarMultiply(0.001));
		 log.info("SaturationScore  is::" +p1);
 	     AddElementsLatency();
 	     RealMatrix p2 = m2.multiply(n2);
 	     log.info("LatencyScore is::" +p2);
 	     AddElementsErrors();
 	     RealMatrix p3 = m3.multiply(n3);
 	     log.info("ErrorScore is " +p3);
 	     AddElementsTraffic();
 	     RealMatrix p4 = m4.multiply(n4);
 	     log.info("TrafficScore is " +p4);
 	     RealMatrix pscore = (p1.add(p2).add(p3).add(p4));
 	     return pscore;
			    }
}
