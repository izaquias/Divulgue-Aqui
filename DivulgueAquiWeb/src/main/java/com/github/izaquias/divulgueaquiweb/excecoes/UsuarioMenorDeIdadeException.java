/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.izaquias.divulgueaquiweb.excecoes;

//import java.util.logging.Logger;

/**
 *
 * @author Izaquias
 */

public class UsuarioMenorDeIdadeException extends IllegalStateException{
    //private static final Logger LOG = Logger.getLogger(UsuarioMenorDeIdadeException.class.getName());
    
    private static final long serialUID = 1L;

    public UsuarioMenorDeIdadeException() {
       super("Informe uma idade válida para o Usuário!");
    }
    
}
