package appzlogic.architecturalexample.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.library.baseAdapters.BR;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import appzlogic.architecturalexample.R;
import appzlogic.architecturalexample.databinding.UserItemBinding;
import appzlogic.architecturalexample.model.User;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder>{

    private List<User.ResponseBean.UsersBean> userModelList;
    private Context context;

    public UserAdapter(List<User.ResponseBean.UsersBean> userModelList, Context context) {
        this.userModelList = userModelList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        UserItemBinding userItemBinding = DataBindingUtil.inflate(LayoutInflater.from(viewGroup.getContext()),
                R.layout.user_item, viewGroup, false);
        return new ViewHolder(userItemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int position) {

        /*viewHolder.textName.setText(userModelList.get(position).firstName);
        viewHolder.textMobile.setText(userModelList.get(position).lastName);
        viewHolder.textEmpId.setText(userModelList.get(position).role);*/
        User.ResponseBean.UsersBean user = userModelList.get(position);
        viewHolder.bind(user);
    }

    @Override
    public int getItemCount() {
        return userModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        /*private TextView textName, textEmpId, textMobile, textDate, textLocation, textTemp, textStatus;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textName = itemView.findViewById(R.id.textName);
            textEmpId = itemView.findViewById(R.id.textEmpId);
            textMobile = itemView.findViewById(R.id.textMobile);
            textDate = itemView.findViewById(R.id.textDate);
            textLocation = itemView.findViewById(R.id.textLocation);
            textTemp = itemView.findViewById(R.id.textTemp);
            textStatus = itemView.findViewById(R.id.textStatus);
        }*/
        public UserItemBinding userItemBinding;
        public ViewHolder(UserItemBinding userItemBinding){
            super(userItemBinding.getRoot());
            this.userItemBinding = userItemBinding;
        }
        public void bind(Object object){
            userItemBinding.setVariable(BR.user, object);
            userItemBinding.executePendingBindings();
        }
    }
}
