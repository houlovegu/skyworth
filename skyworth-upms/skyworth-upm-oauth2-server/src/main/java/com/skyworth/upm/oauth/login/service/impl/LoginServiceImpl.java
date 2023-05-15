package com.skyworth.upm.oauth.login.service.impl;

import com.skyworth.oauth.model.OauthCodeRequest;
import com.skyworth.oauth.model.OauthState;
import com.skyworth.oltu.oauth2.AccountType;
import com.skyworth.oltu.oauth2.OauthLoginFactory;
import com.skyworth.oltu.oauth2.Profile;
import com.skyworth.oltu.oauth2.service.OauthLoginInterface;
import com.skyworth.upm.oauth.config.TokenStore;
import com.skyworth.upm.oauth.login.service.LoginService;
import com.skyworth.upm.oauth.login.util.OauthGenerator;
import com.skyworth.web.response.R;
import org.apache.oltu.oauth2.common.token.OAuthToken;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.annotation.Resource;

/**
 * @ClassName LoginServiceImpl
 * @Description LoginServiceImpl
 * @Author sky
 * @Date 2023/5/15 11:39
 * @Version 1.0
 **/
@Service
public class LoginServiceImpl implements LoginService {

    @Resource
    private TokenStore tokenStore;

    @Override
    public R loginByThird(String loginType) {
        OauthState state = new OauthState();
        String uid = OauthGenerator.generateState();
        state.setUid(uid);
        state.setStatus(OauthState.Status.Create);
        tokenStore.storeOauthState(uid, state);
        OauthLoginInterface helper = OauthLoginFactory.createOauthHelper(loginType);
        String redirectUrl = helper.redirectUrl(uid);

        return R.success(redirectUrl);
    }

    @Override
    public R oauthLoginCallback(String callbackType, String code, String state) {
        OauthState oauthState = tokenStore.getOauthState(state);
        if (oauthState == null || oauthState.getStatus() == OauthState.Status.Success) {
            return R.build(HttpStatus.FORBIDDEN.value(),HttpStatus.FORBIDDEN.getReasonPhrase());
        } else {
            //设置state状态，防止state重放攻击
            oauthState.setStatus(OauthState.Status.Success);
            tokenStore.storeOauthState(oauthState.getUid(), oauthState);
            //通过code获取token ，三方账号信息，并且在本系统创建或者更新用户和信息
            OauthLoginInterface oauthHelper = OauthLoginFactory.createOauthHelper(callbackType);
            OAuthToken oAuthToken = oauthHelper.getToken(code);
            Profile profile = oauthHelper.getProfile(oAuthToken.getAccessToken());
            // TODO: 将第三方账户添加到用户表
//            SysUserEntity skyCloudUserEntity = userService.updateOrAddUserByThirdPartAccount(profile, accountType);
            return R.success(profile);
        }
    }


}
