package com.example.contacts;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

    //GUI Fields
    protected Button enter_name;
    protected Button display_contacts;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*
         * R is a special class generated
         *
         * R matches name to its address
         *
         * R creates reference to widget
         *
         *
         * R: public final class
         *
         *
         *
         * */


        enter_name = (Button) findViewById(R.id.enter_name_button);
        display_contacts = (Button) findViewById(R.id.display_contacts_button);



        //Set up listeners for buttons
        enter_name.setOnClickListener(enter_nameListener);
        display_contacts.setOnClickListener(display_contactsListener);
    }

    /*We want to save the state of current activity*/

    // This will be called when the app loses focus; save
    // current state
    @Override
    public void onSaveInstanceState(Bundle outState) {
        // Always do this
        super.onSaveInstanceState(outState)  ;
    }

    /*Create a new activity associated when the first button is clicked*/


    /*Create Listener for the enter_name button*/

    public View.OnClickListener enter_nameListener = new View.OnClickListener() {

        // Called when up button is selected
        @Override
        public void onClick(View v) {
            switch_to_enter_name_Activity();
        }
    };

    /*Create Listener for the display_contacts_button*/
    public View.OnClickListener display_contactsListener = new View.OnClickListener() {

        // Called when up button is selected
        @Override
        public void onClick(View v) {
            setDisplay_contactsActivity();
        }
    };

    /*Switch to enter_name Activity
    *
    *   This intent will allow the user to enter a name and check if it is valid within
    *
    *   the contacts
    *
    * */
    private void switch_to_enter_name_Activity() {
        //From Activity ----> To Activity
        Intent i = new Intent(MainActivity.this,Enter_Name_Activity.class);
        startActivityForResult(i,1);
    }

    /*Switch to displayContacts Activity */
    private void setDisplay_contactsActivity(){
        // Intent is a HASHMAP <action,data>
        //ACTION_PICK ---> provide app access to
        Intent i= new Intent(Intent.ACTION_PICK,  ContactsContract.Contacts.CONTENT_URI);
        startActivityForResult(i,1);
    }
}

