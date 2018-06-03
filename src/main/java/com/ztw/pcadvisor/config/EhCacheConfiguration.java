package com.ztw.pcadvisor.config;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.cache.ehcache.EhCacheManagerFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * The type Eh cache configuration.
 */
@EnableJpaRepositories(basePackages = "com.ztw.pcadvisor.repository")
@EnableCaching
@Configuration
public class EhCacheConfiguration {

    /**
     * Get cache manager cache manager.
     *
     * @return the cache manager
     */
    @Bean
    public CacheManager getCacheManager(){
        return new EhCacheCacheManager(getEhCacheManagerFactoryBean().getObject());
    }

    /**
     * Get ehcache manager factory bean eh cache manager factory bean.
     *
     * @return the eh cache manager factory bean
     */
    @Bean
    public EhCacheManagerFactoryBean getEhCacheManagerFactoryBean(){
        EhCacheManagerFactoryBean managerFactoryBean = new EhCacheManagerFactoryBean();
        managerFactoryBean.setConfigLocation(new ClassPathResource("ehCaches.xml"));
        managerFactoryBean.setShared(true);
        return managerFactoryBean;
    }

}
