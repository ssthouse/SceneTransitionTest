package com.ssthouse.myscenetransitiontest.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.ssthouse.myscenetransitiontest.R;
import com.ssthouse.myscenetransitiontest.model.Item;
import com.ssthouse.myscenetransitiontest.util.ViewHelper;
import com.ssthouse.myscenetransitiontest.view.adapter.MainGridAdapter;
import com.ssthouse.myscenetransitiontest.view.style.TransparentStyle;

public class MainActivity extends AppCompatActivity {

    private GridView gv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    private void initView(){
        TransparentStyle.setTransparentStyle(this, R.color.color_primary);
        ViewHelper.initActionBar(this, getSupportActionBar(), "Transition");

        gv = (GridView) findViewById(R.id.id_gv);
        gv.setAdapter(new MainGridAdapter(this));

        gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                Item item = (Item) parent.getItemAtPosition(position);

                // Construct an Intent as normal
                Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                intent.putExtra(DetailActivity.EXTRA_PARAM_ID, item.getId());

                // BEGIN_INCLUDE(start_activity)
                /**
                 * Now create an {@link android.app.ActivityOptions} instance using the
                 * {@link ActivityOptionsCompat#makeSceneTransitionAnimation(Activity, Pair[])} factory
                 * method.
                 */
                ActivityOptionsCompat activityOptions = ActivityOptionsCompat.makeSceneTransitionAnimation(
                        MainActivity.this,
                        // Now we provide a list of Pair items which contain the view we can transitioning
                        // from, and the name of the view it is transitioning to, in the launched activity
                        new Pair<View, String>(view.findViewById(R.id.id_iv),
                                DetailActivity.VIEW_NAME_HEADER_IMAGE),
                        new Pair<View, String>(view.findViewById(R.id.id_tv),
                                DetailActivity.VIEW_NAME_HEADER_TITLE));

                // Now we can start the Activity, providing the activity options as a bundle
                ActivityCompat.startActivity(MainActivity.this, intent, activityOptions.toBundle());
                // END_INCLUDE(start_activity)
            }
        });
    }

    private void beginTransition(){

    }
}
