package com.arobs.ArobsMeetup.service.event;

import com.arobs.ArobsMeetup.entity.EventEntity;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.ConfigurableMapper;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class EventMapper extends ConfigurableMapper implements ApplicationContextAware {

    public EventMapper(){
        super(false);
    }
    @Override
    protected void configure(MapperFactory factory) {
        super.configure(factory);
        factory.classMap(EventEntity.class, EventDTO2.class)
                .byDefault()
                .register();
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        init();
    }
}
