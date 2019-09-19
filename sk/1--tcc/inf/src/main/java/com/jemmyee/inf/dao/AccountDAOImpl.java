package com.jemmyee.inf.dao;

import com.jemmyee.core.dao.BaseDAOImpl;
import com.jemmyee.inf.entity.Account;
import org.springframework.stereotype.Repository;

/**
 * 文件名称                ：AccountDAOImpl
 * 编写者                  : wanyixing
 * 编写日期                : 2017-9-8
 * 编写时间                : 09:37
 * 程序功能（类）描述       ：<p>
 */
@Repository("accountDAOImpl")
public class AccountDAOImpl extends BaseDAOImpl<Account> implements IAccountDAO {
}
