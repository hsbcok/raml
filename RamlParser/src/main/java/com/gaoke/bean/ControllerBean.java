package com.gaoke.bean;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ControllerBean {
    private String className;
    private String rootPath;
    private String packageName;
    List<ControllerMethod> methods;



}

