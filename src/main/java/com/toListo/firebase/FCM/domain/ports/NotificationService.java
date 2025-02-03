package com.toListo.firebase.FCM.domain.ports;

import com.google.firebase.auth.FirebaseAuthException;

public interface NotificationService {

    /**
     * method to send notification using FCM
     *
     *
     * @param token a valid JWT
     * @param title title of the notification
     * @param body body of the notification
     * @return a message indicating the status
     */
    String sendNotification(String token, String title, String body) throws Exception;


    /**
     * method that generates a custom token to send notifiactions
     * into firebase
     * @return
     */
    String generateCustomToken(String userUID) throws FirebaseAuthException;
}
