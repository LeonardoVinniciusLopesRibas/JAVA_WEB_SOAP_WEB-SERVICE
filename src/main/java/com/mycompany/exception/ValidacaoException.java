package com.mycompany.exception;

import jakarta.xml.ws.WebFault;

@WebFault
public class ValidacaoException extends Exception{

    public ValidacaoException(String message) {
        super(message);
    }
    
    
    
}
