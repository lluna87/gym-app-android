package com.lmlunadev.gymapp.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lmlunadev.gymapp.R;
import com.lmlunadev.gymapp.adapters.RecyclerItemsAdapter;
import com.lmlunadev.gymapp.constants.ListenerConstants;
import com.lmlunadev.gymapp.model.TitleDescriptionItem;
import com.lmlunadev.gymapp.utils.DividerItemDecoration;

import java.util.ArrayList;

/**
 * Created by Luis on 16/01/2016.
 */
public class RoutineAdminFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            /* Inflate the layout for this fragment */
        return inflater.inflate(R.layout.routine_admin, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        FragmentActivity fragmentActivity = getActivity();

        if (fragmentActivity != null) {
            RecyclerView recyclerView = (RecyclerView) fragmentActivity.findViewById(R.id.sets_recicler);
            recyclerView.setHasFixedSize(true);
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(fragmentActivity);
            linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
            recyclerView.setLayoutManager(linearLayoutManager);

            ArrayList<TitleDescriptionItem> recyclerItems = new ArrayList<>();
            short index = 0;
            recyclerItems.add(index++, new TitleDescriptionItem("Item " + index, "Descripción de item " + index));
            recyclerItems.add(index++, new TitleDescriptionItem("Item " + index, "Descripción de item " + index));
            recyclerItems.add(index++, new TitleDescriptionItem("Item " + index, "Descripción de item " + index));
            recyclerItems.add(index++, new TitleDescriptionItem("Item " + index, "Descripción de item " + index));

            RecyclerItemsAdapter recyclerItemsAdapter = new RecyclerItemsAdapter(fragmentActivity, recyclerItems, ListenerConstants.ContentType.Set);
            recyclerView.setAdapter(recyclerItemsAdapter);

            DividerItemDecoration aas = new DividerItemDecoration(fragmentActivity, DividerItemDecoration.VERTICAL_LIST);
            recyclerView.addItemDecoration(aas);
        }
    }
}

