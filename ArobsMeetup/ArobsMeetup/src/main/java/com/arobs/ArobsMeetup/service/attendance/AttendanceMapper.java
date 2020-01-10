package com.arobs.ArobsMeetup.service.attendance;

import com.arobs.ArobsMeetup.entity.AttendanceEntity;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.ConfigurableMapper;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class AttendanceMapper extends ConfigurableMapper implements ApplicationContextAware {

    public AttendanceMapper(){
        super(false);
    }
    @Override
    protected void configure(MapperFactory factory) {
        super.configure(factory);
        factory.classMap(AttendanceEntity.class, AttendanceDTO.class)
                .byDefault()
                .register();
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        init();
    }
}
