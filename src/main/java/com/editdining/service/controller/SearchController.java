package com.editdining.service.controller;

import com.editdining.response.CommonResult;
import com.editdining.response.ResponseService;
import com.editdining.service.dto.ServiceDto;
import com.editdining.service.service.SearchService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/* 서버비용 문제로 서비스 컨트롤러에 검색 api도 추가 */
@ApiOperation(value = "8. 검색")
@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping("/")
public class SearchController {

    private final SearchService service;
    private final ResponseService responseService = new ResponseService();

    @ApiOperation(value = "8-1. 검색")
    @GetMapping(path = "search")
    public CommonResult search(
            @RequestHeader(value="member_id", required = false, defaultValue = "0") int member_id
            , @RequestParam(value = "category", defaultValue = "0",required = false) int category
            , @RequestParam(value = "keyword")String keyword
            , @RequestParam(value = "offset", defaultValue="0", required = false) int offset
            , @RequestParam(value = "limit", defaultValue = "25", required = false) int limit) {
        List<ServiceDto.Response> list = service.search(keyword, category, member_id, offset, limit);
        long totalCount = service.searchTotal(keyword, category);
        return responseService.getListResult(totalCount, list);
    }
}
