package com.cd.test.designpattern.singleton;

/**
 * 饿汗
 */
public class IdeaCreate {
    private static IdeaCreate ourInstance = new IdeaCreate();

    public static IdeaCreate getInstance() {
        return ourInstance;
    }

    private IdeaCreate() {
    }

    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        IdeaCreate instance = IdeaCreate.getInstance();
        IdeaCreate instance1 = IdeaCreate.getInstance();
        System.out.println(instance == instance1);

        IdeaCreate ideaCreate = IdeaCreate.class.newInstance();
        System.out.println(instance == ideaCreate);

    }
}
