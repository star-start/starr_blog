package my.starblog.controller.admin;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import my.starblog.entity.Article;
import my.starblog.entity.Comment;
import my.starblog.entity.Category;
import my.starblog.entity.Record;
import my.starblog.service.ArticleService;
import my.starblog.service.CategoryService;
import my.starblog.service.CommentService;
import my.starblog.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @author Chenzixin
 * @email 2212294009@qq.com
 * @github https://github.com/star-start
 * @since 2022-12-18 1:38 下午
 */
@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    ArticleService articleService;

    @Autowired
    CategoryService categoryService;

    @Autowired
    CommentService commentService;

    @Autowired
    RecordService recordService;


    @GetMapping("/all/article")
    public PageInfo getBriefArticleByStatus(@RequestParam(value = "userId",defaultValue = "-1") Integer userId,
                                            @RequestParam(value = "status",defaultValue = "-1") Byte status,
                                            @RequestParam(value = "keyword" , defaultValue = "") String keyword,
                                            @RequestParam(value = "curPage" , defaultValue = "1") Integer curPage,
                                            @RequestParam(value = "pageSize" , defaultValue="7") Integer pageSize){
        PageHelper.startPage(curPage,pageSize);
        List<Article> briefArticles= articleService.getBriefArticlesByStatus(userId, status, keyword);
        PageInfo<Article> articlePageInfo = new PageInfo<>(briefArticles);
        return articlePageInfo;
    }


    @GetMapping("/all/category")
    public PageInfo getCategories(@RequestParam(value = "userId",defaultValue = "-1") Integer userId,
                                  @RequestParam(value = "status" , defaultValue = "-1") Byte status,
                                  @RequestParam(value = "curPage" , defaultValue = "1") Integer curPage,
                                  @RequestParam(value = "pageSize" , defaultValue="7") Integer pageSize){
        PageHelper.startPage(curPage,pageSize);
        List<Category> categories= categoryService.getCategories(userId,status);
        PageInfo<Category> categoryPageInfo = new PageInfo<>(categories);
        return categoryPageInfo;

    }


    //管理页评论
    @GetMapping("/all/comment")
    public PageInfo<Comment> getComments(@RequestParam(value = "userId",defaultValue = "-1") Integer userId,
                                         @RequestParam(value = "status",defaultValue = "-1" ) Byte status,
                                         @RequestParam(value = "titleKeyword" , defaultValue = "" ) String titleKeyword,
                                         @RequestParam(value = "contentKeyword" , defaultValue = "" ) String contentKeyword,
                                         @RequestParam(value = "articleId" , defaultValue="-1") Integer articleId,
                                         @RequestParam(value = "curPage" , defaultValue="1") Integer curPage,
                                         @RequestParam(value = "pageSize" , defaultValue="7") Integer pageSize){
        PageHelper.startPage(curPage,pageSize);
        List<Comment> Comments= commentService.getComments(userId, status, titleKeyword,contentKeyword,articleId);
        PageInfo<Comment> PageInfo = new PageInfo<>(Comments);
        return PageInfo;
    }


    //管理页统计（文章、分类、浏览量、评论量 --单用户的全部文章）
    @GetMapping("/dashboardCount")
    public Map<String,Long> getDashboardCount(){
        return articleService.getDashboardCount(-1);
    }


    @GetMapping("/scheduleRecords")
    public List<Record> getScheduleRecordsInLatestWeek(){
        return  recordService.getScheduleRecordsInLatestWeek();
    }



}
