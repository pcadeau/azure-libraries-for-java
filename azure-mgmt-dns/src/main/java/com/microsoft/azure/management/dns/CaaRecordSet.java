/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 */
package com.microsoft.azure.management.dns;

import com.microsoft.azure.management.apigeneration.Fluent;

import java.util.List;

/**
 * An immutable client-side representation of an CAA (service) record set in Azure DNS Zone.
 */
@Fluent
public interface CaaRecordSet extends DnsRecordSet {
    /**
     * @return the CAA records in this record set
     */
    List<CaaRecord> records();
}
