package appzlogic.architecturalexample.model;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.library.baseAdapters.BR;
import java.util.List;

public class User extends BaseObservable {


    /**
     * description : All users.
     * response : {"users":[{"userId":2,"firstName":"Satyendra","lastName":"babu","photoUrl":null,"hairType":"Curly","youAdmired":false,"admirersCount":0,"role":"NORMAL"},{"userId":3,"firstName":"Satyendra","lastName":"babu","photoUrl":"https://s3.us-east-2.amazonaws.com/rhytrx-data/SATYENDRABABU1585057208.364855profileImg","hairType":"Curly","youAdmired":false,"admirersCount":0,"role":"NORMAL"},{"userId":4,"firstName":"Satyendra","lastName":"babu","photoUrl":"https://rhytrx-data.s3.us-east-2.amazonaws.com/cropped5882706360182777208.jpg","hairType":"Curly","youAdmired":false,"admirersCount":0,"role":"NORMAL"},{"userId":119,"firstName":"satyendra","lastName":"sharma","photoUrl":null,"hairType":"Waves","youAdmired":false,"admirersCount":0,"role":"STYLIST"}],"totalData":0,"totalPage":0}
     */

    private String description;
    private ResponseBean response;

    @Bindable
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
        notifyPropertyChanged(BR.description);
    }

    @Bindable
    public ResponseBean getResponse() {
        return response;
    }

    public void setResponse(ResponseBean response) {
        this.response = response;
        notifyPropertyChanged(BR.response);
    }

    public static class ResponseBean extends BaseObservable {
        /**
         * users : [{"userId":2,"firstName":"Satyendra","lastName":"babu","photoUrl":null,"hairType":"Curly","youAdmired":false,"admirersCount":0,"role":"NORMAL"},{"userId":3,"firstName":"Satyendra","lastName":"babu","photoUrl":"https://s3.us-east-2.amazonaws.com/rhytrx-data/SATYENDRABABU1585057208.364855profileImg","hairType":"Curly","youAdmired":false,"admirersCount":0,"role":"NORMAL"},{"userId":4,"firstName":"Satyendra","lastName":"babu","photoUrl":"https://rhytrx-data.s3.us-east-2.amazonaws.com/cropped5882706360182777208.jpg","hairType":"Curly","youAdmired":false,"admirersCount":0,"role":"NORMAL"},{"userId":119,"firstName":"satyendra","lastName":"sharma","photoUrl":null,"hairType":"Waves","youAdmired":false,"admirersCount":0,"role":"STYLIST"}]
         * totalData : 0
         * totalPage : 0
         */

        private int totalData;
        private int totalPage;
        private List<UsersBean> users;

        @Bindable
        public int getTotalData() {
            return totalData;
        }

        public void setTotalData(int totalData) {
            this.totalData = totalData;
            notifyPropertyChanged(BR.totalData);
        }

        @Bindable
        public int getTotalPage() {
            return totalPage;
        }

        public void setTotalPage(int totalPage) {
            this.totalPage = totalPage;
            notifyPropertyChanged(BR.totalPage);
        }

        @Bindable
        public List<UsersBean> getUsers() {
            return users;
        }

        public void setUsers(List<UsersBean> users) {
            this.users = users;
            notifyPropertyChanged(BR.users);
        }

        public static class UsersBean extends BaseObservable {
            /**
             * userId : 2
             * firstName : Satyendra
             * lastName : babu
             * photoUrl : null
             * hairType : Curly
             * youAdmired : false
             * admirersCount : 0
             * role : NORMAL
             */

            private int userId;
            public String firstName;
            public String lastName;
            public Object photoUrl;
            private String hairType;
            private boolean youAdmired;
            private int admirersCount;
            public String role;

            @Bindable
            public int getUserId() {
                return userId;
            }

            public void setUserId(int userId) {
                this.userId = userId;
                notifyPropertyChanged(BR.userId);
            }

            @Bindable
            public String getFirstName() {
                return firstName;
            }

            public void setFirstName(String firstName) {
                this.firstName = firstName;
                notifyPropertyChanged(BR.firstName);
            }

            @Bindable
            public String getLastName() {
                return lastName;
            }

            public void setLastName(String lastName) {
                this.lastName = lastName;
                notifyPropertyChanged(BR.lastName);
            }

            @Bindable
            public Object getPhotoUrl() {
                return photoUrl;
            }

            public void setPhotoUrl(Object photoUrl) {
                this.photoUrl = photoUrl;
                notifyPropertyChanged(BR.photoUrl);
            }

            @Bindable
            public String getHairType() {
                return hairType;
            }

            public void setHairType(String hairType) {
                this.hairType = hairType;
                notifyPropertyChanged(BR.hairType);
            }

            @Bindable
            public boolean isYouAdmired() {
                return youAdmired;
            }

            public void setYouAdmired(boolean youAdmired) {
                this.youAdmired = youAdmired;
                notifyPropertyChanged(BR.youAdmired);
            }

            @Bindable
            public int getAdmirersCount() {
                return admirersCount;
            }

            public void setAdmirersCount(int admirersCount) {
                this.admirersCount = admirersCount;
                notifyPropertyChanged(BR.admirersCount);
            }

            @Bindable
            public String getRole() {
                return role;
            }

            public void setRole(String role) {
                this.role = role;
                notifyPropertyChanged(BR.role);
            }
        }
    }
}
