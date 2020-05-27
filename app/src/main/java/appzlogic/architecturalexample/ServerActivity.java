package appzlogic.architecturalexample;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import appzlogic.architecturalexample.adapter.UserAdapter;
import appzlogic.architecturalexample.model.User;
import appzlogic.architecturalexample.databinding.ActivityServerBinding;
import appzlogic.architecturalexample.viewmodel.UserViewModel;

public class ServerActivity extends AppCompatActivity {

    private ActivityServerBinding activityServerBinding;
    private UserAdapter userAdapter;
    private List<User.ResponseBean.UsersBean> userList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityServerBinding = DataBindingUtil.setContentView(this,R.layout.activity_server);
        activityServerBinding.setUser(new appzlogic.architecturalexample.User("Jay shree ram"));
        activityServerBinding.setActivity(new ServerActivity());


        UserViewModel userViewModel = ViewModelProviders.of(this).get(UserViewModel.class);
        userViewModel.init();
        userViewModel.getUserRepository().observe(this, new Observer<User>() {
            @Override
            public void onChanged(User userResponse) {
                userList.addAll(userResponse.getResponse().getUsers());
                userAdapter.notifyDataSetChanged();

            }
        });
        setupRecyclerView();
    }

    private void setupRecyclerView(){
        if (userAdapter == null){
            userAdapter = new UserAdapter(userList, this);
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
            linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
            activityServerBinding.contentServer.recyclerView.setLayoutManager(linearLayoutManager);
            activityServerBinding.contentServer.recyclerView.setAdapter(userAdapter);
        }else {
            userAdapter.notifyDataSetChanged();
        }
    }

}
