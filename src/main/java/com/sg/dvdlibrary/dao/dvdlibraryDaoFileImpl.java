/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdlibrary.dao;

import com.sg.dvdlibrary.dto.Dvd;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ashwinsridhar
 */
public class dvdlibraryDaoFileImpl implements dvdlibraryDao{
    private Map<String, Dvd> dvds = new HashMap<>();
            public static final String ROSTER_FILE = "output.txt";
            public static final String DELIMITER = "::";
            
        @Override
	public Dvd addDvd(String dvdTitle, Dvd dvd) 
	 throws dvdlibraryDaoException {
	    Dvd newDvd = dvds.put(dvdTitle, dvd);
	    writeOutput();
	    return newDvd;
	}
	   
        @Override
	public List<Dvd> getAllDvds() 
	 throws dvdlibraryDaoException {
	    loadOutput();
	    return new ArrayList<Dvd>(dvds.values());
	}
	
        @Override
	public Dvd getDvd(String dvdTitle) 
	 throws dvdlibraryDaoException {
	    loadOutput();
	    return dvds.get(dvdTitle);
	}
	   
        @Override
	public Dvd removeDvd(String dvdTitle) 
	 throws dvdlibraryDaoException {
	    Dvd removedDvd = dvds.remove(dvdTitle);
	    writeOutput();
	    return removedDvd;
	}
        
        public Dvd findDvd(String dvdTitle) 
         throws dvdlibraryDaoException {
            return dvds.get(dvdTitle);
          }
            
        
        private void loadOutput() throws dvdlibraryDaoException {
	    Scanner scanner;
	    
	    try {
	        // Create Scanner for reading the file
	        scanner = new Scanner(
	                new BufferedReader(
	                        new FileReader(ROSTER_FILE)));
	    } catch (FileNotFoundException e) {
	        throw new dvdlibraryDaoException(
	                "-_- Could not load roster data into memory.", e);
	    }
	    // currentLine holds the most recent line read from the file
	    String currentLine;
	    // currentTokens holds each of the parts of the currentLine after it has
	    // been split on our DELIMITER
	    // NOTE FOR APPRENTICES: In our case we use :: as our delimiter.  If
	    // currentLine looks like this:
	    // 1234::Joe::Smith::Java-September2013
	    // then currentTokens will be a string array that looks like this:
	    //
	    // ___________________________________
	    // |    |   |     |                  |
	    // |1234|Joe|Smith|Java-September2013|
	    // |    |   |     |                  |
	    // -----------------------------------
	    //  [0]  [1]  [2]         [3]
	    String[] currentTokens;
	    // Go through ROSTER_FILE line by line, decoding each line into a 
	    // Student object.
	    // Process while we have more lines in the file
	    while (scanner.hasNextLine()) {
	        // get the next line in the file
	        currentLine = scanner.nextLine();
	        // break up the line into tokens
	        currentTokens = currentLine.split(DELIMITER);
	        // Create a new Dvd object and put it into the map of dvds
	        // NOTE FOR APPRENTICES: We are going to use the title
	        // which is currentTokens[0] as the map key for our student object.
	        // We also have to pass the title into the Dvd constructor
	        Dvd currentDvd = new Dvd(currentTokens[0]);
	        // Set the remaining vlaues on currentStudent manually
	        //currentDvd.setdvdTitle(currentTokens[1]);
	        currentDvd.setreleaseDate(currentTokens[1]);
                currentDvd.setRating(currentTokens[2]);
	        currentDvd.setdirectorsName(currentTokens[3]);
                currentDvd.setStudio(currentTokens[4]);
                currentDvd.setuserRating(currentTokens[5]);
                
	        
	        // Put currentDvd into the map using dvdTitle as the key
	        dvds.put(currentDvd.getdvdTitle(), currentDvd);
	    }
	    // close scanner
	    scanner.close();
	}
        /**
	 * Writes all dvds in the library out to a ROSTER_FILE.  See loadRoster
	 * for file format.
	 * 
	 * @throws dvdlibraryDaoException if an error occurs writing to the file
	 */
	private void writeOutput() throws dvdlibraryDaoException {
	    // NOTE FOR APPRENTICES: We are not handling the IOException - but
	    // we are translating it to an application specific exception and 
	    // then simple throwing it (i.e. 'reporting' it) to the code that
	    // called us.  It is the responsibility of the calling code to 
	    // handle any errors that occur.
	    PrintWriter out;
	    
	    try {
	        out = new PrintWriter(new FileWriter(ROSTER_FILE));
	    } catch (IOException e) {
	        throw new dvdlibraryDaoException(
	                "Could not save Dvd data.", e);
	    }
	    
	    // Write out the Dvd objects to the output file.
	    // NOTE TO THE APPRENTICES: We could just grab the dvd map,
	    // get the Collection of Dvds and iterate over them but we've
	    // already created a method that gets a List of Dvds so
	    // we'll reuse it.
	    List<Dvd> dvdList = this.getAllDvds();
	    for (Dvd currentdvd : dvdList) {
	        // write the Dvd object to the file
	        out.println(currentdvd.getdvdTitle() + DELIMITER
	                + currentdvd.getreleaseDate() + DELIMITER 
	                + currentdvd.getRating() + DELIMITER
	                + currentdvd.getdirectorsName() + DELIMITER
                        + currentdvd.getStudio() + DELIMITER
                        + currentdvd.getuserRating());
	        // force PrintWriter to write line to the file
	        out.flush();
	    }
	    // Clean up
	    out.close();
	}
     
}  

