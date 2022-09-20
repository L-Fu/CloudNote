package com.liang.controller;


import com.liang.pojo.Schedule;
import com.liang.service.ScheduleService;
import com.liang.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@CrossOrigin
@RequestMapping("/schedule")
public class ScheduleController {

    @Autowired
    private ScheduleService scheduleService;

    @PostMapping("/addSchedule")
    public Result addSchedule(Schedule schedule){
        int i = scheduleService.addSchedule(schedule);
        return Result.ok("增加"+i+"个日程");
    }

    @PostMapping("/delSchedule")
    public Result delSchedule(long[] ids){
        List<Long> idList = Arrays.stream(ids).boxed().collect(Collectors.toList());
        int i = scheduleService.delSchedule(idList);
        String msg = "成功删除 "+i+" 条数据";
        Map<String,String> map = new HashMap<String,String>();
        map.put("msg",msg);
        return Result.ok(map);

    }

    @PostMapping("/querySchedule")
    public Result querySchedule(){
        List<Schedule> schedules = scheduleService.querySchedule();
        return Result.ok(schedules);
    }

    @PostMapping("/updateSchedule")
    public Result uodateSchedule(Schedule schedule){
        int i = scheduleService.updateSchedule(schedule);
        String msg = "成功修改 "+i+" 条数据";
        Map<String,String> map = new HashMap<String,String>();
        map.put("msg",msg);
        return Result.ok(map);
    }
}
