package com.mobileappscompany.android.trainerapp;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;
import com.mobileappscompany.android.trainerapplibrary.fragments.SlidingTabsTraineeFragment;
import com.mobileappscompany.android.trainerapplibrary.views.adapters.TraineeCardAdapter;
import com.mobileappscompany.android.trainerapplibrary.views.custom_views.TraineeHeader;
import com.mobileappscompany.android.trainerapplibrary.views.custom_views.models.ListOfTabs;
import com.mobileappscompany.android.trainerapplibrary.views.custom_views.models.SingleTab;
import com.mobileappscompany.android.trainerapplibrary.views.listeners.ColorChangeListener;


import com.mikepenz.iconics.typeface.FontAwesome;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.model.DividerDrawerItem;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.SecondaryDrawerItem;
import com.mikepenz.materialdrawer.model.SectionDrawerItem;


/**
 * A simple launcher activity containing a summary sample description, sample log and a custom
 * {@link android.support.v4.app.Fragment} which can display a view.
 * <p>
 * For devices with displays with a width of 720dp or greater, the sample log is always visible,
 * on other devices it's visibility is controlled by an item on the Action Bar.
 */
public class TraineeActivity extends ActionBarActivity  {

    public static final String TAG = "TraineeActivity";
    private ViewPager viewPager;
    private Drawer.Result result = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.mobileappscompany.android.trainerapp.R.layout.activity_trainee);

        Toolbar mToolbar = (Toolbar) findViewById(R.id.trainee_toolbar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        result = new Drawer()
                .withActivity(this)
                .withToolbar(mToolbar)
                .withActionBarDrawerToggle(true)
                .withHeader(R.layout.header)
                .addDrawerItems(
                        new PrimaryDrawerItem().withName(R.string.drawer_item_home).withIcon(FontAwesome.Icon.faw_home).withIdentifier(1),
                        new PrimaryDrawerItem().withName("Tasks").withIcon(FontAwesome.Icon.faw_file),
                        new PrimaryDrawerItem().withName("Issues").withIcon(FontAwesome.Icon.faw_warning).withIdentifier(2),
                        new SectionDrawerItem().withName("Trainees"),
                        new SecondaryDrawerItem().withName("John Doe"),
                        new SecondaryDrawerItem().withName("Carlos Lopez"),
                        new SecondaryDrawerItem().withName("Scott Smith"),
                        new SecondaryDrawerItem().withName("Davy Jones"),
                        new SectionDrawerItem().withName("Personal Information"),
                        new SecondaryDrawerItem().withName(R.string.drawer_item_help).withIcon(FontAwesome.Icon.faw_question),
                        new SecondaryDrawerItem().withName(R.string.drawer_item_contact).withIcon(FontAwesome.Icon.faw_bullhorn)
                )
                .withOnDrawerListener(new Drawer.OnDrawerListener() {
                    @Override
                    public void onDrawerOpened(View drawerView) {
                        // Toast.makeText(TraineeActivity.this, "onDrawerOpened", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onDrawerClosed(View drawerView) {
                        // Toast.makeText(TraineeActivity.this, "onDrawerClosed", Toast.LENGTH_SHORT).show();
                    }
                })
                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id, IDrawerItem drawerItem) {
                        if (drawerItem instanceof PrimaryDrawerItem) {
                            PrimaryDrawerItem di = (PrimaryDrawerItem) drawerItem;

                            Toast.makeText(TraineeActivity.this, TraineeActivity.this.getString(di.getNameRes()), Toast.LENGTH_SHORT).show();

                            if (di.getBadge() != null) {
                                //note don't do this if your badge contains a "+"
                                int badge = Integer.valueOf(di.getBadge());
                                if (badge > 0) {
                                    di.withBadge(String.valueOf(badge - 1));
                                    result.updateItem(di);
                                }
                            }
                        }
                    }
                })
                .withOnDrawerItemLongClickListener(new Drawer.OnDrawerItemLongClickListener() {
                    @Override
                    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id, IDrawerItem drawerItem) {
                        if (drawerItem instanceof SecondaryDrawerItem) {
                            Toast.makeText(TraineeActivity.this, TraineeActivity.this.getString(((SecondaryDrawerItem) drawerItem).getNameRes()), Toast.LENGTH_SHORT).show();
                        }
                        return false;
                    }
                }).build();

        TraineeHeader header = (TraineeHeader)findViewById(R.id.trainee_header);
        header.setFirstName("John");
        header.setLastName("Doe");
        header.setTechnology("Android");
        header.setTraineeAvatar(getResources().getDrawable(R.drawable.bunissesman));

        // BEGIN_INCLUDE (setup_viewpager)
        // Get the ViewPager and set it's PagerAdapter so that it can display items
        ListOfTabs tabs = setupTabs();
        viewPager = (ViewPager)findViewById(com.mobileappscompany.android.trainerapp.R.id.viewpager);
        TraineeCardAdapter adapter = new TraineeCardAdapter(getSupportFragmentManager());
        adapter.setTabs(tabs.getTabs());
        viewPager.setAdapter(adapter);

        ColorChangeListener mColorListener = new ColorChangeListener(this);
        mColorListener.setViewPager(viewPager);
        mColorListener.setActionBar(getSupportActionBar());

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        SlidingTabsTraineeFragment fragment = new SlidingTabsTraineeFragment();
        fragment.setColorListener(mColorListener);
        fragment.setViewPager(viewPager);
        Bundle bundle = new Bundle();
        bundle.putParcelable(SlidingTabsTraineeFragment.TAB_ARGUMENTS, tabs);
        fragment.setArguments(bundle);
        transaction.replace(com.mobileappscompany.android.trainerapp.R.id.sample_content_fragment, fragment);
        transaction.commit();
    }

    @Override
    public void setTitle(CharSequence title) {
        CharSequence ch = "St";
        getSupportActionBar().setTitle(ch);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = new MenuInflater(this);
        inflater.inflate(R.menu.menu_trainee, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    private ListOfTabs setupTabs() {
        ListOfTabs tabs = new ListOfTabs(
                new SingleTab(
                        getString(R.string.tab_home), // Title
                        getResources().getColor(R.color.indigo_500), // Indicator color
                        getResources().getColor(R.color.blue_grey_500), // Divider color
                        getResources().getColor(R.color.indigo_100), // Background color
                        getResources().getColor(R.color.indigo_700)
                ),
                new SingleTab(
                        getString(R.string.tab_tasks), // Title
                        getResources().getColor(R.color.green_500), // Indicator color
                        getResources().getColor(R.color.blue_grey_500), // Divider color
                        getResources().getColor(R.color.green_100), // Background color
                        getResources().getColor(R.color.green_700)
                ),
                new SingleTab(
                        getString(R.string.tab_exams), // Title
                        getResources().getColor(R.color.orange_500), // Indicator color
                        getResources().getColor(R.color.blue_grey_500), // Divider color
                        getResources().getColor(R.color.orange_100), // Background color
                        getResources().getColor(R.color.orange_700)
                )
        );
        return tabs;
    }
}
