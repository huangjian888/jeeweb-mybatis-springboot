package com.company.business.goods.moudle.service;

import com.company.business.goods.moudle.entity.SubjectEntity;

import java.util.List;

public interface ISubjectService {
    List<SubjectEntity> getSubjectByCategoryId(String categoryId);
}
