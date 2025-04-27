package com.example.demo;

interface IMVPContract {

    // The presenter's interface for this "contract"
    // Currently just add's person to the DB
    interface Presenter {
        void addPersonToDB( String name, String lastname,String age );
        void searchPerson(String name);
    }

    // The view's interface for this "contract".  Allows
    // the presenter to update the information in the view's
    // display.
    interface View {
        void updateNumberInDB( int num );
        void updateSearch(String l);
    }
}