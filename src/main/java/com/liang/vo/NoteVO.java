package com.liang.vo;

import com.liang.pojo.Note;
import com.liang.pojo.Noteclassific;
import lombok.Data;

import java.util.List;

@Data
public class NoteVO {
    private List<Noteclassific> noteclassificList;
    private List<NoteTitle> noteTitleList;
    private Note note;
}
