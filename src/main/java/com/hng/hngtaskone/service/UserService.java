package com.hng.hngtaskone.service;

import com.hng.hngtaskone.User.User;
import com.hng.hngtaskone.config.MessageProvider;
import com.hng.hngtaskone.constants.ResponseCode;
import com.hng.hngtaskone.dto.ErrorResponse;
import com.hng.hngtaskone.dto.PayloadResponse;
import com.hng.hngtaskone.dto.ServerResponse;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Calendar;
import java.util.Date;

@Service
public class UserService implements IUserService{
    @Autowired
    private MessageProvider messageProvider;


    @Override
    public ServerResponse getUser(@NonNull String slackName,@NonNull String track) {
        String responseCode = ResponseCode.SYSTEM_ERROR;
        String responseMessage = messageProvider.getMessage(responseCode);
        ErrorResponse errorResponse = ErrorResponse.getInstance();

        User user = new User();
        user.setSlackName(slackName);
        user.setTrack(track);
        user.setCurrentDayOfWeek(getDayOfWeek());
        user.setCurrentUTCTime(getCurrentUtcTime());
        user.setGithubUrlFile();

        responseCode = ResponseCode.SUCCESS;
        responseMessage = messageProvider.getMessage(responseCode)
        PayloadResponse response = PayloadResponse.getInstance();
        response.setResponseCode(responseCode);
        response.setResponseMessage(responseMessage);
        response.setResponseData(getCurrentUtcTime());
        return response;
    }
    private String getDayOfWeek(){
        Date date=new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        String dayWeekText = new SimpleDateFormat("EEEE").format(date);

        return dayWeekText;
    }
    private String getCurrentUtcTime() {
        String d1;
        Instant instant = Instant.now();
        d1 = instant.toString();
        return d1;
    }
}
