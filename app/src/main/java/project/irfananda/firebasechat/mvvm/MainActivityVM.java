package project.irfananda.firebasechat.mvvm;

import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;

import project.irfananda.firebasechat.R;
import project.irfananda.firebasechat.base.BaseVM;
import project.irfananda.firebasechat.databinding.ActivityMainBinding;
import project.irfananda.firebasechat.model.Message;

/**
 * Created by irfananda on 26/05/16.
 */
public class MainActivityVM extends BaseVM<MainController,ActivityMainBinding>{
    public MainActivityVM(AppCompatActivity activity, MainController controller, ActivityMainBinding binding) {
        super(activity, controller, binding);
    }

    public void addViewMessage(Message message){
        View v = mActivity.getLayoutInflater().inflate(R.layout.card_message, null);
        TextView txt_name = (TextView) v.findViewById(R.id.txt_name);
        TextView txt_message = (TextView) v.findViewById(R.id.txt_message);
        txt_name.setText(message.getName());
        txt_message.setText(message.getTextMessage());
        mBinding.chatContainer.addView(v);
    }

    public void onClickSend(View view){
        mController.writeToMessage(new Message(mBinding.bName.getText().toString(),mBinding.bMessage.getText().toString()));
        mBinding.bName.setText("");
        mBinding.bMessage.setText("");
    }

    public void isFinishLoadData(boolean finish){
        if(finish) {
            mBinding.bProgress.setVisibility(View.GONE);
            mBinding.bChatView.setVisibility(View.VISIBLE);
        }else{
            mBinding.bProgress.setVisibility(View.VISIBLE);
            mBinding.bChatView.setVisibility(View.GONE);
        }
    }
}
