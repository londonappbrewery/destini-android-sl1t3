package com.londonappbrewery.destini;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // TODO: Steps 4 & 8 - Declare member variables here:

    TextView mText;
    Button mButtonTop;
    Button mButtonBottom;
    int mIndex;

    String packageName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // TODO: Step 5 - Wire up the 3 views from the layout to the member variables:

        mText = findViewById(R.id.storyTextView);
        mButtonTop = findViewById(R.id.buttonTop);
        mButtonBottom = findViewById(R.id.buttonBottom);
        mIndex = 1;
        packageName = getPackageName();

        // TODO: Steps 6, 7, & 9 - Set a listener on the top button:

mButtonTop.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {

        String stringPressed = "T"+mIndex+"_Ans1";
        updateLayout(getNextID(stringPressed));

    }
});
        // TODO: Steps 6, 7, & 9 - Set a listener on the bottom button:
        mButtonBottom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String stringPressed = "T"+mIndex+"_Ans2";
                updateLayout(getNextID(stringPressed));

            }
        });

    }

public void updateLayout (int nextStringId){

        mText.setText(nextStringId);

        String currentStringName = getResources().getResourceName(nextStringId);

        if (currentStringName.contains("End")){

            mButtonTop.setVisibility(View.INVISIBLE);
            mButtonBottom.setVisibility(View.INVISIBLE);
        } else{

            int tempStringIndex = currentStringName.lastIndexOf("T");
            currentStringName = currentStringName.substring(tempStringIndex);

            mIndex = Integer.parseInt(Character.toString(currentStringName.charAt(1)));

        String topStringName = "T"+mIndex+"_Ans1";
        String bottomStringName = "T"+mIndex+"_Ans2";

        int topId = getResources().getIdentifier(topStringName,"string",packageName);
        int bottomId = getResources().getIdentifier(bottomStringName,"string",packageName);

        mButtonTop.setText(topId);
        mButtonBottom.setText(bottomId);

        }

}

public int getNextID (String currentStringName){

    String tempNextStringName = currentStringName+"_Next";
    int tempNextId = getResources().getIdentifier(tempNextStringName,"string",packageName);

    String nextStringName = getResources().getString(tempNextId);
    nextStringName = nextStringName.substring(nextStringName.lastIndexOf("T"));

    int nextStringId = getResources().getIdentifier(nextStringName,"string",packageName);

    return nextStringId;
}

}
