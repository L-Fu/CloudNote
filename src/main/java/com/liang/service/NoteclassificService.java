package com.liang.service;

import com.liang.pojo.Noteclassific;

import java.util.List;

public interface NoteclassificService {
    /**
     * 增加分区
     * @param noteclassific
     * @return
     */
    int addClassific(Noteclassific noteclassific);

    /**
     * 删除分区
     * @param noteclassific
     * @return
     */
    int delClassific(Noteclassific noteclassific);

    /**
     * 查找分区
     * @return
     */
    List<Noteclassific> findClassific();

    /**
     * 更新分区
     * @param noteclassific
     * @return
     */
    int updateClassific(Noteclassific noteclassific);
}
