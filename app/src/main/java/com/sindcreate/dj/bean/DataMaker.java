package com.sindcreate.dj.bean;

import com.sindcreate.dj.model.Entry;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Double on 2018/6/9.
 */

public class DataMaker {
static String[] img={
     "http://p1.img.cctvpic.com/fmspic/vms/image/2017/02/27/VSET_1488194042055568.jpg",
        "http://p3.img.cctvpic.com/fmspic/vms/image/2016/11/29/VSET_1480410149273998.jpg",
        "http://p1.img.cctvpic.com/fmspic/vms/image/2016/10/12/VSET_1476257056957917.jpg",
        "http://p4.img.cctvpic.com/fmspic/vms/image/2015/08/28/VSET_1440747811396619.jpg",
        "http://p5.img.cctvpic.com/fmspic/vms/image/2016/04/08/VSET_1460099834102788.jpg",
        "http://p5.img.cctvpic.com/fmspic/vms/image/2016/10/21/VSET_1477045441698927.JPG"

};
static String []str={
        "严肃换届纪律“九严禁”",
        "知行止、守纪律，做合格党员",
        "“两学一做”就在你身边",
        "从“四个全面”战略布局把握治国理政新思路",
        "二十一世纪中国梦的战略宏图和阶段目标",
        "《榜样》专题节目"



};
    public static List<Entry> MakeHomeData(){
        List<Entry> entries = new ArrayList<>();
        Entry entry;
        for(int i=0;i<6;i++){
            entry = new Entry();
            entry.imageUrl=img[i];
            entry.nr=str[i];



            entries.add(entry);
        }
        return entries;

    }
}
