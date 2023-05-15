package com.skyworth.login.amazon.service;

import com.skyworth.login.amazon.entity.AmzAuthRequest;
import com.skyworth.web.response.R;

public interface AmazonAuthService {
    R doLogin(AmzAuthRequest amzAuthRequest);

    String login();
}
