package com.cgi.recipe.search.filter;


import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;

import com.cgi.recipe.models.Recipe;
import com.cgi.recipe.search.SearchOperation;

import static com.cgi.recipe.config.DatabaseAttributes.INGREDIENT_KEY;

import javax.persistence.criteria.*;

public class SearchFilterContains implements SearchFilter {

    @Override
    public boolean couldBeApplied(SearchOperation opt) {
        return opt == SearchOperation.CONTAINS;
    }

    @Override
    public Predicate apply(CriteriaBuilder cb, String filterKey, String filterValue, Root<Recipe> root, Join<Object, Object> subRoot) {
        if (filterKey.equals(INGREDIENT_KEY))
            return cb.like(cb.lower(subRoot.get(filterKey).as(String.class)), "%" + filterValue + "%");

        return cb.like(cb.lower(root.get(filterKey).as(String.class)), "%" + filterValue + "%");
    }
}
