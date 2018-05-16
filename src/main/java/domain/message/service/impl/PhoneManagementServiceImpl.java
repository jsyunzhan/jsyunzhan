package domain.message.service.impl;

import domain.message.dao.PhoneDao;
import domain.message.entity.PhoneEntity;
import domain.message.service.PhoneManagementService;
import domain.shiro.entity.PageQueryResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

@Service
@Transactional
public class PhoneManagementServiceImpl implements PhoneManagementService{

    final private PhoneDao phoneDao;

    @Autowired
    public PhoneManagementServiceImpl(PhoneDao phoneDao){
        this.phoneDao = phoneDao;
    }

    @Override
    public PageQueryResult phoneMessInfo(PhoneEntity phoneEntity) {

        final PageQueryResult pageQueryResult = new PageQueryResult();

        final Integer count = phoneDao.phoneMessCount(phoneEntity);

        List<PhoneEntity> phoneEntities = newArrayList();

        if (count > 0){
            phoneEntities = phoneDao.phoneMessList(phoneEntity);
        }

        pageQueryResult.setRows(phoneEntities);
        pageQueryResult.setTotal(count);

        return pageQueryResult;
    }

    @Override
    public Boolean phoneMessAdd(PhoneEntity phoneEntity) {
        return phoneDao.phoneMessAdd(phoneEntity) > 0;
    }

    @Override
    public Boolean phoneMessEdit(PhoneEntity phoneEntity) {
        return phoneDao.phoneMessEdit(phoneEntity) > 0;
    }

    @Override
    public Boolean phoneMessDelete(Long id, Long loginId) {
        return phoneDao.phoneMessDelete(id,loginId) > 0;
    }
}
