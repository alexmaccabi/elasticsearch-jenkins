package com.speedledger.measure.jenkins;

import java.util.Map;

/**
 * Jenkins build.
 */
public class Build {
    private int number;
    private String jobName;
    private String result;
    private long startTime;
    private long duration;

    public Build() {
    }

    public Build(int number, String jobName, String result, long startTime, long duration) {
        this.number = number;
        this.jobName = jobName;
        this.result = result;
        this.startTime = startTime;
        this.duration = duration;
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


    @Override
    public String toString() {
        return "Build{" +
                "number=" + number +
                ", jobName='" + jobName + '\'' +
                ", result='" + result + '\'' +
                ", startTime=" + startTime +
                ", duration=" + duration +
                '}';
    }
}
