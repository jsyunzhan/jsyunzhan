package domain.listen.service.impl;

import domain.listen.dao.NoteDao;
import domain.listen.entity.NoteEntity;
import domain.listen.service.QureManagementService;
import domain.person.dao.ListenerDao;
import domain.shiro.entity.PageQueryResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

@Service
@Transactional
public class QureManagementServiceImpl implements QureManagementService{
    final private ListenerDao listenerDao;
    final private NoteDao noteDao;

    @Autowired
    public QureManagementServiceImpl(ListenerDao listenerDao,NoteDao noteDao){
        this.listenerDao = listenerDao;
        this.noteDao = noteDao;
    }

    @Override
    public PageQueryResult noteListInfo(NoteEntity noteEntity) {
        final PageQueryResult pageQueryResult = new PageQueryResult();
        final Integer count = noteDao.noteListCount(noteEntity);
        List<NoteEntity> noteEntities = newArrayList();

        if (count > 0){
            noteEntities = noteDao.noteList(noteEntity);
        }

        pageQueryResult.setTotal(count);
        pageQueryResult.setRows(noteEntities);

        return pageQueryResult;
    }
}
