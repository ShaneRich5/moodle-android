package com.shadow.moodle.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.shadow.moodle.R;
import com.shadow.moodle.callbacks.CredentialsLoadedListener;
import com.shadow.moodle.logger.Logger;
import com.shadow.moodle.model.User;
import com.shadow.moodle.tasks.TaskRetrieveToken;


public class MainActivity extends AppCompatActivity implements
        View.OnClickListener, CredentialsLoadedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnSubmit = (Button) findViewById(R.id.submit);
        btnSubmit.setOnClickListener(this);
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

    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.submit:
                String username = ((TextView) findViewById(R.id.username)).getText().toString();
                String password = ((TextView) findViewById(R.id.password)).getText().toString();

                new TaskRetrieveToken(this, username, password).execute();

                break;
        }
    }

    @Override
    public void onTokenLoaded(String token) {
        Logger.toastLong(this, token);
    }

    @Override
    public void onUserDetailsLoaded(User user) {

    }
}
