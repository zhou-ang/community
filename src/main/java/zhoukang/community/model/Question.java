package zhoukang.community.model;

import lombok.Data;

import java.io.Serializable;

/**
 * question
 * @author 
 */
@Data
public class Question implements Serializable {
    private Integer id;

    private String title;

    private Long gmt_create;

    private Long gmt_modified;

    private String creator;

    private Integer comment_count;

    private Integer view_count;

    private Integer like_count;

    private String tags;

    private String description;

    private static final long serialVersionUID = 1L;

}