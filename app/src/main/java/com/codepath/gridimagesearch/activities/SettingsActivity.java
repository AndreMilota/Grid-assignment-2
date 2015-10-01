package com.codepath.gridimagesearch.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.ArrayRes;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;

import com.codepath.gridimagesearch.R;

public class SettingsActivity extends AppCompatActivity {

    //private Spinner spColor;

    private String picColor;
    private String picSize;
    private String picType;
    private String picSite;
    private Spinner spColor;
    private Spinner spSize;
    private Spinner spType;
    private EditText editSite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        picColor = getIntent().getStringExtra("color");
        picSize = getIntent().getStringExtra("size");;
        picType = getIntent().getStringExtra("type");;
        picSite = getIntent().getStringExtra("site");;

        spColor = (Spinner) findViewById(R.id.spnColor);
        spSize = (Spinner) findViewById(R.id.spnSize);
        spType = (Spinner) findViewById(R.id.spnTypes);
        editSite = (EditText)findViewById(R.id.edSite);

        //picColor = arrayTranslate(R.array.send_colors, R.array.display_colors, picColor);
        //picSize = arrayTranslate(R.array.send_sizes, R.array.display_sizes, picSize);
        //picType = arrayTranslate(R.array.send_types, R.array.display_types, picType);

        String[] colors = getResources().getStringArray(R.array.send_colors);
        int indexColor = findString(colors, picColor);

        String[] sizes = getResources().getStringArray(R.array.send_sizes);
        int indexSize = findString(sizes, picSize);

        String[] types = getResources().getStringArray(R.array.send_types);
        int indexType = findString(types, picType);

        spColor.setSelection(indexColor);
        spSize.setSelection(indexSize);
        spType.setSelection(indexType);

        editSite.setText(picSite);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_settings, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void onSave(View view) {
        Intent returnIntent = new Intent();

        picColor = spColor.getSelectedItem().toString();
        String[] displayColors = getResources().getStringArray(R.array.display_colors);
        int colorIndex = findString(displayColors, picColor);
        picColor = getResources().getStringArray(R.array.send_colors)[colorIndex];
        returnIntent.putExtra("color", picColor);

        picSize = spSize.getSelectedItem().toString();
        String[] displaySizes  = getResources().getStringArray(R.array.display_sizes);
        int sizeIndex = findString(displaySizes, picSize);
        picSize = getResources().getStringArray(R.array.send_sizes)[sizeIndex];
        returnIntent.putExtra("size", picSize);

        picType = spType.getSelectedItem().toString();
        String[] displayTypes  = getResources().getStringArray(R.array.display_types);
        int typeIndex = findString(displayTypes, picType);
        picType = getResources().getStringArray(R.array.send_types)[typeIndex];
        returnIntent.putExtra("type", picType);

        picSite = editSite.getText().toString();
        returnIntent.putExtra("site", picSite);
        
        setResult(RESULT_OK, returnIntent);
        finish();
    }

    private int findString(String[] src, String tar){
        for(int i = 0; i < src.length; i++){
            if(src[i].equals(tar))
            {
                return i;
            }
        }
        return 0;
    }

    private String arrayTranslate(@ArrayRes int arSrcArray, @ArrayRes int arDestArry, String key){

        String[] srcArray = getResources().getStringArray(arSrcArray);
        String[] destArry = getResources().getStringArray(arDestArry);
        int index;

        if(key == null || key.length() == 0){
            index = 0;
        }
        else{
            index = findString(srcArray, key);
        }

        return destArry[index];
    }


}
