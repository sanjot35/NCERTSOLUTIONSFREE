package com.goo_dev.ncertsolutionsfree;


import android.content.Intent;
import android.net.Uri;
import android.support.design.widget.TabLayout;

import android.support.design.widget.Snackbar;

import android.support.v7.app.AppCompatActivity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;

import android.util.Log;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


import android.widget.EditText;

import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LOGIN extends AppCompatActivity {


    private SectionsPagerAdapter mSectionsPagerAdapter;
    private ViewPager mViewPager;
    String emailvalid = "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" +
            "\\@" +
            "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" + "\\." + "com";

    boolean flag = true;
    boolean checkmail =true;
   // boolean flagforget = true;
    ArrayList<String> Lemail = new ArrayList<>();

   DatabaseReference database;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        database = FirebaseDatabase.getInstance().getReference("Confidential");

       // Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);






    }


    public void Login_Database(final View v)
    {   EditText loginuname= (EditText)findViewById(R.id.editUsername_login);
        EditText loginpass= (EditText)findViewById(R.id.editPassword_login);
        final String password=loginpass.getText().toString();
        final String username=loginuname.getText().toString();
        //Toast.makeText(getApplicationContext(), "happy", Toast.LENGTH_SHORT).show();
        database.addValueEventListener(new ValueEventListener() {


            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
               // Toast.makeText(LOGIN.this, "1", Toast.LENGTH_SHORT).show();
                for(DataSnapshot confedentialsnapshot : dataSnapshot.getChildren())
                {
                   //Toast.makeText(LOGIN.this, "2", Toast.LENGTH_SHORT).show();
                    Confidential confidential = confedentialsnapshot.getValue(Confidential.class);
                    if(confidential.uname.equals(username) && confidential.pass.equals(password))
                    {
                        flag=false;
                        Intent i = new Intent(getApplicationContext(),Home_page.class);
                    startActivity(i);
                    }

                }

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        if(flag==false)
        {
            Snackbar.make(v,"Welcome",Snackbar.LENGTH_LONG).show();
        }
    }

    public void Signup_databse(View v) {
        if (v.getId() == R.id.button_Signup) {
            boolean valid = true;
            EditText name = (EditText) findViewById(R.id.editname_signup);
            EditText emailedit = (EditText) findViewById(R.id.editmail_signup);
            EditText uname = (EditText)findViewById(R.id.editUsername_signup);
            EditText passwordedit = (EditText) findViewById(R.id.editpassword_signup);
            EditText confirmpass = (EditText) findViewById(R.id.editconfirmpass_signup);
            String namestr = name.getText().toString();
            String emailstr = emailedit.getText().toString();
            String unamestr = uname.getText().toString();
            String passwordstr = passwordedit.getText().toString();
            String confirmpassstr = confirmpass.getText().toString();
            Pattern p = Pattern.compile(emailvalid);
            Matcher m = p.matcher(emailstr);
            if (!passwordstr.equals(confirmpassstr)) {
                confirmpass.setError("Enter same password");
                valid = false;
            }
            if (emailstr.isEmpty() || !m.find()) {
                emailedit.setError("enter a valid email address");
                valid = false;
            }

            if (passwordstr.isEmpty() || passwordstr.length() < 4 || passwordstr.length() > 10) {
                passwordedit.setError("between 4 and 10 alphanumeric characters");
                valid = false;
            }
            if (unamestr.isEmpty() || namestr.isEmpty()) {
                uname.setError("can't be empty");
                valid = false;
            }
            if (unamestr.length() < 4) {
                uname.setError("atleast 4 char");
                valid = false;
            }
            if (namestr.length() < 2) {
                name.setError("invalid name");
                valid = false;
            }


            if (valid) {

                  String id = database.push().getKey();
                 Confidential confidential = new Confidential(id,namestr,passwordstr,emailstr);
                database.child(id).setValue(confidential);
                Toast.makeText(getApplicationContext(), "You Are In", Toast.LENGTH_SHORT).show();


            } else
                Snackbar.make(v,"                                  Try Again",Snackbar.LENGTH_LONG).show();
        }

    }
public void Trouble(View v)
{
    String[] TO = {"sanjot35@gmail.com"};
    Intent emailIntent = new Intent(Intent.ACTION_SEND);
    emailIntent.setData(Uri.parse("mailto:"));
    emailIntent.setType("text/plain");


    emailIntent.putExtra(Intent.EXTRA_EMAIL, TO);
    emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Trouble in Log-in");
    emailIntent.putExtra(Intent.EXTRA_TEXT, "Enter your problem ");

    try {
        startActivity(Intent.createChooser(emailIntent, "Send mail..."));
        finish();
        Log.i("Finished sending email","");
    } catch (android.content.ActivityNotFoundException ex) {
        Toast.makeText(getApplicationContext(),
                "There is no email client installed.", Toast.LENGTH_SHORT).show();
    }
}
    public void Forgotpw(final View v) {
        final EditText forgote = (EditText) findViewById(R.id.editmail_forgot);
        final String forgotemail = forgote.getText().toString();
        final EditText forgotu = (EditText)findViewById(R.id.editname_forgot);
        final String forgotuname = forgotu.getText().toString();
        Pattern p = Pattern.compile(emailvalid);
        Matcher m = p.matcher(forgotemail);

        if (forgotemail.isEmpty() || !m.find() ) {
            forgote.setError("enter a valid email address");
        }
        else if(forgotuname.isEmpty())
        {
            forgotu.setError("Empty");
        }
        database.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                for (DataSnapshot confedentialsnapshot : dataSnapshot.getChildren()) {
                    Confidential confidential = confedentialsnapshot.getValue(Confidential.class);
                     if (confidential.useemail.equals(forgotemail) && confidential.uname.equals(forgotuname)) {
                        checkmail=false;
                         Toast.makeText(LOGIN.this,"Your password is : "+confidential.pass, Toast.LENGTH_SHORT).show();
                        }

                    }
                    if(checkmail==true)
                    {
                        Snackbar.make(v,"Invalid Details",Snackbar.LENGTH_LONG).show();
                    }

                }


            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_login, menu);
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

    /**
     * A placeholder fragment containing a simple view.
     */
        /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    Frag_login frag_login = new Frag_login();
                    return frag_login;
                case 1:
                    Frag_signup frag_signup = new Frag_signup();
                    return frag_signup;
                case 2:
                    Frag_Forgot_pass frag_pass=new Frag_Forgot_pass();
                    return frag_pass;
                default:
                    return null;
            }
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                   return "LOGIN";
                case 1:
                    return "SIGNUP";
                case 2:
                    return "Forgot Password";
            }
            return null;
        }
    }
}
