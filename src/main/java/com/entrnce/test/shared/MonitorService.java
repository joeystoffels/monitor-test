package com.entrnce.test.shared;

import com.entrnce.test.api.StatusResource;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.ExchangeFilterFunctions;
import org.springframework.web.reactive.function.client.WebClient;

@Service
class MonitorService implements Monitor {

    @Override
    public void log(StatusResource statusResource) {
        WebClient.builder()
                .filter(ExchangeFilterFunctions.basicAuthentication("admin", "admin"))
                .build().post()
                .uri("http://localhost:7000/api/status")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(statusResource)
                .retrieve()
                .toBodilessEntity().block();
    }

}
