package com.buschmais.jqassistant.core.analysis.impl;

import javax.xml.XMLConstants;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import org.xml.sax.SAXException;

import com.buschmais.jqassistant.core.analysis.api.RuleSetReader;

/**
 * Provides utility functions for working with XML files.
 */
public class XmlHelper {

	public static Schema getSchema(String resource) {
		Schema schema;
		try {
			SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
			schema = schemaFactory.newSchema(RuleSetReader.class.getResource(resource));
		} catch (SAXException e) {
			throw new IllegalStateException("Cannot read rules schema.", e);
		}
		return schema;
	}
}
