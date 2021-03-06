package com.editdining.service.controller;

import com.editdining.response.CommonResult;
import com.editdining.response.ResponseService;
import com.editdining.service.dto.ServiceDto;
import com.editdining.service.service.ServiceService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@ApiOperation(value = "2. 서비스")
@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping("/")
public class ServiceController {

    private final ServiceService service;
    private final ResponseService responseService = new ResponseService();

    @ApiOperation(value = "2-1. 서비스 등록")
	@PostMapping(value = "", consumes = {"multipart/form-data"})
    public CommonResult save(@RequestHeader(value="member_id") int member_id
            , @ApiParam(name = "service 등록", required = true) @ModelAttribute ServiceDto.Save saveDto) throws IOException {
        saveDto.setMember_id(member_id);
        CommonResult result = service.save(saveDto);
        return result;
    }

    @ApiOperation(value = "2-2. 서비스 리스트")
    @GetMapping(path = "/{category}")
    public CommonResult get(
        @ApiParam(name = "1:영상편집 2:영상소스 3:캐리커처/일러스트 4:채널아트/채널아이콘 5:번역/자막 6:사운드/녹음", example = "1") @PathVariable(name="category", required = true) int category
        , @ApiParam(name = "1:일반편집 2:간단편집", example = "1") @RequestParam(value = "edit_type", required = false) Integer edit_type
        , @ApiParam(name = "개발중 popular recommend rate register", example = "register") @RequestParam(value = "sort", required = false) String sort
        , @ApiParam(name = "default : 0") @RequestParam(value = "offset", defaultValue = "0")int offset
        , @ApiParam(name = "default : 12") @RequestParam(value = "limit", defaultValue = "12")int limit) {
        List<ServiceDto.Response> list= service.findByCategory(category, edit_type, sort, offset, limit);

        return responseService.getListResult(list.size(), list);
    }


}
