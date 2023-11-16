package my.starblog.service;

import my.starblog.entity.Article;
import my.starblog.entity.Tag;
import my.starblog.entity.TimeLineYear;

import java.util.List;
import java.util.Map;

/**
 * (Article)表服务接口
 *
 * @author Chenzixin
 * @email 2212294009@qq.com
 * @github https://github.com/star-start
 * @since 2022-102-18 00:33:49
 */
public interface ArticleService {

    List<Article> getBriefArticlesByStatus(Integer userId, Byte status, String keyword);

    List<Article> getBriefArticlesByCategoryName(String categoryName);

    List<Article> getBriefArticlesByTagName(String tagName);

    List<Tag> getTagsUsed();

    Article getArticleById(Integer articleId,Byte status);

    Map<String,Integer> getBlogCount();

    Map<String,Long> getDashboardCount(Integer userId);

    int addOrUpdateArticle(Article article);

    int updateStatusByArticleIds(Integer[] articleIds);

    int updateArticleFromTrash(Integer articleId,String articleTags);

    int deleteArticlesByArticleIds(Integer[] articleIds);

    List<TimeLineYear> getTimeLineYear();

}