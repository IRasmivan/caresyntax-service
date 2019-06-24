package com.rasmivan.caresyntax.helper;

import org.springframework.stereotype.Component;

import com.rasmivan.caresyntax.constants.MessageConstantsUtils;
import com.rasmivan.caresyntax.exception.InvalidPageNumberOrPageSize;

/**
 * The Class CommonValidationUtils.
 */
@Component
public class CommonValidationUtils {
	
	/**
	 * Validate page size and page number.
	 *
	 * @param pageNumber the page number
	 * @param pageSize the page size
	 */
	public void validatePageSizeAndPageNumber(int pageNumber, int pageSize) {
		if(!(pageSize > 0 && pageSize <= 25)) {
			throw new InvalidPageNumberOrPageSize(MessageConstantsUtils.INVALID_PAGE_SIZE);
		}
		
		if(pageNumber < 0) {
			throw new InvalidPageNumberOrPageSize(MessageConstantsUtils.INVALID_PAGE_NUMBER);
		}
	}

}
