package com.liang.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.liang.mapper.CollectionMapper;
import com.liang.mapper.UserMapper;
import com.liang.pojo.Collection;
import com.liang.pojo.Note;
import com.liang.service.CollectionService;
import com.liang.util.UserHolder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Service
public class CollectionServiceImpl implements CollectionService {

    @Resource
    private CollectionMapper collectionMapper;

    @Resource
    private UserMapper userMapper;

    @Override
    public int addCollection(Note note) {
        Collection collection = new Collection();
        collection.setOriginalUID(note.getUid());
        collection.setNoteTitle(note.getNoteTitle());
        collection.setNoteContent(note.getNoteContent());
        collection.setClassificID(note.getClassificID());
        collection.setUid(UserHolder.getId());
        collection.setType(note.getType());
        Date day=new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        LocalDateTime time = LocalDateTime.parse(df.format(day));
        collection.setCollectionTime(String.valueOf(time));
        return collectionMapper.insert(collection);
    }

    @Override
    public int delCollection(List<Long> collectionIds) {
        return collectionMapper.deleteBatchIds(collectionIds);

    }

    @Override
    public List<Collection> queryCollection() {
        QueryWrapper<Collection> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("uid",UserHolder.getId());
        return collectionMapper.selectList(queryWrapper);
    }


    @Override
    public Collection getCollection(long id){
        return collectionMapper.selectById(id);
    }
}
