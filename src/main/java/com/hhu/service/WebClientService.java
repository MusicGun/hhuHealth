package com.hhu.service;

import com.hhu.entities.User;

import java.io.IOException;

public interface WebClientService {



    boolean checkIn(User user) throws IOException;
}
