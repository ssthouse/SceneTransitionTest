package com.ssthouse.myscenetransitiontest.activity;

import android.os.Bundle;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.ssthouse.myscenetransitiontest.R;
import com.ssthouse.myscenetransitiontest.model.Item;
import com.ssthouse.myscenetransitiontest.util.ViewHelper;
import com.ssthouse.myscenetransitiontest.view.style.TransparentStyle;

/**
 * 显示详细内容Activity
 * Created by ssthouse on 2015/8/27.
 */
public class DetailActivity extends AppCompatActivity {

    // Extra name for the ID parameter
    public static final String EXTRA_PARAM_ID = "detail:_id";

    // View name of the header image. Used for activity scene transitions
    public static final String VIEW_NAME_HEADER_IMAGE = "detail:header:image";

    // View name of the header title. Used for activity scene transitions
    public static final String VIEW_NAME_HEADER_TITLE = "detail:header:title";

    private ImageView mHeaderImageView;
    private TextView mHeaderTitle;

    private Item mItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);


        //initView()
        TransparentStyle.setTransparentStyle(this, R.color.color_primary);
        ViewHelper.initActionBar(this, getSupportActionBar(), "Transition");

        // Retrieve the correct Item instance, using the ID provided in the Intent
        mItem = Item.getItem(getIntent().getIntExtra(EXTRA_PARAM_ID, 0));

        mHeaderImageView = (ImageView) findViewById(R.id.id_iv);
        mHeaderTitle = (TextView) findViewById(R.id.id_tv_title);

        // BEGIN_INCLUDE(detail_set_view_name)
        /**
         * Set the name of the view's which will be transition to, using the static values above.
         * This could be done in the layout XML, but exposing it via static variables allows easy
         * querying from other Activities
         */
        ViewCompat.setTransitionName(mHeaderImageView, VIEW_NAME_HEADER_IMAGE);
        ViewCompat.setTransitionName(mHeaderTitle, VIEW_NAME_HEADER_TITLE);
        // END_INCLUDE(detail_set_view_name)

       loadFullSizeImage();
    }
    /**
     * Load the item's full-size image into our {@link ImageView}.
     */
    private void loadFullSizeImage() {
        Picasso.with(mHeaderImageView.getContext())
                .load(mItem.getPhotoUrl())
                .noFade()
                .placeholder(R.mipmap.ic_launcher)
                .into(mHeaderImageView);
    }
}
