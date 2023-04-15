package com.liang.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.liang.mapper.NoteMapper;
import com.liang.mapper.RecyclebinMapper;
import com.liang.pojo.Note;
import com.liang.pojo.Recyclebin;
import com.liang.service.RecycleBinService;
import com.liang.util.UserHolder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;



@Service
public class RecycleBinServiceImpl implements RecycleBinService {

    @Resource
    private RecyclebinMapper recyclebinMapper;
    @Resource
    private NoteMapper noteMapper;

    @Override
    public int addRecycleBinNote(Recyclebin recyclebin) {
        recyclebin.setUid(UserHolder.getId());
        return recyclebinMapper.insert(recyclebin);
    }

    @Override
    public int delRecycleBinNote(List<Long> recyclebinIds) {
        System.out.println(recyclebinIds);
        return recyclebinMapper.deleteBatchIds(recyclebinIds);
    }

    @Override
    public int recoveryNote(List<Long> recyclebinIds) {
        int i = 0;
        for (Long recyclebinId : recyclebinIds) {

            Recyclebin recyclebin = recyclebinMapper.selectById(recyclebinId);
            Note note =new Note();
            note.setNoteTitle(recyclebin.getNoteTitle());
            note.setNoteContent(recyclebin.getNoteContent());
            note.setClassificID(recyclebin.getClassificID());
            note.setCraeteTime(recyclebin.getCraeteTime());
            note.setModifiTime(recyclebin.getModifiTime());
            note.setUid(recyclebin.getUid());
            note.setType(recyclebin.getType());
            note.setNoteHtml(recyclebin.getNoteHtml());
            recyclebinMapper.deleteById(recyclebinId);
            i += noteMapper.insert(note);
        }
        return i;

    }

    @Override
    public List<Recyclebin> queryRecycleBinNote() {

        QueryWrapper<Recyclebin> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("uid", UserHolder.getId());
        return recyclebinMapper.selectList(queryWrapper);
    }

    @Override
    public Recyclebin getRecycleBinNote(long id) {
        return recyclebinMapper.selectById(id);
    }
}
