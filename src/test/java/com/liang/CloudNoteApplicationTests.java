package com.liang;

//import com.liang.e.UserDao;
import com.liang.dto.UserDTO;
import com.liang.mapper.CollectionMapper;
import com.liang.mapper.UserMapper;
import com.liang.pojo.Schedule;
import com.liang.pojo.User;
import com.liang.service.ScheduleService;
import com.liang.service.UserService;
import com.liang.util.UserHolder;
import com.liang.vo.LoginVO;
import io.github.furstenheim.CopyDown;
import io.github.furstenheim.Options;
import io.github.furstenheim.OptionsBuilder;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
class CloudNoteApplicationTests {

    @Resource
//    private UserDao userMapper;
    private UserMapper userMapper;
    @Autowired
    private ScheduleService scheduleService;
    @Test

    void contextLoads() {
//        String result = "<p style=\"line-height: 1;\">asfdfgasg</p>\n" +
//                "<p style=\"line-height: 1;\">aaaaaaa</p>";
//        OptionsBuilder optionsBuilder = OptionsBuilder.anOptions();
//        Options options = optionsBuilder.withBr("-")
//                // more options
//                .build();
//        CopyDown converter = new CopyDown(options);
//        String markdown = converter.convert(result);
//        System.out.println(markdown);
        String[] sA={"0","1"};
        String[] sA2={"0","1"};
        int rtn=0;
        for(int i=0;i<sA.length;i++){
            for(int j=0;j<sA2.length;j++){
                if ("1".equals(sA[i])&&"0".equals(sA2[j])){
                    continue;
                }else {
                    rtn++;
                }
            }
        }
        System.out.println(rtn);


    }

}
