package domain.system.service.impl;

import domain.shiro.entity.PageQueryResult;
import domain.system.dao.RoleDao;
import domain.system.entity.RoleEntity;
import domain.system.service.RoleManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

@Service
@Transactional
public class RoleManagementServiceImpl implements RoleManagementService{

    private final RoleDao roleDao;

    @Autowired
    public RoleManagementServiceImpl(RoleDao roleDao){
        this.roleDao = roleDao;
    }
    @Override
    public PageQueryResult roleListInfo(RoleEntity roleEntity) {

        PageQueryResult pageQueryResult = new PageQueryResult();

        List<RoleEntity> roleEntities = newArrayList();

        final Integer count = roleDao.roleCount(roleEntity);

        if (count > 0){
            roleEntities = roleDao.roleListInfo(roleEntity);
        }

        pageQueryResult.setTotal(count);
        pageQueryResult.setRows(roleEntities);
        return pageQueryResult;
    }

    @Override
    public Boolean addRole(RoleEntity roleEntity) {
        return roleDao.addRole(roleEntity) > 0;
    }

    @Override
    public Boolean checkRoleName(Long id, String roleName) {
        Integer flag = roleDao.checkRoleName(id,roleName);
        return flag<1;
    }

    @Override
    public Boolean editRole(RoleEntity roleEntity) {
        return roleDao.editRole(roleEntity) > 0;
    }

    @Override
    public Boolean deleRole(Long id, Long loginId) {
        return roleDao.deleRole(id,loginId);
    }
}
