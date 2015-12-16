package com.speedledger.measure.jenkins;

import java.util.Map;
import java.util.Calendar;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Jenkins build.
 */

public class Build {
    public transient static final DateFormat DATE_FORMATTER = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ");
    //private static final String node_env = System.getProperty("NODE_ENV");
    private String nodeenv = System.getProperty("NODE_ENV");
    private String timestamp;
    private int number;
    private String jobName;
    private String result;
    private long startTime;
    private long duration;
    private Map<String, String> environment;

    public Build() {
    }

    public Build(String timestamp, int number,String nodeenv ,String jobName, String result, long startTime, long duration, Map<String, String> environment) {
        this.timestamp = timestamp;
        this.number = number;
        this.jobName = jobName;
        this.result = result;
        this.startTime = startTime;
        this.duration = duration;
        this.environment = environment;
        this.nodeenv = nodeenv;
    }
    
//    public String getProperty("JENKINS_BUILD_URL") {
//        return JENKINS_BUILD_URL;
// }

    public String getNode_env() {
        return nodeenv;
    }
    
    public void setNode_env(String nodeenv ) {
    this.nodeenv = nodeenv;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }

    public Map<String, String> getEnvironment() {
        return environment;
    }

    public void setEnvironment(Map<String, String> environment) {
        this.environment = environment;
    }
    
    public String getTimestamp() {
      return timestamp;
    }
    
    public void setTimestamp(Calendar timestamp) {
         this.timestamp = DATE_FORMATTER.format(timestamp.getTime());
    }


    @Override
    public String toString() {
        return "Build{" +
                "@timestamp" + timestamp +
                ", number=" + number +
                ", jobName='" + jobName + '\'' +
                ", result='" + result + '\'' +
                ", startTime=" + startTime +
                ", duration=" + duration +
                ", environment=" + environment + '\'' +
                ", node_env=" + nodeenv + '\'' +
                '}';
    }
}
