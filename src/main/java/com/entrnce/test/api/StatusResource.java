package com.entrnce.test.api;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Schema
@Data
@NoArgsConstructor
public class StatusResource {

    private Instant timestamp;
    private String tenantName;
    private String message;

    public StatusResource(String tenantName, String message) {
        this.timestamp = Instant.now();
        this.tenantName = tenantName;
        this.message = message;
    }

    public StatusResource(String message) {
        this(null, message);
    }

}
