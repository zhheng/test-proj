package org.apache.ibatis.submitted.rounding;

import org.apache.ibatis.reflection.factory.DefaultObjectFactory;

import java.util.List;
import java.util.Properties;

/**
 * Created by Administrator on 2016/11/15.
 */
public class ExampleObjectFactory extends DefaultObjectFactory {


    public void setProperties(Properties properties) {
        super.setProperties(properties);
    }

    public <T> T create(Class<T> type) {
        return super.create(type);
    }

    public <T> T create(Class<T> type, List<Class<?>> constructorArgTypes, List<Object> constructorArgs) {
        return super.create(type, constructorArgTypes, constructorArgs);
    }

    public <T> boolean isCollection(Class<T> type) {
        return super.isCollection(type);
    }
}
