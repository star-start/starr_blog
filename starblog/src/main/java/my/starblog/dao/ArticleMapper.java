package my.starblog.dao;

import my.starblog.entity.Article;
import my.starblog.entity.TimeLineMonth;
import my.starblog.entity.TimeLineYear;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (Article)表数据库访问层
 *
 * @author Chenzixin
 * @email 2212294009@qq.com
 * @github https://github.com/star-start
 * @since 2022-12-18 00:14:58
 */
public interface ArticleMapper {

    List<Article> selectBriefArticlesByStatus(@Param("userId") Integer userId,@Param("status") Byte status, @Param("keyword") String keyword);

    List<Article> selectBriefArticlesByCategoryName( @Param("categoryName") String categoryName);

    List<Article> selectBriefArticlesByTagName(@Param("tagName") String tagName);

    Article selectArticleByArticleId(@Param("articleId") Integer articleId,@Param("status") Byte status);

    int updateViewsById(@Param("articleId") Integer articleId);

    int selectArticlesCount(@Param("userId") Integer userId,@Param("status") Byte status);

    Object selectViewsCount(@Param("userId") Integer userId);

    int insertArticle(Article article);

    int updateArticle(Article article);

    int updateStatusByArticleIds(@Param("articleIds") Integer[] articleIds);

    int updateArticleFromTrash(@Param("articleId") Integer articleId);

    int deleteArticlesByArticleIds(@Param("articleIds") Integer[] articleIds);

    //TimeLine
    List<TimeLineYear> selectTimeLineYear();

    List<TimeLineMonth> selectArticlesByYear(@Param("year") Integer year);

}