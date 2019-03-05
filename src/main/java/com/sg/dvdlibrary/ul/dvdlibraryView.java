/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdlibrary.ul;

import com.sg.dvdlibrary.dto.Dvd;
import java.util.List;

/**
 *
 * @author ashwinsridhar
 */
public class dvdlibraryView {
    private UserIO io;
    public dvdlibraryView(UserIO io){
        this.io = io;
    }

	public int printMenuAndGetSelection() {
	        io.print("Main Menu");
	        io.print("1. List Dvds");
	        io.print("2. Add a Dvd");
	        io.print("3. View a Dvd");
	        io.print("4. Remove a Dvd");
                io.print("5. Edit a Dvd");
                io.print("6. Search for a Dvd");
	        io.print("7. Exit");

	        return io.readInt("Please select from the above choices.", 1, 7);
	}
        public Dvd getNewDvdInfo() {
	    String Title = io.readString("Please enter Title");
	    String releaseDate = io.readString("Please enter Release Date");
	    String Rating = io.readString("Please enter MPAA Rating");
	    String directorsName = io.readString("Please enter the Director's name");
            String Studio = io.readString("Please enter Studio");
            String userRating = io.readString("Please enter User rating");
	    Dvd currentDvd = new Dvd(Title);
	    currentDvd.setreleaseDate(releaseDate);
	    currentDvd.setRating(Rating);
	    currentDvd.setdirectorsName(directorsName);
            currentDvd.setStudio(Studio);
            currentDvd.setuserRating(userRating);
	    return currentDvd;
	}
        public void displayCreateStudentBanner() {
	    io.print("=== Create Dvd ===");
	}
        public void displayCreateSuccessBanner() {
	    io.readString(
	            "Dvd successfully created.  Please hit enter to continue");
	}
        public void displayDvdList(List<Dvd> dvdList) {
	    for (Dvd currentDvd : dvdList) {
	        io.print(currentDvd.getdvdTitle() + ": "
	                + currentDvd.getreleaseDate() + ": "
	                + currentDvd.getRating() + ": " + 
                        currentDvd.getdirectorsName() + ": "
                        + currentDvd.getStudio() + ": " +
                        currentDvd.getuserRating());
	    }
	    io.readString("Please hit enter to continue.");
	}
        public void displayAllBanner() {
	    io.print("=== Display All Dvds ===");
	}
        public void displayDvdBanner () {
	    io.print("=== Display Dvd ===");
	}

	public String getDvdTitleChoice() {
	    return io.readString("Please enter the Title.");
	}

	public void displayDvd(Dvd dvd) {
	    if (dvd != null) {
	        io.print(dvd.getdvdTitle());
	        io.print(dvd.getreleaseDate());
                io.print(dvd.getRating());
                io.print(dvd.getdirectorsName());
	        io.print(dvd.getStudio());
                io.print(dvd.getuserRating());
	        io.print("");
	    } else {
	        io.print("No such Dvd.");
	    }
	    io.readString("Please hit enter to continue.");
	}
        public void displayRemoveDvdBanner () {
	    io.print("=== Remove Dvd ===");
	}

	public void displayRemoveSuccessBanner () {
	    io.readString("Dvd successfully removed. Please hit enter to continue.");
	}
        public void displayExitBanner() {
            io.print("Good Bye!!!");
        }

        public void displayUnknownCommandBanner() {
            io.print("Unknown Command!!!");
        }
        public void displayErrorMessage(String errorMsg) {
	    io.print("=== ERROR ===");
	    io.print(errorMsg);
	}
}
