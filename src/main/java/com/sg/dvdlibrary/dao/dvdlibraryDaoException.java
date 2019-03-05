/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdlibrary.dao;

/**
 *
 * @author ashwinsridhar
 */
public class dvdlibraryDaoException extends Exception{
    public dvdlibraryDaoException(String message) {
	        super(message);
	    }
	    
	    public dvdlibraryDaoException(String message, Throwable cause) {
	        super(message, cause);
	    }
}
