package com.buschmais.jqassistant.plugin.java.impl.store.visitor;

import org.objectweb.asm.signature.SignatureVisitor;

import com.buschmais.jqassistant.plugin.java.impl.store.descriptor.DependentDescriptor;
import com.buschmais.jqassistant.plugin.java.impl.store.descriptor.TypeDescriptor;

/**
 * Type signature visitor which adds a dependency to a resolved types.
 */
public class DependentTypeSignatureVisitor extends AbstractTypeSignatureVisitor<DependentDescriptor> {

	/**
	 * Constructor
	 * 
	 * @param dependentDescriptor
	 *            The descriptor which depends on the resolvedd types.
	 * @param visitorHelper
	 *            The {@link VisitorHelper}
	 */
	DependentTypeSignatureVisitor(DependentDescriptor dependentDescriptor, VisitorHelper visitorHelper) {
		super(dependentDescriptor, visitorHelper);
	}

	@Override
	public SignatureVisitor visitSuperclass() {
		return new DependentTypeSignatureVisitor(getUsingDescriptor(), getVisitorHelper());
	}

	@Override
	public SignatureVisitor visitInterface() {
		return new DependentTypeSignatureVisitor(getUsingDescriptor(), getVisitorHelper());
	}

	@Override
	public SignatureVisitor visitArrayType() {
		return new DependentTypeSignatureVisitor(getUsingDescriptor(), getVisitorHelper());
	}

	@Override
	public SignatureVisitor visitTypeArgument(char wildcard) {
		return new DependentTypeSignatureVisitor(getUsingDescriptor(), getVisitorHelper());
	}

	@Override
	public void visitEnd(TypeDescriptor resolvedTypeDescriptor) {
		getUsingDescriptor().getDependencies().add(resolvedTypeDescriptor);
	}
}
