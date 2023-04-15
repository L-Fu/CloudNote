package com.liang.dao.impl;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch.core.*;
import co.elastic.clients.elasticsearch.core.search.Highlight;
import co.elastic.clients.elasticsearch.core.search.HighlightField;
import co.elastic.clients.elasticsearch.core.search.Hit;
import co.elastic.clients.elasticsearch.core.search.LaplaceSmoothingModel;
import com.liang.dao.EsNoteDao;
import com.liang.pojo.Note;
import com.liang.util.UserHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Liang
 */
@Repository
public class EsNoteDaoImpl implements EsNoteDao {

    @Autowired
    private ElasticsearchClient client;

    private Map<Long,Note> searchKeyUtil(String fields,String key,Map<Long,Note> map) throws IOException{
        HighlightField.Builder highlightFieldBuilder = new HighlightField.Builder();
        HighlightField fieldNoteHtml = highlightFieldBuilder.build();
        Highlight.Builder highlightBuilder = new Highlight.Builder();
        Highlight highlight = highlightBuilder.fields(fields, fieldNoteHtml).preTags("<span style=\"background-color: #fbeeb8;\">").postTags("</span>").build();
        SearchResponse<Note> response = client.search(s -> s
                        .index("note")
                        .query(q -> q.bool(a->a
                                        .must(c->c.match(d->d
                                                .field("uid")
                                                .query(UserHolder.getId())
                                        ))
                                        .must(b->b.match(t -> t
                                                .field(fields)
                                                .query(key)
                                                .analyzer("ik_max_word")
                                        ))
                                )

                        ).highlight(highlight)
                ,
                Note.class
        );
        List<Hit<Note>> hits = response.hits().hits();
        for (Hit<Note> hit: hits) {
            Note note = hit.source();
            if (note != null){
                long noteId = note.getNoteId();
                if (fields.equals(hit.highlight().keySet().iterator().next())){
                    String text = hit.highlight().get(fields).get(0);
                    if (map.containsKey(noteId)){
                        note = map.get(noteId);
                    }
                    if ("noteTitle".equals(fields)){
                        note.setNoteTitle(text);
                    }else if("noteHtml".equals(fields)){
                        note.setNoteHtml(text);
                    }
                    map.put(noteId,note);
                }
            }
        }
        return map;
    }

    @Override
    public List<Note> searchKey(String key) throws IOException {
//        HighlightField.Builder highlightFieldBuilder = new HighlightField.Builder();
//        HighlightField.Builder highlightFieldBuilder1 = new HighlightField.Builder();
//        HighlightField fieldNoteHtml = highlightFieldBuilder.build();
//        HighlightField fieldNoteTitle = highlightFieldBuilder1.build();
//        //构建高亮字段
//        Highlight.Builder highlightBuilder = new Highlight.Builder();
//        Highlight.Builder highlightBuilder1 = new Highlight.Builder();
//        Highlight highlightNoteHtml = highlightBuilder.fields("noteHtml", fieldNoteHtml).preTags("<span style=\"background-color: #fbeeb8;\">").postTags("</span>").build();
//        Highlight highlightNoteTitle = highlightBuilder1.fields("noteTitle", fieldNoteTitle).preTags("<span style=\"background-color: #fbeeb8;\">").postTags("</span>").build();
//        SearchResponse<Note> resTitle = client.search(s -> s
//                        .index("note")
//                        .query(q -> q.bool(a->a
//                                        .must(c->c.match(d->d
//                                                .field("uid")
//                                                .query(UserHolder.getId())
//                                        ))
//                                        .must(b->b.match(t -> t
//                                                .field("noteTitle")
//                                                .query(key)
//                                                .analyzer("ik_max_word")
//                                        ))
//                                )
//
//                        ).highlight(highlightNoteTitle)
//                ,
//                Note.class
//        );
//        SearchResponse<Note>  resContent = client.search(s -> s
//                        .index("note")
//                        .query(q -> q.bool(a->a
//                                        .must(c->c.match(d->d
//                                                .field("uid")
//                                                .query(UserHolder.getId())
//                                        ))
//                                        .must(b->b.match(t -> t
//                                                .field("noteHtml")
//                                                .query(key)
//                                                .analyzer("ik_max_word")
//                                        ))
//                                )
//
//                        ).highlight(highlightNoteHtml)
//                ,
//                Note.class
//        );
//        List<Note> noteList = new ArrayList<Note>();
//        Map<Long,Note> map= new HashMap<>();
//        List<Hit<Note>> hitContents = resContent.hits().hits();
//        List<Hit<Note>> hitTitles = resTitle.hits().hits();
//        for (Hit<Note> hit: hitContents) {
//            Note note = hit.source();
//            System.out.println(hit);
//            if (note != null){
//                long noteId = note.getNoteId();
//                if ("noteHtml".equals(hit.highlight().keySet().iterator().next())){
//                    String noteHtml = hit.highlight().get("noteHtml").get(0);
//                    if (map.containsKey(noteId)){
//                        note = map.get(noteId);
//                    }
//                    note.setNoteHtml(noteHtml);
//                    map.put(noteId,note);
//                }
//            }
//        }
//        for (Hit<Note> hit: hitTitles) {
//
//            Note note = hit.source();
//            if (note != null){
//                long noteId = note.getNoteId();
//                if ("noteTitle".equals(hit.highlight().keySet().iterator().next())){
//                    String noteTitle = hit.highlight().get("noteTitle").get(0);
//                    if (map.containsKey(noteId)){
//                        note = map.get(noteId);
//                    }
//                    note.setNoteTitle(noteTitle);
//                    map.put(noteId,note);
//                }
//            }
//        }
        List<Note> noteList= new ArrayList<>();
        Map<Long,Note> map = new HashMap<>();
        searchKeyUtil("noteTitle", key, map);
        searchKeyUtil("noteHtml", key, map);
        for (Map.Entry<Long, Note> longNoteEntry : map.entrySet()) {
            noteList.add(longNoteEntry.getValue());
        }
        return noteList;
    }

    @Override
    public int updateNoteList(List<Note> notes) throws IOException {
        BulkRequest.Builder br = new BulkRequest.Builder();
        for (Note note : notes) {
            br.operations(op -> op
                    .index(idx -> idx
                            .index("note")
                            .id(String.valueOf(note.getNoteId()))
                            .document(note)
                    )
            );
        }
        BulkResponse result = client.bulk(br.build());
        return result.items().size();
    }

    @Override
    public int updateEsNote(Note note) throws IOException {
        UpdateRequest<Note, Note> updateRequest = new UpdateRequest.Builder<Note,Note>().index("note")
                .id(String.valueOf(note.getNoteId())).doc(note).build();
        UpdateResponse<Note> update = client.update(updateRequest, Note.class);
        System.out.println(update.result());
        if("Updated".equals(update.result().toString())){
            return 1;
        }
        return 0;
    }

    @Override
    public int insertEsNote(Note note) throws IOException {
        IndexResponse response = client.index(i -> i
                .index("note")
                .id(String.valueOf(note.getNoteId()))
                .document(note)
        );
        System.out.println(response.result());
        if("Created".equals(response.result().toString())){
            return 1;
        }
        return 0;
    }

    @Override
    public int deleteEsNote(Long noteId) throws IOException {
        DeleteResponse delete = client.delete(d -> d.id(String.valueOf(noteId)).index("note"));
        if("Deleted".equals(delete.result().toString())){
            return 1;
        }
        return 0;
    }
}
