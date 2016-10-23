/*
 * Copyright (c) 2015-present, Parse, LLC.
 * All rights reserved.
 *
 * This source code is licensed under the BSD-style license found in the
 * LICENSE file in the root directory of this source tree. An additional grant
 * of patent rights can be found in the PATENTS file in the same directory.
 */
package com.parse.starter;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.ParseAnalytics;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseUser;
import com.parse.SignUpCallback;



public class MainActivity extends AppCompatActivity {

  EditText usernameField;
  EditText passwordField;

  public void signUpOrLogin(View view)
  {

    Log.i("AppInfo",String.valueOf(usernameField.getText()));
    Log.i("AppInfo",String.valueOf(passwordField.getText()));

    ParseUser user = new ParseUser();
    user.setUsername(String.valueOf(usernameField.getText()));
    user.setPassword(String.valueOf(passwordField.getText()));
    user.signUpInBackground(new SignUpCallback() {
      @Override
      public void done(ParseException e) {
        if(e == null)
        {
          Log.i("AppInfo","Sign up Successful");
        }
        else{
          Log.i("AppInfo","Not Successful");
          Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_LONG).show();
        }
      }
    });


  }

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    usernameField = (EditText) findViewById(R.id.username);
    passwordField = (EditText) findViewById(R.id.password);



    ParseAnalytics.trackAppOpenedInBackground(getIntent());

  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the menu; this adds items to the action bar if it is present.
    getMenuInflater().inflate(R.menu.menu_main, menu);
    return true;
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    // Handle action bar item clicks here. The action bar will
    // automatically handle clicks on the Home/Up button, so long
    // as you specify a parent activity in AndroidManifest.xml.
    int id = item.getItemId();

    //noinspection SimplifiableIfStatement
    if (id == R.id.action_settings) {
      return true;
    }

    return super.onOptionsItemSelected(item);
  }
}
