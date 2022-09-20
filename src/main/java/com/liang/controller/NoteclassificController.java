package com.liang.controller;


import com.liang.dto.UserDTO;
import com.liang.pojo.Noteclassific;
import com.liang.service.NoteclassificService;
import com.liang.util.UserHolder;
import com.liang.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Liang
 */
@CrossOrigin
@RestController
@RequestMapping("/noteclassific")
public class NoteclassificController {

    @Autowired
    private NoteclassificService noteclassificService;


    @PostMapping("/addNoteclassific")
    public Result addNoteclassific(Noteclassific noteclassific){
        int i = noteclassificService.addClassific(noteclassific);
        return Result.ok("增加"+i+"个分区");
    }

    @PostMapping("/delNoteclassific")
    public Result delNoteclassific(Noteclassific noteclassific){
        int i = noteclassificService.delClassific(noteclassific);
        return Result.ok("删除"+i+"个分区");
    }

    @PostMapping("/updateNoteclassific")
    public Result updateNoteclassific(Noteclassific noteclassific){
//        System.out.println(noteclassific);
        int i = noteclassificService.updateClassific(noteclassific);
        return Result.ok("更改"+i+"个分区");
    }

    @PostMapping("/queryNoteclassific")
    public Result queryNoteclassific(){
//        UserDTO userDTO = new UserDTO();
////        userDTO.setUId(10004);
//        System.out.println();
//        UserHolder.saveUser(userDTO);
        List<Noteclassific> classific = noteclassificService.findClassific();
        return Result.ok(classific);
    }

}
