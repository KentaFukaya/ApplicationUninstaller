package com.example.himawari.applicationuninstaller;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Date;

/**
 * Created by b1014100_2 on 2017/01/16.
 */

public class ApplicationListAdapter extends ArrayAdapter<PackageInfo> {

    LayoutInflater mInflater;
    PackageManager packageManager;

    public ApplicationListAdapter(Context context) {
        super(context, 0);
        mInflater = LayoutInflater.from(context);
        packageManager = context.getPackageManager();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.applicationlistitem, parent, false);
        }

        PackageInfo info = getItem(position);

        ImageView icon = (ImageView) convertView.findViewById(R.id.application_icon);
        icon.setImageDrawable(info.applicationInfo.loadIcon(packageManager));

        TextView name = (TextView) convertView.findViewById(R.id.application_name);
        name.setText(info.applicationInfo.loadLabel(packageManager));

        Date date = new Date(info.firstInstallTime);

        TextView time = (TextView)convertView.findViewById(R.id.application_downloadtime);
        time.setText(date.toString());

        return convertView;
    }
}