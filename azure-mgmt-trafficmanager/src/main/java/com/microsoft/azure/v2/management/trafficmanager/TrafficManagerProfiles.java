/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 */
package com.microsoft.azure.v2.management.trafficmanager;

import com.microsoft.azure.management.apigeneration.Fluent;

import com.microsoft.azure.v2.management.resources.fluentcore.arm.collection.SupportsBatchDeletion;
import com.microsoft.azure.v2.management.resources.fluentcore.arm.collection.SupportsDeletingByResourceGroup;
import com.microsoft.azure.v2.management.resources.fluentcore.arm.collection.SupportsGettingById;
import com.microsoft.azure.v2.management.resources.fluentcore.arm.collection.SupportsGettingByResourceGroup;
import com.microsoft.azure.v2.management.resources.fluentcore.arm.collection.SupportsListingByResourceGroup;
import com.microsoft.azure.v2.management.resources.fluentcore.arm.models.HasManager;
import com.microsoft.azure.v2.management.resources.fluentcore.collection.SupportsBatchCreation;
import com.microsoft.azure.v2.management.resources.fluentcore.collection.SupportsCreating;
import com.microsoft.azure.v2.management.resources.fluentcore.collection.SupportsDeletingById;
import com.microsoft.azure.v2.management.resources.fluentcore.collection.SupportsListing;
import com.microsoft.azure.v2.management.resources.fluentcore.model.HasInner;
import com.microsoft.azure.v2.management.trafficmanager.implementation.ProfilesInner;
import com.microsoft.azure.v2.management.trafficmanager.implementation.TrafficManager;
import com.microsoft.rest.v2.ServiceCallback;
import com.microsoft.rest.v2.ServiceFuture;
import io.reactivex.Maybe;
import rx.Observable;

/**
 * Entry point to traffic manager profile management API in Azure.
 */
@Fluent
public interface TrafficManagerProfiles extends
        SupportsCreating<TrafficManagerProfile.DefinitionStages.Blank>,
        SupportsListing<TrafficManagerProfile>,
        SupportsListingByResourceGroup<TrafficManagerProfile>,
        SupportsGettingByResourceGroup<TrafficManagerProfile>,
        SupportsGettingById<TrafficManagerProfile>,
        SupportsDeletingById,
        SupportsDeletingByResourceGroup,
        SupportsBatchCreation<TrafficManagerProfile>,
        SupportsBatchDeletion,
        HasManager<TrafficManager>,
        HasInner<ProfilesInner> {

    /**
     * Checks that the DNS name is valid for traffic manager profile and is not in use.
     *
     * @param dnsNameLabel the DNS name to check
     * @return whether the DNS is available to be used for a traffic manager profile and other info if not
     */
    CheckProfileDnsNameAvailabilityResult checkDnsNameAvailability(String dnsNameLabel);

    /**
     * Asynchronously checks that the DNS name is valid for traffic manager profile and is not in use.
     *
     * @param dnsNameLabel the DNS name to check
     * @return a representation of the deferred computation of this call, returning whether the DNS is available to be used for a traffic manager profile and other info if not
     */
    Maybe<CheckProfileDnsNameAvailabilityResult> checkDnsNameAvailabilityAsync(String dnsNameLabel);

    /**
     * Asynchronously checks that the DNS name is valid for traffic manager profile and is not in use.
     *
     * @param dnsNameLabel the DNS name to check
     * @param callback the callback to call on success or failure, on success with the result whether the DNS is available
     *                 to be used for a traffic manager profile and other info if not
     *
     * @return a handle to cancel the request
     */
    ServiceFuture<CheckProfileDnsNameAvailabilityResult> checkDnsNameAvailabilityAsync(String dnsNameLabel, ServiceCallback<CheckProfileDnsNameAvailabilityResult> callback);

    /**
     * @return the default geographic hierarchy used by the Geographic traffic routing method.
     */
    GeographicLocation getGeographicHierarchyRoot();
}