package Builder_Pattern;

import Builder_Pattern.Models.Builder;

public class Director {
    Builder builder;

    public void construct(Builder builder){
        this.builder = builder;
        builder.startUpOperations();
        builder.buildBody();
        builder.addHeadLights();
        builder.insertWheels();
        builder.endOperations();
    }
}
