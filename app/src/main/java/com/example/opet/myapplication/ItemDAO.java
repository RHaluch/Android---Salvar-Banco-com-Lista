package com.example.opet.myapplication;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;
/**
 * Created by opet on 02/10/2019.
 */
@Dao
public interface ItemDAO {

    @Query("select * from item")
    public List<Item> getAll();

    @Insert
    public long insert(Item item);
}
