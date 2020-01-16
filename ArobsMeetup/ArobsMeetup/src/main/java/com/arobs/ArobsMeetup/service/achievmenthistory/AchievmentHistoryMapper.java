package com.arobs.ArobsMeetup.service.achievmenthistory;

import com.arobs.ArobsMeetup.entity.AchievementHistoryEntity;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.ConfigurableMapper;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class AchievmentHistoryMapper extends ConfigurableMapper implements ApplicationContextAware {

    public AchievmentHistoryMapper(){
        super(false);
    }

    @Override
    protected void configure(MapperFactory factory) {
        super.configure(factory);
        factory.classMap(AchievementHistoryEntity.class, AchievmentHistoryDTO.class)
                .byDefault()
                .register();
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        init();
    }
}
