package com.cd.test.designpattern.singleton;

public class IdeaCreate {
    private static IdeaCreate ourInstance = new IdeaCreate();

    public static IdeaCreate getInstance() {
        return ourInstance;
    }

    private IdeaCreate() {
    }
}
