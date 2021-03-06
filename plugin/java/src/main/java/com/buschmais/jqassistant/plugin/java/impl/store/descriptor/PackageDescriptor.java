package com.buschmais.jqassistant.plugin.java.impl.store.descriptor;

import com.buschmais.cdo.neo4j.api.annotation.Label;
import com.buschmais.jqassistant.core.store.api.descriptor.ContainingDescriptor;
import com.buschmais.jqassistant.core.store.api.descriptor.FullQualifiedNameDescriptor;

/**
 * Describes a Java package.
 */
@Label(value = "PACKAGE", usingIndexedPropertyOf = FullQualifiedNameDescriptor.class)
public interface PackageDescriptor extends PackageMemberDescriptor, ContainingDescriptor {
}
