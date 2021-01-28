package com.example.project1.entities;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "person")
public class Person
{
    @PrimaryKey (autoGenerate = true)
     int ID;
     String Name;
     String Phone;
     String Area;
     String Address;
     String City;
     String State;
     String Zip;
     String Email;
     String Birthday;


    public Person (int ID, String Name, String Phone, String Area, String Address, String City, String State, String Zip,
    String Email, String Birthday)
    {
        this.ID = ID;
        this.Name = Name;
         this.Phone = Phone;
         this.Area = Area;
         this.Address = Area;
         this.City = City;
         this.State = State;
         this.Zip = Zip;
         this.Email = Email;
         this.Birthday = Birthday;
    }

  @Ignore
  public Person (String Name, String Phone, String Area, String Address, String City, String State, String Zip,
                 String Email, String Birthday)
  {
      this.Name = Name;
      this.Phone = Phone;
      this.Area = Area;
      this.Address = Area;
      this.City = City;
      this.State = State;
      this.Zip = Zip;
      this.Email = Email;
      this.Birthday = Birthday;
  }


    public void setID(int ID) {
        this.ID = ID;
    }

    public int getID() {
        return ID;
    }

    public void setName (String Name)
    {
        Name = this.Name;
    }

    public String getName ()
    {
        return Name;
    }

    public void setPhone (String Phone)
    {
        Phone = this.Phone;
    }

    public String getPhone ()
    {
        return Phone;
    }

    public void setArea (String Area)
    {
        Area = this.Area;
    }

    public String getArea ()
    {
        return Area;
    }

    public void setAddress (String Address)
    {
        Address = this.Address;
    }

    public String getAddress ()
    {
       return  Address;
    }

    public void setCity (String City)
    {
        City = this.City;
    }

    public String getCity()
    {
       return City;
    }

    public void setState(String State) {
        State = this.State;
    }

    public String getState() {
        return State;
    }

    public void setZip(String Zip) {
        Zip = this.Zip;
    }

    public String getZip() {
        return Zip;
    }

    public void setEmail(String Email) {
        Email = this.Email;
    }

    public String getEmail() {
        return Email;
    }

    public void setBirthday(String Birthday) {
        Birthday = this.Birthday;
    }

    public String getBirthday() {
        return Birthday;
    }
}
