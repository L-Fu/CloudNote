package com.liang.service;

import com.liang.pojo.Collection;
import com.liang.pojo.Note;

import java.util.List;

public interface CollectionService {
    int addCollection(Note note);
    int delCollection(List<Long> collectionIds);
    List<Collection> queryCollection();
}
