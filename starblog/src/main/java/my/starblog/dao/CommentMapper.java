package my.starblog.dao;

import my.starblog.entity.Comment;
import org.apache.ibatis.annotations.Param;

import java.sql.Timestamp;
import java.util.List;

/**
 * (Comment)表数据库访问层
 *
 * @author Chenzixin
 * @email 2212294009@qq.com
 * @github https://github.com/star-start
 * @since 2022-12-18 00:15:00
 */
public interface CommentMapper {

    int selectCommentsCount(@Param("userId") Integer userId);


    List<Comment> selectComments(@Param("userId") Integer userId,
                                 @Param("status") Byte status,
                                 @Param("titleKeyword") String titleKeyword,
                                 @Param("contentKeyword") String contentKeyword,
                                 @Param("articleId") Integer articleId);


    int insertCommentByArticleId(Comment comment);

    int updateReplyByCommentId(@Param("commentId") Integer commentId,@Param("replyContent") String replyContent,@Param("replyCreateTime") Timestamp replyCreateTime);

    int updateStatusByCommentId(@Param("commentId") Integer commentId,@Param("status") Byte status);

    int deleteCommentByCommentId(@Param("commentId") Integer commentId);

}