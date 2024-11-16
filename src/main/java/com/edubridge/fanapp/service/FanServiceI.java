package com.edubridge.fanapp.service;

import java.util.List;

import com.edubridge.fanapp.model.Fan;

public interface FanServiceI {
    void addFan(Fan fan);
    List<Fan> getAllFans();
    Fan getFanById(Integer id);
    void updateFan(Fan fan);
    void deleteFan(Integer id);
    void deleteAllFans();
}
