package com.liang.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.liang.exception.MyException;
import com.liang.mapper.NoteMapper;
import com.liang.pojo.Note;
import com.liang.pojo.Recyclebin;
import com.liang.service.NoteService;
import com.liang.service.RecycleBinService;
import com.liang.util.UserHolder;
import com.liang.vo.NoteTitle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.TimeUnit;

import static com.liang.constant.RedisPrefixConst.SHARE_NOTE;
import static com.liang.enums.StatusCodeEnum.POST_NOT_EXIST;


/**
 * @author Liang
 */
@Service
public class NoteServiceImpl implements NoteService {

    @Resource
    private NoteMapper noteMapper;

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RecycleBinService recycleBinService;

    @Override
    public List<Note> queryNote() {
        QueryWrapper<Note> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("uid", UserHolder.getId());
        return noteMapper.selectList(queryWrapper);
    }


    @Override
    /*/**
     * 功能描述:
     * TODO
     *
      * @param note
     * @return int
     * @author JohanChan
     * @date 2022/10/25 10:41
     */

    public int updateNote(Note note) {
        Date day=new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        LocalDateTime time = LocalDateTime.parse(df.format(day));
        note.setModifiTime(String.valueOf(time));
        note.setUid(UserHolder.getId());
//        System.out.println(note);

        return noteMapper.updateById(note);
    }

    @Override
    public int delNote(List<Long> noteIds) {
        int i = 0;
        for (Long noteId : noteIds) {
            QueryWrapper<Note> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("noteId",noteId);
            Note note = noteMapper.selectOne(queryWrapper);
            Recyclebin recyclebin = new Recyclebin();
            recyclebin.setClassificID(note.getClassificID());
            recyclebin.setNoteID(note.getNoteId());
            recyclebin.setNoteTitle(note.getNoteTitle());
            recyclebin.setNoteContent(note.getNoteContent());
            recyclebin.setCraeteTime(note.getCraeteTime());
            recyclebin.setModifiTime(note.getModifiTime());
            recyclebin.setUid(note.getUid());
            recyclebin.setType(note.getType());
            recyclebin.setNoteHtml(note.getNoteHtml());
            i += recycleBinService.addRecycleBinNote(recyclebin);
        }
        return noteMapper.deleteBatchIds(noteIds);
    }

    @Override
     /**
     * 功能描述:
     * TODO
     * @param note
     * @return int
     * @author Liang
     * @date 2022/10/25 11:21
     */
    public int addNote(Note note) {
        Date day=new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        LocalDateTime time = LocalDateTime.parse(df.format(day));
        note.setCraeteTime(String.valueOf(time));
        note.setUid(UserHolder.getId());
        return noteMapper.insert(note);
    }

    @Override
    public List<NoteTitle> queryNoteList(long classId) {
        List<NoteTitle> noteTitlelist = new ArrayList<>();
        QueryWrapper<Note> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("classificID",classId);
        List<Note> noteList = noteMapper.selectList(queryWrapper);
        for (Note note : noteList) {
            noteTitlelist.add(new NoteTitle(note.getNoteTitle(), note.getNoteId(),note.getCraeteTime(),note.getModifiTime()));
        }
        return noteTitlelist;
    }

    @Override
    public Note queryNoteById(long noteId) {
        return noteMapper.selectById(noteId);
    }




}
