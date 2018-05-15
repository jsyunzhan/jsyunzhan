package domain.person.service.impl;

import domain.person.dao.ListenerDao;
import domain.person.entity.ListenerEntity;
import domain.person.service.ListenerManagementService;
import domain.shiro.entity.PageQueryResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

@Service
@Transactional
public class ListenerManagementServiceImpl implements ListenerManagementService{

    private ListenerDao listenerDao;

    @Autowired
    public ListenerManagementServiceImpl(ListenerDao listenerDao){
        this.listenerDao = listenerDao;
    }

    @Override
    public PageQueryResult listenerList(ListenerEntity listenerEntity) {
        final PageQueryResult pageQueryResult = new PageQueryResult();

        final Integer count = listenerDao.listenerCount(listenerEntity);

        List<ListenerEntity> listenerEntities = newArrayList();

        if (count > 0){
            listenerEntities = listenerDao.listenerListInof(listenerEntity);
        }

        pageQueryResult.setRows(listenerEntities);
        pageQueryResult.setTotal(count);
        return pageQueryResult;
    }

    @Override
    public Boolean addListener(ListenerEntity listenerEntity) {
        return listenerDao.addListener(listenerEntity) > 0;
    }

    @Override
    public Boolean editListener(ListenerEntity listenerEntity) {
        return listenerDao.editListener(listenerEntity) > 0;
    }

    @Override
    public Boolean deleteListener(Long id, Long loginId) {
        return listenerDao.deleteListener(id,loginId) > 0;
    }
}
