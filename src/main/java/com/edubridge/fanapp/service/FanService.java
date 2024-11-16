package com.edubridge.fanapp.service;

import java.util.List;

import com.edubridge.fanapp.dao.FanDao;
import com.edubridge.fanapp.model.Fan;

public class FanService implements FanServiceI {
    private FanDao dao;

    public FanService() {
        dao = new FanDao();
    }

    @Override
    public void addFan(Fan fan) {
        dao.addFan(fan);
    }

    @Override
    public List<Fan> getAllFans() {
        return dao.getAllFans();
    }

    @Override
    public Fan getFanById(Integer id) {
        return dao.getFanById(id);
    }

    @Override
    public void updateFan(Fan fan) {
        dao.updateFan(fan);
    }

    @Override
    public void deleteFan(Integer id) {
        dao.deleteFan(id);
    }

    @Override
    public void deleteAllFans() {
        dao.deleteAllFans();
    }
}
