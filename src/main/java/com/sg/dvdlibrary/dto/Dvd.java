/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdlibrary.dto;

/**
 *
 * @author ashwinsridhar
 */
public class Dvd {
     private String dvdTitle;
	    private String releaseDate;
	    private String Rating;
	    private String directorsName; // Java or .Net + cohort month/year
	    private String Studio;
            private String userRating;
            
	    public Dvd(String dvdTitle) {
	        this.dvdTitle = dvdTitle;
	    }
            
            public String getdvdTitle() {
	        return dvdTitle;
	    }
            
            public void setreleaseDate(String releaseDate) {
                this.releaseDate = releaseDate;
            }

	    public String getreleaseDate() {
	        return releaseDate;
	    }
            
            public void setRating(String Rating) {
                this.Rating = Rating;
            }

	    public String getRating() {
	        return Rating;
	    }

	    public void setdirectorsName(String directorsName) {
	        this.directorsName = directorsName;
	    }

	    public String getdirectorsName() {
	        return directorsName;
	    }

	    public void setStudio(String Studio) {
	        this.Studio = Studio;
	    }
            
            public String getStudio() {
	        return Studio;
	    }
            
            public void setuserRating(String userRating) {
	        this.userRating = userRating;
	    }

	    public String getuserRating() {
	        return userRating;
	    }

}
