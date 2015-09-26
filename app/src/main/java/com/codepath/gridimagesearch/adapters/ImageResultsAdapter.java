package com.codepath.gridimagesearch.adapters;

import android.content.Context;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.codepath.gridimagesearch.R;
import com.codepath.gridimagesearch.models.ImageResult;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Andre on 9/24/2015.
 */
public class ImageResultsAdapter extends ArrayAdapter<ImageResult>{

    public ImageResultsAdapter(Context context, List<ImageResult> images) {
        super(context, R.layout.item_image_result, images);

        //super(context, android.R.layout.simple_list_item_1, images);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageResult imageInfo = getItem(position);
        if(convertView == null){
            convertView = LayoutInflater.from((getContext())).inflate(R.layout.item_image_result,
                    parent,
                    false);// postpones attach


        }
        ImageView ivImage = (ImageView)convertView.findViewById(R.id.ivImage);
        TextView tvTitle = (TextView)convertView.findViewById(R.id.tvTitle);

        // Clear out image from last time
        ivImage.setImageResource(0);
        // populate title and remote dowwnload image url
        //tvTitle.setText(imageInfo.title);
        tvTitle.setText(Html.fromHtml(imageInfo.title));

                // remotaly download the image data in the background (with Picasso)
                Picasso.with(getContext()).load(imageInfo.thumUrl).into(ivImage);
        // return compleated view
        return convertView;
    }
}
