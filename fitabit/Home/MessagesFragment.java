package com.hp.fitabit.Home;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.hp.fitabit.R;
import com.hp.fitabit.models.User;

import java.util.ArrayList;
import java.util.List;


public class MessagesFragment extends Fragment {
    private static final String TAG = "MessagesFragment";
    DatabaseReference dbref;
    ListView userList;
    List<User> list2;

    @Override
    public void onStart() {
        super.onStart();
        dbref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                list2.clear();
                for(DataSnapshot followerSnapshot : dataSnapshot.getChildren())
                {
                    User u = followerSnapshot.getValue(User.class);
                    list2.add(u);

                    UserList adapter = new UserList(getActivity(),list2);
                    userList.setAdapter(adapter);

                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_messages, container, false);

        dbref = FirebaseDatabase.getInstance().getReference("users");
        userList=(ListView)view.findViewById(R.id.lv);
        list2 = new ArrayList<>();

        return view;
    }
}
