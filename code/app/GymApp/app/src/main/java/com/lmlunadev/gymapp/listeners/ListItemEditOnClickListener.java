package com.lmlunadev.gymapp.listeners;

import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.widget.FrameLayout;

import com.lmlunadev.gymapp.R;
import com.lmlunadev.gymapp.constants.ListenerConstants;
import com.lmlunadev.gymapp.fragments.SetAdminFragment;
import com.lmlunadev.gymapp.fragments.SubSetAdminFragment;
import com.lmlunadev.gymapp.utils.FragmentConstants;

/**
 * Created by Luis on 26/01/2016.
 */
public class ListItemEditOnClickListener implements View.OnClickListener {

    private FragmentActivity contextActivity;
    private ListenerConstants.ContentType contentType;

    public ListItemEditOnClickListener(FragmentActivity contextActivity, ListenerConstants.ContentType contentType) {
        this.contextActivity = contextActivity;
        this.contentType = contentType;
    }

    @Override
    public void onClick(View v) {
        switch (this.contentType){
            case Set: this.createSetContent();
            break;
            case SubSet: this.createSubSetContent();
                break;
            case Exercise: this.createExerciseContent();
                break;
        }
    }

    private void createSetContent() {
        SetAdminFragment firstFragment = new SetAdminFragment();
        FrameLayout container = (FrameLayout) this.contextActivity.findViewById(R.id.main_content_fragment_frame);
        container.removeAllViews();
        FragmentManager fragmentManager = this.contextActivity.getSupportFragmentManager();
        FragmentsBackStackListener backStackListener = new FragmentsBackStackListener();
        fragmentManager.addOnBackStackChangedListener(backStackListener);

        /* Add the fragment to the 'main_content_fragment' FrameLayout */
        fragmentManager.beginTransaction().add(R.id.main_content_fragment_frame, firstFragment)
                .addToBackStack(FragmentConstants.SetAdminTag).commit();
    }

    private void createSubSetContent() {
        SubSetAdminFragment firstFragment = new SubSetAdminFragment();
        FrameLayout container = (FrameLayout) this.contextActivity.findViewById(R.id.main_content_fragment_frame);
        container.removeAllViews();
        FragmentManager fragmentManager = this.contextActivity.getSupportFragmentManager();
        FragmentsBackStackListener backStackListener = new FragmentsBackStackListener();
        fragmentManager.addOnBackStackChangedListener(backStackListener);

        /* Add the fragment to the 'main_content_fragment' FrameLayout */
        fragmentManager.beginTransaction().add(R.id.main_content_fragment_frame, firstFragment)
                .addToBackStack(FragmentConstants.SubSetAdminTag).commit();
    }

    private void createExerciseContent() {

    }


}
