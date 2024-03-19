package com.mycompany.exception;

import jakarta.xml.ws.WebFault;

@WebFault
public class AutorizacaoException extends Exception{

    public AutorizacaoException() {
        super("Usuário ou Senha Incorreta");
    }
    
    
    
}
