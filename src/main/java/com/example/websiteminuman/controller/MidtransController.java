package com.example.websiteminuman.controller;

import java.time.Instant;
import java.util.Map;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.websiteminuman.service.MidtransService;

@RestController
@RequestMapping("/api/payments")
public class MidtransController {
    private final MidtransService midtransService;

    public MidtransController(MidtransService midtransService) {
        this.midtransService = midtransService;
    }

    @PostMapping("/snap-token")
    public ResponseEntity<Map<String, String>> createSnapToken(@RequestBody Map<String, Object> req) {
        long amount = Long.parseLong(req.get("amount").toString());
        String name = req.getOrDefault("name", "Customer").toString();
        String email = req.getOrDefault("email", "customer@mail.com").toString();
        String phone = req.getOrDefault("phone", "08123456789").toString();

        String orderId = "ORD-" + Instant.now().toEpochMilli() + "-" + UUID.randomUUID().toString().substring(0, 8);
        String token = midtransService.createSnapToken(orderId, amount, name, email, phone);

        return ResponseEntity.ok(Map.of(
                "orderId", orderId,
                "snapToken", token
        ));
    }
}
