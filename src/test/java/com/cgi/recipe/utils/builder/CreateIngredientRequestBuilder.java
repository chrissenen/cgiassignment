package com.cgi.recipe.utils.builder;

import com.cgi.recipe.api.request.CreateIngredientRequest;

public class CreateIngredientRequestBuilder {
    private String name;

    public CreateIngredientRequest build() {
        return new CreateIngredientRequest(name);
    }

    public CreateIngredientRequestBuilder withName(String firstName) {
        this.name = firstName;
        return this;
    }


}
