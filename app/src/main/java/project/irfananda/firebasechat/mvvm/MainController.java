package project.irfananda.firebasechat.mvvm;

import android.os.Bundle;
import android.util.Log;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import project.irfananda.firebasechat.Constant;
import project.irfananda.firebasechat.base.BaseController;
import project.irfananda.firebasechat.databinding.ActivityMainBinding;
import project.irfananda.firebasechat.model.Message;

/**
 * Created by irfananda on 26/05/16.
 */
public class MainController extends BaseController<MainActivityVM,ActivityMainBinding>{

    public FirebaseDatabase firebaseDatabase;

    @Override
    public MainActivityVM createViewModel(ActivityMainBinding binding) {
        return new MainActivityVM(mActivity,this,binding);
    }

    @Override
    public void bindViewModel(ActivityMainBinding binding, MainActivityVM viewModel) {
        binding.setVm(viewModel);
    }

    @Override
    public void onCreateController(Bundle savedInstanceState) {
        super.onCreateController(savedInstanceState);
        firebaseDatabase = FirebaseDatabase.getInstance();
        addListenerToMessage();
    }

    public void addListenerToMessage() {
        DatabaseReference dMessage = firebaseDatabase.getReferenceFromUrl(Constant.FIREBASE_URL).child("message");
        mViewModel.isFinishLoadData(false);
        dMessage.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                Log.i("infoirfan","child added : "+dataSnapshot.getKey());
                Message message =dataSnapshot.getValue(Message.class);
                mViewModel.addViewMessage(message);
                mViewModel.isFinishLoadData(true);
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                Log.i("infoirfan","child change : "+dataSnapshot.getKey());
                mViewModel.isFinishLoadData(true);
            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {
                Log.i("infoirfan","child remove : "+dataSnapshot.getKey());
                mViewModel.isFinishLoadData(true);
            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {
                Log.i("infoirfan","child move : "+dataSnapshot.getKey());
                mViewModel.isFinishLoadData(true);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.i("infoirfan","error : "+databaseError.getMessage());
                mViewModel.isFinishLoadData(true);
            }
        });
    }

    public void writeToMessage(Message message) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String currentDateandTime = sdf.format(new Date());
        DatabaseReference dMessage = firebaseDatabase.getReferenceFromUrl(Constant.FIREBASE_URL);
        dMessage.child("message").child(currentDateandTime).setValue(message);
    }
}
