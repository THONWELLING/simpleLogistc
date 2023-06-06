package com.thonwelling.simpleLogistic.exceptionhandler;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ObjectField {

    private String name;
    private String message;

    public ObjectField() {}
}
