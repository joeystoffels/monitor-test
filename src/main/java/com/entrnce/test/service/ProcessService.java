package com.entrnce.test.service;

import com.entrnce.test.api.StatusResource;
import com.entrnce.test.shared.Monitor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProcessService {

    private final Monitor monitor;

    @Scheduled(cron = "0 0/1 * * * *", zone = "UTC")
    public void testProcessTask() {
        monitor.log(new StatusResource("Test process task started"));

        var tenants = List.of("Test Tenant", "Other Tenant", "New Tenant", "Old Tenant");
        monitor.log(new StatusResource("Running tasks for tenants: " + tenants));

        tenants.forEach(this::performActions);

        monitor.log(new StatusResource("Test process task finished"));
    }

    private void performActions(String tenant) {
        // Perform tenant specific process actions
        monitor.log(new StatusResource(tenant, "Processing actions completed"));
    }

}
