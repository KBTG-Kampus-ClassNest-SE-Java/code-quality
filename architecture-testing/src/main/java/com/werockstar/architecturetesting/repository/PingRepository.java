package com.werockstar.architecturetesting.repository;

import org.springframework.stereotype.Repository;

@Repository
public class PingRepository {


    public Message ping() {
        return new Message("Pong");
    }

}
