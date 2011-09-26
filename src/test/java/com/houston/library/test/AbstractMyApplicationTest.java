package com.houston.library.test;

import org.mockito.MockitoAnnotations;

import com.formos.tapestry.testify.core.TapestryTester;
import com.formos.tapestry.testify.testng.TapestryTest;
import com.houston.library.services.AppModule;

public abstract class AbstractMyApplicationTest extends TapestryTest {
	private static final TapestryTester SHARED_TESTER = new TapestryTester("com.houston.library", AppModule.class);

	public AbstractMyApplicationTest() {
		super(SHARED_TESTER);
	}

	@Override
	protected void setUpForAllTestMethods() throws Exception {
		MockitoAnnotations.initMocks(this);
	}
}