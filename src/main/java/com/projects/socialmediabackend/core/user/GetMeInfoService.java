package com.projects.socialmediabackend.core.user;

import com.projects.socialmediabackend.api.user.info.GetMeInfoOperation;
import com.projects.socialmediabackend.api.user.info.GetMeInfoRequest;
import com.projects.socialmediabackend.api.user.info.GetMeInfoResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetMeInfoService implements GetMeInfoOperation {

    @Override
    public GetMeInfoResponse process(GetMeInfoRequest request) {
        return GetMeInfoResponse.builder()
                .user(request.getCurrentUser()).build();
    }
}
