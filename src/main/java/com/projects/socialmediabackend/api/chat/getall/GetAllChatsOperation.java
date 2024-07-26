package com.projects.socialmediabackend.api.chat.getall;

import com.projects.socialmediabackend.api.base.Operation;

public interface GetAllChatsOperation extends Operation<GetAllChatsRequest, GetAllChatsResponse> {
    @Override
    GetAllChatsResponse process(GetAllChatsRequest request);
}
