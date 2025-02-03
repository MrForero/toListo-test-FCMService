package com.toListo.firebase.FCM.infrastructure.controllers.dto;

import lombok.Data;

@Data
public class NotificationRequestDto {
    private String userUID;
    private String title;
    private String body;

    public String getUserUID() {
        return userUID;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }
}
