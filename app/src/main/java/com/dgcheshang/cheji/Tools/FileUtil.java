package com.dgcheshang.cheji.Tools;

import com.dgcheshang.cheji.netty.conf.NettyConf;

import java.io.File;

/**
 * Created by Administrator on 2018/8/31 0031.
 */

public class FileUtil {

    //判断文件是否存在
    public static boolean fileIsExists(String strFile)
    {
        try
        {
            File f=new File(strFile);
            if(!f.exists())
            {
                return false;
            }

        }
        catch (Exception e)
        {
            return false;
        }

        return true;
    }

    //文件长度
    public static long fileLength(String strFile)
    {
        try
        {
            File f=new File(strFile);
            if(!f.exists())
            {
                return 0;
            }else {
                return f.length();
            }

        }
        catch (Exception e)
        {
            return 0;
        }
    }

    /**
     * 判断文件夹和最新apk是否存在
     *
     * @param version*/
    public static boolean fileIsExists2(String version)
    {
        File f=new File(NettyConf.fileurl);
        if(!f.exists()){
            //不存在
            f.mkdirs();
            return false;
        }else {
            //文件夹存在
            File file = new File(NettyConf.fileurl + "/cheji" + version + ".apk");
            //判断最新版本apk是否存在
            if(!file.exists()){
                return false;
            }else {
                return true;
            }
        }
    }

    /**
     * 删除文件夹底下所有文件
     * */
    public static void deleteAllFiles(File root) {
        File files[] = root.listFiles();
        if (files != null)
            for (File f : files) {
                if (f.isDirectory()) { // 判断是否为文件夹
                    deleteAllFiles(f);
                    try {
                        f.delete();
                    } catch (Exception e) {
                    }
                } else {
                    if (f.exists()) { // 判断是否存在
                        deleteAllFiles(f);
                        try {
                            f.delete();
                        } catch (Exception e) {
                        }
                    }
                }
            }
    }
}
