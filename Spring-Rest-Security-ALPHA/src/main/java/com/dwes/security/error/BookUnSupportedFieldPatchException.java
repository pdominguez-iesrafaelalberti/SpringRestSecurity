package com.dwes.security.error;

import java.util.Set;

public class BookUnSupportedFieldPatchException extends RuntimeException {


	/**
	 * 
	 */
	private static final long serialVersionUID = 2195071002984793435L;

	public BookUnSupportedFieldPatchException(Set<String> keys) {
        super("Field " + keys.toString() + " update is not allow.");
    }

}
