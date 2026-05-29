package com.example.websiteminuman.service;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MidtransService {

    @Value("${midtrans.server-key}")
    private String serverKey;

    @Value("${midtrans.base-url}")
    private String baseUrl;

    private final RestTemplate restTemplate = new RestTemplate();

    public String createSnapToken(String orderId, long grossAmount, String firstName, String email, String phone) {
        String auth = Base64.getEncoder().encodeToString((serverKey + ":").getBytes(StandardCharsets.UTF_8));

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "Basic " + auth);

        Map<String, Object> body = new HashMap<>();
        body.put("transaction_details", Map.of(
                "order_id", orderId,
                "gross_amount", grossAmount
        ));
        body.put("customer_details", Map.of(
                "first_name", firstName,
                "email", email,
                "phone", phone
        ));

        HttpEntity<Map<String, Object>> request = new HttpEntity<>(body, headers);

        @SuppressWarnings("unchecked")
        Map<String, Object> response = restTemplate.postForObject(
                baseUrl + "/snap/v1/transactions",
                request,
                Map.class
        );

        if (response == null || response.get("token") == null) {
            throw new IllegalStateException("Gagal membuat Snap token");
        }

        return response.get("token").toString();
    }
}