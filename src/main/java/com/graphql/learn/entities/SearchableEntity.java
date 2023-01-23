package com.graphql.learn.entities;

import org.springframework.util.CollectionUtils;


import java.io.Serializable;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Interface for Search utility
 * @author Surabhi Bhawsar
 * @since 2020-01-06
 *
 */
public interface SearchableEntity extends Serializable {

    default List<String> getSearchFields() { return Collections.emptyList(); }
    String getNodeName();
    String getMultiDataNodeName();
    default void clearDefaultValues() {};

    /**
     * Default implementation returns ascending sort on {@code id} field.
     * Override this in case a different field should be used for sorting (or {@code id} field is not present).
     * @return default sort field.
     */
    default String defaultSort() {
        return "+id";
    }
    
    /**
     * Default limit for every list API is 50, override this in entity in case a other value need to be used.
     * @return
     */
    default String defaultLimit() {
        return String.valueOf(0);
    }
    
    /**
     * Default limit for every list API is 50, override this in entity in case a other value need to be used.
     * @return
     */
    default String defaultOffset() {
        return String.valueOf(50);
    }

    /**
     * Additional Search Fields.
     * 
     * @return
     */
    default List<String> getAdditionalSearchFields() {
        return Collections.emptyList();
    }
}
