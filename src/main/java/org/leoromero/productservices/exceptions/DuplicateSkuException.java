package org.leoromero.productservices.exceptions;

public class DuplicateSkuException extends RuntimeException {

    public DuplicateSkuException(String skul){
        super("El skul ya existe"+skul);
    }


}
