/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.containerregistry;

import java.util.Collection;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.microsoft.rest.ExpandableStringEnum;

/**
 * Defines values for BuildType.
 */
public final class BuildType extends ExpandableStringEnum<BuildType> {
    /** Static value AutoBuild for BuildType. */
    public static final BuildType AUTO_BUILD = fromString("AutoBuild");

    /** Static value QuickBuild for BuildType. */
    public static final BuildType QUICK_BUILD = fromString("QuickBuild");

    /**
     * Creates or finds a BuildType from its string representation.
     * @param name a name to look for
     * @return the corresponding BuildType
     */
    @JsonCreator
    public static BuildType fromString(String name) {
        return fromString(name, BuildType.class);
    }

    /**
     * @return known BuildType values
     */
    public static Collection<BuildType> values() {
        return values(BuildType.class);
    }
}
