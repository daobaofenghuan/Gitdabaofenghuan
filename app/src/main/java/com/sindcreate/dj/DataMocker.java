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

"http://p2.img.cctvpic.com/photoAlbum/page/performance/img/2017/11/17/1510882755358_744.jpg",
            "http://p2.img.cctvpic.com/photoAlbum/page/performance/img/2017/11/13/1510541227985_359.jpg",
            "http://p1.img.cctvpic.com/photoAlbum/page/performance/img/2017/10/25/1508896314079_178.jpg",
            "http://p2.img.cctvpic.com/photoAlbum/page/performance/img/2017/10/15/1508051698237_91.jpg",
            "http://p5.img.cctvpic.com/photoAlbum/page/performance/img/2017/10/15/1508051096457_594.jpg"







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
