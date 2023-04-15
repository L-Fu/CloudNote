package com.liang.controller;

import com.liang.pojo.Note;
import com.liang.service.NoteService;
import com.liang.vo.NoteTitle;
import com.liang.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.Response;
import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/note")
@CrossOrigin
public class NoteController {


    @Autowired
    private NoteService noteService;


    @PostMapping("/addNote")
    public Result addNote(Note note){
        int i = noteService.addNote(note);
        Map<String,String> map = new HashMap<>();
        map.put("msg","新增"+i+"笔记");
        return Result.ok(map);
    }

    @PostMapping("/delNote")
    public Result delNote(String ids){
        long id = Long.parseLong(ids);
        List<Long> idList= Collections.singletonList(id);
        int i = noteService.delNote(idList);
        Map<String,String> map = new HashMap<>();
        map.put("msg","删除 "+i+" 笔记");
        return Result.ok(map);
    }

    @PostMapping("/update")
    public Result updeteNote(Note note){
        int i = noteService.updateNote(note);
        Map<String,String> map = new HashMap<>();
        map.put("msg","更新 "+i+" 笔记");
        return Result.ok(map);
    }

    @PostMapping("/qureyNoteById")
    public Result qureyNoteById(long noteId){
        Note note = noteService.queryNoteById(noteId);
        return Result.ok(note);
    }


    @RequestMapping("/queryNoteList")
    @ResponseBody
    public Result queryNoteList(long classId){
        List<NoteTitle> noteTitles = noteService.queryNoteList(classId);
        return Result.ok(noteTitles);
    }


//    @PostMapping("/shareNote")
//    public Result shareNote(long noteId){
//        HashMap<String, String> map = new HashMap<>();
//        map.put("shareNoteId",noteService.shareNote(noteId));
//        return Result.ok(map);
//    }

}
