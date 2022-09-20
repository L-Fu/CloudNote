package com.liang.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.liang.mapper.NoteclassificMapper;
import com.liang.pojo.Noteclassific;
import com.liang.service.NoteclassificService;
import com.liang.util.UserHolder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;


@Service
public class NoteclassificServiceImpl implements NoteclassificService {

    @Resource
    NoteclassificMapper noteclassificMapper;

    /**
     * 增加分区
     *
     * @param noteclassific
     * @return
     */
    @Override
    public int addClassific(Noteclassific noteclassific) {
        noteclassific.setUid(UserHolder.getId());
        Date day=new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        LocalDateTime time = LocalDateTime.parse(df.format(day));
        noteclassific.setCreateTime(String.valueOf(time));
//        System.out.println(noteclassific);
        return noteclassificMapper.insert(noteclassific);

    }

    /**
     * 删除分区
     *
     * @param noteclassific
     * @return int
     */
    @Override
    public int delClassific(Noteclassific noteclassific) {
        return noteclassificMapper.deleteById(noteclassific.getClassificID());
    }

    /**
     * 查找分区
     * @return Noteclassific
     */
    @Override
    public List<Noteclassific> findClassific() {
        QueryWrapper<Noteclassific> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("uid", UserHolder.getId());
        return noteclassificMapper.selectList(queryWrapper);
    }

    /**
     * 更新分区
     *
     * @param noteclassific
     * @return
     */
    @Override
    public int updateClassific(Noteclassific noteclassific) {
        noteclassific.setUid(UserHolder.getId());
        return noteclassificMapper.updateById(noteclassific);
    }
}
