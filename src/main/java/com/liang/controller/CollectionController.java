package com.liang.controller;

import com.liang.enums.StatusCodeEnum;
import com.liang.exception.MyException;
import com.liang.mapper.NoteMapper;
import com.liang.pojo.Collection;
import com.liang.pojo.Note;
import com.liang.service.CollectionService;
import com.liang.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static com.liang.enums.StatusCodeEnum.*;

@RestController
@CrossOrigin
@RequestMapping("/collection")
public class CollectionController {

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private CollectionService collectionService;

    @Resource
    private NoteMapper noteMapper;

    @GetMapping("/addCollection")
    public Result addCollection(long noteRandId){
        String noteId = stringRedisTemplate.opsForValue().get(String.valueOf(noteRandId));
//        System.out.println(noteId);
        if (Objects.isNull(noteId)){
            throw new MyException(SHARE_NOTE_ERROR);
        }else {
            Note note = noteMapper.selectById(noteId);
            if(Objects.isNull(note)){
                HashMap<String,String> map = new HashMap<>();
                map.put("msg","原笔记已被删除");
                return Result.fail(map);
            }
            collectionService.addCollection(note);
        }
        return Result.ok();
    }

    @PostMapping("/delCollection")
    public Result delCollection(long[] ids){
        List<Long> idList = Arrays.stream(ids).boxed().collect(Collectors.toList());
        int i = collectionService.delCollection(idList);
        String msg = "成功删除"+i+"收藏";
        return Result.ok(msg);
    }

    @PostMapping("/queryCollection")
    public Result queryCollection(){
        List<Collection> collections = collectionService.queryCollection();
        return Result.ok(collections);
    }

}
