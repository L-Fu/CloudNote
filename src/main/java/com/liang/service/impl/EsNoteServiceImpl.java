package com.liang.service.impl;

import com.liang.dao.EsNoteDao;
import com.liang.pojo.Note;
import com.liang.service.EsNoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

/**
 * @author Liang
 */
@Service
public class EsNoteServiceImpl implements EsNoteService {
    @Autowired
    private EsNoteDao esNoteDao;
    @Override
    public List<Note> searchKey(String key) throws IOException {
        return esNoteDao.searchKey(key);
    }
}
