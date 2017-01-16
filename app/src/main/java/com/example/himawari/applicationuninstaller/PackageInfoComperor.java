package com.example.himawari.applicationuninstaller;

import android.content.pm.PackageInfo;

import java.util.Comparator;

/**
 * Created by b1014100_2 on 2017/01/16.
 */

public class PackageInfoComperor implements Comparator<PackageInfo> {

//比較メソッド（データクラスを比較して-1, 0, 1を返すように記述する）
public int compare(PackageInfo a, PackageInfo b) {
        long no1 = a.firstInstallTime;
        long no2 = b.firstInstallTime;

        //こうすると社員番号の昇順でソートされる
        if (no1 < no2) {
        return 1;

        } else if (no1 == no2) {
        return 0;

        } else {
        return -1;

        }
        }
 }
