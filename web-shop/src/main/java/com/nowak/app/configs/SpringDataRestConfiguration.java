package com.nowak.app.configs;

import com.nowak.app.entities.Item;
import com.nowak.app.entities.ItemCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.support.ConfigurableConversionService;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;

import javax.persistence.EntityManager;
import javax.persistence.metamodel.EntityType;
import javax.persistence.metamodel.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Configuration
public class SpringDataRestConfiguration implements RepositoryRestConfigurer {

    private final EntityManager entityManager;

    @Autowired
    public SpringDataRestConfiguration(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    private final HttpMethod[] disabledHttpMethods = {
            HttpMethod.POST,
            HttpMethod.PUT,
            HttpMethod.DELETE
    };

    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration configuration) {
        configuration.getExposureConfiguration()
                .forDomainType(Item.class)
                .withItemExposure(((metdata, httpMethods) ->
                        httpMethods.disable(disabledHttpMethods)))
                .withCollectionExposure(((metdata, httpMethods) ->
                        httpMethods.disable(disabledHttpMethods)));

        configuration.getExposureConfiguration()
                .forDomainType(ItemCategory.class)
                .withItemExposure(((metdata, httpMethods) ->
                        httpMethods.disable(disabledHttpMethods)))
                .withCollectionExposure(((metdata, httpMethods) ->
                        httpMethods.disable(disabledHttpMethods)));

        displayCategoryId(configuration);
    }

    /*
    this fynction adds self id for every category entity in response
     */
    private void displayCategoryId(RepositoryRestConfiguration configuration) {
        Set<EntityType<?>> entityTypeSet = entityManager
                .getMetamodel()
                .getEntities();

        List<Class<?>> list = entityTypeSet.stream()
                .map(Type::getJavaType)
                .collect(Collectors.toList());
        Class[] types = list.toArray(new Class[0]);
        configuration.exposeIdsFor(types);
    }

    @Override
    public void configureConversionService(ConfigurableConversionService conversionService) {

    }
}
