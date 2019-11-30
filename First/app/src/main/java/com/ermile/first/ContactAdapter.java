package com.ermile.first;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class ContactAdapter extends ArrayAdapter {

    private List<MyContact> contacts;

    public ContactAdapter(@NonNull Context context, @NonNull List<MyContact> contacts) {
        super(context, R.layout.mycontact_list_item, contacts);

        this.contacts = contacts;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        MyContact contact = contacts.get(position);
        ViewHolder holder;
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.mycontact_list_item, parent, false);
            holder = new ViewHolder();
            holder.img_profile = convertView.findViewById(R.id.mycontact_pimg);
            holder.tv_phone = convertView.findViewById(R.id.mycontact_phone);
            holder.tv_name = convertView.findViewById(R.id.mycontact_name);
            holder.icsms = convertView.findViewById(R.id.mycontact_icsms);
            holder.iccall = convertView.findViewById(R.id.mycontact_iccall);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.fill(contact);
        return convertView;


//        View view = inflater.inflate(R.layout.mycontact_list_item, parent, false);
//        ImageView img_profile = view.findViewById(R.id.mycontact_pimg);
//        TextView tv_name = view.findViewById(R.id.mycontact_name);
//        TextView tv_phone = view.findViewById(R.id.mycontact_phone);
//
//        if (contact.getId() != 0){
//            img_profile.setImageResource(contact.getId());
//        }
//        tv_name.setText(contact.getName());
//        tv_phone.setText(contact.getPhonenumber());
//        return view;

    }


    private class ViewHolder implements View.OnClickListener {
        public ImageView img_profile;
        public TextView tv_name;
        public TextView tv_phone;
        public ImageView icsms, iccall;
//    if notfind on getView use from here else use on top


        //        public ViewHolder(View convertView){
//            img_profile = convertView.findViewById(R.id.mycontact_pimg);
//            tv_phone = convertView.findViewById(R.id.mycontact_phone);
//            tv_name = convertView.findViewById(R.id.mycontact_name);
//            icsms = convertView.findViewsWithText(R.id.mycontact_icsms);
//            iccall = convertView.findViewById(R.id.mycontact_iccall);
//        }
        public void fill(MyContact contact) {
            if (contact.getId() != 0) {
                img_profile.setImageResource(contact.getId());
            }
            tv_name.setText(contact.getName());
            tv_phone.setText(contact.getPhonenumber());
            iccall.setTag(contact.getPhonenumber());
            icsms.setTag(contact.getPhonenumber());
            icsms.setOnClickListener(this);
            iccall.setOnClickListener(this);
        }


        @Override
        public void onClick(View v) {
            String phone = (String) v.getTag();
            Intent intent = new Intent(Intent.ACTION_VIEW);
            if (v.equals(iccall)){
                intent.setData(Uri.parse("tel:" + phone));
                getContext().startActivity(intent);
            }else if (v.equals(icsms)){
                intent.setData(Uri.parse("sms:" + phone));
                getContext().startActivity(intent);
            }

        }
    }
}
