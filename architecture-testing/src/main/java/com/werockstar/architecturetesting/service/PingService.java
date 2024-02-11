package com.werockstar.architecturetesting.service;

import com.werockstar.architecturetesting.repository.Message;
import com.werockstar.architecturetesting.repository.PingRepository;
import org.springframework.stereotype.Service;

@Service
public class PingService {

    private final PingRepository pingRepository;

    public PingService(PingRepository pingRepository) {
        this.pingRepository = pingRepository;
    }

    public Message ping() {
        return pingRepository.ping();
    }
}
