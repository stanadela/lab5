package ro.pub.cs.systems.eim.lab05.startedservice.service;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

import ro.pub.cs.systems.eim.lab05.startedservice.general.Constants;

public class MyThread extends Thread {
    Context context;

    public MyThread(Context context) {
        this.context = context;
    }

    public void run() {
        Log.d(Constants.TAG, "Thread.run() was invoked, PID: " + android.os.Process.myPid() + " TID: " + android.os.Process.myTid());

        //1
        Intent intent = new Intent();
        intent.setAction(Constants.ACTION_STRING);
        intent.putExtra(Constants.DATA, Constants.STRING_DATA);
        context.sendBroadcast(intent);

        try {
            Thread.sleep(Constants.SLEEP_TIME);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //2
        intent = new Intent();
        intent.setAction(Constants.ACTION_ARRAY_LIST);
        intent.putExtra(Constants.DATA, Constants.ARRAY_LIST_DATA);
        context.sendBroadcast(intent);

        try {
            Thread.sleep(Constants.SLEEP_TIME);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //3
        intent = new Intent();
        intent.setAction(Constants.ACTION_INTEGER);
        intent.putExtra(Constants.DATA, Constants.INTEGER_DATA);
        context.sendBroadcast(intent);
    }
}
