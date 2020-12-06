package com.example.androiddevfinal_conaxapp;

import android.widget.Button;

public class JobItem {
    private String jobName;
    private String description;
    private String experience;
    private int jobImageURL;
    private Button emailButton;

    public JobItem(String jobName, String description, String experience, int jobImageURL, Button emailButton) {
        this.jobName = jobName;
        this.description = description;
        this.experience = experience;
        this.jobImageURL = jobImageURL;
        this.emailButton = emailButton;
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

    public int getJobImageURL() {
        return jobImageURL;
    }

    public void setJobImageURL(int jobImageURL) {
        this.jobImageURL = jobImageURL;
    }

    public Button getEmailButton() {
        return emailButton;
    }

    public void setEmailButton(Button emailButton) {
        this.emailButton = emailButton;
    }

    @Override
    public String toString() {
        return this.jobName;
    }
}
