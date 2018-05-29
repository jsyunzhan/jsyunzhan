package domain.message.service.impl;

import domain.message.dao.PhoneDao;
import domain.message.entity.PhoneEntity;
import domain.message.service.PhoneManagementService;
import domain.shiro.entity.PageQueryResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

@Service
@Transactional
public class PhoneManagementServiceImpl implements PhoneManagementService{
    private static final Logger LOGGER = LoggerFactory.getLogger(PhoneManagementServiceImpl.class);

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
        final Boolean flag = phoneDao.phoneMessAdd(phoneEntity) > 0;
        if (LOGGER.isDebugEnabled()){
            LOGGER.debug("手机消息新增结果:",flag);
        }
        return flag;
    }

    @Override
    public Boolean phoneMessEdit(PhoneEntity phoneEntity) {
        final Boolean flag = phoneDao.phoneMessEdit(phoneEntity) > 0;
        if (LOGGER.isDebugEnabled()){
            LOGGER.debug("手机消息修改结果:",flag);
        }
        return flag;
    }

    @Override
    public Boolean phoneMessDelete(Long id, Long loginId) {
        final Boolean flag = phoneDao.phoneMessDelete(id,loginId) > 0;
        if (LOGGER.isDebugEnabled()){
            LOGGER.debug("手机消息删除结果:",flag);
        }
        return flag;
    }
}
