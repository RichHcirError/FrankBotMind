package ru.dpolulyakh.www.datamodel;

import org.hibernate.FlushMode;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import java.util.List;

/**
 * Created by Денис on 05.01.2017.
 */
public class StockDaoImpl extends HibernateDaoSupport implements StockDao{
    @Override
    public void save(Stock stock){
        getHibernateTemplate().getSessionFactory().getCurrentSession().setFlushMode(FlushMode.AUTO);
        getHibernateTemplate().save(stock);
    }
    @Override

    public void update(Stock stock){
        getHibernateTemplate().getSessionFactory().getCurrentSession().setFlushMode(FlushMode.AUTO);
        getHibernateTemplate().update(stock);
    }
    @Override
     public void delete(Stock stock){
        getHibernateTemplate().getSessionFactory().getCurrentSession().setFlushMode(FlushMode.AUTO);
        getHibernateTemplate().delete(stock);
    }
    @Override
     public Stock findByStockCode(String stockCode){
        List list = getHibernateTemplate().find("from Stock where stockCode=?",stockCode);
        return (Stock)list.get(0);
    }

}
