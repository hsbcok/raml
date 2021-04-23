package com.gaoke.gen;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Attribute {
    private String name;
    private String type;

    public Attribute(String name, String type) {
        this.name = name;
        this.type = type;
    }
}
