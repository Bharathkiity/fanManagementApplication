package com.edubridge.fanapp.dao;

import java.util.List;
import com.edubridge.fanapp.model.Fan;

public interface FanDaoI {
    void addFan(Fan fan);
    List<Fan> getAllFans();
    Fan getFanById(Integer id);
    void updateFan(Fan fan);
    void deleteFan(Integer id);
    void deleteAllFans();
}
