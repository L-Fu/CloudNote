package com.liang.service;

import com.liang.pojo.Schedule;

import java.util.List;

public interface ScheduleService {
    List<Schedule> querySchedule(String date);
    int addSchedule(Schedule schedule);
    int updateSchedule(Schedule schedule);
    int delSchedule(List<Long> scheduleIds);
    Schedule getSchedule(long id);
}
