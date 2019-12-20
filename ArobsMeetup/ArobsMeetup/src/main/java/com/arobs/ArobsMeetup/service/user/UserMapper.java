package com.arobs.ArobsMeetup.service.user;

import com.arobs.ArobsMeetup.entity.UserEntity;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.ConfigurableMapper;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class UserMapper extends ConfigurableMapper implements ApplicationContextAware {


    private MapperFactory factory;
    private ApplicationContext applicationContext;

    public UserMapper(){

        super(false);
    }

    protected void configure(MapperFactory factory){
        this.factory = factory;
        factory.classMap(UserEntity.class, UserDTO.class).byDefault().register();

    }


    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {

        this.applicationContext = applicationContext;
        init();
    }
}
