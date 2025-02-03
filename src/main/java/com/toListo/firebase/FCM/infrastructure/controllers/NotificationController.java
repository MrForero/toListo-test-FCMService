package com.toListo.firebase.FCM.infrastructure.controllers;

import com.google.firebase.auth.FirebaseAuthException;
import com.toListo.firebase.FCM.domain.ports.NotificationService;
import com.toListo.firebase.FCM.infrastructure.controllers.dto.NotificationRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/notificaciones")
//@RequiredArgsConstructor
public class NotificationController {

    @Autowired
    private NotificationService notificationService;

    @PostMapping("/enviar")
    public ResponseEntity<?> sendNotification(@RequestBody NotificationRequestDto notificationRequestDto){
        try{
//            return ResponseEntity.ok(this.notificationService.generateCustomToken("user-UID"));
            String token = this.notificationService.generateCustomToken(notificationRequestDto.getUserUID());
            return ResponseEntity.ok(this.notificationService
                    .sendNotification(token,
                            notificationRequestDto.getTitle(), notificationRequestDto.getBody()));
        } catch (Exception e){
            return new ResponseEntity<>("Problemas con el token, acceso denegado: "+e.getMessage(), HttpStatus.UNAUTHORIZED);
        }

    }
}
