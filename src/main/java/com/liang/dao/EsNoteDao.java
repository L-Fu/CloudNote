package com.liang.dao;

import com.liang.pojo.Note;

import java.io.IOException;
import java.util.List;

/**
 * @author Liang
 */
public interface EsNoteDao {
    List<Note> searchKey(String key) throws IOException;
    int updateNoteList(List<Note> notes) throws IOException;
    int updateEsNote(Note note) throws IOException;
    int insertEsNote(Note note) throws IOException;
    int deleteEsNote(Long noteId) throws IOException;
}
