package com.lmlunadev.gymapp.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.lmlunadev.gymapp.R;
import com.lmlunadev.gymapp.adapters.RecyclerItemsAdapter;
import com.lmlunadev.gymapp.constants.ListenerConstants;
import com.lmlunadev.gymapp.listeners.NumericInputListener;
import com.lmlunadev.gymapp.model.TitleDescriptionItem;
import com.lmlunadev.gymapp.utils.DividerItemDecoration;

import java.util.ArrayList;

/**
 * Created by Luis on 26/01/2016.
 */
public class SetAdminFragment extends Fragment {

    protected ArrayList<TitleDescriptionItem> recyclerItems;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            /* Create list example items */
        this.recyclerItems = this.getItemList();
            /* Inflate the layout for this fragment */
        View inflatedView = this.getInflatedFragmentView(inflater, container);
        return inflatedView;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        FragmentActivity fragmentActivity = this.getActivity();

        if (fragmentActivity != null) {
            /* Rep count input with character filter */
            EditText input = (EditText) fragmentActivity.findViewById(R.id.set_rep_input);
            NumericInputListener listener = new NumericInputListener(NumericInputListener.Type.Integer, 0, 55);
            NumericInputListener[] inputFilters = new NumericInputListener[]{listener};
            input.setFilters(inputFilters);

            /* Recycler */
            RecyclerView recyclerView = this.getRecyclerView();
            recyclerView.setHasFixedSize(true);
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(fragmentActivity);
            linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
            recyclerView.setLayoutManager(linearLayoutManager);

            /* Items adapter */
            RecyclerItemsAdapter itemsAdapter = this.getItemsAdapter();
            recyclerView.setAdapter(itemsAdapter);

            /* Item separator */
            DividerItemDecoration itemDivider = new DividerItemDecoration(fragmentActivity, DividerItemDecoration.VERTICAL_LIST);
            recyclerView.addItemDecoration(itemDivider);
        }
    }

    /**
     * Overridable
     */
    protected RecyclerItemsAdapter getItemsAdapter() {
        RecyclerItemsAdapter result = new RecyclerItemsAdapter(this.getActivity(), this.recyclerItems, ListenerConstants.ContentType.SubSet);
        return result;
    }

    /**
     * Overridable
     */
    protected RecyclerView getRecyclerView() {
        RecyclerView result = (RecyclerView) this.getActivity().findViewById(R.id.exercise_subset_recicler);
        return result;
    }

    /**
     * Overridable
     */
    protected ArrayList<TitleDescriptionItem> getItemList() {
        short exerciseIndex = 0;
        short subsetIndex = 0;
        ArrayList<TitleDescriptionItem> itemList = new ArrayList<>();
        itemList.add(exerciseIndex++, new TitleDescriptionItem("Ejercicio " + exerciseIndex, "Descripcion de ejercicio " + exerciseIndex));
        itemList.add(subsetIndex++, new TitleDescriptionItem("Subset " + subsetIndex, "Subgrupo de ejercicios"));
        itemList.add(exerciseIndex++, new TitleDescriptionItem("Ejercicio " + exerciseIndex, "Descripcion de ejercicio " + exerciseIndex));
        itemList.add(exerciseIndex++, new TitleDescriptionItem("Ejercicio " + exerciseIndex, "Descripcion de ejercicio " + exerciseIndex));
        itemList.add(subsetIndex++, new TitleDescriptionItem("Subset " + subsetIndex, "Subgrupo de ejercicios"));
        return itemList;
    }

    /**
     * Overridable
     */
    protected View getInflatedFragmentView(LayoutInflater inflater, ViewGroup container) {
        return inflater.inflate(R.layout.set_admin, container, false);
    }
}
