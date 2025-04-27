package com.example.demo;
public class PersonPresenter implements IMVPContract.Presenter {

    // Presenter needs the model...
    PersonDB_Mem personDB;
    IMVPContract.View theActualView;

    public PersonPresenter(IMVPContract.View aView) {
        this.theActualView = aView;
        this.personDB = new PersonDB_Mem();
    }

    @Override
    public void addPersonToDB(String name,String lastname, String age) {
        Integer pAge = Integer.parseInt(age);
        Person p = new Person(name,lastname, pAge);
        personDB.addPerson(p);

        // All "Views" must implement this interface to update
        // the information on the screen about the number in the DB.
        theActualView.updateNumberInDB(personDB.numInDB());
    }

    @Override

    public void searchPerson(String name) {
        if (personDB.containsPersonWithName(name)) {
            theActualView.updateSearch("Found");
        } else {
            theActualView.updateSearch("Not Found");
        }
    }


}