package com.example.androiddevfinal_conaxapp;

public class JobItem {
    private String jobName;
    private String description;
    private String experience;

    public JobItem(String jobName, String description, String experience) {
        this.jobName = jobName;
        this.description = description;
        this.experience = experience;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }


    @Override
    public String toString() {
        return this.jobName;
    }
}
