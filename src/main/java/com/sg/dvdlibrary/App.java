/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdlibrary;

import com.sg.dvdlibrary.controller.dvdlibrarycontroller;
import com.sg.dvdlibrary.dao.dvdlibraryDao;
import com.sg.dvdlibrary.dao.dvdlibraryDaoFileImpl;
import com.sg.dvdlibrary.ul.UserIO;
import com.sg.dvdlibrary.ul.UserIOConsoleImpl;
import com.sg.dvdlibrary.ul.dvdlibraryView;

/**
 *
 * @author ashwinsridhar
 */
public class App {
    public static void main(String[] args) {
    UserIO myIo = new UserIOConsoleImpl();
    dvdlibraryView myView = new dvdlibraryView(myIo);
    dvdlibraryDao myDao = new dvdlibraryDaoFileImpl();
    dvdlibrarycontroller controller = 
            new dvdlibrarycontroller(myDao, myView);
    controller.run();
    }
}
