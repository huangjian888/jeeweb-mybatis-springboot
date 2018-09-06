package cn.jeeweb.core.query.data;

import java.util.Iterator;
import java.util.List;

public interface Page<T> extends Iterable<T> {

	/**
	 * Returns the number of the current page. Is always non-negative and less
	 * that {@code Page#getTotalPages()}.
	 * 
	 * @return the number of the current page
	 */
	int getNumber();

	/**
	 * Returns the size of the page.
	 * 
	 * @return the size of the page
	 */
	int getSize();

	/**
	 * Returns the number of total pages.
	 * 
	 * @return the number of toral pages
	 */
	int getTotalPages();

	/**
	 * Returns the number of elements currently on this page.
	 * 
	 * @return the number of elements currently on this page
	 */
	int getNumberOfElements();

	/**
	 * Returns the total amount of elements.
	 * 
	 * @return the total amount of elements
	 */
	long getTotalElements();

	/**
	 * Returns if there is a previous page.
	 * 
	 * @return if there is a previous page
	 */
	boolean hasPreviousPage();

	/**
	 * Returns whether the current page is the first one.
	 * 
	 * @return
	 */
	boolean isFirstPage();

	/**
	 * Returns if there is a next page.
	 * 
	 * @return if there is a next page
	 */
	boolean hasNextPage();

	/**
	 * Returns whether the current page is the last one.
	 * 
	 * @return
	 */
	boolean isLastPage();

	/**
	 * Returns the {@link Pageable} to request the next {@link Page}. Can be
	 * {@literal null} in case the current {@link Page} is already the last one.
	 * Clients should check {@link #hasNextPage()} before calling this method to
	 * make sure they receive a non-{@literal null} value.
	 * 
	 * @return
	 */
	Pageable nextPageable();

	/**
	 * Returns the {@link Pageable} to request the previous page. Can be
	 * {@literal null} in case the current {@link Page} is already the first
	 * one. Clients should check {@link #hasPreviousPage()} before calling this
	 * method make sure receive a non-{@literal null} value.
	 * 
	 * @return
	 */
	Pageable previousPageable();

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Iterable#iterator()
	 */
	Iterator<T> iterator();

	/**
	 * Returns the page content as {@link List}.
	 * 
	 * @return
	 */
	List<T> getContent();

	/**
	 * Returns whether the {@link Page} has content at all.
	 * 
	 * @return
	 */
	boolean hasContent();

	/**
	 * Returns the sorting parameters for the page.
	 * 
	 * @return
	 */
	Sort getSort();
}
