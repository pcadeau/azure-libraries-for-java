/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.containerinstance;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.microsoft.rest.serializer.JsonFlatten;

/**
 * A container instance.
 */
@JsonFlatten
public class Container {
    /**
     * The user-provided name of the container instance.
     */
    @JsonProperty(value = "name", required = true)
    private String name;

    /**
     * The name of the image used to create the container instance.
     */
    @JsonProperty(value = "properties.image", required = true)
    private String image;

    /**
     * The commands to execute within the container instance in exec form.
     */
    @JsonProperty(value = "properties.command")
    private List<String> command;

    /**
     * The exposed ports on the container instance.
     */
    @JsonProperty(value = "properties.ports")
    private List<ContainerPort> ports;

    /**
     * The environment variables to set in the container instance.
     */
    @JsonProperty(value = "properties.environmentVariables")
    private List<EnvironmentVariable> environmentVariables;

    /**
     * The instance view of the container instance. Only valid in response.
     */
    @JsonProperty(value = "properties.instanceView", access = JsonProperty.Access.WRITE_ONLY)
    private ContainerPropertiesInstanceView instanceView;

    /**
     * The resource requirements of the container instance.
     */
    @JsonProperty(value = "properties.resources", required = true)
    private ResourceRequirements resources;

    /**
     * The volume mounts available to the container instance.
     */
    @JsonProperty(value = "properties.volumeMounts")
    private List<VolumeMount> volumeMounts;

    /**
     * The liveness probe.
     */
    @JsonProperty(value = "properties.livenessProbe")
    private ContainerProbe livenessProbe;

    /**
     * The readiness probe.
     */
    @JsonProperty(value = "properties.readinessProbe")
    private ContainerProbe readinessProbe;

    /**
     * Get the name value.
     *
     * @return the name value
     */
    public String name() {
        return this.name;
    }

    /**
     * Set the name value.
     *
     * @param name the name value to set
     * @return the Container object itself.
     */
    public Container withName(String name) {
        this.name = name;
        return this;
    }

    /**
     * Get the image value.
     *
     * @return the image value
     */
    public String image() {
        return this.image;
    }

    /**
     * Set the image value.
     *
     * @param image the image value to set
     * @return the Container object itself.
     */
    public Container withImage(String image) {
        this.image = image;
        return this;
    }

    /**
     * Get the command value.
     *
     * @return the command value
     */
    public List<String> command() {
        return this.command;
    }

    /**
     * Set the command value.
     *
     * @param command the command value to set
     * @return the Container object itself.
     */
    public Container withCommand(List<String> command) {
        this.command = command;
        return this;
    }

    /**
     * Get the ports value.
     *
     * @return the ports value
     */
    public List<ContainerPort> ports() {
        return this.ports;
    }

    /**
     * Set the ports value.
     *
     * @param ports the ports value to set
     * @return the Container object itself.
     */
    public Container withPorts(List<ContainerPort> ports) {
        this.ports = ports;
        return this;
    }

    /**
     * Get the environmentVariables value.
     *
     * @return the environmentVariables value
     */
    public List<EnvironmentVariable> environmentVariables() {
        return this.environmentVariables;
    }

    /**
     * Set the environmentVariables value.
     *
     * @param environmentVariables the environmentVariables value to set
     * @return the Container object itself.
     */
    public Container withEnvironmentVariables(List<EnvironmentVariable> environmentVariables) {
        this.environmentVariables = environmentVariables;
        return this;
    }

    /**
     * Get the instanceView value.
     *
     * @return the instanceView value
     */
    public ContainerPropertiesInstanceView instanceView() {
        return this.instanceView;
    }

    /**
     * Get the resources value.
     *
     * @return the resources value
     */
    public ResourceRequirements resources() {
        return this.resources;
    }

    /**
     * Set the resources value.
     *
     * @param resources the resources value to set
     * @return the Container object itself.
     */
    public Container withResources(ResourceRequirements resources) {
        this.resources = resources;
        return this;
    }

    /**
     * Get the volumeMounts value.
     *
     * @return the volumeMounts value
     */
    public List<VolumeMount> volumeMounts() {
        return this.volumeMounts;
    }

    /**
     * Set the volumeMounts value.
     *
     * @param volumeMounts the volumeMounts value to set
     * @return the Container object itself.
     */
    public Container withVolumeMounts(List<VolumeMount> volumeMounts) {
        this.volumeMounts = volumeMounts;
        return this;
    }

    /**
     * Get the livenessProbe value.
     *
     * @return the livenessProbe value
     */
    public ContainerProbe livenessProbe() {
        return this.livenessProbe;
    }

    /**
     * Set the livenessProbe value.
     *
     * @param livenessProbe the livenessProbe value to set
     * @return the Container object itself.
     */
    public Container withLivenessProbe(ContainerProbe livenessProbe) {
        this.livenessProbe = livenessProbe;
        return this;
    }

    /**
     * Get the readinessProbe value.
     *
     * @return the readinessProbe value
     */
    public ContainerProbe readinessProbe() {
        return this.readinessProbe;
    }

    /**
     * Set the readinessProbe value.
     *
     * @param readinessProbe the readinessProbe value to set
     * @return the Container object itself.
     */
    public Container withReadinessProbe(ContainerProbe readinessProbe) {
        this.readinessProbe = readinessProbe;
        return this;
    }

}
