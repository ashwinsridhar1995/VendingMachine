/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdlibrary.controller;

import com.sg.dvdlibrary.dao.dvdlibraryDao;
import com.sg.dvdlibrary.dao.dvdlibraryDaoException;
import com.sg.dvdlibrary.dto.Dvd;
import com.sg.dvdlibrary.ul.UserIO;
import com.sg.dvdlibrary.ul.UserIOConsoleImpl;
import com.sg.dvdlibrary.ul.dvdlibraryView;
import java.util.List;

/**
 *
 * @author ashwinsridhar
 */
public class dvdlibrarycontroller {
    UserIO io = new UserIOConsoleImpl();
    dvdlibraryView view;
    dvdlibraryDao dao;
   // private UserIO io;
    public dvdlibrarycontroller(dvdlibraryDao dao,dvdlibraryView view){
        this.view = view;
        this.dao = dao;
    }
            
	    public void run() {
	    boolean keepGoing = true;
	    int menuSelection = 0;
	    try {
	        while (keepGoing) {

	            menuSelection = getMenuSelection();

	            switch (menuSelection) {
	                case 1:
	                    listdvds();
	                    break;
	                case 2:
	                    createdvd();
	                    break;
	                case 3:
	                    viewdvd();
	                    break;
	                case 4:
	                    removedvd();
	                    break;
                        case 5:
                            Edit();
                            break;
	                case 6:
                            String title = io.readString("Please enter the title that you're searching for: ");
                            view.displayDvd(dao.findDvd(title));
	                    break;
                        case 7:
                            keepGoing = false;
                            break;
	                default:
	                    unknownCommand();
	            }

	        }
	        exitMessage();
	    } catch (dvdlibraryDaoException e) {
	        view.displayErrorMessage(e.getMessage());
	    }
	}
	    
	private int getMenuSelection() {
	    return view.printMenuAndGetSelection();
	}

	private void createdvd() throws dvdlibraryDaoException {
	    view.displayCreateStudentBanner();
	    Dvd newDvd = view.getNewDvdInfo();
	    dao.addDvd(newDvd.getdvdTitle(), newDvd);
	    view.displayCreateSuccessBanner();
	}

	private void listdvds() throws dvdlibraryDaoException {
	    view.displayAllBanner();
	    List<Dvd> dvdList = dao.getAllDvds();
	    view.displayDvdList(dvdList);
	}

	private void viewdvd() throws dvdlibraryDaoException {
	    view.displayDvdBanner();
	    String dvdTitle = view.getDvdTitleChoice();
	    Dvd dvd = dao.getDvd(dvdTitle);
	    view.displayDvd(dvd);
	}

	private void removedvd() throws dvdlibraryDaoException {
	    view.displayRemoveDvdBanner();
	    String dvdTitle = view.getDvdTitleChoice();
	    dao.removeDvd(dvdTitle);
	    view.displayRemoveSuccessBanner();
	}

	private void unknownCommand() {
	    view.displayUnknownCommandBanner();
	}

	private void exitMessage() {
	    view.displayExitBanner();
	}
        private void Edit() throws dvdlibraryDaoException{
            String editTitle = view.getDvdTitleChoice();
            dao.removeDvd(editTitle);
            io.readString("The Dvd has been removed. Press enter to create a new one.");
            view.displayCreateStudentBanner();
	    Dvd newDvd = view.getNewDvdInfo();
	    dao.addDvd(newDvd.getdvdTitle(), newDvd);
	    view.displayCreateSuccessBanner();
        }
}
