package com.liang.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NoteTitle {
    private String noteTitle;
    private long noteId;
    /**
     *
     */
    private String craeteTime;

    /**
     *
     */
    private String modifiTime;
}
