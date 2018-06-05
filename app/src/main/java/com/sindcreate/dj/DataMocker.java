package com.sindcreate.dj;



import com.sindcreate.dj.model.DetailEntry;
import com.sindcreate.dj.model.Entry;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhouwei on 17/2/15.
 */

public class DataMocker {

    public static List<Entry> mockData(){
        List<Entry> entries = new ArrayList<>();
        Entry entry;
        for(int i=1;i<50;i++){
            entry = new Entry();


            if(i % 2 == 1){
                entry.type = Entry.TYPE_TEXT;
                entry.content = "This is Item "+i;
            }else{
                entry.type = Entry.TYPE_IMAGE;
                entry.imageUrl = "http://www.8kmm.com/UploadFiles/2012/8/201208140920132659.jpg";
            }

            entries.add(entry);
        }
        return entries;
    }


    public static List<Entry> mockMoreData(){
        List<Entry> entries = new ArrayList<>();
        Entry entry;
        for(int i=50;i<100;i++){
            entry = new Entry();
            if(i % 2 == 0){
                entry.type = Entry.TYPE_TEXT;
                entry.content = "This is Item "+i;
            }else{
                entry.type = Entry.TYPE_IMAGE;
                entry.imageUrl = "http://ww3.sinaimg.cn/large/610dc034gw1fbou2xsqpaj20u00u0q4h.jpg";
            }

            entries.add(entry);
        }
        return entries;
    }


    public static List<Entry> mockMoreDatamessage(){
        List<Entry> entries = new ArrayList<>();
        Entry entry;
        for(int i=1;i<5;i++){
            entry = new Entry();
            if(i % 2 == 0){
                entry.type = Entry.TYPE_MESSAGE;
                entry.flag1 = true;
            }else{
                entry.type = Entry.TYPE_MESSAGE;
                entry.flag1 =false;
            }

            entries.add(entry);
        }
        return entries;
    }

    public static List<String> getData(){
        List<String> data = new ArrayList<>();
        for(int i=0;i<20;i++){
            data.add("item "+i);
        }
        return data;
    }

    public static String[] images = {

            "https://ss0.bdstatic.com/94oJfD_bAAcT8t7mm9GUKT-xh_/timg?image&quality=100&size=b4000_4000&sec=1527844314&di=67466d8ccd64755508c49d7c0a6aa3d0&src=http://pic9.nipic.com/20100828/2116027_135158009416_2.jpg",
"https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1527854492722&di=09955f97898ef177bc290565b90d67a0&imgtype=0&src=http%3A%2F%2Fpic6.nipic.com%2F20100423%2F4692664_103320047067_2.jpg"
,"https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1527854492722&di=09955f97898ef177bc290565b90d67a0&imgtype=0&src=http%3A%2F%2Fpic6.nipic.com%2F20100423%2F4692664_103320047067_2.jpg"
            ,"https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1527854492722&di=09955f97898ef177bc290565b90d67a0&imgtype=0&src=http%3A%2F%2Fpic6.nipic.com%2F20100423%2F4692664_103320047067_2.jpg"
    };

    public static List<DetailEntry> mockStaggerData(){
        List<DetailEntry> detailEntries = new ArrayList<>();
        for(int i=0;i<100;i++){
            DetailEntry entry = new DetailEntry();
            entry.title = "this is item "+i;
            if(i % 3 == 0){
                entry.imageUrl = "http://www.8kmm.com/UploadFiles/2012/8/201208140920132659.jpg";

            }else{
                entry.imageUrl = "http://img2.3lian.com/2014/f2/37/d/40.jpg";
            }

            detailEntries.add(entry);
        }
        return detailEntries;
    }
}
