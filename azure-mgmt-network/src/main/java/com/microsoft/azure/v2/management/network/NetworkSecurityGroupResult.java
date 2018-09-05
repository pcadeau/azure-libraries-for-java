/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.v2.management.network;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

/**
 * Network configuration diagnostic result corresponded provided traffic query.
 */
public final class NetworkSecurityGroupResult {
    /**
     * The network traffic is allowed or denied. Possible values are 'Allow'
     * and 'Deny'. Possible values include: 'Allow', 'Deny'.
     */
    @JsonProperty(value = "securityRuleAccessResult")
    private SecurityRuleAccess securityRuleAccessResult;

    /**
     * List of results network security groups diagnostic.
     */
    @JsonProperty(value = "evaluatedNetworkSecurityGroups", access = JsonProperty.Access.WRITE_ONLY)
    private List<EvaluatedNetworkSecurityGroup> evaluatedNetworkSecurityGroups;

    /**
     * Get the securityRuleAccessResult value.
     *
     * @return the securityRuleAccessResult value.
     */
    public SecurityRuleAccess securityRuleAccessResult() {
        return this.securityRuleAccessResult;
    }

    /**
     * Set the securityRuleAccessResult value.
     *
     * @param securityRuleAccessResult the securityRuleAccessResult value to
     * set.
     * @return the NetworkSecurityGroupResult object itself.
     */
    public NetworkSecurityGroupResult withSecurityRuleAccessResult(SecurityRuleAccess securityRuleAccessResult) {
        this.securityRuleAccessResult = securityRuleAccessResult;
        return this;
    }

    /**
     * Get the evaluatedNetworkSecurityGroups value.
     *
     * @return the evaluatedNetworkSecurityGroups value.
     */
    public List<EvaluatedNetworkSecurityGroup> evaluatedNetworkSecurityGroups() {
        return this.evaluatedNetworkSecurityGroups;
    }
}