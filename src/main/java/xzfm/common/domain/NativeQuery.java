package xzfm.common.domain;

import org.hibernate.SQLQuery;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 * Created by wangxizhong on 16/12/18.
 *
 * @author wangxizhong
 * @return Map
 */
@Configuration
public class NativeQuery {

    @Autowired
    //@PersistenceContext
    private  EntityManager entityManager;

    public  EntityManager getEntityManager() {
        return entityManager;
    }

  /*  public  void setEntityManager(EntityManager entityManager) {
        if (entityManager == null || NativeQuery.entityManager != entityManager)
            NativeQuery.entityManager = entityManager;
    }*/

    public  Query createQuery(String sql) {
        Query query = entityManager.createNativeQuery(sql);
        query.unwrap(SQLQuery.class).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        return query;
    }
}

