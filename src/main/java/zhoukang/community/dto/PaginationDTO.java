package zhoukang.community.dto;

import lombok.Data;
import zhoukang.community.model.Question;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by codedrinker on 2019/5/14.
 */
@Data
public class PaginationDTO<T> {
    private List<QuestionDTO> questions;
    private Integer currentPage;
    private List<Integer> currentPages = new ArrayList<>();
    private Integer totalPage;

    public void setPagination(Integer totalCount, Integer currentPage, Integer size) {
        this.currentPage=currentPage;
        currentPages.add(currentPage);
        if(totalCount%5==0){
            totalPage=totalCount/size;
        }else{
            totalPage=totalCount/size+1;
        }
        //pages的范围
        for (int i = 1; i <= 3; i++) {
            if (currentPage - i > 0) {
                currentPages.add(0, currentPage - i);
            }
            if (currentPage + i <= totalPage) {
                currentPages.add(currentPage + i);
            }
        }
    }
}
