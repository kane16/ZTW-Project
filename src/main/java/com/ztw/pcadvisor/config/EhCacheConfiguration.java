package com.ztw.pcadvisor.config;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.cache.ehcache.EhCacheManagerFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = "com.ztw.pcadvisor.repository")
@EnableCaching
@Configuration
public class EhCacheConfiguration {

    @Bean
    public CacheManager getCacheManager(){
        return new EhCacheCacheManager(getEhCacheManagerFactoryBean().getObject());
    }

    @Bean
    public EhCacheManagerFactoryBean getEhCacheManagerFactoryBean(){
        EhCacheManagerFactoryBean managerFactoryBean = new EhCacheManagerFactoryBean();
        managerFactoryBean.setConfigLocation(new ClassPathResource("ehCaches.xml"));
        managerFactoryBean.setShared(true);
        return managerFactoryBean;
    }

}
