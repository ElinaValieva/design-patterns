package com.patterns.caching.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class User extends BaseModel {

    private String name;
    private String description;
}
