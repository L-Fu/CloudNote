package com.liang.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.liang.mapper.ScheduleMapper;
import com.liang.pojo.Schedule;
import com.liang.service.ScheduleService;
import com.liang.util.UserHolder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


@Service
public class ScheduleServiceImpl implements ScheduleService {
    @Resource
    private ScheduleMapper scheduleMapper;

    @Override
    public List<Schedule> querySchedule(String date) {
        QueryWrapper<Schedule> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("uid", UserHolder.getId());
        queryWrapper.like("ScheduleDate",date);
        return scheduleMapper.selectList(queryWrapper);
    }

    @Override
    public int addSchedule(Schedule schedule) {
        schedule.setUid(UserHolder.getId());
        return scheduleMapper.insert(schedule);
    }

    @Override
    public int updateSchedule(Schedule schedule) {
        schedule.setUid(UserHolder.getId());
        return scheduleMapper.updateById(schedule);
    }

    @Override
    public int delSchedule(List<Long> scheduleIds) {
        return scheduleMapper.deleteBatchIds(scheduleIds);
    }

    @Override
    public Schedule getSchedule(long id) {
        return scheduleMapper.selectById(id);
    }
}
