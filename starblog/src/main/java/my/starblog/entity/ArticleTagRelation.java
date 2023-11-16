package my.starblog.entity;

import java.io.Serializable;

/**
 * (ArticleTagRelation)实体类
 *
 * @author Chenzixin
 * @email 2212294009@qq.com
 * @github https://github.com/star-start
 * @since 2022-12-17 17:06:18
 */
public class ArticleTagRelation implements Serializable {
    private static final long serialVersionUID = 969666879503526484L;
    /**
    * 关系表id
    */
    private Integer relationId;
    /**
    * 文章id
    */
    private Integer articleId;
    /**
    * 标签id
    */
    private Integer tagId;


    public Integer getRelationId() {
        return relationId;
    }

    public void setRelationId(Integer relationId) {
        this.relationId = relationId;
    }

    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    public Integer getTagId() {
        return tagId;
    }

    public void setTagId(Integer tagId) {
        this.tagId = tagId;
    }

}