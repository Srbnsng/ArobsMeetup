package com.arobs.ArobsMeetup.service.prize;

import com.arobs.ArobsMeetup.entity.PrizeEntity;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.ConfigurableMapper;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class PrizeMapper extends ConfigurableMapper implements ApplicationContextAware {

    PrizeMapper(){
        super(false);
    }

    @Override
    protected void configure(MapperFactory factory) {
        super.configure(factory);
        factory.classMap(PrizeEntity.class, PrizeDTO.class)
                .byDefault()
                .register();
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        init();
    }
}
