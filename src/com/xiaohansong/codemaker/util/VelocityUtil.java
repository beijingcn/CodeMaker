package com.xiaohansong.codemaker.util;

import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;

import java.io.StringWriter;
import java.util.Map;
import java.util.Properties;

/**
 * @author hansong.xhs
 * @version $Id: VelocityUtil.java, v 0.1 2017-01-22 下午8:49 hansong.xhs Exp $$
 */
public class VelocityUtil {

    private final static VelocityEngine velocityEngine;

    static {
        velocityEngine = new VelocityEngine();
        Properties props = new Properties();
        props.put("runtime.log.logsystem.class", "org.apache.velocity.runtime.log.SimpleLog4JLogSystem");
        props.put("runtime.log.logsystem.log4j.category", "velocity");
        props.put("runtime.log.logsystem.log4j.logger", "velocity");

        velocityEngine.init(props);
    }

    public static String evaluate(String template, Map<String, Object> map) {
        VelocityContext context = new VelocityContext();
        map.forEach(context::put);
        StringWriter writer = new StringWriter();
        velocityEngine.evaluate(context, writer, "", template);
        return writer.toString();
    }

}
