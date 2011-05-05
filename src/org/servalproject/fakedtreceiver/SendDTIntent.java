package org.servalproject.fakedtreceiver;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class SendDTIntent extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        // Set up the listeners for the buttons
        ((Button)findViewById(R.id.DT1)).setOnClickListener(DT1Listener);
        ((Button)findViewById(R.id.DT2)).setOnClickListener(DT2Listener);
    }

    private OnClickListener DT1Listener = new OnClickListener() {
        public void onClick(View v) {
            sendDT("012345", "This is the first SMS for a test");
        }
    };

    private OnClickListener DT2Listener = new OnClickListener() {
        public void onClick(View v) {
            sendDT("543210", "This is the second SMS for a test");
        }
    };
    
    // Put a DT in an Intent object and start an Activity which can get it
    void sendDT(String senderNumber, String content) {	    	
	    Intent i = new Intent();
        // Set the action, and type
        i.setAction("android.intent.action.PICK");
        i.setType("vnd.servalproject.DTSMS/vnd.servalproject.DTSMS-text");
	    i.putExtra("number", senderNumber);
	    i.putExtra("content", content);
	    sendBroadcast(i);
	    // End this activity
        finish();
    }
}