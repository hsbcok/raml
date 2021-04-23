package ${packageName};
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
@Controller
@RequestMapping("${requestMapping}")
public class ${className} {

<#list methods as method>

    @${method.getOrPost}("${method.mappingPath}")
    @ResponseBody
    public String ${method.methodName} (@RequestParam("param") String param) {


        return "true";
    }
</#list>
}