package com.liang.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.liang.mapper.ScheduleMapper;
import com.liang.pojo.Schedule;
import com.liang.service.ScheduleService;
import com.liang.util.UserHolder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;


@Service
public class ScheduleServiceImpl implements ScheduleService {
    @Resource
    private ScheduleMapper scheduleMapper;

    @Override
    public List<Schedule> querySchedule() {
        QueryWrapper<Schedule> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("uid", UserHolder.getId());
        return scheduleMapper.selectList(queryWrapper);
    }

    @Override
    public int addSchedule(Schedule schedule) {
        Date day=new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        LocalDateTime time = LocalDateTime.parse(df.format(day));
        schedule.setCraeteTime(String.valueOf(time));
        schedule.setScheduleTime(String.valueOf(time));
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
}
