package com.jqassistant.scanner.test;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;

import com.buschmais.jqassistant.scanner.DependencyScanner;
import com.buschmais.jqassistant.store.api.Store;
import com.buschmais.jqassistant.store.impl.EmbeddedGraphStore;

public abstract class AbstractScannerTest {

	private Store store;
	private DependencyScanner scanner;

	@Before
	public void startStore() {
		store = new EmbeddedGraphStore();
		scanner = new DependencyScanner(store);
		store.start();
	}

	@After
	public void stopStore() {
		store.stop();
	}

	protected void scanClass(Class<?> classType) throws IOException {
		store.beginTransaction();
		String resourceName = "/" + classType.getName().replace('.', '/')
				+ ".class";
		scanner.scanInputStream(classType.getResourceAsStream(resourceName));
		store.endTransaction();
	}

}