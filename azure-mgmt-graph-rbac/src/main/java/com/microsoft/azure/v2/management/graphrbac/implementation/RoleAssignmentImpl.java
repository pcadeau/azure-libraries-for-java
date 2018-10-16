/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 */

package com.microsoft.azure.v2.management.graphrbac.implementation;

import com.microsoft.azure.management.apigeneration.LangDefinition;
import com.microsoft.azure.v2.CloudException;
import com.microsoft.azure.v2.management.graphrbac.ActiveDirectoryGroup;
import com.microsoft.azure.v2.management.graphrbac.ActiveDirectoryUser;
import com.microsoft.azure.v2.management.graphrbac.BuiltInRole;
import com.microsoft.azure.v2.management.graphrbac.RoleAssignment;
import com.microsoft.azure.v2.management.graphrbac.RoleAssignmentCreateParameters;
import com.microsoft.azure.v2.management.graphrbac.ServicePrincipal;
import com.microsoft.azure.v2.management.resources.ResourceGroup;
import com.microsoft.azure.v2.management.resources.fluentcore.model.implementation.CreatableImpl;
import io.reactivex.Maybe;
import com.microsoft.azure.v2.management.resources.fluentcore.arm.models.Resource;
import io.reactivex.Observable;
import io.reactivex.exceptions.Exceptions;

import java.util.concurrent.TimeUnit;

/**
 * Implementation for ServicePrincipal and its parent interfaces.
 */
@LangDefinition(ContainerName = "/Microsoft.Azure.Management.Graph.RBAC.Fluent")
class RoleAssignmentImpl
        extends CreatableImpl<RoleAssignment, RoleAssignmentInner, RoleAssignmentImpl>
        implements
            RoleAssignment,
            RoleAssignment.Definition {
    private GraphRbacManager manager;
    // Active Directory identify info
    private String objectId;
    private String userName;
    private String servicePrincipalName;
    // role info
    private String roleDefinitionId;
    private String roleName;

    RoleAssignmentImpl(RoleAssignmentInner innerObject, GraphRbacManager manager) {
        super(innerObject.name(), innerObject);
        this.manager = manager;
    }

    @Override
    public String id() {
        return inner().id();
    }

    @Override
    public boolean isInCreateMode() {
        return inner().id() == null;
    }

    @Override
    public Observable<RoleAssignment> createResourceAsync() {
        Observable<String> objectIdObservable;
        if (objectId != null) {
            objectIdObservable = Observable.just(objectId);
        } else if (userName != null) {
            objectIdObservable = manager.users().getByNameAsync(userName)
                    .map(user -> user.id());
        } else if (servicePrincipalName != null) {
            objectIdObservable = manager.servicePrincipals().getByNameAsync(servicePrincipalName)
                    .map(sp -> sp.id());
        } else {
            throw new IllegalArgumentException("Please pass a non-null value for either object Id, user, group, or service principal");
        }

        Observable<String> roleDefinitionIdObservable;
        if (roleDefinitionId != null) {
            roleDefinitionIdObservable = Observable.just(roleDefinitionId);
        } else if (roleName != null) {
            roleDefinitionIdObservable = manager().roleDefinitions().getByScopeAndRoleNameAsync(scope(), roleName)
                    .map(roleDefinition -> roleDefinition.id());
        } else {
            throw new IllegalArgumentException("Please pass a non-null value for either role name or role definition ID");
        }

        return
        Observable.zip(objectIdObservable, roleDefinitionIdObservable, (objectId, roleDefinitionId) -> new RoleAssignmentCreateParameters().withPrincipalId(objectId).withRoleDefinitionId(roleDefinitionId))
                .flatMap(createParameter ->
                        manager().roleInner().roleAssignments().createAsync(scope(), name(), createParameter)
                                .toObservable())
                .retryWhen(throwableObservable -> throwableObservable.zipWith(Observable.range(1, 30), (throwable, integer) -> {
                    if (throwable instanceof CloudException
                            && ((CloudException) throwable).body().code().equalsIgnoreCase("PrincipalNotFound")) {
                        return integer;
                    } else {
                        throw Exceptions.propagate(throwable);
                    }
                }).flatMap(i -> Observable.timer(i, TimeUnit.SECONDS)))
                .map(innerToFluentMap(this));
    }

    @Override
    protected Maybe<RoleAssignmentInner> getInnerAsync() {
        return manager.roleInner().roleAssignments().getAsync(scope(), name());
    }

    @Override
    public GraphRbacManager manager() {
        return manager;
    }

    @Override
    public String scope() {
        return inner().scope();
    }

    @Override
    public String roleDefinitionId() {
        return inner().roleDefinitionId();
    }

    @Override
    public String principalId() {
        return inner().principalId();
    }

    @Override
    public RoleAssignmentImpl forObjectId(String objectId) {
        this.objectId = objectId;
        return this;
    }

    @Override
    public RoleAssignmentImpl forUser(ActiveDirectoryUser user) {
        this.objectId = user.id();
        return this;
    }

    @Override
    public RoleAssignmentImpl forUser(String name) {
        this.userName = name;
        return this;
    }

    @Override
    public RoleAssignmentImpl forGroup(ActiveDirectoryGroup activeDirectoryGroup) {
        this.objectId = activeDirectoryGroup.id();
        return this;
    }

    @Override
    public RoleAssignmentImpl forServicePrincipal(ServicePrincipal servicePrincipal) {
        this.objectId = servicePrincipal.id();
        return this;
    }

    @Override
    public RoleAssignmentImpl forServicePrincipal(String servicePrincipalName) {
        this.servicePrincipalName = servicePrincipalName;
        return this;
    }

    @Override
    public RoleAssignmentImpl withBuiltInRole(BuiltInRole role) {
        this.roleName = role.toString();
        return this;
    }

    @Override
    public RoleAssignmentImpl withRoleDefinition(String roleDefinitionId) {
        this.roleDefinitionId = roleDefinitionId;
        return this;
    }

    @Override
    public RoleAssignmentImpl withScope(String scope) {
        this.inner().withScope(scope);
        return this;
    }

    @Override
    public RoleAssignmentImpl withResourceGroupScope(ResourceGroup resourceGroup) {
        return withScope(resourceGroup.id());
    }

    @Override
    public RoleAssignmentImpl withResourceScope(Resource resource) {
        return withScope(resource.id());
    }

    @Override
    public RoleAssignmentImpl withSubscriptionScope(String subscriptionId) {
        return withScope("subscriptions/" + subscriptionId);
    }
}