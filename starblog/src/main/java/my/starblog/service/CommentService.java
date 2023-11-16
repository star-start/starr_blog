package my.starblog.service;

import my.starblog.entity.Comment;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * (Comment)表服务接口
 *
 * @author Chenzixin
 * @email 2212294009@qq.com
 * @github https://github.com/star-start
 * @since 2022-12-18 00:33:57
 */
public interface CommentService {

    List<Comment> getComments(Integer userId, Byte status, String titleKeyword, String contentKeyword, Integer articleId);

    int addCommentByArticleId(Comment Comment, HttpServletRequest httpServletRequest);

    int replyCommentByCommentId(Integer CommentId,String replyContent);

    int setComment(Integer commentId,Byte status);

    int deleteCommentByCommentId(Integer commentId);

}