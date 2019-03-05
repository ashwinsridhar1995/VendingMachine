/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdlibrary.dao;

import com.sg.dvdlibrary.dto.Dvd;
import java.util.List;

/**
 *
 * @author ashwinsridhar
 */
public interface dvdlibraryDao {
    /**
	     * Adds the given Dvd to the library and associates it with the given 
	     * title.
	     * 
	     * @param dvdTitle title with which the dvd is to be associated
	     * @param dvd dvd to be added to the library
	     * @throws com.sg.classroster.dao.ClassRosterDaoException
	     */
	    Dvd addDvd(String dvdTitle, Dvd dvd)
	     throws dvdlibraryDaoException;
	    
	    /**
	     * Returns a String array containing the titles of all 
	     * dvds in the library.
	     * 
	     * @return String array containing the titles of all the dvds 
	     * in the library
	     * @throws com.sg.classroster.dao.dvdlibraryDaoException
	     */
	    List<Dvd> getAllDvds()
	     throws dvdlibraryDaoException;
	    
	    /**
	     * Returns the dvd object associated with the given title.
	     * Returns null if no such title exists
	     * 
	     * @param title title of the dvd to retrieve
	     * @return the Dvd object associated with the given title,  
	     * null if no such Dvd exists
	    **/
	    Dvd getDvd(String dvdTitle)
	     throws dvdlibraryDaoException;
	    
	    /**
	     * Removes from the roster the dvd associated with the given title. 
	     * Returns the Dvd object that is being removed or null if 
	     * there is no dvd associated with the given title
	     * 
    
	     * @param title title of the dvd to be removed
	     * @return Dvd object that was removed or null if no dvd 
	     * was associated with the given title
	    */
	    Dvd removeDvd(String dvdTitle)
	     throws dvdlibraryDaoException;
            
            Dvd findDvd(String dvdTitle)
	     throws dvdlibraryDaoException;
}
