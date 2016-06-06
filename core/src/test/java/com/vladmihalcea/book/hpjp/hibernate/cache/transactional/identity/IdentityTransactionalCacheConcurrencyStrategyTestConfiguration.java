package com.vladmihalcea.book.hpjp.hibernate.cache.transactional.identity;

import com.vladmihalcea.book.hpjp.util.spring.config.jta.HsqldbJtaTransactionManagerConfiguration;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

@Configuration
public class IdentityTransactionalCacheConcurrencyStrategyTestConfiguration extends HsqldbJtaTransactionManagerConfiguration {

    @Override
    protected Properties additionalProperties() {
        Properties properties = super.additionalProperties();
        properties.put("hibernate.cache.region.factory_class", "org.hibernate.cache.ehcache.EhCacheRegionFactory");
        properties.put("hibernate.generate_statistics", Boolean.TRUE.toString());
        return properties;
    }

    @Override
    protected Class configurationClass() {
        return IdentityTransactionalEntities.class;
    }
}