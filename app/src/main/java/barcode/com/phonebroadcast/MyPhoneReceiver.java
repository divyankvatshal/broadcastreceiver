package barcode.com.phonebroadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by Divyank Vatshal on 14-06-2017.
 */

public class MyPhoneReceiver extends BroadcastReceiver {
    @Override

    public void onReceive(Context context, Intent intent) {
        Bundle bundle = intent.getExtras();

        if(null == bundle)
            return;

        String state = bundle.getString(TelephonyManager.EXTRA_STATE);

        if(state.equalsIgnoreCase(TelephonyManager.EXTRA_STATE_RINGING))
        {
            String phonenumber = bundle.getString(TelephonyManager.EXTRA_INCOMING_NUMBER);

            String info = "Divyank - Detect Calls \nIncoming number: " + phonenumber;

            Toast.makeText(context, info, Toast.LENGTH_LONG).show();

            Intent i = new Intent(context,MainActivity.class);
            i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(i);

        }
    }

}