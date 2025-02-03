package com.toListo.firebase.FCM.domain.usercases;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.FirebaseToken;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.Message;
import com.google.firebase.messaging.Notification;
import com.toListo.firebase.FCM.domain.ports.NotificationService;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class NotificationServiceImp implements NotificationService {

    @Override
    public String sendNotification(String token, String title, String body) throws Exception {
        Message message = Message.builder()
                .setToken(token)
                .setNotification(Notification.builder()
                        .setTitle(title)
                        .setBody(body)
                            .build())
                .build();
            String response = FirebaseMessaging.getInstance().send(message);
            return "Notification sent successfully: " + response;
    }

    @Override
    public String generateCustomToken(String userUID) throws FirebaseAuthException{
        return FirebaseAuth.getInstance().createCustomToken(userUID);

    }
}
