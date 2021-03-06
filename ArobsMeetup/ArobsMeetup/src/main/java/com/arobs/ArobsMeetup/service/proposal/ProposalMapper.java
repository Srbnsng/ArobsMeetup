package com.arobs.ArobsMeetup.service.proposal;

import com.arobs.ArobsMeetup.entity.ProposalEntity;
import com.arobs.ArobsMeetup.service.proposal.ProposalDTO;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.ConfigurableMapper;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;


@Component
public class ProposalMapper extends ConfigurableMapper implements ApplicationContextAware {


    public ProposalMapper(){

        super(false);
    }

    @Override
    protected void configure(MapperFactory factory){

        factory.classMap(ProposalEntity.class, ProposalDTO.class)
                .byDefault()
                .register();

    }


    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {

        init();
    }
}
