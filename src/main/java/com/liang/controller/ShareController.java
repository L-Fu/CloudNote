package com.liang.controller;

import com.liang.pojo.Note;
import com.liang.pojo.Share;
import com.liang.service.ShareService;
import com.liang.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

/**
 * @author: Liang
 * @date: 2022年10月28日 10:53
 * @ClassName: ShareController
 * @Description: TODO
 */

@RestController
@RequestMapping("/share")
@CrossOrigin
public class ShareController {

    @Autowired
    private ShareService shareService;

    /**
     * 功能描述:
     * TODO
     * @param noteId
     * @return com.liang.vo.Result
     * @author Liang
     * @date 2022/10/28 16:06
    */
    @PostMapping("/getShare")
    public Result getShare(long noteId){
        Share share = shareService.getShare(noteId);
        if (Objects.isNull(share)){
            shareService.shareNote(noteId);
            share = shareService.getShare(noteId);
        }
        return Result.ok(share);
    }

    /**
     * 功能描述:
     * TODO
     * @param noteId
     * @return com.liang.vo.Result
     * @author Liang
     * @date 2022/10/28 16:13
    */
    @PostMapping ("/addShare")
    public Result addShare(long noteId){
        String url = shareService.shareNote(noteId);
        return Result.ok(url);
    }

    /**
     * 功能描述:
     * 停止分享
     * @param shareId
     * @return com.liang.vo.Result
     * @author Liang
     * @date 2022/10/28 20:26
    */
    @PostMapping("/delShare")
    public Result delShare(long shareId){
        int i = shareService.delShare(shareId);
        String msg = "停止"+i+"条分享";
        return Result.ok(msg);
    }

    /**
     * 功能描述:
     * 更新分享
     * @param share
     * @return com.liang.vo.Result
     * @author Liang
     * @date 2022/10/28 20:27
    */
    @PostMapping("/updateShare")
    public Result updateShare(Share share){
        int i = shareService.updateShare(share);
        String msg = "增加"+i+"条分享";
        return Result.ok(msg);
    }
    /**
     * 功能描述:
     * TODO
     * @param url
     * @return com.liang.vo.Result
     * @author Liang
     * @date 2022/10/28 20:57
    */
    @PostMapping("/queryShareByUrl")
    public Result queryShareByUrl(String url){
        Note note = shareService.queryShareByUrl(url);
        return Result.ok(note);
    }
}
