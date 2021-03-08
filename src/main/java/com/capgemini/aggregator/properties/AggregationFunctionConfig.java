package com.capgemini.aggregator.properties;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import lombok.Data;

@Configuration
@EnableConfigurationProperties
@Data 
public class AggregationFunctionConfig {

 /*Traffic*/ 
 @Value(value = "${table.traffic.load}")
 private double load ;
 
 @Value(value = "${table.traffic.throughput}")
 private double throughput;
 
 @Value(value = "${table.traffic.networkIncoming}")
 private double networkIncoming;
 
 @Value(value = "${table.traffic.networkOutgoing}")
 private double networkOutgoing;
 
 /*Error Performance metric weights */ 
 
 @Value(value = "${table.errors.errorsperminute}")
 private double errorsperminute;
 
 @Value(value = "${table.errors.inferrorsperminute}")
 private double inferrorsperminute;
 
 @Value(value = "${table.errors.networkerrorsminincoming}")
 private double networkerrorsminincoming;
 
 @Value(value = "${table.errors.networkerrorsminoutgoing}")
 private double networkerrorsminoutgoing;
 
 @Value(value = "${table.errors.httperrorcodespermin}")
 private double httperrorcodespermin;
 
/*Latency weights*/
 
 @Value(value = "${table.latency.avresptime}")
 private double avresptime ;
 
 @Value(value = "${table.latency.avendtoendLatency}")
 private double avendtoendLatency;
 
 @Value(value = "${table.latency.garbagecollection}")
 private double garbagecollection;
 
 /*Saturation weights*/
 
 @Value(value = "${table.saturation.cpuusagehm}")
 private double cpuusagehm;
 
 @Value(value = "${table.saturation.cpuusagejvm}")
 private double cpuusagejvm;
 
 @Value(value = "${table.saturation.memoryhw}")
 private double memoryhw;
 
 @Value(value = "${table.saturation.memoryheap}")
 private double memoryheap;
 
 @Value(value = "${table.saturation.volumesusage}")
 private double volumesusage;
 
 @Value(value = "${table.saturation.cpusteal}")
 private double cpusteal;
 
 @Value(value = "${table.saturation.memoryswap}")
 private double memoryswap;
 
 @Value(value = "${table.saturation.memorynonheap}")
 private double memorynonheap;
 
 
 
	
}