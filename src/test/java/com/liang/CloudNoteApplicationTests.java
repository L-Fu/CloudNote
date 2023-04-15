package com.liang;

//import com.liang.e.UserDao;
import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch.core.*;
import co.elastic.clients.elasticsearch.core.search.Highlight;
import co.elastic.clients.elasticsearch.core.search.HighlightField;
import co.elastic.clients.elasticsearch.core.search.Hit;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
//import com.liang.dao.EsNoteMapper;
import com.liang.dao.EsNoteDao;
import com.liang.dto.UserDTO;
import com.liang.mapper.NoteMapper;
import com.liang.mapper.UserMapper;
import com.liang.pojo.Note;
import com.liang.service.ScheduleService;
import com.liang.util.UserHolder;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@Slf4j
@SpringBootTest
class CloudNoteApplicationTests {

    @Resource
//    private UserDao userMapper;
    private UserMapper userMapper;
    @Autowired
    private ScheduleService scheduleService;
    @Autowired
    private EsNoteDao esNoteDao;
    @Resource
    private NoteMapper noteMapper;
    @Autowired
    private ElasticsearchClient client;




    @Test
    void contextLoads() throws IOException {
//        SearchRequest searchRequest = new SearchRequest("note");
//
//        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder(); //1
//        SearchSourceBuilder query1 = sourceBuilder.query(QueryBuilders.termQuery("note", "啊"));
//
//        System.out.println(query1);
//        Note note = noteMapper.selectById(10036);
//        Note save = esNoteMapper.save(note);
//        System.out.println(esNoteMapper.findAll());

//        QueryBuilder query = QueryBuilders.boolQuery().must(QueryBuilders.termQuery("noteHtml", "人民"));


// And create the API client
//        ElasticsearchClient client = new ElasticsearchClient(transport);
//
//        QueryWrapper<Note> queryWrapper = new QueryWrapper<>();
//        queryWrapper.eq("uid","10004");
//
//        List<Note> notes = noteMapper.selectList(queryWrapper);
//
//        BulkRequest.Builder br = new BulkRequest.Builder();
//
//        for (Note note : notes) {
//            br.operations(op -> op
//                    .index(idx -> idx
//                            .index("note")
//                            .id(String.valueOf(note.getNoteId()))
//                            .document(note)
//                    )
//            );
//        }
//        BulkResponse result = client.bulk(br.build());
//        System.out.println(result.items().get(0).result());
//        notes.get(0).setNoteTitle("你好");
//        UpdateRequest<Note, Note> updateRequest = new UpdateRequest.Builder<Note,Note>().index("note")
//                .id(String.valueOf(notes.get(0).getNoteId())).doc(notes.get(0)).build();
//        UpdateResponse<Note> update = client.update(updateRequest, Note.class);
//        System.out.println(update.result());
////        HighlightField highlightField = new HighlightField.Builder().build();
//        HighlightField.Builder highlightFieldBuilder = new HighlightField.Builder();
//        HighlightField highlightField = highlightFieldBuilder.build();
//        //构建高亮字段
//        Highlight.Builder highlightBuilder = new Highlight.Builder();
//        Highlight highlight = highlightBuilder.fields("noteHtml", highlightField).preTags("<span style=\"background-color: #fbeeb8;\">").postTags("</span>").build();
////        Highlight highlight = new Highlight.Builder().fields("body",highlightField)
////                .preTags("<tag1>", "<tag2>").postTags("</tag1>", "</tag2>").build();
////        System.out.println(highlight);
//        SearchResponse<Note> response = client.search(s -> s
//                        .index("note")
//                        .query(q -> q
//                                .match(t -> t
//                                        .field("noteHtml")
//                                        .query("啊")
//                                        .analyzer("ik_max_word")
//                                )
//
//                        ).highlight(highlight)
//                ,
//
//                Note.class
//        );
//        SearchResponse<Note> res = client.search(s -> s
//                        .index("note")
//                        .query(q -> q.bool(a->a
//                                        .must(c->c.match(d->d
//                                                .field("uid")
//                                                .query(10004)
//                                        ))
//                                        .must(b->b.match(t -> t
//                                                .field("noteHtml")
//                                                .query("啊")
//                                                .analyzer("ik_max_word")
//                                ))
//                                )
//
//                        ).highlight(highlight)
//                ,
//                Note.class
//        );
////        System.out.println(res.hits().hits());
//        List<Hit<Note>> hits = response.hits().hits();
//        for (Hit<Note> hit: hits) {
//            Map<String, List<String>> highlight1 = hit.highlight();
//            System.out.println(highlight1.get("noteHtml"));
////            String noteHtml = highlight1.get("noteHtml").get(0);
////            String noteTitle = highlight1.get("noteTitle").get(0);
////            System.out.println(noteTitle);
//            Note note = hit.source();
////            assert note != null;
////            note.setNoteHtml();
//            System.out.println(note);
//        }

    }
    @Test
    public void esTest() throws IOException {
//        UserHolder.saveUser(new UserDTO(10004,"asd","","",""));
//        Note note = noteMapper.selectById(10040);
////        note.setNoteId(note.getNoteId()+10);
//        note.setNoteHtml("啊啊啊");
////        esNoteDao.updateEsNote(note);
//        List<Note> noteList = esNoteDao.searchKey("啊");
//        esNoteDao.insertEsNote(note);
//        esNoteDao.deleteEsNote(10046L);
//        QueryWrapper<Note> queryWrapper = new QueryWrapper<>();
//        queryWrapper.eq("uid","10004");
//
//        List<Note> notes = noteMapper.selectList(queryWrapper);
//        notes.add(note);
//        esNoteDao.updateNoteList(notes);
    }

}
