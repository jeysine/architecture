package utils.code.generate;

import freemarker.cache.ClassTemplateLoader;
import freemarker.cache.NullCacheStorage;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;

import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by yarus li on 2017/7/30.
 */
public class FreeMarkerTemplateUtils {

    private FreeMarkerTemplateUtils(){}
    private static final Configuration CONFIGURATION = new Configuration(Configuration.VERSION_2_3_22);

    static{
        //这里比较重要，用来指定加载模板所在的路径
        CONFIGURATION.setTemplateLoader(new ClassTemplateLoader(FreeMarkerTemplateUtils.class, "/templates"));
        CONFIGURATION.setDefaultEncoding("UTF-8");
        CONFIGURATION.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
        CONFIGURATION.setCacheStorage(NullCacheStorage.INSTANCE);
    }

    public static Template getTemplate(String templateName) throws IOException {
        try {
            return CONFIGURATION.getTemplate(templateName);
        } catch (IOException e) {
            throw e;
        }
    }

    public static void clearCache() {
        CONFIGURATION.clearTemplateCache();
    }

    /**
     * generate output from template using the data-model provided
     *
     * @param templateFileName
     *            relative to the configured base dir
     * @param properties
     * @return
     */
    public static String generate(String templateFileName, Map<String, Object> properties) throws IOException, TemplateException {
        Map<String, Object> copiedProperties;
        if (properties == null) {
            copiedProperties = new HashMap<>();
        } else {
            copiedProperties = new HashMap<>(properties);
        }

        Template template = FreeMarkerTemplateUtils.getTemplate(templateFileName);

        if (template == null) {
            throw new IOException("not find this template");
        }
        StringWriter output = new StringWriter();
        processVariable(copiedProperties);
        template.process(copiedProperties, output);

        return output.toString();
    }

    /**
     * 对模板变量的通用预处理(比如自定义方法、通用参数添加操作)
     *
     * @param variables
     * @return
     */
    public static Map<String, Object> processVariable(Map<String, Object> variables) {
        variables.put("encodeURL", EncodingUtil.utf8UrlEncode(variables.toString()));
        return variables;
    }
}