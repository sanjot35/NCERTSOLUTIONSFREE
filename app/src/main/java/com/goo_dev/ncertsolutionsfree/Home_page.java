package com.goo_dev.ncertsolutionsfree;


import android.content.Intent;

import android.net.Uri;

import android.support.v4.view.ViewPager;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;

import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;

import java.util.Timer;
import java.util.TimerTask;

public class Home_page extends AppCompatActivity {
    ViewPager vp;
    String loadurl;
    InterstitialAd mInterstitialAd;
    private InterstitialAd interstitial;


    Spinner spchap, spsub, spclass;
    String submaths6[] = {"Chapter 1", "Chapter 2", "Chapter 3", "Chapter 4", "Chapter 5", "Chapter 6", "Chapter 7", "Chapter 8", "Chapter 9", "Chapter 10", "Chapter 11", "Chapter 12", "Chapter 13", "Chapter 14"};

    String subsci6[] = {"Chapter 1", "Chapter 2", "Chapter 3", "Chapter 4", "Chapter 5", "Chapter 6", "Chapter 7", "Chapter 8", "Chapter 9", "Chapter 10", "Chapter 11", "Chapter 12", "Chapter 13", "Chapter 14", "Chapter 15", "Chapter 16"};

    String subsci7[] = {"Chapter 1", "Chapter 2", "Chapter 3", "Chapter 4", "Chapter 5", "Chapter 6", "Chapter 7", "Chapter 8", "Chapter 9", "Chapter 10", "Chapter 11", "Chapter 12", "Chapter 13", "Chapter 14", "Chapter 15", "Chapter 16", "Chapter 17", "Chapter 18"};

    String submaths7[] = {"Chapter 1", "Chapter 2", "Chapter 3", "Chapter 4", "Chapter 5", "Chapter 6", "Chapter 7", "Chapter 8", "Chapter 9", "Chapter 10", "Chapter 11", "Chapter 12", "Chapter 13", "Chapter 14", "Chapter 15"};

    String submaths8[] = {"Chapter 1", "Chapter 2", "Chapter 3", "Chapter 4", "Chapter 5", "Chapter 6", "Chapter 7", "Chapter 8", "Chapter 9", "Chapter 10", "Chapter 11", "Chapter 12", "Chapter 13", "Chapter 14", "Chapter 15", "Chapter 16"};

    String subsci8[] = {"Chapter 1", "Chapter 2", "Chapter 3", "Chapter 4", "Chapter 5", "Chapter 6", "Chapter 7", "Chapter 8", "Chapter 9", "Chapter 10", "Chapter 11", "Chapter 12", "Chapter 13", "Chapter 14", "Chapter 15", "Chapter 16", "Chapter 17", "Chapter 18"};

    String submaths9[] = {"Chapter 1", "Chapter 2", "Chapter 3", "Chapter 4", "Chapter 5", "Chapter 6", "Chapter 7", "Chapter 8", "Chapter 9", "Chapter 10", "Chapter 11", "Chapter 12", "Chapter 13", "Chapter 14", "Chapter 15"};

    String subsci9[] = {"Chapter 1", "Chapter 2", "Chapter 3", "Chapter 4", "Chapter 5", "Chapter 6", "Chapter 7", "Chapter 8", "Chapter 9", "Chapter 10", "Chapter 11", "Chapter 12", "Chapter 13", "Chapter 14", "Chapter 15"};

    String submaths10[] = {"Chapter 1", "Chapter 2", "Chapter 3", "Chapter 4", "Chapter 5", "Chapter 6", "Chapter 7", "Chapter 8", "Chapter 9", "Chapter 10", "Chapter 11", "Chapter 12", "Chapter 13", "Chapter 14", "Chapter 15"};

    String subsci10[] = {"Chapter 1", "Chapter 2", "Chapter 3", "Chapter 4", "Chapter 5", "Chapter 6", "Chapter 7", "Chapter 8", "Chapter 9", "Chapter 10", "Chapter 11", "Chapter 12", "Chapter 13", "Chapter 14", "Chapter 15", "Chapter 16"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        vp = (ViewPager) findViewById(R.id.viewpage);

        ViewPageAdapter viewpageada = new ViewPageAdapter(this);

        vp.setAdapter(viewpageada);
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new Mytimer(),3000,10000);




        AdView mAdView = (AdView) findViewById(R.id.adsss);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

// Prepare the Interstitial Ad
        interstitial = new InterstitialAd(this);
// Insert the Ad Unit ID
        interstitial.setAdUnitId("ca-app-pub-6146043872713766/4189300020");

        interstitial.loadAd(adRequest);
// Prepare an Interstitial Ad Listener
        interstitial.setAdListener(new AdListener() {
            public void onAdLoaded() {
                // Call displayInterstitial() function
                displayInterstitial();
            }
        });



        spchap = (Spinner) findViewById(R.id.spinnerchapter);
        spclass = (Spinner) findViewById(R.id.spinnerclass);
        spsub = (Spinner) findViewById(R.id.spinnersubject);

