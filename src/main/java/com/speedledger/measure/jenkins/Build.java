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
    private String node_env = System.getProperty("NODE_ENV");
    private String JENKINS_BUILD_URL = System.getProperty("jenkins.buildUrl");
    private String GIT_COMMIT = System.getProperty("jenkins.gitcommit");
    private String timestamp;
    private int number;
    private String jobName;
    private String result;
    private long startTime;
    private long duration;
    private Map<String, String> environment;
    public List<BuildParameter> getAvailableParameters() {
        List<BuildParameter> buildParameters = new ArrayList<BuildParameter>();

        for (ParameterDefinition parameterDefinition : getParameterDefinitions()) {
            BuildParameter buildParameter = new BuildParameter(parameterDefinition.getName(), parameterDefinition.getDescription());
            if (parameterDefinition.getClass().isAssignableFrom(PasswordParameterDefinition.class)) {
                buildParameter.setType(BuildParameterType.PASSWORD);
            } else if (parameterDefinition.getClass().isAssignableFrom(BooleanParameterDefinition.class)) {
                buildParameter.setType(BuildParameterType.BOOLEAN);
            } else if (parameterDefinition.getClass().isAssignableFrom(ChoiceParameterDefinition.class)) {
                buildParameter.setType(BuildParameterType.CHOICE);
                buildParameter.setChoices(((ChoiceParameterDefinition) parameterDefinition).getChoices());
            } else if (parameterDefinition.getClass().isAssignableFrom(StringParameterDefinition.class)) {
                buildParameter.setType(BuildParameterType.STRING);
            } else if (parameterDefinition.getClass().isAssignableFrom(TextParameterDefinition.class)) {
                buildParameter.setType(BuildParameterType.TEXT);
            } else {
                // default to string
                buildParameter.setType(BuildParameterType.STRING);
            }

            try {
                buildParameter.setValue(getParameterDefinitionValue(parameterDefinition));
            } catch (IllegalArgumentException ignored) {
                // If a value was provided that does not match available options, leave the value blank.
            }

            buildParameters.add(buildParameter);
        }

        return buildParameters;
    }
    
    public Build() {
    }


    public Build(String GIT_COMMIT ,String JENKINS_BUILD_URL ,String timestamp, int number,String node_env ,String jobName, String result, long startTime, long duration, Map<String, String> environment) {
        this.timestamp = timestamp;
        this.number = number;
        this.jobName = jobName;
        this.result = result;
        this.startTime = startTime;
        this.duration = duration;
        this.environment = environment;
        this.node_env  = node_env ;
        this.JENKINS_BUILD_URL = JENKINS_BUILD_URL;
        this.GIT_COMMIT = GIT_COMMIT;
    }

      public String getNode_env() {
          return node_env ;
      }
    
      public void setNode_env(String node_env) {
      this.node_env  = node_env ;
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
    
    public String getUrl() {
        return JENKINS_BUILD_URL;
    }

    public void setUrl(String JENKINS_BUILD_URL) {
        this.JENKINS_BUILD_URL = JENKINS_BUILD_URL;
    } 
    
    public String getGIT() {
        return GIT_COMMIT;
    }

    public void setGIT(String GIT_COMMIT) {
        this.GIT_COMMIT = GIT_COMMIT;
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
                ", node_env=" + node_env + '\'' +
                ", GIT_COMMIT=" + GIT_COMMIT + '\'' +
                ", JENKINS_BUILD_URL=" + JENKINS_BUILD_URL + '\'' +
                '}';
    }
}
