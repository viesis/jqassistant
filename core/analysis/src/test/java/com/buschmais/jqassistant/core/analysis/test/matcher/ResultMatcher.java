package com.buschmais.jqassistant.core.analysis.test.matcher;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

import com.buschmais.jqassistant.core.analysis.api.Result;
import com.buschmais.jqassistant.core.analysis.api.rule.AbstractExecutable;

/**
 * A matcher for {@link Result}s.
 */
public class ResultMatcher<E extends AbstractExecutable> extends TypeSafeMatcher<Result<E>> {

	private Matcher<? extends AbstractExecutable> executableMatcher;

	/**
	 * Constructor.
	 * 
	 * @param executableMatcher
	 *            The expected executable type.
	 */
	protected ResultMatcher(Matcher<? extends AbstractExecutable> executableMatcher) {
		this.executableMatcher = executableMatcher;
	}

	@Override
	public boolean matchesSafely(Result item) {
		return this.executableMatcher.matches(item.getExecutable());
	}

	@Override
	public void describeTo(Description description) {
		description.appendText("Result(");
		executableMatcher.describeTo(description);
		description.appendText(")");
	}

	/**
	 * Return a {@link ResultMatcher}.
	 * 
	 * @param constraintMatcher
	 *            The matcher for the expected constraint.
	 * @return The {@link ResultMatcher}.
	 */
	public static <E extends AbstractExecutable> Matcher<? super Result<E>> result(Matcher<E> constraintMatcher) {
		return new ResultMatcher(constraintMatcher);
	}

	@Override
	protected void describeMismatchSafely(Result item, Description mismatchDescription) {
		mismatchDescription.appendText("Result(");
		executableMatcher.describeMismatch(item.getExecutable(), mismatchDescription);
		mismatchDescription.appendText(")");
	}
}
