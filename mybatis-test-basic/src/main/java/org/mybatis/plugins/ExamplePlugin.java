package org.mybatis.plugins;

import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Signature;

import java.util.Properties;

/**
 * Created by Administrator on 2016/11/16.
 */
@Intercepts({@Signature(type = Executor.class, method = "update", args = {MappedStatement.class, Object.class})})
public class ExamplePlugin implements Interceptor{
    public Object intercept(Invocation invocation) throws Throwable {
        return null;
    }

    public Object plugin(Object target) {
        return null;
    }

    public void setProperties(Properties properties) {

    }
}
