package com.editdining.response;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

@Getter
@Setter
public class PageResult<T> extends CommonResult {
    private long totalPages;
    private long totalElements;
    private boolean isLast;
    private boolean isFirst;
    private boolean hasPrevious;
    private boolean hasNext;
    private Pageable pageable;
    private long number;
    private long size;
    private Sort sort;
    private long numberOfElements;
    private List<T> list;

}
