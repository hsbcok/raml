package ${packageName};

import java.util.List;
import lombok.Getter;
import lombok.Setter;
/**
 *  @author ${author}
 */
@Getter
@Setter
public class ${className} {
<#list attrs as attr>
    private ${attr.type} ${attr.name};
</#list>

}
