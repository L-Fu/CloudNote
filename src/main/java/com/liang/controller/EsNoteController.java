package com.liang.controller;

import com.liang.pojo.Note;
import com.liang.service.EsNoteService;
import com.liang.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

/**
 * @author Liang
 */
@RestController
@RequestMapping("/esNote")
@CrossOrigin
public class EsNoteController {

    @Autowired
    private EsNoteService esNoteService;
    @RequestMapping("/searchKey")
    public Result searchKey(String key) throws IOException {
        List<Note> noteList = esNoteService.searchKey(key);
        return Result.ok(noteList);
    }
}
