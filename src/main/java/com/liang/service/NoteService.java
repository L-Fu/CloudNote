package com.liang.service;

import com.liang.pojo.Note;
import com.liang.vo.NoteTitle;

import java.util.List;

public interface NoteService {
    List<Note> queryNote();
    int updateNote(Note note);
    int delNote(List<Long> noteIds);
    int addNote(Note note);
    List<NoteTitle> queryNoteList(long classId);
    Note queryNoteById(long noteId);
}
