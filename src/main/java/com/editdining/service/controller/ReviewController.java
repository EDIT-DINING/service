package com.editdining.service.controller;

import com.editdining.response.CommonResult;
import com.editdining.response.ResponseService;
import com.editdining.service.dto.ReviewDto;
import com.editdining.service.entity.PurchaseReviewEntity;
import com.editdining.service.service.ReviewService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@ApiOperation(value = "6. 리뷰")
@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping("/review")
public class ReviewController {

    private final ResponseService responseService = new ResponseService();

    private final ReviewService service;

    @ApiOperation(value = "6-1. 리뷰 리스트")
    @GetMapping(path = "{service_id}")
    public CommonResult list(@PathVariable(value = "service_id") int service_id,
                             final Pageable pageable) {
        Page<ReviewDto> list = service.getList(service_id, pageable).map(ReviewDto::new);
        return responseService.getPageResult(list);
    }
}