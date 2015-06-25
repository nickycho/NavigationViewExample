package com.nickycho.navigationviewexample;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private DrawerLayout mDrawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        if (navigationView != null) {
            setupDrawerContent(navigationView);
        }

        TextView userNameTv = (TextView) findViewById(R.id.header_userNameTv);
        userNameTv.setText("Nicky Cho");

//        final LinearLayout newItemLl = (LinearLayout) findViewById(R.id.newItemLl);
//        final LinearLayout deleteItemLl = (LinearLayout) findViewById(R.id.deleteItemLl);
//        final LinearLayout renameItemLl = (LinearLayout) findViewById(R.id.renameItemLl);
//        newItemLl.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                mDrawerLayout.closeDrawers();
//                Toast.makeText(MainActivity.this, "newItemLl", Toast.LENGTH_LONG).show();
//            }
//        });
//
//        deleteItemLl.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                mDrawerLayout.closeDrawers();
//                Toast.makeText(MainActivity.this, "deleteItemLl", Toast.LENGTH_LONG).show();
//            }
//        });
//
//        renameItemLl.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                mDrawerLayout.closeDrawers();
//                Toast.makeText(MainActivity.this, "renameItemLl", Toast.LENGTH_LONG).show();
//            }
//        });





    }



    private void setupDrawerContent(NavigationView navigationView) {
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        menuItem.setChecked(true);
                        mDrawerLayout.closeDrawers();
                        switch (menuItem.getItemId()){
                            case R.id.nav_home:
                                makeToast("home");
                                break;
                            case R.id.nav_messages:
                                makeToast("messages");
                                break;
                            case R.id.nav_friends:
                                makeToast("friends");
                                break;
                            case R.id.nav_discussion:
                                makeToast("discussion");
                                break;
                        }
                        return true;
                    }
                });
    }

    private void makeToast(String message){
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
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
