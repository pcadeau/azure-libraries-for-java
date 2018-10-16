/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.v2.management.compute.implementation;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.microsoft.azure.v2.management.compute.SubResourceReadOnly;
import com.microsoft.rest.v2.serializer.JsonFlatten;

/**
 * Describes a Virtual Machine Scale Set Extension.
 */
@JsonFlatten
public class VirtualMachineScaleSetExtensionInner extends SubResourceReadOnly {
    /**
     * The name of the extension.
     */
    @JsonProperty(value = "name")
    private String name;

    /**
     * If a value is provided and is different from the previous value, the
     * extension handler will be forced to update even if the extension
     * configuration has not changed.
     */
    @JsonProperty(value = "properties.forceUpdateTag")
    private String forceUpdateTag;

    /**
     * The name of the extension handler publisher.
     */
    @JsonProperty(value = "properties.publisher")
    private String publisher;

    /**
     * Specifies the type of the extension; an example is
     * "CustomScriptExtension".
     */
    @JsonProperty(value = "properties.type")
    private String type;

    /**
     * Specifies the version of the script handler.
     */
    @JsonProperty(value = "properties.typeHandlerVersion")
    private String typeHandlerVersion;

    /**
     * Indicates whether the extension should use a newer minor version if one
     * is available at deployment time. Once deployed, however, the extension
     * will not upgrade minor versions unless redeployed, even with this
     * property set to true.
     */
    @JsonProperty(value = "properties.autoUpgradeMinorVersion")
    private Boolean autoUpgradeMinorVersion;

    /**
     * Json formatted public settings for the extension.
     */
    @JsonProperty(value = "properties.settings")
    private Object settings;

    /**
     * The extension can contain either protectedSettings or
     * protectedSettingsFromKeyVault or no protected settings at all.
     */
    @JsonProperty(value = "properties.protectedSettings")
    private Object protectedSettings;

    /**
     * The provisioning state, which only appears in the response.
     */
    @JsonProperty(value = "properties.provisioningState", access = JsonProperty.Access.WRITE_ONLY)
    private String provisioningState;

    /**
     * Get the name value.
     *
     * @return the name value.
     */
    public String name() {
        return this.name;
    }

    /**
     * Set the name value.
     *
     * @param name the name value to set.
     * @return the VirtualMachineScaleSetExtensionInner object itself.
     */
    public VirtualMachineScaleSetExtensionInner withName(String name) {
        this.name = name;
        return this;
    }

    /**
     * Get the forceUpdateTag value.
     *
     * @return the forceUpdateTag value.
     */
    public String forceUpdateTag() {
        return this.forceUpdateTag;
    }

    /**
     * Set the forceUpdateTag value.
     *
     * @param forceUpdateTag the forceUpdateTag value to set.
     * @return the VirtualMachineScaleSetExtensionInner object itself.
     */
    public VirtualMachineScaleSetExtensionInner withForceUpdateTag(String forceUpdateTag) {
        this.forceUpdateTag = forceUpdateTag;
        return this;
    }

    /**
     * Get the publisher value.
     *
     * @return the publisher value.
     */
    public String publisher() {
        return this.publisher;
    }

    /**
     * Set the publisher value.
     *
     * @param publisher the publisher value to set.
     * @return the VirtualMachineScaleSetExtensionInner object itself.
     */
    public VirtualMachineScaleSetExtensionInner withPublisher(String publisher) {
        this.publisher = publisher;
        return this;
    }

    /**
     * Get the type value.
     *
     * @return the type value.
     */
    public String type() {
        return this.type;
    }

    /**
     * Set the type value.
     *
     * @param type the type value to set.
     * @return the VirtualMachineScaleSetExtensionInner object itself.
     */
    public VirtualMachineScaleSetExtensionInner withType(String type) {
        this.type = type;
        return this;
    }

    /**
     * Get the typeHandlerVersion value.
     *
     * @return the typeHandlerVersion value.
     */
    public String typeHandlerVersion() {
        return this.typeHandlerVersion;
    }

    /**
     * Set the typeHandlerVersion value.
     *
     * @param typeHandlerVersion the typeHandlerVersion value to set.
     * @return the VirtualMachineScaleSetExtensionInner object itself.
     */
    public VirtualMachineScaleSetExtensionInner withTypeHandlerVersion(String typeHandlerVersion) {
        this.typeHandlerVersion = typeHandlerVersion;
        return this;
    }

    /**
     * Get the autoUpgradeMinorVersion value.
     *
     * @return the autoUpgradeMinorVersion value.
     */
    public Boolean autoUpgradeMinorVersion() {
        return this.autoUpgradeMinorVersion;
    }

    /**
     * Set the autoUpgradeMinorVersion value.
     *
     * @param autoUpgradeMinorVersion the autoUpgradeMinorVersion value to set.
     * @return the VirtualMachineScaleSetExtensionInner object itself.
     */
    public VirtualMachineScaleSetExtensionInner withAutoUpgradeMinorVersion(Boolean autoUpgradeMinorVersion) {
        this.autoUpgradeMinorVersion = autoUpgradeMinorVersion;
        return this;
    }

    /**
     * Get the settings value.
     *
     * @return the settings value.
     */
    public Object settings() {
        return this.settings;
    }

    /**
     * Set the settings value.
     *
     * @param settings the settings value to set.
     * @return the VirtualMachineScaleSetExtensionInner object itself.
     */
    public VirtualMachineScaleSetExtensionInner withSettings(Object settings) {
        this.settings = settings;
        return this;
    }

    /**
     * Get the protectedSettings value.
     *
     * @return the protectedSettings value.
     */
    public Object protectedSettings() {
        return this.protectedSettings;
    }

    /**
     * Set the protectedSettings value.
     *
     * @param protectedSettings the protectedSettings value to set.
     * @return the VirtualMachineScaleSetExtensionInner object itself.
     */
    public VirtualMachineScaleSetExtensionInner withProtectedSettings(Object protectedSettings) {
        this.protectedSettings = protectedSettings;
        return this;
    }

    /**
     * Get the provisioningState value.
     *
     * @return the provisioningState value.
     */
    public String provisioningState() {
        return this.provisioningState;
    }
}