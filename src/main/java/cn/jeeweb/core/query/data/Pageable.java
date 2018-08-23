package cn.jeeweb.core.query.data;

public interface Pageable {

	int getPageNumber();

	/**
	 * Returns the number of items to be returned.
	 * 
	 * @return the number of items of that page
	 */
	int getPageSize();

	/**
	 * Returns the offset to be taken according to the underlying page and page
	 * size.
	 * 
	 * @return the offset to be taken
	 */
	int getOffset();

	/**
	 * Returns the sorting parameters.
	 * 
	 * @return
	 */
	Sort getSort();

	/**
	 * Returns the {@link Pageable} requesting the next {@link Page}.
	 * 
	 * @return
	 */
	Pageable next();

	/**
	 * Returns the previous {@link Pageable} or the first {@link Pageable} if
	 * the current one already is the first one.
	 * 
	 * @return
	 */
	Pageable previousOrFirst();

	/**
	 * Returns the {@link Pageable} requesting the first page.
	 * 
	 * @return
	 */
	Pageable first();

	/**
	 * Returns whether there's a previous {@link Pageable} we can access from
	 * the current one. Will return {@literal false} in case the current
	 * {@link Pageable} already refers to the first page.
	 * 
	 * @return
	 */
	boolean hasPrevious();
}
