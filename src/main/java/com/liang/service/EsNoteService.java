package com.liang.service;

import com.liang.pojo.Note;

import java.io.IOException;
import java.util.List;

/**
 * @author Liang
 */
public interface EsNoteService {
    List<Note> searchKey(String key) throws IOException;
}
