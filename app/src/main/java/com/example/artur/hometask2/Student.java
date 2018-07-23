package com.example.artur.hometask2;

import android.os.Parcel;
import android.os.Parcelable;

public class Student implements Parcelable {


        public String FirstName;
        public String LastName;
        public int Age;
        public String Age1;

    public Student(String firstName, String lastName, int age){
        FirstName = firstName;
        LastName = lastName;
        Age = age;
    }

    public Student() {
    }

    public Student(String firstName, String lastName, String age1) {
        FirstName = firstName;
        LastName = lastName;
        Age1 = age1;
    }

    public String toFname(){
        return String.format("First Name: %s", FirstName);
    }

    public String toLname(){
        return String.format("Last Name: %s", LastName);
    }

    public String toAge(){
        return String.format("Age is %d", Age);
    }

    public String toFname1(){
        return String.format("%s", FirstName);
    }

    public String toFname2(String s){
        return String.format("%s", FirstName);
    }

    public String toLname1(){
        return String.format("%s", LastName);
    }
    public String toLname2(String s){
        return String.format("%s", LastName);
    }

    public String toAge1(){
        return String.format("%s", Age);
    }

    public String toAge2(String s){
        return String.format("%s", Age);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.FirstName);
        dest.writeString(this.LastName);
        dest.writeInt(this.Age);
    }

    protected Student(Parcel in) {
        this.FirstName = in.readString();
        this.LastName = in.readString();
        this.Age = in.readInt();
    }

    public static final Creator<Student> CREATOR = new Creator<Student>() {
        @Override
        public Student createFromParcel(Parcel source) {
            return new Student(source);
        }

        @Override
        public Student[] newArray(int size) {
            return new Student[size];
        }
    };
}
