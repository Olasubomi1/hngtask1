package com.hng.hngtaskone.User;

import lombok.Data;

@Data
public class User {
    private String slackName;
    private String track;
    private String currentDayOfWeek;
    private String currentUTCTime;
    private String githubFileUrl;
    private String githubSourcecodeUrl;
}
