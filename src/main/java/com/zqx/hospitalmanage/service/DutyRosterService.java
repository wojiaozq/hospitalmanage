package com.zqx.hospitalmanage.service;

import com.zqx.hospitalmanage.pojo.DutyRoster;

import java.util.List;

/**
 * @version 1.0
 * @program: hospitalmanage.DutyRosterService
 * @description:
 * @author:
 * @create: 2019-03-30 10:49:33
 **/
public interface DutyRosterService {

   void saveAll(DutyRoster[] ds);

   List<DutyRoster> findOneByDoctorId(String id);

}
