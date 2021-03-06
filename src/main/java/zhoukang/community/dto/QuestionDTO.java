package zhoukang.community.dto;

import lombok.Data;
import zhoukang.community.model.User;

import java.util.List;

/**
 * Created by codedrinker on 2019/5/7.
 */
@Data
public class QuestionDTO {
    private Integer id;

    private String title;

    private Long gmt_create;

    private Long gmt_modified;

    private String creator;

    private Integer comment_count;

    private Integer view_count;

    private Integer like_count;

    private String tags;

    private String description;;

    private User user;

    private List<Integer> pages;
}
