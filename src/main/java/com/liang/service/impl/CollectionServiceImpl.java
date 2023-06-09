package com.liang.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.liang.exception.MyException;
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
import java.util.Objects;

import static com.liang.enums.StatusCodeEnum.COLLECTION_REPEAT_ERROR;

@Service
public class CollectionServiceImpl implements CollectionService {

    @Resource
    private CollectionMapper collectionMapper;

    @Resource
    private UserMapper userMapper;

    @Override
    public int addCollection(Note note) {
        QueryWrapper<Collection> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("OriginalNoteId",note.getNoteId());
        Collection collection1 = collectionMapper.selectOne(queryWrapper);
        if (!Objects.isNull(collection1)){
            throw new MyException(COLLECTION_REPEAT_ERROR);
        }
        Collection collection = new Collection();
        collection.setOriginalUId(note.getUid());
        collection.setNoteTitle(note.getNoteTitle());
        collection.setNoteContent(note.getNoteContent());
        collection.setOriginalNoteId(note.getNoteId());
        collection.setUId(UserHolder.getId());
        collection.setType(note.getType());
        collection.setNoteHtml(note.getNoteHtml());
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
