package com.liang.service;

import com.liang.pojo.Recyclebin;

import java.util.List;

/**
 * @author Liang
 */
public interface RecycleBinService {
    int addRecycleBinNote(Recyclebin recyclebin);
    int delRecycleBinNote(List<Long> recyclebinIds);
    int recoveryNote(List<Long> recyclebins);
    List<Recyclebin> queryRecycleBinNote();
    Recyclebin getRecycleBinNote(long id);
}
