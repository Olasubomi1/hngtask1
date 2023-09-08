package com.hng.hngtaskone.service;

import com.hng.hngtaskone.dto.ServerResponse;
import org.springframework.stereotype.Service;

@Service
public interface IUserService {
    ServerResponse getUser(String slackName, String track);
}