        // final ArrayAdapter<String> subjectschoose=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,subject);
        final ArrayAdapter<String> subjectmath6 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, submaths6);
        final ArrayAdapter<String> subjectmath7 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, submaths7);
        final ArrayAdapter<String> subjectmath8 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, submaths8);
        final ArrayAdapter<String> subjectmath9 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, submaths9);
        final ArrayAdapter<String> subjectmath10 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, submaths10);
        final ArrayAdapter<String> subjectsci6 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, subsci6);
        final ArrayAdapter<String> subjectsci7 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, subsci7);
        final ArrayAdapter<String> subjectsci8 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, subsci8);
        final ArrayAdapter<String> subjectsci9 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, subsci9);
        final ArrayAdapter<String> subjectsci10 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, subsci10);

        spclass.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 1:
                        String chooseclass6 = spsub.getSelectedItem().toString();
                        if (chooseclass6.equals("Maths")) {
                            subjectmath6.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            spchap.setAdapter(subjectmath6);
                        }
                        if (chooseclass6.equals("Science")) {
                            subjectsci6.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            spchap.setAdapter(subjectsci6);
                        }
                        break;
                    case 2:
                        String chooseclass7 = spsub.getSelectedItem().toString();
                        if (chooseclass7.equals("Maths")) {
                            subjectmath7.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            spchap.setAdapter(subjectmath7);
                        }
                        if (chooseclass7.equals("Science")) {
                            subjectsci7.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            spchap.setAdapter(subjectsci7);
                        }
                        break;
                    case 3:
                        String chooseclass8 = spsub.getSelectedItem().toString();
                        if (chooseclass8.equals("Maths")) {
                            subjectmath8.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            spchap.setAdapter(subjectmath8);
                        }
                        if (chooseclass8.equals("Science")) {
                            subjectsci8.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            spchap.setAdapter(subjectsci8);
                        }
                        break;
                    case 4:
                        String chooseclass9 = spsub.getSelectedItem().toString();
                        if (chooseclass9.equals("Maths")) {
                            subjectmath9.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            spchap.setAdapter(subjectmath9);
                        }
                        if (chooseclass9.equals("Science")) {
                            subjectsci9.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            spchap.setAdapter(subjectsci9);
                        }
                        break;
                    case 5:
                        String chooseclass10 = spsub.getSelectedItem().toString();
                        if (chooseclass10.equals("Maths")) {
                            subjectmath10.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            spchap.setAdapter(subjectmath10);
                        }
                        if (chooseclass10.equals("Science")) {
                            subjectsci10.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            spchap.setAdapter(subjectsci10);
                        }
                        break;


                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    public void Logout(View v) {
        Intent i = new Intent(getApplicationContext(), LOGIN.class);
        startActivity(i);
        finish();
    }

    public void find(View v) {
        String getclass = spclass.getSelectedItem().toString();
        String getsubject = spsub.getSelectedItem().toString();
        String getchapter = spchap.getSelectedItem().toString();
        if (getclass.equals("Class 6")) {
            if (getsubject.equals("Maths")) {
                if (getchapter.equals("Chapter 1")) {
                    loadurl = "https://drive.google.com/open?id=0B_U2dqDidq-0VVh3S1E2aVJKRVE";
                    funk(loadurl);
                } else if (getchapter.equals("Chapter 2")) {
                    loadurl = "https://drive.google.com/open?id=0B_U2dqDidq-0UmE2akE4UkJqVzQ";
                    funk(loadurl);
                } else if (getchapter.equals("Chapter 3")) {
                    loadurl = "https://drive.google.com/open?id=0B_U2dqDidq-0QklVRjhrcFlXSHc";
                    funk(loadurl);
                } else if (getchapter.equals("Chapter 4")) {
                    loadurl = "https://drive.google.com/open?id=0B_U2dqDidq-0cXpkUVRBb25uTkU";
                    funk(loadurl);
                } else if (getchapter.equals("Chapter 5")) {
                    loadurl = "https://drive.google.com/open?id=0B_U2dqDidq-0VktUMmJnZWJDbTQ";
                    funk(loadurl);
                } else if (getchapter.equals("Chapter 6")) {
                    loadurl = "https://drive.google.com/open?id=0B_U2dqDidq-0NnotTkxNUDAyYzQ";
                    funk(loadurl);
                } else if (getchapter.equals("Chapter 7")) {
                    loadurl = "https://drive.google.com/open?id=0B_U2dqDidq-0ZDNMU0d0S2wxSHM";
                    funk(loadurl);
                } else if (getchapter.equals("Chapter 8")) {
                    loadurl = "https://drive.google.com/open?id=0B_U2dqDidq-0ZnBlRzBud3ZpNlk";
                    funk(loadurl);
                } else if (getchapter.equals("Chapter 9")) {
                    loadurl = "https://drive.google.com/open?id=0B_U2dqDidq-0T1poeXFaVGRqUmc";
                    funk(loadurl);
                } else if (getchapter.equals("Chapter 10")) {
                    loadurl = "https://drive.google.com/open?id=0B_U2dqDidq-0eGxoSjhMbDhPNjA";
                    funk(loadurl);
                } else if (getchapter.equals("Chapter 11")) {
                    loadurl = "https://drive.google.com/open?id=0B_U2dqDidq-0ZGFsQ3dDcTRjekE";
                    funk(loadurl);
                } else if (getchapter.equals("Chapter 12")) {
                    loadurl = "https://drive.google.com/open?id=0B_U2dqDidq-0YnFDR2pFeDczLTg";
                    funk(loadurl);
                } else if (getchapter.equals("Chapter 13")) {
                    loadurl = "https://drive.google.com/open?id=0B_U2dqDidq-0VkRDWkxWNVVnZk0";
                    funk(loadurl);
                } else if (getchapter.equals("Chapter 14")) {
                    loadurl = "https://drive.google.com/open?id=0B_U2dqDidq-0VkVIOTVzMW5pUWM";
                    funk(loadurl);
                } else {
                    Toast.makeText(this, "Invalid", Toast.LENGTH_SHORT).show();
                }

            }
            if (getsubject.equals("Science")) {
                if (getchapter.equals("Chapter 1")) {
                    loadurl = "https://drive.google.com/open?id=0B_U2dqDidq-0d0cwV19nZmRaaXc";
                    funk(loadurl);
                } else if (getchapter.equals("Chapter 2")) {
                    loadurl = "https://drive.google.com/open?id=0B_U2dqDidq-0UVZON3lvY1FWVGM";
                    funk(loadurl);
                } else if (getchapter.equals("Chapter 3")) {
                    loadurl = "https://drive.google.com/open?id=0B_U2dqDidq-0MHRTclcxZFpMejA";
                    funk(loadurl);
                } else if (getchapter.equals("Chapter 4")) {
                    loadurl = "https://drive.google.com/open?id=0B_U2dqDidq-0VGNjRmNzdWhuU1E";
                    funk(loadurl);
                } else if (getchapter.equals("Chapter 5")) {
                    loadurl = "https://drive.google.com/open?id=0B_U2dqDidq-0Y3daNkEzOXBvUkU";
                    funk(loadurl);
                } else if (getchapter.equals("Chapter 6")) {
                    loadurl = "https://drive.google.com/open?id=0B_U2dqDidq-0Ty1KbjNxWW9NQ3M";
                    funk(loadurl);
                } else if (getchapter.equals("Chapter 7")) {
                    loadurl = "https://drive.google.com/open?id=0B_U2dqDidq-0a3JOdkRfWS05azA";
                    funk(loadurl);
                } else if (getchapter.equals("Chapter 8")) {
                    loadurl = "https://drive.google.com/open?id=0B_U2dqDidq-0dVlqM2pxWTNlUms";
                    funk(loadurl);
                } else if (getchapter.equals("Chapter 9")) {
                    loadurl = "https://drive.google.com/open?id=0B_U2dqDidq-0MjIxZjZ2WTlZOFU";
                    funk(loadurl);
                } else if (getchapter.equals("Chapter 10")) {
                    loadurl = "https://drive.google.com/open?id=0B_U2dqDidq-0cjRpbFJOVVB1YmM";
                    funk(loadurl);
                } else if (getchapter.equals("Chapter 11")) {
                    loadurl = "https://drive.google.com/open?id=0B_U2dqDidq-0b1pUaHdaMGtfSFk";
                    funk(loadurl);
                } else if (getchapter.equals("Chapter 12")) {
                    loadurl = "https://drive.google.com/open?id=0B_U2dqDidq-0eWpDUDMxSHgzTFU";
                    funk(loadurl);
                } else if (getchapter.equals("Chapter 13")) {
                    loadurl = "https://drive.google.com/open?id=0B_U2dqDidq-0Q2MxUWJSa0xxNWc";
                    funk(loadurl);
                } else if (getchapter.equals("Chapter 14")) {
                    loadurl = "https://drive.google.com/open?id=0B_U2dqDidq-0a3RHVXB3OHZ4MWc";
                    funk(loadurl);
                } else if (getchapter.equals("Chapter 15")) {
                    loadurl = "https://drive.google.com/open?id=0B_U2dqDidq-0NlQwY1dqMUI3VjA";
                    funk(loadurl);
                } else if (getchapter.equals("Chapter 16")) {
                    loadurl = "https://drive.google.com/open?id=0B_U2dqDidq-0c2tlNEhsVlNSVU0";
                    funk(loadurl);
                } else {
                    Toast.makeText(this, "Invalid", Toast.LENGTH_SHORT).show();
                }

            }
        } else if (getclass.equals("Class 7")) {
            if (getsubject.equals("Maths")) {
                if (getchapter.equals("Chapter 1")) {
                    loadurl = "https://drive.google.com/open?id=0B_U2dqDidq-0ZFptU0lsVXk0d0k";
                    funk(loadurl);
                } else if (getchapter.equals("Chapter 2")) {
                    loadurl = "https://drive.google.com/open?id=0B_U2dqDidq-0S0cxWjhxWWpYQkk";
                    funk(loadurl);
                } else if (getchapter.equals("Chapter 3")) {
                    loadurl = "https://drive.google.com/open?id=0B_U2dqDidq-0UlpJMVE1YVhRQXM";
                    funk(loadurl);
                } else if (getchapter.equals("Chapter 4")) {
                    loadurl = "https://drive.google.com/open?id=0B_U2dqDidq-0Z2VrWm8yMXViUmM";
                    funk(loadurl);
                } else if (getchapter.equals("Chapter 5")) {
                    loadurl = "https://drive.google.com/open?id=0B_U2dqDidq-0T3pUN05TdkhYdzQ";
                    funk(loadurl);
                } else if (getchapter.equals("Chapter 6")) {
                    loadurl = "https://drive.google.com/open?id=0B_U2dqDidq-0em1JdERSTF9sU28";
                    funk(loadurl);
                } else if (getchapter.equals("Chapter 7")) {
                    loadurl = "https://drive.google.com/open?id=0B_U2dqDidq-0UW9jYTJfcFBwa0E";
                    funk(loadurl);
                } else if (getchapter.equals("Chapter 8")) {
                    loadurl = "https://drive.google.com/open?id=0B_U2dqDidq-0TlpFekFENzhwYjg";
                    funk(loadurl);
                } else if (getchapter.equals("Chapter 9")) {
                    loadurl = "https://drive.google.com/open?id=0B_U2dqDidq-0VWdUUXExaGFIWUU";
                    funk(loadurl);
                } else if (getchapter.equals("Chapter 10")) {
                    loadurl = "https://drive.google.com/open?id=0B_U2dqDidq-0TWp4a1h1ZFBzQUk";
                    funk(loadurl);
                } else if (getchapter.equals("Chapter 11")) {
                    loadurl = "https://drive.google.com/open?id=0B_U2dqDidq-0RGZ5QVoxaFBub1U";
                    funk(loadurl);
                } else if (getchapter.equals("Chapter 12")) {
                    loadurl = "https://drive.google.com/open?id=0B_U2dqDidq-0UG1wYW5FX3B5Vzg";
                    funk(loadurl);
                } else if (getchapter.equals("Chapter 13")) {
                    loadurl = "https://drive.google.com/open?id=0B_U2dqDidq-0b2ViejhINHVidk0";
                    funk(loadurl);
                } else if (getchapter.equals("Chapter 14")) {
                    loadurl = "https://drive.google.com/open?id=0B_U2dqDidq-0dXFXazZNWkdjNnc";
                    funk(loadurl);
                } else if (getchapter.equals("Chapter 15")) {
                    loadurl = "https://drive.google.com/open?id=0B_U2dqDidq-0NW5hTEd5MFo2Q28";
                    funk(loadurl);
                } else {
                    Toast.makeText(this, "Invalid", Toast.LENGTH_SHORT).show(); }

            }
            if (getsubject.equals("Science")) {
                if (getchapter.equals("Chapter 1")) {
                    loadurl = "https://drive.google.com/open?id=0B_U2dqDidq-0WEJSZ3FuN1hGdUE";
                    funk(loadurl);
                } else if (getchapter.equals("Chapter 2")) {
                    loadurl = "https://drive.google.com/open?id=0B_U2dqDidq-0Ul9JcUJUZE9wbzg";
                    funk(loadurl);
                } else if (getchapter.equals("Chapter 3")) {
                    loadurl = "https://drive.google.com/open?id=0B_U2dqDidq-0cVRLSXBOWG1SQUk";
                    funk(loadurl);
                } else if (getchapter.equals("Chapter 4")) {
                    loadurl = "https://drive.google.com/open?id=0B_U2dqDidq-0VUMyNUQxa0hTeEU";
                    funk(loadurl);
                } else if (getchapter.equals("Chapter 5")) {
                    loadurl = "https://drive.google.com/open?id=0B_U2dqDidq-0eEVhaUlMVnZrdjg";
                    funk(loadurl);
                } else if (getchapter.equals("Chapter 6")) {
                    loadurl = "https://drive.google.com/open?id=0B_U2dqDidq-0QUNFcUIwNnNNS2c";
                    funk(loadurl);
                } else if (getchapter.equals("Chapter 7")) {
                    loadurl = "https://drive.google.com/open?id=0B_U2dqDidq-0Z0x4ZXFNd2dsNk0";
                    funk(loadurl);
                } else if (getchapter.equals("Chapter 8")) {
                    loadurl = "https://drive.google.com/open?id=0B_U2dqDidq-0N2JPQ095eWwtRUE";
                    funk(loadurl);
                } else if (getchapter.equals("Chapter 9")) {
                    loadurl = "https://drive.google.com/open?id=0B_U2dqDidq-0MUVydGZfQnE4Rlk";
                    funk(loadurl);
                } else if (getchapter.equals("Chapter 10")) {
                    loadurl = "https://drive.google.com/open?id=0B_U2dqDidq-0bUNIZURqTE1Sekk";
                    funk(loadurl);
                } else if (getchapter.equals("Chapter 11")) {
                    loadurl = "https://drive.google.com/open?id=0B_U2dqDidq-0dllYaHVzV2JsQ1k";
                    funk(loadurl);
                } else if (getchapter.equals("Chapter 12")) {
                    loadurl = "https://drive.google.com/open?id=0B_U2dqDidq-0bmlzdEtjSkliTk0";
                    funk(loadurl);
                } else if (getchapter.equals("Chapter 13")) {
                    loadurl = "https://drive.google.com/open?id=0B_U2dqDidq-0eVhJWGt4QUZRMkE";
                    funk(loadurl);
                } else if (getchapter.equals("Chapter 14")) {
                    loadurl = "https://drive.google.com/open?id=0B_U2dqDidq-0Y09fTllYLThJVzg";
                    funk(loadurl);
                } else if (getchapter.equals("Chapter 15")) {
                    loadurl = "https://drive.google.com/open?id=0B_U2dqDidq-0TmFzZzVHNjJ2cGs";
                    funk(loadurl);
                } else if (getchapter.equals("Chapter 16")) {
                    loadurl = "https://drive.google.com/open?id=0B_U2dqDidq-0LVc5S0p1TWRqSDg";
                    funk(loadurl);
                } else if (getchapter.equals("Chapter 17")) {
                    loadurl = "https://drive.google.com/open?id=0B_U2dqDidq-0R1VYdUpDdl8yV3M";
                    funk(loadurl);
                } else if (getchapter.equals("Chapter 18")) {
                    loadurl = "https://drive.google.com/open?id=0B_U2dqDidq-0bTBfeHU5NVVIcjQ";
                    funk(loadurl);
                } else {
                    Toast.makeText(this, "Invalid", Toast.LENGTH_SHORT).show();
                }

            }
        }
        else if (getclass.equals("Class 8")) {
            if (getsubject.equals("Maths")) {
                if (getchapter.equals("Chapter 1")) {
                    loadurl = "https://drive.google.com/open?id=0B_U2dqDidq-0cHpyMUQyN1gzejQ";
                    funk(loadurl);
                } else if (getchapter.equals("Chapter 2")) {
                    loadurl = "https://drive.google.com/open?id=0B_U2dqDidq-0NzFPVHBTWWJnTGM";
                    funk(loadurl);
                } else if (getchapter.equals("Chapter 3")) {
                    loadurl = "https://drive.google.com/open?id=0B_U2dqDidq-0LWgzM0NIdFUyTXc";
                    funk(loadurl);
                } else if (getchapter.equals("Chapter 4")) {
                    loadurl = "https://drive.google.com/open?id=0B_U2dqDidq-0ZThWWVhBYlI4blU";
                    funk(loadurl);
                } else if (getchapter.equals("Chapter 5")) {
                    loadurl = "https://drive.google.com/open?id=0B_U2dqDidq-0TUhOTFhfYXptSUU";
                    funk(loadurl);
                } else if (getchapter.equals("Chapter 6")) {
                    loadurl = "https://drive.google.com/open?id=0B_U2dqDidq-0MDlYY2lxbnN1SXM";
                    funk(loadurl);
                } else if (getchapter.equals("Chapter 7")) {
                    loadurl = "https://drive.google.com/open?id=0B_U2dqDidq-0b0dxT0tBaC1PWVk";
                    funk(loadurl);
                } else if (getchapter.equals("Chapter 8")) {
                    loadurl = "https://drive.google.com/open?id=0B_U2dqDidq-0MEtKcDdTMlJSSDQ";
                    funk(loadurl);
                } else if (getchapter.equals("Chapter 9")) {
                    loadurl = "https://drive.google.com/open?id=0B_U2dqDidq-0ZGNYNnRlQWJ4WGc";
                    funk(loadurl);
                } else if (getchapter.equals("Chapter 10")) {
                    loadurl = "https://drive.google.com/open?id=0B_U2dqDidq-0c0J3eVlMYjA2aG8";
                    funk(loadurl);
                } else if (getchapter.equals("Chapter 11")) {
                    loadurl = "https://drive.google.com/open?id=0B_U2dqDidq-0QkdwaFliaDJyQjg";
                    funk(loadurl);
                } else if (getchapter.equals("Chapter 12")) {
                    loadurl = "https://drive.google.com/open?id=0B_U2dqDidq-0TjQ0VjZhYXZ2MXM";
                    funk(loadurl);
                } else if (getchapter.equals("Chapter 13")) {
                    loadurl = "https://drive.google.com/open?id=0B_U2dqDidq-0eXZ2VHQ1TkxSams";
                    funk(loadurl);
                } else if (getchapter.equals("Chapter 14")) {
                    loadurl = "https://drive.google.com/open?id=0B_U2dqDidq-0bl9mdkdjd3ZmWlE";
                    funk(loadurl);
                } else if (getchapter.equals("Chapter 15")) {
                    loadurl = "https://drive.google.com/open?id=0B_U2dqDidq-0aFppeEpqaTFBRGM";
                    funk(loadurl);
                }
                else if (getchapter.equals("Chapter 16")) {
                    loadurl = "https://drive.google.com/open?id=0B_U2dqDidq-0RjlvY2RXTFQxRDQ";
                    funk(loadurl);
                }
                else {
                    Toast.makeText(this, "Invalid", Toast.LENGTH_SHORT).show();
                }

            }
            if (getsubject.equals("Science")) {
                if (getchapter.equals("Chapter 1")) {
                    loadurl = "https://drive.google.com/open?id=0B_U2dqDidq-0MzZ2VlV4MEk0SDg";
                    funk(loadurl);
                } else if (getchapter.equals("Chapter 2")) {
                    loadurl = "https://drive.google.com/open?id=0B_U2dqDidq-0Zy1YamRxV0NZczA";
                    funk(loadurl);
                } else if (getchapter.equals("Chapter 3")) {
                    loadurl = "https://drive.google.com/open?id=0B_U2dqDidq-0OUMzdnBXSnNLTmM";
                    funk(loadurl);
                } else if (getchapter.equals("Chapter 4")) {
                    loadurl = "https://drive.google.com/open?id=0B_U2dqDidq-0SGw2d2d2RU9VdzQ";
                    funk(loadurl);
                } else if (getchapter.equals("Chapter 5")) {
                    loadurl = "https://drive.google.com/open?id=0B_U2dqDidq-0ZG9wV1gtQm1UV00";
                    funk(loadurl);
                } else if (getchapter.equals("Chapter 6")) {
                    loadurl = "https://drive.google.com/open?id=0B_U2dqDidq-0OW51dU54LUdoZkE";
                    funk(loadurl);
                } else if (getchapter.equals("Chapter 7")) {
                    loadurl = "https://drive.google.com/open?id=0B_U2dqDidq-0YUZIYkxrNVdpR28";
                    funk(loadurl);
                } else if (getchapter.equals("Chapter 8")) {
                    loadurl="https://drive.google.com/open?id=0B_U2dqDidq-0WUloQVVQa2Jrdzg";
                    funk(loadurl);

                } else if (getchapter.equals("Chapter 9")) {
                    loadurl = "https://drive.google.com/open?id=0B_U2dqDidq-0T1N6RTJNcUJsdms";
                    funk(loadurl);
                } else if (getchapter.equals("Chapter 10")) {
                    loadurl = "https://drive.google.com/open?id=0B_U2dqDidq-0OXVyRDQ2TFZRWHc";
                    funk(loadurl);
                } else if (getchapter.equals("Chapter 11")) {
                    loadurl = "https://drive.google.com/open?id=0B_U2dqDidq-0U2ZIa3Awd1ZIWk0";
                    funk(loadurl);
                } else if (getchapter.equals("Chapter 12")) {
                    loadurl = "https://drive.google.com/open?id=0B_U2dqDidq-0c2VoU1JTOFpES28";
                    funk(loadurl);
                } else if (getchapter.equals("Chapter 13")) {
                    loadurl = "https://drive.google.com/open?id=0B_U2dqDidq-0VGV2UngtakVPazA";
                    funk(loadurl);
                } else if (getchapter.equals("Chapter 14")) {
                    loadurl = "https://drive.google.com/open?id=0B_U2dqDidq-0a0I5TEo1c3pTV0k";
                    funk(loadurl);
                } else if (getchapter.equals("Chapter 15")) {
                    loadurl = "https://drive.google.com/open?id=0B_U2dqDidq-0WlFDTWVpWk14eGM";
                    funk(loadurl);
                } else if (getchapter.equals("Chapter 16")) {
                    loadurl = "https://drive.google.com/open?id=0B_U2dqDidq-0MUo4eVkxNmlFT0k";
                    funk(loadurl);
                } else if (getchapter.equals("Chapter 17")) {
                    loadurl = "https://drive.google.com/open?id=0B_U2dqDidq-0NXZzQnhMU0Jia0k";
                    funk(loadurl);
                } else if (getchapter.equals("Chapter 18")) {
                    loadurl = "https://drive.google.com/open?id=0B_U2dqDidq-0MHlIX0liMzFhZFE";
                    funk(loadurl);
                } else {
                    Toast.makeText(this, "Invalid", Toast.LENGTH_SHORT).show();
                }

            }
        }
        else if (getclass.equals("Class 9")) {
            if (getsubject.equals("Maths")) {
                if (getchapter.equals("Chapter 1")) {
                    loadurl = "https://drive.google.com/open?id=0B_U2dqDidq-0REY0QzVXS3hLOVE";
                    funk(loadurl);
                } else if (getchapter.equals("Chapter 2")) {
                    loadurl = "https://drive.google.com/open?id=0B_U2dqDidq-0U3h1M1ZWSzB1S0k";
                    funk(loadurl);
                } else if (getchapter.equals("Chapter 3")) {
                    loadurl = "https://drive.google.com/open?id=0B_U2dqDidq-0NHU3bXAtbTRTRzA";
                    funk(loadurl);
                } else if (getchapter.equals("Chapter 4")) {
                    loadurl = "https://drive.google.com/open?id=0B_U2dqDidq-0ekdCYzcyTHR3OGc";
                    funk(loadurl);
                } else if (getchapter.equals("Chapter 5")) {
                    loadurl = "https://drive.google.com/open?id=0B_U2dqDidq-0ZVJ6cVJuTTlkQTQ";
                    funk(loadurl);
                } else if (getchapter.equals("Chapter 6")) {
                    loadurl = "https://drive.google.com/open?id=0B_U2dqDidq-0RlB5aXhwXzkyOUE";
                    funk(loadurl);
                } else if (getchapter.equals("Chapter 7")) {
                    loadurl = "https://drive.google.com/open?id=0B_U2dqDidq-0MlBqNDRYajRwZHc";
                    funk(loadurl);
                } else if (getchapter.equals("Chapter 8")) {
                    loadurl = "https://drive.google.com/open?id=0B_U2dqDidq-0aTBrMU1id1MzQjA";
                    funk(loadurl);
                } else if (getchapter.equals("Chapter 9")) {
                    loadurl = "https://drive.google.com/open?id=0B_U2dqDidq-0RHhUREZFTVlZZEE";
                    funk(loadurl);
                } else if (getchapter.equals("Chapter 10")) {
                    loadurl = "https://drive.google.com/open?id=0B_U2dqDidq-0S09LVk5LTmxWQ3c";
                    funk(loadurl);
                } else if (getchapter.equals("Chapter 11")) {
                    loadurl = "https://drive.google.com/open?id=0B_U2dqDidq-0NktwVmNwX3l1a1E";
                    funk(loadurl);
                } else if (getchapter.equals("Chapter 12")) {
                    loadurl = "https://drive.google.com/open?id=0B_U2dqDidq-0RXJIYjdRWWtJZlk";
                    funk(loadurl);
                } else if (getchapter.equals("Chapter 13")) {
                    loadurl = "https://drive.google.com/open?id=0B_U2dqDidq-0TjVrc3hKWm9Ea0U";
                    funk(loadurl);
                } else if (getchapter.equals("Chapter 14")) {
                    loadurl = "https://drive.google.com/open?id=0B_U2dqDidq-0bmp0bzF3aGRvUFE";
                    funk(loadurl);
                } else if (getchapter.equals("Chapter 15")) {
                    loadurl = "https://drive.google.com/open?id=0B_U2dqDidq-0Z3AtekxQMG5CaFU";
                    funk(loadurl);
                }

                else {
                    Toast.makeText(this, "Invalid", Toast.LENGTH_SHORT).show();
                }

            }
            if (getsubject.equals("Science")) {
                if (getchapter.equals("Chapter 1")) {
                    loadurl = "https://drive.google.com/open?id=0B_U2dqDidq-0OGJkWHo2SlM4QTg";
                    funk(loadurl);
                } else if (getchapter.equals("Chapter 2")) {
                    loadurl = "https://drive.google.com/open?id=0B_U2dqDidq-0aVhLRHBGM1pzcG8";
                    funk(loadurl);
                } else if (getchapter.equals("Chapter 3")) {
                    loadurl = "https://drive.google.com/open?id=0B_U2dqDidq-0NVFLd1RDd3VWdjQ";
                    funk(loadurl);
                } else if (getchapter.equals("Chapter 4")) {
                    loadurl = "https://drive.google.com/open?id=0B_U2dqDidq-0OGhkN192MDZ2dk0";
                    funk(loadurl);
                } else if (getchapter.equals("Chapter 5")) {
                    loadurl = "https://drive.google.com/open?id=0B_U2dqDidq-0dlZrM3FxRVhpalk";
                    funk(loadurl);
                } else if (getchapter.equals("Chapter 6")) {
                    loadurl = "https://drive.google.com/open?id=0B_U2dqDidq-0STNpR3ZDODNlR1k";
                    funk(loadurl);
                } else if (getchapter.equals("Chapter 7")) {
                    loadurl = "https://drive.google.com/open?id=0B_U2dqDidq-0bGZZX0ZNZVRYLTQ";
                    funk(loadurl);
                } else if (getchapter.equals("Chapter 8")) {
                    loadurl = "https://drive.google.com/open?id=0B_U2dqDidq-0TFhsc2c5bnFNQ2s";
                    funk(loadurl);
                } else if (getchapter.equals("Chapter 9")) {
                    loadurl = "https://drive.google.com/open?id=0B_U2dqDidq-0MXM0bndtMThjQTA";
                    funk(loadurl);
                } else if (getchapter.equals("Chapter 10")) {
                    loadurl = "https://drive.google.com/open?id=0B_U2dqDidq-0aTByTk5OUTdVS00";
                    funk(loadurl);
                } else if (getchapter.equals("Chapter 11")) {
                    loadurl = "https://drive.google.com/open?id=0B_U2dqDidq-0aW5sWmZMMU45SW8";
                    funk(loadurl);
                } else if (getchapter.equals("Chapter 12")) {
                    loadurl = "https://drive.google.com/open?id=0B_U2dqDidq-0eVZaTGdtcmVUdzQ";
                    funk(loadurl);
                } else if (getchapter.equals("Chapter 13")) {
                    loadurl = "https://drive.google.com/open?id=0B_U2dqDidq-0UEJoeDNlajdsWmc";
                    funk(loadurl);
                } else if (getchapter.equals("Chapter 14")) {
                    loadurl = "https://drive.google.com/open?id=0B_U2dqDidq-0c0x3Nzdxb0VLUEk";
                    funk(loadurl);
                } else if (getchapter.equals("Chapter 15")) {
                    loadurl = "https://drive.google.com/open?id=0B_U2dqDidq-0UFJIX0c5c3hPM2c";
                    funk(loadurl);
                } else {
                    Toast.makeText(this, "Invalid", Toast.LENGTH_SHORT).show();
                }

            }
        }
        else if (getclass.equals("Class 10")) {
            if (getsubject.equals("Maths")) {
                if (getchapter.equals("Chapter 1")) {
                    loadurl = "https://drive.google.com/open?id=0B_U2dqDidq-0Zml6aWd1VEZTQTQ";
                    funk(loadurl);
                } else if (getchapter.equals("Chapter 2")) {
                    loadurl = "https://drive.google.com/open?id=0B_U2dqDidq-0dkNRODN3bTdWV3M";
                    funk(loadurl);
                } else if (getchapter.equals("Chapter 3")) {
                    loadurl = "https://drive.google.com/open?id=0B_U2dqDidq-0Y3pBWHBRdG15MDQ";
                    funk(loadurl);
                } else if (getchapter.equals("Chapter 4")) {
                    loadurl = "https://drive.google.com/open?id=0B_U2dqDidq-0U0VhaVN0WTFiLWM";
                    funk(loadurl);
                } else if (getchapter.equals("Chapter 5")) {
                    loadurl = "https://drive.google.com/open?id=0B_U2dqDidq-0Qm8xQUZ0VlhFa00";
                    funk(loadurl);
                } else if (getchapter.equals("Chapter 6")) {
                    loadurl = "https://drive.google.com/open?id=0B_U2dqDidq-0d1ZxUkxhdDBraU0";
                    funk(loadurl);
                } else if (getchapter.equals("Chapter 7")) {
                    loadurl = "https://drive.google.com/open?id=0B_U2dqDidq-0QktxczRrTXFQMUk";
                    funk(loadurl);
                } else if (getchapter.equals("Chapter 8")) {
                    loadurl = "https://drive.google.com/open?id=0B_U2dqDidq-0WjJsbEx0bUwyZEk";
                    funk(loadurl);
                } else if (getchapter.equals("Chapter 9")) {
                    loadurl = "https://drive.google.com/open?id=0B_U2dqDidq-0ZWdHTVVKaXIxeWc";
                    funk(loadurl);
                } else if (getchapter.equals("Chapter 10")) {
                    loadurl = "https://drive.google.com/open?id=0B_U2dqDidq-0dVZXbHh6SDZIa0k";
                    funk(loadurl);
                } else if (getchapter.equals("Chapter 11")) {
                    loadurl = "https://drive.google.com/open?id=0B_U2dqDidq-0UTE1N2NpcWlWOGM";
                    funk(loadurl);
                } else if (getchapter.equals("Chapter 12")) {
                    loadurl = "https://drive.google.com/open?id=0B_U2dqDidq-0VWMwUXJtYVpSZDg";
                    funk(loadurl);
                } else if (getchapter.equals("Chapter 13")) {
                    loadurl = "https://drive.google.com/open?id=0B_U2dqDidq-0MWtMb0h2R1BTZVE";
                    funk(loadurl);
                } else if (getchapter.equals("Chapter 14")) {
                    loadurl = "https://drive.google.com/open?id=0B_U2dqDidq-0eWYtRWM4RWplQmM";
                    funk(loadurl);
                } else if (getchapter.equals("Chapter 15")) {
                    loadurl = "https://drive.google.com/open?id=0B_U2dqDidq-0RGd2NlZLTnJmMm8";
                    funk(loadurl);
                }
                else {
                    Toast.makeText(this, "Invalid", Toast.LENGTH_SHORT).show();
                }

            }
            if (getsubject.equals("Science")) {
                if (getchapter.equals("Chapter 1")) {
                    loadurl = "https://drive.google.com/open?id=0B_U2dqDidq-0T2ZBVlhlcTQ5azA";
                    funk(loadurl);
                } else if (getchapter.equals("Chapter 2")) {
                    loadurl = "https://drive.google.com/open?id=0B_U2dqDidq-0a0hjbGszdjRyTkk";
                    funk(loadurl);
                } else if (getchapter.equals("Chapter 3")) {
                    loadurl = "https://drive.google.com/open?id=0B_U2dqDidq-0eUkwdGVvQ2x4bm8";
                    funk(loadurl);
                } else if (getchapter.equals("Chapter 4")) {
                    loadurl = "https://drive.google.com/open?id=0B_U2dqDidq-0VWhaRmVJX1VGODQ";
                    funk(loadurl);
                } else if (getchapter.equals("Chapter 5")) {
                    loadurl = "https://drive.google.com/open?id=0B_U2dqDidq-0azBuQ2FQRTdacjg";
                    funk(loadurl);
                } else if (getchapter.equals("Chapter 6")) {
                    loadurl = "https://drive.google.com/open?id=0B_U2dqDidq-0b2FXRlpnc2VHOFk";
                    funk(loadurl);
                } else if (getchapter.equals("Chapter 7")) {
                    loadurl = "https://drive.google.com/open?id=0B_U2dqDidq-0bWVaRGhPZzZ3cDg";
                    funk(loadurl);
                } else if (getchapter.equals("Chapter 8")) {
                    loadurl = "https://drive.google.com/open?id=0B_U2dqDidq-0NnZrckFaaEJ2RTA";
                    funk(loadurl);
                } else if (getchapter.equals("Chapter 9")) {
                    loadurl = "https://drive.google.com/open?id=0B_U2dqDidq-0YzZIQ2hkVU9kb2c";
                    funk(loadurl);
                } else if (getchapter.equals("Chapter 10")) {
                    loadurl = "https://drive.google.com/open?id=0B_U2dqDidq-0N2t0c1ZyWXRFeTg";
                    funk(loadurl);
                } else if (getchapter.equals("Chapter 11")) {
                    loadurl = "https://drive.google.com/open?id=0B_U2dqDidq-0bDRFckExUDJEaE0";
                    funk(loadurl);
                } else if (getchapter.equals("Chapter 12")) {
                    loadurl = "https://drive.google.com/open?id=0B_U2dqDidq-0YThjSTFqR0szaFU";
                    funk(loadurl);
                } else if (getchapter.equals("Chapter 13")) {
                    loadurl = "https://drive.google.com/open?id=0B_U2dqDidq-0Q1k0bDByQ0tGdk0";
                    funk(loadurl);
                } else if (getchapter.equals("Chapter 14")) {
                    loadurl = "https://drive.google.com/open?id=0B_U2dqDidq-0bmVNN2VYU2JGS3c";
                    funk(loadurl);
                } else if (getchapter.equals("Chapter 15")) {
                    loadurl = "https://drive.google.com/open?id=0B_U2dqDidq-0dGFFUjAwekRLVU0";
                    funk(loadurl);
                } else if (getchapter.equals("Chapter 16")) {
                    loadurl = "https://drive.google.com/open?id=0B_U2dqDidq-0MFVEMVBST1ljTFk";
                    funk(loadurl);
                }  else {
                    Toast.makeText(this, "Invalid", Toast.LENGTH_SHORT).show();
                }

            }
        }
    }



    public void funk(String s)
    {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(s));
        startActivity(intent);
    }

    public class Mytimer extends TimerTask {
        @Override
        public void run() {
            Home_page.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if (vp.getCurrentItem() == 0)
                        vp.setCurrentItem(1);
                    else if (vp.getCurrentItem() == 1)
                        vp.setCurrentItem(2);
                    else if (vp.getCurrentItem() == 2)
                        vp.setCurrentItem(3);
                    else if (vp.getCurrentItem() == 3)
                        vp.setCurrentItem(4);
                    else if (vp.getCurrentItem() == 4)
                        vp.setCurrentItem(5);
                    else if (vp.getCurrentItem() == 5)
                        vp.setCurrentItem(6);
                    else if (vp.getCurrentItem() == 6)
                        vp.setCurrentItem(7);
                    else if (vp.getCurrentItem() == 7)
                        vp.setCurrentItem(8);
                    else
                        vp.setCurrentItem(0);
                }
            });
        }
    }
    public void displayInterstitial() {
// If Ads are loaded, show Interstitial else show nothing.
        if (interstitial.isLoaded()) {
            interstitial.show();
        }
    }


}