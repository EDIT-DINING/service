package com.editdining.service.service;

import com.editdining.service.dto.ServiceDto;
import com.editdining.service.repository.ServiceMasterRepository;
import com.editdining.service.repository.ServiceMasterRepositorySupport;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;

@Log4j2
@RequiredArgsConstructor
@Service
public class SearchService {

    private final ServiceMasterRepositorySupport masterRepoSupport;

    public List<ServiceDto.Response> search(String keyword, int category, int member_id, int offset, int limit) {
        List<ServiceDto.Response> list = masterRepoSupport.search(keyword, category, member_id, offset, limit);
        return list;
    }

    public long searchTotal(String keyword, int category) {
        return masterRepoSupport.searchTotal(keyword, category);
    }
}
