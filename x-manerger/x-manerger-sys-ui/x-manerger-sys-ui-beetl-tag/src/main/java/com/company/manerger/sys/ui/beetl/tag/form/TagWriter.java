package com.company.manerger.sys.ui.beetl.tag.form;

import java.io.IOException;
import java.io.Writer;
import java.util.ArrayDeque;
import java.util.Deque;
import com.company.manerger.sys.ui.beetl.tag.exception.BeetlTagException;
import org.beetl.core.Context;
import org.springframework.lang.Nullable;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

public class TagWriter {

	/**
	 * The {@link SafeWriter} to write to.
	 */
	private final SafeWriter writer;

	/**
	 * Stores {@link TagStateEntry tag state}. Stack model naturally supports tag nesting.
	 */
	private final Deque<TagStateEntry> tagState = new ArrayDeque<>();


	/**
	 * Create a new instance of the {@link TagWriter} class that writes to
	 * the supplied {@link Context}.
	 * @param pageContext the JSP Context to obtain the {@link Writer} from
	 */
	public TagWriter(Context pageContext) {
		Assert.notNull(pageContext, "Context must not be null");
		this.writer = new SafeWriter(pageContext);
	}

	/**
	 * Create a new instance of the {@link TagWriter} class that writes to
	 * the supplied {@link Writer}.
	 * @param writer the {@link Writer} to write tag content to
	 */
	public TagWriter(Writer writer) {
		Assert.notNull(writer, "Writer must not be null");
		this.writer = new SafeWriter(writer);
	}


	/**
	 * Start a new tag with the supplied name. Leaves the tag open so
	 * that attributes, inner text or nested tags can be written into it.
	 * @see #endTag()
	 */
	public void startTag(String tagName) throws BeetlTagException {
		if (inTag()) {
			closeTagAndMarkAsBlock();
		}
		push(tagName);
		this.writer.append("<").append(tagName);
	}

	/**
	 * Write an HTML attribute with the specified name and value.
	 * <p>Be sure to write all attributes <strong>before</strong> writing
	 * any inner text or nested tags.
	 * @throws IllegalStateException if the opening tag is closed
	 */
	public void writeAttribute(String attributeName, String attributeValue) throws BeetlTagException {
		if (currentState().isBlockTag()) {
			throw new IllegalStateException("Cannot write attributes after opening tag is closed.");
		}
		this.writer.append(" ").append(attributeName).append("=\"")
				.append(attributeValue).append("\"");
	}

	/**
	 * Write an HTML attribute if the supplied value is not {@code null}
	 * or zero length.
	 * @see #writeAttribute(String, String)
	 */
	public void writeOptionalAttributeValue(String attributeName, @Nullable String attributeValue) throws BeetlTagException {
		if (StringUtils.hasText(attributeValue)) {
			writeAttribute(attributeName, attributeValue);
		}
	}

	/**
	 * Close the current opening tag (if necessary) and appends the
	 * supplied value as inner text.
	 * @throws IllegalStateException if no tag is open
	 */
	public void appendValue(String value) throws BeetlTagException {
		if (!inTag()) {
			throw new IllegalStateException("Cannot write tag value. No open tag available.");
		}
		closeTagAndMarkAsBlock();
		this.writer.append(value);
	}

	public void forceAppendValue(String value) throws BeetlTagException {
		this.writer.append(value);
	}

	/**
	 * Indicate that the currently open tag should be closed and marked
	 * as a block level element.
	 * <p>Useful when you plan to write additional content in the body
	 * outside the context of the current {@link TagWriter}.
	 */
	public void forceBlock() throws BeetlTagException {
		if (currentState().isBlockTag()) {
			return; // just ignore since we are already in the block
		}
		closeTagAndMarkAsBlock();
	}

	/**
	 * Close the current tag.
	 * <p>Correctly writes an empty tag if no inner text or nested tags
	 * have been written.
	 */
	public void endTag() throws BeetlTagException {
		endTag(false);
	}

	/**
	 * Close the current tag, allowing to enforce a full closing tag.
	 * <p>Correctly writes an empty tag if no inner text or nested tags
	 * have been written.
	 * @param enforceClosingTag whether a full closing tag should be
	 * rendered in any case, even in case of a non-block tag
	 */
	public void endTag(boolean enforceClosingTag) throws BeetlTagException {
		if (!inTag()) {
			throw new IllegalStateException("Cannot write end of tag. No open tag available.");
		}
		boolean renderClosingTag = true;
		if (!currentState().isBlockTag()) {
			// Opening tag still needs to be closed...
			if (enforceClosingTag) {
				this.writer.append(">");
			}
			else {
				this.writer.append("/>");
				renderClosingTag = false;
			}
		}
		if (renderClosingTag) {
			this.writer.append("</").append(currentState().getTagName()).append(">");
		}
		this.tagState.pop();
	}


	/**
	 * Adds the supplied tag name to the {@link #tagState tag state}.
	 */
	private void push(String tagName) {
		this.tagState.push(new TagStateEntry(tagName));
	}

	/**
	 * Closes the current opening tag and marks it as a block tag.
	 */
	private void closeTagAndMarkAsBlock() throws BeetlTagException {
		if (!currentState().isBlockTag()) {
			currentState().markAsBlockTag();
			this.writer.append(">");
		}
	}

	private boolean inTag() {
		return !this.tagState.isEmpty();
	}

	private TagStateEntry currentState() {
		return this.tagState.peek();
	}


	/**
	 * Holds state about a tag and its rendered behavior.
	 */
	private static class TagStateEntry {

		private final String tagName;

		private boolean blockTag;

		public TagStateEntry(String tagName) {
			this.tagName = tagName;
		}

		public String getTagName() {
			return this.tagName;
		}

		public void markAsBlockTag() {
			this.blockTag = true;
		}

		public boolean isBlockTag() {
			return this.blockTag;
		}
	}


	/**
	 * Simple {@link Writer} wrapper that wraps all
	 * {@link IOException IOExceptions} in {@link BeetlTagException BeetlTagExceptions}.
	 */
	private static final class SafeWriter {

		private Context pageContext;
		private Writer writer;

		public SafeWriter(Context pageContext) {
			this.pageContext = pageContext;
		}

		public SafeWriter(Writer writer) {
			this.writer = writer;
		}

		public SafeWriter append(String value) throws BeetlTagException {
			try {
				this.pageContext.byteWriter.writeString(value);
				return this;
			}
			catch (IOException ex) {
				throw new BeetlTagException("Unable to write to JspWriter", ex);
			}
		}
	}

}
