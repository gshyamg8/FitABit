package com.hp.fitabit.Home;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.hp.fitabit.Profile.ProfileFragment;
import com.hp.fitabit.R;
import com.hp.fitabit.models.User;

import java.util.List;



public class UserList extends ArrayAdapter<User> {
    private Activity context;
    private List<User> list4;
    TextView a,b;

    public UserList(Activity context, List<User> list4)
    {
        super(context,R.layout.list_layout,list4);
        this.context=context;
        this.list4=list4;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = context.getLayoutInflater();

        View view = layoutInflater.inflate(R.layout.list_layout,null,true);
        a=(TextView)view.findViewById(R.id.textView1);
        b=(TextView)view.findViewById(R.id.textView2);
//        int x=getFollowersCount2();
        User user = list4.get(position);
        a.setText(user.getEmail());
        b.setText(user.getUsername());

        return  view;




    }
}
