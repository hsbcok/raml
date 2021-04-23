package com.gaoke.gen;

import com.gaoke.bean.ControllerBean;
import com.gaoke.bean.ControllerMethod;
import freemarker.template.TemplateException;
import com.google.common.io.Resources;
import org.raml.v2.api.RamlModelBuilder;
import org.raml.v2.api.RamlModelResult;
import org.raml.v2.api.model.v08.methods.Method;
import org.raml.v2.api.model.v08.resources.Resource;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class RamlParserUse {

    public static void main(String[] args) {
        ControllerBean cbean = buildController();
        try {
            ControllerGen.gen(cbean);

        } catch (IOException | TemplateException e) {
            e.printStackTrace();
        }

    }


    static ControllerBean buildController() {
        URL url = Resources.getResource("a.raml");
        File ramlFile = new File(url.getPath());
        System.out.println(url);
        RamlModelResult ramlModelResult = new RamlModelBuilder().buildApi(ramlFile);

        ControllerBean cbean = new ControllerBean();

        String className = ramlFile.getName().substring(0, ramlFile.getName().indexOf("."));
        className = "G" + className;
        cbean.setClassName(className);
        cbean.setPackageName("com.gaoke.controller");
        cbean.setRootPath("/");
        List<ControllerMethod> cMethods = new ArrayList<>();
        cbean.setMethods(cMethods);

        List<Resource> resources = ramlModelResult.getApiV08().resources();
        for (Resource re : resources) {
            String path = re.resourcePath();
            List<Method> methods = re.methods();
            String methodName;
            //get method 0
            Method method = methods.get(0);
            if(method.method().equalsIgnoreCase("get")){
                methodName = "GetMapping";
            }else{
                methodName = "PostMapping";
            }
            ControllerMethod cmethod = new ControllerMethod();

            cmethod.setGetOrPost(methodName);
            cmethod.setMappingPath(path);
            String mName = path.substring(1);
            mName.replaceAll("-", "_");
            cmethod.setMethodName(mName);

            cMethods.add(cmethod);
        }
        return cbean;
    }
}
