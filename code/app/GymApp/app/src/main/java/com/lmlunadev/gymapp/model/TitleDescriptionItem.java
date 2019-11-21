package com.lmlunadev.gymapp.model;

import android.content.Context;

import com.lmlunadev.gymapp.R;
import com.lmlunadev.gymapp.utils.CoreApp;

public class TitleDescriptionItem {

    private String title;
    private String description;

    public TitleDescriptionItem() {
    }

    public TitleDescriptionItem(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public String getTitle() {
        if (this.title != null){
            return this.title;
        }
        else {
            Context context = CoreApp.getContext();
            String result = context.getString(R.string.no_title_text);
            return result;
        }
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        if (this.description != null){
            return this.description;
        }
        else {
            Context context = CoreApp.getContext();
            String result = context.getString(R.string.no_description_text);
            return result;
        }
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString(){
        String result = "";

        if (this.title != null && !this.title.equals("")){
            result += this.title;
        }

        if (this.description != null && !this.description.equals("")) {
            result += ((!result.equals("")) ? ": " : "") + this.description;
        }

        if (result.equals("")){
            result = "Sin datos";
        }

        return result;
    }

}