package com.liang.controller;


import com.liang.pojo.Recyclebin;
import com.liang.service.RecycleBinService;
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
@RequestMapping("/recycleBin")
public class RecycleBinController {


    @Autowired
    RecycleBinService recycleBinService;


    @PostMapping("/queryRecycleBin")
    public Result queryRecycleBin(){
        List<Recyclebin> recyclebins = recycleBinService.queryRecycleBinNote();
        return Result.ok(recyclebins);
    }

    @PostMapping("/delRecycleBin")
    public Result delRecycleBin(long[] ids){
        List<Long> idList = Arrays.stream(ids).boxed().collect(Collectors.toList());
        int i = recycleBinService.delRecycleBinNote(idList);
        String msg = "成功删除 "+i+" 条数据";
        return Result.ok(msg);
    }

    @PostMapping("/recoveryNote")
    public Result recoveryNote(long[] ids){
        List<Long> idList = Arrays.stream(ids).boxed().collect(Collectors.toList());
        int i = recycleBinService.recoveryNote(idList);
        Map<String,String> map = new HashMap<>();
        map.put("mas","成功恢复 "+i+" 笔记");
        return Result.ok(map);
    }

}
