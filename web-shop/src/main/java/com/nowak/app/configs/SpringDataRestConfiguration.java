package com.nowak.app.configs;

import com.nowak.app.entities.Item;
import com.nowak.app.entities.ItemCategory;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.support.ConfigurableConversionService;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;

@Configuration
public class SpringDataRestConfiguration implements RepositoryRestConfigurer {

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
    }

    @Override
    public void configureConversionService(ConfigurableConversionService conversionService) {

    }
}
