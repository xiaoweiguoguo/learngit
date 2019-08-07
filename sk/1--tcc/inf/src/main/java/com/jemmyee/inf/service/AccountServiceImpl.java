package com.jemmyee.inf.service;

import com.github.pagehelper.PageInfo;
import com.jemmyee.core.entity.BaseExample;
import com.jemmyee.core.service.BaseServiceImpl;
import com.jemmyee.inf.dao.IAccountDAO;
import com.jemmyee.inf.entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 文件名称                ：AccountServiceImpl
 * 编写者                  : wanyixing
 * 编写日期                : 2017-9-8
 * 编写时间                : 09:39
 * 程序功能（类）描述       ：<p>
 */
@Service("accountService")
public class AccountServiceImpl extends BaseServiceImpl<Account> implements IAccountService{
    @Autowired
    private IAccountDAO accountDAO;
    public Account selectByPrimaryKey(Long id) {
        return accountDAO.selectByPrimaryKey(id);
    }

    public Account selectByPrimaryKey(String id) {
        return accountDAO.selectByPrimaryKey(id);
    }

    public int insert(Account entity) {
        return accountDAO.insert(entity);
    }

    public int update(Account entity) {
        return accountDAO.update(entity);
    }

    public int deleteByPrimaryKey(Long id) {
        return accountDAO.deleteByPrimaryKey(id);
    }

    public int countByExample(BaseExample example) {
        return accountDAO.countByExample(example);
    }

    public List<Account> selectByExample(BaseExample exapmle) {
        return accountDAO.selectByExample(exapmle);
    }

    public PageInfo<Account> selectPageByexample(BaseExample exapmle, Integer pageSize, Integer pageNo) {
        return accountDAO.selectPageByexample(exapmle,pageSize,pageNo);
    }
}
