package com.company.business.goods.moudle.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.company.business.goods.moudle.entity.SubjectEntity;
import com.company.business.goods.moudle.mapper.SubjectMapper;
import com.company.business.goods.moudle.service.ISubjectService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("subjectService")
public class SubjectServiceImpl extends ServiceImpl<SubjectMapper, SubjectEntity> implements ISubjectService {
    @Override
    public List<SubjectEntity> getSubjectByCategoryId(String categoryId) {
        try {
            return baseMapper.getSubjectByCategoryId(categoryId);

        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
}
