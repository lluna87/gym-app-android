package com.lmlunadev.gymapp.adapters;

import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.lmlunadev.gymapp.R;
import com.lmlunadev.gymapp.constants.ListenerConstants;
import com.lmlunadev.gymapp.model.TitleDescriptionItem;
import com.lmlunadev.gymapp.utils.ListItemViewHolder;

import java.util.ArrayList;

public class RecyclerItemsAdapter extends RecyclerView.Adapter<ListItemViewHolder> {

    private static final int TYPE_HEADER = 0;
    private static final int TYPE_ITEM = 1;
    private final ArrayList<TitleDescriptionItem> items;
    private final ListenerConstants.ContentType contentType;
    private FragmentActivity contextActivity;

    public RecyclerItemsAdapter(FragmentActivity passedContext, ArrayList<TitleDescriptionItem> items, ListenerConstants.ContentType contentType) {
        this.items = items;
        this.contextActivity = passedContext;
        this.contentType = contentType;
    }

    @Override
    public ListItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemContainer = inflater.inflate(R.layout.list_item, parent, false);
        ListItemViewHolder viewHolder = new ListItemViewHolder(itemContainer, contextActivity, this.contentType);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ListItemViewHolder holder, int position) {
        TextView titleFieldView = holder.getTitleField();
        TextView descriptionFieldView = holder.getDescriptionField();
        TitleDescriptionItem item = items.get(position);
        String titleText = item.getTitle();
        String description = item.getDescription();
        titleFieldView.setText(titleText);
        descriptionFieldView.setText(description);
        holder.setItem(item);
    }

    @Override
    public int getItemCount() {
        return this.items.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (isPositionHeader(position)) {
            return TYPE_HEADER;
        }
        return TYPE_ITEM;
    }

    private boolean isPositionHeader(int position) {
        return position == 0;
    }
}