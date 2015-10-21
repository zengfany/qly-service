package com.qly.inject;

import com.google.inject.name.Names;
import com.qly.dao.IGoodsDao;
import com.qly.dao.IUserDao;
import com.qly.dao.IVenderDao;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.mybatis.guice.MyBatisModule;
import org.mybatis.guice.datasource.builtin.PooledDataSourceProvider;

import java.util.Properties;

/**
 * Created by Fanyi on 15/10/3.
 */
public class BindMybatisModule extends MyBatisModule {
    @Override
    protected void initialize() {
        Properties props = new Properties();
        props.setProperty("JDBC.driver", "com.mysql.jdbc.Driver");
        props.setProperty("JDBC.url", "jdbc:mysql://127.0.0.1:3307/beikenshop?useUnicode=true&characterEncoding=utf8");
        props.setProperty("JDBC.username", "root");
        props.setProperty("JDBC.password", "Abcd1234");

        environmentId("development");
        //bindDataSourceProviderType(UnpooledDataSourceProvider.class);
        bindDataSourceProviderType(PooledDataSourceProvider.class);
        bindTransactionFactoryType(JdbcTransactionFactory.class);
        Names.bindProperties(this.binder(), props);
        addMapperClasses("com.qly.dao.impl.mybatis.mapper");
        bind(IUserDao.class).to(com.qly.dao.impl.mybatis.UserDaoImpl.class);
        bind(IVenderDao.class).to(com.qly.dao.impl.mybatis.VenderDaoImpl.class);
        bind(IGoodsDao.class).to(com.qly.dao.impl.mybatis.GoodsDaoImpl.class);

    }
}
