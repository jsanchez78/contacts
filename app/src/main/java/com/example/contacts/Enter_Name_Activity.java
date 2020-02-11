package com.example.contacts;

import android.app.Activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;


public class Enter_Name_Activity extends Activity {

    protected TextView user_prompt_text;
    protected EditText edit_text;
    String getText;
    String first_and_last_name[];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //This switches scene to second Activity
        setContentView(R.layout.enter_name_layout);


        //Initiazlie widgets
        user_prompt_text = findViewById(R.id.enter_name);
        edit_text = findViewById(R.id.edit_text);

        /*Event Handler when user enters text*/

        edit_text.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    //Parse user input
                    getText = edit_text.getText().toString();
                    first_and_last_name = getText.split("");//Seperate by white space
                    onPause();
                    return true;
                }
                onPause();
                return false;
            }
        });
    }




    /*Now we must check if edit_text is legal text to be entered:
    *
    *
    *
    *       A legal name consists at least of a first name and a last name, each
        containing a sequence of alphabetical characters and separated by one or more space
        characters. Leading and trailing white space characters should be ignored.
    *
    *
    *
    *
    *
    */
    public static boolean isStringOnlyAlphabet(String str)
    {
        return ((!str.equals("")) && (str.matches("^[a-zA-Z]*$")));
    }

    protected void onPause() {
        super.onPause() ;
        if(isStringOnlyAlphabet(first_and_last_name[0]) && isStringOnlyAlphabet(first_and_last_name[1]))
            setResult(RESULT_OK);
        else{
            setResult(RESULT_CANCELED);  //Result cancelled
        }
        finish();  //Kill the activity from which you will go to next activity
    }
}

